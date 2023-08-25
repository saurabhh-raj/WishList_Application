
import React, { useState } from 'react';
import axios from 'axios';
import './styles.css';


function GetProducts() {
 const [data, setData] = useState([]);
  const [showTable, setShowTable] = useState(false);
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
    let param = { params  : {"userBucketId":formData.userBucketId,},...axiosConfig};
console.log(param);
        try {
              console.log(param, axiosConfig);
            const response = await axios.get('api/products', param,

        );
        setData(response.data);
         setShowTable(true);
         console.log("try block")
            console.log(response.data); // Handle successful response
        } catch (error) {

            console.error('An error occurred:', error); // Handle error
        }
    };

    return (

     <>   <div>

            <form onSubmit={handleSignup} class="form-container">
             <h1>GetProducts from WishlistId </h1>

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

                <button type="submit" class="btn btn-primary">Get Products</button>
            </form>
        </div>

         <div class="product-table-container">

           <table class="wname">
             <thead> <h2 class="hed">Product Table</h2>
               <tr>
                 <th>WishlistId</th>
                 <th>ProductId</th>
                 <th>Name</th>
                 <th>Price</th>
               </tr>
             </thead>
             <tbody>
               {showTable && data.map(item => (
                 <tr key={item.userBucketId}>
                   <td>{item.userBucketId}</td>
                   <td>{item.productId}</td>
                   <td>{item.name}</td>
                   <td>{item.price}</td>
                 </tr>
               ))}
             </tbody>
           </table>
         </div>

</>
    );
}

export default GetProducts;


/*
   {data.map(item => (
                              <tr key={item.userBucketId}>
                               <td>{item.userBucketId}</td>
                                <td>{item.ProductId}</td>
                                <td>{item.name}</td>
                                <td>{item.price}</td>

                                {*/
/* Add more table data cells as needed *//*
}
                              </tr>
                            ))}*/


/*

______________________________________________________________


curl 'http://localhost:3000/api/products?userBucketId=lapotp' \
  -H 'Accept: application/json, text/plain, *' \
  -H 'Accept-Language: en-GB,en-US;q=0.9,en;q=0.8' \
  -H 'Connection: keep-alive' \
  -H 'Cookie: JSESSIONID=B4486FE9CB22728C727FBD678EB88169' \
  -H 'Referer: http://localhost:3000/wishlist' \
  -H 'Sec-Fetch-Dest: empty' \
  -H 'Sec-Fetch-Mode: cors' \
  -H 'Sec-Fetch-Site: same-origin' \
  -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/115.0.0.0 Safari/537.36' \
  -H 'sec-ch-ua: "Not/A)Brand";v="99", "Google Chrome";v="115", "Chromium";v="115"' \
  -H 'sec-ch-ua-mobile: ?0' \
  -H 'sec-ch-ua-platform: "macOS"' \
  --compressed


 curl --location 'http://localhost:3000/api/products?userBucketId=lapotp' \
 --header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdyIsImlhdCI6MTY5Mjk0MDQ4MiwiZXhwIjoxNjkyOTc2NDgyfQ.2MLQ3B-KwClx5ggn5cjC3ETrZ-SOu0If_yy8w5naRLA' \
 --header 'Cookie: JSESSIONID=900DC44EF7F108B8387A25C94D1DC847'
*/
