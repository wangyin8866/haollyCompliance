package com.haolyy.compliance.ui.bank;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseActivity;
import com.haolyy.compliance.custom.ClearEditText;
import com.haolyy.compliance.entity.bank.BankListBean;
import com.haolyy.compliance.entity.login.UserBaseInfoBean;
import com.haolyy.compliance.ui.bank.presenter.RebindBankPresenter;
import com.haolyy.compliance.ui.bank.view.BankReBindView;
import com.haolyy.compliance.utils.DateUtil;
import com.haolyy.compliance.utils.UIUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscription;

import static com.haolyy.compliance.base.BaseApplication.context;

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
    EditText etRebindPhone;
    @BindView(R.id.et_rebind_sms)
    EditText etRebindSms;
    @BindView(R.id.tv_rebind_sms)
    TextView tvRebindSms;
    @BindView(R.id.btn_rebind)
    TextView btnRebind;
    @BindView(R.id.iv_bank)
    ImageView ivBank;
    private boolean isNew = false;
    private String smsSqOld, smsOald, smsNew, smsSqnew;
    private String rebindPhone;
    private Subscription subscriptionCount;
    private String mobile;
    private String bank_card_no;
    private String newCardNo;
    private String bankNo = "";

    @Override
    protected RebindBankPresenter createPresenter() {
        return new RebindBankPresenter(mContext);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rebind_bank);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        etRebindPhone.setEnabled(false);
        tvTitle.setText("解绑银行卡");
        mPresenter.selectUserBaseInfo();
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
                if (isNew) {
                    rebindPhone = etRebindPhone.getText().toString();
                    newCardNo = etCardNo.getText().toString();
                    if (TextUtils.isEmpty(rebindPhone)) {
                        UIUtils.showToastCommon(mContext, "手机号不能为空");
                        return;
                    }
                    if (TextUtils.isEmpty(newCardNo)) {
                        UIUtils.showToastCommon(mContext, "银行卡号不能为空");
                        return;
                    }
                    mPresenter.sendSms("rebind", newCardNo, rebindPhone, "N");
                } else {
                    mPresenter.sendSms("rebind", getIntent().getStringExtra("bank"), mobile, "O");
                }
                tvRebindSms.setEnabled(false);//发短信按钮不可点击
                break;
            case R.id.btn_rebind:
                etRebindPhone.clearFocus();
                etCardNo.clearFocus();
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
                    newCardNo = etCardNo.getText().toString();
                    if (TextUtils.isEmpty(newCardNo)) {
                        UIUtils.showToastCommon(mContext, "银行卡号不能为空");
                        return;
                    }
                    mPresenter.quikBind("REBIND", bankNo, newCardNo, rebindPhone, "666666", "AAAAAAAA", "666666AAAAAAAA");
                } else {
                    //解绑页面
                    smsOald = sms;
                    etRebindSms.getText().clear();
                    etRebindPhone.getText().clear();
                    etRebindPhone.setEnabled(true);
                    subscriptionCount.unsubscribe();
                    tvRebindSms.setEnabled(true);
                    tvRebindSms.setText("发送验证码");

                    rlRebind.setVisibility(View.GONE);
                    llRebind.setVisibility(View.VISIBLE);
                    btnRebind.setText("完成");
                    tvTitle.setText("绑定新的银行卡");
                    isNew = true;
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (null != data) {
            etCardNo.requestFocus();
            BankListBean.ModelBeanX.ModelBean model = (BankListBean.ModelBeanX.ModelBean) data.getSerializableExtra("data");
            bankNo = model.getBankNo();
            tvBankNameLogo.setText(model.getBankName());
            Glide.with(mContext).load(model.getMapUrl()).into(ivBankLogo);
        }
    }

    @Override
    public void showSuccessToast(String msg) {
        finish();
        UIUtils.showToastCommon(mContext, msg);
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
            etRebindSms.setEnabled(true);
            etRebindSms.requestFocus();
            subscriptionCount = DateUtil.countDown(tvRebindSms, "重新发送");
            if (isNew) {
                smsSqnew = smsSeq;
            } else {
                smsSqOld = smsSeq;
            }
        }
    }

    /**
     * 卡号 老的手机号
     *
     * @param fb
     */
    @Override
    public void setCardInfo(UserBaseInfoBean fb) {
        mobile = fb.getModel().getMobile();
        bank_card_no = fb.getModel().getBankCardNo();
        tvCardNo.setText(bank_card_no);
        tvBankName.setText(fb.getModel().getBankName());
        Glide.with(context).load(fb.getModel().getMapUrl()).into(ivBank);
        etRebindPhone.setText(mobile);
    }
}
