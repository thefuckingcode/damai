package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.util.UIUtil;

/* compiled from: Taobao */
public class MedalSpan extends ReplacementSpan {
    private static transient /* synthetic */ IpChange $ipChange;
    private int mColor;
    private Drawable mMedalDrawable;
    private int mRadius;
    private int mSize = UIUtil.dip2px(44);

    public MedalSpan(int i, int i2, Drawable drawable) {
        this.mColor = i;
        this.mRadius = i2;
        this.mMedalDrawable = drawable;
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1221450372")) {
            ipChange.ipc$dispatch("-1221450372", new Object[]{this, canvas, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), paint});
            return;
        }
        paint.setColor(this.mColor);
        paint.setAntiAlias(true);
        float f2 = (float) i4;
        RectF rectF = new RectF(f, paint.ascent() + f2 + ((float) UIUtil.dip2px(1)), ((float) this.mSize) + f, (f2 + paint.descent()) - ((float) UIUtil.dip2px(1)));
        int i6 = this.mRadius;
        canvas.drawRoundRect(rectF, (float) i6, (float) i6, paint);
        paint.setColor(-1);
        paint.setTextSize((float) UIUtil.dip2px(9));
        canvas.drawText(charSequence, i, i2, f, (float) (i4 - UIUtil.dip2px(1)), paint);
        Drawable drawable = this.mMedalDrawable;
        if (drawable != null) {
            drawable.setBounds((int) f, i3 + UIUtil.dip2px(3), (int) (((float) UIUtil.dip2px(18)) + f), i3 + UIUtil.dip2px(15));
            this.mMedalDrawable.draw(canvas);
        }
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "582040652")) {
            return this.mSize;
        }
        return ((Integer) ipChange.ipc$dispatch("582040652", new Object[]{this, paint, charSequence, Integer.valueOf(i), Integer.valueOf(i2), fontMetricsInt})).intValue();
    }

    public void setDrawable(BitmapDrawable bitmapDrawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1025493942")) {
            ipChange.ipc$dispatch("1025493942", new Object[]{this, bitmapDrawable});
            return;
        }
        this.mMedalDrawable = bitmapDrawable;
    }
}
