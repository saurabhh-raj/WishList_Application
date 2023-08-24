
import React from 'react';

import Signup from './components/Signup.component.js';
import Login from './components/Login.component.js';
import GetProducts from './components/GetProducts.js';
import AddProducts from './components/AddProducts.js';
import RemoveProducts from './components/RemoveProducts.js';
import GetWishlists from './components/GetWishlists.js';
import ReactDOM from "react-dom/client";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

//import setupProxy from './components/setupProxy.js';
//const setupProxy = require('./setupProxy');
//setupProxy(App);

function App() {

 /*   const [formData, setFormData] = useState({
        username: '',
        password: ''
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

        const headers = {
            'Content-Type': 'application/json', // Specify the content type
            'Access-Control-Allow-Origin': '*',// Add any other custom headers here
        };

        try {
            const response = await axios.post('http://localhost:9090/signup', JSON.stringify(formData), { headers });
            console.log(response.data); // Handle successful response
        } catch (error) {
            console.error('An error occurred:', error); // Handle error
        }
    };
*/
    return (
     /*   <div>
        <Signup/>
         <Login/>
        <GetWishlists/>
         <GetProducts/>
         <AddProducts/>
         <RemoveProducts/>

        </div>*/
         <Router>

              <Routes>
                <Route path="/" element={[<Signup />,<Login />]} />
                <Route path="/wishlist" element={[<GetWishlists />,<GetProducts/>,<AddProducts/>,<RemoveProducts/>]} />

              </Routes>
            </Router>
    );
}

export default App;

/*

import logo from './logo.svg';*//*

import "./App.css";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import { useForm } from "react-hook-form";
import React, { useState, useEffect } from "react";
import axios from "axios";

function App() {
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm();
  debugger;

  const [inputValue, setInputValue] = useState("");
  const [responseData, setResponseData] = useState(null);
  let onSubmit = async () => {
    try {
      debugger;
      let response = axios({
        method: "post",
        url: "http://localhost:9090/signup",
        data: {"username" : "osos" , "password":"12"},
          headers: {
                  "Content-Type": "application/json;charset=UTF-8",
                  "Access-Control-Allow-Origin": "*",
                }
      }).then(function (response) {
        console.log(response.data);
      });

      setResponseData(response.data);
    } catch (error) {
      console.error("Error sending data:", error);
    }
    */
/*   if(this.data === undefined) {return}
          try {  await axios.post("https://localhost:9090/signup", {data : inputValue}).then((res) => { console.log(res.data); }); } catch (error) { console.log(error.response.data.message); }
*//*

  };
  return (
    <>
      <p className="title">Registration Form</p>
      <form className="App" onSubmit={handleSubmit(onSubmit)}>
        <input type="email" {...register("email", { required: true })} />
        {errors.email && (
          <span style={{ color: "red" }}>*Email* is mandatory </span>
        )}
        <input type="password" {...register("password")} />
        <input type={"submit"} style={{ backgroundColor: "#ADt8E6" }} />
      </form>
    </>
  );
}

export default App;
*/
