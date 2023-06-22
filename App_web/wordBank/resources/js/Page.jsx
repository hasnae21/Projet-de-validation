import React from "react";
import DictionaryApp from "./components";
import Favorites from "./FavoriteApp";


const Page = () => {
  return (
    <div className="flex flex-row">
      <div className="w-1/5">
        <Favorites />
      </div>
      <div className="w-4/5">
        <DictionaryApp />
      </div>
    </div>
  );
};

export default Page;