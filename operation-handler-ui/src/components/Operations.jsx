import Operation from "./Operation";

const Operations = ({ operations }) => {
  return (
    <div className=" flex flex-row">
      <div className="pb-8 ">
        <h1 className="text-xl font-bold">Operations</h1>
        <ul>
          {operations.map((operation) => (
            <Operation key={operation.id} operation={operation} />
          ))}
        </ul>
      </div>
    </div>
  );
};

export default Operations;
