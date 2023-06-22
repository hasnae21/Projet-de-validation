import React, { useState, useEffect } from 'react';
import axios from 'axios';

const Favorites = () => {
    const [favorites, setFavorites] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            const response = await axios.get('/api/favorites/2');
            setFavorites(response.data);
            // console.log(response);
        };
        fetchData();
    }, []);

    return (
        <div>
            <h1>My Favorites</h1>
            {favorites.length > 0 ? (
                <ul>
                    {favorites.map((favorite) => (
                        <li key={favorite.id}>
                            {favorite.word}
                        </li>
                    ))}
                </ul>
            ) : (
                <p>No favorites yet.</p>
            )}
        </div>
    );
};

export default Favorites;