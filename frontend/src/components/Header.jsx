import React from 'react'
import { useNavigate } from 'react-router-dom';
import styled from 'styled-components';
import { useStateValue } from '../StateProvider';


function Header() {

    const [{ basket }] = useStateValue(false);
    const navigate = useNavigate();


  return (
    <Container>
       <Inner>
        <Logo onClick={() => navigate('/')}>
            <img src="./logo.png" alt="" />
        </Logo>
            

        <SearchBar>
            <input type="text" placeholder='Search...'/>
            <SearchIcon>
                <img src="./searchicon.png" alt="" />
            </SearchIcon>
        </SearchBar>

        <RightContainer>

            <NavButton onClick={() => navigate('/login')}>
                <p>Hellow</p>
                <p>Guest</p>
            </NavButton>

            <NavButton onClick={() => navigate('/')}>
                <p>Return</p>
                <p>& Orders</p>
            </NavButton>

            <BasketButton onClick={() => navigate('/checkout')}>
                <img src="./basket-icon.png" alt="" />
                <p>{basket?.length}</p>
            </BasketButton>
        </RightContainer>
       </Inner>

       <MobileSearchBar>
            <input type="text" placeholder='Search...'/>
            <SearchIcon>
                <img src="./searchicon.png" alt="" />
            </SearchIcon>
        </MobileSearchBar>

    </Container>

  )
}

const Container = styled.div`
    width: 100%;
    height: 100px;
    background-color: #131921;
    display: flex;
    align-items: center;
    position: relative;

    @media only screen and (max-width: 767px){
        height: 120px;
        padding: 20px;
        flex-direction: column;
    }
`;


const Inner = styled.div`
    width: 100%;
    display: flex;
    align-items: center;

    @media only screen and (max-width: 767px){
        justify-content: space-between;
    }
`;


const Logo = styled.div`
        margin-left: 100px;
        cursor: pointer;

    img{
        width: 50px;
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
        border: none;
        border-radius: 5px 0px 0px 5px;

        &::placeholder{
            padding-left: 5px;
        }
    }

    @media only screen and (max-width: 767px){
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


        &::placeholder{
            padding-left: 10px;
        }
    }

    @media only screen and (min-width: 768px) {
        display: none;
    }

`;

const SearchIcon = styled.div`
    background-color: #D1AE6C;
    height: 100%;
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

    @media only screen and (max-width: 767px){

    }
`;

const NavButton = styled.div`
    color: #FFF;
    padding: 5px;
    height: 80%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    cursor: pointer;
    margin-right: 15px;

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

const BasketButton = styled.div`
    display: flex;
    align-items: center;
    height: 90%;
    margin-right: 100px;
    cursor: pointer;

    img{
        width: 30px;
        margin-right: 10px;
    }

    p{
        color: #fff;
        font-weight: 500;
    }
`;


export default Header