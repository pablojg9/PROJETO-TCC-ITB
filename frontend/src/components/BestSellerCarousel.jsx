import Slider from "react-slick";
import "slick-carousel/slick/slick.css"; 
import "slick-carousel/slick/slick-theme.css";
import styled from "styled-components";
import Card from './Card';

const BestSellerCarousel = () => {
    const settings = {
        dots: true,
        infinite: false,
        speed: 500,
        slidesToShow: 5,
        slidesToScroll: 5,
        initialSlide: 0,
        responsive: [
          {
            breakpoint: 1324,
            settings: {
              slidesToShow: 3,
              slidesToScroll: 3,
              infinite: true,
              dots: true
            }
          },
          {
            breakpoint: 1150,
            settings: {
              slidesToShow: 2,
              slidesToScroll: 2,
              initialSlide: 2
            }
          },
          {
            breakpoint: 750,
            settings: {
              slidesToShow: 1,
              slidesToScroll: 2,
              initialSlide: 2
            }
          },
          {
            breakpoint: 480,
            settings: {
              slidesToShow: 1,
              slidesToScroll: 1
            }
          }
        ]
      };
    
      return (
        <Container>
        <h1>Mais Vendidos</h1>
        <Slider {...settings}>
        <CardContainer>
            <Card
              id={1}
              image={"https://m.media-amazon.com/images/I/71Ils+Co9fL.jpg"}
              price={40}
              rating={3}
              title={"Mindset"}
              />
        </CardContainer>
    
        <CardContainer>
            <Card
              id={1}
              image={"https://veja.abril.com.br/wp-content/uploads/2017/11/capa-pai-rico-pai-pobre.png"}
              price={40}
              rating={3}
              title={"Pai Rico Pai Pobrez "}
              />
        </CardContainer>
    
        <CardContainer>
            <Card
              id={1}
              image={"https://m.media-amazon.com/images/I/710evbXqM2L.jpg"}
              price={40}
              rating={3}
              title={"Sapiens"}
              />
        </CardContainer>
    
        <CardContainer>
            <Card
              id={1}
              image={"https://m.media-amazon.com/images/I/91QSDmqQdaL.jpg"}
              price={40}
              rating={3}
              title={"O Código Da Vinci"}
              />
        </CardContainer>
    
        <CardContainer>
            <Card
              id={1}
              image={"https://m.media-amazon.com/images/I/81XTXQEVPlL.jpg"}
              price={40}
              rating={3}
              title={"O poder do Hábito"}
              />
        </CardContainer>
    
        <CardContainer>
            <Card
              id={1}
              image={"https://images-na.ssl-images-amazon.com/images/I/91yUtx44+AL.jpg"}
              price={40}
              rating={3}
              title={"Naruto"}
              />
        </CardContainer>
    
        <CardContainer>
            <Card
              id={1}
              image={"https://images-na.ssl-images-amazon.com/images/I/91yUtx44+AL.jpg"}
              price={40}
              rating={3}
              title={"Naruto"}
              />
        </CardContainer>
    
        <CardContainer>
            <Card
              id={1}
              image={"https://images-na.ssl-images-amazon.com/images/I/91yUtx44+AL.jpg"}
              price={40}
              rating={3}
              title={"Naruto"}
              />
        </CardContainer>
      
        </Slider>        
    </Container>
      )
    }
    
    
    const Container = styled.div`
        max-width: 100%;
        margin: 10px 200px 100px 200px;
        height: 600px;
    
    
        h1{
            margin-bottom: 25px;
        }
    `;
    
    const CardContainer = styled.div`
        height: 420px;  
        max-width: 270px;
        padding-bottom: 10px;
    `;

export default BestSellerCarousel