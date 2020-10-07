package alfrasan.novatada.musicapitestjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class ActivityMain extends AppCompatActivity {

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TabLayout tabLayout = findViewById(R.id.tab_layout_main);

        final FragmentManager fragMag = getSupportFragmentManager();

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
                        fragTransaction.replace(R.id.frag_layout_main, new FragmentSongs(context));
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