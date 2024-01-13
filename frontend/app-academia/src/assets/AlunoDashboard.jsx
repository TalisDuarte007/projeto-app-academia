import React, { useState, useEffect } from 'react';
import TabelaTreino from '../components/TabelaTreino';

const PaginaAluno = ({ match }) => {
  const alunoId = match?.params?.id;
  const [treino, setTreino] = useState({});

  useEffect(() => {
    const fetchTreino = async () => {
      try {
        if (alunoId) {
          const response = await fetch(`http://localhost:8080/alunos/${alunoId}/treino`);
          const data = await response.json();
          setTreino(data);
        }
      } catch (error) {
        console.error('Erro ao buscar treino do aluno:', error);
      }
    };

    fetchTreino();
  }, [alunoId]);

  return (
    <div>
      <h2>Página do Aluno</h2>
      <h3>Treino do Aluno</h3>
      {alunoId ? (
        <TabelaTreino treino={treino} />
      ) : (
        <p>Selecione um aluno para visualizar o treino.</p>
      )}
    </div>
  );
};

export default PaginaAluno;
