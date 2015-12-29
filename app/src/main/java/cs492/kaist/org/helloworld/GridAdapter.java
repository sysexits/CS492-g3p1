package cs492.kaist.org.helloworld;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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
        if (convertView == null)
        {
            textView = new TextView(mContext);
            int val = game.board[position];
            textView.setText(Integer.toString(val));
        }
        else
        {
            int val = game.board[position];
            ((TextView)convertView).setText(Integer.toString(val));
            textView = (TextView)convertView;
        }

        return textView;
    }
}
