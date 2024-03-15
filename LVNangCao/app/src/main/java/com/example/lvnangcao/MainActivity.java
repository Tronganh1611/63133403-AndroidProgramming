package com.example.lvnangcao;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lvnangcao.adapters.CountryAdapter;
import com.example.lvnangcao.models.Country;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Country> dsQG = new ArrayList<Country>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
            //b1:Danh Sach Quoc Gia
        });

        dsQG = new ArrayList<Country>();
        dsQG.add(new Country("VietNam",90,"vn"));
        dsQG.add(new Country("My",110,"my"));
        dsQG.add(new Country("Nga",90,"nga"));
        ListView listView = findViewById(R.id.lvQG);
        CountryAdapter adapter = new CountryAdapter(dsQG,this);
        listView.setAdapter(adapter);
    }
}