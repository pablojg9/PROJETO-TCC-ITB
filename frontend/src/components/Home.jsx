import React, { useState, useEffect } from 'react';

import styled from 'styled-components';
import Card from './Card';
import Footer from './Footer';
import Header from './Header';
import Carousel from './Carousel';
import Feature from './Feature';
import DropdownCategory from './DropdownCategory';
import BookCarousel from './BookCarousel';
import BestSellerCarousel from './BestSellerCarousel';
import PaymentMethod from './PaymentMethod';
import Api from '../api/Api';

const Home = () => {

  const [livros, setLivros] = useState("");

  useEffect(() => {
    Api.get("/api/book").then((response) => {
      setLivros(response.data);
    })
  }, [])

  return (
    <Container>
      <Header />

      <DropdownCategory/>

      <Carousel />

      <Main>
        {
          livros && livros.map((livro) => (
            <Card
              id={livro.id}
              image={"https://books.google.com.br/books/publisher/content?id=hjcQCwAAQBAJ&hl=pt-BR&pg=PP1&img=1&zoom=3&bul=1&sig=ACfU3U0MuXkWY6t7UZcHk_zr0rBIUtBhwQ&w=1280"}
              price={livro.valueBook}
              rating={3}
              title={livro.name}
              author={livro.author}
              category={livro.category.nameCategory}
            />
          ))
        }

      </Main>

      <Feature />

      <BookCarousel />

      <BestSellerCarousel />

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




export default Home;