// import React from 'react';

// const TabelaTreino = ({ treino }) => {
//   // Verifique se 'treino' está definido e tem a propriedade 'exercicios'
//   if (!treino || !treino.exercicios) {
//     return <p>Nenhum treino disponível.</p>;
//   }

//   return (
//     <table>
//         <thead>
//           <tr>
//             <th>Exercício</th>
//             <th>Séries</th>
//             <th>Repetições</th>
//             <th>Descanso</th>
//             <th>Carga</th>
//             <th>Exemplo</th>
//           </tr>
//         </thead>
//         <tbody>
//           {detalhesTreino.map((exercicio, index) => (
//             <tr key={index}>
//               <td>{exercicio.exercicio.nome}</td>
//               <td>{exercicio.series}</td>
//               <td>{exercicio.repeticoes}</td>
//               <td>{exercicio.descanso}s</td>
//               <td>{exercicio.carga}kg</td>
//               <td>
//                 <button className='btn' onClick={() => openModal(exercicio.exercicio.link_gif)}>
//                   <img className='btnVideo' src={btnVideo} alt="" />
//                 </button>
//               </td>
//             </tr>
//           ))}
//         </tbody>
//       </table>
//   );
// };

// export default TabelaTreino;
