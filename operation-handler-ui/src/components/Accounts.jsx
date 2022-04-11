import React, { useEffect, useState } from "react";
import axios from "axios";

const Accounts = () => {
  const [data, setData] = useState([]);
  const [nameInput, setName] = useState("");
  const [opened, setOpened] = useState(false);

  let eventSource;

  useEffect(() => {
    axios
      .get("http://localhost:8081/accounts")
      .then((res) => setData(res.data));
  }, []);

  const pushAccount = () => {
    if (!opened) {
      eventSource = new EventSource("http://localhost:8081/account-sse3");
      let accountAdded = null;
      eventSource.addEventListener("TEST", (event) => {
        accountAdded = JSON.parse(event.data);
        console.log(`Account from server: ${accountAdded.owner}`);
        data.push(accountAdded);
        setData([...data]);
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
    const account = {
      owner: nameInput,
    };
    axios.post("http://localhost:8081/add-account", account);
  };

  return (
    <div className="App flex flex-row">
      <div>
        <h1 className="text-xl font-bold">Accounts</h1>
        <ul>
          {data.map((account) => (
            <li className=" py-1" key={account.id}>
              {account.id}, {account.balance}, {account.owner},
              {account.creationDate}
            </li>
          ))}
        </ul>
      </div>

      <div className="py-8 px-8 flex flex-row">
        <div>
          <input
            type="text"
            placeholder="Name"
            onChange={(e) => setName(e.target.value)}
          />

          <div className="py-8">
            <p>The new name: {nameInput}</p>
          </div>
        </div>
        <div className="pl-7">
          <button
            className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-1 px-4 rounded-full"
            onClick={() => pushAccount()}>
            Add
          </button>
        </div>
      </div>
    </div>
  );
};

export default Accounts;
