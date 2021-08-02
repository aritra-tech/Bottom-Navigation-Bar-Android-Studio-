package com.example.navigationbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class MainActivity extends AppCompatActivity {
    
    ChipNavigationBar chipNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        chipNavigationBar = findViewById(R.id.nav_menu);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeScreenFragment()).commit();
        bottommenu();
    }

    private void bottommenu() {

        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment =null;
                switch (i){
                    case R.id.nav_home:
                        fragment = new HomeScreenFragment();
                        break;
                    case R.id.nav_notification:
                        fragment = new NotificationScreenFragment();
                        break;
                    case R.id.nav_cart:
                        fragment = new CartScreenFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
            }
        });
    }
}