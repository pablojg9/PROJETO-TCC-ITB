import React from 'react';
import styled from "styled-components";
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { FaChevronDown } from 'react-icons/Fa';
import { GiHamburgerMenu } from 'react-icons/Gi';



 function DropdownCategory() {

  const [isActive, setIsActive] = useState();
  const navigate = useNavigate();

  return (
    <>
       <DropdownContainer>
            <DropdownHover onClick={e => setIsActive(!isActive)}><GiHamburgerMenu /> <p>Categorias</p> <FaChevronDown /></DropdownHover>
        </DropdownContainer>
        {isActive && (
              <DropdownContent>
                <DropdownItems onClick={() => navigate('/category')}><span>Ação</span></DropdownItems>
                <DropdownItems onClick={() => navigate('/category')}><span>Aventura</span></DropdownItems>
                <DropdownItems onClick={() => navigate('/category')}><span>Comedia</span></DropdownItems>
                <DropdownItems onClick={() => navigate('/category')}><span>Crime</span></DropdownItems>
                <DropdownItems onClick={() => navigate('/category')}><span>Drama</span></DropdownItems>
                <DropdownItems onClick={() => navigate('/category')}><span>Ficcção</span></DropdownItems>
                <DropdownItems onClick={() => navigate('/category')}><span>Mangá</span></DropdownItems>
                <DropdownItems onClick={() => navigate('/category')}><span>Mistério</span></DropdownItems>
                <DropdownItems onClick={() => navigate('/category')}><span>Romance</span></DropdownItems>
        </DropdownContent>
        )}
    </>
  )
};

const DropdownContainer = styled.div`
    height: 70px;
    display: flex;
    flex-direction: column;
    margin-left: 100px;
    position: relative;

`;


const DropdownHover = styled.div`
    width: 140px;
    padding: 10px;
    display: flex;
    align-items: center;
    justify-content: space-evenly;
    background-color: lightgray;

    p{
        font-weight: bold;
    }
`;


const DropdownContent = styled.div`
    width: 250px;
    background-color: #FFF;
    z-index: 20;
    margin-left: 100px;
    margin-top: -30px;
    position: absolute;
    border: 1px solid black;
`;

const DropdownItems = styled.div`
    padding:10px;
    border: 0.2px solid black;


    &:hover{
        cursor: pointer;
        background-color: #f4f4f4;
        transition: all 0.2s;
    }
`;


export default DropdownCategory;