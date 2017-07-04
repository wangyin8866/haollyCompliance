package com.haolyy.compliance.ui.bank;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseActivity;
import com.haolyy.compliance.custom.ClearEditText;
import com.haolyy.compliance.ui.bank.presenter.RebindBankPresenter;
import com.haolyy.compliance.ui.bank.view.BankReBindView;
import com.haolyy.compliance.utils.DateUtil;
import com.haolyy.compliance.utils.UIUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscription;

/**
 * 解绑与换绑共享页面
 */
public class RebindBankActivity extends BaseActivity<RebindBankPresenter, BankReBindView> implements BankReBindView {

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
    @BindView(R.id.tv_bank_name)
    TextView tvBankName;
    @BindView(R.id.tv_card_type)
    TextView tvCardType;
    @BindView(R.id.tv_card_no)
    TextView tvCardNo;
    @BindView(R.id.rl_rebind)
    RelativeLayout rlRebind;
    @BindView(R.id.iv_bank_logo)
    ImageView ivBankLogo;
    @BindView(R.id.tv_bank_name_logo)
    TextView tvBankNameLogo;
    @BindView(R.id.tv_select_bank)
    TextView tvSelectBank;
    @BindView(R.id.et_card_no)
    ClearEditText etCardNo;
    @BindView(R.id.ll_rebind)
    LinearLayout llRebind;
    @BindView(R.id.et_rebind_phone)
    ClearEditText etRebindPhone;
    @BindView(R.id.et_rebind_sms)
    ClearEditText etRebindSms;
    @BindView(R.id.tv_rebind_sms)
    TextView tvRebindSms;
    @BindView(R.id.btn_rebind)
    TextView btnRebind;
    private boolean isNew = false;
    private String smsSqOld, smsOald, smsNew, smsSqnew;
    private String rebindPhone;
    private Subscription subscriptionCount;

    @Override
    protected RebindBankPresenter createPresenter() {
        return new RebindBankPresenter(mContext);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rebind_bank);
        ButterKnife.bind(this);
    }

    @Override
    protected void handleMessage(Integer s) {

    }

    @OnClick({R.id.iv_finish, R.id.tv_select_bank, R.id.tv_rebind_sms, R.id.btn_rebind})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_finish:
                finish();
                break;
            case R.id.tv_select_bank:
                startActivityForResult(new Intent(mContext, BankListActivity.class), 0x03);
                break;
            case R.id.tv_rebind_sms:
                rebindPhone = etRebindPhone.getText().toString();
                if (TextUtils.isEmpty(rebindPhone)) {
                    UIUtils.showToastCommon(mContext, "手机号不能为空");
                    return;
                }
                if (isNew) {
                    mPresenter.sendSms("rebind", "6225801240710012", "6000060007303359", "2", "13821882946", "N");
                } else {
                    mPresenter.sendSms("rebind", "6225801240710011", "6000060007303359", "2", "13821882946", "O");
                }
                tvRebindSms.setEnabled(false);//发短信按钮不可点击
                break;
            case R.id.btn_rebind:
                rebindPhone = etRebindPhone.getText().toString();
                String sms = etRebindSms.getText().toString();
                if (TextUtils.isEmpty(rebindPhone)) {
                    UIUtils.showToastCommon(mContext, "手机号不能为空");
                    return;
                }
                if (TextUtils.isEmpty(sms)) {
                    UIUtils.showToastCommon(mContext, "短信验证码不能为空");
                    return;
                }
                if (isNew) {
                    //换绑页面
                    smsNew = sms;
                    mPresenter.quikBind("6000060007303359","REBIND","CMB","6225801240710012","13821882946","666666","AAAAAAAA","666666AAAAAAAA","1");
                } else {
                    //解绑页面
                    smsOald = sms;
                    etRebindSms.getText().clear();
                    etRebindPhone.getText().clear();
                    subscriptionCount.unsubscribe();
                    tvRebindSms.setEnabled(true);
                    tvRebindSms.setText("发送验证码");
                    rlRebind.setVisibility(View.GONE);
                    llRebind.setVisibility(View.VISIBLE);
                    btnRebind.setText("完成");
                    tvTitle.setText("绑定新的银行卡");
                    isNew=true;
                }
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
        }
    }

    @Override
    public void showSuccessToast(String msg) {

    }

    @Override
    public void showErrorToast(String msg) {

    }

    @Override
    public void countDown(String smsSeq, boolean b) {
        if (b) {
            //短信发送失败，让按钮重新可点击
            tvRebindSms.setEnabled(true);
        } else {
            //发送成功开始倒计时
            subscriptionCount = DateUtil.countDown(tvRebindSms, "重新发送");
            if (isNew) {
                smsSqnew = smsSeq;
            } else {
                smsSqOld = smsSeq;
            }
        }
    }
}
