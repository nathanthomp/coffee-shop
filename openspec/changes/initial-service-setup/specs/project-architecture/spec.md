## ADDED Requirements

### Requirement: Service-layer responsibilities are recognized between app and domain
The project SHALL treat `coffeeshop.service.*` as the default service-layer package area for application-facing coordination that sits between the UI/application layer and the domain layer.

#### Scenario: Service logic has a documented architectural home
- **GIVEN** a future change introduces coordination logic for the app
- **WHEN** the author decides where that logic belongs
- **THEN** service-oriented coordination code SHALL belong under `coffeeshop.service.*`
- **AND** that layer SHALL be treated as distinct from both `coffeeshop.app.*` and `coffeeshop.domain.*`
