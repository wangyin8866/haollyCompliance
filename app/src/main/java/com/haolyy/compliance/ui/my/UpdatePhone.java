package com.haolyy.compliance.ui.my;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.custom.TopBar;
import com.haolyy.compliance.custom.wheelview.adapter.ArrayWheelAdapter;
import com.haolyy.compliance.custom.wheelview.widget.WheelView;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wangyin on 2017/6/9.
 */

public class UpdatePhone extends AppCompatActivity {
    @BindView(R.id.top_security_update_phone)
    TopBar topSecurityPhone;
    @BindView(R.id.region)
    RelativeLayout region;
    private View popView;
    private WheelView<String> wheelView;
    private PopupWindow popWindow;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accout_update_phone);
        ButterKnife.bind(this);
        topSecurityPhone.setOnItemClickListener(new TopBar.OnItemClickListener() {
            @Override
            public void OnLeftButtonClicked() {
                finish();
            }

            @Override
            public void OnRightButtonClicked() {

            }
        });


    }

    @OnClick(R.id.region)
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.region:
                showSingChooseDialog();
                break;
        }
    }
    private void showSingChooseDialog() {
        popView = LayoutInflater.from(this).inflate(R.layout.vw_bottom, null);
        wheelView = (WheelView<String>) popView.findViewById(R.id.wheelview);
        initWheelView(wheelView, createTypeData());

        wheelView.setOnWheelItemSelectedListener(new WheelView.OnWheelItemSelectedListener<String>() {
            @Override
            public void onItemSelected(int position, String s) {

            }
        });

        popWindow = new PopupWindow(popView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popWindow.setFocusable(true);
        popWindow.setOutsideTouchable(false);
        popWindow.setAnimationStyle(R.style.mypopwindow_anim_style);
        popWindow.showAtLocation(popView, Gravity.BOTTOM, 0, 0);

        TextView ok = (TextView) popView.findViewById(R.id.ok);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                popWindow.dismiss();
            }
        });
    }
    private void initWheelView(WheelView<String> wv, List<String> list) {
        wv.setWheelAdapter(new ArrayWheelAdapter(this));
        wv.setSkin(WheelView.Skin.Holo);
        wv.setWheelData(list);
        WheelView.WheelViewStyle style = new WheelView.WheelViewStyle();
        style.selectedTextSize = 24;
        style.textSize = 16;
        wv.setStyle(style);
        wv.setWheelSize(5);
    }
    private List<String> createTypeData() {
        String[] strings = {"全部", "还款", "充值", "提现", "罚息"};
        return Arrays.asList(strings);
    }
}
