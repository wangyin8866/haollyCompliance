package com.haolyy.compliance.custom;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.haolyy.compliance.R;

import java.util.List;

import static com.haolyy.compliance.R.id.viewGroup;

/**
 * Created by wangyin on 2017/6/19.
 */

public class MyPointView extends LinearLayout {
    private LinearLayout mGroup;
    private float mScale;
    private ImageView mImageView = null;
    private Context mContext;
    private ImageView[] mImageViews = null;
    private int imageCount;

    public MyPointView(Context context) {
        this(context, null);
    }

    public MyPointView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        mScale = context.getResources().getDisplayMetrics().density;
        LayoutInflater.from(context).inflate(R.layout.ad_cycle_view, this);
        mGroup = (LinearLayout) findViewById(viewGroup);

    }

    public void init(List list) {
        mGroup.removeAllViews();
        imageCount = list.size();
        if (imageCount > 1) {
            mImageViews = new ImageView[imageCount];
            for (int i = 0; i < imageCount; i++) {
                mImageView = new ImageView(mContext);
                int imageParams = (int) (mScale * 8 + 0.5f);
                int imagePadding = (int) (mScale * 4 + 0.5f);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(imageParams, imageParams);
                params.bottomMargin = imagePadding;
                params.topMargin = imagePadding;
                params.leftMargin = imagePadding;
                params.rightMargin = imagePadding;
                mImageView.setLayoutParams(params);
                mImageViews[i] = mImageView;
                if (i == 0) {
                    mImageViews[i].setBackgroundResource(R.mipmap.banner_point_checked);
                } else {
                    mImageViews[i].setBackgroundResource(R.mipmap.banner_point);
                }
                mGroup.addView(mImageViews[i]);
            }
        }
    }

    public void selectView(int current) {
        for (int i = 0; i < imageCount; i++) {
            if (i == current) {
                mImageViews[current].setBackgroundResource(R.mipmap.banner_point_checked);
            } else {
                mImageViews[i].setBackgroundResource(R.mipmap.banner_point);
            }
        }
    }
}
