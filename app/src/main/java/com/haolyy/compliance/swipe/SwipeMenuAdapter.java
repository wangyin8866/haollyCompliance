package com.haolyy.compliance.swipe;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.entity.ItemModel;
import com.haolyy.compliance.ui.my.MessageDetail;
import com.haolyy.compliance.utils.AppToast;
import com.haolyy.compliance.utils.LogUtils;


public class SwipeMenuAdapter extends ListBaseAdapter<ItemModel> {
    public SwipeMenuAdapter(Context context) {
        super(context);

    }

    @Override
    public int getLayoutId() {
   return R.layout.item_list_swipe;
       /* if (mDataList.get(mPosition).isMark) {
            return R.layout.item_list_swipe;
        } else {
            return R.layout.item_list_swipe_mark;
        }*/
    }

    @Override
    public void onBindItemHolder(SuperViewHolder holder, final int position) {
        LogUtils.e("isMark"+position+mDataList.get(position).isMark+"size"+mDataList.size());
        View contentView = holder.getView(R.id.swipe_content);

         Button btnDelete = holder.getView(R.id.btnDelete);
         ImageView iv= holder.getView(R.id.iv_1);
        //这句话关掉IOS阻塞式交互效果 并依次打开左滑右滑
        ((SwipeMenuView)holder.itemView).setIos(false).setLeftSwipe(true);
        if(mDataList.get(position).isMark){
            iv.setVisibility(View.VISIBLE);
        }else {
            iv.setVisibility(View.GONE);
        }
//        title.setText(getDataList().get(position).isMark+"");


        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mOnSwipeListener) {
                    //如果删除时，不使用mAdapter.notifyItemRemoved(pos)，则删除没有动画效果，
                    //且如果想让侧滑菜单同时关闭，需要同时调用 ((CstSwipeDelMenu) holder.itemView).quickClose();
                    //((CstSwipeDelMenu) holder.itemView).quickClose();
                    mOnSwipeListener.onDel(position);
                }
            }
        });
        //注意事项，设置item点击，不能对整个holder.itemView设置咯，只能对第一个子View，即原来的content设置，这算是局限性吧。
        contentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppToast.makeShortToast(mContext, getDataList().get(position).title);
                Log.d("TAG", "onClick() called with: v = [" + v + "]");
                mContext.startActivity(new Intent(mContext, MessageDetail.class));
            }
        });

    }

    /**
     * 和Activity通信的接口
     */
    public interface onSwipeListener {
        void onDel(int pos);


    }

    private onSwipeListener mOnSwipeListener;

    public void setOnDelListener(onSwipeListener mOnDelListener) {
        this.mOnSwipeListener = mOnDelListener;
    }


}

