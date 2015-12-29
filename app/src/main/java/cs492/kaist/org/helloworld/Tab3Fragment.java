package cs492.kaist.org.helloworld;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class Tab3Fragment extends Fragment {


    GridAdapter gridAdapter;
    public Tab3Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.tab3_fragment_main, container, false);

        GridView gridview = (GridView)view.findViewById(R.id.gridview);
        final Game game = new Game(9, 9, 9);
        gridAdapter = new GridAdapter(this.getContext(), game);
        gridview.setAdapter(gridAdapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                game.click(position);
                gridAdapter.notifyDataSetChanged();
            }
        });


        return view;
    }

}
