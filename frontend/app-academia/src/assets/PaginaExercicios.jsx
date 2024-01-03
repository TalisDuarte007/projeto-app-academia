import React, { useState } from 'react';
import { useLocation } from 'react-router-dom';
import { StyledBoxPrincipal, StyledModalOverlay, StyledModalContent, StyledCloseButton } from './Paginas-styledcomponents';
import dragaoVermelho from '../views/images/dragao_vermelho.png';
import btnVideo from '../views/images/icons8-botão-_play_-dentro-de-um-círculo-50.png';
import './table.css';

const PaginaExercicios = () => {
  const location = useLocation();
  const queryParams = new URLSearchParams(location.search);
  const detalhesTreino = JSON.parse(decodeURIComponent(queryParams.get('detalhesTreino')));
  const idTreino = queryParams.get('id');
  const alunoId = queryParams.get('alunoId');
  const tipoTreino = queryParams.get('tipoTreino');

  const [modalVisible, setModalVisible] = useState(false);
  const [selectedGifLink, setSelectedGifLink] = useState('');
  const [exercicioId, setExercicioId] = useState('');
  const [isEditModalOpen, setIsEditModalOpen] = useState(false);
  const [novaCarga, setNovaCarga] = useState('');

  const openModal = (link) => {
    setSelectedGifLink(link);
    setModalVisible(true);
    setIsEditModalOpen(false);
  };

  const closeModal = () => {
    setSelectedGifLink('');
    setModalVisible(false);
  };

  const openEditModal = (id) => {
    setExercicioId(id)
    setIsEditModalOpen(true);
    setModalVisible(false);
  };
  
  const closeEditModal = () => {
    setIsEditModalOpen(false);
  };

  const handleSalvarClick = async (treinoId, exercicioId, novaCarga) => {

    try {
      const response = await fetch(
        `http://localhost:8080/treinos/alunos/${alunoId}/treinos/${treinoId}/exercicio/${exercicioId}`,
        {
          method: 'PUT',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify({ carga: novaCarga }),
        }
      );
  
      if (response.ok) {
        console.log('Carga atualizada com sucesso!');
      } else {
        console.error('Falha ao atualizar a carga.');
      }
    } catch (error) {
      console.error('Erro ao fazer a requisição:', error);
    }
  
    // Fechar o modal de edição após a conclusão da requisição.
    closeEditModal();
  };
  
  

  return (
    <StyledBoxPrincipal>
      <img className='logo' src={dragaoVermelho} alt="" />
      <h2>Treino de {tipoTreino}</h2>
      <table>
        <thead>
          <tr>
            <th>Exercício</th>
            <th>Séries</th>
            <th>Repetições</th>
            <th>Descanso</th>
            <th>Carga</th>
            <th>Exemplo</th>
          </tr>
        </thead>
        <tbody>
          {detalhesTreino.map((exercicio, index) => (
            <tr key={index}>
              <td>{exercicio.exercicio.nome}</td>
              <td>{exercicio.series}</td>
              <td>{exercicio.repeticoes}</td>
              <td>{exercicio.descanso}s</td>
              <td>
                <button className='btn' onClick={() => openEditModal(exercicio.id)}>
                  {exercicio.carga}kg
                </button>
              </td>
              <td>
                <button className='btn' onClick={() => openModal(exercicio.exercicio.link_gif)}>
                  <img className='btnVideo' src={btnVideo} alt="" />
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>

      {modalVisible && (
        <StyledModalOverlay>
          <StyledModalContent>
            <StyledCloseButton onClick={closeModal}>
              X
            </StyledCloseButton>
            <img src={selectedGifLink} alt="GIF" />
          </StyledModalContent>
        </StyledModalOverlay>
      )}

      {isEditModalOpen && (
        <StyledModalOverlay>
          <StyledModalContent>
            <StyledCloseButton onClick={closeEditModal}>
              X
            </StyledCloseButton>
            <form action="">
              <span>Informe a nova Carga do exercício:</span>
              <input
                type="number"
                name="novaCarga"
                id=""
                placeholder="35"
                value={novaCarga}
                onChange={(e) => setNovaCarga(e.target.value)}
              />
            </form>
            <button onClick={() => handleSalvarClick(idTreino, exercicioId, novaCarga)}>Salvar</button>
          </StyledModalContent>
        </StyledModalOverlay>
      )}
    </StyledBoxPrincipal>
  );
};

export default PaginaExercicios;
