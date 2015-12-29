package cs492.kaist.org.helloworld;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class Tab3Fragment extends Fragment {


    GridAdapter gridAdapter;
    public Tab3Fragment() {
        // Required empty public constructor
    }

    ImageView newGame;
    Game game;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.tab3_fragment_main, container, false);

        //Button newGame = (Button)view.findViewById(R.id.btnNewGame);
        newGame = (ImageView)view.findViewById(R.id.btnNewGame);

        Picasso.with(getContext()).load("http://weknowyourdreams.com/images/smile/smile-09.jpg").fit().centerCrop().into(newGame);
        //http://www.clipartbest.com/cliparts/Kin/oyR/KinoyRpiq.jpeg

        GridView gridview = (GridView)view.findViewById(R.id.gridview);
        game = new Game();
        gridAdapter = new GridAdapter(this.getContext(), game);
        gridview.setAdapter(gridAdapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                game.click(position);
                gridAdapter.notifyDataSetChanged();

                if (game.isGameOver) {
                    if (game.isVictory) {
                        Toast.makeText(getContext(), "Congratulations! You WIN!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(), "You died :(", Toast.LENGTH_SHORT).show();
                        Picasso.with(getContext()).load("http://www.clipartbest.com/cliparts/Kin/oyR/KinoyRpiq.jpeg").fit().centerCrop().into(newGame);
                    }
                }
            }
        });
        gridview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                game.longClick(position);
                gridAdapter.notifyDataSetChanged();
                return true;
            }
        });

        newGame.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                game.Reset();
                gridAdapter.notifyDataSetChanged();
                Picasso.with(getContext()).load("http://weknowyourdreams.com/images/smile/smile-09.jpg").fit().centerCrop().into(newGame);
            }
        });






        return view;
    }

}
