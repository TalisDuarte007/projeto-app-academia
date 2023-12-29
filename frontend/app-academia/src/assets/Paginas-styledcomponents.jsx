import styled from 'styled-components';

export const StyledBoxPrincipal = styled.div`
    display: flex;
    flex-direction: column;
    h2{
        font-size: 40px;
        font-style: italic;
    }
    align-items: center;
    img {
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