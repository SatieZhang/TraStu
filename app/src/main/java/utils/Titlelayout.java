package utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.firstapp.zstudio.travp_student1.Arragement_activity;
import com.firstapp.zstudio.travp_student1.R;

import data.Arragementdata;
import fragment.Frag_arragement;

import static base.Basedefine.backbt;
import static base.Basedefine.deletebt;

/**
 * Created by Administrator on 2016/11/21.
 */

public class Titlelayout extends RelativeLayout {
 private Intent mintent;
    private Bundle mbundle;
  private    ImageButton ib_back,ib_delete;
    private Arragementdata marragementdata;

    Arragement_activity arragement_activity;

    public Titlelayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.actionbar,this);

       ib_back = (ImageButton) findViewById(R.id.actionbar_back);
      ib_delete= (ImageButton) findViewById(R.id.actionbar_delete);


        ib_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                 arragement_activity=new Arragement_activity();

                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                intent.setClass(arragement_activity, Frag_arragement.class);
                bundle.putInt("backkey",backbt);
                intent.putExtras(bundle);
                getContext().startActivity(intent);
                Log.v("tag","back");
                ((Activity)getContext()).finish();

            }
        });
        ib_delete.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
//                marragementdata=arragement_activity.arragementdata;

                ((Activity)getContext()).finish();
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                bundle.putInt("backkey",deletebt);
                intent.putExtras(bundle);
                Log.v("tag","delete");

            }
        });
    }
}
