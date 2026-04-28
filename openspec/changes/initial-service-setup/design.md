## Context

The current codebase has a JavaFX MVC application shell under `coffeeshop.app` and a small domain layer under `coffeeshop.domain`, but there is no dedicated service layer yet. That means any future menu-loading logic would either land too early in the UI layer or force the app to reach directly into domain construction details.

This change introduces a first service package, `coffeeshop.service`, and a concrete `MenuService` that loads menu data into memory and returns it as a `List<Item>`. The goal is to establish the service-layer boundary before wiring the app to consume the service.

## Goals / Non-Goals

**Goals:**
- Create a first-class service package area under `coffeeshop.service.*`.
- Add a concrete `MenuService` as the first service in the codebase.
- Define menu loading as an in-memory concern for the initial version.
- Return menu data as a `List<Item>` to keep the first version lightweight.
- Keep the app-side integration explicitly out of scope for this change.

**Non-Goals:**
- Wire `MenuService` into `CoffeeShopApplication`, controllers, or views yet.
- Introduce file-backed menu loading, persistence, or remote data access.
- Add a `Menu` domain wrapper type in this change.
- Add a service interface/implementation split before there is a real need for one.

## Decisions

### Introduce `coffeeshop.service` as a peer package area
The codebase will add `coffeeshop.service.*` as a dedicated package area for application-facing services that coordinate domain data for the app.

This gives the architecture a clearer shape:
- `coffeeshop.app.*` for UI/application code
- `coffeeshop.service.*` for coordination/services
- `coffeeshop.domain.*` for domain models and business concepts

Alternative considered:
- Putting `MenuService` under `coffeeshop.app.models` or a controller package. Rejected because that would blur UI and non-UI responsibilities.

### Start with a concrete `MenuService`
The initial `MenuService` will be a concrete class rather than an interface plus implementation pair.

This keeps the first version simple and matches the current stage of the project, where there is only one expected source of menu data.

Alternative considered:
- Introducing a `MenuService` interface and separate implementation immediately. Rejected because it adds abstraction without a concrete second implementation or substitution need.

### Keep menu loading in memory for the first version
The first version of `MenuService` will load menu items into memory for the current application session.

This is consistent with the project’s current in-memory direction and avoids prematurely specifying file formats or persistence concerns.

Alternative considered:
- Loading from a file immediately. Rejected because the user explicitly wants the service established first without committing to a file-based input format yet.

### Return `List<Item>` instead of introducing `Menu`
`MenuService` will return a `List<Item>` for now.

This is the smallest useful contract for the app to consume later, and it avoids adding a `Menu` aggregate before the project knows what additional menu behavior is needed.

Alternative considered:
- Introducing a dedicated `Menu` domain class. Rejected for now because the current need is simply to expose loaded items.

## Risks / Trade-offs

- [A simple `List<Item>` may become too small once menu categories or metadata are needed] -> Mitigation: treat this as a baseline service contract and introduce a `Menu` type later if the requirements justify it.
- [A concrete service may need refactoring if multiple loading strategies appear] -> Mitigation: start concrete now and extract an interface only when a second implementation or clear substitution need emerges.
- [Future contributors may still try to load menu data directly in the UI layer] -> Mitigation: capture the service-layer role in specs so future changes have a documented boundary to follow.
