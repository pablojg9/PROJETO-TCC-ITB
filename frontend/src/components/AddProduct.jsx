import React, { useState } from "react";
import { useEffect } from "react";
import { Navigate, useNavigate } from "react-router-dom";
import styled from 'styled-components';
import Api from "../api/Api";

const AddProduct = () => {


    const navigate = useNavigate()

    const [name, setName] = useState("");
    const [author, setAuthor] = useState("");
    const [editora, setEditora] = useState("")
    // const [imageURL, setImageURL] = useState("");
    const [value_book, setValueBook] = useState(0);
    const [categoriaList, setCategoriaList] = useState(0);
    const [categoryId, setCategoryId] = useState(0);
    //const [rating, setRating] = useState(0);

    const data = {
        name: name,
        author: author,
        editora: editora,
        value_book: value_book,
        categoryId: categoryId
    };

    useEffect(() => {

        Api.get("/api/category").then((response) => {
            console.log(response.data[0])
            setCategoriaList(response.data)
        }).catch((error) => {
            console.log(error);
        })
    }, [])

    const onSubmit = async (e) => {
        e.preventDefault();

        await Api.post("/api/book/save", data).then((response) => {
            console.log(response.data);
            console.log("deu certo")
        }).catch((error) => {
            console.log(error);
        })
    }

    return (
        <Container>
            <Logo onClick={() => navigate('/')}>
                <img src="./logo.png" alt="" />
            </Logo>

            <FormContainer>
                <h3>Adicionar Produto</h3>

                <InputContainer>
                    <p>Título</p>
                    <input type="text" onChange={(e) => setName(e.target.value)} value={name} />
                </InputContainer>

                <InputContainer>
                    <p>Autor</p>
                    <input type="text" onChange={(e) => setAuthor(e.target.value)} value={author} />
                </InputContainer>

                <InputContainer>
                    <p>Editora</p>
                    <input type="text" onChange={(e) => setEditora(e.target.value)} value={editora} />
                </InputContainer>
                
                <InputContainer>
                    <p>Preço</p>
                    <input type="number" onChange={(e) => setValueBook(e.target.value)} value={value_book} />
                </InputContainer>


                <InputContainer>
                    <p>Codigo</p>
                    <input type="number" onChange={(e) => setCategoryId(e.target.value)} value={categoryId} />
                </InputContainer>

                <InputContainer>
                    <p>Categoria</p>
                    <Select>
                        <option type="number" hidden>Codigo da categoria</option>
                       {
                        categoriaList && categoriaList.map((categoryId) => (
                            <option>
                                {categoryId.id}.&nbsp;
                                {categoryId.nameCategory}
                            </option>
                        ))
                       }
                    </Select>
                </InputContainer>  
                <Button onClick={onSubmit}>Adicionar Produto</Button>
            </FormContainer>
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
    justify-content: center;
`;

const Select = styled.select`
  width: 97%;
  height: 35px;
  margin-top: 5px;
  background: white;
  color: gray;
  
  font-size: 14px;
  border: none;

  option {
    color: black;
    background: white;
    display: flex;
    white-space: pre;
    min-height: 20px;
    padding: 0px 2px 1px;
  }
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
    height: fit-content;
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


const Button = styled.button`
    width: 70%;
    height: 35px;
    background-color: #f3b414;
    border: none;
    outline: none;
    border-radius: 10px;
    margin-top: 30px;

    &:hover{
        border: 2px solid black;
    }
`;

export default AddProduct