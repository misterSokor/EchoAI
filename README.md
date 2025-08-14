
# <img width="311" height="264" alt="Screen Shot 2025-08-13 at 21 59 27" src="https://github.com/user-attachments/assets/e49c247d-82a8-49a3-8f80-08b6e022748d" />
choAI — Simple Chat API 🤖🗣️

![Build Status](https://img.shields.io/badge/build-passing-brightgreen)
![License](https://img.shields.io/badge/License-MIT-yellow.svg)

> **Status:** `0.0.1-SNAPSHOT` (generated 2025-08-14)  
> A minimal Spring Boot REST API that forwards chat prompts to an OpenAI-compatible API and returns the model's response.

---

## 📑 Table of Contents
1. [✨ Features](#-features)
2. [🛠 Tech Stack](#-tech-stack)
3. [📂 Project Structure](#-project-structure)
4. [🌐 API Overview](#-api-overview)
5. [⚙️ Configuration](#️-configuration)
6. [🚀 Getting Started](#-getting-started)
7. [📸 Screenshots & Demos](#-screenshots--demos)
8. [🤝 Contributing](#-contributing)
9. [🗺 Roadmap](#-roadmap)
10. [📜 License](#-license)

---

## ✨ Features
- POST endpoint to send a prompt and get a model reply
- Pluggable model via `openai.model` property (e.g., `gpt-4o`)
- Centralized HTTP client via `OpenAIRestTemplateConfig`
- Clean DTOs: `ChatRequest`, `ChatResponse` with nested `Choice`
- Simple domain model: `Message`

---

## 🛠 Tech Stack
- ☕ Java 17
- 🚀 Spring Boot
- 🌐 Spring Web (RestTemplate)
- 🧩 Jackson (JSON)
- 🐘 Maven

---

## 📂 Project Structure (selected)
```
com/sokortech/echoai/
  EchoAiApplication.class
  config/
    OpenAIRestTemplateConfig.class
  controller/
    ChatController.class
  dto/
    ChatRequest.class
    ChatResponse.class
    ChatResponse$Choice.class
  model/
    Message.class
application.properties
```

---

## 🌐 API Overview
<details>
<summary>Click to expand API endpoints</summary>

### 💬 Chat
- **POST** `/api/chat`  
  **Body:**  
  ```json
  {
    "message": "Say hello to the world",
    "model": "gpt-4o"
  }
  ```
  **Response (example):**
  ```json
  {
    "choices": [{ "message": {"role":"assistant","content":"Hello, world!"} }]
  }
  ```

</details>

---

## ⚙️ Configuration
> **Never commit real API keys.**
Set values via **environment variables** or an external `application-*.properties` file.

Default properties (from `application.properties` in the JAR):
```properties
spring.application.name=EchoAI
openai.model=gpt-4o
openai.api-base=https://api.openai.com/v1
# openai.api-key=...  (Use an environment variable)
```

Recommended environment variables:
```bash
export OPENAI_API_KEY="your-api-key"
export OPENAI_MODEL="gpt-4o"
export OPENAI_API_BASE="https://api.openai.com/v1"
```

Spring mapping (example):
```properties
openai.api-key=${OPENAI_API_KEY}
openai.model=${OPENAI_MODEL:gpt-4o}
openai.api-base=${OPENAI_API_BASE:https://api.openai.com/v1}
```

---

## 🚀 Getting Started

### ▶ Run (Maven)
```bash
mvn spring-boot:run
```

### ▶ Run (JAR)
```bash
mvn -DskipTests package
java -jar target/EchoAI-0.0.1-SNAPSHOT.jar
```

### 🔎 Test the API
```bash
curl -X POST http://localhost:8080/api/chat   -H "Content-Type: application/json"   -d '{"message":"Say a short poem about spring"}'
```

> If your implementation reads the key from config (typical), you **do not** send the OpenAI key as a header to your API. It stays server-side.

---

## 📸 Screenshots & Demos
*(Replace with actual images/GIFs of a request/response in Postman or curl output)*

![Demo Screenshot](https://via.placeholder.com/800x400.png?text=EchoAI+Chat+Demo)

---

## 🤝 Contributing
1. Fork the repo
2. Create a branch: `git checkout -b feature/your-feature`
3. Commit: `git commit -m "Add your feature"`
4. Push: `git push origin feature/your-feature`
5. Open a PR

---

## 🗺 Roadmap
- ✅ Basic chat relay
- ⏳ Streaming responses (Server-Sent Events)
- ⏳ Error handling & retry/backoff
- ⏳ Switch to WebClient and reactive pipeline
- ⏳ OpenAPI/Swagger docs
- ⏳ Dockerfile + Compose
- ⏳ Simple UI client

---

## 📜 License
MIT (update as needed)
