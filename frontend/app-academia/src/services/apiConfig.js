import axios from 'axios';

const token = localStorage.getItem('token');

const api = axios.create({
  baseURL: 'http://localhost:8080', 
  headers: {
    'Authorization': `Bearer ${token}`,
    'Content-Type': 'application/json',
  },
});

// // Intercepta a requisição antes de ser enviada
// api.interceptors.request.use(config => {
//   // Verifica se a requisição é para a rota de registro
//   if (config.url === '/auth/register') {
//     // Não envia o token de autorização para a rota de registro
//     delete config.headers['Authorization'];
//   } else {
//     // Adiciona o token de autorização para outras rotas
//     config.headers['Authorization'] = `Bearer ${token}`;
//   }

//   return config;
// });

export default api;
