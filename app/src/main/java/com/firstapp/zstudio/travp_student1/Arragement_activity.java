package com.firstapp.zstudio.travp_student1;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.Serializable;
import java.util.Calendar;

import data.Arragementdata;
import utils.Titlelayout;

import static base.Basedefine.back_item;
import static base.Basedefine.back_new;
import static base.Basedefine.backbt;
import static base.Basedefine.delete;
import static base.Basedefine.deletebt;
import static base.Basedefine.fromitem;
import static base.Basedefine.fromnew;
import static base.Basedefine.origin;

/**
 * Created by Administrator on 2016/11/10.
 */

public class Arragement_activity extends Activity {
    View view;
    private EditText et_time, et_place;
    private EditText tv_day, tv_amount;
    private Button bt_turn;
    private Titlelayout titlelayout;
    private ImageButton add_amount, add_day, decrease_amount, decrease_day,ab_back,ab_delete;
    public Arragementdata arragementdata;
    public Intent intent;
    public  Bundle bundle;
    int amount = 3;
    int day = 7;
    public Mytextwatcher mytextwatcher1;
    public  Mytextwatcher mytextwatcher2;
    public Message msg;
    private int category;
    private static Arragementdata data_receive;
    private static String receive_place;
   private  static int ca_year,ca_month,ca_day;
  private Calendar cal;
     String time1;
    String place1;
    String day1;
    String amount1;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */




















public class Mytextwatcher1 implements TextWatcher{

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
                 setdata();
        }
    }



public class Mytextwatcher implements TextWatcher {
       private int watchdata;


        public  Mytextwatcher(int watchdata){
            this.watchdata=watchdata;

        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if(s.toString().isEmpty())
                return;
            oberserve();

            watchdata= Integer.parseInt(s.toString());
              setdata();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.arragement_main);
        getWindow().setFeatureInt(
                Window.FEATURE_CUSTOM_TITLE,
                R.layout.actionbar
        );



       ab_back= (ImageButton) findViewById(R.id.actionbar_back);
        ab_delete= (ImageButton) findViewById(R.id.actionbar_delete);
        et_time = (EditText) findViewById(R.id.et_time);
        et_place = (EditText) findViewById(R.id.et_place);
        tv_day = (EditText) findViewById(R.id.tv_day);
        tv_amount = (EditText) findViewById(R.id.tv_amount);
        bt_turn = (Button) findViewById(R.id.turn2search);
        add_day = (ImageButton) findViewById(R.id.add_day);
        add_amount = (ImageButton) findViewById(R.id.add_amount);
        decrease_amount = (ImageButton) findViewById(R.id.decrease_amount);
        decrease_day = (ImageButton) findViewById(R.id.decrease_day);
        cal=Calendar.getInstance();
        ca_year=cal.get(Calendar.YEAR);
        ca_month=cal.get(Calendar.MONTH);
        ca_day=cal.get(Calendar.DAY_OF_MONTH);
        initdata();
        receivedata();



//        inittitlebar();


      mytextwatcher1= new Mytextwatcher(day);
        mytextwatcher2=new Mytextwatcher(amount);
        et_place.addTextChangedListener(new Mytextwatcher1());
        et_time.addTextChangedListener(new Mytextwatcher1());
        tv_day.addTextChangedListener(mytextwatcher1);
        tv_amount.addTextChangedListener(mytextwatcher2);

//          intent = this.getIntent();
//           bundle = new Bundle();

