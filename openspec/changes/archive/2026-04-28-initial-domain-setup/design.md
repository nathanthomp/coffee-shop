## Context

The project currently has a clear UI/application baseline under `coffeeshop.app` and a live `project-structure` capability that documents the MVC-oriented package layout. What is missing is an equally clear home for business concepts that should not live in controllers, views, or presentation models.

This change establishes that missing layer by introducing a dedicated `coffeeshop.domain` package area. The first slice of that layer models menu items through a small hierarchy composed of a base `Item` abstraction and concrete `Beverage` and `Food` classes, and it introduces a minimal `Order` aggregate that holds a list of items.

## Goals / Non-Goals

**Goals:**
- Create a first-class domain package area distinct from `coffeeshop.app`.
- Establish `coffeeshop.domain.items` as the home for menu item concepts.
- Establish `coffeeshop.domain.orders` as the initial home for order concepts.
- Define the shared baseline item data as `name`, `price`, and `description`.
- Keep the first version of `Beverage` and `Food` intentionally simple so later changes can refine them without refactoring out of UI packages.
- Keep the first version of `Order` intentionally small and in-memory, focused only on containing items.
- Update structural documentation so future contributors understand where domain and UI responsibilities belong.

**Non-Goals:**
- Implement order management workflows, order status handling, catalog services, or persistence.
- Finalize the entire coffee shop domain model.
- Add subtype-specific beverage or food attributes yet.
- Introduce factories, repositories, or pricing engines in this change.

## Decisions

### Introduce `coffeeshop.domain` as a peer to `coffeeshop.app`
The codebase will treat `coffeeshop.app.*` and `coffeeshop.domain.*` as separate first-class package areas with different responsibilities.

- `coffeeshop.app.*` remains responsible for JavaFX application structure and MVC UI concerns.
- `coffeeshop.domain.*` becomes the home for business concepts, business rules, and domain models.

This keeps controllers and presentation models from becoming a long-term storage location for core business logic.

Alternative considered:
- Keeping all early business classes in `coffeeshop.app.models`. Rejected because it blurs the line between presentation concerns and core domain concepts.

### Start with `coffeeshop.domain.items`
The first domain package will be `coffeeshop.domain.items`, which groups the shared item abstraction and the initial concrete item types.

Initial structure:
- `coffeeshop.domain.items.Item`
- `coffeeshop.domain.items.Beverage`
- `coffeeshop.domain.items.Food`
- `coffeeshop.domain.orders.Order`

Examples of additional domain packages that may emerge later:
- `coffeeshop.domain.pricing`
- `coffeeshop.domain.menu`
- `coffeeshop.domain.fulfillment`

These examples are directional only and are not required by this change.

### Add a simple `coffeeshop.domain.orders` package
The initial order concept will live in `coffeeshop.domain.orders` and start as a minimal aggregate that contains a list of `Item` instances.

Initial structure:
- `coffeeshop.domain.orders.Order`

The first implementation is intentionally small:
- no order identifier yet,
- no status yet,
- no timestamps yet,
- no pricing totals yet.

This gives future changes a clear domain home for ordering behavior without pretending the full order model is already known.

### Use an interface for the shared item contract
`Item` will be defined as an interface rather than an abstract class in the initial design. The goal is to establish a small contract for common item data while leaving room for future composition or alternate item implementations.

The initial contract will require:
- `name`
- `price`
- `description`

Alternative considered:
- An abstract base class with shared state immediately baked in. Rejected for now because the user wants a lightweight starting point and expects the hierarchy to evolve.

### Keep `Beverage` and `Food` simple in the first pass
`Beverage` and `Food` will be concrete classes that implement the shared `Item` contract without adding subtype-specific requirements yet.

This lets the project:
- prove the domain boundary exists,
- keep the first hierarchy easy to understand,
- and defer details like drink sizes, temperatures, bakery categories, or modifiers until real requirements arrive.

### Keep `Order` as a small immutable item container
`Order` will begin as a simple domain type whose responsibility is to hold a list of items. The list should be treated as an immutable snapshot so callers cannot mutate an order unexpectedly through shared collection references.

Alternative considered:
- Adding identifiers, totals, and status immediately. Rejected because the project is still defining its baseline domain and those details should come from a dedicated order-focused change.

## Risks / Trade-offs

- [A minimal item contract may be revised soon] -> Mitigation: keep the initial hierarchy intentionally small and document that refinement is expected in later changes.
- [The first `Order` model may be too small for near-term feature work] -> Mitigation: establish the package and aggregate now, then evolve it in a focused follow-up change once ordering requirements are specified.
- [Future contributors may still place business classes under `coffeeshop.app.models`] -> Mitigation: update `project-structure` to explicitly document the app/domain separation.
- [Using an interface may lead to repeated state handling in early implementations] -> Mitigation: accept that small duplication now in exchange for a flexible baseline, and revisit if a shared abstract base becomes warranted.
