import React from "react";
import Home from "./Home";
import Login from "./Login";
import Register from "./Register";
const DisPlay=(props)=>{
    return(
        <div>
            {props.data === 'Home'? <Home/> : null }
            {props.data === 'Login'? <Login/> : null }
            {props.data === 'Register'? <Register/> : null }
            
        </div>
    );
}
export default DisPlay;