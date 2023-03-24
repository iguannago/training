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
    <div>
      <main>
        <h2>Color Organizer</h2>
        <form onSubmit={submit}>
          <input ref={colorTitle} type='text' placeholder='color title...' />
          <input ref={hexColor} type='color' />
          <button>ADD</button>
        </form>
      </main>
    </div>
  );
}

export default AppFormWithUseRef;
