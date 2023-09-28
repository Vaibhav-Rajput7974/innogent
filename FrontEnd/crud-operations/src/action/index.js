export const showData = ()=>{
    return {
        type : "GETDATA"
    }
}
export const addData = (obj) =>{
    return{
        type : "ADDDATA",
        payload : obj
    };
}