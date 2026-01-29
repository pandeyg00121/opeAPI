#  API-First Spring Boot CRUD using OpenAPI Generator (Jakarta)

This project demonstrates how to build a **Spring Boot CRUD REST API using API-First Development** with OpenAPI as the contract and OpenAPI Generator for automatic code generation.

The API design drives the entire backend — controllers and models are generated directly from an OpenAPI YAML file.

---

##  Tech Stack

* Java 17+
* Spring Boot 3.x (Jakarta EE)
* OpenAPI 3 Specification
* OpenAPI Generator
* Maven
* Swagger UI (springdoc)

---

## What This Project Covers

✔ API-first workflow
✔ Contract-driven development
✔ Auto-generated interfaces & models
✔ Jakarta instead of javax
✔ Clean controller implementation
✔ Swagger UI testing

---

## High Level Architecture

```
OpenAPI YAML
     ↓
OpenAPI Generator
     ↓
Generated Interfaces + Models
     ↓
Controller implements interface
     ↓
Spring Boot Application
     ↓
Swagger UI / API Clients
```

---

# 🛠 Prerequisites

Make sure you have:

* Java 17 or higher
* Maven installed
* IntelliJ IDEA (recommended)

Verify:

```bash
java -version
mvn -version
```

---

# 📜 Step-by-Step Setup

---

## Step 1 — Create Spring Boot Project

Use:

* Spring Initializr
* IntelliJ new project
* Or Maven archetype

Include:

* Spring Web
* Validation (optional)

---

## Step 2 — Design API Contract

Create:

```
src/main/resources/openapi/api.yaml
```

This file defines:

* All CRUD endpoints
* Request/response schemas
* Path parameters
* HTTP status codes

👉 This becomes the **single source of truth**.

---

## Step 3 — Configure OpenAPI Generator

Add the OpenAPI Generator Maven plugin in `pom.xml` and configure:

* Input spec → your YAML file
* Generator → Spring
* API package
* Model package
* Interface-only mode
* Jakarta support
* Spring Boot 3 support

---

## Step 4 — Register Generated Sources

Use the Maven build helper plugin to add:

```
target/generated-sources/openapi
```

as a source directory so Spring Boot can compile generated code.

---

## Step 5 — Install Required Dependencies

Add dependencies for:

* Swagger annotations (Jakarta)
* Jackson nullable support
* Springdoc OpenAPI UI

These ensure:

✔ Proper schema mapping
✔ Swagger UI rendering
✔ Compatibility with Spring Boot 3

---

## Step 6 — Generate Code

Run:

```bash
mvn clean generate-sources
```

This generates:

* API interfaces
* Request/response models

inside:

```
target/generated-sources/openapi
```

---

## Step 7 — Implement Controller

Create your controller class and:

* Implement the generated API interface
* Let Spring Boot auto-map endpoints
* Add business logic inside methods

No manual `@RequestMapping` needed — it’s driven by the contract.

---

## Step 8 — Run Application

```bash
mvn spring-boot:run
```

or directly from IntelliJ.

---

# 🧪 API Testing

### Swagger UI (Auto-Generated)

Open:

```
http://localhost:8080/swagger-ui/index.html
```

From here you can:

* Create users
* Fetch users
* Update users
* Delete users

All from the OpenAPI contract.

---

### Alternative

You can also test using:

* Postman
* Curl
* Frontend clients

---

# 📌 Benefits of This Approach

| Traditional   | API-First             |
| ------------- | --------------------- |
| Code first    | Contract first        |
| Manual DTOs   | Auto generated        |
| Manual docs   | Live Swagger          |
| Error prone   | Consistent            |
| Hard to scale | Microservice friendly |

---

# 🚀 Best Practices Used

* Contract-driven development
* Clean separation of concerns
* Jakarta compliance
* Auto documentation
* Build-time code generation

---

# 🔮 Possible Enhancements

* Database integration (JPA/Hibernate)
* Validation rules from YAML
* Global exception handling
* JWT authentication
* API versioning
* CI/CD integration

---

# 📚 Useful Commands

Generate code:

```bash
mvn generate-sources
```

Run app:

```bash
mvn spring-boot:run
```

Clean build:

```bash
mvn clean install
```

---

**“Add advanced production features to this README”**
