package fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.firstapp.zstudio.travp_student1.Apply_leader;
import com.firstapp.zstudio.travp_student1.R;

import base.BaseFragment;

/**
 * Created by Administrator on 2016/11/2.
 */

public class Frag_me extends BaseFragment{
    private View view;
    private LinearLayout ll_me_edit,ll_me_order,ll_me_collection,ll_me_apply,ll_me_setting,ll_me_suggestion;
    private ImageView iv_me_user;
    private TextView tv_me_user;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        view=View.inflate(activity, R.layout.frag_me,null);
        ll_me_edit= (LinearLayout) view.findViewById(R.id.ll_me_edit);
        ll_me_order= (LinearLayout) view.findViewById(R.id.ll_me_all_order);
        ll_me_collection= (LinearLayout) view.findViewById(R.id.ll_me_all_collcetion);
        ll_me_apply= (LinearLayout) view.findViewById(R.id.ll_me_apply);
        ll_me_setting= (LinearLayout) view.findViewById(R.id.ll_me_all_setting);
        ll_me_suggestion= (LinearLayout) view.findViewById(R.id.ll_me_suggestion);
        iv_me_user= (ImageView) view.findViewById(R.id.iv_me_user);
        tv_me_user= (TextView) view.findViewById(R.id.tv_me_username);
        ll_me_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_apply=new Intent();
                intent_apply.setClass(getActivity(), Apply_leader.class);
                startActivity(intent_apply);
            }
        });









        return view;
    }
}
