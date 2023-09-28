import { createStore } from "redux";
import rootReducer from "./reduce/index";
const store=createStore(rootReducer);
export default store;