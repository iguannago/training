import './App.css';
import { useState, useEffect, useReducer } from 'react';

function App({ firstname }) {
  const [emotion, setEmotion] = useState('happy');
  const [secondary, setSecondary] = useState('tired');
  const [checked, setChecked] = useReducer((checked) => !checked, false);

  useEffect(() => {
    console.log(`Emotion is: ${emotion}`);
    console.log(`Secondary emotion is: ${secondary}`);
    console.log(`Checked is: ${checked}`);
  }, [emotion, secondary, checked]);

  return (
    <div>
      <header>
        <h1>{firstname}</h1>
      </header>
      <main>
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
        <h2>Secondary emotion is: {secondary}</h2>
        <button
          onClick={() => {
            setSecondary((secondary) =>
              secondary === 'tired' ? 'happy' : 'tired'
            );
          }}
        >
          Change secondary emotion
        </button>
      </main>
    </div>
  );
}

export default App;
