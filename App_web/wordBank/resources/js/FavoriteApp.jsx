import React, { useState, useEffect } from 'react';
import axios from 'axios';

const Favorites = () => {
    const [favorites, setFavorites] = useState([]);
    // const [newWord, setNewWord] = useState('');

    useEffect(() => {
        const fetchData = async () => {
            const response = await axios.get('/api/favorites/2');
            setFavorites(response.data);
        };
        fetchData();
    }, []);

    // const handleAdd = async (event) => {
    //     event.preventDefault();
    //     try {
    //         await axios.post('/api/favorites/2', { word: newWord });
    //         const response = await axios.get('/api/favorites/2');
    //         setFavorites(response.data);
    //         setNewWord('');
    //     } catch (error) {
    //         console.error(error);
    //     }
    // };

    const handleRemove = async (word) => {
        try {
            await axios.delete('/api/favorites/2', { params: { word } });
            const response = await axios.get('/api/favorites/2');
            setFavorites(response.data);
        } catch (error) {
            console.error(error);
        }
    };

    return (
        <div className="text-custom-blue text-3xl pt-10 text-center">
            <h1>My Favorites</h1>
            {favorites.length > 0 ? (
                <ul>
                    {favorites.map((favorite) => (
                        <li key={favorite.id}>
                            {favorite.word}{' '}
                            <button onClick={() => handleRemove(favorite.word)}>Remove</button>
                        </li>
                    ))}
                </ul>
            ) : (
                <p>No favorites yet.</p>
            )}
            {/* <form onSubmit={handleAdd}>
                <input
                    type="text"
                    value={newWord}
                    onChange={(event) => setNewWord(event.target.value)}
                />
                <button type="submit">Add Favorite</button>
            </form> */}
        </div>
    );
};

export default Favorites;
