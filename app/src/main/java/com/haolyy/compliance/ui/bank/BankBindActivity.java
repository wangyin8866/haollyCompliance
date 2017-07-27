package com.haolyy.compliance.ui.bank;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseActivity;
import com.haolyy.compliance.base.BaseApplication;
import com.haolyy.compliance.custom.ClearEditText;
import com.haolyy.compliance.custom.dialog.DialogBankSms;
import com.haolyy.compliance.entity.bank.BankListBean;
import com.haolyy.compliance.inteface.EditTextChangeBankCardListener;
import com.haolyy.compliance.ui.MainActivity;
import com.haolyy.compliance.ui.bank.presenter.BankBindPresenter;
import com.haolyy.compliance.ui.bank.view.BankBindView;
import com.haolyy.compliance.utils.DateUtil;
import com.haolyy.compliance.utils.LogUtils;
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
    @BindView(R.id.tv_back_account)
    TextView tvBackAccount;
    @BindView(R.id.ll_open_error)
    LinearLayout llOpenError;
    @BindView(R.id.tv_back_account_success)
    TextView tvBackAccountSuccess;
    @BindView(R.id.ll_open_success)
    LinearLayout llOpenSuccess;
    @BindView(R.id.iv_waiting)
    ImageView ivWaiting;

    private String realName, idCard, bankName, bankPhone, cardno;
    private DialogBankSms dialogBankSms;
    private String smseq;//短信序列号
    private Handler handler = new Handler();
    private Runnable check;
    private boolean isAgree=true;
    @Override
    protected BankBindPresenter createPresenter() {
        return new BankBindPresenter(mContext);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_bind);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        tvTitle.setText("开通上海银行存管");
        etCardNo.requestFocus();
        realName = getIntent().getStringExtra("name");
        idCard = getIntent().getStringExtra("id");
        tvRealName.setText(realName);
        tvIdCard.setText(idCard);
        etCardNo.addTextChangedListener(new EditTextChangeBankCardListener(etCardNo));
        cbBindProctor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    isAgree=true;
                }else {
                    isAgree=false;
                }
            }
        });
    }

    @Override
    protected void handleMessage(Integer s) {

    }

    @OnClick({R.id.iv_finish, R.id.tv_bank_next, R.id.tv_select_bank, R.id.tv_back_account, R.id.tv_back_account_success})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_finish:
                finish();
                break;
            case R.id.tv_bank_next:
                realName = tvRealName.getText().toString();
                idCard = tvIdCard.getText().toString();
                bankName = tvBankNameLogo.getText().toString();
                bankPhone = etBankPhone.getText().toString().trim();
                cardno = etCardNo.getText().toString().replaceAll(" ","");
                if (TextUtils.isEmpty(bankName)) {
                    UIUtils.showToastCommon(mContext, "请选择银行");
                    return;
                } else if (TextUtils.isEmpty(bankPhone)) {
                    UIUtils.showToastCommon(mContext, "请填写手机号码");
                    return;
                } else if (TextUtils.isEmpty(cardno)) {
                    UIUtils.showToastCommon(mContext, "请填写银行卡号");
                    return;
                }else if(!isAgree){
                    UIUtils.showToastCommon(mContext, "请勾选服务协议");
                    return;
                }
                mPresenter.sendSms("user_register", cardno, bankPhone, "", 0);
                break;
            case R.id.tv_select_bank:
                startActivityForResult(new Intent(BankBindActivity.this, BankListActivity.class), 0x03);
                break;
            case R.id.tv_back_account:
                startActivity(MainActivity.getMainIntent(mContext, 3));
                break;
            case R.id.tv_back_account_success:
                startActivity(MainActivity.getMainIntent(mContext, 3));
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 0x03) {
            LogUtils.e("ndyb", "banklisdy");
            etCardNo.requestFocus();
            BankListBean.ModelBeanX.ModelBean model = (BankListBean.ModelBeanX.ModelBean) data.getSerializableExtra("data");
            tvBankNameLogo.setText(model.getBankName());
            Glide.with(mContext).load(model.getMapUrl()).into(ivBankLogo);
            tvLimit.setVisibility(View.VISIBLE);
            // 招商银行 单笔限额5万元，每日限额5万元
            tvLimit.setText(Html.fromHtml("<font color='#4a4a4a'>" + model.getBankName() + "单笔限额</font><font color='#ff9933'>" + model.getSingerMaxAmount() + "</font><font color='#4a4a4a4a'>元,每日限额</font><font color='#ff9933'>" + model.getSingerDayAmount() + "</font><font color='#4a4a4a'>元</font>"));
        } else {
            LogUtils.e("ndyb", "汇付返回陈宫失败");
            //上海银行界面返回
            llInputInfo.setVisibility(View.GONE);
            ivWaiting.setVisibility(View.VISIBLE);
            //延时三秒查询是否成功
            check = new Runnable() {
                @Override
                public void run() {
                    mPresenter.selectUserState(-1);
                }
            };
            handler.postDelayed(check, 3000);

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(check);
    }

    @Override
    public void showSuccessToast(String msg) {
        ivWaiting.setVisibility(View.GONE);
        llOpenSuccess.setVisibility(View.VISIBLE);
    }

    @Override
    public void showErrorToast(String msg) {
        ivWaiting.setVisibility(View.GONE);
        llOpenError.setVisibility(View.VISIBLE);
    }

    /**
     * 短信验证码弹框
     *
     * @param smsSeq
     */
    @Override
    public void showSmsDialog(final String smsSeq) {
        smseq = smsSeq;
        dialogBankSms = new DialogBankSms(BankBindActivity.this);
        dialogBankSms.setContext(bankPhone.substring(bankPhone.length() - 4, bankPhone.length())).setOnDoubleClickListener(new DialogBankSms.OnDoubleClickListener() {
            @Override
            public void executeSend() {
                dialogBankSms.getBtn().setEnabled(false);
                mPresenter.sendSms("user_register", cardno, bankPhone, "", 1);
            }

            @Override
            public void executeLeft() {

            }

            @Override
            public void executeRight(String sms) {
                mPresenter.register(bankPhone, BaseApplication.mUserName, idCard, realName, cardno, "101", "666666", "AAAAAAAA", "", "2");
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
        startActivityForResult(intent, 0);
    }
}
