package com.haolyy.compliance.ui.bank;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.custom.ClearEditText;
import com.haolyy.compliance.inteface.EditTextChangeIdCardListener;
import com.haolyy.compliance.utils.UIUtils;
import com.haolyy.compliance.utils.WyUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class CheckBankActivity extends AppCompatActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.view_line)
    View viewLine;
    @BindView(R.id.tv_real_name)
    ClearEditText tvRealName;
    @BindView(R.id.tv_id_card)
    ClearEditText tvIdCard;
    @BindView(R.id.iv_finish)
    ImageView ivFinish;
    @BindView(R.id.tv_bank_next)
    TextView tvBankNext;
    private String realname;
    private String idCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_check_bank);
        ButterKnife.bind(this);
        tvTitle.setText("开通上海银行存管账户");
        tvIdCard.addTextChangedListener(new EditTextChangeIdCardListener(tvIdCard));
    }

    @OnClick({R.id.iv_finish, R.id.tv_bank_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_finish:
                finish();
                break;
            case R.id.tv_bank_next:
                realname = tvRealName.getText().toString();
                idCard = tvIdCard.getText().toString().replaceAll(" ","");
               /* if(TextUtils.isEmpty(realname)|| !WyUtils.checkChnCharacters(realname)){
                    UIUtils.showToastCommon(CheckBankActivity.this,"请输入正确的姓名");
                    return;
                }*/
               if(TextUtils.isEmpty(idCard)|| !WyUtils.checkId(idCard)){
                    UIUtils.showToastCommon(CheckBankActivity.this,"请输入正确的身份证号");
                    return;
                }
                startActivity(new Intent(CheckBankActivity.this, BankBindActivity.class));
                break;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction()==MotionEvent.ACTION_DOWN){
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
        }
        return super.onTouchEvent(event);
    }
}
