package utils;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firstapp.zstudio.travp_student1.R;


public class TitleBuilder {

	private View viewTitle;
	private TextView tvTitle,tv_finish;
	private ImageView ivLeft;
	private ImageView ivRight;


	public TitleBuilder(Activity context) {
		viewTitle = context.findViewById(R.id.rl_arragement_titlebar);
		tvTitle = (TextView) viewTitle.findViewById(R.id.text_arragement_titlebar);
		ivLeft = (ImageView) viewTitle.findViewById(R.id.add_arragement_titlebar);
		ivRight = (ImageView) viewTitle.findViewById(R.id.edit_arragement_titlebar);
		tv_finish=(TextView) viewTitle.findViewById(R.id.tv_arragement_titlebar);

	}
	
	public TitleBuilder(View context) {
		viewTitle = context.findViewById(R.id.rl_arragement_titlebar);
		tvTitle = (TextView) viewTitle.findViewById(R.id.text_arragement_titlebar);
		ivLeft = (ImageView) viewTitle.findViewById(R.id.add_arragement_titlebar);
		ivRight = (ImageView) viewTitle.findViewById(R.id.edit_arragement_titlebar);
		tv_finish=(TextView) viewTitle.findViewById(R.id.tv_arragement_titlebar);

	}

	// title

	public TitleBuilder setTitleBgRes(int resid) {
		viewTitle.setBackgroundResource(resid);
		return this;
	}

	public TitleBuilder setTitleText(String text) {
		tvTitle.setVisibility(TextUtils.isEmpty(text) ? View.GONE
				: View.VISIBLE);
		tvTitle.setText(text);
		return this;
	}

	// left

	public TitleBuilder setLeftImage(int resId) {
		ivLeft.setVisibility(resId > 0 ? View.VISIBLE : View.GONE);
		ivLeft.setImageResource(resId);
		return this;
	}




	// right

	public TitleBuilder setRightImage(int resId) {
		ivRight.setVisibility(resId > 0 ? View.VISIBLE : View.GONE);
		ivRight.setImageResource(resId);
		return this;
	}

	public TitleBuilder setRightOnClickListener(View.OnClickListener listener) {
		if (ivRight.getVisibility() == View.VISIBLE) {
			ivRight.setOnClickListener(listener);
		}
		return this;
	}
	public TitleBuilder setLetfOnClickListener(View.OnClickListener listener) {
		if (ivLeft.getVisibility() == View.VISIBLE) {
			ivLeft.setOnClickListener(listener);
		}
		return this;
	}

public TitleBuilder setRightvisiblegone(Boolean isornot){
	if (isornot==true){
	ivRight.setVisibility(View.GONE);
	tv_finish.setVisibility(View.VISIBLE);}
	return this;

}
	public TitleBuilder setRightvisiblevisivible(Boolean isornot){
		if(isornot==true){
		ivRight.setVisibility(View.VISIBLE);
		tv_finish.setVisibility(View.GONE);}
		return this;

	}
	public TitleBuilder setLeftVisible(Boolean isornot){
		if(isornot==true){
			ivLeft.setVisibility(View.VISIBLE);
		}
		else if(isornot==false){
			ivLeft.setVisibility(View.GONE);
		}
		return this;
	}
	public TitleBuilder setRighttvOnclickListener(View.OnClickListener listener){
		if(tv_finish.getVisibility()==View.VISIBLE){
			tv_finish.setOnClickListener(listener);

		}

		return this;
	}



	public View build() {
		return viewTitle;
	}


}
