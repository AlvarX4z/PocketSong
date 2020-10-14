package alfrasan.novatada.musicapitestjava;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public final class FragmentSongs extends Fragment {

    private Context context;

    public FragmentSongs(Context context) { this.context = context; }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_song, container, false);

        if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) ==
                PackageManager.PERMISSION_GRANTED) {

            thingsThisFragmentDoes(view);

        } else {

            requestPermissions(new String[] { Manifest.permission.READ_EXTERNAL_STORAGE }, 1);

            thingsThisFragmentDoes(view);

        }

        return view;

    }

    public void thingsThisFragmentDoes(View view) {

        // ArrayList<Song> songList = getSongsFromMusicDirectory(); // TODO Pending to fix the function
        ArrayList<Song> songList = new ArrayList<>();
        songList.add((new Song("Chlorine", "21 Pilots", "C:/")));

        final RecyclerView recyclerView = view.findViewById(R.id.recview_frag_song);

        final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        final RecyclerView.Adapter<RecyclerViewAdapterSong.ViewHolder> recViewAdapter =
                new RecyclerViewAdapterSong(context, songList);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recViewAdapter);

    }

    public ArrayList<Song> getSongsFromMusicDirectory() {

        ArrayList<Song> songsList = new ArrayList<>();

        /*File[] test = context.getExternalFilesDirs();
        for (File file : test) {
            if (file.isFile()) {
                songsList.add(new Song(file.getName(), file.getPath()));
            }
            Log.d("MUSIC FILE", (file.getName()));
            Log.d("MUSIC FILE", (file.getPath()));
            Log.d("MUSIC FILE", (file.getAbsolutePath()));
            Log.d("MUSIC FILE", (file.isFile() ? "FILE" : "NOT FILE"));
        }*/

        return songsList;

    }

}