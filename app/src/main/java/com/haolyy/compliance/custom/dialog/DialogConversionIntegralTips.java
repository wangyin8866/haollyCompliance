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

public class DialogConversionIntegralTips extends Dialog {

    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.tv_left)
    TextView tvLeft;
    @BindView(R.id.tv_right)
    TextView tvRight;
    private ConversionIntegral converIntegral;
    private DialogConversionIntegralTips instance;
    public void setConverIntegral(ConversionIntegral converIntegral) {
        this.converIntegral = converIntegral;
    }

    public DialogConversionIntegralTips(Context context) {
        super(context, R.style.dialogToast);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.gravity = Gravity.CENTER;
        getWindow().setAttributes(attributes);
        super.setContentView(R.layout.dialog_conversion_integral);
        ButterKnife.bind(this);
        instance = this;
    }

    @OnClick({R.id.tv_left, R.id.tv_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_left:
                dismiss();
                break;
            case R.id.tv_right:
                converIntegral.conversion();
                break;
        }
    }
    public DialogConversionIntegralTips setContent(String content){
        tvContent.setText(content);
        return instance;

    }
    public DialogConversionIntegralTips setLeftText(String left){
        tvLeft.setText(left);
        return instance;
    }
    public DialogConversionIntegralTips setRightText(String rightText){
        tvRight.setText(rightText);
        return instance;
    }
    public interface ConversionIntegral{
        void conversion();
    }
}
