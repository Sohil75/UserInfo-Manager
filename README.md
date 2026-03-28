<div align="center">

<img src="https://img.shields.io/badge/User_Info_Manager-0066FF?style=for-the-badge&logo=data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZpZXdCb3g9IjAgMCAyNCAyNCI+PHBhdGggZmlsbD0id2hpdGUiIGQ9Ik0xMiAxMmMyLjIxIDAgNC0xLjc5IDQtNHMtMS43OS00LTQtNC00IDEuNzktNCA0IDEuNzkgNCA0IDR6bTAgMmMtMi42NyAwLTggMS4zNC04IDR2MmgxNnYtMmMwLTIuNjYtNS4zMy00LTgtNHoiLz48L3N2Zz4=&logoColor=white" alt="User Info Manager" height="40"/>

# User Info Manager

### A Java-based desktop application for efficient user data management

[![Java](https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=openjdk&logoColor=white)](https://www.java.com/)
[![Swing](https://img.shields.io/badge/Java_Swing-007396?style=flat-square&logo=java&logoColor=white)](https://docs.oracle.com/javase/tutorial/uiswing/)
[![SQLite](https://img.shields.io/badge/SQLite-003B57?style=flat-square&logo=sqlite&logoColor=white)](https://www.sqlite.org/)
[![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-000000?style=flat-square&logo=intellijidea&logoColor=white)](https://www.jetbrains.com/idea/)
[![OOP](https://img.shields.io/badge/OOP_Principles-0066FF?style=flat-square)](https://en.wikipedia.org/wiki/Object-oriented_programming)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg?style=flat-square)](LICENSE)

[📸 Screenshots](#-screenshots) · [⚙️ Setup Guide](#%EF%B8%8F-installation--setup) · [🐛 Report Bug](https://github.com/your-username/user-info-manager/issues)

---

</div>

## 📌 Overview

**User Info Manager** is a desktop-based application built with **Java Swing** that provides a clean, interactive interface for managing user records efficiently. It supports full **CRUD operations** (Create, Read, Update, Delete) with persistent **SQLite** storage — making it a reliable solution for small-scale data management.

> Built using core **Object-Oriented Programming** principles and **event-driven programming** for a responsive, intuitive user experience.

---

## ✨ Features

| Feature | Description |
|--------|-------------|
| 👤 **Add Users** | Fill and submit a form to store new user records |
| 📋 **View Users** | Browse all stored users in a structured list view |
| ✏️ **Update Records** | Edit and save changes to existing user details |
| ❌ **Delete Records** | Remove user entries with confirmation handling |
| 💾 **Persistent Storage** | All data saved to SQLite — survives app restarts |
| ✅ **Input Validation** | Form validation to ensure data accuracy and integrity |
| 🖥️ **Clean UI** | Simple, interactive interface built with Java Swing |

---

## 🛠️ Tech Stack

| Layer | Technology |
|-------|------------|
| **Language** | Java |
| **UI Framework** | Java Swing |
| **Database** | SQLite |
| **IDE** | IntelliJ IDEA |
| **Architecture** | OOP + Event-Driven Programming |

---

## 📂 Application Modules

```
User Info Manager
│
├── 🗂️  User Form Module       — Add and edit user details via form inputs
├── 📋  User List Module        — Display all users in a structured table/list
├── 💾  Database Module         — Handles SQLite connection and data persistence
└── 🎛️  Controller Layer        — Manages business logic between UI and database
```

---

## ⚙️ Functional Overview

- 🧱 **Object-Oriented Design** — built with encapsulation, inheritance, and abstraction principles
- ⚡ **Event-Driven UI** — button clicks and form interactions handled via Swing event listeners
- ✅ **Input Validation** — user inputs are validated before being written to the database
- 💾 **SQLite Integration** — lightweight, file-based database with no external server required
- 🔄 **Real-Time Updates** — user list refreshes instantly after any add, update, or delete action

---

## ⚙️ Installation & Setup

### Prerequisites
- Java JDK `v8+`
- IntelliJ IDEA (or any Java IDE)
- SQLite (bundled — no separate installation needed)

### 1. Clone the Repository

```bash
git clone https://github.com/Sohil75/UserInfo-Manager
cd user-info-manager
```

### 2. Open in IntelliJ IDEA

```
File → Open → Select the project folder
```

### 3. Add SQLite JDBC Dependency

Download the SQLite JDBC driver from [sqlite-jdbc releases](https://github.com/xerial/sqlite-jdbc/releases) and add it to your project:

```
File → Project Structure → Libraries → Add JAR → sqlite-jdbc-x.x.x.jar
```

### 4. Run the Application

```
Right-click Main.java → Run 'Main'
```

Or via terminal:

```bash
javac Main.java
java Main
```

---

## 📸 Screenshots
<img width="600" height="1080" alt="image" src="https://github.com/user-attachments/assets/d75026f4-fe33-49e3-aac9-ec5423a1bb4f" />

---

## 🎯 Use Cases

- 🏢 **Small businesses** managing customer or employee records
- 🖥️ **Admin systems** for storing and retrieving user information
- 🎓 **Learning project** demonstrating Java desktop development with database integration

---

## 📌 Roadmap

- [ ] 🔐 User authentication and login system
- [ ] 📤 Export data to CSV / PDF
- [ ] ☁️ Cloud database integration (Firebase / MySQL remote)
- [ ] 📊 Analytics dashboard with user statistics
- [ ] 🔍 Search and filter functionality

---

## 👨‍💻 Author

**Md Sohil**

[![Portfolio](https://img.shields.io/badge/Portfolio-000000?style=flat-square&logo=vercel&logoColor=white)](https://react-portfolios.onrender.com/)
[![GitHub](https://img.shields.io/badge/GitHub-181717?style=flat-square&logo=github&logoColor=white)](https://github.com/Sohil75)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-0A66C2?style=flat-square&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/md-sohil/
)
[![Email](https://img.shields.io/badge/Email-D14836?style=flat-square&logo=gmail&logoColor=white)](mailto:mdsohil1802@gmail.com)

---

## 📄 License

This project is licensed under the [MIT License](LICENSE).

---

<div align="center">

If you found this project useful, please consider giving it a ⭐ — it helps others discover it!

**Made with ☕ Java & ❤️ by Md Sohil**

</div>
