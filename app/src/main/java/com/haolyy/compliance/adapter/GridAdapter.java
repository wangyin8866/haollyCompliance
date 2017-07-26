package com.haolyy.compliance.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.haolyy.compliance.R;
import com.haolyy.compliance.entity.bank.BankListBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by niudeyang on 2017/5/25.
 */

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ListHolder> {

    private Context mContext;
    private List<BankListBean.ModelBeanX.ModelBean> datas = new ArrayList<>();

    public GridAdapter(Context context, List list) {
        this.mContext = context;
        this.datas = list;
    }

    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_bank, parent, false);
        ListHolder listHolder = new ListHolder(view);
        return listHolder;
    }


    @Override
    public void onBindViewHolder(final ListHolder holder, final int position) {
        holder.setData(position);

        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClick(v, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, int data);
    }

    public void setOnRecyclerViewItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    class ListHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView logo;

        public ListHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_bank_item);
            logo = (ImageView) itemView.findViewById(R.id.iv_bank_logo);
        }

        public void setData(int position) {
            name.setText(datas.get(position).getBankName());
            Glide.with(mContext).load(datas.get(position).getMapUrl()).into(logo);
        }

    }
}