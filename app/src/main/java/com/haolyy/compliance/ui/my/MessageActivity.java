package com.haolyy.compliance.ui.my;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.github.jdsjlzx.util.RecyclerViewStateUtils;
import com.github.jdsjlzx.view.LoadingFooter;
import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseActivity;
import com.haolyy.compliance.entity.my.MessageBean;
import com.haolyy.compliance.swipe.SwipeMenuAdapter;
import com.haolyy.compliance.ui.my.presenter.MessagePresenter;
import com.haolyy.compliance.ui.my.view.MessageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wangyin on 2017/6/6.
 */

public class MessageActivity extends BaseActivity<MessagePresenter,MessageView>implements MessageView  {
    private static final String TAG = "lzx";

    /**
     * 服务器端一共多少条数据
     */
    private static final int TOTAL_COUNTER = 64;

    /**
     * 每一页展示多少条数据
     */
    private static final int REQUEST_COUNT = 10;

    /**
     * 已经获取到多少条数据了
     */
    private static int mCurrentCounter = 0;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_mark)
    TextView tvMark;
    @BindView(R.id.lrv_message)
    LRecyclerView lrvMessage;

    private LRecyclerView mRecyclerView = null;

    private SwipeMenuAdapter mDataAdapter = null;

    private LRecyclerViewAdapter mLRecyclerViewAdapter = null;

    private boolean isRefresh = false;
    private List<MessageBean.ModelBeanX.ModelBean.AccountMessagesBean> accountMessagesBeanList;
    private int pageIndex=0;
    @Override
    protected MessagePresenter createPresenter() {
        return new MessagePresenter(mContext);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        ButterKnife.bind(this);

        mPresenter.getMessage(pageIndex+"");

        mRecyclerView = (LRecyclerView) findViewById(R.id.lrv_message);


    }

    @Override
    protected void handleMessage(Integer s) {

    }

    private void notifyDataSetChanged() {
        mLRecyclerViewAdapter.notifyDataSetChanged();
    }

    private void addItems(ArrayList<MessageBean.ModelBeanX.ModelBean.AccountMessagesBean> list) {

        mDataAdapter.addAll(list);
        mCurrentCounter += list.size();

    }

    @OnClick({R.id.iv_back, R.id.tv_mark})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_mark:
                break;
        }
    }

    @Override
    public void showData(MessageBean messageBean) {
        accountMessagesBeanList =  messageBean.getModel().getModel().getAccountMessages();
        mDataAdapter = new SwipeMenuAdapter(this);
        mDataAdapter.setDataList(accountMessagesBeanList);
        mDataAdapter.setOnDelListener(new SwipeMenuAdapter.onSwipeListener() {
            @Override
            public void onDel(int pos) {
                Toast.makeText(MessageActivity.this, "删除:" + pos, Toast.LENGTH_SHORT).show();

                //RecyclerView关于notifyItemRemoved的那点小事 参考：http://blog.csdn.net/jdsjlzx/article/details/52131528
                mDataAdapter.getDataList().remove(pos);
                mDataAdapter.notifyItemRemoved(pos);//推荐用这个

                if (pos != (mDataAdapter.getDataList().size())) { // 如果移除的是最后一个，忽略 注意：这里的mDataAdapter.getDataList()不需要-1，因为上面已经-1了
                    mDataAdapter.notifyItemRangeChanged(pos, mDataAdapter.getDataList().size() - pos);
                }
                //且如果想让侧滑菜单同时关闭，需要同时调用 ((CstSwipeDelMenu) holder.itemView).quickClose();
            }


        });
        mLRecyclerViewAdapter = new LRecyclerViewAdapter(mDataAdapter);
        mRecyclerView.setAdapter(mLRecyclerViewAdapter);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setArrowImageView(R.drawable.ic_pulltorefresh_arrow);

//        mLRecyclerViewAdapter.addHeaderView(new SampleHeader(this));//添加头部布局



        mRecyclerView.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                mDataAdapter.clear();
                mLRecyclerViewAdapter.notifyDataSetChanged();//fix bug:crapped or attached views may not be recycled. isScrap:false isAttached:true
                mCurrentCounter = 0;
                isRefresh = true;
               mPresenter.getMessage(pageIndex+"");
            }
        });
        mRecyclerView.refresh();
    }


    private View.OnClickListener mFooterClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RecyclerViewStateUtils.setFooterViewState(MessageActivity.this, mRecyclerView, REQUEST_COUNT, LoadingFooter.State.Loading, null);
        }
    };

}