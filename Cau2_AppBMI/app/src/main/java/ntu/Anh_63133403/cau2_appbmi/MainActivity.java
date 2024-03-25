package ntu.Anh_63133403.cau2_appbmi;

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
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void BMI(View view){

        EditText H = findViewById(R.id.edt1);
        EditText W = findViewById(R.id.edt2);
        EditText editestKetQua = findViewById(R.id.edtKQ);
        EditText editestNX = findViewById(R.id.edtNX);

        String strA = H.getText().toString();
        String strB = W.getText().toString();

        int so_W = Integer.parseInt(strB);
        double so_H = Double.parseDouble(strA);
        //tính BMI
        double BMI = so_W/(so_H*so_H);
        String nhanXet;
        if (BMI < 18.5) {
            nhanXet = "Bạn thiếu cân.";
        } else if (BMI >= 18.5 && BMI < 24.9) {
            nhanXet = "Bạn khỏe mạnh!";
        } else if (BMI >= 25 && BMI < 29.9) {
            nhanXet = "Bạn thừa cân.";
        } else {
            nhanXet = "Bạn béo phì.";
        }

        String strkq = String.valueOf(BMI);
        //hiện ra màn hình
        editestKetQua.setText(strkq);
        editestNX.setText(nhanXet);
    }
}