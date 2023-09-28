import './App.css';
import store from './store';
import { useSelector,useDispatch } from 'react-redux';
import { addData, showData } from './action';
function App() {
  const data=useSelector((state) => state.crudSet.employee);
  const dispath=useDispatch();
  function addDataFun(num1, num2, num3){
    const employee={
      id:num1,
      FirsttName:num2,
      LastName:num3
    }
   dispath(addData(employee)); 
  }
 // console.log(data);
  
  return (
    <>
    <div>
      <input type="text" id="t1"></input>
      <input type="text" id="t2"></input>
      <input type="text" id="t3"></input>
      
    <button onClick={() => {addDataFun(document.getElementById('t1').value,document.getElementById('t2').value,document.getElementById('t3').value)}}>addData</button>
    <button onClick={ ()=>dispath(showData())}> GETDATA</button>
    
    
    <table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">First</th>
      <th scope="col">Last</th>
      <th scope="col">Handle</th>
    </tr>
  </thead>
  <tbody>
    {data.map((data) => (
        <>
        <tr>
        <td>
          {data.id}
          </td>
          <td>{data.FirsttName}</td>
          <td>{data.LastName}</td>
          <td><button> UPDATA</button></td>
          <td><button>Delete</button></td>
          
          </tr>
          </>
      ))}
    </tbody>
    </table>
      
    </div>
    </>
  );
}

export default App;
