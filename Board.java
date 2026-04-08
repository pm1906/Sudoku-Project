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
