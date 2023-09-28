const root=["employee1","employee2","employee3"]
const crudOperation=(state = root , action) =>{
    switch(action.type){
        case "GETDATA":{
            return state;
        }
        case "ADDDATA":{
            return state+action.payload;
        }
        default : return state;
    }
}
export default crudOperation;