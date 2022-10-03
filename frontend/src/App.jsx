import React from 'react'
import { BrowserRouter as Router, Routes, Route} from 'react-router-dom'
import styled from 'styled-components'


import Address from './components/Address';
import Checkout from './components/Checkout';
import Home from './components/Home';
import Login from './components/Login';
import Payment from './components/Payment';
import SignUp from './components/SignUp';

import {Elements} from '@stripe/react-stripe-js';
import {loadStripe} from '@stripe/stripe-js';
import Category from './components/Category';



const promise = loadStripe(
  "pk_test_51LiZ0bDifAPYKrkMuW1z19J65uLgzWYOqTeMPDUQXhIhZwd6tAAMOyWDTd3e3cRstIVcIdKKZ2CnYLOQETwOnD0900HchoSOuj"
);

function App() {

  return (
    <Router>
      <Container>
        <Routes>
          <Route  path="/"  element={<Home />} />
          <Route  path="/login"  element={<Login />} />
          <Route path='checkout' element={<Checkout/>} />
          <Route  path="/signup"  element={<SignUp />} />
          <Route  path="/address"  element={<Address />} />
          <Route  
            path="/payment" 
            element={
            <Elements stripe={promise} >
              <Payment />
            </Elements>
            }
            />


          <Route  path="/category"  element={<Category />} />

        </Routes>
      </Container>
    </Router>
  )
}

const Container = styled.div`

`;

export default App