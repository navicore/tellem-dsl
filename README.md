<!-- ghmig:moved -->
> **This repository has moved to [https://git.navicore.tech/navicore/tellem-dsl](https://git.navicore.tech/navicore/tellem-dsl).**
>
> The GitHub copy is archived and no longer maintained.

Tellem DSL
-----

# UNDER CONSTRUCTION

# UNDER CONSTRUCTION

# UNDER CONSTRUCTION

A DSL for extracting telemetry from complex JSON and XML inputs

### Build and run

```console
sbt assembly
java -jar target/scala-2.12/TellemDsl.jar
```

### Test and Code Coverage

```console
sbt clean coverage test
sbt coverageReport
open target/scala-2.12/scoverage-report/index.html
```

### Code Stats

```console
sbt stats
```
### Check dependencies

```console
sbt dependencyUpdates
```