package com.haolyy.compliance.custom.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.haolyy.compliance.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by William on 2017/1/8
 */

public class DialogInvest extends Dialog {

    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.tv_left)
    TextView tvLeft;
    @BindView(R.id.tv_right)
    TextView tvRight;
    @BindView(R.id.tv_content2)
    TextView tvContent2;
    private ConversionIntegral converIntegral;
    private DialogInvest instance;

    public void setConverIntegral(ConversionIntegral converIntegral) {
        this.converIntegral = converIntegral;
    }

    public DialogInvest(Context context) {
        super(context, R.style.dialogToast);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.gravity = Gravity.CENTER;
        getWindow().setAttributes(attributes);
        super.setContentView(R.layout.dialog_invest);
        ButterKnife.bind(this);
        instance = this;
    }

    @OnClick({R.id.tv_left, R.id.tv_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_left:
                converIntegral.leftClick();
                break;
            case R.id.tv_right:
                converIntegral.rightClick();
                break;
        }
    }

    public DialogInvest setContent1(String content) {
        tvContent.setText(content);
        return instance;

    }
    public DialogInvest setContent2(String content) {
        tvContent2.setText(content);
        return instance;

    }
    public DialogInvest setLeftText(String left) {
        tvLeft.setText(left);
        return instance;
    }

    public DialogInvest setRightText(String rightText) {
        tvRight.setText(rightText);
        return instance;
    }

    public interface ConversionIntegral {
        void leftClick();
        void rightClick();
    }
}
