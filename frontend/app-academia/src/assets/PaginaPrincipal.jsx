import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import api from '../services/apiConfig';
import { StyledBoxPrincipal } from './Paginas-styledcomponents';
import dragaoVermelho from '../views/images/dragao_vermelho.png';
import '../autosugest.css';

const PaginaPrincipal = () => {
  const navigate = useNavigate();
  const [email, setEmail] = useState('');
  const [senha, setSenha] = useState('');

  const handleLogin = async () => {
    try {
      const response = await api.post('/auth/login', { email, senha });
      const token = response.data.token;
      localStorage.setItem('token', token);

      // console.log(response.data.user.role)
      // console.log(response.data.user.id)

      // Obter informações sobre o usuário a partir do token ou fazer outra chamada à API
      const userRole = response.data.user.role;

      // Redirecionar com base na ROLE
      if (userRole === 'PROFESSOR') {
        navigate(`/dashboard-professor/${response.data.user.id}`);
      } else if (userRole === 'ALUNO') {
        navigate(`/dashboard-aluno/${response.data.user.id}`);
      } else {
        alert('Role não reconhecida. Contate o suporte.');
      }
    } catch (error) {
      alert('Credenciais inválidas. Tente novamente.');
    }
  };

  return (
    <StyledBoxPrincipal>
      <img className='logo' src={dragaoVermelho} alt="" />
      <h2>Academia Red Dragon</h2>

      <label htmlFor="email">Email:</label>
      <input
        type="email"
        id="email"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
      />

      <label htmlFor="senha">Senha:</label>
      <input
        type="password"
        id="senha"
        value={senha}
        onChange={(e) => setSenha(e.target.value)}
      />

      <button onClick={handleLogin}>Login</button>
    </StyledBoxPrincipal>
  );
};

export default PaginaPrincipal;
