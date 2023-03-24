import './App.css';
import { useState } from 'react';

function AppFormWithUseState() {
  const [color, setColor] = useState('#000000');
  const [title, setTitle] = useState('');

  const submit = (e) => {
    e.preventDefault();
    alert(title + ' ' + color);
    console.log(title, color);
    setColor('#000000');
    setTitle('');
  };
  return (
    <div>
      <main>
        <h2>Color Organizer</h2>
        <form onSubmit={submit}>
          <input
            onChange={(event) => setTitle(event.target.value)}
            value={title}
            type='text'
            placeholder='color title...'
          />
          <input
            onChange={(event) => setColor(event.target.value)}
            value={color}
            type='color'
          />
          <button>ADD</button>
        </form>
      </main>
    </div>
  );
}

export default AppFormWithUseState;
