package com.haolyy.compliance.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import com.haolyy.compliance.R;
import com.haolyy.compliance.utils.UIUtils;


/**
 * Created by wy on 2016/12/28
 * WeChat: wy391920778
 * Effect:
 */
public class CircleView extends View {
    private Context mContext;
    private Paint mPaint;
    /**
     * 屏幕的宽
     */
    private int mWidth;
    /**
     * 屏幕的高
     */
    private int mHeight;
    private double value;
    /**
     * 百分比
     */
    private double percentage;
    /**
     * 总值
     */
    private double sumValue;
    /**
     * 外圆半径
     */
    private int mOutRadius ;
    /**
     * 外圆的背景颜色
     */
    private  int mBgColor;
    /**
     * 圆弧的背景颜色
     */
    private  int mOutColor;
    /**
     * 内圆的背景颜色
     */
    private  int mInnerColor;
    /**
     * 内援半径
     */
    private int mInnerRadius ;
    /**
     * 外圆的宽度
     */
    private int mOutSweep;
    /**
     * 内圆的宽度
     */
    private int mInnerSweep;
    /**
     * 文本信息
     */
    private String mCircleText ;
    /**
     * 文本颜色
     */
    private int mCircleTextColor ;
    /**
     * 文本大小
     */
    private int mCircleTextSize ;
    private Rect mTextBound;
    private int[] mColors = {Color.parseColor("#80fbda61"), Color.parseColor("#80f76b1c")};
    private int[] mColors1 = {Color.parseColor("#fbda61"), Color.parseColor("#f76b1c")};
    private int[] mColors2 = {Color.parseColor("#f76b1c"), Color.parseColor("#fbda61")};

    public CircleView(Context context) {
        this(context, null);
        this.mContext = context;
    }

    public CircleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        this.mContext = context;
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CircleView, defStyleAttr, 0);
        int count = a.getIndexCount();
        for (int i = 0; i < count; i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.CircleView_bg_color:
                    mBgColor=a.getColor(attr,Color.parseColor("#cccccc"));
                    break;
                case R.styleable.CircleView_out_color:
                    mOutColor = a.getColor(attr, Color.parseColor("#E8A125"));
                    break;
                case R.styleable.CircleView_out_radius:
                    mOutRadius = a.getDimensionPixelSize(attr, UIUtils.dp2px(200,mContext));
                    break;
                case R.styleable.CircleView_inner_color:
                    mInnerColor = a.getColor(attr, Color.parseColor("#FF6601"));
                    break;
                case R.styleable.CircleView_inner_radius:
                    mInnerRadius=a.getDimensionPixelSize(attr, UIUtils.dp2px(180,mContext));
                    break;
                case R.styleable.CircleView_circle_text:
                    mCircleText = a.getString(attr);
                    break;
                case R.styleable.CircleView_circle_text_color:
                    mCircleTextColor = a.getColor(attr, Color.WHITE);
                    break;
                case R.styleable.CircleView_circle_text_size:
                    mCircleTextSize = a.getDimensionPixelSize(attr, UIUtils.sp2px(12,mContext));
                    break;
                case R.styleable.CircleView_circle_out_sweep_width:
                    mOutSweep = a.getDimensionPixelSize(attr, UIUtils.dp2px(10,mContext));
                    break;
                case R.styleable.CircleView_circle_inner_sweep_width:
                    mInnerSweep = a.getDimensionPixelSize(attr, UIUtils.dp2px(5, mContext));
                    break;
            }
        }
        a.recycle();
        mPaint = new Paint();
        mPaint.setAntiAlias(true);

        mTextBound = new Rect();
        mPaint.getTextBounds(mCircleText, 0, mCircleText.length(), mTextBound);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //获取到屏幕的宽和高
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();
        //圆心平移
        canvas.translate(mWidth / 2, mHeight / 2);
        //背景圆
        mPaint.setStyle(Paint.Style.STROKE);
//        mPaint.setColor(mBgColor);
        mPaint.setStrokeWidth(mOutSweep);
        LinearGradient shader1 = new LinearGradient(3, 3, mWidth - 3, mHeight - 3, mColors, null,
                Shader.TileMode.CLAMP);
        mPaint.setShader(shader1);
        RectF rectOut = new RectF(-mOutRadius, -mOutRadius, mOutRadius, mOutRadius);
        canvas.drawArc(rectOut, 0, 360, false, mPaint);
        //外圆
//        mPaint.setColor(mOutColor);
        percentage = value / sumValue;
        float angle = (float) (percentage * 360);                 // 对应的角度
        LinearGradient shader2 = new LinearGradient(3, 3, mWidth - 3, mHeight - 3, mColors1, null,
                Shader.TileMode.CLAMP);
        mPaint.setShader(shader2);
        canvas.drawArc(rectOut, -90, angle, false, mPaint);
//        //圆环
//        RectF rectInner = new RectF(-mInnerRadius, -mInnerRadius, mInnerRadius, mInnerRadius);
////        mPaint.setColor(mInnerColor);
//        LinearGradient shader3 = new LinearGradient(3, 3, mWidth - 3, mHeight - 3, mColors2, null,
//                Shader.TileMode.CLAMP);
//        mPaint.setShader(shader3);
//        mPaint.setStrokeWidth(mInnerSweep);
//        canvas.drawArc(rectInner, 0, 360, false, mPaint);

        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setTextSize(mCircleTextSize);
        mPaint.setColor(mCircleTextColor);
        mPaint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(mCircleText, 0, mTextBound.height(), mPaint);
        canvas.restore();
    }


    /**
     * 设置数据
     * @param value 已经购买
     * @param sumValue 总标
     */
    public void setData(double value, double sumValue) {
        this.value = value;
        this.sumValue = sumValue;
        invalidate();
    }



    public void setmCircleTextColor(int mCircleTextColor) {
        this.mCircleTextColor = mCircleTextColor;
    }


    public void setmCircleText(String mCircleText) {
        this.mCircleText = mCircleText;
    }

    public String getmCircleText() {
        return mCircleText;
    }

    public void setmOutColor(int mOutColor) {
        this.mOutColor = mOutColor;
    }
}
