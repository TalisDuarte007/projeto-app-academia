import React from 'react';

const TabelaTreino = ({ treino }) => {
  // Verifique se 'treino' está definido e tem a propriedade 'exercicios'
  if (!treino || !treino.exercicios) {
    return <p>Nenhum treino disponível.</p>;
  }

  return (
    <table>
      <thead>
        <tr>
          <th>Exercício</th>
          <th>Séries</th>
          <th>Repetições</th>
        </tr>
      </thead>
      <tbody>
        {treino.exercicios.map((exercicio, index) => (
          <tr key={index}>
            <td>{exercicio.nome}</td>
            <td>{exercicio.series}</td>
            <td>{exercicio.repeticoes}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
};

export default TabelaTreino;
