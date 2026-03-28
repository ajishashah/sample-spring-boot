# springboot-sample

Minimal Spring Boot sample application.

Run locally:

```bash
cd springboot_sample
mvn spring-boot:run
```

Build and run jar:

```bash
mvn package
java -jar target/springboot-sample-0.0.1-SNAPSHOT.jar
```

Test:

```bash
mvn test
```

Open http://localhost:8080/greeting or http://localhost:8080/greeting?name=Bob
