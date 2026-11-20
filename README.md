# MediSupply Platform

## Overview

RESTful API for MediSupply Platform

## Authorship

- Private repository: `https://github.com/Matthewnhfe/pc27793u202421065
- Author: Carlos Matthew Salcedo Correa

## Tech Stack

Java 27, Spring Boot 4.1.3, Spring Data JPA, MySQL, springdoc-openapi (Swagger UI), Lombok.

## Shared bounded context

- `shared.application.result`: `Result` (Success / Failure) and `ApplicationError`.
- `shared.domain.model.aggregates`: `AbstractDomainAggregateRoot`.
- `shared.infrastructure`: snake_case + plural physical naming strategy, `AuditableAbstractPersistenceEntity`,
  domain events publisher, i18n `LocaleResolver`, virtual threads and OpenAPI configuration.
- `shared.interfaces.rest`: `GlobalExceptionHandler`, `ResponseEntityAssembler`, `ProblemDetailFromApplicationErrorAssembler`.

## Run

```bash
mvn spring-boot:run   # http://localhost:8080/swagger-ui.html
```
