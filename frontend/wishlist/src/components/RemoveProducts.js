
import React, { useState } from 'react';
import axios from 'axios';

function RemoveProducts() {
    const [formData, setFormData] = useState({
        token: '',
        wid: '',
        pid: ''
    });

    const handleChange = (event) => {
        const { name, value } = event.target;
        setFormData(prevData => ({
            ...prevData,
            [name]: value
        }));
    };

    const handleSignup = async (event) => {
        event.preventDefault();



/*const config = {
  headers : {
     'Access-Control-Allow-Origin': '*',// Add any other custom headers here
    'Authorization': 'Bearer ' + formData.token,
  },

};*/
let t = formData.token;

let axiosConfig = {
      headers: {
        "Content-Type": "application/json",
        "Access-Control-Allow-Origin": "*",
        "Authorization" :  `Bearer ${t}`,
      },
    };
console.log(formData)
        try {

            const response = await axios.delete('http://localhost:9090/product',{ params  : {'wid':formData.userBucketId , 'pid':formData.productId}},
       axiosConfig

        );
         console.log("try block")
            console.log(response.data); // Handle successful response
        } catch (error) {

console.log( JSON.stringify(axiosConfig.headers));
            console.error('An error occurred:', error); // Handle error
        }
    };

    return (
        <div>
            <h1>RemoveProducts </h1>
            <form onSubmit={handleSignup}>
                <div>
                    <label>Token</label>
                    <input type="text" name="token" value={formData.token} onChange={handleChange} />
                </div>
                <div>
                    <label>userBucketId</label>
                    <input type="text" name="wid" value={formData.wid} onChange={handleChange} />
                </div>


                <div>
                    <label>ProductId</label>
                    <input type="text" name="pid" value={formData.pid} onChange={handleChange} />
                </div>

                <button type="submit">Delete Product</button>
            </form>
        </div>
    );
}

export default RemoveProducts;