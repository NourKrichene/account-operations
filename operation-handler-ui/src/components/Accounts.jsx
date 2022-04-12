import React from "react";

const Accounts = ({ accounts }) => {
  return (
    <div className="App flex flex-row">
      <div>
        <h1 className="text-xl font-bold">Accounts</h1>
        <ul>
          {accounts.map((account) => (
            <li className=" py-1" key={account.id}>
              {account.id}, {account.balance}, {account.owner},
              {account.creationDate}
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
};

export default Accounts;
