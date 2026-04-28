## Why

The project direction is defined, but the repository does not yet have a runnable Java application structure, build configuration, or testing setup. Establishing that foundation now creates a stable baseline for future feature changes and proves that the chosen Java 21, JavaFX, Maven, and JUnit 5 stack works end to end.

## What Changes

- Create the initial Maven-based project structure using standard `src/main/java` and `src/test/java` source roots.
- Establish the `coffeeshop.*` package convention, with MVC-related application classes organized under `coffeeshop.app`.
- Add a minimal pure-JavaFX runnable skeleton that demonstrates application startup without introducing feature-specific behavior.
- Add JUnit 5 test wiring and at least one passing test to prove test execution works.
- Add repository hygiene files such as `.gitignore` to support normal Java and Maven development.
- Define the long-lived `project-structure` capability so future changes inherit the same structural expectations.

## Capabilities

### New Capabilities
- `project-structure`: Defines the baseline Maven layout, package conventions, JavaFX application skeleton, and build/test execution requirements for the project.

### Modified Capabilities
- None.

## Impact

- Affected code: repository root structure, Maven build configuration, Java source and test source layout, initial JavaFX application classes, and repository ignore rules.
- Dependencies: Maven-managed JavaFX and JUnit 5 dependencies will be introduced.
- Systems: Local developer build, run, and test workflows will be established for the first time.
