const Antonym = ({ mean }) => {
    return (
        <div>
            {mean.map(val =>
                val.meanings.map(means =>{
                        return means.antonyms?.map(ant => (
                            <li>{ant}</li>
                        ))
                    }))}
        </div>
    );
};

export default Antonym;
