import React from 'react'
import styled from 'styled-components'
import { useStateValue } from '../StateProvider';
import Header from './Header';
import Footer from './Footer';
import CurrencyFormat from 'react-currency-format';
import { getBasketTotal } from '../reducer';
import {CardElement, useElements, useStripe} from "@stripe/react-stripe-js"
import PaymentMethod from './PaymentMethod';

// import { useEffect, useState } from 'react';
// import { useNavigate } from 'react-router-dom';
// import axios from "../axios";

function Payment() {

    const [{address, basket}] = useStateValue();
    // const [clientSecret, setClientSecret] = useState('');
    const elements = useElements()
    const stripe = useStripe()

    // const navigate = useNavigate();

    // useEffect(() => {
    //     const fetchClientSecret = async () => {
    //         const data = await axios.post('/payment/create', {
    //             amount: getBasketTotal(basket),
    //         });

    //         setClientSecret(data.data.clientSecret);
    //     };

    //     fetchClientSecret();
    //     console.log('clientSecret is >>>>', clientSecret)
    // }, []);

    // const confirmPayment = async (e) => {
    //     e.preventDefault(); 

    //     await stripe.confirmCardPayment(clientSecret, {
    //         payment_mothod: {
    //             card: elements.getElement(CardElement)
    //         }
    //     })
    //     .then((result) => {
            //    axios.post("/orders/add", {
            //         basket: basket,
            //         price: getBasketTotal(basket),
            //         email: user?.email,
            //         adress: address,
            //    });

    //         dispatch({
    //             type:'EMPTY_BASKET'
    //         })
    //         navigate('/')
    //     })
    //     .catch((err) => console.warn(err));
    // }

  return (
   <Container>
        <Header />

        <Main> 
            <ReviewContainer>
                <h2>Resumo do seu pedido</h2>

                <AddressContainer>
                    <h5>Informações do Destinatário</h5>

                    <div>
                        <p><strong>Nome: </strong>{address.fullName} </p>
                        <p><strong>Localização: </strong>{address.flat} </p>
                        <p><strong>Rua: </strong>{address.area} </p>
                        <p><strong>Ponto de Referência: </strong>{address.landmark} </p>
                        <p><strong>Cidade e Estado: </strong>{address.city}, {address.state} </p>
                        <p><strong>Telefone: </strong>{address.phone}</p>
                    </div>

                </AddressContainer>

                <PaymentContainer>
                    <h5>Método de Pagamento</h5>

                    <div>
                        <p>Detalhes do Cartão</p>
                        {/* Card Element */}

                        <CardElement />
                    </div>
                </PaymentContainer>

                <OrderContainer>
                    <h5>Seu Pedido</h5>

                    <div>
                    {basket?.map((product) => (
                        <Product>
                        <Image>
                            <img src={product.image} alt="" />
                        </Image>
    
                        <Description>
                            <h4>{product.title}</h4>
    
                            <p>R$ {product.price}</p>
                         </Description>
                    </Product>
                    ))}
                    </div>
                </OrderContainer>
            </ReviewContainer>

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
                
                <button>Pagar</button>
                {/* <button onClick={confirmPayment}>Pagar</button> */}


            </Subtotal>

        </Main>

        <PaymentMethod />
        <Footer />
   </Container>
  )
}

const Container = styled.div`
    width: 100%;
    background-color: rgb(234, 237, 237);
`;


const Main = styled.div`
    padding: 15px;
    display: flex;

    @media only screen and (max-width: 1200px) {
        flex-direction: column;
    }
    
`;


const ReviewContainer = styled.div`
    background-color: #fff;
    flex: 0.7;
    padding: 15px;
    

    h2{
        font-weight: 500;
        border-bottom: 1px solid lightgray;
        padding-bottom: 15px;
    }
`;


const PaymentContainer = styled.div`
    margin-top: 15px;

    div{
        margin-top: 15px;
        margin-left: 15px;

    p{
        font-size: 14px;
    }
 }
`;

const OrderContainer = styled.div`
    margin-top: 30px;
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
        width: 50%;
        height: 33px;
        margin-top: 20px;
        background-color: orange;
        border: none;
        outline: none;
        border-radius: 8px;
    }
`;

const AddressContainer = styled.div`
    margin-top: 20px;

    div{
        margin: 15px 0 50px 10px;
    }



    p{
        font-size: 14px;
        margin-top: 4px;
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




export default Payment