package com.su.aquaf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.su.aquaf.databinding.ActivityMainBinding;
import com.su.aquaf.ui.AboutFragment;
import com.su.aquaf.ui.ContactFragment;
import com.su.aquaf.ui.HomeFragment;
import com.su.aquaf.ui.PartnersFragment;
import com.su.aquaf.ui.QueryFragment;
import com.su.aquaf.ui.ServicesFragment;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding2;
    ImageView spinner;
    MenuBuilder menu_builder;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv4 = findViewById(R.id.topbar_tittle);
        spinner = findViewById(R.id.spinner_menu);

        menu_builder = new MenuBuilder(this);
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menu_setting, menu_builder);

        Fragment homefragment = new HomeFragment();
        openfragment(homefragment);

        spinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MenuPopupHelper optionMenu = new MenuPopupHelper(MainActivity.this,
                        menu_builder,view);
                optionMenu.setForceShowIcon(true);

                menu_builder.setCallback(new MenuBuilder.Callback() {
                    @Override
                    public boolean onMenuItemSelected(@NonNull MenuBuilder menu, @NonNull MenuItem item) {
                        switch (item.getItemId())
                        {
                            case R.id.nav_contact:
//                                Toast.makeText(MainActivity.this, "Clicked on Contact", Toast.LENGTH_SHORT).show();
                                Fragment contactfragment = new ContactFragment();
                                openfragment(contactfragment);
                                tv4.setText("Contact us");
                                break;
                            case R.id.nav_query:
//                                Toast.makeText(MainActivity.this, "Clicked on Contact", Toast.LENGTH_SHORT).show();
                                Fragment queryfragment = new QueryFragment();
                                openfragment(queryfragment);
                                tv4.setText("About Us");
                                break;
                        }
                        return false;
                    }

                    @Override
                    public void onMenuModeChange(@NonNull MenuBuilder menu) {

                    }
                });

                optionMenu.show();

            }
        });

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
//                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        Fragment homefragment = new HomeFragment();
                        openfragment(homefragment);
                        tv4.setText("Home");
                        return true;
                    case R.id.navigation_services:
//                        Toast.makeText(MainActivity.this, "Services", Toast.LENGTH_SHORT).show();
                        Fragment servicesfragment = new ServicesFragment();
                        openfragment(servicesfragment);
                        tv4.setText("Services");
                        return true;
                    case R.id.navigation_partners:
//                        Toast.makeText(MainActivity.this, "partners", Toast.LENGTH_SHORT).show();
                        Fragment navigationfragment = new PartnersFragment();
                        openfragment(navigationfragment);
                        tv4.setText("Partners");
                        return true;
                }
                return true;
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater  = getMenuInflater();

        return true;
    }

    public void openfragment (Fragment fragment){
        androidx.fragment.app.FragmentManager fm1 = getSupportFragmentManager();
        androidx.fragment.app.FragmentTransaction transaction1 = fm1.beginTransaction();
        transaction1.replace(R.id.fragment_container, fragment);
        transaction1.commit();
    }

}