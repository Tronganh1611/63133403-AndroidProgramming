package ntu.anh_63133403.recycleview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LandSscapeAdapter landSscapeAdapter;
    ArrayList<LandScape> recycleViewData;
    RecyclerView recyclerViewLandscape;
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
        //3
        recycleViewData = getDataRecycleView();
        //4
        recyclerViewLandscape = findViewById((R.id.recyclerLand));
        //5
//        RecyclerView.LayoutManager layoutLinear = new LinearLayoutManager(this);
//        recyclerViewLandscape.setLayoutManager(layoutLinear);
//        RecyclerView.LayoutManager layoutLinearHorizonal = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
//        recyclerViewLandscape.setLayoutManager(layoutLinearHorizonal);
        RecyclerView.LayoutManager layoutGrid = new GridLayoutManager(this,2);
        recyclerViewLandscape.setLayoutManager(layoutGrid);
        //6
        landSscapeAdapter = new LandSscapeAdapter(this, recycleViewData);
        //7
        recyclerViewLandscape.setAdapter(landSscapeAdapter);
    }
    ArrayList<LandScape> getDataRecycleView(){
        ArrayList<LandScape> dsDuLieu = new ArrayList<LandScape>();
        LandScape landScape = new LandScape("vn","Việt Nam");
        dsDuLieu.add(landScape);
        dsDuLieu.add(new LandScape("my","Mỹ"));
        dsDuLieu.add(new LandScape("nga","Nga"));
        return  dsDuLieu;
    }
}