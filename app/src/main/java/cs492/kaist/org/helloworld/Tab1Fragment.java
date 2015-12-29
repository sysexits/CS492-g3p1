package cs492.kaist.org.helloworld;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Jaehyun Jang on 12/24/2015.
 */

/**
 * Modified by Seungwoo Lee on 12/27/2015.
 */
public class Tab1Fragment extends Fragment {
    //URL to get JSON Array
    private static String url = "http://cgv.kaist.ac.kr/~jaehyun/cs492/players.json";

    //JSON Node Names
    private static final String TAG_NAME = "name";
    private static final String TAG_NUMBER = "number";
    private static final String TAG_TEAM = "team";
    private static final String TAG_URL = "url";

    public Tab1Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1_fragment_main, container, false);

        JSONParse jsonParse = new JSONParse();
        JSONObject jsonObject = null;
        try {
            jsonObject = jsonParse.execute(url).get();
        } catch (Exception e) {
            e.printStackTrace();
        }


        final ArrayList<Player> players = new ArrayList<Player>();

        for(int i=0; i<jsonObject.length(); i++) {
            JSONObject player = null;
            String name = "";
            String team = "";
            String url = "";
            String number = "";
            try {
                player = (JSONObject) jsonObject.get(Integer.toString(i));
                name = player.getString("name");
                team = player.getString("team");
                url = player.getString("img");
                number = player.getString("number");
            } catch (Exception e) {
                e.printStackTrace();
            }
            Player playerStruct = new Player(name, team, number, url);
            players.add(i,playerStruct);
        }

        PlayerAdapter adapter = new PlayerAdapter(getActivity(), players);

        ListView simpleList = (ListView) view.findViewById(R.id.tab1ListView);
        simpleList.setAdapter(adapter);

        return view;
    }

    private class JSONParse extends AsyncTask<String, String, JSONObject> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected JSONObject doInBackground(String... args) {
            JSONObject json = null;
            try {
                JSONParser jParser = new JSONParser();
                // Getting JSON from URL
                json = jParser.getJSONFromUrl(url);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return json;
        }
    }
}
