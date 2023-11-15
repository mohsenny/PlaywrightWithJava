# Playwright with Java

This repository provides a boilerplate for implementing automated tests using Playwright in Java. It follows the Page-Object model, offering a structured and maintainable approach to writing tests.

## Features

- Comprehensive examples using Playwright with Java.
- Implementation of the Page-Object model for better test maintenance.
- Ready-to-use setup for quick start.

## Prerequisites

- Java (version 8 or higher)
- Maven
- Playwright

## Getting Started

To get started with this boilerplate:

1. Clone the repository:
   ```bash
   git clone https://github.com/mohsenny/PlaywrightWithJava.git

2. Navigate to the cloned directory:
   ```bash
   cd PlaywrightWithJava

3. Install dependencies:
   ```bash
   cd PlaywrightWithJava

## Structure

#### `src/main/java`

- **`Base`**: This directory contains the base classes that are the foundation of the test framework. Common functionalities that are used across different tests are typically placed here. For instance, a `BasePage.java` would include methods and functionalities common to all page objects.

- **`Pages`**: This folder contains the Page Objects, an essential part of the Page-Object model. Each page of the web application you're testing should have a corresponding page object class here. These classes encapsulate the page-specific elements and behaviors. For example, `HomePage.java` would contain elements and actions specific to the home page of the application.

- **`Utils`**: The utilities directory usually includes helper methods and common utilities that are used across the project. These might include file readers, data generators, or any other utility methods that don't belong to a specific page.

- **`Resources`**: For any additional resources such as different languages files containing keys and values for different locales.

#### `src/test/java`

- **`Tests`**: This is where your test cases are located. These tests utilize the page objects defined in `src/main/java/Pages`. Each test class typically corresponds to a set of test scenarios for a specific part of the application. For example, `HomePageTests.java` would contain tests that interact with and verify behaviors of the home page.

#### `src/test/resources`

- **Configuration Files**: If your project contains any configuration files (like properties files to configure browser settings, URLs, etc.), they would typically be placed in this directory. Also any other utility methods, such as reading the translation values in order to avoid hard-cording strings in the tests, could also be included here.

#### Root Directory

- **`pom.xml`**: This is the Maven Project Object Model file. It contains configurations for the project build, including dependencies (like Playwright), plugins, project version, and other build settings.

- **`.gitignore`**: Specifies intentionally untracked files that Git should ignore. This typically includes compiled code, log files, and other artifacts that don't need to be part of the Git repository.

- **`README.md`**: The Markdown document that provides an overview of your project, how to set it up, and how to use it. This is the file where you would include the explanation of the project structure as described above.

### Additional Considerations

- If you have specific configurations for Playwright (like browser setup or test configurations), these details might either be coded within the base classes or set up through external configuration files.
- Depending on how your project evolves, you might also have additional directories for things like shared components, test data, or API clients.

## Contributing
Contributions to this repository are welcome. Please ensure to follow the existing code structure and style.

## License
MIT License
