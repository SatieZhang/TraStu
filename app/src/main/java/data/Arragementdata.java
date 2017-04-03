package data;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/11/10.
 */

public class Arragementdata implements Serializable {
    private String place,time_go,time_back;
    private String day;
    private String amount;
    private int id;
    private int t_year,t_month,t_day;
    public boolean check;

    public void setT_day(int t_day) {
        this.t_day = t_day;
    }

    public void setT_month(int t_month) {
        this.t_month = t_month;
    }

    public void setT_year(int t_year) {
        this.t_year = t_year;
    }

    public int getT_day() {
        return t_day;
    }

    public int getT_month() {
        return t_month;
    }

    public int getT_year() {
        return t_year;
    }

    public String getTime_back() {
        return time_back;
    }

    public String getTime_go() {
        return time_go;
    }

    public void setTime_back(String time_back) {
        this.time_back = time_back;
    }

    public void setTime_go(String time_go) {
        this.time_go = time_go;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setPlace(String place) {
        this.place = place;
    }



    public String getAmount() {
        return amount;
    }

    public String getDay() {
        return day;
    }

    public String getPlace() {
        return place;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
