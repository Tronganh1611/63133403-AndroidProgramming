package com.example.listdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> dsTenTinhThanhVN;//khai bao
    ArrayAdapter<String> adapterTinhThanh;
    //khai bao nut
    Button nut= findViewById(R.id.btn);
    Button nut1= findViewById(R.id.btn1);
    Button nut2= findViewById(R.id.btn3);
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

        dsTenTinhThanhVN = new ArrayList<String>();//tao the hien cu the
        dsTenTinhThanhVN.add("Hà Nội");
        dsTenTinhThanhVN.add("Thành Phố Hồ CHí Minh");
        dsTenTinhThanhVN.add("Nha Trang");
        dsTenTinhThanhVN.add("Phú Yên");
        dsTenTinhThanhVN.add("Cà Mau");
        //Buoc 2 tao Adapter
        adapterTinhThanh = new ArrayAdapter<String>(this,
                                                            android.R.layout.simple_list_item_1
                                                            ,dsTenTinhThanhVN);
        //buoc 3 gan vao dieu khiien list view
        //3.1,Tim
        ListView lvTenTinhThanh = findViewById(R.id.lvDanhSachTT);
        //3.2 Gan
        lvTenTinhThanh.setAdapter(adapterTinhThanh);
        //3.3 gan bo lang nghe
        lvTenTinhThanh.setOnItemClickListener(BoLangNghevaXL);
        nut.setOnClickListener(Them);
        nut1.setOnClickListener(Xoa);
        nut2.setOnClickListener(Sua);
    }
    //Tao bo lang nghe va xu li su kien Onclick
    //Vd:BolangNgheVaXL
    AdapterView.OnItemClickListener BoLangNghevaXL = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //i la vi tri phan tu vua click
            //hien thong bao vi tri khi chon
            String strTEnTinhTHhanh = dsTenTinhThanhVN.get(position);
            Toast.makeText(MainActivity.this,strTEnTinhTHhanh , Toast.LENGTH_SHORT).show();
        }
    };
    View.OnClickListener Them = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EditText strTP = findViewById(R.id.edt);

            String Ten = strTP.getText().toString();
            if (!Ten.isEmpty()){
                dsTenTinhThanhVN.add(Ten);
                adapterTinhThanh.notifyDataSetChanged();
            }else{
                Toast.makeText(MainActivity.this, "Tên chưa được nhập mời bạn nhập lại ", Toast.LENGTH_SHORT).show();
            }
        }
    };
    View.OnClickListener Xoa = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EditText strTP = findViewById(R.id.edt);
            String Ten = strTP.getText().toString();
            if (!Ten.isEmpty() && dsTenTinhThanhVN.contains(Ten)){
                dsTenTinhThanhVN.remove(Ten);
                adapterTinhThanh.notifyDataSetChanged();
            }else{
                Toast.makeText(MainActivity.this, "Tên không tồn tại trong danh sách, mời bạn nhập lại ", Toast.LENGTH_SHORT).show();
            }
        }
    };

    View.OnClickListener Sua = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EditText strTP = findViewById(R.id.edt);
            EditText strTPNew = findViewById(R.id.edtNew);
            String Ten = strTP.getText().toString();
            String TenMoi = strTPNew.getText().toString();
            if (!Ten.isEmpty() && dsTenTinhThanhVN.contains(Ten)){
                int vt = dsTenTinhThanhVN.indexOf(Ten);
                dsTenTinhThanhVN.set(vt, TenMoi);
                adapterTinhThanh.notifyDataSetChanged();
            }else{
                Toast.makeText(MainActivity.this, "Tên không tồn tại trong danh sách, mời bạn nhập lại ", Toast.LENGTH_SHORT).show();
            }
        }
    };


}