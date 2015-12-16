import solvers.BruteForce;

/**
 * Created by Marcel on 16.12.2015.
 */
public class Main {

    static int[][] example = new int[][]{
            {0, 0, 9, 1, 0, 0, 0, 0, 2},
            {0, 4, 0, 8, 0, 5, 0, 0, 0},
            {0, 8, 0, 0, 0, 0, 0, 1, 5},
            {0, 0, 5, 6, 0, 0, 0, 4, 3},
            {0, 0, 7, 9, 0, 0, 0, 2, 8},
            {0, 9, 0, 0, 5, 8, 1, 0, 0},
            {6, 0, 0, 3, 4, 0, 0, 0, 1},
            {3, 0, 8, 7, 1, 0, 0, 0, 4},
            {0, 1, 0, 0, 0, 0, 6, 0, 7}};
    public static void main(String[] args){

        BruteForce brute = new BruteForce(example);
        brute.solve();
    }
}
