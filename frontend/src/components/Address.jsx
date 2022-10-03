import React from 'react'
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import styled from 'styled-components'
import { useStateValue } from '../StateProvider';
import Footer from './Footer';
import Header from './Header';

function Address() {

  const [{}, dispatch] = useStateValue()
  const [fullName, setFullName] = useState("")
  const [phone, setPhone] = useState("")
  const [flat, setFlat] = useState("")
  const [area, setArea] = useState("")
  const [landmark, setLandmark] = useState("")
  const [city, setCity] = useState("")
  const [state, setState] = useState("")


    const navigate = useNavigate()

    const deliver = (e) => {
        e.preventDefault()

        dispatch({
            type: 'SET_ADRESS',
            item: {
                fullName,
                phone,
                flat,
                area,
                landmark,
                city,
                state,
            }
        })
        navigate("/payment")
    }


  return (
    <Container>
        <Header />

        <Main>
          <FormContainer>
                  <InputContainer>
                      <p>Full Name</p>
                      <input 
                      onChange={(e) => setFullName(e.target.value)} 
                      type="text" 
                      placeholder='John Cena' 
                      value={fullName}/>
                  </InputContainer>

                  <InputContainer>
                      <p>Número de Telefone</p>
                      <input 
                      onChange={(e) => setPhone(e.target.value)} 
                      type="text" 
                      value={phone}
                      />
                  </InputContainer>

                  <InputContainer>
                      <p>Lozalização</p>
                      <input 
                      onChange={(e) => setFlat(e.target.value)} 
                      type="text" 
                      value={flat}/>
                  </InputContainer>

                  <InputContainer>
                      <p>Rua</p>
                      <input 
                      onChange={(e) => setArea(e.target.value)} 
                      type="text"
                      value={area}
                      />
                  </InputContainer>

                  <InputContainer>
                      <p>Ponto de Referência</p>
                      <input 
                      onChange={(e) => setLandmark(e.target.value)} 
                      type="text"
                      value={landmark}
                      />
                  </InputContainer>

                  <InputContainer>
                      <p>Cidade</p>
                      <input
                      onChange={(e) => setCity(e.target.value)} 
                      type="text"
                      value={city}
                      />
                  </InputContainer>

                  <InputContainer>
                      <p>Estado</p>
                      <input 
                      onChange={(e) => setState(e.target.value)} 
                      type="text" 
                      value={state}
                      />
                  </InputContainer>

                  <button onClick={deliver}>Entegar neste endereço</button>
          </FormContainer>
        </Main>

        <Footer />
    </Container>
  )
}

const Container = styled.div`
  width: 100%;
  height: 100vh;
  margin: auto;
  background-color: rgb(234, 237, 237);
  position: relative;
`;

const Main = styled.div`
  padding: 15px;
`;


const FormContainer = styled.div`
   border: 1px solid lightgray;
   width: 55%;
   min-width: 400px;
   height: fit-content;
   display: flex;
   flex-direction: column;
   align-items: center;
   justify-content: center;
   padding: 15px;
   background-color: #fff;
   margin: auto;

   button{
    align-self: flex-start;
    height: 33px;
    width: 250px;
    margin-top: 20px;
    background-color: purple;
    border: none;
    outline: none;
    border-radius: 5px;
    cursor: pointer;
   }
`;

const InputContainer = styled.div`
    width: 100%;
    padding: 10px;

    p{
        font-size: 14px;
        font-weight: 600;
    }

    input{
        width: 95%;
        height: 33px;
        padding-left: 5px;
        border-radius: 5px;
        border: 1px solid lightgray;
        margin-top: 5px;

        &:hover{
            border: 1px solid purple
        }
    }
`;



export default Address