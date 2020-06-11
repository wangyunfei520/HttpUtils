package cn.wyf.httptest.application;


/**
 * @author linyt
 */

public class Resource {

    public static String getString(int resId) {
        return App.getIntstance().getString(resId);
    }
}
