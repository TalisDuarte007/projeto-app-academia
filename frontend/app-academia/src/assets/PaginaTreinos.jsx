import React, { useState, useEffect } from 'react';
import { useParams, useNavigate } from 'react-router-dom';

const PaginaTreinos = () => {
  const { id } = useParams();
  const [treinos, setTreinos] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    const fetchTreinos = async () => {
      try {
        const response = await fetch(`http://localhost:8080/treinos/alunos/${id}/treinos`);
        const data = await response.json();
        setTreinos(data);
      } catch (error) {
        console.error('Erro ao buscar treinos do aluno:', error);
      }
    };

    fetchTreinos();
  }, [id]);

  const handleTreinoClick = (treino) => {
    // Navegar para a próxima página passando os dados do treino como parâmetros de consulta
    navigate(`/pagina-exercicios?tipoTreino=${treino.tipoTreino}&detalhesTreino=${encodeURIComponent(JSON.stringify(treino.detalhesTreino))}&id=${treino.id}`);
  };

  return (
    <div>
      <h2>Escolha o Treino</h2>
      <div>
        {treinos.map((treino) => (
          <div key={treino.id}>
            <button onClick={() => handleTreinoClick(treino)}>
              {treino.tipoTreino}
            </button>
          </div>
        ))}
      </div>
    </div>
  );
};

export default PaginaTreinos;
