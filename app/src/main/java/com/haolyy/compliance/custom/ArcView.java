package com.haolyy.compliance.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.haolyy.compliance.R;
import com.haolyy.compliance.utils.UIUtils;


/**
 * Created by wy on 2017/1/3.
 */

public class ArcView extends View {
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
     * 外圆底色
     */
    private int mBgColor;
    /**
     * 外圆颜色，扫过的颜色
     */
    private int mOutColor;
    /**
     * 小原点的颜色
     */
    private int mLittleColor;
    /**
     * 外圆的半径
     */
    private int mOutRadius;
    /**
     * 小圆点的半径
     */
    private int mLittleRadius;
    /**
     * 起始地角度
     */
    private int startAngle;
    /**
     * 结束的角度
     */
    private int endAngle;
    /**
     * 文字文本
     */
    private String mTextStr1;
    private String mTextStr2;

    /**
     * 文字的颜色
     */
    private int mTextColor;
    /**
     * 文字的大小
     */
    private int mText1Size;
    private int mText2Size;
    /**
     * 画笔
     */
    private Paint mPaint;
    /**
     * 文本画笔
     */
    private TextPaint textPaint1;
    private TextPaint textPaint2;
    /**
     * 圆的宽度
     */
    private int sweepWidth;

    /**
     * 文本大小
     */
    private Rect mTextBound1;

    private Rect mTextBound2;

    private Context mContext;

    public ArcView(Context context) {

        this(context, null);
        this.mContext = context;
    }

    public ArcView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        this.mContext = context;
    }

    public ArcView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ArcView, defStyleAttr, 0);
        int count = a.getIndexCount();
        for (int i = 0; i < count; i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.ArcView_arc_bg_color:
                    mBgColor = a.getColor(attr, Color.parseColor("#cccccc"));
                    break;
                case R.styleable.ArcView_arc_out_color:
                    mOutColor = a.getColor(attr, Color.parseColor("#E8A125"));
                    break;
                case R.styleable.ArcView_arc_out_radius:
                    mOutRadius = a.getDimensionPixelSize(attr, UIUtils.dp2px(200, mContext));
                    break;
                case R.styleable.ArcView_arc_little_radius:
                    mLittleRadius = a.getDimensionPixelSize(attr, UIUtils.dp2px(3, mContext));
                    break;
                case R.styleable.ArcView_arc_text1:
                    mTextStr1 = a.getString(attr);
                    break;
                case R.styleable.ArcView_arc_text2:
                    mTextStr2 = a.getString(attr);
                    break;
                case R.styleable.ArcView_arc_text_color:
                    mTextColor = a.getColor(attr, Color.WHITE);
                    break;
                case R.styleable.ArcView_arc_text1_size:
                    mText1Size = a.getDimensionPixelSize(attr, UIUtils.sp2px(60, mContext));
                    break;
                case R.styleable.ArcView_arc_text2_size:
                    mText2Size = a.getDimensionPixelSize(attr, UIUtils.sp2px(30, mContext));
                    break;
                case R.styleable.ArcView_arc_sweep_width:
                    sweepWidth = a.getDimensionPixelSize(attr, UIUtils.dp2px(3, mContext));
                    break;
                case R.styleable.ArcView_arc_start_angle:
                    startAngle = a.getInt(attr, -220);
                    break;
                case R.styleable.ArcView_arc_end_angle:
                    endAngle = a.getInt(attr, 260);
                    break;
                case R.styleable.ArcView_arc_little_color:
                    mLittleColor = a.getColor(attr, Color.WHITE);
                    break;
            }

        }
        a.recycle();
        //圆
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(sweepWidth);
        //10.7万
        mTextBound1 = new Rect();
        textPaint1 = new TextPaint(Paint.FAKE_BOLD_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
        textPaint1.setTextSize(mText1Size);
        textPaint1.getTextBounds(mTextStr1, 0, mTextStr1.length(), mTextBound1);
        //剩余可购
        mTextBound2 = new Rect();
        textPaint2 = new TextPaint();
        textPaint2.setAntiAlias(true);
        textPaint2.setTextSize(mText2Size);
        textPaint2.getTextBounds(mTextStr2, 0, mTextStr2.length(), mTextBound2);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        //平移到屏幕中心
        canvas.translate(mWidth / 2, mHeight / 2);
        //外圆
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(mBgColor);
        RectF rectOut = new RectF(-mOutRadius, -mOutRadius, mOutRadius, mOutRadius);
        canvas.drawArc(rectOut, startAngle, endAngle, false, mPaint);
        //根据获取到的数据画弧
        mPaint.setColor(mOutColor);
        if (value == 0) {
            value=0.01;
        }
        percentage = value / sumValue;
        float angle = (float) (percentage * 260);                 // 对应的角度
        canvas.drawArc(rectOut, startAngle, angle, false, mPaint);
        //小原点
        float x = (float) ((mOutRadius) * Math.cos(Math.toRadians(startAngle + angle)));
        float y = (float) ((mOutRadius) * Math.sin(Math.toRadians(startAngle + angle)));
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(mLittleColor);


        mPaint.setMaskFilter(new BlurMaskFilter(dp2px(3), BlurMaskFilter.Blur.SOLID)); //需关闭硬件加速
        canvas.drawCircle(x, y, mLittleRadius, mPaint);
        //10.4万
        textPaint1.setTextAlign(Paint.Align.CENTER);
        textPaint1.setColor(mTextColor);

        canvas.drawText(mTextStr1, 0, mTextBound1.height() / 2, textPaint1);
        //剩余可购
        textPaint2.setTextAlign(Paint.Align.CENTER);
        textPaint2.setColor(mTextColor);
        canvas.drawText(mTextStr2,0, mOutRadius-mTextBound2.height(), textPaint2);
        canvas.restore();
    }

    /**
     * 设置数据
     *
     * @param value    已经购买
     * @param sumValue 总标
     */
    public void setData(double value, double sumValue) {
        this.value = value;
        this.sumValue = sumValue;
        invalidate();
    }

    //尺寸转化
    protected int dp2px(int dp) {
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dp,
                getResources().getDisplayMetrics());
    }

    protected int sp2px(int sp) {
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP,
                sp,
                getResources().getDisplayMetrics());
    }


    public void setmTextStr1(String mTextStr1) {
        this.mTextStr1 = mTextStr1;
    }
}
