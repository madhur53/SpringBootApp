#!/bin/bash

echo "========================================="
echo "CDAC Hiring Challenge - Build & Run"
echo "========================================="
echo ""

# Check if Maven is installed
if ! command -v mvn &> /dev/null
then
    echo "❌ Maven is not installed. Please install Maven first."
    exit 1
fi

# Check if Java is installed
if ! command -v java &> /dev/null
then
    echo "❌ Java is not installed. Please install Java 17 or higher."
    exit 1
fi

echo "✅ Maven found: $(mvn -version | head -n 1)"
echo "✅ Java found: $(java -version 2>&1 | head -n 1)"
echo ""

# Clean and build
echo "📦 Building the project..."
mvn clean package -DskipTests

if [ $? -eq 0 ]; then
    echo ""
    echo "✅ Build successful!"
    echo ""
    echo "JAR location: target/cdac-hiring-challenge.jar"
    echo ""
    echo "========================================="
    echo "Running the application..."
    echo "========================================="
    echo ""
    
    # Run the JAR
    java -jar target/cdac-hiring-challenge.jar
else
    echo ""
    echo "❌ Build failed. Please check the errors above."
    exit 1
fi
