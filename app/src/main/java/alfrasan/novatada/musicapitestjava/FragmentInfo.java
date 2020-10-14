package alfrasan.novatada.musicapitestjava;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public final class FragmentInfo extends Fragment {

    private Context context;
    private String songNameURL;
    private String songGroupURL;
    private String resJSON = "";
    private final String clientAPI = "apikey=CXS5RvuDuOIy93tsBpSkthRS9CcxjeE5GDYNuCOz0pOAc9v70ImcUjg5EG5d1vHX";
    private final String baseURL = "https://orion.apiseeds.com/api/music/lyric/";

    public FragmentInfo(Context context) { this.context = context; }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_info, container, false);

        final EditText songName = view.findViewById(R.id.editText_song_name);
        final EditText songGroup = view.findViewById(R.id.editText_song_group);
        final Button btnSearch = view.findViewById(R.id.btn_fraginfo_search);

        btnSearch.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                if ((songName != null && songName.length() >= 1) && (songGroup != null && songGroup.length() >= 1)) {

                    songNameURL = songName.getText().toString() + "?";
                    songGroupURL = songGroup.getText().toString() + "/";

                    try {

                        getJSONfromApiseedsAPI();
                        Log.d("TESTING JSON AFTER FUNC", resJSON);

                    }
                    catch (IOException e) { e.printStackTrace(); }

                } else { Toast.makeText(context, R.string.invalid_field, Toast.LENGTH_LONG).show(); }

            }

        });

        return view;

    }

    public void getJSONfromApiseedsAPI() throws IOException {

        new Thread(new Runnable() {

            @Override
            public void run() {

                try {

                    Looper.prepare(); // ??

                    String urlString;
                    URL url;
                    HttpsURLConnection connection;
                    BufferedReader br;
                    Gson gson;

                    urlString = (baseURL + songGroupURL + songNameURL + clientAPI);
                    url = new URL(urlString);
                    connection = (HttpsURLConnection) url.openConnection();

                    connection.setRequestMethod("GET");
                    connection.connect();

                    if (connection.getResponseCode() != 200) {

                        Toast.makeText(context, Resources.getSystem().getString(R.string.connection_failed) + connection.getResponseCode(), Toast.LENGTH_LONG).show();

                    }



                    br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                    while (br.ready()) {

                        resJSON += br.readLine();

                    }

                    br.close();
                    Log.d("TEST JSON IN STRING", resJSON);
                    Toast.makeText(context, resJSON, Toast.LENGTH_LONG).show();

                    gson = new GsonBuilder().setPrettyPrinting().create();

                    Song testSong = gson.fromJson(resJSON, Song.class);

                    Looper.loop();

                } catch (Exception e) { e.printStackTrace(); }

            }

        }).start();

    }

}
