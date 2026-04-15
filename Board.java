import java.util.Random;

public class Board {
    private int[][] sudo;  
    private Random rand; 
    
    public Board(){
        sudo = new int[9][9];  
        rand = new Random();
        fillBoard();  
    }
    
    public void fillBoard(){
        solve(0, 0);  
    }
    
    
    public boolean solve(int row, int col) {
        //last row we are done
        if (row == 9){
            return true;
        }
        
        // end of a row then go to next row
        if (col == 9){
            return solve(row + 1, 0);
        }
        
        // Skipp cells with a number in it
        if (sudo[row][col] != 0){
            return solve(row, col + 1);
        }
        
        
        
        
        for (int randn = 0; randn < 9; randn++) {
            int num = rand.nextInt(9) + 1;
            
            if (isSafe(row, col, num)){
                sudo[row][col] = num;
                if (solve(row, col + 1)) return true;
                sudo[row][col] = 0;
            }
            
        }
        
        return false;
    }
    
    
    public boolean isSafe(int row, int col, int num) {
        
        for (int i = 0; i < 9; i++) {
            if (sudo[row][i] == num) {
                return false;
            }
        }
        
        
        for (int i = 0; i < 9; i++) {
            if (sudo[i][col] == num){
                return false;
            }
        }
        
        
        int boxRow = (row / 3) * 3;  
        int boxCol = (col / 3) * 3;  
        for (int r = boxRow; r < boxRow + 3; r++) {
            for (int c = boxCol; c < boxCol + 3; c++) {
                if (sudo[r][c] == num) {
                    return false;
                }
            }
        }
        return true; 
    }
    
    
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
