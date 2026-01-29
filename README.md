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

#  Step-by-Step Setup

---

## Step 1 — Create Spring Boot Project

Use:

* Spring Initializr
* IntelliJ new project
* Or Maven archetype

Include Dependencies:

* Spring Web
* Validation
* Lombok (optional)
  
* Swagger annotations (Jakarta)
* Jackson nullable support
* Springdoc OpenAPI UI

---

## Step 2 — Design API Contract

Create:
```
src/main/resources/openapi/api.yaml
```
This becomes the **single source of truth**.
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

## Step 4 — Register Generated Sources (IMP)

Use the Maven build helper plugin to add:

```
target/generated-sources/openapi
```

as a source directory so Spring Boot can compile generated code.

---


## Step 5 — Generate Code

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

## Step 6 — Implement Controller

Create your controller class and:

No manual `@RequestMapping` needed — it’s driven by the contract.

---

## Step 7 — Run Application

```bash
mvn spring-boot:run
```
---

#  API Testing

### Swagger UI (Auto-Generated)

Open:

```
http://localhost:8080/swagger-ui/index.html
```
OR

```bash
curl -X POST http://localhost:8080/users \
-H "Content-Type: application/json" \
-d '{"name":"Pranay","email":"pranay@gmail.com"}'
```

From here you can:

* Create users
* Fetch users
* Update users
* Delete users

All from the OpenAPI contract.

---


#  Benefits of This Approach

| Traditional   | API-First             |
| ------------- | --------------------- |
| Code first    | Contract first        |
| Manual DTOs   | Auto generated        |
| Manual docs   | Live Swagger          |
| Error prone   | Consistent            |
| Hard to scale | Microservice friendly |

---

Refer to this chat for handling errors :
https://chatgpt.com/share/697bbd16-43cc-8006-b11f-dd2713010f4a
