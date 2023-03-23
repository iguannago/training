import './App.css';
import { useState, useEffect, useReducer } from 'react';

function App({ firstname }) {
  const [emotion, setEmotion] = useState('happy');
  const [secondary, setSecondary] = useState('tired');
  const [checked, setChecked] = useReducer((checked) => !checked, false);

  useEffect(() => {
    console.log(`It's ${emotion} right now`);
    console.log(`It's ${secondary} right now`);
    console.log(`It's ${checked} right now`);
  }, [emotion, secondary, checked]);

  return (
    <div className='App'>
      <h1>Hello {firstname}</h1>
      <input type='checkbox' value={checked} onChange={setChecked} />
      <label>{checked ? 'checked' : 'not checked'}</label>
      <h2>Your emotion is: {emotion}</h2>
      <button
        onClick={() => {
          setEmotion((emotion) => (emotion === 'happy' ? 'sad' : 'happy'));
        }}
      >
        Change emotion
      </button>
      <h2>Current secondary emotion is: {secondary}</h2>
      <button
        onClick={() => {
          setSecondary((secondary) =>
            secondary === 'tired' ? 'happy' : 'tired'
          );
        }}
      >
        Change secondary emotion
      </button>
    </div>
  );
}

export default App;
