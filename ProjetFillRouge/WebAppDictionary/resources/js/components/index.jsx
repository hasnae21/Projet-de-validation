import React, { useEffect, useState } from "react";

//components
import Searchbar from "./DictionaryApp/Searchbar";
import Definition from "./Definition";

import { DictionaryContextProvider } from "../contexts/DictionaryContext";
import SynoAno from "./SynoAno";

const DictionaryApp = () => {
  return (
    <DictionaryContextProvider>
      <div className="class_dark_mode">
        <div
          className={`bg-slate-100 min-h-screen dark:bg-gray-800 serif`}
        >
          <div className="w-full md:w-2/3 xl:w-1/2 mx-auto px-5">
            <Searchbar />
            <Definition />
            <SynoAno />
          </div>
        </div>
      </div>
    </DictionaryContextProvider>
  );
};

export default DictionaryApp;
