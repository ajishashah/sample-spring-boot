# AGENTS

Repository-level instructions for AI coding agents working in this project.

## Scope
- This is a minimal Spring Boot 3.1.x sample app with REST endpoints and Cucumber BDD tests.
- Keep changes small and focused; avoid large refactors unless explicitly requested.

## Quick Start Commands
- Build: `mvn clean package`
- Run app locally: `mvn spring-boot:run`
- Run all tests: `mvn test`
- Run only Cucumber suite: `mvn -Dtest=CucumberTest test`

## Tech Stack
- Java 17, Maven, Spring Boot 3.1.6
- Spring Web + Spring Data JPA
- In-memory H2 database initialized from SQL seed data
- JUnit 5 + Cucumber (JUnit Platform engine)

## Architecture and Boundaries
- API/controller layer: `src/main/java/com/example/demo/GreetingController.java`
- Domain/persistence model: `src/main/java/com/example/demo/Employee.java`
- Repository: `src/main/java/com/example/demo/EmployeeRepository.java`
- App/test config: `src/main/resources/application.properties`
- Seed data: `src/main/resources/data.sql`

## Testing Conventions
- Cucumber feature files live in: `src/test/resources/features`
- Cucumber step definitions live in: `src/test/java/com/example/demo/steps`
- Cucumber suite entrypoint: `src/test/java/com/example/demo/CucumberTest.java`
- Spring wiring for Cucumber: `src/test/java/com/example/demo/CucumberSpringConfiguration.java`
- When adding or changing REST endpoints, update Cucumber scenarios and steps in the same change.

## Endpoint Change Pattern
- Existing employee API patterns use `ResponseEntity` with explicit status behavior for 200/204/400/404.
- Keep request/response contracts backward-compatible unless asked otherwise.
- Validate request payloads defensively (null/blank checks are already used for update-name).

## Data and Runtime Notes
- H2 is configured in-memory and recreated (`create-drop`) for local/test runs.
- Seed records are loaded from `data.sql`; tests may rely on IDs 1 and 2.
- H2 console is enabled at `/h2-console`.

## Existing Customizations
- Prompt shortcut for PR creation: `.github/prompts/create-pr.prompt.md`
- Custom agent for GitHub push + PR workflow: `.github/agents/github-push-pr.agent.md`
- Custom agent for REST API + Cucumber + commit workflow: `.github/agents/cucumber-restapi-commit.agent.md`

## Working Rules for Agents
- Prefer modifying existing patterns over introducing new frameworks.
- Run relevant tests before finishing work; at minimum run targeted tests for changed areas.
- Do not edit generated build output under `target/`.
- Keep commits scoped to the user request.
