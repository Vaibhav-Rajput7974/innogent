import './App.css';
import UPdate from './UPdate';
import { addData, deleteData, updataData } from './slice/CrudeSlice';
import { useSelector,useDispatch } from 'react-redux';
function App() {
  const {employee}=useSelector((state) => state.crud);
  console.log(employee);
  const dispath=useDispatch();
  function saveData(num1, num2, num3){
    const employee={
      id:num1,
      FirsttName:num2,
      LastName:num3
    }
    dispath(addData(employee)); 
  }
  function updateHandeler(val){
    console.log(val);
    dispath(updataData(val));
  }
  function delethandler(val){
    console.log(val);
    dispath(deleteData(val));
  }
 // console.log(data);

  return (

    <div> 
      <div>
    <label>id</label>
  <input type="text" id="t1"></input>
  <label>name</label>
  <input type="text" id="t2"></input>
  <label>phonr Number</label>
  <input type="text" id="t3"></input>
 <button onClick={() => {saveData(document.getElementById('t1').value,document.getElementById('t2').value,document.getElementById('t3').value)}}>save</button>
</div>

    {/* <button onClick={() => {addDataFun(document.getElementById('t1').value,document.getElementById('t2').value,document.getElementById('t3').value)}}>addData</button>
    <button onClick={ ()=>dispath(showData())}> GETDATA</button>
     */}
    
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
    {employee.map((data) => (
        <>
        <tr>
        <td>
          {data.id}
          </td>
          <td>{data.FirsttName}</td>
          <td>{data.LastName}</td>
          <td><button  onClick={()=>updateHandeler(data.id)}> UPDATA</button></td>
          <td><button  onClick={()=>delethandler(data.id)}>Delete</button></td>
          </tr>
          </>
      ))}
    </tbody>
    </table>
    <UPdate></UPdate>
    </div>
	

  );
}

export default App;
