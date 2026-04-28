## Why

The project now has separate UI and domain layers, but it does not yet have an application-facing service layer that can coordinate domain data for the app. Introducing a first service package and a concrete `MenuService` now creates a clean place for menu-loading behavior before the JavaFX application begins consuming live domain data.

## What Changes

- Introduce a new `service` capability that defines the baseline service-layer package area under `coffeeshop.service.*`.
- Add a concrete `MenuService` under `coffeeshop.service` as the first service in the codebase.
- Define the first `MenuService` behavior as loading a menu into memory for the current app session and returning that menu as a `List<Item>`.
- Explicitly defer JavaFX app integration so this change establishes the service without yet wiring it into controllers or views.

## Capabilities

### New Capabilities
- `service`: Defines the baseline service package area and the initial `MenuService` behavior for loading menu items into memory.

### Modified Capabilities
- `project-architecture`: Extends the project architecture guidance to recognize a service layer between the UI/application and domain layers.

## Impact

- Affected code: new `coffeeshop.service` package, new `MenuService`, module exports as needed, and related tests.
- Affected specs: new `service` capability and updated `project-architecture`.
- Systems: future UI work can retrieve menu data through a service instead of embedding menu-loading logic in the JavaFX layer.
