package com.haolyy.compliance.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.haolyy.compliance.base.BaseApplication;

//实现标记的写入与读取
public class SPUtils {
    private static final String SP_NAME = "Haolly";
    private static SharedPreferences sp;

    //保存布尔值
    public static void saveBoolean(Context context, String key, boolean value) {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        }
        sp.edit().putBoolean(key, value).apply();
    }

    public static boolean getBoolean(Context context, String key, boolean defValue) {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        }
        boolean result = sp.getBoolean(key, defValue);
        return result;
    }

    //保存字符串
    public static void saveString(Context context, String key, String value) {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        }
        sp.edit().putString(key, value).apply();
    }

    public static String getString(Context context, String key, String defValue) {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        }
        String result = sp.getString(key, defValue);
        return result;
    }

    //保存Long---token
    public static void saveLong(Context context, String key, long value) {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        }
        sp.edit().putLong(key, value).apply();
    }

    public static long getLong(Context context, String key, long defValue) {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        }
        long result = sp.getLong(key, defValue);
        return result;
    }

    //保存int
    public static void saveInt(Context context, String key, int value) {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        }
        sp.edit().putInt(key, value).apply();
    }

    public static int getInt(Context context, String key, int defValue) {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        }
        int result = sp.getInt(key, defValue);
        return result;
    }


    //保存密码
    private String psw;
    private String phone;
    private int gId;
    private String gCode;
    private Context context;
    private SharedPreferences sharedPreferences;

    public SPUtils(Context context) {
        this.context = context;
        this.sharedPreferences = context.getSharedPreferences("gesture", Context.MODE_PRIVATE);
    }

    public String getPsw() {
        psw = sharedPreferences.getString("gesturePsw", "");
        return psw;
    }

    public String getPhone(){
        phone=sharedPreferences.getString("gesturePhone","");
        return phone;
    }

    public int getgId(){
        gId=sharedPreferences.getInt("gestureId", BaseApplication.userId);
        return gId;
    }

    public String getgCode(){
        gCode=sharedPreferences.getString("gestureCode","");
        return gCode;
    }

    // 清除手势密码
    public static void clearGestureInfo(Context context) {
        BaseApplication.mLoginState = false;
        BaseApplication.userId = -1;
        BaseApplication.mUserName="";
        SharedPreferences sharedPreferences = context.getSharedPreferences("gesture", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
