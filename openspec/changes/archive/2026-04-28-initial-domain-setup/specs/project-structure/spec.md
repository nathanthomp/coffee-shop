## MODIFIED Requirements

### Requirement: Package conventions are defined for the codebase
The project SHALL use `coffeeshop.*` as its package root. MVC-related application classes SHALL be organized under the `coffeeshop.app` package structure, and business/domain classes SHALL be organized under the `coffeeshop.domain` package structure. The baseline MVC package layout SHALL include dedicated `coffeeshop.app.controllers`, `coffeeshop.app.views`, and `coffeeshop.app.models` packages, while the JavaFX application entry point remains in `coffeeshop.app`.

#### Scenario: Application and domain classes follow the agreed package root
- **GIVEN** the project structure is in place
- **WHEN** application source files are created
- **THEN** those files SHALL use the `coffeeshop.*` package convention
- **AND** MVC-related application classes SHALL be placed within `coffeeshop.app`
- **AND** business/domain classes SHALL be placed within `coffeeshop.domain`
- **AND** controller, view, and model baseline classes SHALL be separated into `controllers`, `views`, and `models` subpackages as part of the `coffeeshop.app` structure

### Requirement: The initial setup documents the intended structural pattern
The project setup specification SHALL explicitly identify MVC as the intended structural pattern for the application baseline and SHALL document that core business concepts belong in dedicated domain packages separate from UI concerns.

#### Scenario: Structural guidance is available for future changes
- **GIVEN** a future change is proposed against the project
- **WHEN** the author reviews the `project-structure` capability
- **THEN** the specification SHALL state that MVC is the intended structural pattern for the baseline project structure
- **AND** it SHALL distinguish `coffeeshop.app.*` as the UI/application area from `coffeeshop.domain.*` as the business/domain area
