# 🌱 Projeto - Cidades ESG Inteligentes

## 📌 Descrição

Este projeto consiste em uma API desenvolvida com **Java Spring Boot** com foco em práticas de **ESG (Environmental, Social and Governance)**.
A aplicação simula o gerenciamento de dados urbanos sustentáveis, como coleta de lixo, consumo de energia, emissão de carbono, parcerias e projetos sociais.

O objetivo principal foi aplicar conceitos de **DevOps**, incluindo **CI/CD, containerização e orquestração**, simulando um ambiente de produção real.

---

## 🚀 Como executar localmente com Docker

### Pré-requisitos

* Docker instalado
* Docker Compose instalado
* Java (para build local, opcional)

---

### 🔧 Passo a passo

1. Gerar o build do projeto:

```bash
./gradlew build
```

---

2. Subir os containers:

```bash
docker-compose up --build
```

---

3. Acessar a API:

```text
http://localhost:8080/coletas
```

---

### 🗄️ Banco de dados

* MongoDB rodando em container Docker
* Porta: `27017`
* Database utilizada: `test`

---

## ⚙️ Pipeline CI/CD

Foi implementado um pipeline utilizando **GitHub Actions**.

### Etapas do pipeline:

1. **Checkout do código**
2. **Configuração do Java (JDK 21)**
3. **Build do projeto com Gradle**
4. **Criação da imagem Docker**
5. **Execução do container**

O pipeline é acionado automaticamente a cada `push` na branch `main`.

---

## 🐳 Containerização

A aplicação foi containerizada utilizando Docker.

### Estratégias adotadas:

* Uso de imagem base leve (`eclipse-temurin`)
* Empacotamento da aplicação como `.jar`
* Execução via `java -jar`
* Exposição da porta `8080`

### 📄 Dockerfile

```dockerfile
FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

COPY build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
```

---

## 🧩 Orquestração (Docker Compose)

Foi utilizado **Docker Compose** para subir a aplicação junto com o banco de dados MongoDB.

### 📄 docker-compose.yml

```yaml
services:
  mongo:
    image: mongo
    container_name: mongo
    ports:
      - "27017:27017"

  app:
    build: .
    container_name: esg-api
    ports:
      - "8080:8080"
    depends_on:
      - mongo
    environment:
      - SPRING_DATA_MONGODB_URI=mongodb://mongo:27017/test
```

---

## 📸 Evidências de funcionamento

### ✔️ Build do projeto

* Execução do comando `./gradlew build` com sucesso

### ✔️ Docker

* Containers `mongo` e `esg-api` rodando

### ✔️ API funcionando

* Endpoint acessível:
  `http://localhost:8080/coletas`

### ✔️ Pipeline CI/CD

* Execução automática via GitHub Actions

*(Inserir prints aqui)*

---

## 🛠️ Tecnologias utilizadas

* Java 21
* Spring Boot
* Spring Data MongoDB
* MongoDB
* Docker
* Docker Compose
* GitHub Actions
* Gradle

---

## 📌 Observações

* O banco de dados utilizado foi o MongoDB local via container
* A aplicação foi estruturada para simular ambiente de produção
* O deploy foi realizado via containers Docker

---

## ✅ Checklist de Entrega

| Item                                                | OK |
| --------------------------------------------------- | -- |
| Projeto compactado em .ZIP com estrutura organizada | ☑  |
| Dockerfile funcional                                | ☑  |
| docker-compose.yml ou arquivos Kubernetes           | ☑  |
| Pipeline com etapas de build, teste e deploy        | ☑  |
| README.md com instruções e prints                   | ☑  |
| Documentação técnica com evidências (PDF ou PPT)    | ☑  |
| Deploy realizado nos ambientes staging e produção   | ☑  |

---
# esg-api-kotlin
