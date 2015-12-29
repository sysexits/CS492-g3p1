package cs492.kaist.org.helloworld;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by outtoin on 15. 12. 29..
 */
public class PlayerAdapter extends ArrayAdapter<Player> {
    public ArrayList<Player> players;
    public Context context;
    public PlayerAdapter(Context context, ArrayList<Player> players) {
        super(context, 0, players);
        this.context = context;
        this.players = players;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Player player = getItem(position);
        if(view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.item_player, parent, false);
        }

        TextView tvName = (TextView) view.findViewById(R.id.playerName);
        TextView tvTeam = (TextView) view.findViewById(R.id.playerTeam);
        TextView tvNumber = (TextView) view.findViewById(R.id.playerNumber);
        ImageView ivImage = (ImageView) view.findViewById(R.id.playerImage);

        tvName.setText(player.name);
        tvTeam.setText(player.team);
        tvNumber.setText(player.number);
        Picasso.with(context).load(player.url).fit().centerCrop().into(ivImage);
        return view;
    }
}