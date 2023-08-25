
import React, { useState } from 'react';
import axios from 'axios';
import './styles.css'

function RemoveProducts() {
    const [formData, setFormData] = useState({
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
let t =  localStorage.getItem('token');

let axiosConfig = {
      headers: {
        "Content-Type": "application/json",
        "Access-Control-Allow-Origin": "*",
        "Authorization" :  `Bearer ${t}`,
      },
    };
console.log(formData)
let param = { params  : {'wid':formData.wid , 'pid':formData.pid} ,...axiosConfig};
        try {

            const response = await axios.delete('api/product',param,


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
           <div class="remove-products-container">
             <h1 class="remove-products-title">Remove Products</h1>
             <form onSubmit={handleSignup}>

               <div class="form-group">
                 <label for="wid" class="form-label">User Bucket ID</label>
                 <input
                   type="text"
                   class="form-control"
                   id="wid"
                   name="wid"
                   value={formData.wid}
                   onChange={handleChange}
                 />
               </div>

               <div class="form-group">
                 <label for="pid" class="form-label">Product ID</label>
                 <input
                   type="text"
                   class="form-control"
                   id="pid"
                   name="pid"
                   value={formData.pid}
                   onChange={handleChange}
                 />
               </div>

               <button type="submit" class="btn btn-primary">Delete Product</button>
             </form>
           </div>

        </div>
    );
}

export default RemoveProducts;