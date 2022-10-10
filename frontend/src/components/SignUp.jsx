import React, { useState } from 'react'
import styled from 'styled-components';
import { useNavigate } from 'react-router-dom';
import Api from '../api/Api';


const SignUp = () => {

    const navigate = useNavigate()

    const [nome, setNome] = useState("");
    const [login, setLogin] = useState("");
    const [senha, setSenha] = useState("");
    
    const data = {
        nome: nome,
        login: login,
        senha: senha
    }

    const onSubmit = async (e) => {
        e.preventDefault();
        await Api.post("/api/usuarios/save", data).then((response) => {
            console.log(response.data.nome);
            
            alert("cadastro com sucesso");
            localStorage.setItem("nome", response.data.nome);

            navigate("/login")
        }).catch((error) => {
            console.log(error);
        });
    }

  return (
    <Container>
       <Logo onClick={() => navigate('/')}>
           <img src="./logo.png" alt="" />
        </Logo>

        <FormContainer onSubmit={onSubmit}>
                <h3>Sign-In</h3>

                <InputContainer>
                    <p>Full Name</p>
                    <input type="text" onChange={(e) => setNome(e.target.value)} placeholder='John Cena' />
                </InputContainer>

                <InputContainer>
                    <p>Email</p>
                    <input type="email" onChange={(e) => setLogin(e.target.value)} placeholder='example@gmail.com' />
                </InputContainer>

                <InputContainer>
                    <p>Password</p>
                    <input type="Password" onChange={(e) => setSenha(e.target.value)} placeholder='****' />
                </InputContainer>

                <SignUpButton>Criar conta na Bookshop</SignUpButton>
                <InfoText>By continuingm, you agree to Bookshop <span>Conditions of Use</span> and <span>Privacy Note .</span></InfoText>
            </FormContainer>

        <LoginButton onClick={() => navigate('/login')}>Voltar ao Login</LoginButton>
    </Container>
  )
}

const Container = styled.div`   
    width: 40%;
    min-width: 450px;
    height: fit-content;
    padding: 15px;
    margin: auto;
    display: flex;
    flex-direction: column;
    align-items: center;
`; 


const Logo = styled.div`
    cursor: pointer;

    img{
        width: 500px;
    }
`;

const FormContainer = styled.form`
    border: 1px solid lightgray;
    width: 55%;
    height: 400px;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    padding: 15px;

    h3{
        font-size: 28px;
        font-weight: 400;
        line-height: 33px;
        align-self: flex-start;

        margin-bottom: 10px;
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
            border: 1px solid black;
        }
    }
`;


const SignUpButton = styled.button`
    width: 100%;
    height: 35px;
    font-size: 12px;
    margin-top: 20px;

    &:hover{
        background-color: #dfdfdf;
        border: 1px solid gray;
    }
`;

const InfoText = styled.p`
    font-size: 12px;
    width: 100%;
    word-wrap: normal;
    word-break: normal;
    margin-top: 20px;

    span{
        color: #426bc0;
    }
`;

const LoginButton = styled.button`
    width: 40%;
    height: 40px;
    background-color: #f3b414;
    border: none;
    outline: none;
    border-radius: 10px;
    margin-top: 30px;

    &:hover{
        border: 2px solid black;
    }
`;




export default SignUp