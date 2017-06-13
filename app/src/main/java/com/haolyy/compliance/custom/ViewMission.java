package com.haolyy.compliance.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.utils.UIUtils;

/**
 * Created by niudeyang on 2017/6/13.
 */

public class ViewMission extends RelativeLayout {
    private ViewMission instance;
    private View view;
    private ImageView imageView;
    private TextView title;
    private TextView description;
    private TextView btn;

    private String t;//title文字
    private String d;//描述文字
    private String b;//按钮文字
    private Drawable bi;//按钮背景
    private Drawable ic;//icon
    private Drawable bg;

    public ViewMission(Context context) {
        super(context);
    }

    public ViewMission(Context context, AttributeSet attrs) {
        super(context, attrs);
        instance = this;
        view = View.inflate(context, R.layout.view_mission_item, null);
        this.addView(view);
        imageView = (ImageView) view.findViewById(R.id.iv_mission);
        title = (TextView) view.findViewById(R.id.tv_mission_title);
        btn = (TextView) view.findViewById(R.id.mission_btn);
        description = (TextView) view.findViewById(R.id.tv_mission_description);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ViewMission);
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.ViewMission_btn:
                    b = a.getString(attr);
                    break;
                case R.styleable.ViewMission_btn_bg:
                    bi = a.getDrawable(attr);
                    break;
                case R.styleable.ViewMission_description_mission:
                    d = a.getString(attr);
                    break;
                case R.styleable.ViewMission_title_mission:
                    t = a.getString(attr);
                    break;
                case R.styleable.ViewMission_icon_mission:
                    ic = a.getDrawable(attr);
                    break;
                case R.styleable.ViewMission_mission_bg:
                    bg = a.getDrawable(attr);
            }

        }
        a.recycle();
        view.setBackground(bg);
        imageView.setImageDrawable(ic);
        title.setText(t);
        description.setText(d);
        btn.setText(b);
        btn.setBackground(bi);
    }

    public ViewMission setBtnText(String text) {
        btn.setText(text);
        return instance;
    }

    public ViewMission setgray() {
        view.setBackground(UIUtils.getDrawable(R.drawable.shape_transparent_gray));
        btn.setBackground(UIUtils.getDrawable(R.mipmap.have_complete));
        title.setTextColor(UIUtils.getColor(R.color.text_b9b9b9));
        description.setTextColor(UIUtils.getColor(R.color.text_b9b9b9));
        return instance;
    }

    public ViewMission setIcon(Drawable drawable) {
        imageView.setImageDrawable(drawable);
        return instance;
    }
}
