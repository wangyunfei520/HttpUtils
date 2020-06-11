package cn.wyf.httptest.application;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import net.wyf.library.utils.Utils;
import net.wyf.library.utils.log.XLogger;
import net.wyf.library.utils.sp.Xsp;

import java.util.ArrayList;
import java.util.List;

import cn.wyf.httptest.BuildConfig;
import cn.wyf.httptest.SpeekUtilOffline;
import cn.wyf.httptest.di.modules.RequestHelper;


public class App extends Application {
    private List<Activity> activityList;//用于存放所有启动的Activity的集合
    private static App appContext;

    public static App getIntstance() {
        return appContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
        activityList = new ArrayList<>();
        initPlugins(this);
    }


    private void initPlugins(Context context) {
        Utils.init(context);//初始化
        XLogger.init(BuildConfig.DEBUG);//初始化日志打印
        Xsp.getInstance().init();//初始化sharedPreferences存储
        RequestHelper.getInstance().init(context, BuildConfig.DEBUG);//初始化网络请求
        SpeekUtilOffline.getInstance();//初始化云之声
    }


    /**
     * 添加Activity
     */
    public void addActivity(Activity activity) {
        // 判断当前集合中不存在该Activity
        if (!activityList.contains(activity)) {
            activityList.add(activity);//把当前Activity添加到集合中
        }
    }

    /**
     * 销毁单个Activity
     */
    public void removeActivity(Activity activity) {
        //判断当前集合中存在该Activity
        if (activityList.contains(activity)) {
            activityList.remove(activity);//从集合中移除
            activity.finish();//销毁当前Activity
        }
    }

    /**
     * 销毁所有的Activity
     */
    public void removeALLActivity() {
        //通过循环，把集合中的所有Activity销毁
        for (Activity activity : activityList) {
            activity.finish();
        }
    }
}
