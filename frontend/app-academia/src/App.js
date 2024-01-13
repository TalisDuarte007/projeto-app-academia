import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import PaginaPrincipal from './assets/PaginaPrincipal';
import AlunoDashboard from './assets/AlunoDashboard';
import PaginaTreinos from './assets/PaginaTreinos';
import PaginaExercicios from './assets/PaginaExercicios';
import ProfessorDashboard from './assets/ProfessorDashboard';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<PaginaPrincipal />} />
        <Route path="/dashboard-professor/:id" element={<ProfessorDashboard />} />
        
        <Route path="/dashboard-aluno/:id" element={<AlunoDashboard />} />

        <Route path='/alunos/:id/treinos' element={<PaginaTreinos/>}/>
        <Route path="/pagina-exercicios" element={<PaginaExercicios />} />
      </Routes>
    </Router>
  );
}

export default App;
