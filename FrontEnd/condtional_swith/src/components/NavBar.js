import React, { useState } from "react";
import DisPlay from "./DisPlay";
const NavBar =() => {
   const [value,setState]=useState("null")
   
    return(
        <body>
        <div class="navbar">
            <button onClick={()=>setState('Home')}>Home</button>
            <button onClick={()=>setState('Login')}>Login</button>
            <button onClick={()=>setState('Register')}>Register</button>
        </div>
        <div class="content">
            <h1>Welcome to My Website</h1>
            <p>This is the main content of your webpage.</p>
            <DisPlay data={value}/>
        </div>
    </body>
    );
}
export default NavBar;