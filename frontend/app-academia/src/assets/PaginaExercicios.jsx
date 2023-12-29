import { useLocation } from 'react-router-dom';
import { StyledBoxPrincipal } from './Paginas-styledcomponents';
import dragaoVermelho from '../views/images/dragao_vermelho.png';
import './table.css'

const PaginaExercicios = () => {
    const location = useLocation();
    const queryParams = new URLSearchParams(location.search);
    const detalhesTreino = JSON.parse(decodeURIComponent(queryParams.get('detalhesTreino')));
    const tipoTreino = queryParams.get('tipoTreino');

    console.log(tipoTreino)

  return (
    <StyledBoxPrincipal>
      <img src={dragaoVermelho} alt="" />
      <h2>Treino de {tipoTreino}</h2>
      <table>
        <thead>
          <tr>
            <th>Exercício</th>
            <th>Séries</th>
            <th>Repetições</th>
            <th>Descanso</th>
            <th>Exemplo</th>
            <th>Carga</th>
          </tr>   
        </thead>
        <tbody>
        {detalhesTreino.map((exercicio, index) => (
          <tr key={index}>
            <td>{exercicio.exercicio.nome}</td>
            <td>{exercicio.series}</td>
            <td>{exercicio.repeticoes}</td>
            <td>{}</td>
            <td>{}</td>
            <td>{}</td>
          </tr>
        ))}
        </tbody>
      </table>
    </StyledBoxPrincipal>
  );
};

export default PaginaExercicios;
