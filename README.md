# Full Automation Framework for SwagLabs

## Overview
This project is a comprehensive automation framework designed for testing the SwagLabs website. It is built using **Java**, **Selenium WebDriver**, and **TestNG**, following industry best practices for scalability, maintainability, and readability.

## Key Features
- **Cross-Browser Testing**: Supports Chrome, Edge, and Firefox browsers.
- **Data-Driven Testing**: Utilizes JSON files for flexible and reusable test data.
- **Page Object Model (POM)**: Implements POM for better code organization and maintainability.
- **Fluent Pattern**: Simplifies method chaining for improved readability and concise test scripts.
- **Logging and Reporting**: Integrates logging utilities and generates detailed test execution reports using **Allure**.
- **Reusable Utilities**: Provides utility classes for common actions like element interactions, waits, and validations.
FullAutomationFrameworkSwagLabs/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── Com/
│   │   │   │   ├── SwagLabs/
│   │   │   │   │   ├── Driver/         # WebDriver management
│   │   │   │   │   ├── Pages/          # Page Object Model classes
│   │   │   │   │   ├── Utils/          # Utility classes (e.g., actions, waits, logs)
│   ├── test/
│   │   ├── java/
│   │   │   ├── Com/
│   │   │   │   ├── SwagLabs/
│   │   │   │   │   ├── Tests/          # Test classes
│   │   ├── resources/
│   │   │   ├── Login_Data.json         # Test data
├── pom.xml                              # Maven configuration

Key Classes

DriverManager: Manages WebDriver instances and browser configurations.
ElementActions: Provides reusable methods for interacting with web elements (e.g., clicks, text input, and validations).
JsonUtils: Reads and parses test data from JSON files.
LoginPage: Handles login-related actions and validations.
CompletePage: Validates order completion and confirmation messages.

Test Scenarios
The framework includes the following test scenarios:  
Login with valid credentials: Verifies successful login functionality.
Add items to the cart: Ensures items can be added to the cart and their details are displayed correctly.
Perform checkout: Validates the checkout process and order completion.

Reporting
Allure Reports: The framework generates detailed Allure reports for test execution, including step-by-step logs, screenshots, and test results.
