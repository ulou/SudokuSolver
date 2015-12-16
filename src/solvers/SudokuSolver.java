package solvers;

import boards.SudokuBoard;
import design.Colors;

/**
 * Created by Marcel on 16.12.2015.
 */
public abstract class SudokuSolver {

    protected final int colLenght = 9;
    protected final int rowLenght = 9;
    protected final int squareLenght = 3;

    protected int table[][];

    public SudokuSolver(int[][] table) {
        this.table = table;
    }

    public abstract void solve();

    public boolean isSolved(int[][] table) {
        int zeroCounter = 0;
        for (int i = 0; i < rowLenght; i++) {
            for (int j = 0; j < colLenght; j++) {
                if (table[i][j] == 0)
                    zeroCounter++;
            }
        }
        return (zeroCounter == 0);
    }

    public void showSolution(){
        for (int i = 0; i < rowLenght ; i++) {
            for (int j = 0; j < colLenght ; j++) {
                if (table[i][j] == 0)
                    System.out.print(Colors.WHITE + table[i][j] + Colors.RESET + " ");
                else if (SudokuBoard.example[i][j] == table[i][j])
                    System.out.print(Colors.BLACK + table[i][j] + Colors.RESET + " ");
                else
                    System.out.print(Colors.GREEN + table[i][j] + Colors.RESET + " ");
                if(j%3 == 2)
                    System.out.print(" ");
            }
            if(i%3 == 2)
                System.out.println();
            System.out.println();
        }
    }

}
