package ntu.anh_63133403.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class LandSscapeAdapter extends RecyclerView.Adapter<LandSscapeAdapter.ItemLandHoder> {
    Context context;
    ArrayList<LandScape> listData;

    public LandSscapeAdapter(Context context, ArrayList<LandScape> listData) {
        this.context = context;
        this.listData = listData;
    }

    @NonNull
    @Override
    public ItemLandHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater cai_bom = LayoutInflater.from(context);
        View vItem = cai_bom.inflate(R.layout.item_land,parent, false);
        ItemLandHoder viewholderCreate = new ItemLandHoder(vItem);
        return viewholderCreate;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemLandHoder holder, int position) {
        //lấy đối tượng hiển thị
        LandScape landScapeHienThi = listData.get(position);
        //Trích thông tin
        String caption = landScapeHienThi.getLandCation();
        String tenFileAnh = landScapeHienThi.getLandImageFilename();
        //đặt vapf các trường thông tin của hollder
        holder.tvCaption.setText(caption);
        //đặt ảnh
         String packageName = holder.itemView.getContext().getPackageName();
         int imageID = holder.itemView.getResources().getIdentifier(tenFileAnh, "mipmap", packageName);
        holder.ivLandscape.setImageResource(imageID);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class  ItemLandHoder extends  RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvCaption;
        ImageView ivLandscape;

        public ItemLandHoder(@NonNull View itemView) {
            super(itemView);
            tvCaption = itemView.findViewById(R.id.textViewCation);
            ivLandscape = itemView.findViewById(R.id.imageViewLand);
        }

        @Override
        public void onClick(View v) {
            int vitridcclick = getAdapterPosition();
            LandScape phantudcclick = listData.get(vitridcclick);
            //bóc thông tin
            String ten = phantudcclick.getLandCation();
            String tenFile = phantudcclick.getLandImageFilename();
            //thông báo
            String chuoithongbao = "Bạn vừa click vào " + ten;
            Toast.makeText(v.getContext(), chuoithongbao, Toast.LENGTH_SHORT);
        }
    }
}
