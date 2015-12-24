package cs492.kaist.org.helloworld;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Jaehyun Jang on 12/24/2015.
 */
public class Tab1Fragment extends Fragment {

    public Tab1Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1_fragment_main, container, false);

        String[] Objects = new String[] {
            "Apple", "Banana", "Crayon", "Dragon", "Eagle", "Fox", "Grape"
        };

        ListView simpleList = (ListView)view.findViewById(R.id.tab1ListView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, Objects);

        simpleList.setAdapter(adapter);

        return view;
    }
}
