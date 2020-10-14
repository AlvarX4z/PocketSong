package alfrasan.novatada.musicapitestjava;

import android.content.Context;
import android.os.Bundle;
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

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public final class FragmentInfo extends Fragment {

    private Context context;
    private String songNameURL;
    private String songGroupURL;
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

                    songNameURL = songName.getText().toString() + "/";
                    songGroupURL = songGroup.getText().toString() + "?";

                    try {

                        String infoJSON = getJSONfromApiseedsAPI();

                    }
                    catch (IOException e) { e.printStackTrace(); }

                } else { Toast.makeText(context, R.string.invalid_field, Toast.LENGTH_LONG).show(); }

            }

        });

        return view;

    }

    public String getJSONfromApiseedsAPI() throws IOException {

        String urlString, resJSON;
        URL url;
        HttpsURLConnection connection;
        InputStreamReader isr;
        Gson gson;

        urlString = (baseURL + songNameURL + songGroupURL + clientAPI).replace(" ", "%20");
        url = new URL(urlString);
        connection = (HttpsURLConnection)url.openConnection();

        connection.setRequestMethod("GET");
        connection.connect();

        if (connection.getResponseCode() != 200) {

            Toast.makeText(context, R.string.connection_failed + connection.getResponseCode(), Toast.LENGTH_LONG).show();

        }

        isr = new InputStreamReader(connection.getInputStream());
        gson = new GsonBuilder().setPrettyPrinting().create();

        resJSON = gson.fromJson(isr, String.class);
        Log.d("TEST", resJSON);

        return resJSON;

    }

}
