import './App.css';
import { useState } from 'react';

function AppMoreAboutMe() {
  const [userData, setUserData] = useState({});

  return (
      <div className='App'>
        <button
          onClick={() => {
            userData.name === undefined ? fetchUserData() : setUserData({});
          }}
        >
          More about me
        </button>
        {userData.name !== undefined && (
          <div>
            <h2>{userData.name}</h2>
            <p>Username: {userData.login}</p>
            <p>Location: {userData.location}</p>
            <p>Bio: {userData.bio}</p>
            <img src={userData.avatar_url} alt={userData.name} />
          </div>
        )}
      </div>
  );

  async function fetchUserData() {
    try {
      const response = await fetch('https://api.github.com/users/iguannago');
      const data = await response.json();
      console.log(data);
      setUserData(data);
    } catch (error) {
      console.log(error);
    }
  }
}

export default AppMoreAboutMe;
