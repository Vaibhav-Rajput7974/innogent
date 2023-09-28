import React, { Component } from "react";
class Counts extends Component{
    constructor(props){
        super() ;
    }
    render(){
        return(
            <div>
            <button onClick={   () => this.props.setCount(1)}>
                click Here to Count
            </button>
        </div>
        )
    }
}
export default Counts ;