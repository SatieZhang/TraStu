package fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.firstapp.zstudio.travp_student1.R;

import java.util.ArrayList;

import base.BaseFragment;


/**
 * Created by Administrator on 2016/11/2.
 */

public class Frag_message extends BaseFragment {
    Resources resources;
    private ViewPager mPager;
    private ArrayList<Fragment> fragmentsList;
    private ImageView ivBottomLine;
    private TextView tvTab_message, tvTab_chat;
    private int currIndex = 0;
    private int bottomLineWidth;
    private int offset = 0;
    private int position_one;
    public final static int num = 2 ;
    Fragment frag_vp_message;
    Fragment frag_vp_chat;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        view=View.inflate(activity, R.layout.frag_message,null);
        resources=getResources();
        InitWidth(view);
        InitTextView(view);
        InitViewPager(view);

        TranslateAnimation animation = new TranslateAnimation(position_one, offset, 0, 0);
        animation.setFillAfter(true);
        animation.setDuration(300);
        ivBottomLine.startAnimation(animation);


        return view;
}

    private void InitViewPager(View view) {
        mPager= (ViewPager) view.findViewById(R.id.vp_message);
        fragmentsList=new ArrayList<Fragment>();
        frag_vp_message=new Frag_vp_message();
        frag_vp_chat=new Frag_vp_chat();
        fragmentsList.add(frag_vp_message);
        fragmentsList.add(frag_vp_chat);
        mPager.setAdapter(new MyFragmentPagerAdapter(getChildFragmentManager(), fragmentsList));
        mPager.setOnPageChangeListener(new MyOnPageChangeListener());
        mPager.setCurrentItem(0);

    }

    private void InitTextView(View viewp) {

        tvTab_message= (TextView) viewp.findViewById(R.id.tv_tab_message);
        tvTab_chat= (TextView) viewp.findViewById(R.id.tv_tab_chat);
        tvTab_message.setOnClickListener(new MyOnclicklistener(0));
        tvTab_chat.setOnClickListener(new MyOnclicklistener(1));

    }

    private void InitWidth(View view) {
        ivBottomLine = (ImageView) view.findViewById(R.id.iv_bottom_line);
        bottomLineWidth = ivBottomLine.getLayoutParams().width;
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;
        offset = (int) ((screenW / num - bottomLineWidth) / 2);
        int avg = (int) (screenW / num);
        position_one = avg + offset;


    }

    private class MyOnclicklistener implements View.OnClickListener {
        private  int index=0;
        public MyOnclicklistener(int i) {
            index=i;
        }

        @Override
        public void onClick(View v) {
            mPager.setCurrentItem(index);

        }
    }

    private class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {


        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            Animation animation = null;
            switch (position) {
                case 0:
                    if (currIndex == 1) {
                        animation = new TranslateAnimation(position_one, offset, 0, 0);
                        tvTab_chat.setTextColor(resources.getColor(R.color.txt_black));
                    }
                    tvTab_message.setTextColor(resources.getColor(R.color.orange));
                    break;
                case 1:
                    if (currIndex == 0) {
                        animation = new TranslateAnimation(offset, position_one, 0, 0);
                        tvTab_message.setTextColor(resources.getColor(R.color.txt_black));
                    }
                    tvTab_chat.setTextColor(resources.getColor(R.color.orange));
                    break;
            }
            currIndex = position;
            animation.setFillAfter(true);
            animation.setDuration(300);
            ivBottomLine.startAnimation(animation);

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
