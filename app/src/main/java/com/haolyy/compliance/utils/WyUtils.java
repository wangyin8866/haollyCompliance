package com.haolyy.compliance.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.design.widget.TabLayout;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import com.haolyy.compliance.base.ActivityCollector;
import com.haolyy.compliance.R;
import com.haolyy.compliance.custom.XListView;
import com.haolyy.compliance.ui.MainActivity;
import com.haolyy.compliance.custom.dialog.WithDrawPopupWindow;

import java.lang.reflect.Field;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by wangyin on 2017/5/23.
 */

public class WyUtils {

    //手机号码正则0
    private static String phoneRex = "^1\\d{10}";
    //密码正则
    private static String passRex = "^(?!^\\d+$)(?!^[a-zA-Z]+$)(?!^[\\-\\/:;()$&@\"\\.,\\?\\!'\\[\\]#%\\^\\*\\+=_\\\\\\|~<>€£¥•：；（）¥@“”。，、？！【】｛｝—《》\\·]+$)[\\da-zA-Z\\-\\/:;()$&@\"\\.,\\?\\!'\\[\\]#%\\^\\*\\+=_\\\\\\|~<>€£¥•：；（）¥@“”。，、？！【】｛｝—《》\\·]{6,20}$";
    //身份证正则
    private static String idRex = "(\\d{14}[0-9a-zA-Z])|(\\d{17}[0-9a-zA-Z])";
    //银行卡正则
    private static String cardRex = "^\\d{16,19}$";
    // 汉字
    private static String chn_characters = "([\\u4e00-\\u9fa5]{2,10})";
    // F码
    private static String fma = "^[a-zA-Z0-9]{6}$";//    /(?!^[0-9]*$)(?!^[a-zA-Z]*$)^([a-zA-Z0-9]{2,})$/


    public static boolean checkPhone(String phone) {
        return phone.matches(phoneRex);
    }

    public static boolean checkPass(String password) {
        return password.matches(passRex);
    }

    public static boolean checkId(String id) {
        return id.matches(idRex);
    }

    public static boolean checkCard(String card) {
        return card.matches(cardRex);
    }

    public static boolean checkChnCharacters(String chnCharacters) {
        return chnCharacters.matches(chn_characters);
    }

    public static boolean checkFm(String fm) {
        return fm.matches(fma);
    }

    public static void onLoad(XListView xListView) {
        xListView.stopRefresh();
        xListView.stopLoadMore();
        xListView.setRefreshTime(new SimpleDateFormat("HH:mm:ss", Locale.CHINA).format(new Date()));
    }

    /**
     * 2      * 判断当前应用是否是debug状态
     * 3
     */
    public static boolean isApkInDebug(Context context) {
        try {
            ApplicationInfo info = context.getApplicationInfo();
            return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 修改tabLayoutIndicator长度
     */
    public static void setIndicator(Context context, TabLayout tabs, int leftDip, int rightDip) {
        Class<?> tabLayout = tabs.getClass();
        Field tabStrip = null;
        try {
            tabStrip = tabLayout.getDeclaredField("mTabStrip");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        tabStrip.setAccessible(true);
        LinearLayout ll_tab = null;
        try {
            ll_tab = (LinearLayout) tabStrip.get(tabs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        int left = (int) (getDisplayMetrics(context).density * UIUtils.dp2px(leftDip, context));
        int right = (int) (getDisplayMetrics(context).density * UIUtils.dp2px(rightDip, context));

        for (int i = 0; i < ll_tab.getChildCount(); i++) {
            View child = ll_tab.getChildAt(i);
            child.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            params.leftMargin = left;
            params.rightMargin = right;
            child.setLayoutParams(params);
            child.invalidate();
        }
    }

    private static DisplayMetrics getDisplayMetrics(Context context) {
        DisplayMetrics metric = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(metric);
        return metric;
    }
    /**
     * 投资期限
     */
    public static String getInvestDeadline(int num) {
        String result = "";
        switch (num) {
            case 1:
                result = "天";
                break;
            case 2:
                result = "周";
                break;
            case 3:
                result = "个月";
                break;
            case 4:
                result = "年";
                break;
        }
        return result;

    }


    /**
     * 保留两位小数 不进行四舍五入
     */
    public static String getTwoNumStr(double num) {
//        DecimalFormat df = new DecimalFormat("######0.00");
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setGroupingSize(0);
        df.setRoundingMode(RoundingMode.FLOOR);
        return df.format(num);

    }

    public static String getVersion(Context context)//获取版本号
    {
        try {
            PackageInfo pi=context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return pi.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "1.0";
        }
    }

    /**
     * 跳转到MainActivity
     * @param activity 当前activity
     * @param currentPage 对应的page
     */
    public static void skipMainActivity(Activity activity,int currentPage) {
        Intent intent = new Intent(activity,MainActivity.class);
        intent.putExtra("currentPage", currentPage);
        activity.startActivity(intent);
        ActivityCollector.finishAll();
    }
}
