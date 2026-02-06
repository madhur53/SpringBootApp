@echo off
echo =========================================
echo CDAC Hiring Challenge - Build ^& Run
echo =========================================
echo.

REM Check if Maven is installed
where mvn >nul 2>nul
if %ERRORLEVEL% NEQ 0 (
    echo ❌ Maven is not installed. Please install Maven first.
    exit /b 1
)

REM Check if Java is installed
where java >nul 2>nul
if %ERRORLEVEL% NEQ 0 (
    echo ❌ Java is not installed. Please install Java 17 or higher.
    exit /b 1
)

echo ✅ Maven and Java found
echo.

REM Clean and build
echo 📦 Building the project...
call mvn clean package -DskipTests

if %ERRORLEVEL% EQU 0 (
    echo.
    echo ✅ Build successful!
    echo.
    echo JAR location: target\cdac-hiring-challenge.jar
    echo.
    echo =========================================
    echo Running the application...
    echo =========================================
    echo.
    
    REM Run the JAR
    java -jar target\cdac-hiring-challenge.jar
) else (
    echo.
    echo ❌ Build failed. Please check the errors above.
    exit /b 1
)
