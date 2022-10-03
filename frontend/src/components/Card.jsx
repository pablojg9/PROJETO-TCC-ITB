import React from 'react'
import styled from 'styled-components';
import Rating from '@material-ui/lab/Rating';
import { useStateValue } from '../StateProvider';


function Card({ id, image, price, rating, title }) {

    const [{basket}, dispatch] = useStateValue()

    const addToBasket = (e) => {
        e.preventDefault()
        console.log('basket >>>', basket)
        dispatch({
            type:'ADD_TO_BASKET',
            item:{
                id,
                title,
                price,
                image,
                rating,
            },
        });
    };

  return (
    <Container>
        <Image>
            <img src={image} alt="" />
        </Image>
        <Description>
            <h5>{title}</h5>

            <Rating name="half-rating-read" defaultValue={rating} precision={0.5} readOnly />

            <p>R${price}</p>
            
            <button onClick={addToBasket}>Adicionar ao Carrinho</button>
        </Description>
    </Container>
  )
}

const Container = styled.div`
    width: 100%;
    height: 100%;

    display: flex;
    flex-direction: column;
    background-color: #FFF;
    z-index: 10;
    border-radius: 5px;
`;

const Image = styled.div`
    width: 100%;

    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    margin-top: 20px;
    flex: 0.3;

    img{
        width: 180px;
        height: 200px;
        border-radius: 5px;
    }
`;

const Description = styled.div`
    width: 90%;
    margin: auto;
    display: flex;
    flex-direction: column;
    justify-content: space-evenly;
    flex: 0.7;

    h3{
        font-size: 16px;
        font-weight: 600;
    }

    p{
        font-weight: 600;
    }

    button{
        width: 60%;
        height: 33px;
        background-color: #fa8900;
        border: none;
        border-radius: 10px;
        cursor: pointer;
        margin-left: 20%;

        &:hover{
            border: 3px solid black;
        }

    }

`;

export default Card