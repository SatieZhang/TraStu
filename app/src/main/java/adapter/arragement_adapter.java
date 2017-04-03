package adapter;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.firstapp.zstudio.travp_student1.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import data.Arragementdata;
import utils.HTQDragGridView;
import utils.ListItemDelete;

import static base.Basedefine.cb_init;

/**
 * Created by Administrator on 2016/11/10.
 */

public class arragement_adapter extends BaseAdapter implements HTQDragGridView.DragGridBaseAdapter {
    public   static ListItemDelete itemDelete=null;
    private List<Arragementdata> datas;
    public static ArrayList<Arragementdata> listad_delete=new ArrayList<Arragementdata>();
    private final Activity aty;
    private int currentHidePosition = -1;
    private Date date,date_back;
    private String st_back;
 private   ViewHolder holder;
    public static HashMap<Integer, Boolean> isSelected;
    private static  boolean cb_visi=false;

    private boolean dataChange = false;

    public arragement_adapter(Activity aty, List<Arragementdata> datas) {
        super();
//         isSelected=new HashMap<Integer, Boolean>();
        this.datas = datas;
        this.aty = aty;
//        isSelected = new HashMap<Integer, Boolean>();


    }

  public Date getDateAfter(Date date, int n) {
      Calendar now = Calendar.getInstance();
      now.setTime(date);
      now.set(Calendar.DATE, now.get(Calendar.DATE) + n);
      return now.getTime();
  }




    @Override
    public int getCount() {


            return datas.size();

}

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public List<Arragementdata> getDatas() {
        return datas;
    }

    public boolean getDataChange() {
        return dataChange;
    }

    @Override
    public void reorderItems(int oldPosition, int newPosition) {

    }

    @Override
    public void setHideItem(int hidePosition) {

    }






  public   static class ViewHolder {
        TextView tv_go, tv_arrive, tv_place, tv_amount;
        ImageView iv_place;
        ImageButton iv_trump;
    CheckBox cb_arragement;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        datas.get(position).setId(position);
         final Arragementdata data = datas.get(position);

        holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(aty, R.layout.listview_arragement, null);
            holder.tv_amount = (TextView) convertView.findViewById(R.id.tv_listview_amount);
            holder.tv_go = (TextView) convertView.findViewById(R.id.tv_listview_go);
            holder.tv_arrive = (TextView) convertView.findViewById(R.id.tv_listview_arrive);
            holder.tv_place = (TextView) convertView.findViewById(R.id.tv_listview_place);
            holder.cb_arragement= (CheckBox) convertView.findViewById(R.id.cb_arragement);
            holder.iv_place= (ImageView) convertView.findViewById(R.id.iv_place);
            convertView.setTag(holder);
//            holder.cb_arragement.setChecked(getIsSelected().get(position));

        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        DateFormat fmt=new SimpleDateFormat("yyyy-MM-dd");
        String a= data.getT_year()+"-"+data.getT_month()+"-"+data.getT_day();
        try {
            date=fmt.parse(a);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        date=java.sql.Date.valueOf(a);

        Log.v("a","setChecked");
        date_back=getDateAfter(date,Integer.parseInt(data.getDay()));
        st_back=fmt.format(date_back);
        holder.tv_amount.setText(" "+data.getAmount());
        holder.tv_place.setText(" "+data.getPlace());
        holder.tv_go.setText(" "+data.getTime_go());
        holder.tv_arrive.setText(st_back);
        initdata();



        holder.cb_arragement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isSelected.get(position)) {
                    isSelected.put(position, false);
                    setIsSelected(isSelected);
                    Log.v("a", String.valueOf((getIsSelected().get(position)))+position);
                } else {
                    isSelected.put(position, true);
                    setIsSelected(isSelected);
                    Log.v("a", String.valueOf((getIsSelected().get(position)))+position);
                }


            }
        });

        if(cb_visi==false){
            holder.iv_place.setVisibility(View.VISIBLE);
            holder.cb_arragement.setVisibility(View.GONE);
        }
          else  if(cb_visi==true){
            holder.iv_place.setVisibility(View.GONE);
            holder.cb_arragement.setVisibility(View.VISIBLE);

        }

        holder.cb_arragement.setChecked(getIsSelected().get(position));

        return convertView;
    }

    public static HashMap<Integer, Boolean> getIsSelected() {
        return isSelected;
    }

    public static void setIsSelected(HashMap<Integer, Boolean> isSelected) {
        arragement_adapter.isSelected = isSelected;
    }

    private void initdata() {

        if(cb_init==false){
        for (int i = 0; i < datas.size(); i++) {
//            getIsSelected().put(i, false);
            getIsSelected().put(i, false);
        }}
    }

    public void set_cb_visible(){

           cb_visi=true;

    }
    public void set_cb_gone(){
       cb_visi=false;

    }

    public static void ItemDeleteReset() {
        if (itemDelete != null) {
            itemDelete.reSet();
        }
    }



//    @Override
//    public boolean isEnabled(int position) {
//        return false;
//    }
}
