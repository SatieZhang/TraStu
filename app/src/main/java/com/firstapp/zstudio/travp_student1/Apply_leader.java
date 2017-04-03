package com.firstapp.zstudio.travp_student1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2017/1/22.
 */

public class Apply_leader extends Activity {
    private ImageButton ib_apply_back;
    private LinearLayout ll_apply_student,ll_apply_online,ll_apply_student_data,ll_apply_online_data;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.leader_apply);
        getWindow().setFeatureInt(
                Window.FEATURE_CUSTOM_TITLE,
                R.layout.leader_apply_actionbar
        );
        ll_apply_student= (LinearLayout) findViewById(R.id.ll_apply_student);
        ll_apply_student_data= (LinearLayout) findViewById(R.id.ll_apply_student_data);
        ll_apply_online= (LinearLayout) findViewById(R.id.ll_apply_online);
        ll_apply_online_data= (LinearLayout) findViewById(R.id.ll_apply_online_data);
        ib_apply_back= (ImageButton) findViewById(R.id.ib_leader_apply_back);
        ib_apply_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ll_apply_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_next=new Intent();
                intent_next.setClass(Apply_leader.this, Apply_leader_student.class);
                startActivity(intent_next);
            }
        });

    }
}
