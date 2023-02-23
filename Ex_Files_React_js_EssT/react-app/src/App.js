import './App.css';
import { useState, useEffect } from 'react';

function App({ firstname }) {
  const [emotion, setEmotion] = useState('happy');
  const [secondary, setSecondary] = useState('tired');

  useEffect(() => {
    console.log(`It's ${emotion} right now`);
  }, [emotion]);

  useEffect(() => {
    console.log(`It's ${secondary} around here`);
  }, [secondary]);

  return (
    <div className='App'>
      <h1>Hello {firstname}</h1>
      <h2>Your emotion is: {emotion}</h2>
      <button
        onClick={() => {
          if (emotion === 'happy') setEmotion('sad');
          else setEmotion('happy');
        }}
      >
        Change emotion
      </button>
      <h2>Current secondary emotion is: {secondary}</h2>
      <button
        onClick={() => {
          if (secondary === 'tired') setSecondary('grateful');
          else setSecondary('tired');
        }}
      >
        Change secondary emotion
      </button>
    </div>
  );
}

export default App;
