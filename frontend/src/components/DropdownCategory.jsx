import React, {useEffect, useState} from 'react';
import styled from "styled-components";
import { useNavigate } from 'react-router-dom';
import { FaChevronDown } from 'react-icons/Fa';
import { GiHamburgerMenu } from 'react-icons/Gi';
import Api from '../api/Api';

const DropdownCategory = () => {

    const [isActive, setIsActive] = useState();
    const navigate = useNavigate();
    
    const [category, setCategory] = useState([]);

    useEffect(() => {
        Api.get("/api/category").then((response) => {
            setCategory(response.data);
        }).catch((error) => {
            console.log(error);
        });
    }, [])

    return (
        <>
            <DropdownContainer>
                <DropdownHover onClick={e => setIsActive(!isActive)}><GiHamburgerMenu /><p>Categorias</p> <FaChevronDown /></DropdownHover>
            </DropdownContainer>
            {isActive && (
                <DropdownContent>
                    {
                        category.map((category, key) => {
                            return (
                                <DropdownItems key={key} onClick={() => {
                                    navigate(`/category/${category.id}`)
                                    window.location.reload();
                                }}><span>{category.nameCategory}</span></DropdownItems>
                            )
                        })
                    }
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

    border-left: 0.2px solid black;
    border-right: 0.2px solid black;

`;

const DropdownItems = styled.div`
    padding:10px;
    border-bottom: 0.2px solid black;

    &:nth-child(1){
        border-top: 0.2px solid black;
        }


    &:hover{
        cursor: pointer;
        background-color: #f4f4f4;
        transition: all 0.2s;
    }
`;


export default DropdownCategory;