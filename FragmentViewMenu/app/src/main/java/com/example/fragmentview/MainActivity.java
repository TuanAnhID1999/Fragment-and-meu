package com.example.fragmentview;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = findViewById(R.id.menu_navigion);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.navigion_frag, new FragmentHome()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selecFragment = null;

                    switch (menuItem.getItemId()) {
                        case R.id.search:
                            selecFragment = new FragmentSearch();
                            break;
                        case R.id.favorites:
                            selecFragment = new FragmentFavorites();
                            break;
                        case R.id.home_fragment:
                            selecFragment = new FragmentHome();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.navigion_frag, selecFragment).commit();
                    return true;
                }


            };
}
