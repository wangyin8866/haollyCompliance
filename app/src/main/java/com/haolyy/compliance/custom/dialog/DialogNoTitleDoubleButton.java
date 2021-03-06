package com.haolyy.compliance.custom.dialog;

import android.app.Dialog;
import android.content.Context;
import android.text.Html;
import android.text.Spanned;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.utils.LogUtils;
import com.haolyy.compliance.utils.UIUtils;
import com.haolyy.compliance.utils.WYUtils;

public class DialogNoTitleDoubleButton extends Dialog {
    private TextView tvDialogContent;
    private TextView btn1Dialog;
    private TextView btn2Dialog;
    private OnDoubleClickListener mdouble;
    private DialogNoTitleDoubleButton instance;
    private Context context;
    public DialogNoTitleDoubleButton(Context context) {
        super(context, R.style.dialogWrong);
        instance = this;
        this.context = context;
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.gravity = Gravity.CENTER | Gravity.CENTER_HORIZONTAL;
        getWindow().setAttributes(attributes);
        super.setContentView(R.layout.dilog_notitle_doublebutton);
        tvDialogContent = (TextView) super.findViewById(R.id.tv_dialog_content);
        btn1Dialog = (TextView) super.findViewById(R.id.btn1_dialog);
        btn2Dialog = (TextView) super.findViewById(R.id.btn2_dialog);
        initListener();
    }

    public interface OnDoubleClickListener {
        void excuteLeft();

        void excuteRight();
    }

    public DialogNoTitleDoubleButton setOnDoubleClickListener(OnDoubleClickListener doubl) {
        this.mdouble = doubl;
        return instance;

    }

    private void initListener() {
        btn1Dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                mdouble.excuteLeft();
            }
        });
        btn2Dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdouble.excuteRight();
            }
        });
    }

    public DialogNoTitleDoubleButton setContent(String content,int size,boolean bold) {
        tvDialogContent.setText(content);
        tvDialogContent.setTextSize(size);
        tvDialogContent.getPaint().setFakeBoldText(bold);
        return instance;
    }

    public DialogNoTitleDoubleButton setContent(Spanned spanned) {
        tvDialogContent.setTextSize(14);
        tvDialogContent.getPaint().setFakeBoldText(false);
        tvDialogContent.setText(spanned);
        return instance;
    }

    public DialogNoTitleDoubleButton setButtonLeft(String btnText) {
        btn1Dialog.setText(btnText);
        return instance;
    }

    public DialogNoTitleDoubleButton setButtonRight(String btnText) {
        btn2Dialog.setText(btnText);
        return instance;
    }
}
