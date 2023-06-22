const Synonym = ({ mean }) => {
    return (
        <div>
            {mean.map(val =>
                val.meanings.map(means => {
                    return means.synonyms?.map(syn => (
                        <li>{syn}</li>
                    ))
                }))}
        </div>
    );
};

export default Synonym;
