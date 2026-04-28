# project-architecture Specification

## Purpose
Define the default application architecture and responsibility boundaries for the project, including MVC as the UI pattern and separation between UI/application code and domain/business code.

## Requirements
### Requirement: MVC remains the default application architecture
The project SHALL treat MVC as the default architectural pattern for the JavaFX application baseline.

#### Scenario: Future changes follow the default architectural pattern
- **GIVEN** a future project change introduces new application behavior
- **WHEN** the author defines the placement of UI responsibilities
- **THEN** the change SHALL treat MVC as the default architectural pattern unless the specification explicitly defines a different approach

### Requirement: UI and domain responsibilities remain separated
The project SHALL keep JavaFX application concerns separate from domain/business concerns by maintaining a clear boundary between `coffeeshop.app.*` and `coffeeshop.domain.*`.

#### Scenario: Business logic is not placed in UI packages by default
- **GIVEN** the codebase contains both JavaFX-facing and business-oriented logic
- **WHEN** a developer introduces or reviews business rules
- **THEN** those business rules SHALL belong in non-UI classes outside `coffeeshop.app.views`
- **AND** they SHALL not require placement in JavaFX controllers to participate in the application design

### Requirement: JavaFX controllers remain thin
The project SHALL keep JavaFX controllers focused on UI coordination rather than core business-rule ownership.

#### Scenario: Controller responsibilities stay focused on UI behavior
- **GIVEN** a JavaFX controller handles user interaction
- **WHEN** that controller coordinates an application action
- **THEN** it SHALL delegate business-oriented rules to non-UI collaborators when such rules emerge
- **AND** it SHALL avoid becoming the long-term home for core domain logic

### Requirement: Service-layer responsibilities are recognized between app and domain
The project SHALL treat `coffeeshop.service.*` as the default service-layer package area for application-facing coordination that sits between the UI/application layer and the domain layer.

#### Scenario: Service logic has a documented architectural home
- **GIVEN** a future change introduces coordination logic for the app
- **WHEN** the author decides where that logic belongs
- **THEN** service-oriented coordination code SHALL belong under `coffeeshop.service.*`
- **AND** that layer SHALL be treated as distinct from both `coffeeshop.app.*` and `coffeeshop.domain.*`
