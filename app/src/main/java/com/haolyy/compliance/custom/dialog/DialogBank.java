package com.haolyy.compliance.custom.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.haolyy.compliance.R;

public class DialogBank extends Dialog {
    private TextView btn1Dialog;
    private TextView btn2Dialog;
    private OnDoubleClickListener mdouble;
    private DialogBank instance;

    public DialogBank(Context context) {
        super(context, R.style.dialogToast);
        instance = this;
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.gravity = Gravity.CENTER | Gravity.CENTER_HORIZONTAL;
        getWindow().setAttributes(attributes);
        super.setContentView(R.layout.dialog_bank);
        btn1Dialog = (TextView) super.findViewById(R.id.tv_think);
        btn2Dialog = (TextView) super.findViewById(R.id.tv_open);
        initListener();
    }

    public interface OnDoubleClickListener {
        void excuteLeft();

        void excuteRight();
    }

    public DialogBank setOnDoubleClickListener(OnDoubleClickListener doubl) {
        this.mdouble = doubl;
        return instance;

    }

    private void initListener() {
        btn1Dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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

    public DialogBank setButtonLeft(String btnText) {
        btn1Dialog.setText(btnText);
        return instance;
    }

    public DialogBank setButtonRight(String btnText) {
        btn2Dialog.setText(btnText);
        return instance;
    }
}
