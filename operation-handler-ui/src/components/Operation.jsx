import React from "react";

const Operation = ({ operation }) => {
  return (
    <li className="py-1">
      {operation.label}, {operation.amount}, {operation.creationDate}
    </li>
  );
};

export default Operation;
