# Playwright Java Automation Framework

This repository contains an automated testing framework built with [Playwright](https://playwright.dev/java/) and **Java**, using **TestNG** for test execution.  
It demonstrates an end-to-end UI testing setup for web applications, following the **Page Object Model (POM)** design pattern for better maintainability.

---

## 📂 Project Structure
src/test/java
├── pages # Page Object Model classes (UI actions & locators)
├── tests # Test classes (organized by feature or flow)
├── utils # Utility classes (data providers, helpers, etc.)
Smoke.xml # TestNG suite file
pom.xml # Maven dependencies

## 🚀 Setup & Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/carinabugho/Playwright_Java.git

Navigate into the project
cd Playwright_Java

Install dependencies
mvn clean install

Install Playwright browsers
mvn exec:java -e -Dexec.mainClass="com.microsoft.playwright.CLI" -Dexec.args="install"

To execute the TestNG suite:
mvn test -DsuiteXmlFile=Smoke.xml
