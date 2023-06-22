import axios from "axios";
import { useContext, useEffect, useState } from "react";
import { InputContext } from "../app";
import Antonym from "./DictionaryApp/Antonym";
import Synonym from "./DictionaryApp/Synonym";

axios.defaults.baseURL = 'https://api.dictionaryapi.dev/api/v2/entries/en';

const SynoAno = () => {
    const { inputValue } = useContext(InputContext);
    const [response, setResponse] = useState("");
    const [error, setError] = useState("");
    const [loading, setLoading] = useState(false);
    const [meanings, setMeanings] = useState("");
    


    const fetchData = async (param) => {
        try {
            setLoading(true);
            const res = await axios(`/${param}`);
            setResponse(res.data);
            setMeanings(res.data[0].meanings);
            // console.log(res.data[0].meanings )
            setError(null);
        } catch (err) {
            setError(err);
        } finally {
            setLoading(false)
        }
    }

    useEffect(() => {
        if (inputValue.length) {
            fetchData(inputValue)
        }
    }, [inputValue]);


    return (
        <div className="container mx-auto p-4 max-w-2xl">
            {response && (
                <div>
                    <h3 className="text-2xl font-bold mt-4">Synonymes:</h3>
                    <Synonym mean={response} />
                    <h3 className="text-2xl font-bold mt-4">Antonymes:</h3>
                    <Antonym mean={response} />
                    <h6>  ___________________________________ </h6>
                </div>
            )}
        </div>
    );
};

export default SynoAno;
