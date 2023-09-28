
import { Component } from "react";
import Counts from "./Counts";
class Main extends Component{
    constructor(){
        super() ;
        this.state  = {
            count : 0,
        } ;
    }
    render(){
        const fun=(num)=>{
            this.setState({count : this.state.count+num})
        }
        return(
            <div>
                <h2>Counter : {this.state.count}</h2>
                <Counts  setCount={fun} />
            </div>
        ) ;
    }
}
export default Main ;