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
        List<Integer> cellSolutions = new LinkedList<>();
        int x = 8 - 1;
        int y = 2 - 1;
        for(int i = 1; i < 10; i++)
            cellSolutions.add(i);
        System.out.println(cellSolutions);
        checkSquare(x, y, cellSolutions);
        System.out.println("squareCheck:" + cellSolutions);
        checkRow(x, cellSolutions);
        System.out.println("rowCheck:   " + cellSolutions);
        checkCol(y, cellSolutions);
        System.out.println("colCheck:   " + cellSolutions);

        for (int i = 0; i < rowLenght ; i++) {
            for (int j = 0; j < colLenght; j++) {

            }
        }
    }

    public void checkRow(int row, List<Integer> list){
//        row +=1;
        for (int i = 0; i < colLenght ; i++) {
            if (table[row][i] != 0 && list.contains(table[row][i])) {
                list.remove(list.indexOf(table[row][i]));
            }

        }
    }

    public void checkCol(int col, List<Integer> list){
//        col += 1;
        for (int i = 0; i < colLenght ; i++) {
            if (table[i][col] != 0 && list.contains(table[i][col])) {
                list.remove(list.indexOf(table[i][col]));
            }

        }
    }

    public void checkSquare(int row, int col, List<Integer> list){
        int squareIndex = findSquareIndex(row, col);
        System.out.println("squareIndex: " + squareIndex);
        int[] squareCords = squareCords(squareIndex);
        for (int i = squareCords[0]; i < squareCords[0] + squareLenght; i++) {
            for (int j = squareCords[1]; j < squareCords[1] + squareLenght; j++) {
                if (table[i][j] != 0 && list.contains(table[i][j])) {
                    list.remove(list.indexOf(table[i][j]));
                }
            }

        }
    }

    public int findSquareIndex(int row, int col) {
        int x = (int) Math.floor(row / 3);
        int y = (int) Math.floor(col / 3);
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
















