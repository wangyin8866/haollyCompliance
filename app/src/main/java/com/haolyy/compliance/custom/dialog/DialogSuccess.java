package com.haolyy.compliance.custom.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.TextView;

import com.haolyy.compliance.R;

public class DialogSuccess extends Dialog {

    private final TextView tv;

    public DialogSuccess(Context context) {
        super(context, R.style.dialogWrong);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.gravity = Gravity.CENTER | Gravity.CENTER_HORIZONTAL;
        getWindow().setAttributes(attributes);
        super.setContentView(R.layout.dialog_success);
        tv = (TextView) super.findViewById(R.id.tv_dialog_success);
    }

    public void setSuccessText(String text) {
        tv.setText(text);
    }
}
