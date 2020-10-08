package alfrasan.novatada.musicapitestjava;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.ArrayList;

public final class FragmentSongs extends Fragment {

    private Context context;

    public FragmentSongs(Context context) { this.context = context; }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_song, container, false);

        // ----------- TESTING CODE FOR THE RECYCLERVIEW ------------

        ArrayList<Song> songList = getSongsFromMusicDirectory();
        /*
        Song song1 = new Song("", "Twenty-One Pilots", "C:/");
        Song song2 = new Song("Adam\'s Song", "blink-182", "Z:/");

        songList.add(song1);
        songList.add(song2);
        */
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

    public ArrayList<Song> getSongsFromMusicDirectory() {

        ArrayList<Song> songsList = new ArrayList<>();
        Log.d("ArrayList<Song>", "ArrayList<Song> Creado !!!");

        String absPath = "/storage/emulated/0/Music";
        File musicDirectory = new File(absPath);
        File[] musicFiles = musicDirectory.listFiles();


        Log.d("musicDirectory", musicDirectory.getPath());
        Log.d("musicDirectory", musicDirectory.getAbsolutePath());

        for (File file : musicFiles) {

            Log.d("ITEM", file.getPath());
            Log.d("ITEM", file.getName());
            Log.d("ITEM", file.getAbsolutePath());



            if (file.getPath().endsWith(".mp3")) {

                songsList.add(new Song(file.getName(), file.getPath()));

            }

        }

        return songsList;

    }

}