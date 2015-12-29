package cs492.kaist.org.helloworld;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by outtoin on 15. 12. 29..
 */
public class JSONParser {

    static InputStream is = null;
    static JSONObject jObj = null;
    static String json = "";

    // constructor
    public JSONParser() {

    }

    public JSONObject getJSONFromUrl(String url) {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(url).build();
            Response response = null;
            JSONObject jsonObject = null;
            String jsonData = "";
            try {
                response = client.newCall(request).execute();
                jsonData = response.body().string();

            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                jsonObject = new JSONObject(jsonData);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        return jsonObject;
    }
}