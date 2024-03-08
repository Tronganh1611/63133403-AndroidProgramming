package anh.mylyrics;

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
        ListView lvBaiHat;
        //Buoc 2
        ArrayList<String> dsBH;
        dsBH = new ArrayList<String>();
        dsBH.add("Tip toe");
        dsBH.add("Dancing with my phone");
        dsBH.add("telescope");
        //Buoc 3
        ArrayAdapter<String> adapterBH;
        adapterBH = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                dsBH);
        //buoc 4
        lvBaiHat = findViewById(R.id.lv);
        lvBaiHat.setAdapter((adapterBH));
        //buoc 5 xu li sựu kiện
        lvBaiHat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //code xu li o day vidu
                String chuoiThongBao = "ban chon 1 bai"+dsBH.get(position);
                Toast.makeText(MainActivity.this,chuoiThongBao,Toast.LENGTH_SHORT).show();
            }
        });
    }
}