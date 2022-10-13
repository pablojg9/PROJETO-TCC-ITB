import styled from 'styled-components';


function PaymentMethod() {
  return (
    <Container>
        <PaymentImage>
          <span>Meios de Pagamento</span>
          <img src="/meiosdepagamento.png/" alt="" />
        </PaymentImage>
    </Container>
  )
}

const Container = styled.div`
    width: 100%;
`;

const PaymentImage = styled.div`
display: flex;
flex-direction: column;
align-items: center;
justify-content: center;
margin-top: 100px;

span{
  color: #818488;
  margin-bottom: 3px;
  font-size: 14px;
}

img{
  width: 400px;
}
`;

export default PaymentMethod