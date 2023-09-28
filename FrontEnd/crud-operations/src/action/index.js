export const showData = ()=>{
    return {
        type : "GETDATA"
    }
}
export const addData = (num) =>{
    return{
        type : "ADDDATA",
        payload : num
    };
}