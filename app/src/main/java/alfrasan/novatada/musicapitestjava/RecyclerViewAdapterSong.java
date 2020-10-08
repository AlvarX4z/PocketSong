package alfrasan.novatada.musicapitestjava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public final class RecyclerViewAdapterSong extends RecyclerView.Adapter<RecyclerViewAdapterSong.ViewHolder> {

    private Context context;
    private ArrayList<Song> songList;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView songName;
        private TextView songGroup;
        private TextView songPath;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            songName = itemView.findViewById(R.id.item_txtView_songname);
            songGroup = itemView.findViewById(R.id.item_txtView_songgroup);
            songPath = itemView.findViewById(R.id.item_txtView_songpath);

        }

    }

    public RecyclerViewAdapterSong(Context context, ArrayList<Song> songList) {

        this.context = context;
        this.songList = songList;

    }

    @NonNull
    @Override
    public RecyclerViewAdapterSong.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_song_recyclerview, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterSong.ViewHolder holder, int position) {

        final int pos = position;

        holder.songName.setText(songList.get(pos).getName());
        holder.songGroup.setText(songList.get(pos).getGroup());
        holder.songPath.setText(songList.get(pos).getPath());
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                ActivityMain.currentSong.setPath(songList.get(pos).getPath());

            }

        });

    }

    @Override
    public int getItemCount() { return songList.size(); }

}
