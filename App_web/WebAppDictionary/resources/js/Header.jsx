import { useContext, useState } from "react";
import { InputContext } from "./App";

const Header = () => {
    const [value, setValue] = useState("");
    const { inputValue, setInputValue } = useContext(InputContext);

    const handleInputChange = e => setValue(e.target.value);

    const handleSubmit = () => {
        setInputValue(value);
        setValue("");
    }

    const handleInputKeyDown = (e) => {
        if (e.key === 'Enter') {
            setInputValue(value);
            setValue("")
        }
    }

    return (
        <div className="mt-5">
            <input
                className="px-5 py-3 pr-12 text-base md:w-80 rounded-lg rounded-full  border-none bg-white ps-4 text-lg shadow-lg block w-full"
                id="search"
                type="search"
                placeholder="Chercher un mot d'ici..."
                onChange={handleInputChange}
                value={value}
                onKeyDown={handleInputKeyDown}
            />
            <button onClick={handleSubmit}></button>
            {inputValue && (
                <h1 className="px-4 text-black-50 mt-4">
                    <span className="font-bold">{inputValue}</span>
                </h1>
            )}
        </div>
    );
};

export default Header;
