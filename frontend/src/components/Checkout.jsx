import React from 'react'
import { useStateValue } from '../StateProvider'
import styled from 'styled-components';
import Header from './Header';
import CurrencyFormat from 'react-currency-format';
import { getBasketTotal } from '../reducer';
import { useNavigate } from 'react-router-dom';
import Footer from './Footer';
import PaymentMethod from './PaymentMethod';


function Checkout() {

    const [{ basket }, dispatch] = useStateValue();
    const navigate = useNavigate()

    const removeFromBasket = (e, id) => {
        e.preventDefault();

        dispatch({
            type: "REMOVE_FROM_BASKET",
            id: id,
        });
    };

    console.log('checkout >>>', basket)

  return (
    <Container>
        <Header />

        <Main>
            <ShoppingCart>
                <h2>Seu Carrinho</h2>

                {basket?.map((product) => (
                        <Product>
                        <Image>
                            <img src={product.image} alt="" />
                        </Image>
    
                        <Description>
                            <h4>{product.title}</h4>
    
                            <p>R$ {product.price}</p>
    
                            <button onClick={(e) => removeFromBasket(e, product.id)}>Remover</button>
                        </Description>
                    </Product>
                    ))}

    
            </ShoppingCart>

            <Subtotal>
                <CurrencyFormat renderText={(value) => (
                    <>
                        <p>
                            Total ({basket.length}) 
                            : <strong>{value}</strong>
                        </p>
                    </>
                )}
                    decimalScale={2}
                    value={getBasketTotal(basket)}
                    displayType='text'
                    thousandSeparator={true}
                    prefix={"R$"}
                />
                
                <button onClick={() => navigate("/address")}>Continuar com o pagamento</button>
            </Subtotal>
        </Main>
        
        <PaymentMethod />

        <Footer />
    </Container>
  )
}

const Container = styled.div`
    width: 100%;
    height: fit-content;
    margin: auto;
    background-color: rgb(234, 237, 237);
`;

const Main = styled.div`
    display: flex;
    padding: 15px;

    @media only screen and (max-width: 1200px){
        flex-direction: column;
    }

`;

const ShoppingCart = styled.div`
    padding: 15px;
    background-color: #FFF;
    flex: 0.7;
    

    h2{
        font-weight: 500;
        border-bottom: 1px solid lightgray;
        padding-bottom: 15px;
    }

    @media only screen and (max-width: 1200px){
        flex: none;
    }

`;

const Subtotal = styled.div`
    flex: 0.3;
    background-color: #fff;
    margin-left: 15px;
    height: 200px;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;

    @media only screen and (max-width: 1200px){
        flex: none;
        margin-top: 20px;
    }

    

    p{
        font-size: 20px;
    }

    small{
        display: flex;
        align-items: center;
        margin-top: 10px;

        span{
            margin-left: 10px;
        }
    }

    button{
        width: 65%;
        height: 33px;
        margin-top: 20px;
        background-color: orange;
        border: none;
        outline: none;
        border-radius: 8px;

        &:hover{
            border: 2px solid black;
        }
    }
`;

const Product = styled.div`
    display: flex;
    align-items: center;
`;

const Image = styled.div`
    margin-top: 10px;
    flex: 0.2;

    img{
        width: 100%;
    }
`;

const Description = styled.div`
    flex: 0.7;
    margin-left: 30px;
    
    h4{
        font-weight: 600;
        font-size: 18px;
    }

    p{
        font-weight: 600;
        margin-top: 10px;
    }

    button{
        background-color: transparent;
        color: #1384b4;
        border: none;
        outline: none;
        margin-top: 10px;
        cursor: pointer;

        &:hover{
        text-decoration: underline;
    }
    }


`;
export default Checkout