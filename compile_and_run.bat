@echo off
echo Compiling ChoreSplitterApp.java...
cd src
javac ChoreSplitterApp.java
if %errorlevel% neq 0 (
    echo.
    echo ERROR: Compilation failed. Make sure Java JDK is installed and in your PATH.
    echo.
    echo To install Java:
    echo 1. Download JDK from https://www.oracle.com/java/technologies/downloads/
    echo 2. Install it
    echo 3. Add Java bin directory to your PATH environment variable
    pause
    exit /b 1
)

echo.
echo Compilation successful! Running the application...
echo.
java ChoreSplitterApp
pause

