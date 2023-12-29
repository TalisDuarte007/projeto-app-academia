import React from 'react';
import { useNavigate } from 'react-router-dom';
import PesquisaAlunos from '../components/PesquisaAlunos';
import { StyledBoxPrincipal } from './Paginas-styledcomponents';
import dragaoVermelho from '../views/images/dragao_vermelho.png';
import '../autosugest.css';


const PaginaPrincipal = () => {
  const navigate = useNavigate();

  const handleSelectAluno = (alunoId) => {
    navigate(`/alunos/${alunoId}/treinos`);
  };

  return (
    <StyledBoxPrincipal>
      <img src={dragaoVermelho} alt="" />
      <h2>Academia Red Dragon</h2>
      <PesquisaAlunos onSelectAluno={handleSelectAluno} />
    </StyledBoxPrincipal>
  );
};

export default PaginaPrincipal;
