package com.haolyy.compliance.custom.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.utils.DateUtil;

public class DialogBankSms extends Dialog {
    private TextView btn1Dialog;
    private TextView btn2Dialog;
    private OnDoubleClickListener mdouble;
    private DialogBankSms instance;
    private EditText editText;
    private TextView tips;
    public TextView getBtn() {
        return btn;
    }

    private TextView btn;
    private TextView tvContent;

    public DialogBankSms(Context context) {
        super(context, R.style.dialogToast);
        instance = this;
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.gravity = Gravity.CENTER | Gravity.CENTER_HORIZONTAL;
        getWindow().setAttributes(attributes);
        super.setContentView(R.layout.dialog_send_sms);
        btn1Dialog = (TextView) super.findViewById(R.id.tv_sms_cancel);
        btn2Dialog = (TextView) super.findViewById(R.id.tv_sms_sure);
        editText = (EditText) super.findViewById(R.id.et_sms);
        btn = (TextView) super.findViewById(R.id.btn_sms);
        tvContent = (TextView) super.findViewById(R.id.tv_sms_content);
        tips=(TextView) super.findViewById(R.id.tv_wrong_tips);
        initListener();
    }

    public interface OnDoubleClickListener {
        void executeSend();

        void executeLeft();

        void executeRight(String sms);
    }

    public DialogBankSms setOnDoubleClickListener(OnDoubleClickListener doubl) {
        this.mdouble = doubl;
        return instance;

    }

    private void initListener() {
        btn1Dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdouble.executeLeft();
                dismiss();
            }
        });
        btn2Dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sms = editText.getText().toString();
                if(sms.length()<6){
                    tips.setVisibility(View.VISIBLE);
                    return;
                }else {
                    tips.setVisibility(View.GONE);
                }
                mdouble.executeRight(sms);
                dismiss();
            }
        });

        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mdouble.executeSend();
                    }
                }
        );
    }

    public DialogBankSms setButtonLeft(String btnText) {
        btn1Dialog.setText(btnText);
        return instance;
    }

    public DialogBankSms setButtonRight(String btnText) {
        btn2Dialog.setText(btnText);
        return instance;
    }

    public DialogBankSms setContext(String text) {
        SpannableStringBuilder style = new SpannableStringBuilder("上海银行\n已给尾号" + text + "的手机发送了验证码");
        style.setSpan(new ForegroundColorSpan(Color.parseColor("#ff9933")), 9, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvContent.setText(style);
        btn.setEnabled(false);
        DateUtil.countDown(btn, "重发");
        return instance;
    }

    public void setWrongTips(String text) {
        tips.setText(text);
    }
}
