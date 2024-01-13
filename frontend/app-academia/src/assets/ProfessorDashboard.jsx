import React, { useEffect, useState } from 'react';
import api from '../services/apiConfig';
import { useParams } from 'react-router-dom';
import { StyledModalOverlay, StyledModalContent, StyledCloseButton } from './Paginas-styledcomponents';

const ProfessorDashboard = () => {
  const [cadastroNovoAlunoVisible, setCadastroNovoAlunoVisible] = useState(false);
  const [cadastroNovoProfessorVisible, setCadastroNovoProfessorVisible] = useState(false);
  const [usuario, setUsuario] = useState({ id: '', nome: ''});
  const [nome, setNome] = useState('');
  const [email, setEmail] = useState('');
  const [senha, setSenha] = useState('');
  const { id } = useParams();
  const roleAluno = "ALUNO";
  const roleProfessor = "PROFESSOR";

  useEffect(() => {
    // Obter token do localStorage
    const token = localStorage.getItem('token');

    // Verificar se o token existe antes de fazer a chamada à API
    if (token) {
      // Configurar o header de autorização para todas as chamadas da API
      api.defaults.headers['Authorization'] = `Bearer ${token}`;

      // Fazer a chamada à API para obter informações do professor
      api.get(`/usuario/${id}`)
        .then(response => {
          const { id, nome, idProfessor } = response.data;
          setUsuario({ id, nome, idProfessor });
        })
        .catch(error => {
          console.error('Erro ao obter informações do professor:', error);
        });
    }
  }, [id]);

  const openCadastroNovoAluno = () => {
    setCadastroNovoAlunoVisible(true)
  }
  const closeCadastroNovoAluno = () => {
    setCadastroNovoAlunoVisible(false)
  }
  const openCadastroNovoProfessor = () => {
    setCadastroNovoProfessorVisible(true)
  }
  const closeCadastroNovoProfessor = () => {
    setCadastroNovoProfessorVisible(false)
  }
  const handleSalvarNovoAluno = async (nome, email, senha, roleAluno, idProfessor) => {
    try {
      // Obter token do localStorage
      const token = localStorage.getItem('token');

      // Verificar se o token existe antes de fazer a chamada à API
      if (token) {
        // Configurar o header de autorização para a chamada da API
        api.defaults.headers['Authorization'] = `Bearer ${token}`;

        // Fazer a chamada à API para salvar um novo aluno
        const response = await api.post('/auth/register', {
          nome: nome,
          email: email,
          senha: senha,
          role: roleAluno,
          idProfessor: idProfessor
        });

        // Lógica de manipulação da resposta
        if (response.status === 200) {
          console.log('Aluno criado com sucesso!');
        } else {
          console.error('Falha ao criar novo aluno. Status:', response.status);
        }
      }
    } catch (error) {
      console.error('Erro ao fazer a requisição:', error);
    }
  };


  const handleSalvarNovoProfessor = async (nome, email, senha, roleProfessor) => {
    try {
      // Obter token do localStorage
      const token = localStorage.getItem('token');

      // Verificar se o token existe antes de fazer a chamada à API
      if (token) {
        // Configurar o header de autorização para a chamada da API
        api.defaults.headers['Authorization'] = `Bearer ${token}`;

        // Fazer a chamada à API para salvar um novo aluno
        const response = await api.post('/auth/register', {
          nome: nome,
          email: email,
          senha: senha,
          role: roleProfessor
        });

        console.log(response)

        // Lógica de manipulação da resposta
        if (response.status === 200) {
          console.log('Professor criado com sucesso!');
        } else {
          console.error('Falha ao criar novo professor. Status:', response.status);
        }
      }
    } catch (error) {
      console.error('Erro ao fazer a requisição:', error);
    }
  };
  
  return (
    <div>
      <h2>Olá, {usuario.nome}</h2>

      <div>
        <button onClick={openCadastroNovoAluno}>Cadastrar novo Aluno</button>
        <button onClick={openCadastroNovoProfessor}>Cadastrar novo Professor</button>
        <button>Editar Treino</button>
      </div>

      {cadastroNovoAlunoVisible && (
        <StyledModalOverlay>
          <StyledModalContent>
            <StyledCloseButton onClick={closeCadastroNovoAluno}>
              X
            </StyledCloseButton>
            <form action="">
              <span>Nome:</span>
              <input
                type="string"
                name="nome"
                id="nome"
                placeholder="Exemplo"
                value={nome}
                onChange={(e) => setNome(e.target.value)}
              />
              <span>Email:</span>
              <input
                type="email"
                name="email"
                id="email"
                placeholder="exemplo@exemplo.com"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
              />
              <span>Senha:</span>
              <input
                type="password"
                name="senha"
                id="senha"
                placeholder="********"
                value={senha}
                onChange={(e) => setSenha(e.target.value)}
              />
               <button onClick={() => handleSalvarNovoAluno(nome, email, senha, roleAluno, usuario.idProfessor)}>Salvar</button>

            </form>
          </StyledModalContent>
        </StyledModalOverlay>
      )}

      {cadastroNovoProfessorVisible && (
        <StyledModalOverlay>
          <StyledModalContent>
            <StyledCloseButton onClick={closeCadastroNovoProfessor}>
              X
            </StyledCloseButton>
            <form action="">
              <span>Nome:</span>
              <input
                type="string"
                name="nome"
                id="nome"
                placeholder="Exemplo"
                value={nome}
                onChange={(e) => setNome(e.target.value)}
              />
              <span>Email:</span>
              <input
                type="email"
                name="email"
                id="email"
                placeholder="exemplo@exemplo.com"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
              />
              <span>Senha:</span>
              <input
                type="password"
                name="senha"
                id="senha"
                placeholder="********"
                value={senha}
                onChange={(e) => setSenha(e.target.value)}
              />
               <button onClick={() => handleSalvarNovoProfessor(nome, email, senha, roleProfessor)}>Salvar</button>

            </form>
          </StyledModalContent>
        </StyledModalOverlay>
      )}
    </div>

    
  );
};

export default ProfessorDashboard;