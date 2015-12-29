package cs492.kaist.org.helloworld;

/**
 * Created by user on 2015-12-29.
 */
public class Game {

    private int[][] board;

    public Game(int x, int y, int mines)
    {
        initialize(x, y, mines);
    }
    private void initialize(int width, int height, int mines)
    {
        board = new int[height][width];


    }
}
