# Project Structure

```
cdac-hiring-challenge/
│
├── 📄 pom.xml                          # Maven build configuration
├── 📄 README.md                        # Project overview and documentation
├── 📄 QUICKSTART.md                    # Quick 3-step guide
├── 📄 INSTRUCTIONS.md                  # Detailed setup and submission guide
├── 📄 .gitignore                       # Git ignore rules
├── 🔧 build-and-run.sh                # Build script (Linux/Mac)
├── 🔧 build-and-run.bat               # Build script (Windows)
│
├── src/
│   ├── main/
│   │   ├── java/com/cdac/hiring/
│   │   │   │
│   │   │   ├── 📘 WebhookChallengeApplication.java
│   │   │   │   └─ Main Spring Boot application class
│   │   │   │
│   │   │   ├── runner/
│   │   │   │   └── 📘 ChallengeRunner.java
│   │   │   │       └─ ⚠️ EDIT THIS: Add your name, regNo, email
│   │   │   │
│   │   │   ├── service/
│   │   │   │   ├── 📘 WebhookService.java
│   │   │   │   │   └─ Handles API calls (generate webhook, submit solution)
│   │   │   │   │
│   │   │   │   └── 📘 SqlQueryService.java
│   │   │   │       └─ ⚠️ EDIT THIS: Add your SQL query solution
│   │   │   │
│   │   │   └── dto/
│   │   │       ├── 📘 WebhookRequest.java     # Request DTO
│   │   │       ├── 📘 WebhookResponse.java    # Response DTO
│   │   │       └── 📘 SolutionRequest.java    # Solution DTO
│   │   │
│   │   └── resources/
│   │       └── 📄 application.properties      # App configuration
│   │
│   └── test/                                  # (not implemented)
│
└── target/                                    # Generated after build
    └── cdac-hiring-challenge.jar             # 📦 Final JAR file

```

## Key Files to Edit

### 1. `ChallengeRunner.java`
- **Location:** `src/main/java/com/cdac/hiring/runner/ChallengeRunner.java`
- **What to change:** Your personal details (name, regNo, email)
- **Lines:** ~33-37

### 2. `SqlQueryService.java`
- **Location:** `src/main/java/com/cdac/hiring/service/SqlQueryService.java`
- **What to change:** SQL query solutions
- **Methods:** `getQuestion1Query()` and/or `getQuestion2Query()`

## Build Output

After running `mvn clean package`, you'll get:
- `target/cdac-hiring-challenge.jar` - Executable JAR file (this is what you submit)

## Documentation Files

- **QUICKSTART.md** - 3-step guide to complete the challenge
- **README.md** - Full project documentation
- **INSTRUCTIONS.md** - Detailed setup and submission instructions

## Technology Stack

- **Spring Boot 3.2.0** - Application framework
- **Spring WebFlux** - WebClient for REST calls
- **Lombok** - Reduces boilerplate code
- **Jackson** - JSON serialization/deserialization
- **Maven** - Build tool
- **Java 17** - Programming language

## Workflow

```
Application Startup
    ↓
ChallengeRunner.run()
    ↓
WebhookService.executeChallenge()
    ↓
1. generateWebhook() → POST to /generateWebhook/JAVA
    ↓
2. SqlQueryService.generateSqlQuery() → Determine SQL based on regNo
    ↓
3. submitSolution() → POST to /testWebhook/JAVA with JWT
    ↓
Challenge Complete!
```
