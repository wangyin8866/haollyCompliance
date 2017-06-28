package com.haolyy.compliance.ui.bank;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseActivity;
import com.haolyy.compliance.custom.ClearEditText;
import com.haolyy.compliance.custom.dialog.DialogBankSms;
import com.haolyy.compliance.ui.bank.presenter.BankBindPresenter;
import com.haolyy.compliance.ui.bank.view.BankBindView;
import com.haolyy.compliance.utils.DateUtil;
import com.haolyy.compliance.utils.UIUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class BankBindActivity extends BaseActivity<BankBindPresenter, BankBindView> implements BankBindView {
    @BindView(R.id.iv_finish)
    ImageView ivFinish;
    @BindView(R.id.iv_service)
    ImageView ivService;
    @BindView(R.id.tv_menu)
    TextView tvMenu;
    @BindView(R.id.iv_share)
    ImageView ivShare;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_joining)
    TextView tvJoining;
    @BindView(R.id.view_line)
    View viewLine;
    @BindView(R.id.titleBar)
    RelativeLayout titleBar;
    @BindView(R.id.tv_real_name)
    ClearEditText tvRealName;
    @BindView(R.id.tv_id_card)
    ClearEditText tvIdCard;
    @BindView(R.id.ll_input_info)
    LinearLayout llInputInfo;
    @BindView(R.id.tv_bank_name)
    TextView tvBankName;
    @BindView(R.id.tv_card_type)
    TextView tvCardType;
    @BindView(R.id.tv_card_no)
    TextView tvCardNo;
    @BindView(R.id.ll_show_card)
    LinearLayout llShowCard;
    @BindView(R.id.tv_bank_next)
    TextView tvBankNext;
    @BindView(R.id.tv_select_bank)
    TextView tvSelectBank;
    @BindView(R.id.tv_bank_name_logo)
    TextView tvBankNameLogo;
    @BindView(R.id.tv_limit)
    TextView tvLimit;
    @BindView(R.id.cb_bind_proctor)
    CheckBox cbBindProctor;
    @BindView(R.id.iv_bank_logo)
    ImageView ivBankLogo;
    @BindView(R.id.et_bank_phone)
    ClearEditText etBankPhone;
    @BindView(R.id.et_card_no)
    ClearEditText etCardNo;
    @BindView(R.id.change_card)
    TextView changeCard;
    private String realName, idCard, bankName, bankPhone, cardno;
    private DialogBankSms dialogBankSms;
    private String smseq;//短信序列号

    @Override
    protected BankBindPresenter createPresenter() {
        return new BankBindPresenter(mContext);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_bind);
        ButterKnife.bind(this);
    }

    @Override
    protected void handleMessage(Integer s) {

    }

    @OnClick({R.id.iv_finish, R.id.tv_bank_next, R.id.tv_select_bank, R.id.change_card})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_finish:
                finish();
                break;
            case R.id.tv_bank_next:
                realName = tvRealName.getText().toString();
                idCard = tvIdCard.getText().toString();
                bankName = tvBankNameLogo.getText().toString();
                bankPhone = etBankPhone.getText().toString();
                cardno = etCardNo.getText().toString();
                mPresenter.sendSms("user_register", "6228229339910333", "", "2", "13856989634", "", "4", 0);
                break;
            case R.id.tv_select_bank:
                startActivityForResult(new Intent(BankBindActivity.this, BankListActivity.class), 0x03);
                break;
            case R.id.change_card:
                Intent intent = new Intent(mContext, ShBankWebActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (null != data) {
            UIUtils.showToastCommon(this, "收到银行data");
            tvBankNameLogo.setText("招行");
            ivBankLogo.setImageResource(R.mipmap.bank_logo);
            tvLimit.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showSuccessToast(String msg) {

    }

    @Override
    public void showErrorToast(String msg) {

    }

    /**
     * 短信验证码弹框
     *
     * @param smsSeq
     */
    @Override
    public void showSmsDialog(String smsSeq) {
        smseq = smsSeq;
        dialogBankSms = new DialogBankSms(BankBindActivity.this);
        //bankPhone.substring(bankPhone.length() - 4, bankPhone.length())
        dialogBankSms.setContext("2946").setOnDoubleClickListener(new DialogBankSms.OnDoubleClickListener() {
            @Override
            public void executeSend(String sms) {
                dialogBankSms.getBtn().setEnabled(false);
                mPresenter.sendSms("user_register", "6228229339910333", "", "2", "13856989634", "", "4", 1);
            }

            @Override
            public void executeLeft() {

            }

            @Override
            public void executeRight() {
                mPresenter.register2("5", "1", "13856989634", "13856989634", "141002199203241329", "禄博丹", "6228229339910333", "101", "666666", "AAAAAAAA", "", "http://www.baidu.com", "1", "android1.0", "1059451948592", "2");
            }
        }).show();
    }

    /**
     * 重新倒计时
     *
     * @param smsSeq
     * @param b
     */
    @Override
    public void refreshDialog(String smsSeq, boolean b) {
        if (b) {
            dialogBankSms.getBtn().setEnabled(true);
        } else {
            smseq = smsSeq;
            DateUtil.countDown(dialogBankSms.getBtn(), "重发");
        }
    }

    /**
     * 跳转上海银行页面
     *
     * @param baseResponseBean
     */
    @Override
    public void pushActivity(String baseResponseBean) {
        Intent intent = new Intent(mContext, ShBankWebActivity.class);
        intent.setAction(baseResponseBean);
        startActivity(intent);
    }
}
