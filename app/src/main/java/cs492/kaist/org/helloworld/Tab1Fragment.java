package cs492.kaist.org.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Jaehyun Jang on 12/24/2015.
 */

/**
 * Modified by Seungwoo Lee on 12/27/2015.
 */
public class Tab1Fragment extends Fragment {

    public Tab1Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1_fragment_main, container, false);

        String[] Objects = new String[] {
            "Apple", "Banana", "Crayon", "Dragon", "Eagle", "Fox", "Grape", "Hi", "Idle", "Jason", "Kyle", "Lenma", "MoMA", "Niels"
        };




        ListView simpleList = (ListView)view.findViewById(R.id.tab1ListView);



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, Objects);

        simpleList.setAdapter(adapter);


        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity().getApplicationContext(), "Hello", Toast.LENGTH_LONG).show();
                int itm = (int) parent.getItemAtPosition(position);
                switch (itm) {
                    case 0:
                        Toast.makeText(getActivity().getApplicationContext(), "case 0", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getActivity(), Tab1Fragment_new.class);
                        startActivity(intent);
                        break;
                }

            }
        });
        return view;
    }
}
