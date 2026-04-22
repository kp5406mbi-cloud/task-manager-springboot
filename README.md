# 📝 Task Manager Application

A full-stack Task Manager application built using **Spring Boot**, featuring **JWT-based authentication**, secure REST APIs, and a responsive frontend interface.

This project demonstrates key backend engineering concepts such as **stateless authentication, role-based authorization, and scalable API design**, along with seamless frontend-backend integration.

---

## 🚀 Features

### 🔐 Authentication

* User Registration
* User Login
* JWT-based Authentication
* Secure API access using tokens

### 📋 Task Management

* Create Task
* Fetch All Tasks
* Update Task
* Delete Task

### 🎨 Frontend

* Login-first UI
* Dynamic dashboard
* Task cards with Edit/Delete
* Empty state handling
* Clean and responsive design

---

## 🛠 Tech Stack

### Backend

* Java
* Spring Boot
* Spring Security
* JWT (JSON Web Tokens)
* Spring Data JPA

### Frontend

* HTML
* CSS
* JavaScript (Vanilla)

### Database

* PostgreSQL / H2 (mention whichever you used)

### API Testing

* Swagger UI

---

## 📂 Project Structure

```
src/
 ├── controller/
 ├── service/
 ├── repository/
 ├── model/
 ├── security/
 ├── config/
 └── exception/

index.html
pom.xml
README.md
```

---

## ⚙️ Setup Instructions

### 1. Clone the repository

```
git clone https://github.com/kp5406mbi-cloud/task-manager-springboot.git
cd task-manager-springboot
```

### 2. Run the backend

```
mvn spring-boot:run
```

### 3. Access the application

* Backend: http://localhost:8080
* Swagger UI: http://localhost:8080/swagger-ui/index.html

---

## ▶️ Run Frontend

After starting the backend:

* Open `index.html` in your browser
* Login/Register and start using the application

---

## 🔑 API Endpoints

### Auth APIs

| Method | Endpoint              |
| ------ | --------------------- |
| POST   | /api/v1/auth/register |
| POST   | /api/v1/auth/login    |

### Task APIs

| Method | Endpoint           |
| ------ | ------------------ |
| GET    | /api/v1/tasks      |
| GET    | /api/v1/tasks/{id} |
| POST   | /api/v1/tasks      |
| PUT    | /api/v1/tasks/{id} |
| DELETE | /api/v1/tasks/{id} |

---

## 🔒 Security

* JWT-based authentication
* Stateless session management
* Protected endpoints using Spring Security
* Role-based access control

---

## 📸 Screenshots

### 🔐 Login Page

![Login](screenshots/login.png)

### 📊 Dashboard

![Dashboard](screenshots/dashboard.png)

### 📋 Tasks

![Tasks](screenshots/tasks.png)

---

## 🔐 Demo Credentials

Username: testuser
Password: test123

---

## 📈 Scalability Considerations

* Stateless authentication using JWT enables horizontal scaling
* Can be extended with:

  * Redis (caching)
  * PostgreSQL (production DB)
  * Docker (containerization)
  * Load balancing for high traffic systems

---

## 🧪 Testing

* APIs tested using Swagger UI
* Frontend tested via browser

---

## 👨‍💻 Author

**Kumar Piyush**
Mathematics and Computing, BIT Mesra

---

## ✅ Status

✔ Backend implemented
✔ Frontend integrated
✔ Full CRUD functionality
✔ Secure authentication
✔ Ready for evaluation

---
