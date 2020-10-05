package alfrasan.novatada.musicapitestjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AppCompatActivity activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnSongs = findViewById(R.id.btn_frag_songs);
        final Button btnSearch = findViewById(R.id.btn_frag_search);

        final FragmentManager fragMag = getSupportFragmentManager();
        final FragmentTransaction fragTransaction = fragMag.beginTransaction();

        Toast.makeText(activity, R.string.thanks_app, Toast.LENGTH_SHORT).show();

        btnSongs.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Fragment fragSongs = new SongFragment();
                fragTransaction.replace(R.id.frag_main, fragSongs);
                fragTransaction.addToBackStack(null);
                fragTransaction.commit();
                btnSongs.setVisibility(View.GONE);
                btnSearch.setVisibility(View.GONE);

            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Fragment fragSearch;
                btnSongs.setVisibility(View.GONE);
                btnSearch.setVisibility(View.GONE);

            }
        });

    }

}