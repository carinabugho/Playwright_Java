# Playwright Java - CI/CD with GitHub Actions

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

## 📌 Features
- **Java + Playwright** setup for end-to-end browser automation
- **CI/CD** integration with GitHub Actions
- Automatically runs tests on:
  - Push to `main`
  - Pull request to `main`
  - Manual trigger via workflow dispatch

## 🚀 How the CI/CD Works
1. **Trigger**  
   The workflow runs automatically when:
   - Code is pushed to the `main` branch
   - A pull request is opened against `main`
   - Manually triggered from GitHub Actions

2. **Actions Performed**
   - Checkout repository
   - Set up Java environment
   - Install dependencies
   - Install Playwright browsers
   - Run all Playwright tests
   - Upload test results as an artifact
3. **Workflow File**  
   The CI/CD configuration is located in: .github/workflows/playwright-ci.yml

4. ## ▶️ How to Manually Re-run the Pipeline
1. Go to the **Actions** tab in this repository.
2. Select **Playwright Tests CI** workflow from the left panel.
3. Click on the latest run or **Run workflow** button (top right).
4. Select the branch (e.g., `main`) and click **Run workflow**.
5. Wait for the job to complete — results will appear in the logs.
