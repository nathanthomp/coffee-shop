## Why

The current codebase establishes the JavaFX MVC application shell under `coffeeshop.app`, but it does not yet define a dedicated domain layer for business concepts. Creating that boundary now will keep business logic out of UI-adjacent packages and give future menu, order, and pricing work a stable home.

## What Changes

- Introduce a new `domain` capability that defines the baseline package area for business-oriented code under `coffeeshop.domain.*`.
- Establish `coffeeshop.domain.items` as the first domain package and define an initial item hierarchy centered on `Item`, `Beverage`, and `Food`.
- Establish `coffeeshop.domain.orders` as an initial domain package for order concepts with a simple `Order` model that holds items.
- Require the initial item abstraction to expose shared item data through `name`, `price`, and `description`.
- Update the `project-structure` capability so the repository explicitly distinguishes UI-oriented `coffeeshop.app.*` packages from domain-oriented `coffeeshop.domain.*` packages.

## Capabilities

### New Capabilities
- `domain`: Defines the baseline domain package structure, initial item hierarchy, and initial order aggregate for the business model.

### Modified Capabilities
- `project-structure`: Expands the package conventions to include a first-class domain package area alongside the MVC application package area.

## Impact

- Affected code: Java package structure, module exports as needed, and future class placement expectations.
- Affected specs: `domain`, `project-structure`.
- Systems: Future business rules, menu modeling, and order-related changes will build on this domain layer.
