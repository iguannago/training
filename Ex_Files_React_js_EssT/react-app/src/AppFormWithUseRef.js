import './App.css';
import { useRef } from 'react';

function AppFormWithUseRef() {
  const colorTitle = useRef();
  const hexColor = useRef();

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
    </div>
  );
}

export default AppFormWithUseRef;
