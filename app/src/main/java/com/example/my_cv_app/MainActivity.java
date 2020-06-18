package com.example.my_cv_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.my_cv_app.about.AboutFragment;
import com.example.my_cv_app.expirience.ExperienceFragment;
import com.example.my_cv_app.project.ProjectFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private final long BACK_PRESSED_INTERVAL = 2000;
    private long backPressedTime;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_about:
                    replaceFragment( AboutFragment.newInstance(), AboutFragment.TAG );
                    return true;
                case R.id.navigation_experience:
                    replaceFragment( ExperienceFragment.newInstance(), ExperienceFragment.TAG );
                    return true;
                case R.id.navigation_projects:
                    replaceFragment( ProjectFragment.newInstance(), ProjectFragment.TAG );
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        BottomNavigationView navigation = findViewById( R.id.navigation );
        navigation.setOnNavigationItemSelectedListener( mOnNavigationItemSelectedListener );
        navigation.setSelectedItemId( 0 );
        replaceFragment( AboutFragment.newInstance(), AboutFragment.TAG );
    }

    @Override
    public void onBackPressed() {
        if (backPressedTime + BACK_PRESSED_INTERVAL > System.currentTimeMillis())
            super.onBackPressed();
        else
            Toast.makeText( getBaseContext(), R.string.press_back_again, Toast.LENGTH_SHORT ).show();
        backPressedTime = System.currentTimeMillis();
    }

    private void replaceFragment(Fragment fragment, String TAG) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace( R.id.content, fragment, TAG )
                .commit();
    }

}
