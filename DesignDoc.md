Program Overview

The program generates valid 9x9 Sudoku puzzles. It uses a pattern-based approach to build the board row by row, then applies simple swaps to make the board look less predictable.Then it prints it neatly.

Data Structures

2D Array (sudo)
The 9x9 Sudoku board is stored in a 2D integer array named sudo. Each cell holds a number from 1 to 9. The array allows easy access to any row and column.

I just use an array and not an arraylist. 


Algorithm Design

The program generates a solved Sudoku board using a row-shifting pattern.

First, it fills the first row with numbers 1 through 9. Then, it fills each subsequent row by shifting the previous row 3 positions to the right, and also wrapping around to the beginning when needed. This pattern automatically satisfies the row, column, and 3x3 box rules of Sudoku.

After the base pattern is created, the program swaps rows within each band of three rows. Specifically, it swaps rows 1 and 2, rows 4 and 5, and rows 7 and 8. Then it swaps columns within each band of three columns, swapping columns 1 and 2, 4 and 5, and 7 and 8. These swaps make the board look more random while satisfying the rules of the game.



Methods

The Board constructor initializes the 9x9 array and calls fillBoard.

The fillBoard method builds the Sudoku board using the row-shifting pattern, then calls swapRows and swapCols to add randomness.

The swapRows method takes two row indexes and swaps all the values in those rows.

The swapCols method takes two column indexes and swaps all the values in those columns.

The printBoard method prints the Sudoku board to the console with dividers between each 3x3 box for easy reading.

Testing Plan

I tested my program using the following methods.

First, I manually checked that each row contains numbers 1 through 9 with no duplicates. I did this by looking at the printed output and scanning each row.

Second, I manually checked that each column contains numbers 1 through 9 with no duplicates. I traced down each column in the printed output.

Third, I manually checked that each 3x3 box contains numbers 1 through 9 with no duplicates. I examined each box section in the printed grid.

Fourth, I ran the program multiple times to ensure the board prints correctly with the dividers in the right places.

The tests passed so it was a valid sudoku. 

Challenges and Solutions

One challenge I faced was making sure the row-shifting pattern actually created a valid Sudoku board. I wasn't sure why shifting by 3 worked. I tried shifting by other numbers like 1 or 2, but those created duplicate numbers in the same column or box.

To solve this, I tested different shift values on paper. I discovered that shifting by 3 works because the board is 9x9 and each box is 3x3. A shift of 3 moves numbers into a new box entirely, so each box ends up with one of each number. I also learned that shifting by 6 works for the same reason. I chose 3 because it was simple and easy to understand. This taught me how the math behind Sudoku patterns actually works.


Source Code:

MyProgram.java:

public class MyProgram
{
    public static void main(String[] args)
    {
        Board sudol = new Board();
        
        sudol.fillBoard();
        
        sudol.printBoard();
    }
    
}

Board.java:

public class Board {
    private int[][] sudo;
    
    public Board(){
        sudo = new int[9][9];
        fillBoard();
    }
    
    public void fillBoard(){
        // Filling the first row with numbers 1-9
        for (int c = 0; c < 9; c++) {
            sudo[0][c] = c + 1;
        }
        
        // Filling the rest of the rows by shifting
        // Each row is the previous row shifted by 3 positions
        for (int r = 1; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                // Then shift each row by 3 to create a valid pattern
                int newCol = (c + 3) % 9;
                sudo[r][newCol] = sudo[r-1][c];
            }
        }
        
        //  Swapiing the rows
        swapRows(1, 2);
        swapRows(4, 5);
        swapRows(7, 8);
        
        // Swaping the columns 
        swapCols(1, 2);
        swapCols(4, 5);
        swapCols(7, 8);
    }
    
    
    public void swapRows(int row1, int row2) {
        for (int c = 0; c < 9; c++) {
            int temp = sudo[row1][c];
            sudo[row1][c] = sudo[row2][c];
            sudo[row2][c] = temp;
        }
    }
    
    
    public void swapCols(int col1, int col2) {
        for (int r = 0; r < 9; r++) {
            int temp = sudo[r][col1];
            sudo[r][col1] = sudo[r][col2];
            sudo[r][col2] = temp;
        }
    }
    
    public void printBoard() {
        System.out.println("═════════════════════════");
        for (int r = 0; r < 9; r++) {
            //  horizontal divider every 3 rows
            if (r % 3 == 0 && r != 0) {
                System.out.println("═════════════════════════");
            }
            
            for (int c = 0; c < 9; c++) {
                // vertical divider every 3 columns
                if (c % 3 == 0) {
                    System.out.print("║ ");
                }
                System.out.print(sudo[r][c] + " ");
            }
            System.out.println("║");
        }
        System.out.println("═════════════════════════");
    }
}



