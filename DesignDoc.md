The program generates a valid 9x9 Sudoku puzzle using a backtracking algorithm. It fills the board cell by cell by trying numbers 1 through 9 and backtracking when a conflict occurs. Once the board is complete, it then prints it neatly with borders.

Data Structures
2D Array (sudo) – The 9x9 Sudoku board is stored in a 2D integer array named sudo. Each cell holds a number from 1 to 9. The array allows easy access to any row and column.

I don’t use an ArrayList. 

Algorithm Design
The program generates a solved Sudoku board using a backtracking algorithm.

First, it starts with an empty 9x9 board filled with zeros. Then it calls the solve method starting at row 0, column 0. The solve method tries numbers 1 through 9 in each empty cell. For each number, it checks if the number is safe to place by verifying the row, column, and 3x3 box have no duplicates. If the number is safe, it places the number and moves to the next cell. If a dead end is reached, it removes the number (backtracks) and tries the next number. The algorithm continues until all 81 cells are filled correctly.


Methods
Constructor: Initializes the 9x9 array and calls fillBoard.

fillBoard: Starts the solving process by calling solve(0, 0).

solve: Uses backtracking to fill the board. Takes row and column parameters. Returns true when the board is complete.

isSafe:  Checks if a number can be placed at a given position. Checks the row, column, and 3x3 box for duplicates.

printBoard:  Prints the Sudoku board to the console with plus, minus, and pipe symbols creating borders between each 3x3 box for easy reading.

Testing Plan
I tested my program using the following methods.

First, I manually checked that each row contains numbers 1 through 9 with no duplicates. I did this by looking at the printed output and scanning each row.

Second, I manually checked that each column contains numbers 1 through 9 with no duplicates. I traced down each column in the printed output.

Third, I manually checked that each 3x3 box contains numbers 1 through 9 with no duplicates. I examined each box section in the printed grid.

Fourth, I ran the program multiple times to ensure the board prints correctly with the dividers in the right places.

The tests passed so it was a valid Sudoku.

Challenges and Solutions
One challenge I faced was making sure the backtracking algorithm actually completed the board. At first, my solve method was not correctly moving to the next cell after placing a number.

To solve this, I added conditions to skip cells that already have numbers and to move to the next row when reaching the end of a column. I also made sure to return true only when row reaches 9, indicating all rows are filled. After fixing these issues, the algorithm successfully generated a complete valid Sudoku board.


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
        solve(0, 0);  // Start solving from top-left corner
    }
    
    // Try to solve the board using backtracking
    private boolean solve(int row, int col) {
        //last row we are done
        if (row == 9) return true;
        
        // end of a row then go to next row
        if (col == 9) return solve(row + 1, 0);
        
        // Skipp cells with a number in it
        if (sudo[row][col] != 0) return solve(row, col + 1);
        
        // Try numbers 1 through 9
        for (int num = 1; num <= 9; num++) {
            if (isSafe(row, col, num)) {  // Check to see if a number can go here
                sudo[row][col] = num;  // Place the number
                if (solve(row, col + 1)) return true;  //next cell after placing
                sudo[row][col] = 0;  // if not valid remove
            }
        }
        return false;  // No number worked so go back
    }
    
    // Checking to see if a number is valid to place at (row, col)
    private boolean isSafe(int row, int col, int num) {
        // Check the row
        for (int i = 0; i < 9; i++) {
            if (sudo[row][i] == num) return false;
        }
        
        // Check the column
        for (int i = 0; i < 9; i++) {
            if (sudo[i][col] == num) return false;
        }
        
        // Check the 3x3 box
        int boxRow = (row / 3) * 3;  // Top row of the box
        int boxCol = (col / 3) * 3;  // Left column of the box
        for (int r = boxRow; r < boxRow + 3; r++) {
            for (int c = boxCol; c < boxCol + 3; c++) {
                if (sudo[r][c] == num) return false;
            }
        }
        return true;  // Number is safe to place
    }
    
    // Print the board with borders
    public void printBoard() {
        System.out.println("+-------+-------+-------+");
        for (int r = 0; r < 9; r++) {
            System.out.print("| ");
            for (int c = 0; c < 9; c++) {
                System.out.print(sudo[r][c] + " ");
                if ((c + 1) % 3 == 0) {  
                    System.out.print("| ");
                }
            }
            System.out.println();
            if ((r + 1) % 3 == 0) {  
                System.out.println("+-------+-------+-------+");
            }
        }
    }
}




