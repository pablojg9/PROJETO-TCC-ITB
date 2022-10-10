import React, { useEffect, useState } from 'react'
import Card from './Card';
import Footer from './Footer';
import Header from './Header';
import Feature from './Feature';
import DropdownCategory from './DropdownCategory';
import styled from "styled-components";
import PaymentMethod from './PaymentMethod';
import Api from '../api/Api';

const Category = () => {

  const [category, setCategory] = useState([]);

  useEffect(() => {
    Api.get(`/api/book/category/${3}`).then((response) => {
      console.log(response.data);
      setCategory(response.data)
    }).catch((error) => {
      console.log(error);
    })
  }, [])

  return (
    <Container>
      <Header />
      <DropdownCategory />

      <CategorySection>

        <BookGrid>

          {
            category && category.map((category) => (
              <Card
                id={category.id}
                image={"https://images-na.ssl-images-amazon.com/images/I/91yUtx44+AL.jpg"}
                price={category.valueBook}
                rating={3}
                author={category.author}
                title={category.name}
                category={category.category.nameCategory}
              />
            ))

          }

        </BookGrid>

      </CategorySection>

      <Feature />

      <PaymentMethod />

      <Footer />
    </Container>
  )
}

const Container = styled.div`
  max-width: 100%;
  background-color: rgb(234, 237, 237);

`;

const CategorySection = styled.div`
  margin: 0 100px -20px 100px;
  max-width: 100%;
`;


const BookGrid = styled.div`
  width: 100%;
  display: grid;
    justify-content: center;
    place-items: center;

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


export default Category

