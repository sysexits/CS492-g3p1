package cs492.kaist.org.helloworld;

/**
 * Created by user on 2015-12-29.
 */
public class Game {

    public Tile[] board;
    private int height;
    private int width;
    private int mines;
    public boolean isGameOver;
    public boolean isVictory;

    public Game(int x, int y, int mines)
    {
        initialize(x, y, mines);
    }

    public Game()
    {
        initialize(9, 9, 10);
    }

    public void Reset()
    {
        initialize(9, 9, 10);
    }

    public void click(int position)
    {
        if (isGameOver)
        {
            return;
        }
        if (board[position].clicked)
        {
            return;
        }
        if (board[position].flagged)
        {
            return;
        }
        board[position].clicked = true;
        if (board[position].mined)
        {
            loseGame();
            return;
        }
        if (board[position].indicator == 0)
        {
            propagate(position);
        }
        if (winCondition())
        {
            isGameOver = true;
            isVictory = true;
        }
    }

    public void longClick(int position)
    {
        if (!board[position].clicked)
        {
            board[position].flagged ^= true;

        }
    }

    private void propagate(int position)
    {
        if (position % width != 0) //if block is not on left
        {
            click(position - 1);
        }
        if (position % width != width - 1) // if block is not on right
        {
            click(position + 1);
        }
        if (position >= width) //if block is not on top
        {
            click(position - width);
        }
        if (position < board.length - width) // if block is not on bottom
        {
            click(position + width);
        }
        if (position % width != 0 && position >= width) // topleft
        {
            click(position - 1 - width);
        }
        if (position % width != 0 && position < board.length - width) //bottomleft
        {
            click(position - 1 + width);
        }
        if (position % width != width - 1 && position >= width) //topright
        {
            click(position + 1 - width);
       }
        if (position % width != width - 1 && position < board.length - width) //bottomright
        {
            click(position + 1 + width);
        }

    }

    private void loseGame()
    {
        for (int i = 0; i < board.length; i++)
        {
            if (board[i].mined)
            {
                click(i);
            }
        }
        isGameOver = true;
    }

    private boolean winCondition()
    {
        int count = 0;
        for (Tile t : board)
        {
            if (!t.clicked)
            {
                if (!t.mined)
                {
                    return false;
                }
                count++;
            }
        }
        if (count == mines) {
            return true;
        }
        return false;
    }

    private void initialize(int width, int height, int mines)
    {
        this.height = height;
        this.width = width;
        this.mines = mines;
        this.isGameOver = false;
        this.isVictory = false;
        board = new Tile[height * width];
        for (int i = 0; i < height * width; i++)
        {
            board[i] = new Tile();
        }
        fillMines(mines);
        fillNumbers();
    }

    private void fillMines(int num)
    {
        int count = 0;
        while (count < num)
        {
            int position = (int) (Math.random() * board.length);
            if (!board[position].mined) {
                board[position].mined = true;
                count++;
            }
        }
    }

    private void fillNumbers()
    {
        for (int i = 0; i < board.length; i++)
        {
            if (board[i].mined)
            {
                continue;
            }
                int count = 0;
            if (i % width != 0) //if block is not on left
            {
                if (board[i-1].mined)
                    count ++;
            }
            if (i % width != width - 1) // if block is not on right
            {
                if (board[i + 1].mined)
                    count ++;
            }
            if (i >= width) //if block is not on top
            {
                if (board[i - width].mined)
                    count ++;
            }
            if (i < board.length - width) // if block is not on bottom
            {
                if (board[i + width].mined)
                    count ++;
            }
            if (i % width != 0 && i >= width) // topleft
            {
                if (board[i - 1 - width].mined)
                    count++;
            }
            if (i % width != 0 && i < board.length - width) //bottomleft
            {
                if (board[i - 1 + width].mined)
                    count++;
            }
            if (i % width != width - 1 && i >= width) //topright
            {
                if (board[i + 1 - width].mined)
                    count++;
            }
            if (i % width != width - 1 && i < board.length - width) //bottomright
            {
                if (board[i + 1 + width].mined)
                    count++;
            }
            board[i].indicator = count;
        }
    }
}

