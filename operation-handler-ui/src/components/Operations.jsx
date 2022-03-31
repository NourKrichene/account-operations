import React, { useEffect, useState } from "react";
import Operation from "./Operation";
import axios from "axios";

const Operations = () => {
  const [data, setData] = useState([]);
  const [amountInput, setAmount] = useState("");
  const [labelInput, setLabel] = useState("");
  const [accountReceiverInput, setAccountReceiver] = useState("");
  const [accountsenderInput, setAccountSender] = useState("");

  useEffect(() => {
    axios
      .get("http://localhost:8081/operations")
      .then((res) => setData(res.data));
  }, []);

  const pushOp = () => {
    const op = {
      amount: amountInput,
      label: labelInput,
      accountReceiver: accountReceiverInput,
      accountSender: accountsenderInput,
    };
    axios.post("http://localhost:8082/add-operation", op);
  };

  return (
    <div className="App flex flex-row">
      <div className="pb-8 ">
        <h1 className="text-xl font-bold">Operations</h1>
        <ul>
          {data.map((operation) => (
            <Operation key={operation.id} operation={operation} />
          ))}
        </ul>
      </div>
      <div className="py-8 px-8 flex flex-row">
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
        <div className="pl-7">
          <button
            className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-1 px-4 rounded-full"
            onClick={() => pushOp()}>
            Add
          </button>
        </div>
      </div>
    </div>
  );
};

export default Operations;
