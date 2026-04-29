# Sauce Demo Automation

UI automation framework for [SauceDemo](https://www.saucedemo.com/) using Selenium WebDriver, Cucumber, and TestNG.

## Tech Stack

- Java
- Maven
- Selenium WebDriver
- Cucumber (BDD)
- TestNG

## Project Structure

```text
sauce-demo-automation/
  resources/
    config.properties
    features/
      Login.feature
      checkout.feature
  src/test/java/
    hooks/
    pages/
    runners/
    stepdefinitions/
    utils/
```

## Prerequisites

- Java 8+ installed
- Maven installed and available in PATH (`mvn -v`)
- Chrome/Edge/Firefox browser installed

## Configuration

Update `sauce-demo-automation/resources/config.properties`:

- `browser=edge` (or `chrome`, `firefox`)
- `url=https://www.saucedemo.com/`

## Run Tests

From project directory:

```bash
cd sauce-demo-automation
mvn clean test
```

## Reports

After execution, reports are generated at:

- `sauce-demo-automation/target/surefire-reports/`
- `sauce-demo-automation/target/cucumber-report.html`
- `sauce-demo-automation/report.html` (if generated)

## Covered Scenarios

- Invalid login validations (multiple users/passwords)
- Successful purchase checkout flow

## Notes

- Browser setup is handled in `DriverFactory`.
- Test hooks for setup/teardown are in `Hooks`.
- Feature files use Cucumber BDD syntax for readability and collaboration.