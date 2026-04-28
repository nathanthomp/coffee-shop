## Context

The repository currently has a single project-wide structural capability, `project-structure`, that carries a mix of concerns: source layout and package boundaries, but also architectural guidance about MVC and separation between UI and domain responsibilities. As the project grows, that blended capability will become harder to maintain because changes to coding standards, architecture, and filesystem structure will all compete for the same spec.

This change introduces a clearer project-level taxonomy:
- `project-structure` for physical organization and build-related layout,
- `project-conventions` for code-level standards,
- `project-architecture` for system design boundaries and intended application pattern.

## Goals / Non-Goals

**Goals:**
- Separate project-wide structural, coding, and architectural guidance into distinct capabilities.
- Keep `project-structure` focused on Maven layout, packages, and module-oriented organization.
- Introduce `project-conventions` with an initial set of enforceable coding conventions, including explicit visibility and deliberate modifier usage.
- Introduce `project-architecture` as the home for MVC and UI/domain separation guidance.
- Make future project-wide changes easier to scope to the correct capability.

**Non-Goals:**
- Rename existing capability folders or perform risky OpenSpec path experiments with nested spec folders.
- Change application runtime behavior.
- Introduce static analysis tooling or automated formatter enforcement in this change.
- Fully define every future coding rule the project may ever need.

## Decisions

### Keep project-wide capabilities flat
The project will continue using flat capability names such as `project-structure`, `project-conventions`, and `project-architecture` instead of nested capability folders like `project/conventions`.

This matches the existing repository layout and avoids relying on unverified nested-capability behavior in the current OpenSpec workflow.

Alternative considered:
- Nested `project/...` capability folders. Rejected because tool compatibility is uncertain and the flat naming pattern already works.

### Re-scope `project-structure` to structural concerns only
`project-structure` will continue to exist, but its requirements will focus on:
- Maven source layout,
- package organization,
- module/package boundaries,
- build-oriented repository structure.

Architecture and coding-style guidance will be removed from that capability where appropriate and restated in the new project-wide specs.

Alternative considered:
- Renaming `project-structure` to `project`. Rejected because it would create a broad catch-all capability and reduce precision in future changes.

### Introduce `project-conventions` for code-level expectations
The initial `project-conventions` capability will define a small set of concrete rules that can be referenced in future work and code review.

The first conventions will emphasize:
- explicit visibility for declarations where Java allows it,
- deliberate use of modifiers such as `final`, `abstract`, and `static`,
- clear separation between constants and mutable state,
- code that expresses design intent rather than relying on implicit defaults.

Alternative considered:
- Putting these rules into `project-structure`. Rejected because they concern source code style and class design rather than repository structure.

### Introduce `project-architecture` for MVC and boundary guidance
The project’s intended architectural pattern and separation-of-concerns guidance will live in `project-architecture`.

This includes:
- MVC as the default application pattern,
- thin JavaFX controllers,
- separation between `coffeeshop.app.*` and `coffeeshop.domain.*`.

Alternative considered:
- Leaving these rules in `project-structure`. Rejected because they describe system design and responsibility boundaries, not physical structure alone.

## Risks / Trade-offs

- [Project-wide guidance may feel split across too many specs] -> Mitigation: keep each capability tightly scoped and name them clearly so authors know where to look.
- [Some conventions are harder to enforce automatically than structure rules] -> Mitigation: start with concrete, reviewable conventions and defer lint tooling to a later change.
- [Moving requirements between capabilities can create temporary overlap] -> Mitigation: update the modified `project-structure` requirement text fully so archived deltas produce a clean long-lived baseline.
