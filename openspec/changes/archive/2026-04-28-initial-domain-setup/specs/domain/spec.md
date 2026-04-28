## ADDED Requirements

### Requirement: A dedicated domain package area exists
The project SHALL provide a first-class domain package area under `coffeeshop.domain.*` for business-oriented classes that are separate from the JavaFX MVC application packages.

#### Scenario: Domain classes are separated from UI packages
- **GIVEN** the codebase includes both UI/application and business-oriented code
- **WHEN** a developer adds or reviews domain model classes
- **THEN** those domain model classes SHALL belong under `coffeeshop.domain.*`
- **AND** they SHALL not require placement under `coffeeshop.app.*` to participate in the application design

### Requirement: Item concepts are defined in `coffeeshop.domain.items`
The project SHALL define the initial menu item hierarchy under the `coffeeshop.domain.items` package.

#### Scenario: Initial item types are discoverable in a dedicated package
- **GIVEN** the initial domain setup is complete
- **WHEN** a developer inspects the source structure for menu item concepts
- **THEN** the item abstraction and initial concrete item types SHALL be located in `coffeeshop.domain.items`

### Requirement: Order concepts are defined in `coffeeshop.domain.orders`
The project SHALL define the initial order aggregate under the `coffeeshop.domain.orders` package.

#### Scenario: Initial order type is discoverable in a dedicated package
- **GIVEN** the initial domain setup is complete
- **WHEN** a developer inspects the source structure for order concepts
- **THEN** the order aggregate SHALL be located in `coffeeshop.domain.orders`

### Requirement: Item exposes shared item data
The project SHALL define `Item` as the base interface for the initial item hierarchy, and that interface SHALL require shared item data for `name`, `price`, and `description`.

#### Scenario: Shared item data is available through the base contract
- **GIVEN** a class participates in the initial item hierarchy
- **WHEN** that class is treated as an `Item`
- **THEN** the item SHALL expose `name`, `price`, and `description` through the shared interface contract

### Requirement: Beverage and Food extend the Item hierarchy as concrete item types
The project SHALL provide concrete `Beverage` and `Food` classes as the first item types that implement the base `Item` interface.

#### Scenario: Initial concrete item types share the base contract
- **GIVEN** the initial domain setup is complete
- **WHEN** a developer reviews the available item classes
- **THEN** `Beverage` and `Food` SHALL exist as concrete domain item types
- **AND** both SHALL implement the `Item` interface
- **AND** neither SHALL require subtype-specific fields in this initial change

### Requirement: Order stores a list of items
The project SHALL provide a simple `Order` class that contains a list of `Item` instances as the initial order model.

#### Scenario: Order groups domain items
- **GIVEN** the initial domain setup is complete
- **WHEN** a developer creates an `Order`
- **THEN** the order SHALL be able to contain multiple `Item` instances
- **AND** the order SHALL not require identifiers, status, or pricing totals in this initial change
