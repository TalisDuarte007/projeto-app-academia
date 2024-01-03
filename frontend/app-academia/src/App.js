import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import PaginaPrincipal from './assets/PaginaPrincipal';
import PaginaAluno from './assets/PaginaAluno';
import PaginaTreinos from './assets/PaginaTreinos';
import PaginaExercicios from './assets/PaginaExercicios';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<PaginaPrincipal />} />
        <Route path='/alunos/:id/treinos' element={<PaginaTreinos/>}/>
        <Route path="/alunos/:alunoId" element={<PaginaAluno />} />
        <Route path="/pagina-exercicios" element={<PaginaExercicios />} />
      </Routes>
    </Router>
  );
}

export default App;
