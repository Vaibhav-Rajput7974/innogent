const INITIAL_STATE = {
    employee: [
      { id: '0', FirsttName: 'Vaibhav', LastName: 'Rajput' },
      { id: '1', FirsttName: 'Himanshu', LastName: 'Rathore' },
      { id: '2', FirsttName: 'Jay', LastName: 'Mahjan' },
      { id: '3', FirsttName: 'Udit', LastName: 'Sharama' },
      { id: '4', FirsttName: 'Abhisheka', LastName: 'Patidar' },
      { id: '5', FirsttName: 'Vishal', LastName: 'Thakur' },
      { id: '6', FirsttName: 'Vanshika', LastName: 'Yadav' },
    ],
};
const crudOperation=(state = INITIAL_STATE , action) =>{
    switch(action.type){
        case "GETDATA":{
            return state;
        }
        case "ADDDATA":{
            return {
                ...state,
                employee: [...state.employee, action.payload],
              };
        }
        
        default : return state;
    }
}
export default crudOperation;