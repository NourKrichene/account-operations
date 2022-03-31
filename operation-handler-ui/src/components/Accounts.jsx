import React, { useEffect, useState } from "react";
import axios from "axios";

const Accounts = () => {
  const [data, setData] = useState([]);
  const [nameInput, setName] = useState("");

  useEffect(() => {
    axios
      .get("http://localhost:8081/accounts")
      .then((res) => setData(res.data));
  }, []);

  const pushAccount = () => {
    const account = {
      owner: nameInput,
    };
    axios.post("http://localhost:8081/add-account", account);
  };

  return (
    <div className="App flex flex-row">
      <div>
        <ul>
          {data.map((account) => (
            <li className="text-xl font-bold py-1">
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
        <div>
          <button
            className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-1 px-4 rounded-full"
            onClick={() => pushAccount()}>
            Push
          </button>
        </div>
      </div>
    </div>
  );
};

export default Accounts;
