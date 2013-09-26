# bench-index-of

Benchmarks of Java's `.indexOf` performance in Clojure using native Clojure
vectors and memoization vs Java ArrayList and type hints.

## Usage

```bash
lein run
```

## Results

Running 1M tests with each method:

```clj
(.indexOf clj-vec "test-string")
"Elapsed time: 6960.071 msecs"

(index-of clj-vec "test-string")
"Elapsed time: 6867.396 msecs"

(index-of-memo clj-vec "test-string")
"Elapsed time: 465.555 msecs"

(string-index-of java-al "test-string")
"Elapsed time: 63.485 msecs"

(string-index-of-memo java-al "test-string")
"Elapsed time: 471.329 msecs"
```

### Winner

Using a Java ArrayList with type hints and no memoization is a clear winner.

## License

Copyright © 2013 Olivier Lauzon

Distributed under the Eclipse Public License.
