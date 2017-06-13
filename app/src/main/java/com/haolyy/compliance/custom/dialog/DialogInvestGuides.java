package com.haolyy.compliance.custom.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.haolyy.compliance.R;

public class DialogInvestGuides extends Dialog {
    public static final String TEST = "test";
    public static final String TRADEPWD = "trade";
    public static final String INTELLIGENCE = "intelligence";
    private TextView btn1Dialog;
    private TextView btn2Dialog;
    private TextView tvContent;
    private ImageView imageView;
    private OnDoubleClickListener mdouble;
    private DialogInvestGuides instance;

    public DialogInvestGuides(Context context, String type) {
        super(context, R.style.dialogToast);
        instance = this;
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.gravity = Gravity.CENTER | Gravity.CENTER_HORIZONTAL;
        getWindow().setAttributes(attributes);
        super.setContentView(R.layout.dialog_guides);
        btn1Dialog = (TextView) super.findViewById(R.id.tv_think);
        btn2Dialog = (TextView) super.findViewById(R.id.tv_open);
        tvContent = (TextView) super.findViewById(R.id.tv_content);
        imageView = (ImageView) super.findViewById(R.id.iv_head_dialog);
        initListener();
        if (type == TEST) {
            setIcon(R.mipmap.icon_dialog_test).setButtonRight("开始评测").setContent("为了对您的风险识别能力和风险承担能力进行评估，请您认真作答");
        } else if (type == TRADEPWD) {
            setIcon(R.mipmap.icon_dialog_pwd).setButtonRight("设置密码").setContent("为保障您的账户资金安全，请设置存管账户交易密码");
        } else {
            setIcon(R.mipmap.icon_dialog_open).setButtonRight("点击开启").setContent("自动投标队列功能、项目集合的一键投标功能和快捷投标功能都需要开启自动投标授权后才可以使用");
        }
    }

    public interface OnDoubleClickListener {
        void excuteLeft();

        void excuteRight();
    }

    public DialogInvestGuides setOnDoubleClickListener(OnDoubleClickListener doubl) {
        this.mdouble = doubl;
        return instance;

    }

    private void initListener() {
        btn1Dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdouble.excuteLeft();
                dismiss();
            }
        });
        btn2Dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdouble.excuteRight();
            }
        });
    }

    public DialogInvestGuides setIcon(int icon) {

        imageView.setImageResource(icon);

        return instance;
    }

    public DialogInvestGuides setContent(String btnText) {
        tvContent.setText(btnText);
        return instance;
    }

    public DialogInvestGuides setButtonLeft(String btnText) {
        btn1Dialog.setText(btnText);
        return instance;
    }

    public DialogInvestGuides setButtonRight(String btnText) {
        btn2Dialog.setText(btnText);
        return instance;
    }
}
