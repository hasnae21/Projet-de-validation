import { createContext, useState } from "react";
import Header from "./Header";
import ResultList from "./ResultList";

export const InputContext = createContext();

const App = () => {
  const [inputValue, setInputValue] = useState("");

  const value = {
    inputValue, setInputValue
  }

  return (
    <InputContext.Provider value={value}>
      <div>
            <Header />
            <ResultList />
      </div>
    </InputContext.Provider>
  );
};

export default App;
