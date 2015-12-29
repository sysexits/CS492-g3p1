package cs492.kaist.org.helloworld;

/**
 * Created by user on 2015-12-29.
 */
public class Game {

    public int[] board;

    public Game(int x, int y, int mines)
    {
        initialize(x, y, mines);
    }

    public Game()
    {
        initialize(9, 9, 9);
    }

    public void draw()
    {

    }

    public void click(int position)
    {
        board[position] = board[position] + 1;
    }

    private void initialize(int width, int height, int mines)
    {
        board = new int[height * width];

    }
}
