import styled from "styled-components";
// import React, { useEffect, useState } from "react";
import Header from './Header';
import Footer from './Footer';
import PaymentMethod from './PaymentMethod';

// import axios from "../axios"
// import { useStateValue } from "../StateProvider";

function Orders() {
  // const [{ user }] = useStateValue();
  //   const [orders, setOrders] = useState([])

  // useEffect(() => {

  //   axios.post("/orders/get", { email: user.email } )
  //   .then((res) => setOrders(res.data));

  // }, []);
  // console.log(orders);


  return (
    <Container>
        <Header />
        {/* <Main>
            <OrderContainer>
              <h2>Seus Pedidos</h2>

              {
                orders.map((orders) => (
                  <OrderDetail>
                  <AdressComponent>
                    <h4>Endereço de Envio</h4>

                    <div>
                        <p>{order.address.fullName}</p>
                        <p>{order.address.area}</p>
                        <p>{order.address.landmark}</p>

                        <p>
                          {order.address.city}
                          {order.address.state}
                        </p>
                        <p>Telefone: {order.address.phone}</p>
                    </div>
                  </AdressComponent>

                  <OrderBasket>
                    <h4>Pedidos</h4>
                    <p>Valor Total : R$ <span>{order.price}</span></p>

                    {order.products.map((product) => (
                        <Product>
                        <Image>
                            <img src={product.image} alt="" />
                        </Image>
    
                        <Description>
                            <h4>{product.title}</h4>
    
                            <p>R$ {prodcut.price}</p>
                         </Description>
                    </Product>
                      ))}

                  </OrderBasket>
              </OrderDetail>
                ))}

              
            </OrderContainer>
        </Main> */}
      <PaymentMethod />
      
      <Footer />

    </Container>
  )
}

const Container = styled.div`
  max-width: 100%;
  height: fit-content;

  margin: auto;
  background-color: rgb(234, 237, 237);
`;

// const Main = styled.div`
//   min-width: 100vw;
//   min-height: 100vh;
//   display: flex;
//   justify-content: center;
// `;

// const OrderContainer = styled.div`
//   padding: 15px;
//   margin-top: 15px;

//   background-color: #fff;
//   width: 95%;

//   h2{
//     font-weight: 500;
//     border-bottom: 1px solid lightgray;
//     padding-bottom: 15px
//   }
// `;

// const OrderDetail = styled.div`
//   border-bottom: 1px solid lightgray;
//   padding-bottom: 20px;
// `;

// const AdressComponent = styled.div`
//   margin-top: 20px;

//   div{
//     margin-top: 10px;
//     margin-left: 10px;
//   }

//   p{
//     font-size: 14px;
//     margin-top: 4px;
//   }
// `;

// const OrderBasket = styled.div`
//   margin-top: 20px;
  
//   p{
//     font-size: 15px;
//     margin-top: 15px;
//     margin-top: 15px;
//   }

//   span{
//     font-weight: 600;
//   }
// `;

// const Product = styled.div`
//     display: flex;
//     align-items: center;
// `;

// const Image = styled.div`
//     margin-top: 10px;
//     flex: 0.2;

//     img{
//         width: 70%;
//     }

//     @media only screen and (max-width: 1200px) {
//       img{
//         width: 100%;
//       }
//     }
// `;

// const Description = styled.div`
//     flex: 0.7;
//     padding-left: 10px;
    
//     h4{
//         font-weight: 600;
//         font-size: 18px;

//      @media only screen and (max-width: 1400px) {
//       font-size: 16px;
//     }

//     p{
//         font-weight: 600;
//         margin-top: 10px;
//     }
// `;

export default Orders