        ab_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(category==fromnew){
                intent=new Intent();
                bundle=new Bundle();
                bundle.putInt("backkey",backbt);
                    bundle.putInt("backfrom",back_new);
                bundle.putSerializable("arragementdata", (Serializable) arragementdata);
                intent.putExtras(bundle);
                setResult(RESULT_OK,intent);

                   finish();
            }
            else if(category==fromitem){

                    intent=new Intent();
                    bundle=new Bundle();
                    bundle.putInt("backkey",backbt);
                    bundle.putInt("backfrom",back_item);
                    bundle.putSerializable("arragementdata", (Serializable) arragementdata);
                    intent.putExtras(bundle);
                    setResult(RESULT_OK,intent);

                    finish();


                }


            }
        });


        ab_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(category==fromitem){
                    Intent intent=new Intent();
                    Bundle bundledelete=new Bundle();
                    bundledelete.putInt("deleteororigrin",origin);
                    bundledelete.putInt("backkey",deletebt);
                    data_receive.setPlace(receive_place);
                    data_receive.setT_day(ca_day);
                    data_receive.setT_month(ca_month);
                    data_receive.setT_year(ca_year);
                    bundledelete.putSerializable("origindata",(Serializable) data_receive);
                    intent.putExtras(bundledelete);
                    setResult(RESULT_OK,intent);
                }
                else if(category==fromnew){

                    Intent intent=new Intent();
                    Bundle bundledelete=new Bundle();
                    bundledelete.putInt("deleteororigrin",delete);
                    bundledelete.putInt("backkey",deletebt);
                    intent.putExtras(bundledelete);
                    setResult(RESULT_OK,intent);
                }


                   finish();
            }
        });




        bt_turn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oberserve();
                oberserve_text();
            }
        });

        add_day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                day=Integer.parseInt(tv_day.getText().toString());
                day++;
                tv_day.setText(day+"");
                tv_day.clearFocus();
            }
        });
        decrease_day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                day=Integer.parseInt(tv_day.getText().toString());
                day--;
                tv_day.setText(day+"");
                tv_day.clearFocus();
            }
        });
        add_amount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amount=Integer.parseInt(tv_amount.getText().toString());
                amount++;
                tv_amount.setText(amount+"");
                tv_amount.clearFocus();

            }
        });
        decrease_amount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amount=Integer.parseInt(tv_amount.getText().toString());
                amount--;
                tv_amount.setText(amount+"");
                tv_amount.clearFocus();

            }
        });



       et_time.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               new DatePickerDialog(Arragement_activity.this, new DatePickerDialog.OnDateSetListener() {
                   @Override
                   public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                       arragementdata.setT_year(year);
                       arragementdata.setT_month(month);
                       arragementdata.setT_day(dayOfMonth);
                       arragementdata.setTime_go(""+year+"-"+month+"-"+dayOfMonth);
                       et_time.setText(arragementdata.getTime_go());

                   }
               },ca_year,ca_month,ca_day).show();
           }
       });



    }

    private void receivedata() {
        Bundle bundle = this.getIntent().getExtras();
        int i=bundle.getInt("fromkey");

        if(i==fromitem){
            Log.v("tag","Ok");
            category=fromitem;
        arragementdata= (Arragementdata) bundle.getSerializable("arragementdata1");
            data_receive=arragementdata;
            receive_place=data_receive.getPlace();
            ca_day=data_receive.getT_day();
            ca_year=data_receive.getT_year();
            ca_month=data_receive.getT_month();

        tv_day.setText(arragementdata.getDay());
        tv_amount.setText(arragementdata.getAmount());
        et_place.setText(arragementdata.getPlace());
        et_time.setText(arragementdata.getTime_go());

        }
        else if(i== fromnew){
            category=fromnew;

        }

    }

    private void oberserve_text() {
        if(et_time.getText().toString()==null){
            Toast toast=Toast.makeText(this,"出发时间不能为空",Toast.LENGTH_SHORT);
            toast.show();
        }
        if(et_place.getText().toString()==null){
            Toast toast=Toast.makeText(this,"地点不能为空",Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    private void oberserve() {
        if(Integer.parseInt(tv_amount.getText().toString())<=0){
            Toast toast=Toast.makeText(this,"人数不能小于0",Toast.LENGTH_SHORT);
            toast.show();
        }
        if(Integer.parseInt(tv_day.getText().toString())<=0){
            Toast toast=Toast.makeText(this,"天数不能小于0",Toast.LENGTH_SHORT);
            toast.show();
        }

    }


    private void setdata() {
        day1= tv_day.getText().toString();
        amount1= tv_amount.getText().toString();
        place1=et_place.getText().toString();
        time1=et_time.getText().toString();
        arragementdata.setAmount(amount1);
        arragementdata.setDay(day1);
        arragementdata.setPlace(place1);
        arragementdata.setTime_go(time1);



    }

    private void initdata() {
        arragementdata = new Arragementdata();

    }
//public void transdata(){
//   intent=this.getIntent();
//    bundle=new Bundle();
//
//    bundle.putSerializable("arragementdata", (Serializable) arragementdata);
//    intent.putExtras(bundle);
//    Log.v("tag","transdata");
//   setResult(RESULT_OK,intent);
//
//
//}

}
