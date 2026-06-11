# TextSpectacles Secure App

A secure Java EE web application developed for the **INT316D Internet Programming** practical mini-project.  
This system enables **field agents** and **managers at HQ** to communicate securely using **DESede encryption**, **role-based authentication/authorization**, **EJB business logic**, and **database persistence**. [1](blob:https://m365.cloud.microsoft/fd5e1627-55b6-49af-b773-12912d6cc0f8)

---

## 📌 Project Overview

**TextSpectacles Secure App** is a secure, database-driven web application built using:

- **Java EE / JEE**
- **JSP + HTML**
- **Servlets**
- **EJB Session Beans**
- **MySQL**
- **DESede (Triple DES) encryption**
- **GlassFish / Payara security (file realm)**

The application was designed to satisfy the following requirements:

- Interactive GUI using JSP/HTML  
- Personalised user interaction  
- Conversational state using sessions  
- Robust exception/error handling  
- Business logic implemented with EJBs  
- Database-driven storage and retrieval  
- Security through authentication, authorization, encryption, and decryption [1](blob:https://m365.cloud.microsoft/fd5e1627-55b6-49af-b773-12912d6cc0f8)

---

## 🚀 Features

### Field Agent
A field agent can:

- Log in securely  
- Generate and view a **secret key**
- Share/store the secret key in the database
- Write a message and encrypt it using **DESede**
- Preview ciphertext before sending it
- Classify messages as **Low**, **High**, or **Critical**
- Send ciphertext to HQ (database)
- Retract/remove a specific ciphertext from HQ
- View the total number of **Low-priority** messages sent
- Log out [1](blob:https://m365.cloud.microsoft/fd5e1627-55b6-49af-b773-12912d6cc0f8)

### Manager
A manager can:

- Log in securely
- View encrypted messages in **decrypted format**
- View messages ordered by priority: **Critical → High → Low**
- Determine the **worst-performing agent**
- Log out [1](blob:https://m365.cloud.microsoft/fd5e1627-55b6-49af-b773-12912d6cc0f8)

### Security
The system supports:

- **Authentication**
- **Authorization**
- **Role-based access control**
- **DESede symmetric encryption**
- Error handling for:
  - unauthenticated access
  - unauthorized access
  - non-existent resources
  - invalid field agent IDs (must be numeric and exactly 3 digits) [1](blob:https://m365.cloud.microsoft/fd5e1627-55b6-49af-b773-12912d6cc0f8)

---

## 🛠️ Technologies Used

- Java EE / JEE
- JSP
- Servlets
- EJB
- JDBC
- MySQL
- GlassFish / Payara
- DESede (Triple DES)
- HTML / CSS

---

## 📂 Project Structure

```text
TextSpectaclesSecureApp/
├── src/java/za/ac/textspectacles/
│   ├── controller/
│   │   ├── LoginServlet.java
│   │   ├── LogoutServlet.java
│   │   ├── AgentServlet.java
│   │   └── ManagerServlet.java
│   ├── ejb/
│   │   ├── MessageServiceBean.java
│   │   ├── KeyServiceBean.java
│   │   └── AgentAnalysisBean.java
│   ├── dao/
│   │   ├── DBConnection.java
│   │   ├── MessageDAO.java
│   │   └── KeyDAO.java
│   ├── model/
│   │   ├── Message.java
│   │   ├── UserKey.java
│   │   └── AgentStats.java
│   └── util/
│       ├── CryptoUtil.java
│       ├── ValidationUtil.java
│       └── TimeUtil.java
├── web/
│   ├── agent/
│   ├── manager/
│   ├── errors/
│   ├── resources/
│   └── WEB-INF/
├── setup/
│   └── TextSpectaclesDB.sql
└── README.md
