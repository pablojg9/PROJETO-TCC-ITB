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
          slidesToShow: 2,
          slidesToScroll: 2,
          initialSlide: 2,
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
          <img src="./c1.png" alt="" />
        </div>
        <div>
         <img src="./c2.png" alt="" />
        </div>
        <div>
         <img src="./c3.png" alt="" />
        </div>
        <div>
         <img src="./c4.png" alt="" />
        </div>
        <div>
          <img src="./c5.png" alt="" />
        </div>
      </Slider>
  </Container>
);
}

const Container = styled.div`
    width: 70%;
    margin:  -40px auto 90px auto;


    div{
      img{
        width: 100%;
      }
    }


    @media only screen  and (max-width: 767px) {
      display: none;
    }
`;





export default Carousel