package ntu.anh.vdbottomnavigation;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Music_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Music_Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Music_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Mucsic_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Music_Fragment newInstance(String param1, String param2) {
        Music_Fragment fragment = new Music_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
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
        View view=inflater.inflate(R.layout.fragment_music_, container, false);
        ListView lvBaiHat;
        //Buoc 2
        ArrayList<String> dsBH;
        dsBH = new ArrayList<String>();
        dsBH.add("Tip toe");
        dsBH.add("Dancing with my phone");
        dsBH.add("telescope");
        //Buoc 3
        ArrayAdapter adapter = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_list_item_1, dsBH);
        //buoc 4
        lvBaiHat = view.findViewById(R.id.lv);
        lvBaiHat.setAdapter(adapter);
        //buoc 5 xu li sựu kiện
        lvBaiHat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //code xu li o day vidu
                String chuoiThongBao = "ban chon 1 bai"+dsBH.get(position);
                Toast.makeText(view.getContext(), chuoiThongBao,Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
        // Inflate the layout for this fragment

}