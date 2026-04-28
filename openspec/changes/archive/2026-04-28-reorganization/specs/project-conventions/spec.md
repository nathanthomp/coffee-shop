## ADDED Requirements

### Requirement: Classes are preferred over records
The project SHALL prefer explicit classes over Java records for production source types unless a future specification explicitly allows a record for a narrow use case.

#### Scenario: New source types use classes by default
- **GIVEN** a developer introduces a new production type
- **WHEN** the type models application or domain behavior/data
- **THEN** the implementation SHALL use a class instead of a Java record by default
- **AND** a record SHALL not be introduced unless a project requirement explicitly permits that exception

### Requirement: Declarations use explicit visibility
The project SHALL require explicit visibility modifiers for classes, constructors, methods, and fields wherever the Java language allows visibility to be declared.

#### Scenario: New source code avoids implicit visibility
- **GIVEN** a developer adds or updates a production class
- **WHEN** that source declares a class member or type with configurable visibility
- **THEN** the declaration SHALL explicitly state `public`, `protected`, or `private` instead of relying on default package-private visibility unless a project requirement intentionally calls for package-private access

### Requirement: Modifier intent is stated deliberately
The project SHALL require developers to declare modifiers intentionally so mutability, inheritance, and utility behavior are made explicit in the source code.

#### Scenario: Source code communicates design intent through modifiers
- **GIVEN** a developer creates or updates a class, field, or method
- **WHEN** the declaration has a meaningful modifier choice such as `final`, `abstract`, or `static`
- **THEN** the chosen modifier SHALL reflect the intended design of the code
- **AND** mutable state SHALL not be left ambiguous when an immutable or constant declaration is intended

### Requirement: Project conventions remain dependency-light
The project SHALL define coding conventions that can be followed through normal development and code review without requiring a new framework or heavy external tooling.

#### Scenario: Conventions fit the current project workflow
- **GIVEN** the project uses Java 21, Maven, JavaFX, and JUnit 5 as its current baseline
- **WHEN** project-wide coding conventions are introduced
- **THEN** those conventions SHALL be expressible without requiring a new runtime dependency
- **AND** they SHALL remain compatible with the project’s dependency-light approach
