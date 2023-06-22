import React from "react";
import axios from 'axios';


//play button
import playIcon from "../../assets/volume-on-svgrepo-com.svg";
import saveIcon from "../../assets/bookmark-svgrepo-com (1).svg";
// import saveIcon1 from "../../assets/bookmark-alt-svgrepo-com.svg";


const Word = ({ word, phonetic, audio }) => {


  const playAudio = (e) => {
    const audio = new Audio();
    audio.src = e.target.getAttribute(`url`);
    audio.play();
  };

  // const handleIconSwitch = () => {
  // };

  // const handleAdd = async (event) => {
  //   event.preventDefault();
  //   try {
  //     await axios.post('/api/favorites/2', { word: {word} });
  //     const response = await axios.get('/api/favorites/2');
  //     setFavorites(response.data);
  //   } catch (error) {
  //     console.error(error);
  //   }
  // };

  // const handleAdd = async (event) => {
  //   event.preventDefault();
  //   try {
  //     const response = await axios.post('/api/favorites/2', { word });
  //     console.log(response.data); // log the response data to the console
  //   } catch (error) {
  //     console.error(error);
  //   }
  // };

  // const handleAdd = async (event) => {
  //   event.preventDefault();
  //   try {
  //     const response = await axios.post('/api/favorites/2', { word });
  //     console.log(response.data); // log the response data to the console
  //   } catch (error) {
  //     if (error.response) {
  //       // The request was made and the server responded with a status code
  //       // that falls out of the range of 2xx
  //       console.error(error.response.data);
  //       console.error(error.response.status);
  //       console.error(error.response.headers);

  //     } else if (error.request) {
  //       // The request was made but no response was received
  //       // `error.request` is an instance of XMLHttpRequest in the browser and an instance of
  //       // http.ClientRequest in node.js
  //       console.error(error.request);
  //     } else {
  //       // Something happened in setting up the request that triggered an Error
  //       console.error('Error', error.message);
  //     }
  //   }
  // };

  const getUserId = () => {
    axios.get('/api/user', {
      withCredentials: true,
    }).then(response => {

      return userId = response.data;

    }).catch(error => {
      console.error(error);
    });
  }


  const handleAdd = async (event) => {
    event.preventDefault();
    try {
      const userId = getUserId(); // replace this with your own function to get the user ID
      const response = await axios.post(`/api/favorites/${userId}`, { word });
      console.log(response.data); // log the response data to the console
    } catch (error) {
      console.error(error);
    }
  };

  
  return (
    <div className="flex justify-between items-center pt-12">
      <div>
        <div className="flex justify-between items-center">
          {audio && (
            <img
              src={playIcon}
              alt="play-icon"
              url={audio}
              onClick={playAudio}
              className="cursor-pointer p-2"
              width={40}
            />
          )}
          <h1 className="text-4xl p-2">{word}</h1>
          <p className="text-blue-600 text-md p-2">
            {phonetic}</p>
        </div>
      </div>
      <div>

        {/* <button onClick={handleIconSwitch}> */}
        {/* <img
              src={saveIcon}
              className="cursor-pointer p-2"
              width={60}
            /> */}
        {/* <img
              src={saveIcon1}
              className="cursor-pointer p-2"
              width={62}
            /> */}
        {/* </button> */}

        {/* <input
          type="hidden"
          value={word}
        /> */}

        <form onSubmit={handleAdd}>
          <button type="submit">
            <img
              src={saveIcon}
              className="cursor-pointer p-2"
              width={60}
            />
          </button>
        </form>

      </div>
    </div>
  );
};

export default Word;
