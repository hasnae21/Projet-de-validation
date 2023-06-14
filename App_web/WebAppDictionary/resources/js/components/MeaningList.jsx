const MeanigList = ({ mean }) => {

  return (
    <div>
      {mean.map((val, index) => (
        <div><h4 key={index}>{val.partOfSpeech}</h4><hr /><div>
          {val.definitions.map((vals, index1) => (
            <div key={index1}><p>- {vals.definition}</p></div>
          ))}
          {/* {val.synonyms.map((syn, index2) => (
            <div key={index2}><li>{syn.synonyms}</li></div>
          ))}
          {val.antonyms.map((ant, index3) => (
            <div key={index3}><li>{ant.antonyms}</li></div>
          ))} */}
        </div>
        </div>
      ))}
    </div>

  );
};

export default MeanigList;