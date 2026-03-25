@echo off
echo ==========================================
echo   Student Grade Tracker - Starting...
echo ==========================================

REM Check Java
java -version >nul 2>&1
if %errorlevel% neq 0 (
    echo ERROR: Java not found!
    echo Please install Java 17 from https://adoptium.net
    pause
    exit /b 1
)

REM Check Maven
mvn -version >nul 2>&1
if %errorlevel% neq 0 (
    echo ERROR: Maven not found!
    echo Please install Maven from https://maven.apache.org/download.cgi
    pause
    exit /b 1
)

echo.
echo Building project (first time takes 2-3 minutes)...
call mvn clean package -DskipTests -q

if %errorlevel% neq 0 (
    echo BUILD FAILED. Check errors above.
    pause
    exit /b 1
)

echo.
echo ==========================================
echo   App is starting...
echo   Open browser: http://localhost:8080
echo   H2 Database:  http://localhost:8080/h2-console
echo   Press Ctrl+C to stop
echo ==========================================
echo.

java -jar target\grade-tracker-1.0.0.jar
pause
