    import { createSlice } from "@reduxjs/toolkit";
    const initialState = {
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
    const CrudeSlice = createSlice({
        name : 'show',
        initialState,
        reducers :{
            getData:(state,action) =>{
                state.employee=action.payload;
            },
            addData:(state,action) =>{
                console.log(action.payload);
        
                state.employee.push(action.payload);
            },
            
            deleteData:(state,action) =>{
                console.log(action.payload);
                    
            }

        }
    }     
    );
    export const{getData,updataData,deleteData}=CrudeSlice.actions;
    export default CrudeSlice.reducer;
    export const{addData}=CrudeSlice.actions;

    