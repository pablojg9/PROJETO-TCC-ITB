import Slider from "react-slick";
import "slick-carousel/slick/slick.css"; 
import "slick-carousel/slick/slick-theme.css";
import styled from "styled-components";

const Carousel = () => {


  const settings = {
    dots: true,
    infinite: true,
    speed: 1500,
    fade: true,
    autoplay: true,
    slidesToShow: 1,
    slidesToScroll: 1,
    initialSlide: 0,
    responsive: [
      {
        breakpoint: 1024,
        settings: {
          slidesToShow: 1,
          slidesToScroll: 1,
          infinite: true,
          dots: true,
        },
      },
      {
        breakpoint: 600,
        settings: {
          slidesToShow: 1,
          slidesToScroll: 1,
          initialSlide: 1,
        },
      },
      {
        breakpoint: 480,
        settings: {
          slidesToShow: 1,
          slidesToScroll: 1,
        },
      },
    ],
  };

return (
  <Container>
      <Slider {...settings}>
        <div>
          <img src="./banner1.png" alt="" />
        </div>
        <div>
         <img src="./Banner2.png" alt="" />
        </div>
        <div>
         <img src="./Banner3.png" alt="" />
        </div>
      </Slider>
  </Container>
);
}

const Container = styled.div`
    width: 75%;
    margin:  30px auto 90px auto;


    div{
      img{
        width: 100%;
      }
    }


    @media only screen  and (max-width: 1075px) {
      display: none;
    }
`;





export default Carousel