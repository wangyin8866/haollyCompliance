package com.haolyy.compliance.ui.bank;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.adapter.GridAdapter;
import com.haolyy.compliance.base.ActivityCollector;
import com.haolyy.compliance.base.BaseActivity;
import com.haolyy.compliance.base.BaseView;
import com.haolyy.compliance.entity.bank.BankListBean;
import com.haolyy.compliance.ui.bank.presenter.BankListPresenter;
import com.haolyy.compliance.ui.bank.view.BanklistView;
import com.haolyy.compliance.utils.UIUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class BankListActivity extends BaseActivity<BankListPresenter,BanklistView> implements BanklistView {
    @BindView(R.id.iv_finish)
    ImageView ivFinish;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.view_line)
    View viewLine;
    @BindView(R.id.recycle_view_bank)
    RecyclerView recycleView;
    @BindView(R.id.titleBar)
    RelativeLayout titleBar;
    private List<BankListBean.ModelBeanX.ModelBean> bankList = new ArrayList<>();
    private GridAdapter gridAdapter;

    @Override
    protected BankListPresenter createPresenter() {
        return new BankListPresenter(mContext);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_list);
        ButterKnife.bind(this);
        ActivityCollector.addActivity(this);
        mPresenter.getBankList();
    }

    @Override
    protected void handleMessage(Integer s) {

    }

    private void initGridView() {
        tvTitle.setText("银行列表");
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleView.setLayoutManager(layoutManager);
        recycleView.setHasFixedSize(true);
        gridAdapter = new GridAdapter(this, bankList);
        recycleView.setAdapter(gridAdapter);
        gridAdapter.setOnRecyclerViewItemClickListener(new GridAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int data) {
                setResult(0x03, new Intent().putExtra("data", bankList.get(data)));
                finish();
            }
        });
    }

    @OnClick(R.id.iv_finish)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void showList(List<BankListBean.ModelBeanX.ModelBean> model) {
        bankList=model;
        initGridView();
    }
}



