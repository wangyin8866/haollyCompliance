package com.haolyy.compliance.ui.bank;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseActivity;
import com.haolyy.compliance.custom.dialog.WithDrawPopupWindow;
import com.haolyy.compliance.ui.bank.presenter.WithDrawPresenter;
import com.haolyy.compliance.ui.bank.view.WithDrawView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class WithDrawActivity extends BaseActivity<WithDrawPresenter, WithDrawView> implements WithDrawView {

    @BindView(R.id.iv_finish)
    ImageView ivFinish;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_bank_name)
    TextView tvBankName;
    @BindView(R.id.tv_card_type)
    TextView tvCardType;
    @BindView(R.id.tv_card_no)
    TextView tvCardNo;
    @BindView(R.id.btn_withdraw)
    TextView btnWithdraw;
    @BindView(R.id.tv_total_withdraw)
    TextView tvTotalWithdraw;
    @BindView(R.id.tv_withdraw_quan)
    TextView tvWithdrawQuan;
    private static WithDrawPopupWindow menuWindow;
    @BindView(R.id.tv_withdraw_way)
    TextView tvWithdrawWay;
    @BindView(R.id.view_line)
    View viewLine;
    @Override
    protected WithDrawPresenter createPresenter() {
        return new WithDrawPresenter(mContext);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_draw);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    protected void handleMessage(Integer s) {

    }

    private void initView() {
        tvTitle.setText("提现");
        tvWithdrawQuan.setText(Html.fromHtml("<font color='#4a4a4a'>未使用</font><font color='#ff9933'>(1)</font>"));
    }

    @OnClick({R.id.iv_finish, R.id.btn_withdraw, R.id.tv_withdraw_quan, R.id.tv_withdraw_way})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_finish:
                finish();
                break;
            case R.id.btn_withdraw:
                mPresenter.withDraw("1", "6000060007303359", "13821882946", "1000","1");
                break;
            case R.id.tv_withdraw_quan:
                startActivity(new Intent(WithDrawActivity.this, WithDrawQuanActivity.class));
                break;
            case R.id.tv_withdraw_way:
                popupWindow(mContext,viewLine);
                break;
        }
    }

    /**
     * 客服弹出框
     *
     * @param context
     * @param view
     */
    public static void popupWindow(final Context context, View view) {
        menuWindow = new WithDrawPopupWindow(context, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuWindow.dismiss();
                switch (v.getId()) {
                    case R.id.tv_normal_withdraw:
                        //选则正常1有提现券

                        break;
                    case R.id.tv_fast_withdraw:
                         //及时提现2无提现券
                        break;
                }
            }
        });
        menuWindow.showAtLocation(view, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
    }

    @Override
    public void pushActivity(String baseResponseBean) {
        Intent intent = new Intent(mContext, ShBankWebActivity.class);
        intent.setAction(baseResponseBean);
        startActivity(intent);
    }
}
