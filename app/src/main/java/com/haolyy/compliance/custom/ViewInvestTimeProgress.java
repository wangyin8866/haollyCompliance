package com.haolyy.compliance.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.utils.UIUtils;

/**
 * 详情页投资进度图
 * Created by NIUDEYANG on 2016/7/14.
 */
public class ViewInvestTimeProgress extends LinearLayout {
    private static final int TIMECOLOR = UIUtils.getColor(R.color.bg_ff9933);
    ImageView mInvestemnt_step_iv1;//圆圈1
    View mInvestemnt_time_v1;//线1
    ImageView mInvestemnt_step_iv2;
    View mInvestemnt_time_v2;
    ImageView mInvestemnt_step_iv3;
    View mInvestemnt_time_v3;
    ImageView mInvestemnt_step_iv4;
    private View view;
    private TextView mInvestemnt_step_tv1;//起售日文本
    private TextView mInvestemnt_step_tv2;
    private TextView mInvestemnt_step_tv3;
    private TextView mInvestemnt_step_tv4;


    public ViewInvestTimeProgress(Context context) {
        super(context);
    }

    public ViewInvestTimeProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
        view = View.inflate(context, R.layout.view_investment_time, null);
        this.addView(view);
        bindViews();
    }

    public ViewInvestTimeProgress(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void bindViews() {
        mInvestemnt_step_iv1 = (ImageView) view.findViewById(R.id.investemnt_step_iv1);
        mInvestemnt_time_v1 = view.findViewById(R.id.investemnt_time_v1);
        mInvestemnt_step_iv2 = (ImageView) view.findViewById(R.id.investemnt_step_iv2);
        mInvestemnt_time_v2 = view.findViewById(R.id.investemnt_time_v2);
        mInvestemnt_step_iv3 = (ImageView) view.findViewById(R.id.investemnt_step_iv3);
        mInvestemnt_time_v3 = view.findViewById(R.id.investemnt_time_v3);
        mInvestemnt_step_iv4 = (ImageView) view.findViewById(R.id.investemnt_step_iv4);
        mInvestemnt_step_tv1 = (TextView) view.findViewById(R.id.investemnt_step_tv1);
        mInvestemnt_step_tv2 = (TextView) view.findViewById(R.id.investemnt_step_tv2);
        mInvestemnt_step_tv3 = (TextView) view.findViewById(R.id.investemnt_step_tv3);
        mInvestemnt_step_tv4 = (TextView) view.findViewById(R.id.investemnt_step_tv4);
    }
   public void setDateText(String t1, String t2, String t3, String t4){
       mInvestemnt_step_tv1.setText(t1);
       mInvestemnt_step_tv2.setText(t2);
       mInvestemnt_step_tv3.setText(t3);
       mInvestemnt_step_tv4.setText(t4);
   }
    public void setTimeProgress(int timeProgress) {
        switch (timeProgress) {
            case 0:
                mInvestemnt_step_iv1.setImageDrawable(getResources().getDrawable(R.mipmap.time_progress_orange));
                mInvestemnt_step_tv1.setTextColor(TIMECOLOR);
                break;
            case 1:
                mInvestemnt_step_iv1.setImageDrawable(getResources().getDrawable(R.mipmap.time_progress_orange));
                mInvestemnt_step_iv2.setImageDrawable(getResources().getDrawable(R.mipmap.time_progress_orange));
                mInvestemnt_time_v1.setBackgroundColor(TIMECOLOR);
                mInvestemnt_step_tv2.setActivated(true);
             
                break;
            case 3:
                mInvestemnt_step_iv1.setImageDrawable(getResources().getDrawable(R.mipmap.time_progress_orange));
                mInvestemnt_step_iv2.setImageDrawable(getResources().getDrawable(R.mipmap.time_progress_orange));
                mInvestemnt_step_iv3.setImageDrawable(getResources().getDrawable(R.mipmap.time_progress_orange));
                mInvestemnt_time_v1.setBackgroundColor(TIMECOLOR);
                mInvestemnt_time_v2.setBackgroundColor(TIMECOLOR);
                mInvestemnt_step_tv3.setActivated(true);
               
                break;
            case 4:
                mInvestemnt_step_iv1.setImageDrawable(getResources().getDrawable(R.mipmap.time_progress_orange));
                mInvestemnt_step_iv2.setImageDrawable(getResources().getDrawable(R.mipmap.time_progress_orange));
                mInvestemnt_step_iv3.setImageDrawable(getResources().getDrawable(R.mipmap.time_progress_orange));
                mInvestemnt_step_iv3.setImageDrawable(getResources().getDrawable(R.mipmap.time_progress_orange));
                mInvestemnt_time_v1.setBackgroundColor(TIMECOLOR);
                mInvestemnt_time_v2.setBackgroundColor(TIMECOLOR);
                mInvestemnt_time_v3.setBackgroundColor(TIMECOLOR);
                mInvestemnt_step_tv4.setActivated(true);
                break;


        }
    }
}
