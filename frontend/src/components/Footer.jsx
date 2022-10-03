import React from 'react'
import styled  from 'styled-components';
import { useNavigate } from 'react-router-dom';
import { BsFacebook, BsYoutube, BsTwitter, BsInstagram } from 'react-icons/bs';

function Footer() {

    const navigate = useNavigate()

  return (
    <Container>
        <SocialContainer>
            <Logo onClick={() => navigate('/')}>
                <img src="./logo.png" alt="" />
            </Logo>           
                        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Autem assumenda suscipit recusandae ipsa omnis excepturi itaque incidunt perferendis repellendus cum voluptate similique obcaecati, dolores commodi laboriosam magni aliquam qui? Nulla!</p>
                        <h5>Siga-nos</h5>
                        
                        <Socials>
                            <div> <BsFacebook /></div>
                            <div><BsYoutube  /></div>
                            <div><BsTwitter /></div>
                            <div><BsInstagram /></div>
                        </Socials>
        </SocialContainer>

        <Categories>
            <h5>Categoria de Livros</h5>

            <CategoriesList>
                <span>Ação</span>
                <span>Aventura</span>
                <span>Comédia</span>
                <span>Crime</span>
                <span>Drama</span>
                <span>Ficção</span>
                <span>Mangá</span>
                <span>Mistério</span>
                <span>Romance</span>
                <span>Terror</span>
                <span></span>
                <span>Veja Mais ></span>
            </CategoriesList>
        </Categories>

        <QuickLinks>
                <h5>Company</h5>

                <span>Sobre Nós</span>
                <span>Contate-nos</span>
                <span>Login</span>
                <span>Cadastre-se</span>
                <span>Privacidade</span>
                <span>Termos de Serviço</span>
            </QuickLinks>
    </Container>
  )
}

const Container = styled.div`
    max-width: 100%;
    height: 100%;
    padding: 50px;
    margin-top: 100px;
    background-color: #131921;
    display: flex;
    justify-content: center;
    align-items: center;

    @media only screen and (max-width: 767px){
        flex-direction: column;
        align-items: flex-start;
}


`;

const SocialContainer = styled.div`
    width: 20%;
    color: white;

    h5{
        margin-top: 20px;
    }

    @media only screen and (max-width: 767px){
        width: 50%;
        margin-top: 50px;
        margin-left: 100px;
    }

    @media only screen and (max-width: 1200px){
        margin-top: 100px;
        height: 100%;

    }
`;



const Logo = styled.div`
        margin-bottom: 30px;
        cursor: pointer;

    img{
        width: 50px;
    }
`;

const Socials = styled.div`
   width: 70%;
   display: flex;
   justify-content: space-between;
   margin-top: 30px;
`;



const Categories = styled.div`
    margin-top: 10px;
    margin-left: 100px;
    
    @media only screen and (max-width: 767px){
       margin-top: 100px;
    }
   
`;

const CategoriesList = styled.div`
    display: grid;
    flex-direction: column;
    margin-top: 20px;

    grid-auto-rows: auto ;
    grid-template-columns: repeat(2, 100px);
    grid-gap: 15px;

    span{
        cursor: pointer;
        color: #FFF;
        font-size: 1rem;
    }
`;

const QuickLinks = styled.div`
    display: flex;
    flex-direction: column;
    margin-left: 100px;

    h5{
        margin-bottom: 15px;
    }

    span{
        cursor: pointer;
        color: #FFF;
        margin-bottom: 12px;
        font-size: 1rem;
    
    }


    @media only screen and (max-width: 767px){
       margin-top: 90px;
       margin-bottom: 100px;
    }
`;

export default Footer;