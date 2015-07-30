# component-core

Core service and data type definitions for component.
This is where Finagle compatible Java classes are generated from your Thrift definition.

The Thrift definition is in `src/thrift`.
Generated Java code will go to `src/java`.

Java classes will automatically be generated from the Thrift definition using [Scrooge](https://twitter.github.io/scrooge/).
Scrooge will automatically create classes that can be used with Finagle.
A hook around `lein javac` that compiles Thrift first is added by the `lein-finagle-clojure` plugin.

The Thrift definitions can also be compiled manually by running `lein finagle-clojure scrooge`.

It is recommended that a golden version of this library be placed in an artifact repository.
It should not be built every time a dependent library (such as -client or -service) are built.
