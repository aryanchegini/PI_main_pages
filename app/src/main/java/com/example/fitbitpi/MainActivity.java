package com.example.fitbitpi;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.bottomNavigationView);
        navView.setOnNavigationItemSelectedListener(item -> {
            Fragment fragment = null;
            int id = item.getItemId();

            if (id == R.id.analysis) {
                fragment = new AnalysisFragment();
            } else if (id == R.id.calendar) {
                fragment = new CalendarFragment();
            } else if (id == R.id.account) {
                fragment = new AccountFragment();
            } else {
                return false;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.outerConstraintLayout, fragment).commit();
            return true;
        });
    }
}

