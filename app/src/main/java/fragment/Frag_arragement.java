package fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.firstapp.zstudio.travp_student1.Arragement_activity;
import com.firstapp.zstudio.travp_student1.Mainactivity;
import com.firstapp.zstudio.travp_student1.R;

import java.io.Serializable;
import java.util.ArrayList;

import adapter.arragement_adapter;
import base.BaseFragment;
import data.Arragementdata;
import utils.TitleBuilder;

import static android.app.Activity.RESULT_OK;
import static base.Basedefine.back_item;
import static base.Basedefine.back_new;
import static base.Basedefine.backbt;
import static base.Basedefine.cb_init;
import static base.Basedefine.delete;
import static base.Basedefine.deletebt;
import static base.Basedefine.fromitem;
import static base.Basedefine.fromnew;
import static base.Basedefine.origin;

/**
 * Created by Administrator on 2016/11/2.
 */

public class Frag_arragement extends BaseFragment{
    private View view;
    private Arragementdata ad,eg1,eg2;
    private ListView listview;
    private ArrayList<Arragementdata> list_delete=new ArrayList<Arragementdata>();
    private ArrayList<Arragementdata> listad;
    private arragement_adapter arragement_adapter1;
    int size,currentpostion;
    private TitleBuilder titleBuilder;

    private static final int NOSELECT_STATE = -1;
   public static int listview_size;
   Handler handler;







    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        view=View.inflate(activity, R.layout.frag_arragement,null);


        listview = (ListView) view.findViewById(R.id.lv);







        titleBuilder= new TitleBuilder(view)
                .setTitleText("行程")
                .setLeftImage(R.drawable.icon_add)
                .setRightImage(R.drawable.icon_edit)

                .setLetfOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        Intent intent1 = intent.setClass(getActivity(), Arragement_activity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("fromkey",fromnew);
                        intent1.putExtras(bundle);
//                        startActivity(intent1);
                        startActivityForResult(intent1,0);



                    }
                });


          eg1=new Arragementdata();
        eg2=new Arragementdata();
        listad=new ArrayList<Arragementdata>();

        arragement_adapter1=new arragement_adapter(activity,listad);
         boolean isMultiSelect = false;
        eg1.setDay("8");
        eg1.setPlace("w");
        eg1.setAmount("3");
        eg1.setT_year(2016);
        eg1.setT_month(8);
        eg1.setT_day(20);
        eg2.setDay("7");
        eg2.setPlace("q");
        eg2.setAmount("3");
        eg2.setT_year(2016);
        eg2.setT_month(8);
        eg2.setT_day(20);
        listad.add(eg1);
        listad.add(eg2);
        listview.setAdapter(arragement_adapter1);


        titleBuilder.setRightOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cb_init=true;
                titleBuilder.setLeftVisible(false);
                titleBuilder.setRightvisiblegone(true);
                Mainactivity.set_navigation_visible();
                arragement_adapter1.set_cb_visible();
               listview.setEnabled(false);
                arragement_adapter1.notifyDataSetChanged();
                Mainactivity.iv_all.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int list_true=0;

                        for(int i=0;i<listad.size();i++){
                            if(arragement_adapter.getIsSelected().get(i)==true){
                                list_true++;
                            }

                        }
                        if(list_true==listad.size()){
                            for(int i=0;i<listad.size();i++){
                                arragement_adapter.getIsSelected().put(i,false);
                            }
                        }
                        else {
                            for(int i=0;i<listad.size();i++){
                                arragement_adapter.getIsSelected().put(i,true);
                            }
                        }
                        arragement_adapter1.notifyDataSetChanged();
                    }
                });
                Mainactivity.iv_delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                                    Log.v("a","selected_0"+arragement_adapter1.isSelected.get(0));
//                                    Log.v("a","selected_1"+arragement_adapter1.isSelected.get(1));
                        for(int i=(listad.size()-1);i>=0;i--){

                                if(arragement_adapter.isSelected.get(i)==true){


                                    listad.remove(i);

                            }







                        }
                        for(int i=0;i<listad.size();i++){
                            arragement_adapter.getIsSelected().put(i,false);
                        }
                        arragement_adapter1.notifyDataSetChanged();

                    }
                });

                titleBuilder.setRighttvOnclickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        titleBuilder.setLeftVisible(true);
                        titleBuilder.setRightvisiblevisivible(true);
                        Mainactivity.set_navigation_gone();
                      arragement_adapter1.set_cb_gone();
                        listview.setEnabled(true);
                        cb_init=false;
                        list_delete.clear();
                        arragement_adapter1.notifyDataSetChanged();

                    }
                });
            }
        });




        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                Arragementdata itemdata= (Arragementdata) Frag_arragement.this.arragement_adapter1.getItem(position);
                Intent intent = new Intent();
                Intent intent1 = intent.setClass(getActivity(), Arragement_activity.class);
                Bundle  bundle=new Bundle();
                bundle.putInt("fromkey",fromitem);
                bundle.putSerializable("arragementdata1", (Serializable)itemdata);
                intent1.putExtras(bundle);
                startActivityForResult(intent1,0);
                currentpostion=position;

//                handler=new Handler();
//                handler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                       listad.remove(position);
//                        listview.setAdapter(arragement_adapter1);
//                    }
//                },3000);





            }
        });
        return view;
    }

    private void getarragementdata() {
            listad.add(ad);


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            ad= (Arragementdata) bundle.getSerializable("arragementdata");
            Arragementdata origindata= (Arragementdata) bundle.getSerializable("origindata");
            int a=bundle.getInt("backkey");
            int b=bundle.getInt("deleteororigrin");
            int c=bundle.getInt("backfrom");
            listview_size=listad.size();

            if (a==backbt){

                if(c==back_new){

                Log.v("tag","backbt");
            getarragementdata();
                arragement_adapter1.notifyDataSetChanged();}
                else if(c==back_item){

                    listad.set(currentpostion,ad);
                    arragement_adapter1.notifyDataSetChanged();


                }




            }
            else if(a==deletebt){
                if(b==origin){
                    listad.set(currentpostion,origindata);

                    Log.v("tag","origindata");
                    arragement_adapter1.notifyDataSetChanged();
                }
                if(b==delete){
                    arragement_adapter1.notifyDataSetChanged();
                }

            }
           arragement_adapter1.notifyDataSetChanged();


        }







    }


}




