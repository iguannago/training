import './App.css';
import { useState } from 'react';

function App({ firstname }) {
  const [emotion, setEmotion] = useState('happy');

  return (
    <div className='App'>
      <h1>Hello {firstname}</h1>
      <h2>Your emotion is:</h2>
      <h1>{emotion}</h1>
      <button
        onClick={() => {
          if (emotion === 'happy') setEmotion('sad');
          else setEmotion('happy');
        }}
      >
        change emotion
      </button>
    </div>
  );
}

export default App;
