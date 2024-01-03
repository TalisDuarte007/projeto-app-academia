import React, { useState, useEffect } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { StyledBoxPrincipal, StyledBotoesTreinos } from './Paginas-styledcomponents';
import dragaoVermelho from '../views/images/dragao_vermelho.png';

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
    console.log(id)
    navigate(`/pagina-exercicios?tipoTreino=${treino.tipoTreino}&detalhesTreino=${encodeURIComponent(JSON.stringify(treino.detalhesTreino))}&id=${treino.treinoId}&alunoId=${id}`);
  };

  return (
    <StyledBoxPrincipal>
      <img className='logo' src={dragaoVermelho} alt="" />
      <h2>Escolha o Treino</h2>
      <StyledBotoesTreinos>
        {treinos.map((treino) => (
          <div key={treino.id}>
            <button className='botao-treinos' onClick={() => handleTreinoClick(treino)}>
              {treino.tipoTreino}
            </button>
          </div>
        ))}
      </StyledBotoesTreinos>
    </StyledBoxPrincipal>
  );
};

export default PaginaTreinos;
