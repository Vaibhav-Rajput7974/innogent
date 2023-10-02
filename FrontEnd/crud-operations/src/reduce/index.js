import { combineReducers } from "redux"
import CrudeSlice from "../slice/CrudeSlice";
const rootReducer=combineReducers({
    crudSet : CrudeSlice,  
})
export default rootReducer;