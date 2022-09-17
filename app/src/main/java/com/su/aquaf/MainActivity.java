package com.su.aquaf;

import android.app.FragmentManager;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.su.aquaf.databinding.ActivityMainBinding;
import com.su.aquaf.ui.HomeFragment;
import com.su.aquaf.ui.PartnersFragment;
import com.su.aquaf.ui.ServicesFragment;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    RelativeLayout topb;
//    HomeFragment homeFragment;
//    ServicesFragment servicesFragment;
//    PartnersFragment partnersFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView tv = (TextView) findViewById(R.id.topbar_tittle2);
        tv.setText("Blah: ");
          // for refreshment

        Fragment homeFragment = new HomeFragment();
        openFragment(homeFragment);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.navView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){

                case R.id.navigation_home:
                    tv.append("Home");
                    Fragment home2Fragment = new HomeFragment();
                    openFragment(home2Fragment);
                    break;
                case R.id.navigation_services:
                    tv.setText("Services");
                    Fragment serviceFragment = new ServicesFragment();
                    openFragment(serviceFragment);
                    break;
                case R.id.navigation_partners:
                    tv.setText("Partners");
                    Fragment partnersFragment = new PartnersFragment();
                    openFragment(partnersFragment);
                    break;
            }

            return true;
        });

    }

    public void openFragment(Fragment fragment) {
//        tittle_text.setText("Home");
        androidx.fragment.app.FragmentManager fm1 = getSupportFragmentManager();
        androidx.fragment.app.FragmentTransaction transaction1 = fm1.beginTransaction();
        transaction1.replace(R.id.fragment_container, fragment);
        transaction1.commit();
    }

}