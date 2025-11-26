# Simren BookShop

A small command-line Java program to manage a bookstore: add/search/purchase/display books and handle invalid inputs via a custom `IncorrectInputException`.

## Features
- Add books (title, author, publisher, price, stock)
- Search by title + author (case-insensitive)
- Purchase a number of copies with stock validation
- Custom checked exception `IncorrectInputException` for invalid inputs

## Project structure
.
├─ src/

│ └─ BookShopDriver.java ← contains all classes in single file (you can split into files)

├─ .gitignore

├─ README.md

└─ LICENSE


## Prerequisites
- Java Development Kit (JDK) 11+ installed
- `javac` and `java` on your PATH

## Compile & run (single-file / no build tool)
Put your Java file(s) in `src/`. From project root:

```bash
# compile (output classes into bin/)
mkdir -p bin
javac -d bin src/*.java

# run
java -cp bin BookShopDriver

Example usage

After running, you'll see a menu:

Simren BookShop
Add Books-----1
Search books-----2
Purchase books----3
Display books-----4
Exit-------------5
Enter your choice:
