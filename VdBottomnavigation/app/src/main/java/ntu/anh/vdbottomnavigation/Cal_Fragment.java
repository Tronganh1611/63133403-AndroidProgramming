package ntu.anh.vdbottomnavigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Cal_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Cal_Fragment extends Fragment {


    public Cal_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Cal_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Cal_Fragment newInstance(String param1, String param2) {
        Cal_Fragment fragment = new Cal_Fragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_cal_, container, false);
        EditText editestsoA = view.findViewById(R.id.edtA);
        EditText editestsoB = view.findViewById(R.id.eddtB);
        EditText editestKetQua = view.findViewById(R.id.edtKQ);
        Button btnCong = view.findViewById(R.id.btncong);
        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //lấy dữ liệu
                String strA = editestsoA.getText().toString();
                String strB = editestsoB.getText().toString();
                //chuyển chuỗi sang số
                int so_A = Integer.parseInt(strA);
                int so_B = Integer.parseInt(strB);
                //tính tổng
                int tong = so_A + so_B;
                String strkq = String.valueOf(tong);
                //hiện ra màn hình
                editestKetQua.setText(strkq);
            }
        });
        return  view;
    }

}