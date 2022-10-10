import Slider from "react-slick";
import "slick-carousel/slick/slick.css"; 
import "slick-carousel/slick/slick-theme.css";
import styled from "styled-components";
import Card from './Card';

function BookCarousel() {

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
    <h1>Mais Populares</h1>
    <Slider {...settings}>
    <CardContainer>
        <Card
          id={1}
          image={"https://www.jbchost.com.br/editorajbc/wp-content/uploads/2017/07/your-name.-01-Capa_p.jpg"}
          price={50}
          rating={3}
          title={"Your Name"}
          />
    </CardContainer>

    <CardContainer>
        <Card
          id={1}
          image={"https://images-na.ssl-images-amazon.com/images/I/91yUtx44+AL.jpg"}
          price={50}
          rating={3}
          title={"Naruto"}
          />
    </CardContainer>

    <CardContainer>
        <Card
          id={1}
          image={"https://i.pinimg.com/564x/bd/20/ff/bd20ffd0ab9412692d4156d25a230e01.jpg"}
          price={50}
          rating={3}
          title={"Berserk"}
          />
    </CardContainer>

    <CardContainer>
        <Card
          id={1}
          image={"https://trecobox.com.br/wp-content/uploads/2020/07/jujutsu-kaisen-vol-1-capa-panini.jpg"}
          price={50}
          rating={3}
          title={"Jujutsu Kaisen"}
          />
    </CardContainer>

    <CardContainer>
        <Card
          id={1}
          image={"https://i0.wp.com/otakusbrasil.com/wp-content/uploads/2021/02/Fire-Force-1.jpg?resize=685%2C1024&ssl=1"}
          price={50}
          rating={3}
          title={"Fire Force"}
          />
    </CardContainer>

    <CardContainer>
        <Card
          id={1}
          image={"https://images-na.ssl-images-amazon.com/images/I/91yUtx44+AL.jpg"}
          price={50}
          rating={3}
          title={"Naruto"}
          />
    </CardContainer>

    <CardContainer>
        <Card
          id={1}
          image={"https://images-na.ssl-images-amazon.com/images/I/91yUtx44+AL.jpg"}
          price={50}
          rating={3}
          title={"Naruto"}
          />
    </CardContainer>

    <CardContainer>
        <Card
          id={1}
          image={"https://images-na.ssl-images-amazon.com/images/I/91yUtx44+AL.jpg"}
          price={50}
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
    margin: 50px 200px 10px 200px;
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

export default BookCarousel