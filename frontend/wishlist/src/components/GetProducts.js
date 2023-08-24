
import React, { useState } from 'react';
import axios from 'axios';

function GetProducts() {
    const [formData, setFormData] = useState({
        token: '',
        userBucketId: ''
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

        try {

            const response = await axios.get('http://localhost:9090/products',{ params  : {'userBucketId':formData.userBucketId}},
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
            <h1>GetProducts </h1>
            <form onSubmit={handleSignup}>
                <div>
                    <label>Token</label>
                    <input type="text" name="token" value={formData.token} onChange={handleChange} />
                </div>
                <div>
                    <label>userBucketId</label>
                    <input type="text" name="userBucketId" value={formData.userBucketId} onChange={handleChange} />
                </div>
                <button type="submit">Get Wishlist</button>
            </form>
        </div>
    );
}

export default GetProducts;