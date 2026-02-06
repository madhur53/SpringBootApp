# SETUP AND SUBMISSION INSTRUCTIONS

## Step 1: Update Your Details

Edit the file: `src/main/java/com/cdac/hiring/runner/ChallengeRunner.java`

Replace the placeholder values:
```java
WebhookRequest request = new WebhookRequest(
    "Your Full Name",        // Your actual name
    "YOUR_REG_NUMBER",       // Your registration number (e.g., REG12347)
    "your.email@example.com" // Your email address
);
```

## Step 2: Get and Add SQL Queries

1. Access the Google Drive links from the challenge document:
   - Question 1 (Odd regNo): https://drive.google.com/file/d/1LAPx2to9zmN5NDY0tkMrJRnVXf1guNr/view?usp=sharing
   - Question 2 (Even regNo): https://drive.google.com/file/d/1b0p5C-6fUrUQglJVaWWAAB3P12IfoBCH/view?usp=sharing

2. Download and solve the SQL problem for your registration number:
   - If last 2 digits are ODD → Use Question 1
   - If last 2 digits are EVEN → Use Question 2

3. Edit: `src/main/java/com/cdac/hiring/service/SqlQueryService.java`

4. Replace the placeholder SQL queries:
   ```java
   private String getQuestion1Query() {
       return "YOUR_ACTUAL_SQL_QUERY_HERE";
   }

   private String getQuestion2Query() {
       return "YOUR_ACTUAL_SQL_QUERY_HERE";
   }
   ```

## Step 3: Build the Project

```bash
cd cdac-hiring-challenge
mvn clean package
```

This creates: `target/cdac-hiring-challenge.jar`

## Step 4: Test the Application

```bash
java -jar target/cdac-hiring-challenge.jar
```

Check the logs to ensure:
- ✅ Webhook generated successfully
- ✅ SQL query created
- ✅ Solution submitted successfully

## Step 5: Prepare for Submission

### Create GitHub Repository

1. Initialize git (if not already done):
```bash
git init
git add .
git commit -m "Initial commit - CDAC Hiring Challenge"
```

2. Create a new repository on GitHub (public)

3. Push your code:
```bash
git remote add origin https://github.com/YOUR_USERNAME/YOUR_REPO.git
git branch -M main
git push -u origin main
```

4. Add the JAR file to your repository:
```bash
# Remove JAR from gitignore temporarily or force add
git add -f target/cdac-hiring-challenge.jar
git commit -m "Add JAR file"
git push
```

### Get RAW JAR Link

The RAW downloadable link format:
```
https://github.com/YOUR_USERNAME/YOUR_REPO/raw/main/target/cdac-hiring-challenge.jar
```

Or use GitHub Releases:
1. Go to your repository → Releases → Create a new release
2. Upload `cdac-hiring-challenge.jar`
3. Publish release
4. Copy the download URL

## Step 6: Submit

Go to: https://forms.office.com/r/bDts9GjetN

Provide:
1. GitHub repository URL: `https://github.com/YOUR_USERNAME/YOUR_REPO.git`
2. RAW JAR download link
3. Any other required information

## Verification Checklist

Before submitting, verify:

- [ ] Personal details updated in ChallengeRunner.java
- [ ] Correct SQL query added in SqlQueryService.java
- [ ] Application builds successfully (`mvn clean package`)
- [ ] Application runs and completes challenge (`java -jar target/cdac-hiring-challenge.jar`)
- [ ] All code pushed to GitHub
- [ ] Repository is PUBLIC
- [ ] JAR file is accessible in repository
- [ ] RAW JAR download link works

## Troubleshooting

**Build fails:**
- Ensure Java 17+ is installed: `java -version`
- Ensure Maven is installed: `mvn -version`

**Application fails to run:**
- Check logs for specific error
- Verify API endpoints are accessible
- Ensure your details are correct

**JAR not found:**
- Run `mvn clean package` again
- Check `target/` directory

**GitHub issues:**
- Ensure repository is public
- Verify you have push access
- Check .gitignore isn't excluding necessary files

## Need Help?

Review:
- README.md - Project overview and structure
- Source code comments - Detailed explanations
- Challenge document - Original requirements

Good luck! 🚀
