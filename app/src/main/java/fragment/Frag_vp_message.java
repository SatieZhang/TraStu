package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firstapp.zstudio.travp_student1.R;

import base.BaseFragment;

/**
 * Created by Administrator on 2016/12/12.
 */

public class Frag_vp_message extends BaseFragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=View.inflate(activity, R.layout.vp_message,null);





        return view;
    }
}
