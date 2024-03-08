package ntu22.appcong;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //gắn layout tương ứng với file
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    //xử lí bộ lắng nghe và onclick khi tính tổng
    public void Xulicong(View view){
        //Tìm và tham chiếu để dữ liệu trên tệp xml
        EditText editestsoA = findViewById(R.id.edtA);
        EditText editestsoB = findViewById(R.id.eddtB);
        EditText editestKetQua = findViewById(R.id.edtKQ);
        //lấy dữ liệu
        String strA = editestsoA.getText().toString();
        String strB = editestsoB.getText().toString();
       //chuyển chuỗi sang số
        int so_A = Integer.parseInt(strA);
        int so_B = Integer.parseInt(strB);
    }
}