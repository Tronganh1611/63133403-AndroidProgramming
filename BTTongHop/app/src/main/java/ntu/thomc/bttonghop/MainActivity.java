package ntu.thomc.bttonghop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Default Fragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new WelcomeFragment())
                .commit();

        BottomNavigationView bottomNav  = findViewById(R.id.bottomNavigationView);
        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                int itemId = item.getItemId();
                if (itemId == R.id.navigation_welcome) {
                    selectedFragment = new WelcomeFragment();
                }else if (itemId == R.id.navigation_cau1) {
                    selectedFragment = new Cau1Fragment();
                } else if (itemId == R.id.navigation_cau2) {
                    selectedFragment = new Cau2Fragment();
                } else if (itemId == R.id.navigation_cau3) {
                    selectedFragment = new Cau3Fragment();
                }
                else if (itemId == R.id.navigation_cau4) {
                    selectedFragment = new Cau4Fragment();
                }
                // It will help to replace the
                // one fragment to other.
                if (selectedFragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                }
                return true;
            }
        });
    }
}