package net.wyf.library.utils;

import android.content.Context;

import com.google.gson.Gson;

/**
 *   Utils初始化相关
 */
public final class Utils {

    private static Context context;

    private Utils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 初始化工具类
     *
     * @param context 上下文
     */
    public static void init(Context context) {
        Utils.context = context.getApplicationContext();
    }

    /**
     * 获取ApplicationContext
     *
     * @return ApplicationContext
     */
    public static Context getContext() {
        if (context != null) return context;
        throw new NullPointerException("u should init first");
    }

    /**
     * 实体类转为json
     * @param obj
     * @return
     */
    public static String objTojson(Object obj){
        return new Gson().toJson(obj);
    }

    /**
     * json转为实体类
     * @param json
     * @return
     */
    public static Object jsonToobj(String json,Class c){
        return new Gson().fromJson(json,c);
    }
}