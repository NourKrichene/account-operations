import React, { useState } from "react";

const Progress = () => {
  const [progressPercentage, setProgressPercentage] = useState(0);
  const [started, setStarted] = useState(false);

  const handleSubmit = () => {
    const eventSource = new EventSource("http://localhost:8081/progress-sse");
    setStarted(true);
    let progressValue = null;
    eventSource.addEventListener("PROGRESS", (event) => {
      progressValue = JSON.parse(event.data);
      console.log(`Progress from server: ${progressValue}`);
      setProgressPercentage(progressValue);
      if (progressValue === 100) {
        eventSource.close();
        setStarted(false);
      }
    });

    eventSource.onerror = (event) => {
      if (event.target.readyState === EventSource.CLOSED) {
        console.log("SSE closed (" + event.target.readyState + ")");
      }
      setProgressPercentage(0);
      eventSource.close();
    };

    eventSource.onopen = () => {
      console.log("connection opened");
    };
  };

  return (
    <div className="App flex flex-row">
      <div>
        <h1 className="text-xl font-bold">Progress</h1>
        <button
          className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-1 px-4 rounded-full"
          onClick={handleSubmit}
          disabled={started}>
          Start
        </button>
        <p> pourcentage :{progressPercentage}</p>
      </div>
    </div>
  );
};

export default Progress;
