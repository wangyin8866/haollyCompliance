package com.haolyy.compliance.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by wangyin on 2017/6/12.
 */

public class DashedLine extends View {
    public DashedLine(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);
        paint.setAntiAlias(true);
        paint.setColor(Color.parseColor("#F5F5F5"));
        Path path = new Path();
        path.moveTo(0,1);
        path.lineTo(getWidth(),1);
        PathEffect effects = new DashPathEffect(new float[]{30,10},1);
        paint.setPathEffect(effects);
        canvas.drawPath(path, paint);
    }
}
