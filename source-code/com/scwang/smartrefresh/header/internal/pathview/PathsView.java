package com.scwang.smartrefresh.header.internal.pathview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect;
import tb.ap1;

/* compiled from: Taobao */
public class PathsView extends View {
    protected ap1 mPathsDrawable;

    public PathsView(Context context) {
        this(context, null);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.mPathsDrawable.draw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        if (getTag() instanceof String) {
            parserPaths(getTag().toString());
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mPathsDrawable.setBounds(getPaddingLeft(), getPaddingTop(), Math.max((i3 - i) - getPaddingRight(), getPaddingLeft()), Math.max((i4 - i2) - getPaddingTop(), getPaddingTop()));
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        ap1 ap1 = this.mPathsDrawable;
        super.setMeasuredDimension(View.resolveSize(Rect.width(ap1.getBounds()) + getPaddingLeft() + getPaddingRight(), i), View.resolveSize(Rect.height(ap1.getBounds()) + getPaddingTop() + getPaddingBottom(), i2));
    }

    public void parserColors(int... iArr) {
        this.mPathsDrawable.e(iArr);
    }

    public void parserPaths(String... strArr) {
        this.mPathsDrawable.f(strArr);
    }

    public PathsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPathsDrawable = new ap1();
        this.mPathsDrawable = new ap1();
    }
}
