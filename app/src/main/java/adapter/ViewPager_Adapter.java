package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import fragment.Frag_vp_chat;
import fragment.Frag_vp_message;

/**
 * Created by Administrator on 2016/12/12.
 */

public class ViewPager_Adapter extends FragmentPagerAdapter {
    public static final int Fragment_Index_0=0;
    public static final int Fragment_Index_1=1;

    public ViewPager_Adapter(FragmentManager fm) {

        super(fm);


    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
        switch (position){
            case Fragment_Index_0:
                fragment=new Frag_vp_message();
                break;
            case Fragment_Index_1:
                fragment=new Frag_vp_chat();
                break;

        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
