package solvers;

import java.util.ArrayList;
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

        while (!isSolved(table)) {
            for (int i = 0; i < rowLenght; i++) {
                for (int j = 0; j < colLenght; j++) {
                    if (table[i][j] == 0)
                        table[i][j] = findCellSolution(i, j);
                }
            }
        }
    }

    public int findCellSolution(int row, int col) {
        List<Integer> cellSolutions = new LinkedList<>();
        for (int i = 1; i < 10; i++)
            cellSolutions.add(i);

        checkSquare(row, col, cellSolutions);
        checkRow(row, cellSolutions);
        checkCol(col, cellSolutions);

        if (isCellSolution(cellSolutions))
            return cellSolutions.get(0);
        return 0;

    }

    public boolean isCellSolution(List<Integer> list) {
        if (list.size() == 1)
            return true;
        return false;
    }

    public void checkRow(int row, List<Integer> list){
        for (int i = 0; i < colLenght ; i++) {
            if (table[row][i] != 0 && list.contains(table[row][i])) {
                list.remove(list.indexOf(table[row][i]));
            }

        }
    }

    public void checkCol(int col, List<Integer> list){
        for (int i = 0; i < colLenght ; i++) {
            if (table[i][col] != 0 && list.contains(table[i][col])) {
                list.remove(list.indexOf(table[i][col]));
            }

        }
    }

    public void checkSquare(int row, int col, List<Integer> list){
        int squareIndex = findSquareIndex(row, col);
        int[] squareCords = squareCords(squareIndex);

        for (int i = squareCords[0]; i < squareCords[0] + squareLenght; i++) {
            for (int j = squareCords[1]; j < squareCords[1] + squareLenght; j++) {
                if (table[i][j] != 0 && list.contains(table[i][j]))
                    list.remove(list.indexOf(table[i][j]));
            }
        }
    }

    public int findSquareIndex(int row, int col) {
        int x = (int) Math.floor((row) / 3);
        int y = (int) Math.floor((col) / 3);
        int tab[][] = new int[][]{ {1,2,3},
                                   {4,5,6},
                                   {7,8,9} };
        return tab[x][y];
    }

    public int[] squareCords(int squareIndex) {
        int squareCord[] = new int[]{0, 3, 6};

        List<int[]> cords = new ArrayList<>();
        for (int i = 0; i < squareCord.length; i++) {
            for (int j = 0; j < squareCord.length; j++) {
                cords.add(new int[]{squareCord[i], squareCord[j]});
            }
        }

        return cords.get(squareIndex - 1);
    }
}
















