# Student Grade Tracker
### Java Full Stack — Spring Boot 3 + React + H2 Database

---

## What's Inside

| Layer | Technology |
|-------|-----------|
| Backend | Spring Boot 3.2, Spring Data JPA, Spring Validation |
| Database | H2 (in-memory, zero setup) |
| Frontend | React 18 (built-in, no npm needed) |
| Build | Maven 3.8+ |
| Java | 17+ |

---

## HOW TO RUN (3 steps)

### Step 1 — Install Requirements
- **Java 17+** → https://adoptium.net  (choose JDK 17 LTS)
- **Maven 3.8+** → https://maven.apache.org/download.cgi

Verify:
```
java -version     # should say 17 or higher
mvn -version      # should say 3.x.x
```

### Step 2 — Run the App

**Windows:**
```
Double-click run.bat
```

**Mac / Linux:**
```bash
chmod +x run.sh
./run.sh
```

**Or manually:**
```bash
mvn clean package -DskipTests
java -jar target/grade-tracker-1.0.0.jar
```

### Step 3 — Open in Browser
```
http://localhost:8080
```

That's it! The app opens with 4 sample students and grades pre-loaded.

---

## Features

- Add / remove students with name, roll number, department, email
- Add / remove grades per student (subject, marks, max marks, semester)
- Auto-calculated percentage and letter grade (A+, A, B, C, D, F)
- Class analytics: average, distribution, department breakdown, top performers
- Search students by name, roll number, or department
- H2 database console at http://localhost:8080/h2-console

---

## REST API Reference

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /api/students | Get all students |
| GET | /api/students/{id} | Get student by ID |
| GET | /api/students/search?q=text | Search students |
| GET | /api/students/department/{dept} | Filter by department |
| POST | /api/students | Create student |
| PUT | /api/students/{id} | Update student |
| DELETE | /api/students/{id} | Delete student |
| POST | /api/students/{id}/grades | Add grade |
| PUT | /api/grades/{gradeId} | Update grade |
| DELETE | /api/grades/{gradeId} | Delete grade |
| GET | /api/analytics | Full analytics summary |

### Sample API Calls (use Postman or curl)

**Create a student:**
```bash
curl -X POST http://localhost:8080/api/students \
  -H "Content-Type: application/json" \
  -d '{"firstName":"Aarav","lastName":"Sharma","rollNumber":"CS001","department":"Computer Science","email":"aarav@college.edu"}'
```

**Add a grade:**
```bash
curl -X POST http://localhost:8080/api/students/1/grades \
  -H "Content-Type: application/json" \
  -d '{"subject":"Mathematics","marks":88,"maxMarks":100,"semester":"Sem 1"}'
```

**Get analytics:**
```bash
curl http://localhost:8080/api/analytics
```

---

## H2 Database Console

1. Go to http://localhost:8080/h2-console
2. JDBC URL: `jdbc:h2:mem:gradedb`
3. Username: `sa`  |  Password: *(leave blank)*
4. Click Connect

Run SQL:
```sql
SELECT * FROM STUDENTS;
SELECT * FROM GRADES;
SELECT s.first_name, s.last_name, g.subject, g.marks
FROM STUDENTS s JOIN GRADES g ON g.student_id = s.id;
```

---

## Project Structure

```
grade-tracker/
├── src/main/java/com/gradetracker/
│   ├── GradeTrackerApplication.java     ← App entry point
│   ├── DataInitializer.java             ← Sample data on startup
│   ├── model/
│   │   ├── Student.java                 ← Student entity (@Entity)
│   │   └── Grade.java                   ← Grade entity (@Entity)
│   ├── repository/
│   │   ├── StudentRepository.java       ← DB access (JpaRepository)
│   │   └── GradeRepository.java
│   ├── service/
│   │   └── StudentService.java          ← Business logic
│   ├── controller/
│   │   └── StudentController.java       ← REST endpoints
│   └── exception/
│       ├── ResourceNotFoundException.java
│       └── GlobalExceptionHandler.java
├── src/main/resources/
│   ├── application.properties           ← Config
│   └── static/
│       └── index.html                   ← React frontend
├── pom.xml                              ← Maven dependencies
├── run.bat                              ← Windows launcher
└── run.sh                               ← Mac/Linux launcher
```

---

## Switch to MySQL (for production)

1. Add to `pom.xml`:
```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <scope>runtime</scope>
</dependency>
```

2. Update `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/gradedb
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.h2.console.enabled=false
```

---

## Grade Scale

| Grade | Percentage |
|-------|-----------|
| A+ | 90 – 100% |
| A | 80 – 89% |
| B | 70 – 79% |
| C | 60 – 69% |
| D | 50 – 59% |
| F | Below 50% |

---

Built with Spring Boot 3 · React 18 · H2 · Lombok · Maven
