package com.tencent.connect.avatar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

/* compiled from: Taobao */
public class b extends View {
    private Rect a;
    private Paint b;

    public b(Context context) {
        super(context);
        b();
    }

    private void b() {
        this.b = new Paint();
    }

    public Rect a() {
        if (this.a == null) {
            this.a = new Rect();
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            int min = Math.min(Math.min((measuredHeight - 60) - 80, measuredWidth), 640);
            int i = (measuredWidth - min) / 2;
            int i2 = (measuredHeight - min) / 2;
            this.a.set(i, i2, i + min, min + i2);
        }
        return this.a;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect a2 = a();
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.b.setStyle(Paint.Style.FILL);
        this.b.setColor(Color.argb(100, 0, 0, 0));
        float f = (float) measuredWidth;
        canvas.drawRect(0.0f, 0.0f, f, (float) a2.top, this.b);
        canvas.drawRect(0.0f, (float) a2.bottom, f, (float) measuredHeight, this.b);
        canvas.drawRect(0.0f, (float) a2.top, (float) a2.left, (float) a2.bottom, this.b);
        canvas.drawRect((float) a2.right, (float) a2.top, f, (float) a2.bottom, this.b);
        canvas.drawColor(Color.argb(100, 0, 0, 0));
        this.b.setStyle(Paint.Style.STROKE);
        this.b.setColor(-1);
        canvas.drawRect((float) a2.left, (float) a2.top, (float) (a2.right - 1), (float) a2.bottom, this.b);
    }
}
