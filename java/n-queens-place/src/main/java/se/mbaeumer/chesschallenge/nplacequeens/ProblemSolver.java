package se.mbaeumer.chesschallenge.nplacequeens;

public class ProblemSolver {

    private int[][] chessboard = new int[4][4];

    public void setChessboard(int[][] chessboard) {
        this.chessboard = chessboard;
    }

    public ProblemSolver(){
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                chessboard[i][j] = 0;
            }
        }
    }

    public boolean solve(int n){
        if (n == 0){
            return true;
        }

        for (int i=0;i<4;i++){
            for (int j=0;j<4;j++){
                if (!isAttacked(i, j)){
                    chessboard[i][j]=1;
                    System.out.println("Placed queen at ["+i+","+j+"]");
                    if (solve(n-1)){
                        return true;
                    }
                    System.out.println("Removed queen at ["+i+","+j+"]");
                    chessboard[i][j] = 0;
                }
            }
        }
        return false;
    }

    public boolean isAttacked(final int row, final int column){
        for (int i = 0; i < 4; i++){
            if (chessboard[row][i] == 1) return true;
        }

        for (int i = 0; i < 4; i++){
            if (chessboard[i][column] == 1) return true;
        }

        int x = column;
        int y = row;

        while (x < 4 && x >= 0 && y < 4 && y >= 0){
            if (chessboard[y][x] == 1) {
                return true;
            }
            x--;
            y++;
        }

        x = column;
        y = row;
        while (x < 4 && x >= 0 && y < 4 && y >= 0){
            if (chessboard[y][x] == 1) {
                return true;
            }
            x++;
            y++;
        }

        x = column;
        y = row;
        while (x < 4 && x >= 0 && y < 4 && y >= 0){
            if (chessboard[y][x] == 1) {
                return true;
            }
            x--;
            y--;
        }

        x = column;
        y = row;
        while (x < 4 && x >= 0 && y < 4 && y >= 0){
            if (chessboard[y][x] == 1) {
                return true;
            }
            x++;
            y--;
        }

        return false;


    }

    public int[][] getChessboard() {
        return chessboard;
    }
}
