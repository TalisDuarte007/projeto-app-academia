import React from 'react';
import { useNavigate } from 'react-router-dom';
import PesquisaAlunos from '../components/PesquisaAlunos';

const PaginaPrincipal = () => {
  const navigate = useNavigate();

  const handleSelectAluno = (alunoId) => {
    // Navegar para a página de treinos com o ID do aluno
    navigate(`/alunos/${alunoId}/treinos`);
  };

  return (
    <div>
      <h2>Página Principal</h2>
      <PesquisaAlunos onSelectAluno={handleSelectAluno} />
    </div>
  );
};

export default PaginaPrincipal;
