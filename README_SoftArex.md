
# SoftArex – Анкетный портал

## Технологический стек

- Java 21  
- Spring Boot 3.1.5  
- Spring Data JPA (Hibernate)  
- PostgreSQL  
- Redis  
- Spring Security (JWT)  
- Spring Mail  
- WebSockets  
- React  
- Maven

## Репозитории

Проект состоит из двух независимых репозиториев:

- **Backend**: Spring Boot (модули `api` и `core`)
- **Frontend**: React-приложение

## Установка и запуск

### Предварительные требования

- Java 21+
- Maven 3.6+
- PostgreSQL
- Redis
- Node.js и npm

### Настройка базы данных

```sql
CREATE DATABASE softarex;
```

`backend/api/src/main/resources/application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/softarex
    username: <ваш_пользователь>
    password: <ваш_пароль>
```

### Настройка Redis

```yaml
spring:
  data:
    redis:
      host: localhost
      port: 6379
```

### Настройка SMTP

```yaml
spring:
  mail:
    host: smtp.example.com
    port: 587
    username: <email>
    password: <app_password>
    properties:
      mail:
        smtp:
          auth: true
          starttls:
            enable: true
```

### Запуск backend

```bash
git clone <ссылка_на_backend_repo>
cd backend
mvn clean install
cd api
mvn spring-boot:run
```

### Запуск frontend

```bash
git clone <ссылка_на_frontend_repo>
cd frontend
npm install
npm run start
```

## Backend: структура

- `core`: сущности, репозитории, бизнес-логика, Redis
- `api`: контроллеры, WebSocket, JWT, Spring Security, email

## Frontend: функциональность

- Регистрация, вход, редактирование профиля
- Работа с анкетами
- Отправка ответов по публичной ссылке
- WebSocket для реального времени

## Дополнительно реализовано

- Spring Security + JWT
- Redis для хранения временных кодов
- Email-нотификации через SMTP
- Чистое модульное разделение
