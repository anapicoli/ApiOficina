# Sistema de Agendamento de Serviços da Oficina
  API RESTful desenvolvida em Spring Boot para gerenciar clientes, serviços e agendamentos em uma oficina mecânica.
  O sistema permite cadastrar clientes, registrar serviços disponíveis e criar agendamentos vinculados entre ambos.

# Tecnologias Utilizadas
  ⋄ Java 20
  ⋄ Spring Boot 3.x
  ⋄ Spring Web
  ⋄ Spring Data JPA
  ⋄ MySQL
  ⋄ Validation
  ⋄ Maven

# Estrutura do projeto
  - agendamentos-api
    - src
      - main
        - java
          - anapicoli.agendamentos_api
            - controller
              - AgendamentoController
              - AgendamentoDTO
              - ClienteController
              - ServicoController
            - model
              - Agendamento
              - Cliente
              - Servico
            - Repository
              - AgendamentoRepository
              - ClienteRepository
              - ServicoRepository
            - AgendamentosApiApplication
        - resources
          - static/
          - templates/
          - application.properties
      - test/
    - target/
    - pom.xml

# Banco de dados
  ## Tabela Cliente
    Campo                Tipo                Descrição
    id                   BIGINT              Chave primária
    nome                 VARCHAR(100)        Nome do cliente
    email                VARCHAR(100)        Email do cliente
    telefone             VARCHAR(20)         Telefone
    criado_em            DATETIME            Data de criação

  ## Tabela Servico
    Campo                Tipo                Descrição
    id                   BIGINT              Chave primária
    nome                 VARCHAR(100)        Nome do serviço
    descricao            TEXT                Detalhes do serviço
    preco                decimal(10,2)       Valor do serviço
    criado_em            DATETIME            Data de criação

  ## Tabela Agendamento
    Campo                Tipo                Descrição
    id                   BIGINT              Chave primária
    cliente_id           BIGINT              Cliente relacionado
    servico_id           BIGINT              Serviço relacionado
    data_agendada        DATETIME            Data/Hora do agendamento
    observacoes          TEXT                Observações adicionais
    status               VARCHAR(20)         Estado do agendamento
    criado_em            DATETIME            Data de criação

# Testes no Postman
  • Criar cliente ⇾ POST /clientes
  • Criar servico ⇾ POST /servicos
  • Criar agendamento ⇾ POST /agendamentos
  • Listar agendamentos ⇾ GET /agendamentos
  • Ver um agendamento específico ⇾ GET /agendamentos/{id}
  • Atualizar agendamento ⇾ PUT /agendamnentos/{id}
  • Excluir agendamento ⇾ DELETE /agendamentos/{id}

# Como executar o projeto
  ## Passos
      ### Crie o banco Oficina no MySQL:
          CREATE DATABASE Oficina;

      ### Configure application.properties com seu usuário e senha do MySQL.
      
      ### Execute o projeto no IntelliJ ou VSCode:
          bash:
          mvn spring-boot:run

      ### Acesse a API em:
          http://localhost:8080



### Projeto Desenvolvido por
  Ana Picoli
