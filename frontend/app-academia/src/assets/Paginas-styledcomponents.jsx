import styled from 'styled-components';

export const StyledBoxPrincipal = styled.div`
    display: flex;
    flex-direction: column;
    h2{
        font-size: 40px;
        font-style: italic;
    }
    align-items: center;
    .logo {
        height: 250px;
        width: auto;
        margin: 50px;
    }
`;

export const StyledBotoesTreinos = styled.div`
    display: flex;
    gap: 20px;
    .botao-treinos{
        cursor: pointer;
        font-family: 'Raleway', sans-serif;
        font-weight: bold;
        font-size: 20px;
        width: 200px;
        height: 50px;
        background: none;
        border-radius: 5px;
        border: 1px solid black;
    }
    .botao-treinos:hover{
        border: 2px solid black;
        font-weight: bolder;
        font-size: 24px;
    }
`;

export const StyledTBody = styled.tbody`
    tr{
        vertical-align: middle;
        td{
            padding: auto;
            vertical-align: middle;
            align-items: center;
        }
    }
`;

export const StyledModalOverlay = styled.div`
    position: fixed;
    top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.8); /* Fundo semi-transparente */
  display: flex;
  align-items: center;
  justify-content: center;
  z-index: 999;
`;

export const StyledModalContent = styled.div`
    background: #fff; /* Cor de fundo do modal */
  padding: 20px;
  border-radius: 8px;
  max-width: 400px;
  max-height: 400px;
  overflow: auto;
  position: relative;
`;

export const StyledCloseButton = styled.button`
    position: absolute;
  top: 10px;
  right: 10px;
  cursor: pointer;
  background: none;
  border: none;
  font-size: 16px;
  color: #333;

`;