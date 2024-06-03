package ntu.anh.vdbottomnavigation;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.ClipData;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ReportFragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new Cal_Fragment()).commit();
        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);

        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int Id = menuItem.getItemId();
                if (Id == R.id.cal){
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new Cal_Fragment()).commit();
                    return  true;
                }if (Id == R.id.pro){
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new Profile_Fragment()).commit();
                    return  true;
                }
                if (Id == R.id.music){
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new Music_Fragment()).commit();
                    return  true;
                }

                return  false;
            }
        });
    }
}