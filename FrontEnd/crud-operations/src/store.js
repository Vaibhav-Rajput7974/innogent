import { configureStore } from "@reduxjs/toolkit";
import CrudeSlice from "./slice/CrudeSlice";
const store=configureStore({
    reducer:{
        crud:CrudeSlice,
    }
});
export default store;