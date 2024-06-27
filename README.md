# Lox Language in Java

This is an attempt to implement the Lox language, as described in
the website [Crafting Interpreters](https://craftinginterpreters.com/statements-and-state.html) in Java.

This is just a study case / compilers/interpreters study, and it's not meant to be production ready nor benchmarked
for anything.

All credits go to the author of the website and the Lox language, your work is awesome,
easy to follow and very didactic. I wish studying compilers in Uni were that easy in my Uni time.

## Running examples

Since, for now, it's "just" an interpreter, I created a gradle task in which you can run your examples to test:
just run `./gradlew processLoxFile -Pfile=examples/print_statements.lox`. You can rename the file you want to execute.

## Grammar

Here you can find the current grammar (BNF-ish - Backus-Naur Form) for the language. If it's here, most likely it's implemented:

```text
program        → declaration* EOF ;

declaration    → classDecl | funDecl | varDecl | statement ;

classDecl      → "class" IDENTIFIER ( "<" IDENTIFIER )? "{" function* "}" ;

funDecl        → "fun" function ;

function       → IDENTIFIER "(" parameters? ")" block ;

parameters     → IDENTIFIER ( "," IDENTIFIER )* ;

varDecl        → "var" IDENTIFIER ( "=" expression )? ";" ;

statement      → exprStmt | forStmt | ifStmt | printStmt | returnStmt | whileStmt | block ;

exprStmt       → expression ";" ;

forStmt        → "for" "(" (varDecl | exprStmt | ";" )
                 expression? ";"
                 expression? ")" statement ;

ifStmt         → "if" "(" expression ")" statement
               ( "else" statement )? ;

printStmt      → "print" expression ";" ;

returnStmt     → "return" expression? ";" ;

whileStmt      → "while" "(" expression ")" statement ;

block          → "{" declaration* "}" ;

expression     → assignment ;

assignment     → ( call "." )? IDENTIFIER "=" assignment | logic_or ;

logic_or       → logic_and ( "or" logic_and )* ;

logic_and      → equality ( "and" equality )* ;

equality       → comparison ( ( "!=" | "==" ) comparison )* ;

comparison     → term ( ( ">" | ">=" | "<" | "<=" ) term )* ;

term           → factor ( ( "-" | "+" ) factor )* ;

factor         → unary ( ( "/" | "*" ) unary )* ;

unary          → ( "!" | "-" ) unary | call ;

call           → primary ( "(" arguments? ")" | "." IDENTIFIER )* ;

arguments      → expression ( "," expression )* ;

primary        → "true" | "false" | "nil" | "this"
               | NUMBER | STRING | IDENTIFIER | "(" expression ")"
               | "super" "." IDENTIFIER;
```