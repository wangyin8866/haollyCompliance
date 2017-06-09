package com.haolyy.compliance.custom.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.haolyy.compliance.R;

public class DialogInvestGuides extends Dialog {
    private TextView btn1Dialog;
    private TextView btn2Dialog;
    private TextView tvContent;
    private ImageView imageView;
    private OnDoubleClickListener mdouble;
    private DialogInvestGuides instance;

    public DialogInvestGuides(Context context) {
        super(context, R.style.dialogBank);
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
