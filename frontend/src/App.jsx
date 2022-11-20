import React from 'react'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'
import styled from 'styled-components'


import Address from './components/Address';
import Checkout from './components/Checkout';
import Home from './components/Home';
import Login from './components/Login';
import Payment from './components/Payment';
import AddProduct from './components/AddProduct';

import { Elements } from '@stripe/react-stripe-js';
import { loadStripe } from '@stripe/stripe-js';
import Category from './components/Category';
import SignUp from './components/SignUp/';
import Orders from './components/Orders/';
import Search from "./components/SearchBook/";


const promise = loadStripe(
  "pk_test_51LiZ0bDifAPYKrkMuW1z19J65uLgzWYOqTeMPDUQXhIhZwd6tAAMOyWDTd3e3cRstIVcIdKKZ2CnYLOQETwOnD0900HchoSOuj"
);

const App = () => {

  return (
    <Router>
      <Container>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/login" element={<Login />} />
          <Route path='/checkout' element={<Checkout />} />
          <Route path="/signup" element={<SignUp />} />
          <Route path="/search" element={<Search />} />
          <Route path="/address" element={<Address />} />
          <Route
            path="/payment"
            element={
              <Elements stripe={promise} >
                <Payment />
              </Elements>
            } />

          <Route path="/addproduct" element={<AddProduct />} />
          <Route path="/orders" element={<Orders />} />
          <Route path="/category/:id" element={<Category />} />

        </Routes>
      </Container>
    </Router>
  )
}

const Container = styled.div`
  width: 100vw;
  height: 100vh;
  overflow-y: scroll;

  &::-webkit-scrollbar {
    display: none;
  }
`;

export default App