package BuiTrongAnh.baikt1;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
    public void login (View view){
        //Tim va tham chieu du lieu
        EditText str = findViewById(R.id.edt);
        EditText str1 = findViewById(R.id.edt1);
        String text1 = str.getText().toString();
        String text2 = str1.getText().toString();
        if ((text1.equals("BuiTrongAnh"))&&(text2.equals("12345"))) {
            Toast.makeText(this, "User and Password is correct", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "User and Password is wrong", Toast.LENGTH_SHORT).show();
        }

    }
}