# Fullstack application built with Spring Boot RESTfull API and Vue.js SPA

Este projeto consiste em um sistema web desenvolvido com as seguintes tecnologias:

- **Backend**: API Spring Boot <br>
- **Frontend**: Vue.js

## **Arquitetura**
A arquitetura do projeto foi definida com o objetivo de separar as responsabilidades entre o backend e o frontend, permitindo que cada parte possa ser desenvolvida e escalada de forma independente.

- Backend (API Spring Boot): Responsável por fornecer os serviços e dados para o frontend, além de lidar com a lógica de negócios e persistência de dados.
- Frontend (Vue.js): Responsável por apresentar a interface do usuário e consumir os serviços do backend.

## Versões de Linguagem e Ferramentas
- Java 17
- Spring Boot 3
- Vue.js 3
- Node.js 16
- npm 8

## Instruções para Subir o Projeto
1. Clone o repositório:
```bash
git clone https://github.com/israel-r-roque/fullstack-financial-transfer-scheduling-system.git
```

2. Acesse o diretório do backend:
```bash
cd backend
```
3. Compile o projeto:
```bash
./mvnw compile
```

4. Execute o projeto:
```bash
./mvnw spring-boot:run
```

5. Acesse o diretório do frontend:
```bash
cd ../frontend
```
6. Instale as dependências:
   
```bash
npm install
```

7. Execute o projeto:
```bash
npm run serve
```

## Observações
- O backend estará disponível na porta `http://localhost:8080`.
- O frontend estará disponível na porta `http://localhost:5173`.
- Certifique-se de ter o Java 17, Node.js 22 e npm 10 instalados em sua máquina.
  
## Contribuições
- Contribuições são sempre bem-vindas! Sinta-se à vontade para abrir issues e enviar pull requests.