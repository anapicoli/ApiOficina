# 🚗 Sistema de Agendamento de Serviços da Oficina

API RESTful desenvolvida em **Spring Boot** para gerenciar **clientes, serviços e agendamentos** em uma oficina mecânica.  
O sistema permite cadastrar clientes, registrar serviços disponíveis e criar agendamentos vinculados entre ambos.

---

## 🧩 Tecnologias Utilizadas
- **Java 20**
- **Spring Boot 3.x**
- **Spring Web**
- **Spring Data JPA**
- **MySQL**
- **Validation**
- **Maven**

---

## ⚙️ Estrutura do Projeto
```
agendamentos-api/
├── src/
│   ├── main/
│   │   ├── java/anapicoli/agendamentosapi/
│   │   │   ├── controller/
│   │   │   │   ├── ClienteController.java
│   │   │   │   ├── ServicoController.java
│   │   │   │   └── AgendamentoController.java
│   │   │   ├── model/
│   │   │   │   ├── Cliente.java
│   │   │   │   ├── Servico.java
│   │   │   │   └── Agendamento.java
│   │   │   ├── repository/
│   │   │   │   ├── ClienteRepository.java
│   │   │   │   ├── ServicoRepository.java
│   │   │   │   └── AgendamentoRepository.java
│   │   │   └── AgendamentosApiApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static/
│   └── test/
│       └── ...
└── pom.xml
```

---

## 🗄️ Banco de Dados

**Nome do banco:** `oficina`

Tabelas criadas automaticamente pelo JPA (ou manualmente, se desejar):

### 🧍 Tabela Cliente
| Campo     | Tipo         | Descrição         |
|-----------|--------------|-------------------|
| id        | BIGINT       | Chave primária    |
| nome      | VARCHAR(100) | Nome do cliente   |
| email     | VARCHAR(100) | E-mail do cliente |
| telefone  | VARCHAR(20)  | Telefone          |
| criado_em | DATETIME     | Data de criação   |

### 🔧 Tabela Servico
| Campo     | Tipo          | Descrição           |
|-----------|---------------|---------------------|
| id        | BIGINT        | Chave primária      |
| nome      | VARCHAR(100)  | Nome do serviço     |
| descricao | TEXT          | Detalhes do serviço |
| preco     | DECIMAL(10,2) | Valor do serviço    |
| criado_em | DATETIME      | Data de criação     |

### 📅 Tabela Agendamento
| Campo         | Tipo        | Descrição                |
|---------------|-------------|--------------------------|
| id            | BIGINT      | Chave primária           |
| cliente_id    | BIGINT      | Cliente relacionado      |
| servico_id    | BIGINT      | Serviço relacionado      |
| data_agendada | DATETIME    | Data/hora do agendamento |
| observacoes   | TEXT        | Observações adicionais   |
| status        | VARCHAR(20) | Estado do agendamento    |
| criado_em     | DATETIME    | Data de criação          |

---

## ⚙️ Configuração do Banco (application.properties)

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/oficina?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=123456
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

---

## 🚀 Endpoints

### 👤 Clientes
| Método | Endpoint    | Descrição                |
|--------|-------------|--------------------------|
| GET    | `/clientes` | Lista todos os clientes  |
| POST   | `/clientes` | Cadastra um novo cliente |

**Exemplo JSON (POST):**
```json
{
  "nome": "Carlos",
  "email": "carlos@ex.com",
  "telefone": "(11)90000-0000"
}
```

---

### 🔧 Serviços
| Método | Endpoint    | Descrição                |
|--------|-------------|--------------------------|
| GET    | `/servicos` | Lista todos os serviços  |
| POST   | `/servicos` | Cadastra um novo serviço |

**Exemplo JSON (POST):**
```json
{
  "nome": "Troca de bateria",
  "descricao": "Serviço completo de substituição",
  "preco": 350.00
}
```

---

### 📅 Agendamentos
| Método | Endpoint             | Descrição                   |
|--------|----------------------|-----------------------------|
| GET    | `/agendamentos`      | Lista todos os agendamentos |
| GET    | `/agendamentos/{id}` | Detalhes de um agendamento  |
| POST   | `/agendamentos`      | Cria um novo agendamento    |
| PUT    | `/agendamentos/{id}` | Atualiza data ou status     |
| DELETE | `/agendamentos/{id}` | Remove um agendamento       |

**Exemplo JSON (POST):**
```json
{
  "clienteId": 1,
  "servicoId": 2,
  "dataAgendada": "2025-10-25T09:00:00",
  "observacoes": "Cliente pediu revisão completa"
}
```

**Exemplo JSON (PUT):**
```json
{
  "dataAgendada": "2025-10-25T10:00:00",
  "status": "CONFIRMADO"
}
```

---

## 🧪 Testes no Postman

1. **Criar cliente** → `POST /clientes`  
2. **Criar serviço** → `POST /servicos`  
3. **Criar agendamento** → `POST /agendamentos`  
4. **Listar agendamentos** → `GET /agendamentos`  
5. **Ver um agendamento específico** → `GET /agendamentos/{id}`  
6. **Atualizar agendamento** → `PUT /agendamentos/{id}`  
7. **Excluir agendamento** → `DELETE /agendamentos/{id}`

---

## 🧱 Execução do Projeto

### Passos:
1. Crie o banco `oficina` no MySQL:  
   ```sql
   CREATE DATABASE oficina;
   ```
2. Configure `application.properties` com seu usuário e senha do MySQL.
3. Execute o projeto no IntelliJ ou VSCode:  
   ```bash
   mvn spring-boot:run
   ```
4. Acesse a API em:  
   ```
   http://localhost:8080
   ```

---

## 🧑‍💻 Autor
**Ana Picoli**
