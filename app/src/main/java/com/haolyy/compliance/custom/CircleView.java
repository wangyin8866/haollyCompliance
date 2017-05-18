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
import android.text.TextPaint;
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
     * 总值
     */
    private double sumValue;
    /**
     * 外圆的背景颜色
     */
    private int mBgColor;
    /**
     * 圆弧的起始颜色
     */
    private int mOutColorStart;
    /**
     * 圆弧的开始颜色
     */
    private int mOutColorEnd;


    /**
     * 外圆的宽度
     */
    private int mOutSweep;

    /**
     * 文本信息
     */
    private TextPaint textPaint;
    private String mCircleText;
    /**
     * 文本颜色
     */
    private int mCircleTextColor;
    /**
     * 文本大小
     */
    private int mCircleTextSize;
    private Rect mTextBound;
    /***
     * 背景色渐变
     */
    private int[] mColors;
    /**
     * 圆弧色渐变
     */
    private int[] mColors1;


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
                    mBgColor = a.getColor(attr, Color.parseColor("#cccccc"));
                    break;
                case R.styleable.CircleView_out_color_start:
                    mOutColorStart = a.getColor(attr, Color.parseColor("#FBDA61"));
                    break;
                case R.styleable.CircleView_out_color_end:
                    mOutColorEnd = a.getColor(attr, Color.parseColor("#F76B1C"));
                    break;
                case R.styleable.CircleView_circle_text:
                    mCircleText = a.getString(attr);
                    break;
                case R.styleable.CircleView_circle_text_color:
                    mCircleTextColor = a.getColor(attr, Color.parseColor("#F6A623"));
                    break;
                case R.styleable.CircleView_circle_text_size:
                    mCircleTextSize = a.getDimensionPixelSize(attr, UIUtils.sp2px(12, mContext));
                    break;
                case R.styleable.CircleView_circle_out_sweep_width:
                    mOutSweep = a.getDimensionPixelSize(attr, UIUtils.dp2px(10, mContext));
                    break;
            }
        }
        a.recycle();
        mColors = new int[]{mBgColor, mBgColor};
        mColors1 = new int[]{mOutColorStart, mOutColorEnd};

        mPaint = new Paint();
        mPaint.setAntiAlias(true);

        textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setStyle(Paint.Style.FILL);
        mTextBound = new Rect();
        textPaint = new TextPaint(Paint.FAKE_BOLD_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
        textPaint.setTextSize(mCircleTextSize);
        textPaint.setColor(mCircleTextColor);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.getTextBounds(mCircleText, 0, mCircleText.length(), mTextBound);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //获取到控件的宽和高
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();
        RectF rectOut = new RectF();
        rectOut.set(mOutSweep, mOutSweep, mWidth-mOutSweep, mHeight-mOutSweep);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(mOutSweep);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        //背景圆
        LinearGradient shader1 = new LinearGradient(3, 3, mWidth - 3, mHeight - 3, mColors, null,
                Shader.TileMode.CLAMP);
        mPaint.setShader(shader1);
        canvas.drawArc(rectOut, 0, 360, false, mPaint);
        //外圆
        double percentage = value / sumValue;//百分比
        float angle = (float) (percentage * 360);                 // 对应的角度
        LinearGradient shader2 = new LinearGradient(3, 3, mWidth - 3, mHeight - 3, mColors1, null,
                Shader.TileMode.CLAMP);
        mPaint.setShader(shader2);
        canvas.drawArc(rectOut, -90, angle, false, mPaint);
        //圆心平移
        canvas.translate(mWidth / 2, mHeight / 2);
        //文本
        canvas.drawText(mCircleText, 0, mTextBound.height(), textPaint);
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

    public void setmCircleTextColor(int mCircleTextColor) {
        this.mCircleTextColor = mCircleTextColor;
    }

    public void setmCircleText(String mCircleText) {
        this.mCircleText = mCircleText;
    }

    public String getmCircleText() {
        return mCircleText;
    }

    public void setmOutColorStart(int mOutColorStart) {
        this.mOutColorStart = mOutColorStart;
    }

    public void setmOutColorEnd(int mOutColorEnd) {
        this.mOutColorEnd = mOutColorEnd;
    }
}
