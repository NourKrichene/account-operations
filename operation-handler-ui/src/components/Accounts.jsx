import React, { useEffect, useState } from "react";
import axios from "axios";

const Accounts = () => {
  const [data, setData] = useState([]);

  useEffect(() => {
    axios
      .get("http://localhost:8081/accounts")
      .then((res) => setData(res.data));
  }, []);

  return (
    <div>
      <ul>
        {data.map((account) => (
          <li className="text-xl font-bold py-1">
            {account.id}, {account.balance}, {account.owner},{" "}
            {account.creationDate}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Accounts;
