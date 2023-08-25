
import React, { useState } from 'react';
import axios from 'axios';
import './styles.css';


function AddProducts() {
    const [formData, setFormData] = useState({
        token: '',
        CustomerId:'1',
        userBucketId: '',
        productId: '',
        customer: '22',
        name: '',
        price: ''
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

        try {

            const response = await axios.post('api/product', formData,
       axiosConfig

        );

            console.log(response.data); // Handle successful response
        } catch (error) {

console.log( JSON.stringify(axiosConfig.headers));
            console.error('An error occurred:', error); // Handle error
        }
    };

    return (
        <div >

           <form onSubmit={handleSignup} class="form-container">
           <h1> Add Products </h1>
             <div class="form-group">
               <label for="userBucketId" class="form-label">User Bucket ID</label>
               <input
                 type="text"
                 class="form-control"
                 id="userBucketId"
                 name="userBucketId"
                 value={formData.userBucketId}
                 onChange={handleChange}
               />
             </div>
             <div class="form-group">
               <label for="productId" class="form-label">Product ID</label>
               <input
                 type="text"
                 class="form-control"
                 id="productId"
                 name="productId"
                 value={formData.productId}
                 onChange={handleChange}
               />
             </div>
             <div class="form-group">
               <label for="name" class="form-label">Name</label>
               <input
                 type="text"
                 class="form-control"
                 id="name"
                 name="name"
                 value={formData.name}
                 onChange={handleChange}
               />
             </div>
             <div class="form-group">
               <label for="price" class="form-label">Price</label>
               <input
                 type="text"
                 class="form-control"
                 id="price"
                 name="price"
                 value={formData.price}
                 onChange={handleChange}
               />
             </div>
             <button type="submit" class="btn btn-primary">Add Product</button>
           </form>

        </div>
    );
}

export default AddProducts;