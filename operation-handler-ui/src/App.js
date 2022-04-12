import Operations from "./components/Operations";
import Accounts from "./components/Accounts";
import React, { useEffect, useState } from "react";

import axios from "axios";

const App = () => {
  const [operations, setOperations] = useState([]);
  const [accounts, setAccounts] = useState([]);

  const [amountInput, setAmount] = useState("");
  const [labelInput, setLabel] = useState("");
  const [accountReceiverInput, setAccountReceiver] = useState("");
  const [accountsenderInput, setAccountSender] = useState("");

  const [opened, setOpened] = useState(false);

  useEffect(() => {
    axios
      .get("http://localhost:8081/operations")
      .then((res) => setOperations(res.data));
  }, []);
  let eventSource;
  const pushOp = () => {
    if (!opened) {
      eventSource = new EventSource("http://localhost:8081/operation-sse");
      let notification = null;
      eventSource.addEventListener("operations", (event) => {
        notification = JSON.parse(event.data);
        operations.push(notification.operation);
        if (notification.sender != null) {
          var senderToUpdate = accounts.filter((obj) => {
            return obj.id === notification.sender.id;
          });
          accounts[accounts.indexOf(senderToUpdate[0])] = notification.sender;
          setAccounts([...accounts]);
        }
        if (notification.receiver != null) {
          var resceiverToUpdate = accounts.filter((obj) => {
            return obj.id === notification.receiver.id;
          });
          accounts[accounts.indexOf(resceiverToUpdate[0])] =
            notification.receiver;
          setAccounts([...accounts]);
        }
      });
      setOpened(true);
      eventSource.onerror = (event) => {
        if (event.target.readyState === EventSource.CLOSED) {
          console.log("SSE closed (" + event.target.readyState + ")");
        }
        eventSource.close();
      };

      eventSource.onopen = () => {
        console.log("connection opened");
      };
    }

    const op = {
      amount: amountInput,
      label: labelInput,
      accountReceiver: accountReceiverInput,
      accountSender: accountsenderInput,
    };
    axios.post("http://localhost:8082/add-operation", op);
    setAmount("");
    setLabel("");
    setAccountSender("");
    setAccountReceiver("");
  };

  useEffect(() => {
    axios
      .get("http://localhost:8081/accounts")
      .then((res) => setAccounts(res.data));
  }, []);

  return (
    <div className="App flex flex-col">
      <h1 className="text-xl font-bold">Operations</h1>
      <div className=" flex flex-row">
        <div className="basis-4/12">
          <Operations key={1} operations={operations} />
        </div>
        <div className="basis-6/12">
          <div>
            <input
              type="text"
              placeholder="Amount"
              onChange={(e) => setAmount(e.target.value)}
            />
            <input
              type="text"
              placeholder="Label"
              onChange={(e) => setLabel(e.target.value)}
            />
            <input
              type="text"
              placeholder="sender id"
              onChange={(e) => setAccountSender(e.target.value)}
            />
            <input
              type="text"
              placeholder="receiver id"
              onChange={(e) => setAccountReceiver(e.target.value)}
            />
            <div className="pt-8 pb-20">
              <p>
                The new operation:
                {amountInput +
                  " " +
                  labelInput +
                  " " +
                  accountReceiverInput +
                  " " +
                  accountsenderInput}
              </p>
            </div>
          </div>
        </div>
        <div className="basis-2/12">
          <button
            className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-1 px-4 rounded-full"
            onClick={() => pushOp()}>
            Add
          </button>
        </div>
      </div>
      <h1 className="text-xl font-bold">Accounts</h1>
      <div className=" flex flex-row">
        <Accounts key={2} accounts={accounts} />
      </div>
    </div>
  );
};

export default App;
