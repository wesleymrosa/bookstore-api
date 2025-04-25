
# Bookstore API

## 📅 Visão Geral

O **Bookstore API** é um sistema desenvolvido em **Java 17 com Spring Boot 3.4.4** que permite o gerenciamento de **categorias e livros**. 

A aplicação fornece uma API RESTful para cadastro, edição, exclusão e consulta de livros, organizados por categorias, com persistência em banco de dados PostgreSQL.

O projeto segue uma arquitetura tradicional e bem estruturada, baseada em camadas, garantindo alta manutenção, escalabilidade e clareza de código.

Este repositório representa **apenas o backend** da aplicação. A parte **frontend** também está disponível no GitHub, no repositório [bookstore-front](https://github.com/wesleymrosa/bookstore-front).

---

## 🔧 Tecnologias Utilizadas

### Back-end

- Java 17
- Spring Boot 3.4.4
- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- Spring Boot Starter Validation
- Spring Boot Actuator
- Springdoc OpenAPI (Swagger)

### Banco de Dados

- PostgreSQL (driver versão 42.7.3)

### Ferramentas de Apoio

- Maven
- Postman
- Swagger UI (Springdoc OpenAPI)
- cURL

---

## 🏆 Competências e Habilidades Aplicadas

### Linguagem e Frameworks

- Desenvolvimento com Java e Spring Boot aplicando boas práticas
- Criação de APIs RESTful

### Banco de Dados

- Modelagem relacional com PostgreSQL
- Mapeamento ORM com JPA/Hibernate

### Boas Práticas

- Uso de DTOs e Entities
- Divisão em camadas: Controller, Service, Repository, DTO, Entity
- Tratamento de exceções com classes dedicadas e handlers globais
- Documentação automática com Swagger
- Monitoramento e métricas com Spring Boot Actuator

### Testes e Documentação

- Testes manuais via Postman
- Swagger OpenAPI para documentação interativa
- Testes de requisições via navegador e cURL

### Ambiente e Execução

- Configurações no application.properties
- Perfis ativos definidos no Spring Profiles
- IntelliJ IDEA como IDE principal
- Logs com SLF4J e Logback

---

## 📁 Estrutura de Pacotes

```
br.wesley.bookstore
├── config               # Configurações (CORS, Profiles, Swagger)
├── controller           # Endpoints REST (CategoriaController, LivroController)
│   └── exceptions       # Tratamento de exceções HTTP
├── domain               # Entidades JPA (Categoria, Livro)
├── dtos                 # Data Transfer Objects (CategoriaDTO, LivroDTO)
├── repositories         # Interfaces JPA (CategoriaRepository, LivroRepository)
├── service              # Regras de negócio (CategoriaService, LivroService)
│   └── exceptions       # Exceções da camada de serviço
└── BookstoreApplication.java
```

---

## 🚀 Como Executar o Projeto

### 1. Clonar o Repositório

```bash
git clone https://github.com/wesleymrosa/bookstore-api.git
cd bookstore-api
```

### 2. Configurar o Banco PostgreSQL

Crie um banco chamado bookstore_db:

```sql
CREATE DATABASE bookstore_db;
```

### 3. Configurar application.properties

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/bookstore_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
server.port=8082
spring.profiles.active=dev
```

> 🔹 **Nota:** O projeto utiliza perfis do Spring (dev, prod, etc). Para mudar o ambiente, altere o valor de spring.profiles.active no application.properties.

### 4. Compilar e Rodar

```bash
mvn clean install
mvn spring-boot:run
```

A aplicação estará disponível em:

```bash
http://localhost:8082
```

---

## 🔍 Como Testar a API

A API pode ser testada de forma abrangente utilizando diversas abordagens:

### ✅ Via Navegador (métodos GET)

```bash
http://localhost:8082/categorias
http://localhost:8082/categorias/1
http://localhost:8082/livros?categoria=1
http://localhost:8082/livros/1
http://localhost:8082/swagger-ui/index.html
```

### ✅ Via Swagger UI

```bash
http://localhost:8082/swagger-ui/index.html
```

### ✅ Via Postman

GET, POST, PUT, DELETE nos endpoints `/categorias` e `/livros`

### ✅ Via cURL

#### CategoriaController

```bash
curl -X GET http://localhost:8082/categorias
curl -X GET http://localhost:8082/categorias/1
curl -X POST http://localhost:8082/categorias -H "Content-Type: application/json" -d '{"nome":"Tecnologia","descricao":"Livros sobre tecnologia"}'
curl -X PUT http://localhost:8082/categorias/1 -H "Content-Type: application/json" -d '{"nome":"Atualizada","descricao":"Nova descrição"}'
curl -X DELETE http://localhost:8082/categorias/1
```

#### LivroController

```bash
curl -X GET http://localhost:8082/livros?categoria=1
curl -X GET http://localhost:8082/livros/1
curl -X POST http://localhost:8082/livros?categoria=1 -H "Content-Type: application/json" -d '{"titulo":"Livro Novo","nome_autor":"Autor Teste","texto":"Texto do livro."}'
curl -X PUT http://localhost:8082/livros/1 -H "Content-Type: application/json" -d '{"titulo":"Atualizado","nome_autor":"Atualizado","texto":"Texto atualizado."}'
curl -X DELETE http://localhost:8082/livros/1
```

---

## 🔐 Considerações Finais

O sistema oferece um CRUD completo de livros e categorias, implementado com foco em boas práticas de desenvolvimento, arquitetura tradicional em camadas e documentação automatizada via Swagger. O projeto é otimizado para operações REST, conta com tratamento de exceções, integração robusta com PostgreSQL e suporte a validações utilizando Spring Boot Validation. A configuração de múltiplos perfis (`dev`, `prod`) permite ajustes dinâmicos de ambiente.

Este projeto corresponde à **parte backend** da aplicação. O **frontend Angular** está disponível publicamente no repositório [bookstore-front](https://github.com/wesleymrosa/bookstore-front).

---

## 👤 Autor

**Wesley Martins Rosa**  
Email: [wesleymrosa@gmail.com](mailto:wesleymrosa@gmail.com)  
LinkedIn: [linkedin.com/in/wesley-martins-rosa-5118aa15a](https://www.linkedin.com/in/wesley-martins-rosa-5118aa15a)
