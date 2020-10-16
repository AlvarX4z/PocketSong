package alfrasan.novatada.musicapitestjava;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import alfrasan.novatada.musicapitestjava.Classes.SongAPI;
import alfrasan.novatada.musicapitestjava.Interfaces.CallLyricsAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class FragmentInfo extends Fragment {

    private final Context context;
    private String songNameURL;
    private String songGroupURL;
    private SongAPI lyrics;

    public FragmentInfo(Context context) { this.context = context; }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_info, container, false);

        final EditText songName = view.findViewById(R.id.editText_song_name);
        final EditText songGroup = view.findViewById(R.id.editText_song_group);
        final Button btnSearch = view.findViewById(R.id.btn_fraginfo_search);

        btnSearch.setOnClickListener(v -> {

            if ((songName != null && songName.length() >= 1) && (songGroup != null && songGroup.length() >= 1)) {

                songNameURL = songName.getText().toString();
                songGroupURL = songGroup.getText().toString();

                getJSONfromApiseedsAPI();


            } else { Toast.makeText(context, R.string.invalid_field, Toast.LENGTH_LONG).show(); }

        });

        return view;

    }

    public void getJSONfromApiseedsAPI() {

        Gson gson = new GsonBuilder().setLenient().create();
        String baseURL = "https://orion.apiseeds.com/api/music/lyric/";
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseURL).addConverterFactory(GsonConverterFactory.create(gson)).build();
        CallLyricsAPI test = retrofit.create(CallLyricsAPI.class);
        Call<SongAPI> call = test.loadLyrics(songGroupURL, songNameURL);

        call.enqueue(new Callback<SongAPI>() {

            @Override
            public void onResponse(Call<SongAPI> call, Response<SongAPI> response) {

                if (response.isSuccessful()) {

                    lyrics = new SongAPI();
                    lyrics.setResult(response.body().getResult());

                    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
                    dialogBuilder.setTitle(songGroupURL + " - " + songNameURL);
                    dialogBuilder.setMessage(lyrics.getResult().getTrack().getText())
                            .setPositiveButton(R.string.btn_search_back, (dialog, id) -> dialog.dismiss());
                    dialogBuilder.create();
                    dialogBuilder.show();

                } else { Toast.makeText(context, R.string.api_error_response, Toast.LENGTH_SHORT).show(); }

            }

            @Override
            public void onFailure(Call<SongAPI> call, Throwable t) {

                Toast.makeText(context, R.string.api_error_response, Toast.LENGTH_SHORT).show();
                call.cancel();

            }

        });

    }

}
