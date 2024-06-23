package com.alibaba.pictures.bricks.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.u50;

/* compiled from: Taobao */
public final class NestedBannerIndicatorView extends View implements BannerViewIndicator {
    private static transient /* synthetic */ IpChange $ipChange;
    private final int mBgColor;
    private int mCurIndex;
    private final int mIndicatorColor;
    @NotNull
    private final Paint mPaint;
    @NotNull
    private final RectF mRectF = new RectF();
    private final int mSimpleIndicatorWidth;
    private int mTotalCount;

    public NestedBannerIndicatorView(@Nullable Context context) {
        super(context);
        u50 u50 = u50.INSTANCE;
        Context context2 = getContext();
        k21.h(context2, WPKFactory.INIT_KEY_CONTEXT);
        this.mSimpleIndicatorWidth = u50.b(context2, 9);
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        this.mPaint = paint;
        this.mBgColor = Color.parseColor("#99ebeafb");
        this.mIndicatorColor = Color.parseColor("#ffffff");
    }

    /* access modifiers changed from: protected */
    public void onDraw(@NotNull Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "544972968")) {
            ipChange.ipc$dispatch("544972968", new Object[]{this, canvas});
            return;
        }
        k21.i(canvas, "canvas");
        int i = this.mTotalCount;
        if (i >= 2 && this.mCurIndex < i) {
            float height = ((float) getHeight()) / 2.0f;
            int i2 = this.mTotalCount * this.mSimpleIndicatorWidth;
            float width = ((float) (getWidth() - i2)) / 2.0f;
            this.mRectF.set(width, 0.0f, ((float) i2) + width, (float) getHeight());
            this.mPaint.setColor(this.mBgColor);
            canvas.drawRoundRect(this.mRectF, height, height, this.mPaint);
            int i3 = this.mCurIndex;
            int i4 = this.mSimpleIndicatorWidth;
            float f = width + ((float) (i3 * i4));
            this.mRectF.set(f, 0.0f, ((float) i4) + f, (float) getHeight());
            this.mPaint.setColor(this.mIndicatorColor);
            canvas.drawRoundRect(this.mRectF, height, height, this.mPaint);
        }
    }

    @Override // com.alibaba.pictures.bricks.view.BannerViewIndicator
    public void updateIndicator(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1492332452")) {
            ipChange.ipc$dispatch("1492332452", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.mTotalCount = i;
        this.mCurIndex = i2;
        invalidate();
    }

    public NestedBannerIndicatorView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        u50 u50 = u50.INSTANCE;
        Context context2 = getContext();
        k21.h(context2, WPKFactory.INIT_KEY_CONTEXT);
        this.mSimpleIndicatorWidth = u50.b(context2, 9);
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        this.mPaint = paint;
        this.mBgColor = Color.parseColor("#99ebeafb");
        this.mIndicatorColor = Color.parseColor("#ffffff");
    }

    public NestedBannerIndicatorView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        u50 u50 = u50.INSTANCE;
        Context context2 = getContext();
        k21.h(context2, WPKFactory.INIT_KEY_CONTEXT);
        this.mSimpleIndicatorWidth = u50.b(context2, 9);
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        this.mPaint = paint;
        this.mBgColor = Color.parseColor("#99ebeafb");
        this.mIndicatorColor = Color.parseColor("#ffffff");
    }
}
