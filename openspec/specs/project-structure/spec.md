# project-structure Specification

## Purpose
TBD - created by archiving change initial-project-setup. Update Purpose after archive.
## Requirements
### Requirement: Maven project structure is established
The project SHALL use Maven as its build system and SHALL organize application and test code using the standard `src/main/java` and `src/test/java` source layout.

#### Scenario: Maven source roots are present
- **GIVEN** a newly checked out repository
- **WHEN** a developer inspects the project structure
- **THEN** the repository SHALL contain Maven-compatible application and test source roots under `src/main/java` and `src/test/java`

### Requirement: Package conventions are defined for the codebase
The project SHALL use `coffeeshop.*` as its package root. MVC-related application classes SHALL be organized under the `coffeeshop.app` package structure, and business/domain classes SHALL be organized under the `coffeeshop.domain` package structure. The baseline MVC package layout SHALL include dedicated `coffeeshop.app.controllers`, `coffeeshop.app.views`, and `coffeeshop.app.models` packages, while the JavaFX application entry point remains in `coffeeshop.app`.

#### Scenario: Application and domain classes follow the agreed package root
- **GIVEN** the project structure is in place
- **WHEN** application source files are created
- **THEN** those files SHALL use the `coffeeshop.*` package convention
- **AND** MVC-related application classes SHALL be placed within `coffeeshop.app`
- **AND** business/domain classes SHALL be placed within `coffeeshop.domain`
- **AND** controller, view, and model baseline classes SHALL be separated into `controllers`, `views`, and `models` subpackages as part of the `coffeeshop.app` structure

### Requirement: A runnable JavaFX application skeleton exists
The project SHALL provide a minimal JavaFX application skeleton implemented in pure Java code that proves the desktop application can launch without implementing feature-specific cashier workflows yet.

#### Scenario: Application skeleton can be launched
- **GIVEN** the project dependencies are resolved through Maven
- **WHEN** the application is launched through the supported Maven workflow
- **THEN** a JavaFX application window SHALL open successfully
- **AND** the initial UI SHALL be implemented without FXML

#### Scenario: Local development launch path is defined
- **GIVEN** the initial project setup is complete
- **WHEN** a developer needs to run the application locally
- **THEN** the supported local workflow SHALL be `mvn javafx:run`

### Requirement: Build and test execution are supported through Maven
The project SHALL support repeatable build and automated test execution through Maven using Java 21 and JUnit 5.

#### Scenario: Automated tests run through Maven
- **GIVEN** the initial project setup is complete
- **WHEN** a developer runs the supported Maven test workflow
- **THEN** JUnit 5 tests SHALL execute successfully

#### Scenario: Project builds through Maven
- **GIVEN** the initial project setup is complete
- **WHEN** a developer runs the supported Maven build workflow
- **THEN** the project SHALL compile successfully with Java 21

#### Scenario: Distribution image can be built for desktop delivery
- **GIVEN** the initial project setup is complete
- **WHEN** a developer runs the supported distribution packaging workflow
- **THEN** the build SHALL produce a JavaFX runtime image suitable as a baseline desktop distribution artifact

### Requirement: Repository hygiene files are included
The project SHALL include repository hygiene files needed for normal Maven and Java development, including a `.gitignore` appropriate for generated build output and common IDE artifacts.

#### Scenario: Generated files are excluded from version control
- **GIVEN** the project has been built or opened in a typical IDE
- **WHEN** generated build output or common IDE metadata appears locally
- **THEN** the repository SHALL ignore those files through `.gitignore`

### Requirement: The initial setup documents the intended structural pattern
The project setup specification SHALL document the intended physical project organization, including the separation between the UI/application package area and the business/domain package area.

#### Scenario: Structural guidance is available for future changes
- **GIVEN** a future change is proposed against the project
- **WHEN** the author reviews the `project-structure` capability
- **THEN** the specification SHALL distinguish `coffeeshop.app.*` as the UI/application area from `coffeeshop.domain.*` as the business/domain area
- **AND** it SHALL describe that package separation as part of the baseline project structure
