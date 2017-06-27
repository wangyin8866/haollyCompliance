package com.haolyy.compliance.ui.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.haolyy.compliance.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wangyin on 2017/6/27.
 */

public class RadiogroupTest extends AppCompatActivity {
    @BindView(R.id.ra_test)
    RadioGroup group;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radio_main);
        ButterKnife.bind(this);

        for(int i=0; i<10; i++)
        {
            RadioButton tempButton = new RadioButton(this);
            tempButton.setBackgroundResource(R.drawable.selector_chose);   // 设置RadioButton的背景图片
            tempButton.setButtonDrawable(R.drawable.bg_deal_no_select);           // 设置按钮的样式
            tempButton.setPadding(80, 0, 0, 0);                 // 设置文字距离按钮四周的距离
            tempButton.setText("按钮 " + i);
            tempButton.setTextColor(getResources().getColorStateList(R.color.color_tv_selector));
            group.addView(tempButton, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        }
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton tempButton = (RadioButton)findViewById(checkedId); // 通过RadioGroup的findViewById方法，找到ID为checkedID的RadioButton
                // 以下就可以对这个RadioButton进行处理了
                Toast.makeText(RadiogroupTest.this,tempButton.getText() , Toast.LENGTH_SHORT).show();
            }
        });
    }
}
