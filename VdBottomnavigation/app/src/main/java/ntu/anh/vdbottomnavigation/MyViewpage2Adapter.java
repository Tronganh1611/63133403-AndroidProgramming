package ntu.anh.vdbottomnavigation;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyViewpage2Adapter extends FragmentStateAdapter {
    public MyViewpage2Adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new Cal_Fragment();
            case 1:
                return new Music_Fragment();
            case 2:
                return new Profile_Fragment();
            default:
                return new Profile_Fragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
