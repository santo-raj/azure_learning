# 🏦 Azure Banking Backend (Spring Boot + Azure Cloud)

## 🚀 Project Summary
Designed and deployed a **cloud-native banking backend system** using **Java (Spring Boot)** on **Microsoft Azure App Service**.  
This project demonstrates hands-on experience in **cloud deployment, REST API development, and production debugging**.

---

## 🌐 Live Application
- **Base URL:**  
  https://santobank.azurewebsites.net

- **Sample Endpoint:**
  GET /hello

- **Response:**
```json
{
  "message": "Hello from Azure Banking App 🚀"
}

🧱 Architecture Overview

Client (Browser / Postman)
        ↓
Azure App Service (Linux, Java 21 - F1)
        ↓
Spring Boot REST API (Embedded Tomcat)
        ↓
(Next Phase) Azure SQL Database

⚙️ Tech Stack

| Category       | Technology                         |
| -------------- | ---------------------------------- |
| Language       | Java 21                            |
| Framework      | Spring Boot                        |
| Cloud Platform | Microsoft Azure                    |
| Hosting        | Azure App Service (Linux, Java SE) |
| Build Tool     | Maven                              |
| API Style      | RESTful APIs (JSON)                |


📊 Project Progress
| Date       | Milestone      | Description                                      |
| ---------- | -------------- | ------------------------------------------------ |
| 2026-04-26 | Cloud Setup    | Configured Azure subscription and resources      |
| 2026-04-26 | App Deployment | Deployed Spring Boot JAR to Azure App Service    |
| 2026-04-26 | Debugging      | Resolved runtime, startup, and deployment issues |
| 2026-04-26 | Live API       | Successfully exposed REST endpoint publicly      |
