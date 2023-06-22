import React, { useEffect, useState } from "react";

//components
import Searchbar from "./DictionaryApp/Searchbar";
import Definition from "./Definition";

import { DictionaryContextProvider } from "../contexts/DictionaryContext";

const DictionaryApp = () => {
  return (
    <DictionaryContextProvider>
      <div className="class_dark_mode">
        <div
          className={`bg-slate-100 dark:bg-gray-800 serif`}
        >
          <div className="w-full md:w-1/6 xl:w-5/6 mx-auto px-5">
            <Searchbar />
            <Definition />
          </div>
        </div>
      </div>
    </DictionaryContextProvider>
  );
};

export default DictionaryApp;
