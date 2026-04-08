# Sudoku Board Generator

Protik Modak

## Short Description
This program generates a complete, valid 9x9 Sudoku puzzle using a backtracking algorithm. It fills the board cell by cell, then prints it neatly with borders.

## How to Run the Program
1. Save `Board.java` and `MyProgram.java` in the same folder
2. Open a terminal in that folder
3. Compile: `javac Board.java MyProgram.java`
4. Run: `java MyProgram`

## Summary of How the Sudoku Board is Generated
The program uses a backtracking algorithm:
- Start with an empty 9x9 board (all zeros)
- Try numbers 1-9 in each empty cell
- Check if the number is safe (no duplicates in row, column, or 3x3 box)
- If safe, place the number and move to the next cell
- If no number works, backtrack and try a different number
- Repeat until all 81 cells are filled

This guarantees a valid completed Sudoku board every time.

## Files Included
- `Board.java` – Contains the Board class with the 2D array, backtracking solve method, safety check, and print method
- `MyProgram.java` – Contains the main method to run the program
- `README.md` – This file

