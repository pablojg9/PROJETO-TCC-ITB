import React from 'react'
import styled from 'styled-components';

function Feature() {
  return (
    <Container>
        <FeatureContent>
            <BgSVG>
                <svg class="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M13 10V3L4 14h7v7l9-11h-7z"></path></svg>
            </BgSVG>
            <FeatureText>
                <FeatureTitle>Entrega Rápida</FeatureTitle>
                <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Optio repudiandae voluptate hic aliquid fugiat praesentiu</p>
            </FeatureText>
        </FeatureContent>
        <FeatureContent>
            <BgSVG>
                <svg class="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M14 10h4.764a2 2 0 011.789 2.894l-3.5 7A2 2 0 0115.263 21h-4.017c-.163 0-.326-.02-.485-.06L7 20m7-10V5a2 2 0 00-2-2h-.095c-.5 0-.905.405-.905.905 0 .714-.211 1.412-.608 2.006L7 11v9m7-10h-2M7 20H5a2 2 0 01-2-2v-6a2 2 0 012-2h2.5"></path></svg>
            </BgSVG>
                <FeatureText>
                    <FeatureTitle>Pagamento Seguro</FeatureTitle>
                    <p>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Voluptatibus obcaecati dolorem </p>
                </FeatureText>
        </FeatureContent>
        <FeatureContent>
            <BgSVG>
                <svg class="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 12l2 2 4-4m5.618-4.016A11.955 11.955 0 0112 2.944a11.955 11.955 0 01-8.618 3.04A12.02 12.02 0 003 9c0 5.591 3.824 10.29 9 11.622 5.176-1.332 9-6.03 9-11.622 0-1.042-.133-2.052-.382-3.016z"></path></svg>
            </BgSVG>
                <FeatureText>
                    <FeatureTitle>Melhor Qualidade</FeatureTitle>
                    <p>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Quam nulla explicabo </p>
                </FeatureText>
        </FeatureContent>
        <FeatureContent>
            <BgSVG>
                <svg class="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M11.049 2.927c.3-.921 1.603-.921 1.902 0l1.519 4.674a1 1 0 00.95.69h4.915c.969 0 1.371 1.24.588 1.81l-3.976 2.888a1 1 0 00-.363 1.118l1.518 4.674c.3.922-.755 1.688-1.538 1.118l-3.976-2.888a1 1 0 00-1.176 0l-3.976 2.888c-.783.57-1.838-.197-1.538-1.118l1.518-4.674a1 1 0 00-.363-1.118l-3.976-2.888c-.784-.57-.38-1.81.588-1.81h4.914a1 1 0 00.951-.69l1.519-4.674z"></path></svg>
            </BgSVG>
                <FeatureText>
                    <FeatureTitle>Garantia de Retorno</FeatureTitle>
                    <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Itaque dignissimos </p>
                </FeatureText>
        </FeatureContent>
</Container>
  )
}


const Container = styled.div`
    width: 100%;
    height: 250px;
    margin-top: 100px;
    display: grid;
    grid-auto-flow: column;    
    justify-content: space-evenly;
    align-items: center;


    @media only screen and (max-width: 1300px) {
      grid-template-rows: repeat(2, 50%);
      grid-gap: 0;
      padding: 40px 0 40px 0;
    }

    @media only screen and (max-width: 827px){
       display: block;    
       height: 600px;

    }

`;



const FeatureContent = styled.div`
    display: flex;
    width: 320px;
    height: 100px;
    padding-top: 8px;

    @media only screen and (max-width: 827px){
        padding: 25px;
        margin: auto;
    }
`;

const BgSVG = styled.div`
    display: flex;
    justify-content: center;
    align-items: center;
    width: 120px;
    padding: 2px;
    height: 50px;
    background-color: #6C5DD3;
    margin-top: 15px;
    border-radius: 100px;

    svg{
        height:30px;
    }
`;

const FeatureText = styled.div`
    margin-left: 20px;

    p{
        margin-top: 5px;
    }
`;

const FeatureTitle = styled.span`
    font-size: 15px;
    font-weight: bold;
`;




export default Feature