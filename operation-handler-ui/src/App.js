import React, { useEffect, useState } from "react";
import Operation from "./components/Operation";
import axios from "axios";

const App = () => {
  const [data, setData] = useState([]);
  const [amountInput, setAmount] = useState("");
  const [labelInput, setLabel] = useState("");
  useEffect(() => {
    axios
      .get("http://localhost:8081/operations")
      .then((res) => setData(res.data));
  }, []);

  const pushOp = () => {
    const op = {
      amount: amountInput,
      label: labelInput,
      executionDate: new Date(),
      withdrawal: true,
    };
    axios.post("http://localhost:8082/add-operation", op);
  };

  return (
    <div className="App flex flex-col">
      <div>
        <ul>
          {data.map((operation) => (
            <Operation key={operation.id} operation={operation} />
          ))}
        </ul>
      </div>
      <div className="py-8">
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
        <p>The new operation : {amountInput + " " + labelInput}</p>
      </div>
      <div>
        <button onClick={() => pushOp()}>Push</button>
      </div>
    </div>
  );
};

export default App;
