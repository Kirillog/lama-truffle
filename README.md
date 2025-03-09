# Lama

# Building for a JVM

Build the project with `mvn package`.
To run simple language using a JDK from JAVA_HOME run `./lama`.

# Building a Native Image

Build the project with `mvn package -Pnative`.
To run lama language natively run `./standalone/target/lamanative`.

## Regression tests
```bash
make -C regression
```
Closures, custom infix operators, pattern matching at function parameter, eta operator is not supported.
Basically all after test092 is not supported.
## Performance tests
```bash
make -C performance
```
Local results is following:
```
Sort (-i) rec   7.89
Sort (-s) rec   3.00
Sort compiled   1.84
Sort truffle    1.74
```
In general compiled to the native image implementation is a little faster
than compiled version of original `lamac` compiler.
