#!/bin/bash

echo "=========================================="
echo "  Student Grade Tracker - Starting..."
echo "=========================================="

# Check Java
if ! command -v java &> /dev/null; then
    echo "ERROR: Java not found!"
    echo "Install Java 17: https://adoptium.net"
    exit 1
fi

# Check Maven
if ! command -v mvn &> /dev/null; then
    echo "ERROR: Maven not found!"
    echo "Install Maven: https://maven.apache.org/download.cgi"
    exit 1
fi

echo ""
echo "Building project (first time takes 2-3 minutes)..."
mvn clean package -DskipTests -q

if [ $? -ne 0 ]; then
    echo "BUILD FAILED. Check errors above."
    exit 1
fi

echo ""
echo "=========================================="
echo "  App is starting..."
echo "  Open browser: http://localhost:8080"
echo "  H2 Database:  http://localhost:8080/h2-console"
echo "  Press Ctrl+C to stop"
echo "=========================================="
echo ""

java -jar target/grade-tracker-1.0.0.jar
