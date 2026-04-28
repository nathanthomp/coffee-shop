## Why

The current project-wide guidance is concentrated in `project-structure`, which now mixes source layout, package rules, and higher-level architectural guidance. Splitting those concerns into dedicated project-level capabilities will make the specs easier to maintain and give future changes a clearer place to capture coding standards, structural rules, and architectural decisions.

## What Changes

- Introduce a new `project-conventions` capability for project-wide coding conventions and class/member design expectations.
- Introduce a new `project-architecture` capability for high-level architectural guidance such as MVC boundaries and separation between UI and domain concerns.
- Refocus `project-structure` so it covers repository layout, package organization, module boundaries, and build-oriented structure only.
- Move or restate project-wide requirements so each one lives in the most appropriate capability instead of overloading `project-structure`.

## Capabilities

### New Capabilities
- `project-conventions`: Defines project-wide coding conventions, including explicit declaration and modifier expectations.
- `project-architecture`: Defines project-wide architectural boundaries and structural design guidance such as MVC and domain/UI separation.

### Modified Capabilities
- `project-structure`: Refines the existing project structure requirements so they focus on physical code organization and build layout rather than broader architectural or coding-style rules.

## Impact

- Affected specs: `project-structure`, plus new `project-conventions` and `project-architecture` capabilities.
- Affected code: no immediate runtime behavior changes are required, but future code and reviews will follow clearer project-wide conventions.
- Systems: OpenSpec change authoring and future implementation work will have a more precise project-level specification baseline.
