
# Selenium Automation Framework

Professional Selenium automation framework using:

- Java 17
- Selenium WebDriver
- Gradle
- JUnit 5
- WebDriverManager
- Page Object Model

## Project Structure

src
 ├── main
 │   └── java
 │       └── framework
 │           ├── config
 │           │   └── ConfigReader.java
 │           ├── driver
 │           │   └── DriverFactory.java
 │           └── utils
 │               └── ScreenshotUtil.java
 │
 └── test
     └── java
         ├── base
         │   └── BaseTest.java
         ├── pages
         │   └── GooglePage.java
         └── tests
             └── GoogleTest.java

## Main Concepts

### DriverFactory
Responsible for creating WebDriver instances.

### BaseTest
Base class for all tests.

### Page Object Model
Pages encapsulate UI interactions.

### ConfigReader
Loads configuration such as browser type.

## Running Tests

Run tests using Gradle:

```
./gradlew test
```

or

```
gradle test
```

## Browser Configuration

Edit:

src/test/resources/config.properties

Example:

```
browser=chrome
```

Supported browsers:

- chrome
- firefox
- edge

## Parallel Execution

Parallel test execution is enabled via JUnit 5 configuration in `build.gradle`.

## Future Improvements

Possible extensions:

- Allure reporting
- CI/CD integration
- Docker execution
- Test data management
- Environment profiles
