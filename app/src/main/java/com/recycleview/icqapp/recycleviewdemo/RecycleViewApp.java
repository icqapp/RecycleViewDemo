package com.recycleview.icqapp.recycleviewdemo;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.Iterator;
import java.util.List;

/**
 * Created by icqapp on 16/5/15.
 */
public class RecycleViewApp extends Application{
    public static RecycleViewApp appContext;

    public static RecycleViewApp getInstance() {
        if (appContext == null) {
            appContext = new RecycleViewApp();
        }
        return appContext;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        boolean applicationRepeat = isApplicationRepeat(this);
        if (applicationRepeat) {
            return;
        }
        Fresco.initialize(this);
    }

    /**
     * 判断程序是否重复启动
     */
    public static boolean isApplicationRepeat(Context applicationContext) {
        int pid = android.os.Process.myPid();
        String processName = null;
        ActivityManager am = (ActivityManager) applicationContext.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> l = am.getRunningAppProcesses();
        Iterator<ActivityManager.RunningAppProcessInfo> i = l.iterator();
        // PackageManager pm = applicationContext.getPackageManager();
        while (i.hasNext()) {
            ActivityManager.RunningAppProcessInfo info = i.next();
            try {
                if (info.pid == pid) {
                    processName = info.processName;
                }
            } catch (Exception e) {
            }
        }
        return processName == null || !processName.equalsIgnoreCase(applicationContext.getPackageName());
    }
}
