package com.haolyy.compliance.custom.dialog;

import android.app.Dialog;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.utils.LogUtils;
import com.haolyy.compliance.utils.WYUtils;

public class DialogLoginPassword extends Dialog {
    private TextView btn1Dialog;
    private TextView btn2Dialog;
    private OnDoubleClickListener mdouble;
    private DialogLoginPassword instance;
    private EditText editText;
    private TextView tips;

    private TextView tvContent;

    public DialogLoginPassword(Context context) {
        super(context, R.style.dialogToast);
        instance = this;
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.gravity = Gravity.CENTER | Gravity.CENTER_HORIZONTAL;
        getWindow().setAttributes(attributes);
        super.setContentView(R.layout.dialog_login_password);
        btn1Dialog = (TextView) super.findViewById(R.id.tv_sms_cancel);
        btn2Dialog = (TextView) super.findViewById(R.id.tv_sms_sure);
        editText = (EditText) super.findViewById(R.id.et_sms);
        tvContent = (TextView) super.findViewById(R.id.tv_sms_content);
        tips=(TextView) super.findViewById(R.id.tv_wrong_tips);
        WYUtils.showSoftPan(editText);
        initListener();

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                LogUtils.e("editText",s.length()+"");
                if (s.length()==0) {

                    tips.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public interface OnDoubleClickListener {

        void executeLeft();

        void executeRight(String password,TextView tips);
    }

    public DialogLoginPassword setOnDoubleClickListener(OnDoubleClickListener doubl) {
        this.mdouble = doubl;
        return instance;

    }

    private void initListener() {
        btn1Dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdouble.executeLeft();
            }
        });
        btn2Dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = editText.getText().toString();
                mdouble.executeRight(password,tips);
            }
        });

    }

    public DialogLoginPassword setButtonLeft(String btnText) {
        btn1Dialog.setText(btnText);
        return instance;
    }

    public DialogLoginPassword setButtonRight(String btnText) {
        btn2Dialog.setText(btnText);
        return instance;
    }

    public DialogLoginPassword setContext(String text) {
        tvContent.setText(text);
        return instance;
    }

    public DialogLoginPassword setWrongTips(String text) {
        tips.setText(text);
        return instance;
    }
}
