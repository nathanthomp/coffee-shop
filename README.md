# Coffee Shop

Java 21 and JavaFX desktop application for a cashier-facing coffee shop POS.

## Local Development

Run the application locally with:

```powershell
mvn javafx:run
```

This uses the JavaFX Maven plugin and is the preferred local launch path.

Run the test suite with:

```powershell
mvn test
```

## Distribution Build

Build a distributable JavaFX runtime image with:

```powershell
mvn javafx:jlink
```

This produces a self-contained application image under `target/coffee-shop/` for desktop distribution.
This workflow requires the project to be built with a full JDK, not just a JRE.
