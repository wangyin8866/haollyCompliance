package com.haolyy.compliance.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;

import com.haolyy.compliance.R;

public class SystemBarUtil {


    /**
     * 自定义状态栏
     * @param context
     */
    public static void setSystemBar(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true,context);
            SystemBarTintManager tintManager = new SystemBarTintManager((Activity)context);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintResource(R.color.white);//通知栏所需颜色
        }
    }

    /**
     * 自定义状态栏
     * @param context
     */
    public static void setSystemBar(Context context,int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true,context);
            SystemBarTintManager tintManager = new SystemBarTintManager((Activity)context);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintResource(color);//通知栏所需颜色
        }
    }

    /**设置状态栏属性
     * @param on
     */
    private static void setTranslucentStatus(boolean on,Context context) {
        Window win = ((Activity)context).getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

}
