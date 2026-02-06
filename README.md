# CDAC Hiring Challenge - Java Spring Boot

This is a Spring Boot application built for the CDAC Hiring Challenge that automatically executes on startup.

## Overview

The application:
1. Sends a POST request to generate a webhook on startup
2. Determines which SQL question to solve based on registration number (odd/even)
3. Submits the SQL solution using JWT authentication

## Prerequisites

- Java 17 or higher
- Maven 3.6+

## Configuration

Before running the application, update the following in `ChallengeRunner.java`:

```java
WebhookRequest request = new WebhookRequest(
    "Your Name",              // Replace with your name
    "YOUR_REG_NO",           // Replace with your registration number
    "your@email.com"         // Replace with your email
);
```

**IMPORTANT**: Also update the SQL queries in `SqlQueryService.java`:
- `getQuestion1Query()` - For odd registration numbers
- `getQuestion2Query()` - For even registration numbers

Access the Google Drive links provided in the challenge document to get the actual SQL questions.

## Building the Application

```bash
mvn clean package
```

This will create a JAR file at: `target/cdac-hiring-challenge.jar`

## Running the Application

```bash
java -jar target/cdac-hiring-challenge.jar
```

The application will:
1. Start up
2. Execute the challenge workflow automatically
3. Log all steps to the console
4. Shut down after completion (or you can keep it running)

## Project Structure

```
src/
├── main/
│   ├── java/com/cdac/hiring/
│   │   ├── WebhookChallengeApplication.java  # Main Spring Boot class
│   │   ├── dto/
│   │   │   ├── WebhookRequest.java           # Request DTO for webhook generation
│   │   │   ├── WebhookResponse.java          # Response DTO from webhook
│   │   │   └── SolutionRequest.java          # Request DTO for solution submission
│   │   ├── service/
│   │   │   ├── WebhookService.java           # Handles API calls
│   │   │   └── SqlQueryService.java          # Generates SQL queries
│   │   └── runner/
│   │       └── ChallengeRunner.java          # Executes on startup
│   └── resources/
│       └── application.properties             # Application configuration
```

## Key Features

- ✅ Automatic execution on startup (no controller needed)
- ✅ Uses WebClient for REST API calls
- ✅ JWT authentication in Authorization header
- ✅ Dynamic SQL query selection based on registration number
- ✅ Comprehensive logging
- ✅ Error handling

## Technologies Used

- Spring Boot 3.2.0
- Spring WebFlux (WebClient)
- Lombok
- Jackson (JSON processing)
- Maven

## API Endpoints Used

1. **Generate Webhook**
   - URL: `https://bfhldevapigw.healthrx.co.in/hiring/generateWebhook/JAVA`
   - Method: POST
   - Body: `{"name": "...", "regNo": "...", "email": "..."}`

2. **Submit Solution**
   - URL: `https://bfhldevapigw.healthrx.co.in/hiring/testWebhook/JAVA`
   - Method: POST
   - Headers: `Authorization: <accessToken>`
   - Body: `{"finalQuery": "YOUR_SQL_QUERY"}`

## Logs

The application provides detailed logging:
- Request/response details
- SQL query generated
- Submission status
- Any errors encountered

## Troubleshooting

If you encounter issues:

1. **Connection errors**: Check your internet connection
2. **Authentication errors**: Verify the access token is being passed correctly
3. **SQL query errors**: Ensure you've updated the SQL queries with actual solutions
4. **Build errors**: Ensure Java 17+ and Maven are properly installed

## Notes

- The application uses `ApplicationRunner` to execute on startup
- No REST controllers are implemented as per requirements
- The JAR file is standalone and can be run anywhere with Java 17+

## Author

[Your Name] - CDAC Hiring Challenge Submission
"# SpringBootApp" 
