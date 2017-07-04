package com.haolyy.compliance.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.http.SslError;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.util.DisplayMetrics;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.haolyy.compliance.R;
import com.haolyy.compliance.base.ActivityCollector;
import com.haolyy.compliance.custom.XListView;
import com.haolyy.compliance.ui.MainActivity;

import java.lang.reflect.Field;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by wangyin on 2017/5/23.
 */

public class WYUtils {

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
    /**
     * webView加载
     */
    public static void loadHtml(final String url, final WebView mWebView, final ProgressBar mProgressBar) {
        WebSettings settings = mWebView.getSettings();
        /**
         * setAllowFileAccess 启用或禁止WebView访问文件数据 setBlockNetworkImage 是否显示网络图像
         * setBuiltInZoomControls 设置是否支持缩放 setCacheMode 设置缓冲的模式
         * setDefaultFontSize 设置默认的字体大小 setDefaultTextEncodingName 设置在解码时使用的默认编码
         * setFixedFontFamily 设置固定使用的字体 setJavaSciptEnabled 设置是否支持Javascript
         * setLayoutAlgorithm 设置布局方式 setLightTouchEnabled 设置用鼠标激活被选项
         * setSupportZoom 设置是否支持变焦
         * */

        //webview在安卓5.0之前默认允许其加载混合网络协议内容
        // 在安卓5.0之后，默认不允许加载http与https混合内容，需要设置webview允许其加载混合网络协议内容
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mWebView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);

        }
        mWebView.setDrawingCacheEnabled(true);
        settings.setJavaScriptEnabled(true);
        // 取消滚动条
        mWebView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        // 触摸焦点起作用
        mWebView.requestFocus();
        settings.setSavePassword(false);// 不弹窗浏览器是否保存密码
        settings.setDefaultTextEncodingName("utf-8");
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        // 自动适应屏幕尺寸
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        mWebView.loadUrl(url);
        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    mProgressBar.setVisibility(View.GONE);
                } else {
                    mProgressBar.setVisibility(View.VISIBLE);
                }
            }
        });
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(url);
                return true;

            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                //注意：super句话一定要删除，或者注释掉，否则又走handler.cancel()默认的不支持https的了。
                //super.onReceivedSslError(view, handler, error);
                //handler.cancel(); // Android默认的处理方式
                //handler.handleMessage(Message msg); // 进行其他处理

                handler.proceed(); // 接受所有网站的证书
            }
        });
    }

    /**
     *
     * @param name  标的名
     * @param imageView iv
     */
    public static void selectIcon(String name, ImageView imageView) {
        if (name.contains("短期赢")) {
            imageView.setBackgroundResource(R.mipmap.duan);
        } else if (name.contains("赢计划")) {
            imageView.setBackgroundResource(R.mipmap.icon_ying);
        }else if (name.contains("周周赢")) {
            imageView.setBackgroundResource(R.mipmap.icon_zhou);
        }else if (name.contains("消费贷")) {
            imageView.setBackgroundResource(R.mipmap.icon_xiao);
        }else if (name.contains("闪车贷")) {
            imageView.setBackgroundResource(R.mipmap.icon_che);
        }else if (name.contains("票据贷")) {
            imageView.setBackgroundResource(R.mipmap.icon_piao);
        }

    }
}
