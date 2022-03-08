import React, { useEffect, useState } from "react";
import Operation from "./components/Operation";
import axios from "axios";

const App = () => {
  const [data, setData] = useState([]);
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
      {/* <div class="flex flex-row">
        <div
          class="basis-1/4  md:basis-1/3 sm:basis-1/2"
          style={{ color: "red", backgroundColor: "green" }}>
          01
        </div>
        <div
          class="basis-1/4 hover:basis-1/2  md:basis-1/3 sm:basis-1/4"
          style={{ color: "green", backgroundColor: "red" }}>
          02
        </div>
        <div
          class="basis-1/2  md:basis-1/3 sm:basis-1/4"
          style={{ color: "red", backgroundColor: "yellow" }}>
          03
        </div>
      </div> */}
    </div>
  );
};

export default App;
