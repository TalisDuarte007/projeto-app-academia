import { useLocation } from 'react-router-dom';

const PaginaExercicios = () => {
    const location = useLocation();
    const queryParams = new URLSearchParams(location.search);
    const detalhesTreino = JSON.parse(decodeURIComponent(queryParams.get('detalhesTreino')));    
  return (
    <div>
      <h2>Página de Exercícios</h2>
      {detalhesTreino.map((exercicio, index) => (
        <div key={index}>
          <p>Exercicio: {exercicio.exercicio.nome}</p>
          <p>Séries: {exercicio.series}</p>
          <p>Repetições: {exercicio.repeticoes}</p>
        </div>
      ))}
    </div>
  );
};

export default PaginaExercicios;
