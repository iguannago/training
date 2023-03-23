import './App.css';
import { useRef, useState } from 'react';

function AppForm() {
  const colorTitle = useRef();
  const hexColor = useRef();
  const [userData, setUserData] = useState({});

  const submit = (e) => {
    e.preventDefault();
    const title = colorTitle.current.value;
    const color = hexColor.current.value;
    alert(title + ' ' + color);
    colorTitle.current.value = '';
    hexColor.current.value = '';
    console.log(title, color);
  };
  return (
    <div className='App'>
      <h1>Color Organizer</h1>
      <form onSubmit={submit}>
        <input ref={colorTitle} type='text' placeholder='color title...' />
        <input ref={hexColor} type='color' />
        <button>ADD</button>
      </form>
      <div>
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

export default AppForm;
