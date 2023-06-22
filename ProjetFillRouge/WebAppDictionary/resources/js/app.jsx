import { createContext, useState } from "react";

import DictionaryApp from "./components";
import Favorites from "./FavoriteApp";

export const InputContext = createContext();

const App = () => {
  const [inputValue, setInputValue] = useState("");

  const value = {
    inputValue, setInputValue
  }

  return (
    <InputContext.Provider value={value}>
      <div className="flex flex-row">
        <div className="w-5/6">
          <DictionaryApp />
        </div>
        <div className="w-1/6">
          <Favorites />
        </div>
      </div>
    </InputContext.Provider>
  );
};

export default App;