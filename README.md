#  LoginForm — Java + Spring Boot + MySQL

Проект представляет собой систему регистрации и авторизации пользователей с подключением к базе данных MySQL. Интерфейс реализован на HTML/CSS, а логика работы — на Java с использованием Spring Boot.

---

##  Функционал

- ✅ Регистрация нового пользователя
- ✅ Проверка уникальности логина и email
- ✅ Авторизация с проверкой пароля и статуса
- ✅ Связь с базой данных MySQL через JDBC
- ✅ HTML-форма логина и регистрации с кастомным дизайном
- 🔄 (В разработке) Подтверждение почты / восстановление пароля

---

##  Технологии

- **Java 17**
- **Spring Boot 3.x**
- **Thymeleaf** (для шаблонов HTML)
- **MySQL 8.x**
- **JDBC Driver**
- **HTML5 / CSS3 / JS**

---

##  Структура проекта
/src
├──java
│  ├── LoginFormApplication.java
│  ├── ReguestController.java
│  ├── User.java
│  └── UserManager.java
├── resourses
│   ├── static
        └── style.css
│   └── templates
├── templates
│ ├── login.html
│ └── welcome.html
├── static
│ └── style.css
└── LoginFormApplication.java
