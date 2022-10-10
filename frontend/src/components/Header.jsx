import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom';
import styled from 'styled-components';
import Api from '../api/Api';
import { useStateValue } from '../StateProvider';

const Header = () => {

    const [{ basket }] = useStateValue(false);
    const navigate = useNavigate();

    const nome = localStorage.getItem("nome");
    const token = localStorage.getItem("token");

    const [searchLivro, setSearchLivro] = useState("");

    const onSubmit = async (e) => {
        e.preventDefault();
        navigate("/search")

        await Api.get(`/api/book/name/${searchLivro}`).then((response) => {
            localStorage.setItem("livros", JSON.stringify(response.data));
            window.location.reload();

        }).catch((error) => {
            console.log(error);
        });
    }

    return (
        <Container>
            <Inner>
                <Logo onClick={() => navigate('/')}>
                    <img src="./whitelogo.png" alt="" />
                </Logo>

                <SearchBar>
                    <input onChange={(e) => setSearchLivro(e.target.value)} ontype="text" placeholder='O que está procurando?' />

                    <SearchIcon onClick={onSubmit}>
                        <img src="./searchicon.png" alt="" />
                    </SearchIcon>
                </SearchBar>

                <RightContainer>
                    <NavButton>
                        <p>Olá</p>
                        {
                            token ? (
                                <p>{nome}</p>
                            ) :
                                (
                                    <p onClick={() => navigate("/login") }>Visitante</p>
                                )
                        }
                        {
                            token ? (

                                <NavbarDropdownContent>

                                    <DropdownItem onClick={() => {
                                        localStorage.removeItem("token");
                                        localStorage.removeItem("nome");
                                        navigate("/")
                                        window.location.reload();
                                    }}>
                                        <span>Sair</span>
                                    </DropdownItem>
                                </NavbarDropdownContent>
                            ) : <p></p>
                        }
                    </NavButton>

                    {
                        token ? (

                            <NavButton onClick={() => navigate('/orders')}>
                                <p>Seus</p>
                                <p>Pedidos</p>
                            </NavButton>
                        ) : (

                            <NavButton onClick={() => navigate('/login')}>
                                <p>Seus</p>
                                <p>Pedidos</p>
                            </NavButton>
                        )
                    }

                    {
                        token ? (
                            <BasketButton onClick={() => navigate("/checkout")}>
                                <img src="./basket.png" alt="" />

                                <BasketBG>
                                    <p>{basket?.length}</p>
                                </BasketBG>
                            </BasketButton>
                        ) :
                            <BasketButton onClick={() => navigate("/login")}>
                                <img src="./basket.png" alt="" />

                                <BasketBG>
                                    <p>{basket?.length}</p>
                                </BasketBG>
                            </BasketButton>
                    }



                </RightContainer>
            </Inner>

            <MobileSearchBar>
                <input type="text" placeholder='Search...' />
                <SearchIcon>
                    <img src="./searchicon.png" alt="" />
                </SearchIcon>
            </MobileSearchBar>

        </Container>

    )
}

const Container = styled.div`
    max-width: 100%;
    height: 100px;
    background-color: #131921;
    display: flex;
    align-items: center;
    position: relative;

    @media only screen and (max-width: 1000px){
        height: 180px;
        padding: 20px;
        flex-direction: column;
    }

    @media only screen and (max-width: 770px){
        height: 230px;
    }
`;


const Inner = styled.div`
    width: 100%;
    display: flex;
    align-items: center;

    @media only screen and (max-width: 1000px){
        justify-content: space-between;
    }

    @media only screen and (max-width: 770px){
        display: flex;
        flex-direction: column;
    }
`;


const Logo = styled.div`
        margin-left: 100px;
        cursor: pointer;

    img{
        width: 300px;
    }

    @media only screen and (max-width: 770px){
        margin: auto;
    }
    
`;



const SearchBar = styled.div`
    height: 35px;
    flex: 1;
    margin: 15px 10px 15px 40px;
    display: flex;
    align-items: center;

    input{
        flex: 1;
        width: 100%;
        height: 100%;
        border: 2px solid orange;
        border-radius: 5px 0px 0px 5px;

        &::placeholder{
            padding-left: 5px;
        }
    }

    @media only screen and (max-width: 1000px){
        display: none;
    }
`;

const MobileSearchBar = styled.div`
    height: 35px;
    width: 90%;
    display: flex;
    align-items: center;
    padding: 10px;

    input{
        flex: 1;
        height: 100%;
        border-top-left-radius: 0%;
        border-radius: 5px 0px 0px 5px;
        border: none;
        border: 1px solid orange;


        &::placeholder{
            padding-left: 10px;
        }
    }

    @media only screen and (min-width: 999px) {
        display: none;
    }

`;

const SearchIcon = styled.div`
    background-color: orange;
    height: 39px;
    width: 40px;
    display: flex;
    align-items: center;
    justify-content: center;
    border-radius: 0px 5px 5px 0;

    img{
        width: 22px;
    }
`;

const RightContainer = styled.div`
    display: flex;
    align-items: center;
    width: fit-content;
    justify-content: space-around;
    height: 100%;
    padding: 5px 15px;

    @media only screen and (max-width: 770px){
        padding-bottom: 20px;
        justify-content: center;
        align-items: center;
        margin-left: 100px;
    }
    
`;

const NavButton = styled.div`
    color: #ffffff;
    font-size: 15px;
    font-weight: 600;
    padding: 5px;
    height: 80%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    cursor: pointer;
    margin-right: 15px;


    &:nth-child(1){
    position: relative;
    display: inline-block;
    height: fit-content;

    &:hover {
      display: block;
      >div {
          display: block;
      }
    }
    }

    p{
        &:nth-child(1){
            font-size: 12px;
        }

        &:nth-child(2){
            font-size: 14px;
            font-weight: 600;
        }
    }
`;

const NavbarDropdownContent = styled.div`
    display: none;

    position: absolute;
    background-color: #f9f9f9;
    width: 120px;
    padding: 10px 5px 5px 7px;
    margin-top: 5px;
    margin-left: -30px;
    z-index: 1;
    color: black;
    border-radius: 5px;

    span:hover{
        cursor: pointer;
        text-decoration: underline;
    }


`;

const DropdownItem = styled.div`
    display: flex;
    flex-direction: column;

    span{
        margin-bottom: 10px;
    }
`;


const BasketButton = styled.div`
    display: flex;
    align-items: center;
    height: 90%;
    margin-right: 100px;
    cursor: pointer;

    img{
        width: 35px;
        margin-right: 18px;
    }

    p{
        margin: 0 0 0 6px;
        color: black;
        font-weight: 500;
    }
`;

const BasketBG = styled.div`
    height: 22px;
    width: 22px;
    background-color: orange;
    border-radius: 30px;
    margin-left: -10px;
    padding: 4px;

`;



export default Header