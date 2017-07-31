package com.haolyy.compliance.ui.my;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.base.ActivityCollector;
import com.haolyy.compliance.custom.SwitchButton;
import com.haolyy.compliance.custom.dialog.DialogNoTitleDoubleButton;
import com.haolyy.compliance.utils.CacheManager;
import com.haolyy.compliance.utils.SPUtils;
import com.haolyy.compliance.utils.WYUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.haolyy.compliance.config.Config.service_phone;


public class SettingActivity extends AppCompatActivity {

    @BindView(R.id.iv_finish)
    ImageView ivFinish;
    @BindView(R.id.view_line)
    View viewLine;
    @BindView(R.id.switch1)
    SwitchButton switch1;
    @BindView(R.id.tv_clear_cache)
    TextView tvClearCache;
    @BindView(R.id.tv_version)
    TextView tvVersion;
    @BindView(R.id.tv_about)
    TextView tvAbout;
    @BindView(R.id.tv_contact_us)
    TextView tvContactUs;
    @BindView(R.id.tv_feedback)
    TextView tvFeedback;
    @BindView(R.id.iv_service)
    ImageView ivService;
    @BindView(R.id.tv_menu)
    TextView tvMenu;
    @BindView(R.id.iv_share)
    ImageView ivShare;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.titleBar)
    RelativeLayout titleBar;
    @BindView(R.id.tv_login_out)
    TextView tvLoginOut;
    private DialogNoTitleDoubleButton dialogNoTitleDoubleButton;
    private String totalCacheSize;
    private boolean isNotification;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        ActivityCollector.addActivity(this);
        initView();
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void initView() {

        //判断用户是否开启权限
        isNotification = WYUtils.isNotificationEnabled(this);

        tvTitle.setText("设置");
        try {
            totalCacheSize = CacheManager.getTotalCacheSize(getApplicationContext());
            tvClearCache.setText(totalCacheSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        dialogNoTitleDoubleButton = new DialogNoTitleDoubleButton(SettingActivity.this);
        if (isNotification) {
            switch1.setChecked(true);
        } else {
            switch1.setChecked(false);
        }
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Spanned spanned = null;
                if (isNotification) {
                    spanned = Html.fromHtml("您现在可以收到消息通知。请到<font color='#ff9933'>“设置-好利网-通知”</font>中，关闭允许通知选项。");
                } else {
                    spanned = Html.fromHtml("您现在无法收到消息通知。请到<font color='#ff9933'>“设置-好利网-通知”</font>中，开启允许通知选项。");
                }
                dialogNoTitleDoubleButton.setContent(spanned).setOnDoubleClickListener(new DialogNoTitleDoubleButton.OnDoubleClickListener() {
                    @Override
                    public void excuteLeft() {

                    }

                    @Override
                    public void excuteRight() {
                        getAppDetailSettingIntent(SettingActivity.this);
                        dialogNoTitleDoubleButton.dismiss();
                    }
                }).show();
            }
        });
    }

    @OnClick({R.id.iv_finish, R.id.tv_clear_cache, R.id.tv_version, R.id.tv_about, R.id.tv_contact_us, R.id.tv_feedback,R.id.tv_login_out})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_finish:
                finish();
                break;
            case R.id.tv_clear_cache:
                Spanned spanned = Html.fromHtml("您的缓存数据大小为<font color='#ff9933'>" + totalCacheSize + "</font>是否确定清理？");
                dialogNoTitleDoubleButton.setContent(spanned).setOnDoubleClickListener(new DialogNoTitleDoubleButton.OnDoubleClickListener() {
                    @Override
                    public void excuteLeft() {

                    }

                    @Override
                    public void excuteRight() {
                        CacheManager.clearAllCache(getApplicationContext());
                        dialogNoTitleDoubleButton.dismiss();
                        try {
                            totalCacheSize = CacheManager.getTotalCacheSize(getApplicationContext());
                            tvClearCache.setText(totalCacheSize);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).show();
                break;
            case R.id.tv_version:
                break;
            case R.id.tv_about:
                break;
            case R.id.tv_contact_us:
                dialogNoTitleDoubleButton.setContent(service_phone, 21, true).setOnDoubleClickListener(new DialogNoTitleDoubleButton.OnDoubleClickListener() {
                    @Override
                    public void excuteLeft() {

                    }
                    @Override
                    public void excuteRight() {
                        WYUtils.CallPhone(SettingActivity.this, 0x11);
                        dialogNoTitleDoubleButton.dismiss();
                    }
                }).show();
                break;
            case R.id.tv_feedback:
                break;
            case R.id.tv_login_out:
                SPUtils.loginOut();
                break;
        }
    }

    /**
     * 请求权限的回调方法(电话)
     *
     * @param requestCode  请求码
     * @param permissions  请求的权限
     * @param grantResults 权限的结果
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 0x11) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                WYUtils.CallPhone(SettingActivity.this, 0x11);
// Permission Granted
            } else {
// Permission Denied
            }

        }
    }

    /**
     * 跳到设置
     * @param context
     */
    private void getAppDetailSettingIntent(Context context) {
        Intent localIntent = new Intent();
        localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (Build.VERSION.SDK_INT >= 9) {
            localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            localIntent.setData(Uri.fromParts("package", getPackageName(), null));
        }
        startActivity(localIntent);
    }


}
