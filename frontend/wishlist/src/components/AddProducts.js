
import React, { useState } from 'react';
import axios from 'axios';

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
        <div>
            <h1>AddProducts </h1>
            <form onSubmit={handleSignup}>


                <div>
                    <label>userBucketId</label>
                    <input type="text" name="userBucketId" value={formData.userBucketId} onChange={handleChange} />
                </div>
                <div>
                                    <label>ProductId</label>
                                    <input type="text" name="productId" value={formData.productId} onChange={handleChange} />
                                </div>
                                <div>
                                                                    <label>Name</label>
                                                                    <input type="text" name="name" value={formData.name} onChange={handleChange} />
                                                                </div>

                           <div>
                                                               <label>Price</label>
                                                               <input type="text" name="price" value={formData.price} onChange={handleChange} />
                                                           </div>
                <button type="submit"> Add Product</button>
            </form>
        </div>
    );
}

export default AddProducts;