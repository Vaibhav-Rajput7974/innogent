import React from 'react';

const UPdate = (props) => {
  // You can use props to receive data from the parent component

  return (
    <div>
      <h1>Hello, {props.name}!</h1>
    </div>
  );
};

export default UPdate;
