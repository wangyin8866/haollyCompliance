package com.haolyy.compliance.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
//import android.graphics.Rect;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import com.haolyy.compliance.R;
import com.haolyy.compliance.utils.UIUtils;


public class CircleProgressView extends View {

    /**
     * 直径
     */
    private int mDiameter;

    /**
     * 绘制时控制绘制的范围
     */
    private Paint mPaint;
    private int progressValue = 0;
    RectF rect;

    //颜色（渐变色的4个点）
    private int[] mColors = {Color.parseColor("#cccccc"), Color.parseColor("#cccccc")};
    private int[] mColors2 = {Color.parseColor("#FBDA61"),Color.parseColor("#F76B1C")};

    //文本画笔
    private TextPaint textPaint;
    private Rect mTextBound;
    private String mCircleText;

    public CircleProgressView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleProgressView(Context context) {
        this(context, null);
    }

    /**
     * 获得我自定义的样式属性
     *
     * @param context
     * @param attrs
     * @param defStyle
     */
    public CircleProgressView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        /**
         * 获得我们所定义的自定义样式属性
         */
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CircleProgressView, defStyle, 0);
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.CircleProgressView_diameter:
                    // 默认设置为240dp
                    mDiameter = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_SP, 240, getResources().getDisplayMetrics()));
                    break;
            }
        }
        a.recycle();

        mPaint = new Paint();
        rect = new RectF();
        progressValue = 0;

      /*  textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setStyle(Paint.Style.FILL);
        mTextBound = new Rect();
        //textPaint = new TextPaint(Paint.FAKE_BOLD_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
        textPaint.setTextSize(UIUtils.dp2px(36,context));
        textPaint.setColor(UIUtils.getColor(R.color.text_f8676f));
        textPaint.setTextAlign(Paint.Align.CENTER);*/

    }

    public void setProgressValue(int progressValue) {

        this.progressValue = progressValue;
        Log.i("customView", "log: progressValue=" + progressValue);

    }

    public void setColors(int[] colors) {

        mColors = colors;
        Log.i("customView", "log: progressValue=" + progressValue);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = 0;
        int height = 0;

        //设置直径的最小值
        if (mDiameter <= 240) {
            mDiameter = 240;
        }
        height = mDiameter;
        width = mDiameter;

        Log.i("customView", "log: w=" + width + " h=" + height);
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int mWidth = getMeasuredWidth();
        int mHeight = getMeasuredHeight();

        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth((float) mWidth / 30);
        mPaint.setStyle(Style.STROKE);
        mPaint.setStrokeCap(Cap.ROUND);
        mPaint.setColor(Color.TRANSPARENT);
         mPaint.setColor(Color.BLACK);
        rect.set(20, 20, mWidth - 20, mHeight - 20);
        LinearGradient shader = new LinearGradient(3, 3, mWidth - 3, mHeight - 3, mColors, null,
                Shader.TileMode.CLAMP);
        mPaint.setShader(shader);
        canvas.drawArc(rect, 180, 180, false, mPaint);
        LinearGradient shader1 = new LinearGradient(3, 3, mWidth - 3, mHeight - 3, mColors2, null,
                Shader.TileMode.CLAMP);
        mPaint.setShader(shader1);
        canvas.drawArc(rect, 180,  170, false, mPaint);
    }
}

