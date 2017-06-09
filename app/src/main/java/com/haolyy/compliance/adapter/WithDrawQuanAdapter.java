package com.haolyy.compliance.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.entity.Repayment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.haolyy.compliance.R.id.tv_quan_rate;

/**
 * Created by niudeyang on 2017/5/18.
 */

public class WithDrawQuanAdapter extends BaseAdapter {
    private Context mContext;
    private List<Integer> repayments;
    private Map<Integer, Boolean> map = new HashMap();
    public WithDrawQuanAdapter(Context context, List<Integer> repayments, int type) {
        this.mContext = context;
        this.repayments = repayments;
        for (int i = 0; i < repayments.size(); i++) {
            map.put(i, false);
        }
    }

    @Override
    public int getCount() {
        return repayments.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        QuansHolder quansHolder = null;
        if (convertView == null) {
            quansHolder = new QuansHolder();
            convertView = quansHolder.itemView;
            convertView.setTag(quansHolder);
        } else {
            quansHolder = (QuansHolder) convertView.getTag();
        }
        quansHolder.setData(repayments.get(position));
        final QuansHolder finalQuansHolder = quansHolder;
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (map.get(position)) {
                    map.put(position, false);
                    setMapc(map);
                    finalQuansHolder.mIv_quan_select.setVisibility(View.INVISIBLE);
                } else {
                    map.put(position, true);
                    setMapc(map);
                    finalQuansHolder.mIv_quan_select.setVisibility(View.VISIBLE);
                }
            }
        });
        if (map.get(position)) {
            quansHolder.mIv_quan_select.setVisibility(View.VISIBLE);
        } else {
            quansHolder.mIv_quan_select.setVisibility(View.INVISIBLE);
        }
        return convertView;
    }

    private void setMapc(Map<Integer, Boolean> mapc) {
        map = mapc;
    }

    public class QuansHolder {
        View itemView;
        public ImageView mIv_quan_select;
        TextView mTv_quan_range;
        TextView mTv_quan_time;

        public QuansHolder() {
            itemView = View.inflate(mContext, R.layout.item_withdraw_quan, null);
            mIv_quan_select = (ImageView) itemView.findViewById(R.id.iv_quan_select);
            mTv_quan_range = (TextView) itemView.findViewById(R.id.tv_quan_range);
            mTv_quan_time = (TextView) itemView.findViewById(R.id.tv_quan_time);
        }

        public void setData(Integer repayment) {

        }
    }
}

