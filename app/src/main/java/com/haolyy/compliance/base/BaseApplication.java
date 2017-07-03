package com.haolyy.compliance.base;


import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.haolyy.compliance.utils.LogUtils;
import com.squareup.leakcanary.LeakCanary;


/**
 * 主工程
 * Created by ndy on 2016/05/19.
 */
public class BaseApplication extends Application {
    /**
     * 全局Context，原理是因为Application类是应用最先运行的，所以在我们的代码调用时，该值已经被赋值过了
     */
    private static BaseApplication mInstance;
    /**
     * 主线程ID
     */
    private static int mMainThreadId = -1;
    /**
     * 主线程ID
     */
    private static Thread mMainThread;
    /**
     * 主线程Handler
     */
    private static Handler mMainThreadHandler;
    /**
     * 主线程Looper
     */
    private static Looper mMainLooper;

    public static boolean mLoginState;
    public static int userId = -1;
    public static String mUserName;

    public static String mInviteCode;//用户邀请码
    public static String registerInviteCode = "";//注册邀请码
    public static String buyInviteCode;
    public static String mSharedPreferencesName;

    public static int loginDefeatCount = 0;// 登录失败次数

    public static boolean isNeedGesture = true;// 是否需要手势密码
    public static boolean isRegisterSucceed = false;
    public static String tryBorrowNid;

    public static String fromActivity = "";//哪来回哪去
    public static String BorrowId;
    private static Context context;
    public static long time_limit = 86400;
    public static int huoti_count;
    public static String Borrow_Amount;
    public static String Borrow_Deline;
    public static String token;
    public static String BankFrom;
    public static String version="";//版本号

    @Override
    public void onCreate() {
        super.onCreate();
        //LeakCanary.install(this);
        context = getApplicationContext();
        mMainThreadId = android.os.Process.myTid();
        mMainThread = Thread.currentThread();
        mMainThreadHandler = new Handler();
        mMainLooper = getMainLooper();
        mInstance = this;


        //是否打印日志
        LogUtils.isDebug = true;
        initUmeng();


    }

    public static Context getContext() {
        return context;
    }

    private void initUmeng() {
        //推送
    }

    public static BaseApplication getApplication() {
        return mInstance;
    }

    /**
     * 获取主线程ID
     */
    public static int getMainThreadId() {
        return mMainThreadId;
    }

    /**
     * 获取主线程
     */
    public static Thread getMainThread() {
        return mMainThread;
    }

    /**
     * 获取主线程的handler
     */
    public static Handler getMainThreadHandler() {
        return mMainThreadHandler;
    }

}
