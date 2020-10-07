package alfrasan.novatada.musicapitestjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class ActivityMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ----------- TESTING CODE FOR THE RECYCLERVIEW ------------
        Song song1 = new Song("aaaaaa", "bbbbbb", "C:/");
        Song song2 = new Song("bbbbbbb", "DDDDDDDD", "Z:/");
        ArrayList<Song> songList = new ArrayList<>();
        songList.add(song1);
        songList.add(song2);
        // ----------- END OF TESTING CODE FOR THE RECYCLERVIEW ------------

        final RecyclerView recyclerView = new RecyclerView(this);

        final TabLayout tabLayout = findViewById(R.id.tab_layout_main);
        recyclerView.findViewById(R.id.recview_frag_song);

        final FragmentManager fragMag = getSupportFragmentManager();
        final LayoutManager layoutManager = new LinearLayoutManager(this);
        final Adapter<RecyclerViewAdapterSong.ViewHolder> recyclerViewAdapterSong = new RecyclerViewAdapterSong(this, songList);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerViewAdapterSong);

        Toast.makeText(ActivityMain.this, R.string.thanks_app, Toast.LENGTH_SHORT).show();

        // ------------------------ EVENTS ------------------------
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                FragmentTransaction fragTransaction = fragMag.beginTransaction();

                switch (tab.getPosition()) {

                    case 0:
                        fragTransaction.replace(R.id.frag_layout_main, new FragmentHome());
                        break;

                    case 1:
                        fragTransaction.replace(R.id.frag_layout_main, new FragmentSongs());
                        break;

                    case 2: // TODO Add the third Fragment when created
                    case 3: // TODO Add the fourth Fragment when created

                }

                fragTransaction.commit();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) { }

            @Override
            public void onTabReselected(TabLayout.Tab tab) { }

        });

    }

}