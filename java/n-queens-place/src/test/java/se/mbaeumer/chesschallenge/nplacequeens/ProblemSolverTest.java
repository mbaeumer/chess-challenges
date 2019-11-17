package se.mbaeumer.chesschallenge.nplacequeens;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProblemSolverTest {

    @Test
    public void isAttacked() {
        ProblemSolver problemSolver = new ProblemSolver();

        int[][] chessboard = new int[4][4];
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                chessboard[i][j] = 0;
            }
        }
        chessboard[0][2] = 1;

        problemSolver.setChessboard(chessboard);

        Assert.assertTrue(problemSolver.isAttacked(0,1));
        Assert.assertTrue(problemSolver.isAttacked(2,2));
        Assert.assertTrue("should return true", problemSolver.isAttacked(2,0));
    }

    @Test
    public void test(){
        ProblemSolver problemSolver = new ProblemSolver();
        Assert.assertTrue(problemSolver.solve(4));
        for (int i = 0; i< 4; i++){
            for (int j=0;j<4;j++){
                int v = problemSolver.getChessboard()[i][j];
                System.out.print(problemSolver.getChessboard()[i][j] + " ");
            }
            System.out.println();
        }
    }
}