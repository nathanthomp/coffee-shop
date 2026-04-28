## 1. Service Capability Setup

- [x] 1.1 Add the `initial-service-setup` OpenSpec change artifacts for proposal, design, and tasks.
- [x] 1.2 Add a new `service` capability spec delta describing the service package area and `MenuService`.
- [x] 1.3 Add a `project-architecture` spec delta documenting the service layer between app and domain concerns.

## 2. Service Implementation

- [x] 2.1 Create the `coffeeshop.service` package in application source.
- [x] 2.2 Add a concrete `MenuService` class that loads a menu into memory.
- [x] 2.3 Define the initial `MenuService` API to return a `List<Item>`.

## 3. Integration and Verification

- [x] 3.1 Update module/package exports if required so the service package participates cleanly in the modular build.
- [x] 3.2 Add or update tests covering the initial `MenuService` behavior.
- [x] 3.3 Verify the project still compiles and tests successfully after the service baseline is added.
