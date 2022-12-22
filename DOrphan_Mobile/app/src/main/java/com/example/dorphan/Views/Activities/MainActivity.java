package com.example.dorphan.Views.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;

import com.example.dorphan.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private NavHostFragment navFragmentMainMenu;
    private NavController navController;
    private Toolbar toolbar;

    //    public void onClick_function(View v) {
//        Navigation.findNavController(v).navigate(R.id.action_kursusFragment_to_detailKursusFragment);
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        navFragmentMainMenu = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_fragment_main_menu);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AppBarConfiguration configuration = new AppBarConfiguration.Builder(R.id.findSkillFragment, R.id.courseOrderTabFragment).build();
        navController = navFragmentMainMenu.getNavController();
        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            if (destination.getId() == R.id.loginFragment
                    || destination.getId() == R.id.registerFragment) {
                getSupportActionBar().hide();
                bottomNavigationView.setVisibility(View.GONE);
            } else {
                getSupportActionBar().show();
                bottomNavigationView.setVisibility(View.VISIBLE);
            }
        });

        NavigationUI.setupActionBarWithNavController(MainActivity.this, navController, configuration);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        navController = navFragmentMainMenu.getNavController();
        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        return navFragmentMainMenu.getNavController().navigateUp() || super.onSupportNavigateUp();
    }

}
