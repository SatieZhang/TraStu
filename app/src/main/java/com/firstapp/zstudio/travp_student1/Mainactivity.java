package com.firstapp.zstudio.travp_student1;

import android.widget.RadioGroup;


import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.HashMap;

import fragment.FragmentController;

import static adapter.arragement_adapter.isSelected;
import static base.Basedefine.cb_init;

/**
 * Created by Administrator on 2016/10/31.
 */

public class Mainactivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener,View.OnClickListener {
    private static RadioGroup rg_tab;

    public  static ImageView iv_all,iv_delete;
    private fragment.FragmentController controlloer;
    private ListView listView;
    private static LinearLayout ll_navigation;



    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        controlloer= FragmentController.getInstance(this,R.id.fl_content);
        controlloer.showFragment(0);
        isSelected = new HashMap<Integer, Boolean>();
        intiView();





    }

    private void intiView() {

        rg_tab= (RadioGroup) findViewById(R.id.rg_tab);

        iv_all= (ImageView) findViewById(R.id.iv_navi_all);
        iv_delete= (ImageView) findViewById(R.id.iv_navi_delete);
        ll_navigation= (LinearLayout) findViewById(R.id.ll_navigation);
        rg_tab.setOnCheckedChangeListener(this);
        cb_init=false;

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {


            default:
                break;
        }

    }


    public static  void   set_navigation_visible(){
        ll_navigation.setVisibility(View.VISIBLE);
        rg_tab.setVisibility(View.GONE);

    }


    public static  void set_navigation_gone(){
        ll_navigation.setVisibility(View.GONE);
        rg_tab.setVisibility(View.VISIBLE);

    }
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_aragement:
                controlloer.showFragment(0);
                break;
            case R.id.rb_serve:
                controlloer.showFragment(1);
                break;
            case R.id.rb_message:
                controlloer.showFragment(2);
                break;
            case R.id.rb_order:
                controlloer.showFragment(3);
                break;
            case R.id.rb_me:
                controlloer.showFragment(4);
                break;
        }
    }
}
