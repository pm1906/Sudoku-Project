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
    public boolean solve(int row, int col) {
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
    public boolean isSafe(int row, int col, int num) {
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
