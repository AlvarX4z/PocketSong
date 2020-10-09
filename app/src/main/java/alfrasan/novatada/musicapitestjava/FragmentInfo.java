package alfrasan.novatada.musicapitestjava;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public final class FragmentInfo extends Fragment {

    private Context context;

    public FragmentInfo(Context context) { this.context = context; }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_main, container, false);

    }

}
