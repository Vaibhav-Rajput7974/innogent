import logo from './logo.svg';
import './App.css';
import store from './store';
import { useSelector,useDispatch } from 'react-redux';
import { addData, showData } from './action';
function App() {
  const data=useSelector((state) => state.crudOperation);
  const dispath=useDispatch();
 
  
  return (
    <div>
      <input type="text" id="t1"></input>
      <button onClick={ ()=>dispath(addData(document.getElementById('t1').value) )}>addData</button>
    <button onClick={ ()=>dispath(showData())}> GETDATA</button>
    <h2>{data}</h2>
    </div>
  );
}

export default App;
