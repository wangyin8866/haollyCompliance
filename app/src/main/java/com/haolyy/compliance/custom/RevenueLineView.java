package com.haolyy.compliance.custom;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import com.haolyy.compliance.R;

import java.util.ArrayList;
import java.util.List;

/**
 * WTF
 * 收率曲线 画了好久
 * Created by niudeyang on 2017/5/22.
 */

public class RevenueLineView extends View {
    private final int XLENTH = dip2px(260);
    private int YLENTH = dip2px(180);
    private static Context mContext;
    //这些像素值在通过dp转换

    private int YPoint = YLENTH;
    private int XScale = XLENTH / 7; // 刻度长度
    private int XPoint = dip2px(60) ;
    private int YScale = YLENTH / 4;
    private int XLength = XLENTH;
    private int YLength = YLENTH;

    public void setXPoint(int XPoint) {
        this.XPoint = XPoint;
    }

    public void setYPoint(int YPoint) {
        this.YPoint = YPoint;
    }

    public void setXScale(int XScale) {
        this.XScale = XScale;
    }

    public void setYScale(int YScale) {
        this.YScale = YScale;
    }

    public void setXLength(int XLength) {
        this.XLength = XLength;
    }

    public void setYLength(int YLength) {
        this.YLength = YLength;
    }


    // private int MaxDataSize = XLength / XScale;

    private List<Double> data = new ArrayList<Double>();

    private String[] YLabel ;
    private String[] XLabel ;

    /* private Handler handler = new Handler() {
         public void handleMessage(Message msg) {
             if (msg.what == 0x1234) {
                RevenueLineView.this.invalidate();
             }
         };
     };*/
    protected int dip2px(int dp) {
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }

    //在代码中创建布局使用
    public RevenueLineView(Context context, int YL, int XL) {
        super(context);
        this.mContext = context;
        this.XLength = XL;
        this.YLength = YL;
//        for (int i = 0; i <= YLabel.length; i++) {
//            YLabel[i] = (1000) + "元";
//        }
//        for (int i = 0; i < XLabel.length; i++) {
//            XLabel[i] = "07-" + (i + 1);
//        }
//        for (int i = 0; i < XLabel.length; i++) {
//            if (i < 3) {
//                data.add(i + 0.5);
//            } else {
//                data.add(i - 0.5);
//            }
//        }

    }

    public RevenueLineView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
//        for (int i = 0; i < YLabel.length; i++) {
//            YLabel[i] = (i * 1000) + "元";
//        }
//        for (int i = 0; i < XLabel.length; i++) {
//            XLabel[i] = "07-" + (i + 1);
//        }

//        data.add(0.0);
//        data.add(1.0);
//        data.add(2.0);
//        data.add(3.0);
//        data.add(2.0);
//        data.add(1.0);
//        data.add(3.0);


    }

    public void setYLabel(String[] YLabel) {
        this.YLabel = YLabel;
    }

    public void setXLabel(String[] XLabel) {
        this.XLabel = XLabel;
        XScale = XLENTH / XLabel.length;
    }

    public void setData(List<Double> data) {
        this.data = data;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new TextPaint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true); // 去锯齿
        paint.setColor(Color.parseColor("#4a4a4a"));
        paint.setTextSize(dip2px(10));
        Paint paint1 = new Paint();//画折线的paint
        paint1.setColor(Color.parseColor("#ff9933"));
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setAntiAlias(true); // 去锯齿
        paint1.setStrokeWidth(4);

        Paint paintDash = new Paint();//画虚线的
        paintDash.reset();
        paintDash.setStyle(Paint.Style.STROKE);
        paintDash.setColor(Color.parseColor("#e1e1e1"));
        paintDash.setStrokeWidth(2);
        paintDash.setAntiAlias(true);


        Paint paint4 = new Paint();//第七日收益率
        paint4.setAntiAlias(true); // 去锯齿
        paint4.setColor(Color.parseColor("#000000"));
        paint4.setTextSize(36);

         if(YLabel == null || XLabel == null) return;
        // 添加刻度和文字
        for (int i = 0; i <= 3; i++) {
            Log.e("ndy", YLabel[i]);
            canvas.drawText(YLabel[i], XPoint - dip2px(40), YPoint - (i) * YScale + 4, paint);// 文字
            //canvas.drawLine((float) (XPoint + 0.5 * XScale), YPoint - (i + 1) * YScale, XPoint + XLENTH, YPoint - (i + 1) * YScale, paintDash); // 刻度
            if (i < 3) {
                DashPathEffect pathEffect = new DashPathEffect(new float[]{10, 10, 10, 10}, 1);
                paintDash.setPathEffect(pathEffect);
                Path path8 = new Path();
                path8.moveTo((float) (XPoint), YPoint - (i + 1) * YScale);
                path8.lineTo((float) (XPoint) + XLength, YPoint - (i + 1) * YScale);
                canvas.drawPath(path8, paintDash);
            }
        }

        // 画X轴
        canvas.drawLine(XPoint, YPoint, XPoint + XLength, YPoint, paint);
        // 添加文字
        for (int i = 0; i * XScale <= XLength; i++) {

            if (i < XLabel.length) {
                canvas.drawText(XLabel[i], XPoint + i * XScale, YPoint + dip2px(20), paint);// 文字
            }
        }

        //绘制折线
        if (data.size() > 1) {
            Path path = new Path();//折线
            for (int i = 0; i < data.size(); i++) {
                if (i == 0) {
                    path.moveTo(XPoint+ (float)(XScale/2.8) , (float) (YPoint - data.get(i) * YScale));//起点
                } else {
                    path.lineTo(XPoint + (float)(XScale/2.8) + i * XScale, (float) (YPoint - data.get(i) * YScale));//终点
                }
            }
            //path.lineTo(XPoint + (data.size() - 1) * XScale, YPoint);
            canvas.drawPath(path, paint1);//绘制折线
        }

        //绘制第七日收益率的背景
        Resources resources = this.getResources();
        Bitmap dotbmp = BitmapFactory.decodeResource(resources, R.mipmap.point_unuseful);
        Bitmap dot = Bitmap.createBitmap(dotbmp);
        //canvas.drawBitmap(dot, XPoint + 6 * XScale, (float) (YPoint - 3 * YScale - 0.5 * dot.getHeight()), paint4);
        //画第一个点
//        canvas.drawBitmap(dot, (float) (XPoint+ (float)(XScale/2.5) -0.5*dot.getWidth()), (float) (YPoint - 0.5 * XScale- 0.5 * dot.getHeight()), paint4);
        for (int j = 0; j < XLabel.length; j++) {
            canvas.drawBitmap(dot, (float) (XPoint+ (float)(XScale/2.8) + j * XScale-0.5*dot.getWidth()), (float) (YPoint - data.get(j) * YScale- 0.5 * dot.getHeight()), paint4);

        }
    }


}

