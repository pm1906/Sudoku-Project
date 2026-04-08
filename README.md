# Sudoku-Project

Protik Modak

## Description
Generates and prints a complete, valid 9x9 Sudoku board using a row-shifting pattern.

## How to Run
1. Save `Board.java` and `MyProgram.java` in the same folder
2. Run `javac Board.java MyProgram.java`
3. Run `java MyProgram`

## How It Works
- Row 0: 1 2 3 4 5 6 7 8 9
- Each new row = previous row shifted right by 3
- Swap rows (1,2), (4,5), (7,8)
- Swap columns (1,2), (4,5), (7,8)
- Prints board with dividers

## Files
- `Board.java` – Board class with 2D array, fill, swap, and print methods
- `MyProgram.java` – Main method to run the program
