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

## Grammar

Here you can find the current grammar (BNF - Backus-Naur Form) for the language. If it's here, most likely it's implemented:

```text
program        → declaration* EOF ;

declaration    → varDecl
               | statement ;

varDecl        → "var" IDENTIFIER ( "=" expression )? ";" ;

statement      → exprStmt
               | ifStmt
               | printStmt
               | block ;

ifStmt         → "if" "(" expression ")" statement
               ( "else" statement )? ;

block          → "{" declaration* "}" ;

exprStmt       → expression ";" ;
printStmt      → "print" expression ";" ;

expression     → assignment ;

assignment     → IDENTIFIER "=" assignment
               | equality ;

equality       → comparison ( ( "!=" | "==" ) comparison )* ;

comparison     → term ( ( ">" | ">=" | "<" | "<=" ) term )* ;

term           → factor ( ( "-" | "+" ) factor )* ;

factor         → unary ( ( "/" | "*" ) unary )* ;

unary          → ( "!" | "-" ) unary
               | primary ;

primary        → "true" | "false" | "nil"
               | NUMBER | STRING
               | "(" expression ")"
               | IDENTIFIER ;
```