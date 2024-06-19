# Lox Language in Java

This is an attempt to implement the Lox language, as described in
the website [Crafting Interpreters](https://craftinginterpreters.com/statements-and-state.html) in Java.

This is just a study case / compilers/interpreters study and it's not meant to be production ready not benchmark
for anything.

All credits to the author of the website and the Lox language, your work is awesome,
easy to follow and very didactic. I wish studying compilers in Uni were that easy in my Uni time.

## Running examples

Since, for now, it's "just" an interpreter, I created a gradle task in which you can run your examples to test:
just run `./gradlew processLoxFile -Pfile=examples/print_statements.lox`. You can rename the file you want to execute.