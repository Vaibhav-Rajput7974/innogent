import { combineReducers } from "redux"
import crudOperation from "./crud"
const rootReducer=combineReducers({
    crudSet : crudOperation,  
})
export default rootReducer;