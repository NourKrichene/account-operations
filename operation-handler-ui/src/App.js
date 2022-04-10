import React from "react";
import Operations from "./components/Operations";
import Accounts from "./components/Accounts";
import Progress from "./components/Progress";

const App = () => {
  return (
    <div className="App flex flex-col">
      <Operations />
      <Accounts />
      <Progress />
    </div>
  );
};

export default App;
