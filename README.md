# 📚 Reading Tracker

A full‑stack web application that helps users organize their personal library and track reading progress. Users can add books, update pages read, and categorize titles as **Not Read**, **Readings**, or **Read** through a clean and responsive interface.

---

## ✨ Features

* User authentication (secure login & registration)
* Add and edit the status of a book
* Categorize books by reading status
* Persistent data saved per user
* Responsive UI for desktop and mobile

---

## 🛠 Tech Stack

**Frontend**

* React
* React Router
* SCSS

**Backend**

* Spring Boot (REST API)
* JWT Authentication
* PostgreSQL

---

## 🚀 Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/your-username/reading-tracker.git
cd reading-tracker
```

---

## 🔐 Environment Variables Used

Create a `.env` file in the frontend:

```
BACKEND_URL=http://localhost:8080
```

Create a `.env` file in the backend:

```
GOOGLE_BOOKS_API_KEY=yourGoogleBooksKey

JWT_SECRET_KEY=yourSecreteKey

```

Backend `application.properties` example:

```
jwt.secret=yourSecretKey
spring.datasource.url=jdbc:your_database_url
spring.datasource.username=your_user
spring.datasource.password=your_password

```

---

## 📡 API Overview

| Method | Endpoint                | Description                          |
| ------ | ----------------------- | ------------------------------------ |
| POST   | /auth/login             | Logs a user in                       |
| GET    | /auth/is-authenticated  | Checks if a user is authenticated    |
| POST   | /auth/logout            | Logs a user out                      |
| POST   | /profile/register       | Creates a user                       |
| GET    | /profile/me             | Gets the current users data          |
| GET    | /book/search            | Search for a book                    |
| GET    | /book/getBook           | Get a book based on an id            |
| POST   | /book/getBook           | Update progress                      |
| POST   | /book/addBook           | Adds a book to the database          |
| GET    | /member_book            | Gets a users reading list            |
| POST   | /member_book            | Adds a book to a user's reading list |
| PUT    | /member_book            | Updates the reading status of a book |

---

## 📁 Project Structure

```
reading-tracker/
│
├── frontend/        # React client
├── backend/         # Spring Boot API
└── README.md
```

---

## 🎯 Future Improvements

* Reading goals & statistics dashboard
* Dark mode
* Recommendations system
* Delete a book from a reading list

---

## 📄 License

This project is for educational and portfolio use.
