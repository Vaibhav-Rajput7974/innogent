import logo from './logo.svg';
import './App.css';
import { useSelector,useDispatch } from 'react-redux';
import {insNumber,decNumber} from './action/index'
function App() {
  const data=useSelector((state) => state.changeNumber);
  const dispath=useDispatch();
  return (
    <div className="App">
      <h2>{data}</h2>
      <button onClick={() =>
        dispath(insNumber())
      }>INCREMENT</button>
      <button onClick={() =>dispath(decNumber())}>DECREMENT</button>
    </div>
  );
}

export default App;
