import React, { useEffect, useState } from "react";

// Logo
import Logo from "../../assets/biblio.svg";
//search icon
import BsSearch from "../../assets/search-svgrepo-com.svg";

//context
import useDictionaryContext from "../../hooks/useDictionaryContext";


const Searchbar = () => {
  const { setWord } = useDictionaryContext();
  const [inputValue, setInputValue] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    if (inputValue.trim() == "") return;
    setWord(inputValue);
    setInputValue("");
  };

  const [theme, setTheme] = useState("");

  useEffect(() => {
    if (window.matchMedia("(prefers-color-scheme: dark)").matches) {
      setTheme("dark");
    } else {
      setTheme("light");
    }
  }, []);

  useEffect(() => {
    if (theme === "dark") {
      document.querySelector(".class_dark_mode").classList.add("dark");
    } else {
      document.querySelector(".class_dark_mode").classList.remove("dark");
    }
  }, [theme]);

  const handleThemeSwitch = () => {
    setTheme(theme === "dark" ? "light" : "dark");
  };


  return (
    <div className="flex items-center justify-between pt-10 sm:pt-12">
      <div className="flex space-x-4">
        <button onClick={handleThemeSwitch}>
          {theme == "dark" ? (
            <img src={Logo} alt="Logo" width={60} />
          ) : (
            <img src={Logo} alt="Logo" width={60} />
          )}
        </button>
      </div>
      <form
        onSubmit={handleSubmit}
        className="flex items-center justify-between py-2 px-3 rounded-lg mx-2 my-3 bg-gray-200 sm:bg-white p-4"
      >
        <input
          type="text"
          placeholder=""
          className="bg-transparent text-black text-sm font-medium focus:outline-none w-full dark:text-custom-white"
          value={inputValue}
          onChange={(e) => setInputValue(e.target.value)}
        />
        <button type="submit" className="py-1 px-1 dark:text-custom-white">
          <img
            src={BsSearch}
            className="cursor-pointer p-2"
            width={50}
          />
        </button>
      </form>
    </div>
  );
};

export default Searchbar;
