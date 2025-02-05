# Sistema de Agendamento de Transferências Financeiras
> *Fullstack application built with Spring Boot RESTfull API and Vue.js SPA*

 Este projeto consiste em um sistema web desenvolvido com as seguintes tecnologias:
- **Backend**: Java 17, Spring Boot 3, Spring JPA, Spring Web, Model Mapper, Flyway Migration, Validation, Lombok
- **Database**: H2 Database <br>
- **Frontend**: Vue.js, Vue Router, Materialize CSS, Axios, ESLint, Prettier, Node.js 22, npm 10
  
## **Arquitetura**
A arquitetura do projeto foi definida com o objetivo de separar as responsabilidades entre o backend e o frontend, permitindo que cada parte possa ser desenvolvida e escalada de forma independente.

- Backend (API Spring Boot): Responsável por fornecer os serviços e dados para o frontend, além de lidar com a lógica de negócios e persistência de dados.
- Escolhi utilizar uma *estrutura de agrupamento por domínio*, inspirado no Domain Driven Design
- De maneira bem simples, o fluxo da aplicação é: <br>
*`--> (Request)`*<br>
*`<-- (Response)`*<br>
`Client: App <--> Vue Router <--> Component <--> Service <--> Backend: Controller <--> Service <--> Repository <--> Database` 

```shell
├───src
│   ├───main
│   │   ├───java
│   │   │   └───br
│   │   │       └───com
│   │   │           └───wayon
│   │   │               └───api
│   │   │                   │   FinancialTransferSchedulingSystemApplication.java
│   │   │                   │
│   │   │                   ├───account
│   │   │                   │       Account.java
│   │   │                   │       AccountController.java
│   │   │                   │       AccountDTO.java
│   │   │                   │       AccountRepository.java
│   │   │                   │       AccountResponse.java
│   │   │                   │       AccountService.java
│   │   │                   │
│   │   │                   ├───config
│   │   │                   │       Config.java
│   │   │                   │
│   │   │                   ├───exception
│   │   │                   │       DuplicateAccountException.java
│   │   │                   │       GlobalExceptionHandler.java
│   │   │                   │       InvalidRequestDataException.java
│   │   │                   │
│   │   │                   ├───fee
│   │   │                   │       Fee.java
│   │   │                   │       PastTransferDateException.java
│   │   │                   │       TransferDateInvalidException.java
│   │   │                   │
│   │   │                   └───transaction
│   │   │                           Transaction.java
│   │   │                           TransactionController.java
│   │   │                           TransactionDTO.java
│   │   │                           TransactionRepository.java
│   │   │                           TransactionResponse.java
│   │   │                           TransactionService.java
│   │   │
│   │   └───resources
│   │       │   application.properties
│   │       │
│   │       ├───db
│   │       │   └───migration
│   │       │           V1__create-table-account.sql
│   │       │           V2__create-table-transaction.sql
│   │       │           V3__add-constraint-fk-account-id-to-transaction.sql
│   │       │
...

```
- Frontend (Vue.js): Responsável por apresentar a interface do usuário e consumir os serviços do backend.
```shell
|───src
|   │   App.vue
|   │   main.js
|   │
|   ├───assets
|   │       base.css
|   │       logo.svg
|   │       main.css
|   │
|   ├───components
|   │   │   Hero.vue
|   │   │   TheWelcome.vue
|   │   │   WelcomeItem.vue
|   │   │
|   │   ├───account
|   │   │       AccountCreate.vue
|   │   │       AccountList.vue
|   │   │
|   │   ├───icons
|   │   │       IconAccountBalance.vue
|   │   │       IconCommunity.vue
|   │   │       IconCurrencyExchange.vue
|   │   │       IconDocumentation.vue
|   │   │       IconEcosystem.vue
|   │   │       IconSupport.vue
|   │   │       IconTooling.vue
|   │   │
|   │   └───transaction
|   │          TransactionCreate.vue
|   │          TransactionList.vue
|   │
|   ├───router
|   │       index.js
|   │
|   ├───services
|   │       AccountService.js
|   │       TransactionService.js
|   │
|   └───views
|           AccountView.vue
|           HomeView.vue
|           TransactionView.vue
...
```
---

## Instruções para Subir o Projeto
1. Clone o repositório:
```bash
git clone https://github.com/israel-r-roque/fullstack-financial-transfer-scheduling-system.git
```

2. Acesse o diretório do *backend* dentro de *fullstack-financial-transfer-scheduling-system* ou no diretório em que você clonou o projeto:
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
npm run dev
```

## Observações
- Certifique-se de ter o Java 17, Node.js 22 e npm 10 instalados em sua máquina.
- O backend estará disponível na porta `http://localhost:8080`.
- O frontend estará disponível na porta `http://localhost:5173`.

---

## Documentação da API

### Métodos
Requisições para a API devem seguir os padrões:

| Método          | Descrição                                          |
| :----------     | :------------------------------------------------- |
| `GET`           | Retorna informações de um ou mais registros.       |
| `POST`          | Utilizado para criar um novo registro.             |

### Respostas

| Código          | Descrição                                          |
| :----------     | :------------------------------------------------- |
| `200`           | Requisição executada com sucesso (success).        |
| `201`           | Requisição executada e resultou na criação de um novo recurso. |
| `400`           | Erros de validação ou os campos informados não existem no sistema. |
| `404`           | Registro pesquisado não encontrado (Not found). |
| `405`           | Método não implementado. |
| `409`           | Recurso já existente. |

---

### Contas

#### Retorna todos as contas cadastradas

```http
  GET /api/v1/accounts
```

#### Cadastra uma nova conta

```http
  POST /api/v1/accounts
  
  { "accountNumber": "XXXXXXXXXX" }
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `accountNumber` | `string` | **Obrigatório**. O número da conta que será criada |

---

### Tranferências

#### Retorna todos as transferências agendadas

```http
  GET /api/v1/transactions
```

#### Agenda uma nova transferência

```http
  POST /api/v1/transactions
  
  {
    "originAccount": "XXXXXXXXXX",
    "destinationAccount": "YYYYYYYYYY",
    "amount": 1000.00,
    "transferDate": "YYYY-MM-DD"
  }
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `originAccount` | `string` | **Obrigatório**. O número da conta de origem (já cadastrada) que irá realizar a transferência |
| `destinationAccount` | `string` | **Obrigatório**. O número da conta de destino (já cadastrada) que irá receber a transferência |
| `amount` | `bigdecimal` | **Obrigatório**. O valor da transferência |
| `transferDate` | `localdate` | **Obrigatório**. A data em que será realizada a transferência |
