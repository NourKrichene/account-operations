import React from "react";
import Operations from "./components/Operations";
import Accounts from "./components/Accounts";

const App = () => {
  return (
    <div className="App flex flex-col">
      <Operations />
      <Accounts />
    </div>
  );
};

export default App;
