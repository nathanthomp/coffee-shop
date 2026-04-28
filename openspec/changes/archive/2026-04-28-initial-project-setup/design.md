## Context

The repository currently contains OpenSpec configuration and no Java application structure. This change establishes the first implementation baseline for the Coffee Shop desktop application by introducing a Maven project, JavaFX runtime wiring, JUnit 5 test execution, and a minimal codebase skeleton that future feature changes can extend.

The project is intentionally starting small: a cashier-facing POS application with session-only in-memory data and manual worker-driven order management. Those runtime behaviors inform future work, but this setup change is focused on providing the structural foundation rather than implementing order flows.

## Goals / Non-Goals

**Goals:**
- Create a standard Maven project layout using `src/main/java` and `src/test/java`.
- Establish a consistent `coffeeshop.*` package root with MVC-related application classes organized under `coffeeshop.app`.
- Provide a pure JavaFX application skeleton that can launch successfully.
- Configure Maven so the project can build and run tests reliably with Java 21.
- Introduce repository hygiene such as `.gitignore`.
- Keep the codebase ready for future MVC expansion without baking in premature domain or UI complexity.

**Non-Goals:**
- Implement menu browsing, order creation, order viewing, or order status management.
- Introduce persistence beyond in-memory assumptions.
- Add FXML, CSS-driven screen systems, or dependency injection frameworks.
- Finalize the complete domain model for the coffee shop workflow.

## Decisions

### Use Maven as the build and dependency management system
Maven will manage JavaFX and JUnit 5 dependencies and provide a repeatable entry point for compile, test, and packaging workflows. This replaces the earlier manual-jar idea because JavaFX module/runtime setup is easier to standardize through Maven than through ad hoc local classpaths.

Alternative considered:
- Manual `lib/` jar management. Rejected because it increases local setup friction and makes JavaFX runtime and test execution harder to reproduce.

### Use the default Maven source layout
The project will use:
- `src/main/java`
- `src/test/java`

Sticking to Maven defaults avoids unnecessary configuration and keeps IDE import straightforward.

Alternative considered:
- Custom root-level `src/` and `test/` folders. Rejected because it adds configuration overhead without helping the implementation.

### Use a simple `coffeeshop.*` package root
The codebase will avoid reverse-domain package naming and instead use a concise `coffeeshop` root. MVC-related application classes will live under `coffeeshop.app`, with `coffeeshop.app.controllers`, `coffeeshop.app.views`, and `coffeeshop.app.models` as the default baseline structure. Other packages can expand beneath `coffeeshop` as future capabilities need them.

Alternative considered:
- `com.*` reverse-domain naming. Rejected because the project is small and the simpler package root is clearer for the intended scope.

### Keep the initial UI in pure JavaFX code
The runnable skeleton will create its scene graph in Java code rather than FXML. This keeps the first change smaller, avoids introducing a second view technology, and matches the current project preference.

Alternative considered:
- FXML-based startup view. Rejected because it adds structure before the team has chosen concrete screens and controller boundaries.

### Keep MVC boundaries explicit from the start
The startup skeleton will separate JavaFX application/bootstrap code from non-UI logic, even if the non-UI layer is minimal at first. Controllers should remain thin and business rules should stay outside JavaFX event handlers as future functionality is added.

Expected early structure:
- `coffeeshop.app` for application startup
- `coffeeshop.app.controllers` for JavaFX-facing controller classes
- `coffeeshop.app.views` for pure JavaFX view classes
- `coffeeshop.app.models` for simple application-facing presentation models
- additional `coffeeshop.*` packages added later for domain and service responsibilities as feature work begins

Alternative considered:
- Putting all startup and future UI logic in a single package. Rejected because it encourages controller-heavy design and makes later refactoring harder.

### Prove the foundation with a runnable skeleton and passing test
The setup change will include a minimal JavaFX entry point and at least one passing JUnit 5 test so the repository proves build, launch, and test flows before feature work begins.

Alternative considered:
- Structure-only setup with no executable proof. Rejected because it leaves toolchain problems undiscovered until later changes.

### Separate local-run and distribution workflows
The project should use `mvn javafx:run` as the primary local development launch path and a JavaFX runtime image as the preferred distribution artifact. This keeps local development simple and aligns the project with a desktop-friendly delivery format.

Alternative considered:
- Relying on the default Maven jar as the primary launch strategy. Rejected because the default artifact is not the intended desktop distribution format for this JavaFX application.

## Risks / Trade-offs

- [JavaFX plugin/runtime setup varies across environments] -> Mitigation: use Maven-managed dependencies and define a single supported launch path in the project setup.
- [Starting with only `coffeeshop.app` could tempt future business logic into UI-adjacent packages] -> Mitigation: document that `coffeeshop.app` is for MVC application structure, not a catch-all for all logic.
- [A minimal skeleton may under-specify future screen composition] -> Mitigation: treat this as a foundation only and defer concrete screen architecture to later feature changes.
- [Requiring a test for every new class can create pressure on UI-heavy classes] -> Mitigation: keep the initial UI thin and bias future logic into testable non-UI classes.
