package alfrasan.novatada.musicapitestjava;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FragmentSongs extends Fragment {

    private Context context;

    public FragmentSongs(Context context) { this.context = context; }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_song, container, false);

        // ----------- TESTING CODE FOR THE RECYCLERVIEW ------------

        Song song1 = new Song("Chlorine", "Twenty-One Pilots", "C:/");
        Song song2 = new Song("What's My Age Again", "blink-182", "Z:/");
        ArrayList<Song> songList = new ArrayList<>();
        songList.add(song1);
        songList.add(song2);

        // ----------- END OF TESTING CODE FOR THE RECYCLERVIEW ------------

        final RecyclerView recyclerView = view.findViewById(R.id.recview_frag_song);

        final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        final RecyclerView.Adapter<RecyclerViewAdapterSong.ViewHolder> recViewAdapter =
                new RecyclerViewAdapterSong(context, songList);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recViewAdapter);

        return view;

    }

}