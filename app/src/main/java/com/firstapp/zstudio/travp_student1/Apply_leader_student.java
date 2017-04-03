package com.firstapp.zstudio.travp_student1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

import me.nereo.multi_image_selector.MultiImageSelectorActivity;

/**
 * Created by Administrator on 2017/4/3.
 */

public class Apply_leader_student extends Activity {
    private EditText ed_firstname,ed_familyname,ed_passport;
    private ImageView iv_add_passport,iv_add_school,iv_passport,iv_school;
    private Button bt_next;
    private ArrayList<String> arrayList_path=new ArrayList<String>();


    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.leader_apply);
        getWindow().setFeatureInt(
                Window.FEATURE_CUSTOM_TITLE,
                R.layout.leader_apply_actionbar
        );
        ed_familyname= (EditText) findViewById(R.id.et_familyname);
        ed_firstname= (EditText) findViewById(R.id.et_firstname);
        ed_passport= (EditText) findViewById(R.id.et_passport);
        iv_add_passport= (ImageView) findViewById(R.id.iv_leader_apply_add_passport);
        iv_add_school= (ImageView) findViewById(R.id.iv_leader_apply_add_schoolprove);
        iv_passport= (ImageView) findViewById(R.id.iv_leader_apply_passport);
        iv_school= (ImageView) findViewById(R.id.iv_leader_apply_schoolprove);
        bt_next= (Button) findViewById(R.id.bt_leader_next);
        iv_add_passport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Apply_leader_student.this, MultiImageSelectorActivity.class);
// 是否显示调用相机拍照
                intent.putExtra(MultiImageSelectorActivity.EXTRA_SHOW_CAMERA, true);
// 最大图片选择数量
                intent.putExtra(MultiImageSelectorActivity.EXTRA_SELECT_COUNT, 1);
// 设置模式 (支持 单选/MultiImageSelectorActivity.MODE_SINGLE 或者 多选/MultiImageSelectorActivity.MODE_MULTI)
                intent.putExtra(MultiImageSelectorActivity.EXTRA_SELECT_MODE, MultiImageSelectorActivity.MODE_SINGLE);
// 默认选择图片,回填选项(支持String ArrayList)
                intent.putStringArrayListExtra(MultiImageSelectorActivity.EXTRA_DEFAULT_SELECTED_LIST, arrayList_path);
                startActivityForResult(intent,1);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
