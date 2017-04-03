package base;

import android.app.Application;

/**
 * Created by Administrator on 2016/12/4.
 */

public class BaseApplication extends Application {
    private String navigation_state,navi_delete,navi_all;
    private static BaseApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
    }

    public String getNavi_all() {
        return navi_all;
    }

    public String getNavi_delete() {
        return navi_delete;
    }

    public String getNavigation_state() {
        return navigation_state;
    }

    public void setNavi_all(String navi_all) {
        this.navi_all = navi_all;
    }

    public void setNavi_delete(String navi_delete) {
        this.navi_delete = navi_delete;
    }

    public void setNavigation_state(String navigation_state) {
        this.navigation_state = navigation_state;
    }

    public static BaseApplication getInstance() {
        return instance;
    }
}
