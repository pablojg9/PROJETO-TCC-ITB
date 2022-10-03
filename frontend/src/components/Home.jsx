import React from 'react'
import styled from 'styled-components';
import Card from './Card';
import Footer from './Footer';
import Header from './Header';
import Carousel from './Carousel';
import Feature from './Feature';
import DropdownCategory from './DropdownCategory';



function Home() {
  
  return (
    <Container>
        <Header />

        <DropdownCategory />
     

       <Carousel />

        <Main>
          <Card
          id={1}
          image={"https://images-na.ssl-images-amazon.com/images/I/91yUtx44+AL.jpg"} 
          price={2500}
          rating={3}
          title={"Vagabond"}
          />

          <Card 
          id={2}
           image={"https://images-na.ssl-images-amazon.com/images/I/91yUtx44+AL.jpg"} 
           price={2500}
           rating={3}
           title={"Vagabond"}
           />

          <Card 
          id={3}
           image={"https://images-na.ssl-images-amazon.com/images/I/91yUtx44+AL.jpg"} 
           price={2500}
           rating={3}
           title={"Vagabond"}
          />

          <Card 
           id={4}
           image={"https://images-na.ssl-images-amazon.com/images/I/91yUtx44+AL.jpg"} 
           price={2500}
           rating={3}
           title={"Vagabond"}
           />
           
          <Card 
           id={5}
           image={"https://images-na.ssl-images-amazon.com/images/I/91yUtx44+AL.jpg"} 
           price={2500}
           rating={3}
           title={"Vagabond"}
           />

          <Card
           id={6}
           image={"https://images-na.ssl-images-amazon.com/images/I/91yUtx44+AL.jpg"} 
           price={2500}
           rating={3}
           title={"Vagabond"}
           />

          <Card 
           id={7}
           image={"https://images-na.ssl-images-amazon.com/images/I/91yUtx44+AL.jpg"} 
           price={2500}
           rating={3}
           title={"Vagabond"}
          />

          <Card 
           id={8}
           image={"https://images-na.ssl-images-amazon.com/images/I/91yUtx44+AL.jpg"} 
           price={2500}
           rating={3}
           title={"Vagabond"}
          />
          
        </Main>

        <Feature />

       <Footer />
    </Container>
  )
}

const Container = styled.div`
    width: 100%;
    background-color: rgb(234, 237, 237);
`;

const Main = styled.div`
    display: grid;
    justify-content: center;
    place-items: center;
    width: 100%;

    grid-auto-rows: 420px 420px;
    grid-template-columns: repeat(4, 300px);
    grid-gap: 20px;

/* Mobile */
    @media only screen and (max-width: 767px) {
      grid-template-columns: repeat(2, 50%);
      grid-gap: 10px;
    }

    @media only screen and (max-width: 540px) {
      flex-direction: column;
      grid-template-columns: repeat(1, 100%);
    }

/* Tablet */
      @media only screen and (min-width: 767px) and (max-width: 1200px) {
      grid-template-columns: repeat(3, 30%);
    }

 
`;


export default Home