package com.example.lvnangcao.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lvnangcao.R;
import com.example.lvnangcao.models.Country;

import java.util.ArrayList;

public class CountryAdapter extends BaseAdapter {
    //Nguon Du Lieu Adapter nay
    ArrayList<Country> listQG;
    //Context Hoat Dong
    Context mcontext;
    LayoutInflater mInflater;
    public CountryAdapter(ArrayList<Country> listQG, Context mcontext) {
        this.listQG = listQG;
        this.mcontext = mcontext;
        mInflater = LayoutInflater.from(mcontext);
    }

    //layout

    @Override
    public int getCount() {
        return listQG.size();
    }

    @Override
    public Object getItem(int position) {
        return listQG.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CountryViewHolder viewItem;
        if (convertView == null){
            convertView = mInflater.inflate(R.layout.country_item,null);
            viewItem = new CountryViewHolder();
            viewItem.textViewNationName  = convertView.findViewById(R.id.tvTenQG);
            viewItem.textViewPopulation  = convertView.findViewById(R.id.tvSoLuongDan);
            viewItem.imageViewFlag  = convertView.findViewById(R.id.imLaCo);
            convertView.setTag(viewItem);
        }
       else
        {
            viewItem = (CountryViewHolder) convertView.getTag();
        }
       //đặt dữ liệu lên view
       Country quocGiaHienThi = listQG.get(position);
       String tenQG = quocGiaHienThi.getTenQG();
       int soDan = quocGiaHienThi.getSoLuongDan();
       String tenLaCo = quocGiaHienThi.getTenFileAnhLaCo();
       viewItem.textViewNationName.setText(tenQG);
       viewItem.textViewPopulation.setText(String.valueOf(soDan));
       ///Tim id file anh o day
        int idAnhlaCo = TimIDAnhTheoTenFile(tenLaCo);
        viewItem.imageViewFlag.setImageResource(idAnhlaCo);
        return convertView;
    }
    public  int TimIDAnhTheoTenFile(String tenFileAnh){
        String tenPak = mcontext.getPackageName();
        int id = mcontext.getResources().
                getIdentifier(
                        tenFileAnh,"mipmap",tenPak
                );
        return id;
    }
    static class  CountryViewHolder{
        ImageView imageViewFlag;
        TextView textViewNationName;
        TextView textViewPopulation;
    }

}
