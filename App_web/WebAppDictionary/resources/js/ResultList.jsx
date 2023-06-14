import axios from "axios";
import { useContext, useEffect, useState } from "react";
import { InputContext } from "./App";
import Antonym from "./components/Antonym";
import Example from "./components/Example";
import MeaningList from "./components/MeaningList";
import Synonym from "./components/Synonym";
import Phonetics from "./components/Phonetics";

axios.defaults.baseURL = 'https://api.dictionaryapi.dev/api/v2/entries/en';

const ResultList = () => {
    const { inputValue } = useContext(InputContext);
    const [response, setResponse] = useState("");
    const [error, setError] = useState("");
    const [loading, setLoading] = useState(false);

    const fetchData = async (param) => {
        try {
            setLoading(true);
            const res = await axios(`/${param}`);
            setResponse(res.data);
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

    if (loading) {
        return (
            <div className="flex flex-col space-y-3 animate-pulse p-4 container mx-auto max-w-2xl">
                <div className="h-40 bg-gray-300 mt-5 rounded-md"></div>
                <div className="h-40 bg-gray-300 mt-5 rounded-md"></div>
                <div className="h-40 bg-gray-300 mt-5 rounded-md"></div>
                <div className="h-40 bg-gray-300 mt-5 rounded-md"></div>
                <div className="h-40 bg-gray-300 mt-5 rounded-md"></div>
            </div>
        )
    }

    if (error) {
        return <h3 className="text-center mt-10 font-semibold text-gray-500">Pas de definitions pour ce mot </h3>
    }

    return (
        <div className="container mx-auto p-4 max-w-2xl">
            {response && (
                <div>
                    <h3 className="text-2xl font-bold mt-4">Phonetic:</h3>
                    <Phonetics mean={response} />
                    <h3 className="text-2xl font-bold mt-4">Definitions:</h3>
                    <MeaningList mean={response} />
                    <h3 className="text-2xl font-bold mt-4">Examples:</h3>
                    <Example mean={response} />
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

export default ResultList;
