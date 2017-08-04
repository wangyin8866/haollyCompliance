package com.haolyy.compliance.ui.my;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseActivity;
import com.haolyy.compliance.base.BaseApplication;
import com.haolyy.compliance.entity.my.MessageBean;
import com.haolyy.compliance.swipe.SwipeMenuAdapter;
import com.haolyy.compliance.ui.my.presenter.MessagePresenter;
import com.haolyy.compliance.ui.my.view.MessageView;
import com.haolyy.compliance.utils.AppToast;
import com.haolyy.compliance.utils.LogUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wangyin on 2017/6/6.
 */

public class MessageActivity extends BaseActivity<MessagePresenter, MessageView> implements MessageView, SwipeMenuAdapter.onSwipeListener {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_mark)
    TextView tvMark;
    @BindView(R.id.lrv_message)
    LRecyclerView mRecyclerView;
    @BindView(R.id.iv_empty)
    ImageView ivEmpty;


    /**已经获取到多少条数据了*/
    private static int mCurrentCounter = 0;
    private SwipeMenuAdapter mDataAdapter = null;

    private LRecyclerViewAdapter mLRecyclerViewAdapter = null;

    private boolean isRefresh = false;
    MessageBean messageBean;
    private int pageNum = 1;
    private int pageSize;
    private List<MessageBean.ModelBeanX.ModelBean.AccountMessagesBean> accountMessagesBeanList;


    @Override
    protected MessagePresenter createPresenter() {
        return new MessagePresenter(mContext);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        ButterKnife.bind(this);
        mRecyclerView.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                pageNum = 1;
                mDataAdapter.clear();
                mLRecyclerViewAdapter.notifyDataSetChanged();//fix bug:crapped or attached views may not be recycled. isScrap:false isAttached:true
                isRefresh = true;
                mPresenter.getMessage("1", false);
            }
        });
        mRecyclerView.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                pageNum += 1;
                mPresenter.getMessage(pageNum + "", true);


            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.getMessage("1", false);
    }

    @Override
    protected void handleMessage(Integer s) {

    }


    @OnClick({R.id.iv_back, R.id.tv_mark})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_mark:
                mPresenter.modificationStatus(BaseApplication.userId, 2);
                break;
        }
    }

    @Override
    public void showData(MessageBean messageBean) {
        this.messageBean = messageBean;
        accountMessagesBeanList = messageBean.getModel().getModel().getAccountMessages();
        pageSize = accountMessagesBeanList.size();
        if (pageSize == 0) {
            mRecyclerView.setPullRefreshEnabled(false);
            ivEmpty.setVisibility(View.VISIBLE);
            mRecyclerView.setVisibility(View.GONE);
        } else {
            mCurrentCounter = pageSize;
            ivEmpty.setVisibility(View.GONE);
            mRecyclerView.setVisibility(View.VISIBLE);
            mDataAdapter = new SwipeMenuAdapter(this);
            mDataAdapter.setDataList(accountMessagesBeanList);
            mDataAdapter.setOnDelListener(this);
            mLRecyclerViewAdapter = new LRecyclerViewAdapter(mDataAdapter);
            mRecyclerView.setAdapter(mLRecyclerViewAdapter);

            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

            mRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
            mRecyclerView.setArrowImageView(R.drawable.ic_pulltorefresh_arrow);
            mLRecyclerViewAdapter.removeFooterView();
            if (pageSize < 10) {
                mRecyclerView.setLoadMoreEnabled(false);
                mRecyclerView.setNoMore(true);
            } else {
                mRecyclerView.setLoadMoreEnabled(true);
                mRecyclerView.setNoMore(false);
            }
            complete();
        }

    }

    @Override
    public void showGetMoreData(MessageBean messageBean) {
        LogUtils.e("showGetMoreData", messageBean.toString());
        if (messageBean.getModel().getModel().getAccountMessages().size() == 0) {
            pageNum = 1;
            AppToast.makeShortToast(mContext, "没有数据了");
            mRecyclerView.setLoadMoreEnabled(false);
            mRecyclerView.setNoMore(true);
        } else {
            mRecyclerView.setLoadMoreEnabled(true);
            mRecyclerView.setNoMore(false);
            mCurrentCounter += messageBean.getModel().getModel().getAccountMessages().size();
            this.messageBean.getModel().getModel().getAccountMessages().addAll(messageBean.getModel().getModel().getAccountMessages());
            mDataAdapter = new SwipeMenuAdapter(this);
            mDataAdapter.setDataList(accountMessagesBeanList);
            mDataAdapter.setOnDelListener(this);
            mLRecyclerViewAdapter = new LRecyclerViewAdapter(mDataAdapter);
            mRecyclerView.setAdapter(mLRecyclerViewAdapter);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            mRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
            mRecyclerView.setArrowImageView(R.drawable.ic_pulltorefresh_arrow);
            mLRecyclerViewAdapter.removeFooterView();
            //定位
            MoveToPosition(new LinearLayoutManager(this), mRecyclerView, this.messageBean.getModel().getModel().getAccountMessages().size() - messageBean.getModel().getModel().getAccountMessages().size());
            complete();
        }
    }

    /**
     * 刷新结束调用
     */
    private void complete() {
        LogUtils.e("mCurrentCounter",mCurrentCounter+"");
        mRecyclerView.refreshComplete(mCurrentCounter);
        mLRecyclerViewAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDel(int pos, int id, int status) {

        mPresenter.deleteMessage(pos, id, status, mDataAdapter);

    }

    @Override
    public void modificationMessage(int id, int status, MessageBean.ModelBeanX.ModelBean.AccountMessagesBean accountMessagesBean) {
        mPresenter.modificationStatus(id, status, accountMessagesBean);
    }

    /**
     * RecyclerView 移动到当前位置，
     *
     * @param manager       设置RecyclerView对应的manager
     * @param mRecyclerView 当前的RecyclerView
     * @param n             要跳转的位置
     */
    private void MoveToPosition(LinearLayoutManager manager, RecyclerView mRecyclerView, int n) {


        int firstItem = manager.findFirstVisibleItemPosition();
        int lastItem = manager.findLastVisibleItemPosition();
        if (n <= firstItem) {
            mRecyclerView.scrollToPosition(n);
        } else if (n <= lastItem) {
            int top = mRecyclerView.getChildAt(n - firstItem).getTop();
            mRecyclerView.scrollBy(0, top);
        } else {
            mRecyclerView.scrollToPosition(n);
        }

    }
}