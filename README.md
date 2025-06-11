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

##  Структура проекта
/src
├──java
│  ├── LoginFormApplication.java
│  ├── ReguestController.java
│  ├── User.java
│  └── UserManager.java
├── resourses
│  ├── static
│       └── style.css
│  └── templates
│       ├── changhePassword.html
│       ├── forgetpassword.html
│       ├──login.html
│       ├── registrator.html
│       └── welcome.html


## 🛠 Необходимое ПО

Для корректной работы проекта рекомендуется установить:

- Java (версия 17 и выше)
- IDE (рекомендуется **IntelliJ IDEA**)
- MySQL (сервер и клиент)
- Драйвер **MySQL Connector/J** для подключения к базе данных


## ⚙️ Настройка проекта

1. Откройте проект в IntelliJ IDEA или другой IDE.
2. Убедитесь, что в `pom.xml` подключён MySQL-драйвер.
3. Перейдите в файл: src/main/java/UserManager.java
 4. Впишите свои данные для подключения к базе данных в следующие строки:

```java
private static final String url = "jdbc:mysql://localhost:3306/ВАШЕ_ИМЯ_БД";
private static final String dbUser = "ВАШ_ЛОГИН";
private static final String dbPassword = "ВАШ_ПАРОЛЬ";

🚀 Запуск
Убедитесь, что MySQL-сервер запущен и база данных создана.

Запустите файл: src/main/java/com/example/loginform/LoginFormApplication.java

После запуска перейдите в браузере по адресу: http://localhost:8080/

✅ Готово!
Теперь вы можете регистрировать и авторизовывать пользователей через интерфейс HTML, а данные будут сохраняться в вашей базе данных.
