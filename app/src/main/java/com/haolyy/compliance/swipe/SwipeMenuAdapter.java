package com.haolyy.compliance.swipe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.entity.my.MessageBean;
import com.haolyy.compliance.ui.my.MessageDetail;


public class SwipeMenuAdapter extends ListBaseAdapter<MessageBean.ModelBeanX.ModelBean.AccountMessagesBean> {

    public SwipeMenuAdapter(Context context) {
        super(context);

    }

    @Override
    public int getLayoutId() {
        if (mDataList.get(mPosition).getStatus() == 1) {
            return R.layout.item_list_swipe;
        } else if (mDataList.get(mPosition).getStatus() == 2) {
            return R.layout.item_list_swipe_mark;
        }
        return 0;
    }


    @Override
    public void onBindItemHolder(SuperViewHolder holder, final int position) {
        View contentView = holder.getView(R.id.swipe_content);
        Button btnDelete = holder.getView(R.id.btnDelete);
        ImageView iv = holder.getView(R.id.iv_1);
        //这句话关掉IOS阻塞式交互效果 并依次打开左滑右滑
        ((SwipeMenuView) holder.itemView).setIos(false).setLeftSwipe(true);
//        if (mDataList.get(position).getStatus() == 1) {
//            iv.setVisibility(View.INVISIBLE);
//        } else {
//            iv.setVisibility(View.GONE);
//        }

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mOnSwipeListener) {
                    //如果删除时，不使用mAdapter.notifyItemRemoved(pos)，则删除没有动画效果，
                    //且如果想让侧滑菜单同时关闭，需要同时调用 ((CstSwipeDelMenu) holder.itemView).quickClose();
                    //((CstSwipeDelMenu) holder.itemView).quickClose();
                    mOnSwipeListener.onDel(position,mDataList.get(position).getId(),3);
                }
            }
        });
        //注意事项，设置item点击，不能对整个holder.itemView设置咯，只能对第一个子View，即原来的content设置，这算是局限性吧。
        contentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDataList.get(position).getStatus() ==1) {//请求接口
                    mOnSwipeListener.modificationMessage(mDataList.get(position).getId(),2,mDataList.get(position));

                } else {
                    Intent intent = new Intent(mContext, MessageDetail.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("message", mDataList.get(position));
                    intent.putExtras(bundle);
                    mContext.startActivity(intent);
                }

            }
        });

    }

    /**
     * 和Activity通信的接口
     */
    public interface onSwipeListener {
        void onDel(int pos,int id,int status);
        void modificationMessage(int id,int status,MessageBean.ModelBeanX.ModelBean.AccountMessagesBean accountMessagesBean);

    }

    private onSwipeListener mOnSwipeListener;

    public void setOnDelListener(onSwipeListener mOnDelListener) {
        this.mOnSwipeListener = mOnDelListener;
    }


}

