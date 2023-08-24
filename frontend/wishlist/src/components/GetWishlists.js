
import React, { useState } from 'react';
import axios from 'axios';
import { Fragment } from 'react';
import './styles.css';

function GetWishlists() {
 const [data, setData] = useState([]);
  const [showTable, setShowTable] = useState(false);



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

        try {

            const response = await axios.get('api/wishlists',axiosConfig

        );
         setData(response.data);
              setShowTable(true);

            console.log(response.data); // Handle successful response
        } catch (error) {

console.log( JSON.stringify(axiosConfig.headers));
            console.error('An error occurred:', error); // Handle error
        }
    };

    return (
        <div>
            <h1>GetWishlists </h1>
            <form onSubmit={handleSignup}>

                <button type="submit">Get Wishlist ids</button>
<table class ="wnames">
                      {showTable && (

<tbody>
<Fragment>
                    {data.map((item) => (
                              <tr key={item}>
                              {item}
                              </tr>
                            ))}
</Fragment></tbody>
                            )}
                            </table>
</form>

        </div>
    );
}

export default GetWishlists;