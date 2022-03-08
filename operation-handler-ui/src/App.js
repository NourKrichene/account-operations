import React, { useEffect, useState } from "react";
import Operation from "./components/Operation";
import axios from "axios";

const App = () => {
  const [data, setData] = useState([]);
  const [searchInput, setSearchInput] = useState("");
  useEffect(() => {
    axios
      .get("http://localhost:8081/operations")
      .then((res) => setData(res.data));
  }, []);

  return (
    <div className="App">
      <ul>
        {data.map((operation) => (
          <Operation key={operation.id} operation={operation} />
        ))}
      </ul>

      <input
        type="text"
        placeholder="Add amount"
        onChange={(e) => setSearchInput(e.target.value)}
      />
      <p>The new operation : {searchInput}</p>
    </div>
  );
};

export default App;
