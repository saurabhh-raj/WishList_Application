
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
let t =  localStorage.getItem('token');

let axiosConfig = {
      headers: {
        "Content-Type": "application/json",
        "Access-Control-Allow-Origin": "*",
       "Authorization" :  `Bearer ${t}`,
},
    };
    let param = { params  : {"userBucketId":formData.userBucketId,},};
console.log(param);
        try {

            const response = await axios.get('api/products', param,
       { headers : axiosConfig}

        );
         console.log("try block")
            console.log(response.data); // Handle successful response
        } catch (error) {

console.log( JSON.stringify(axiosConfig.headers));

            console.error('An error occurred:', error); // Handle error
        }
    };

    return (

     <>   <div>
            <h1>GetProducts from WishlistId </h1>
            <form onSubmit={handleSignup}>

                <div>
                    <label>userBucketId</label>
                    <input type="text" name="userBucketId" value={formData.userBucketId} onChange={handleChange} />
                </div>
                <button type="submit">Get Wishlist</button>
            </form>
        </div>

          <div>
              <h1>Product Table</h1>
              <table>
                <thead>
                  <tr>
                    <th>WishlistId</th>
                    <th>ProductId</th>
                    <th>Name</th>
                    <th>Price</th>
                  </tr>

                </thead>
                <tbody>

                </tbody>
              </table>

            </div>

</>
    );
}

export default GetProducts;

