package solvers;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Marcel on 16.12.2015.
 */
public class BruteForce extends SudokuSolver {

    public BruteForce(int[][] table) {
        super(table);
    }

    @Override
    public void solve() {
        List<Integer> cellSolutions = new LinkedList<>();
        for(int i = 1; i < 10; i++)
            cellSolutions.add(i);
        System.out.println(cellSolutions);
        checkRow(0, cellSolutions);
        System.out.println(cellSolutions);
        checkCol(0, cellSolutions);
        System.out.println(cellSolutions);

        for (int i = 0; i < rowLenght ; i++) {
            for (int j = 0; j < colLenght; j++) {

            }
        }
    }

    public void checkRow(int row, List<Integer> list){
        for (int i = 0; i < colLenght ; i++) {
            if(table[row][i] != 0){
                list.remove(list.indexOf(table[row][i]));
            }

        }
    }

    public void checkCol(int col, List<Integer> list){
        for (int i = 0; i < colLenght ; i++) {
            if(table[i][col] != 0){
                list.remove(list.indexOf(table[i][col]));
            }

        }
    }

    public void checkSquare(int row, int col, List<Integer> list){
        int squareIndex = findSquareIndex(row, col);



    }

    public int findSquareIndex(int row, int col) {
        int x = (int) Math.floor(row / 3);
        int y = (int) Math.floor(col / 3);
        int tab[][] = new int[][]{ {1,2,3},
                                   {4,5,6},
                                   {7,8,9} };
        return tab[x][y];
    }
}
















