## 1. Change Scaffolding

- [x] 1.1 Add the `initial-domain-setup` OpenSpec change artifacts for proposal, design, and tasks.
- [x] 1.2 Add a new `domain` capability spec delta describing the domain package area and initial item hierarchy.
- [x] 1.3 Add a `project-structure` spec delta documenting the split between `coffeeshop.app.*` and `coffeeshop.domain.*`.

## 2. Domain Package Baseline

- [x] 2.1 Create the `coffeeshop.domain.items` package in application source.
- [x] 2.2 Add the base `Item` interface with the initial shared item data contract for `name`, `price`, and `description`.
- [x] 2.3 Add concrete `Beverage` and `Food` classes that implement `Item` without subtype-specific extensions yet.
- [x] 2.4 Create the `coffeeshop.domain.orders` package with a simple `Order` class that stores a list of items.

## 3. Integration and Verification

- [x] 3.1 Update module/package exports if required so the new domain package participates cleanly in the modular build.
- [x] 3.2 Add or update tests covering the initial domain item hierarchy and simple order aggregate.
- [x] 3.3 Verify the project still compiles and tests successfully after the domain baseline is added.
