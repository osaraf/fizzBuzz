# FizzBuzz (Plain IntelliJ Project)

A small, maintainable FizzBuzz implementation showing clean structure,
flexibility, and team-friendliness — **no Maven/Gradle required**.

## 📂 Project Structure
```
src/
  com/example/
    Application.java
    FizzBuzz.java
test/
  com/example/
    FizzBuzzTest.java
.github/
  workflows/
    java.yml
```

## Design
- **Rule-based engine:** uses `LinkedHashMap<Integer,String>` so rules keep insertion order.
- **Pure core logic:**
    - `evaluate(int)` → evaluates a single number.
    - `run(int, int)` → returns `List<String>` for a range.
    - `run(int, int, Consumer<String>)` → streams results anywhere (console, file, logger).
- **Validation:** throws exceptions for invalid ranges or divisor = 0.
- **Extensible:** easily add rules like multiples of 7 → `Bazz`.

## Run
### IntelliJ IDEA
- Open the project.
- Run `com.example.Application`.

### Command line
```bash
# Compile sources
javac -d out $(find src -name "*.java")

# Run the app (default prints 1–100)
java -cp out com.example.Application
```

## Tests
- Written with **JUnit 5** under `test/com/example/`.
- Run from IntelliJ (green ▶ on class or method) or via GitHub Actions.

## Continuous Integration
The GitHub Actions workflow (`.github/workflows/java.yml`):
- Downloads JUnit console runner.
- Compiles `src/` and `test/`.
- Runs tests by scanning the classpath.
