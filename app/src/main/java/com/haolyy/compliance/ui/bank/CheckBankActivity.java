package com.haolyy.compliance.ui.bank;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseActivity;
import com.haolyy.compliance.custom.ClearEditText;
import com.haolyy.compliance.custom.dialog.DialogBankSms;
import com.haolyy.compliance.entity.bank.IsActivateBean;
import com.haolyy.compliance.ui.MainActivity;
import com.haolyy.compliance.ui.bank.presenter.CheckBankPresenter;
import com.haolyy.compliance.ui.bank.view.CheckBankView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class CheckBankActivity extends BaseActivity<CheckBankPresenter, CheckBankView> implements CheckBankView {
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
    @BindView(R.id.titleBar)
    RelativeLayout titleBar;
    @BindView(R.id.ll_check)
    LinearLayout llCheck;
    @BindView(R.id.tv_bank_name)
    TextView tvBankName;
    @BindView(R.id.tv_card_type)
    TextView tvCardType;
    @BindView(R.id.tv_card_no)
    TextView tvCardNo;
    @BindView(R.id.ll_show_card)
    LinearLayout llShowCard;
    @BindView(R.id.tv_go_account)
    TextView tvGoAccount;
    private String realname;
    private String idCard;

    @Override
    protected CheckBankPresenter createPresenter() {
        return new CheckBankPresenter(mContext);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_check_bank);
        ButterKnife.bind(this);
        tvTitle.setText("开通上海银行存管账户");
    }

    @Override
    protected void handleMessage(Integer s) {

    }

    @OnClick({R.id.iv_finish, R.id.tv_bank_next,R.id.tv_go_account})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_finish:
                finish();
                break;
            case R.id.tv_bank_next:
                realname = tvRealName.getText().toString();
                idCard = tvIdCard.getText().toString().replaceAll(" ", "");
               /* if(TextUtils.isEmpty(realname)|| !WYUtils.checkChnCharacters(realname)){
                    UIUtils.showToastCommon(CheckBankActivity.this,"请输入正确的姓名");
                    return;
                }
               if(TextUtils.isEmpty(idCard)|| !WYUtils.checkId(idCard)){
                    UIUtils.showToastCommon(CheckBankActivity.this,"请输入正确的身份证号");
                    return;
                }*/
                mPresenter.isBosAcctActivate(idCard, realname, "2");
                //返回的type"type":"1,2"正常开户 3 发短息 4 掉激活接口
                break;
            case R.id.tv_go_account:
                startActivity(new Intent(mContext, MainActivity.class));
                break;
        }
    }

/*    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
        }
        return super.onTouchEvent(event);
    }*/

    @Override
    public void showSuccessToast(final String msg) {
        DialogBankSms dialogBankSms = new DialogBankSms(mContext);

        dialogBankSms.setContext( msg.substring(msg.length() - 4, msg.length())).setOnDoubleClickListener(new DialogBankSms.OnDoubleClickListener() {
            @Override
            public void executeSend() {


            }

            @Override
            public void executeLeft() {

            }

            @Override
            public void executeRight(String sms) {
                //获取银行卡信息展示银行卡界面
                mPresenter.validateOldUser(msg,sms);
            }
        }).show();
    }

    @Override
    public void showErrorToast(String msg) {

    }

    @Override
    public void pushActivity(String s) {
        Intent intent = new Intent(mContext, ShBankWebActivity.class);
        intent.setAction(s);
        startActivity(intent);
        finish();
    }

    /**
     * 展示在别的频台绑定的银行卡
     *
     * @param s
     */
    @Override
    public void showCard(IsActivateBean s) {
        llCheck.setVisibility(View.GONE);
        llShowCard.setVisibility(View.VISIBLE);
        tvBankName.setText(s.getModel().getBank_name());
        tvCardNo.setText(s.getModel().getBank_card_no());
    }
}
