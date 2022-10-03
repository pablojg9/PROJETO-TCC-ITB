import React from 'react'
import Card from './Card';
import Footer from './Footer';
import Header from './Header';
import Feature from './Feature';
import DropdownCategory from './DropdownCategory';
import styled from "styled-components";


const Category = () => {
  return (
    <Container>
      <Header />
      <DropdownCategory />

      <CategorySection>
        <Filter>
          <h1>Opções de Filtro</h1>
          
          <DropdownFilter>
              Editor
          </DropdownFilter>

        </Filter>

        <BookGrid>

        <Card
          id={1}
          image={"https://images-na.ssl-images-amazon.com/images/I/91yUtx44+AL.jpg"} 
          price={2500}
          rating={3}
          title={"Vagabond"}
          />

        <Card
          id={1}
          image={"https://images-na.ssl-images-amazon.com/images/I/91yUtx44+AL.jpg"} 
          price={2500}
          rating={3}
          title={"Vagabond"}
          />

        <Card
          id={1}
          image={"https://images-na.ssl-images-amazon.com/images/I/91yUtx44+AL.jpg"} 
          price={2500}
          rating={3}
          title={"Vagabond"}
          />

        <Card
          id={1}
          image={"https://images-na.ssl-images-amazon.com/images/I/91yUtx44+AL.jpg"} 
          price={2500}
          rating={3}
          title={"Vagabond"}
          />


        <Card
          id={1}
          image={"https://images-na.ssl-images-amazon.com/images/I/91yUtx44+AL.jpg"} 
          price={2500}
          rating={3}
          title={"Vagabond"}
          />

          <Card
          id={1}
          image={"https://images-na.ssl-images-amazon.com/images/I/91yUtx44+AL.jpg"} 
          price={2500}
          rating={3}
          title={"Vagabond"}
          />

        <Card
          id={1}
          image={"https://images-na.ssl-images-amazon.com/images/I/91yUtx44+AL.jpg"} 
          price={2500}
          rating={3}
          title={"Vagabond"}
          />


        <Card
          id={1}
          image={"https://images-na.ssl-images-amazon.com/images/I/91yUtx44+AL.jpg"} 
          price={2500}
          rating={3}
          title={"Vagabond"}
          />

          
        </BookGrid>
      </CategorySection>


      <Feature />
      <Footer />
    </Container>
  )
}

const Container = styled.div`
  max-width: 100%;
  background-color: rgb(234, 237, 237);

`;

const CategorySection = styled.div`
  margin: 0 100px 0 100px;
  max-width: 100%;
`;

const Filter = styled.div`
  width: 25%;
`;

const BookGrid = styled.div`
  width: 75%;
  display: grid;
    justify-content: center;
    place-items: center;
     margin-left: 350px;


    grid-auto-rows: 420px 420px;
    grid-template-columns: repeat(4, 300px);
    grid-gap: 20px;

/* Mobile */
    @media only screen and (max-width: 1000px) {
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

const DropdownFilter = styled.div`

`;


export default Category;

