import boards.SudokuBoard;
import design.Colors;
import solvers.BruteForce;

/**
 * Created by Marcel on 16.12.2015.
 */
public class Main {
    private long start, stop;

    public void start() {
        start = System.currentTimeMillis(); // start timing
    }

    public void stop() {
        stop = System.currentTimeMillis(); // stop timing
    }

    public long Time() {
        return (stop - start);
    }

    public String end() {
        return Colors.YELLOW + "Algorithm took: " + Long.toString(Time()) + " [ms].\n\n" + Colors.RESET; // print execution time
    }

    public static void main(String[] args){

        BruteForce brute = new BruteForce(SudokuBoard.example);
        Main timer = new Main();
        timer.start();
        brute.solve();
        timer.stop();
        brute.showSolution();

        System.out.println(timer.end());
    }
}
