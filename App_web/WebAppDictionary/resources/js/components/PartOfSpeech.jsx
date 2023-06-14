const PartOfSpeech = ({ mean }) => {
    return (
        <div>
            {mean.map(val =>
                val.meanings.map(means => {
                    <h3 className="font-bold"> {means.partOfSpeech} <br /></h3>
                }))}
        </div>
    );
};

export default PartOfSpeech;
