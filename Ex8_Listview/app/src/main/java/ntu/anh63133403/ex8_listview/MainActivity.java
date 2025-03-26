package ntu.anh63133403.ex8_listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvNNLT;
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
        lvNNLT = findViewById(R.id.lv);

        //chuan bi du lieu
        ArrayList<String> dsNNLT = new ArrayList<String>();
        dsNNLT.add("C++");
        dsNNLT.add("Java");
        dsNNLT.add("Python");
        dsNNLT.add("C#");
        dsNNLT.add("PHP");
        dsNNLT.add("Javascript");
        //B2
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dsNNLT);
        //B3
        lvNNLT.setAdapter(adapter);
        //b4: gan BLN
        lvNNLT.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Ban chon: " + dsNNLT.get(i), Toast.LENGTH_SHORT).show();
            }
        });

    }
}