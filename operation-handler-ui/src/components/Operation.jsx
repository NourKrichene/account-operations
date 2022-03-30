import React from "react";

const Operation = ({ operation }) => {
  return (
    <li className="text-xl font-bold">
      {operation.label}, {operation.amount}, {operation.creationDate}
    </li>
  );
};

export default Operation;
