ESG API – Sistema de Coletas

API desenvolvida para gerenciamento de coletas, com foco em boas práticas de backend, testes automatizados e containerização com Docker.

---

Tecnologias utilizadas

**Backend**
- Kotlin
- Spring Boot
- MongoDB
- Gradle

**Testes**
- Java
- Maven
- Cucumber (BDD)
- Rest Assured
- JUnit

**Infraestrutura**
- Docker
- Docker Compose
- GitHub Actions (CI)

---

Estrutura do projeto

esg-api-kotlin/  
├── src/ (backend Kotlin)  
├── build.gradle.kts  
├── docker-compose.yml  
├── Dockerfile  

testes-automatizados/  
├── src/test/java (testes Maven)  
├── src/test/resources  
├── pom.xml  

---

Como rodar o backend

Build do projeto:
./gradlew build

Subir containers:
docker-compose up --build

---

Acesso à API
http://localhost:8080/swagger-ui/index.html#/

---

Como rodar os testes

Dentro da pasta de testes:

mvn clean test

---

Fluxo completo

1. Build do backend:
./gradlew build

2. Subir aplicação:
docker-compose up --build

3. Rodar testes:
mvn clean test

---

Testes implementados

- Cadastro de coletas
- Consulta por ID e listagem
- Atualização de coletas
- Deleção de coletas
- Validação de status code
- Validação de corpo de resposta
- Testes de contrato (JSON Schema)

---

Docker

Subir todos os serviços:

docker-compose up --build

Inclui:
- API Kotlin
- MongoDB

---

Observações

- MongoDB usado como banco de dados
- API deve estar rodando para testes funcionarem
- Porta da API: 8080
- Porta do Mongo: 27017

---

CI (GitHub Actions)

O pipeline automatiza:
- Build do backend (Gradle)
- Subida dos containers
- Execução dos testes Maven

---

Requisitos

- Java 21+
- Docker + Docker Compose
- Gradle wrapper
- Maven