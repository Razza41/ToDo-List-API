# 📝 ToDo List API

API REST para gerenciamento de tarefas, desenvolvida com Java 21 e Spring Boot 4.

## 🛠️ Tecnologias

- Java 21
- Spring Boot 4
- Spring Web
- Spring Data JPA
- Spring Validation
- MySQL
- Lombok

## 📋 Funcionalidades

- Criar tarefa
- Listar todas as tarefas
- Buscar tarefa por ID
- Atualizar tarefa
- Deletar tarefa

## ▶️ Como executar

### Pré-requisitos

- Java 21+
- Maven
- MySQL

### Configuração do banco de dados

Crie um banco de dados MySQL e configure as credenciais no `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/todo_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

### Rodando o projeto

```bash
# Clone o repositório
git clone https://github.com/Razza41/ToDo-List-API.git

# Entre na pasta
cd ToDo-List-API

# Execute com Maven
./mvnw spring-boot:run
```

A API estará disponível em `http://localhost:8080`.

## 🔗 Endpoints

| Método | Rota | Descrição |
|--------|------|-----------|
| GET | `/tasks` | Lista todas as tarefas |
| GET | `/tasks/{id}` | Busca tarefa por ID |
| POST | `/tasks` | Cria uma nova tarefa |
| PUT | `/tasks/{id}` | Atualiza uma tarefa |
| DELETE | `/tasks/{id}` | Remove uma tarefa |

## 🚀 Próximos passos

- [ ] Autenticação e autorização com Spring Security + JWT
- [ ] Associação entre usuários e tarefas
- [ ] Testes unitários e de integração com JUnit e Mockito
- [ ] Containerização com Docker
- [ ] Deploy em nuvem

## 📄 Licença

Este projeto está sob a licença MIT.
