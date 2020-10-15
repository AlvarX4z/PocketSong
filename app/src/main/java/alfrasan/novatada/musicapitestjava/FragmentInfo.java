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

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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

                    getJSONfromApiseedsAPI();


                } else { Toast.makeText(context, R.string.invalid_field, Toast.LENGTH_LONG).show(); }

            }

        });

        return view;

    }

    public void getJSONfromApiseedsAPI() {

        Retrofit retrofit;

        retrofit = new Retrofit.Builder().baseUrl(baseURL).addConverterFactory(GsonConverterFactory.create()).build();

        Test test = retrofit.create(Test.class);

        Call<FragmentInfo> call = test.find(songGroupURL, songNameURL);
        call.enqueue(new Callback<FragmentInfo>() {
            @Override
            public void onResponse(Call<FragmentInfo> call, Response<FragmentInfo> response) {
                Log.d("SUCCESS", response.code() + "");
            }

            @Override
            public void onFailure(Call<FragmentInfo> call, Throwable t) {
                Toast.makeText(context, "FAILURE RETRIEVING", Toast.LENGTH_LONG).show();
            }
        });

    }

}
