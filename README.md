# Sistema de Gerenciamento de Tarefas

## Descrição

O Sistema de Gerenciamento de Tarefas é uma aplicação web que permite aos usuários criar, gerenciar e organizar listas de tarefas e itens associados. A aplicação oferece funcionalidades para adicionar, editar, remover e alterar o estado de itens, bem como filtrar e priorizar tarefas.

## Requisitos

- **Framework de Desenvolvimento:** Spring Boot
- **Banco de Dados:** Relacional (MySQL, PostgreSQL, etc.)
- **Testes Automatizados:** JUnit, Mockito

## Funcionalidades

1. **Criação de Listas**
   - **Endpoint:** `POST /lists`
   - **Descrição:** Cria uma nova lista de tarefas.

2. **Gerenciamento de Itens**
   - **Endpoint:** `POST /lists/{listId}/items`
   - **Descrição:** Adiciona um item a uma lista específica.
   - **Endpoint:** `PUT /lists/{listId}/items/{itemId}`
   - **Descrição:** Atualiza um item em uma lista específica.
   - **Endpoint:** `DELETE /lists/{listId}/items/{itemId}`
   - **Descrição:** Remove um item de uma lista específica.
   - **Endpoint:** `PUT /lists/{listId}/items/{itemId}/status`
   - **Descrição:** Altera o estado de um item.

3. **Visualização e Filtragem**
   - **Endpoint:** `GET /lists`
   - **Descrição:** Obtém todas as listas.
   - **Endpoint:** `GET /lists/{id}`
   - **Descrição:** Obtém uma lista específica pelo ID.

4. **Prioridade de Itens**
   - **Endpoint:** `PUT /lists/{listId}/items/{itemId}/priority`
   - **Descrição:** Destaca um item para indicar prioridade.

## Requisitos de Configuração

### Banco de Dados

1. **Configuração do Banco de Dados**
   - O banco de dados deve estar configurado e acessível.
   - Exemplo de string de conexão para MySQL:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/task_manager
     spring.datasource.username=root
     spring.datasource.password=password
     ```

2. **Estrutura do Banco de Dados**
   - Tabelas necessárias:
     - `task_lists`: Armazena as listas de tarefas.
     - `task_items`: Armazena os itens de tarefas associados às listas.

## Configuração do Projeto

1. **Clone o Repositório**
   ```bash
   git clone https://github.com/seu-usuario/task-manager-app.git

## Configuração do Projeto

### Instale Dependências

Utilize Maven ou Gradle para gerenciar dependências.

```bash
mvn install

## Configure o Banco de Dados

Ajuste as configurações de conexão no arquivo `application.properties` conforme necessário.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/task_manager
spring.datasource.username=root
spring.datasource.password=password


## Execute a Aplicação

```bash
mvn spring-boot:run

## Testes Automatizados

### Executar Testes

Utilize o Maven ou Gradle para executar testes automatizados.

```bash
mvn test
