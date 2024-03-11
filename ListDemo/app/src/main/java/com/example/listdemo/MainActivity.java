package com.example.listdemo;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
        //Hiển thị dữ liệu trên list view

        //B1+:cần có dữ liệu
        ArrayList<String> dsTenTinhThanhVN;//khai bao
        dsTenTinhThanhVN = new ArrayList<String>();//tao the hien cu the
        dsTenTinhThanhVN.add("Hà Nội");
        dsTenTinhThanhVN.add("Thành Phố Hồ CHí Minh");
        dsTenTinhThanhVN.add("Nha Trang");
        dsTenTinhThanhVN.add("Phú Yên");
        dsTenTinhThanhVN.add("Cà Mau");
        //Buoc 2 tao Adapter
        ArrayAdapter<String> adapterTinhThanh;
        adapterTinhThanh = new ArrayAdapter<String>(this,
                                                            android.R.layout.simple_list_item_1
                                                            ,dsTenTinhThanhVN);
        //buoc 3 gan vao dieu khiien list view
        //3.1,Tim
        ListView lvTenTinhThanh = findViewById(R.id.lvDanhSachTT);
        //3.2 Gan
        lvTenTinhThanh.setAdapter(adapterTinhThanh);
    }
}