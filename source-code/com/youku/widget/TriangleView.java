package com.youku.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.PathShape;
import android.util.AttributeSet;
import android.widget.ImageView;

/* compiled from: Taobao */
public class TriangleView extends ImageView {
    public static int BOTTOM_LEFT = 2;
    public static int BOTTOM_RIGHT = 3;
    public static int TOP_LEFT = 0;
    public static int TOP_LEFT_1_3 = 4;
    public static int TOP_LEFT_4_9 = 5;
    public static int TOP_RIGHT = 1;
    private int color = -16776961;
    private int direction = TOP_LEFT;

    public TriangleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.color != -16776961) {
            Path path = new Path();
            int i = this.direction;
            if (i == TOP_LEFT) {
                path.moveTo(0.0f, 0.0f);
                path.lineTo((float) getWidth(), 0.0f);
                path.lineTo(0.0f, (float) getHeight());
                path.lineTo(0.0f, 0.0f);
            } else if (i == TOP_RIGHT) {
                path.moveTo(0.0f, 0.0f);
                path.lineTo((float) getWidth(), 0.0f);
                path.lineTo((float) getWidth(), (float) getHeight());
                path.lineTo(0.0f, 0.0f);
            } else if (i == BOTTOM_LEFT) {
                path.moveTo(0.0f, 0.0f);
                path.lineTo(0.0f, (float) getHeight());
                path.lineTo((float) getWidth(), (float) getHeight());
                path.lineTo(0.0f, 0.0f);
            } else if (i == BOTTOM_RIGHT) {
                path.moveTo((float) getWidth(), 0.0f);
                path.lineTo((float) getWidth(), (float) getHeight());
                path.lineTo(0.0f, (float) getHeight());
                path.lineTo((float) getWidth(), 0.0f);
            } else if (i == TOP_LEFT_1_3) {
                path.moveTo((float) (getWidth() / 3), 0.0f);
                path.lineTo((float) getWidth(), 0.0f);
                path.lineTo(0.0f, (float) getHeight());
                path.lineTo(0.0f, (float) (getHeight() / 3));
                path.lineTo((float) (getWidth() / 3), 0.0f);
            } else if (i == TOP_LEFT_4_9) {
                path.moveTo((float) ((getWidth() * 4) / 9), 0.0f);
                path.lineTo((float) getWidth(), 0.0f);
                path.lineTo(0.0f, (float) getHeight());
                path.lineTo(0.0f, (float) ((getHeight() * 4) / 9));
                path.lineTo((float) ((getWidth() * 4) / 9), 0.0f);
            }
            ShapeDrawable shapeDrawable = new ShapeDrawable(new PathShape(path, (float) getWidth(), (float) getHeight()));
            shapeDrawable.getPaint().setColor(this.color);
            shapeDrawable.setBounds(0, 0, getWidth(), getHeight());
            shapeDrawable.setAlpha(192);
            shapeDrawable.draw(canvas);
        }
    }

    public void setBackgroundColor(int i) {
        this.color = i;
        postInvalidate();
    }

    public void setDirection(int i) {
        this.direction = i;
    }

    public TriangleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TriangleView(Context context) {
        super(context);
    }
}
