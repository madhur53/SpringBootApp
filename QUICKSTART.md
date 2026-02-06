# Quick Start Guide

## 🚀 3 Steps to Complete the Challenge

### 1️⃣ Configure Your Details (2 minutes)

**File:** `src/main/java/com/cdac/hiring/runner/ChallengeRunner.java`

```java
WebhookRequest request = new WebhookRequest(
    "John Doe",      // ← Change to YOUR name
    "REG12347",      // ← Change to YOUR registration number  
    "john@xyz.com"   // ← Change to YOUR email
);
```

### 2️⃣ Add Your SQL Query (5 minutes)

**File:** `src/main/java/com/cdac/hiring/service/SqlQueryService.java`

**Check your registration number:**
- Last 2 digits ODD (e.g., 47, 33, 21)? → Use Question 1
- Last 2 digits EVEN (e.g., 46, 32, 20)? → Use Question 2

**Get the question from Google Drive:**
- Question 1: https://drive.google.com/file/d/1LAPx2to9zmN5NDY0tkMrJRnVXf1guNr/view
- Question 2: https://drive.google.com/file/d/1b0p5C-6fUrUQglJVaWWAAB3P12IfoBCH/view

**Solve it and paste your SQL:**

```java
// For ODD registration numbers
private String getQuestion1Query() {
    return "YOUR SQL QUERY HERE";  // ← Paste your solution
}

// For EVEN registration numbers
private String getQuestion2Query() {
    return "YOUR SQL QUERY HERE";  // ← Paste your solution
}
```

### 3️⃣ Build, Run & Submit (3 minutes)

**Build & Test:**
```bash
# Linux/Mac
./build-and-run.sh

# Windows
build-and-run.bat

# Or manually
mvn clean package
java -jar target/cdac-hiring-challenge.jar
```

**Push to GitHub:**
```bash
git init
git add .
git commit -m "CDAC Hiring Challenge Solution"
git remote add origin https://github.com/YOUR_USERNAME/YOUR_REPO.git
git push -u origin main

# Add JAR file
git add -f target/cdac-hiring-challenge.jar
git commit -m "Add JAR file"
git push
```

**Submit at:** https://forms.office.com/r/bDts9GjetN

Provide:
- GitHub URL: `https://github.com/YOUR_USERNAME/YOUR_REPO.git`
- JAR URL: `https://github.com/YOUR_USERNAME/YOUR_REPO/raw/main/target/cdac-hiring-challenge.jar`

---

## ✅ That's It!

**Total Time:** ~10 minutes

**What the app does:**
1. ✅ Sends POST request on startup
2. ✅ Gets webhook URL and access token
3. ✅ Determines your SQL question (odd/even)
4. ✅ Submits your SQL solution with JWT auth

**No manual API calls needed - it's all automatic!**

---

## 🆘 Troubleshooting

| Problem | Solution |
|---------|----------|
| Build fails | Install Java 17+ and Maven 3.6+ |
| Can't run JAR | Use `java -jar target/cdac-hiring-challenge.jar` |
| Wrong SQL question | Check last 2 digits of your regNo |
| GitHub push fails | Make sure repository is public |

---

## 📁 Project Structure (Just FYI)

```
cdac-hiring-challenge/
├── src/main/java/com/cdac/hiring/
│   ├── WebhookChallengeApplication.java    # Main app
│   ├── runner/ChallengeRunner.java         # ← EDIT: Your details
│   ├── service/SqlQueryService.java        # ← EDIT: Your SQL
│   ├── service/WebhookService.java         # API handler
│   └── dto/                                # Data objects
├── pom.xml                                 # Maven config
├── README.md                               # Full documentation
└── INSTRUCTIONS.md                         # Detailed guide
```

**Only edit the 2 files marked with ← EDIT**

Good luck! 🎯
