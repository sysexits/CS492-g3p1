package cs492.kaist.org.helloworld;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

/**
 * Created by HAJE on 2015-12-29.
 */
public class GridAdapter extends BaseAdapter {

    private Context mContext;
    private Game game;
    public GridAdapter(Context c, Game game)
    {
        mContext = c;
        this.game = game;
    }

    @Override
    public int getCount() {
        return game.board.length;
    }

    @Override
    public Object getItem(int position) {
        return game.board[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView;
        Tile tile = game.board[position];
        if (convertView == null)
        {
            int indicator = tile.indicator;
            textView = new TextView(mContext);
            textView.setLayoutParams(new GridView.LayoutParams(GridView.AUTO_FIT, 100));
            textView.setGravity(Gravity.CENTER);
            textView.setTextSize(24);

            if (tile.clicked)
            {
                textView.setBackgroundColor(Color.parseColor("#ffffff"));
            }
            else
            {
                textView.setBackgroundColor(Color.parseColor("#cccccc"));
            }

            textView.setText(Integer.toString(indicator));
            if (tile.mined)
            {
                textView.setText(Integer.toString(-1));
            }
            if (!tile.clicked)
            {
                textView.setText("");
            }
        }
        else
        {
            int indicator = tile.indicator;
            textView = (TextView) convertView;
            if (tile.clicked)
            {
                textView.setBackgroundColor(Color.parseColor("#ffffff"));
            }
            else
            {
                textView.setBackgroundColor(Color.parseColor("#cccccc"));
            }
            textView.setText(Integer.toString(indicator));
            if (tile.mined)
            {
                textView.setText(Integer.toString(-1));
            }
            if (!tile.clicked)
            {
                textView.setText("");
            }

        }

        return textView;
    }
}
