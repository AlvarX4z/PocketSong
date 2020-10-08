package alfrasan.novatada.musicapitestjava;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public final class FragmentPlayer extends Fragment {

    private Context context;
    private Song song;

    public FragmentPlayer(Context context, Song song) {

        this.context = context;
        this.song = song;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Toast.makeText(context, song.getPath(), Toast.LENGTH_SHORT).show();
        return inflater.inflate(R.layout.fragment_player, container, false);

    }

}