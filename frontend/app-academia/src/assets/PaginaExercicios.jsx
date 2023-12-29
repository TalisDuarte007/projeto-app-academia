import React, { useEffect, useState } from 'react';
import { useLocation } from 'react-router-dom';

const PaginaExercicios = () => {
    const location = useLocation();
    const queryParams = new URLSearchParams(location.search);
    //const tipoTreino = queryParams.get('tipoTreino');
    //const detalhesTreino = JSON.parse(decodeURIComponent(queryParams.get('detalhesTreino')));
    const idTreino = queryParams.get('id');

    const [exercicios, setExercicios] = useState([]);

  useEffect(() => {
    const fetchExercicios = async () => {
        try {
          // Substitua a URL da API conforme necessário
          const response = await fetch(`http://localhost:8080/exercicios?treinoId=${idTreino}`);
          const data = await response.json();
          
          setExercicios(data);
          
        } catch (error) {
          console.error('Erro ao buscar exercícios:', error);
        }
      };
      
  
      fetchExercicios();
    }, [idTreino]);
    // Aqui você pode usar os dados do treino como necessário
    

  return (
    <div>
      <h2>Página de Exercícios</h2>
      {/* Renderizar os exercícios com base nos dados recebidos */}
    </div>
  );
};

export default PaginaExercicios;

//console.log('Tipo de Treino:', tipoTreino);
  //  console.log('Detalhes do Treino:', detalhesTreino);
    //console.log('ID do Treino:', idTreino);
  //}, [tipoTreino, detalhesTreino, idTreino]);
