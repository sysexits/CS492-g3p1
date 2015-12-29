package cs492.kaist.org.helloworld;

/**
 * Created by user on 2015-12-29.
 */
public class Game {

    public int[] board;
    private int height;
    private int width;
    // board number code
    // 0 ~ 8 : number
    //

    public Game(int x, int y, int mines)
    {
        initialize(x, y, mines);
    }

    public Game()
    {
        initialize(9, 9, 10);
    }

    public void click(int position)
    {
        board[position] = board[position] + 1;
    }

    private void initialize(int width, int height, int mines)
    {
        this.height = height;
        this.width = width;
        board = new int[height * width];
        fillMines(mines);
        fillNumbers();
    }
    private void fillMines(int num)
    {
        int count = 0;
        while (count < num)
        {
            int position = (int) (Math.random() * board.length);
            if (board[position] == 0) {
                board[position] = -1;
                count++;
            }
        }
    }

    private void fillNumbers()
    {
        for (int i = 0; i < board.length; i++)
        {
            if (board[i] == -1)
            {
                continue;
            }
                int count = 0;
            if (i % width != 0) //if block is not on left
            {
                if (board[i-1] == -1)
                    count ++;
            }
            if (i % width != width - 1) // if block is not on right
            {
                if (board[i + 1] == -1)
                    count ++;
            }
            if (i >= width) //if block is not on top
            {
                if (board[i - width] == -1)
                    count ++;
            }
            if (i < board.length - width) // if block is not on bottom
            {
                if (board[i + width] == -1)
                    count ++;
            }
            if (i % width != 0 && i >= width) // topleft
            {
                if (board[i - 1 - width] == -1)
                    count++;
            }
            if (i % width != 0 && i < board.length - width) //bottomleft
            {
                if (board[i - 1 + width] == -1)
                    count++;
            }
            if (i % width != width - 1 && i >= width) //topright
            {
                if (board[i + 1 - width] == -1)
                    count++;
            }
            if (i % width != width - 1 && i < board.length - width) //bottomright
            {
                if (board[i + 1 + width] == -1)
                    count++;
            }
            board[i] = count;
        }
    }
}
