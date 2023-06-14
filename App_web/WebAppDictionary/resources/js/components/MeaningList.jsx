// const MeaningList = ({ mean }) => {
//     return (
//         <div>
//             {mean.map(val => (
//                 <div key={val.partOfSpeech}>
//                     <h3 key={val.partOfSpeech}>{val.partOfSpeech}</h3>
//                     {val.definitions?.map(def => (
//                         <div key={def.definition}>
//                             <li key={def.definition} >{def.definition}</li>
//                             <hr />
//                         </div>
//                     ))}
//                 </div>
//             ))}
//         </div>
//     );
// };

// export default MeaningList;


const MeanigList = ({ mean }) => {
    return (
      <div>
        {mean.map(val => val.meanings.map(means => means.definitions.map(def => (
          <div key={def.definition}>
            <li>{def.definition}</li>
            <hr />
          </div>
        ))))}
      </div>
    );
  };
  
  export default MeanigList;