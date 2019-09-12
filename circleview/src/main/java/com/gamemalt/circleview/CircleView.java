package com.gamemalt.circleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;


public class CircleView extends View {


    private Paint mpaint;
    private int circleColor;


    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CircleView);
        try {
            circleColor = typedArray.getColor(R.styleable.CircleView_cv_color, Color.WHITE);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            typedArray.recycle();
        }


        init();

    }

    public CircleView(Context context) {
        super(context);
        init();
    }


    private void init() {
        mpaint = new Paint();
        mpaint.setStyle(Paint.Style.FILL);
        mpaint.setAntiAlias(true);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int w = this.getWidth();
        int h = this.getHeight();

        float ox = (w / 2.0f);
        float oy = (h / 2.0f);

        mpaint.setColor(circleColor);
        canvas.drawCircle(ox, oy, (getWidth() / 2.0f), mpaint);


    }


    public int getCircleColor() {
        return circleColor;
    }

    public void setCircleColor(int circleColor) {
        this.circleColor = circleColor;
        invalidate();

    }
}
