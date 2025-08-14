# 🚀 Spring Boot Social Posts API

![Java](https://img.shields.io/badge/Java-21-ED8B00?logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.4-6DB33F?logo=springboot&logoColor=white)
![MongoDB](https://img.shields.io/badge/MongoDB-Database-47A248?logo=mongodb&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3.9+-C71A36?logo=apachemaven&logoColor=white)
![License](https://img.shields.io/badge/license-MIT-blue)

Uma **API REST** para gerenciamento de posts em um contexto social, desenvolvida com **Spring Boot** e **MongoDB**.  
Projetada com foco em **simplicidade**, **boas práticas** e **camadas bem definidas**, já pronta para evoluir.

---

## 🛠️ Stack Tecnológica
- **Java 21**
- **Spring Boot 3.5.4**  
  - Spring Web  
  - Spring Data MongoDB  
  - Spring Boot Test
- **MongoDB**
- **Maven**

---

## 🏗 Arquitetura
O projeto segue uma **arquitetura em camadas**:
- **Controller**: apenas delega requisições.
- **Service**: concentra a lógica de negócio.
- **Repository**: cuida da persistência com MongoDB.
- **Domain**: modelo de dados isolado.

📌 Diagrama da arquitetura:  
<img width="776" height="435" alt="Image" src="https://github.com/user-attachments/assets/85687ac3-f48c-4965-b269-4f1c61044177" />

---

## 📋 Pré-requisitos
- **Java 21** instalado 
- **Maven 3.9+**  
- **MongoDB** em execução (local ou remoto)  

---

## ⚙️ Configuração
Defina a conexão com o MongoDB via `application.properties`:

`spring.data.mongodb.uri=mongodb://localhost:27017/seubancodedados`

---

## 📡 Endpoints

**Base URL:** `/` (porta padrão **8080**)

### 👥 Users (`/users`)
- `GET /users` → lista todos os usuários (DTO).
- `GET /users/{id}` → busca usuário por ID (DTO).
- `POST /users` → cria novo usuário (DTO) → **201 Created** com Location.
- `PUT /users/{id}` → atualiza usuário por ID (DTO) → **204 No Content**.
- `DELETE /users/{id}` → remove usuário por ID → **204 No Content**.
- `GET /users/{id}/posts` → lista os posts de um usuário específico.

### 📝 Posts (`/posts`)
- `GET /posts/{id}` → busca post por ID.
- `GET /posts/titlesearch?text=...` → busca posts pelo título (com decoding).
- `GET /posts/fullsearch?text=...&minDate=...&maxDate=...` → busca posts por texto e filtra por intervalo de datas.

---

## 💡 Observações
- Os **controllers** apenas delegam a lógica para **UserService** e **PostService**.
- Persistência gerenciada pelo **Spring Data MongoDB**.
- **DTOs** são usados para respostas de usuários; posts retornam o modelo diretamente.
