package alfrasan.novatada.musicapitestjava;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public final class FragmentPlayer extends Fragment {

    private Context context;
    private MediaPlayer mediaPlayer;
    private Handler handler;
    private SeekBar seekBarDur;
    private UpdateSeekBar updateSeekBar;

    public FragmentPlayer(Context context) { this.context = context; }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_player, container, false);
        mediaPlayer = null;
        handler = new Handler();
        updateSeekBar = new UpdateSeekBar();

        final Button pauseBtn = view.findViewById(R.id.btn_fragplayer_pause);
        final Button playBtn = view.findViewById(R.id.btn_fragplayer_play);
        final Button stopBtn = view.findViewById(R.id.btn_fragplayer_stop);
        final TextView songName = view.findViewById(R.id.txt_fragplayer_songname);
        final TextView songGroup = view.findViewById(R.id.txt_fragplayer_songgroup);
        seekBarDur = view.findViewById(R.id.seekbar_fragplayer_duration);

        songName.setText(ActivityMain.currentSong.getName());
        songGroup.setText(ActivityMain.currentSong.getGroup());

        seekBarDur.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if (fromUser) { mediaPlayer.seekTo(progress); }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }

        });

        playBtn.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (mediaPlayer == null) {

                    mediaPlayer = MediaPlayer.create(context, R.raw.sample);
                    seekBarDur.setMax(mediaPlayer.getDuration());

                }

                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                    @Override
                    public void onCompletion(MediaPlayer mp) { stop(); }

                });

                mediaPlayer.start();

                handler.post(updateSeekBar);

            }

        });

        pauseBtn.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) { if (mediaPlayer != null) { mediaPlayer.pause(); } }

        });

        stopBtn.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (mediaPlayer != null) {

                    mediaPlayer.stop();
                    stop();

                }

            }

        });

        return view;

    }

    public void stop() {

        mediaPlayer.release();
        mediaPlayer = null;

    }

    public class UpdateSeekBar implements Runnable {

        @Override
        public void run() {

            try {

                seekBarDur.setProgress(mediaPlayer.getCurrentPosition());
                handler.postDelayed(this, 100);

            } catch (Exception e) { seekBarDur.setProgress(0);  }

        }

    }

}