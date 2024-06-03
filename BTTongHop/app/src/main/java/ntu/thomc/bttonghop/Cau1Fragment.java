package ntu.thomc.bttonghop;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Cau1Fragment extends Fragment {
    public Cau1Fragment() {
        // Required empty public constructor
    }
//
    public static Cau1Fragment newInstance(String param1, String param2) {
        Cau1Fragment fragment = new Cau1Fragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    Button buttonCong;
    EditText editTextSo1,  editTextSo2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_cau1, container, false);
        buttonCong = view.findViewById(R.id.btnTinhTong);
        editTextSo1 = view.findViewById(R.id.editTextSoA);
        editTextSo2 = view.findViewById(R.id.editTextSoB);
        buttonCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   float so1 =Float.parseFloat(editTextSo1.getText().toString());
                   float so2 =Float.parseFloat(editTextSo2.getText().toString());
                    float tong=so1+so2;
                    TextView textViewKQ = view.findViewById(R.id.textViewKetQua);
                    textViewKQ.setText(String.valueOf(tong));
            }
        });
        return view;
    }
}