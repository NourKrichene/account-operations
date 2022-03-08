import React from "react";

const Operation = ({ operation }) => {
  return (
    <li>
      {operation.label}, {operation.amount}, {operation.executionDate}
    </li>
  );
};

export default Operation;
