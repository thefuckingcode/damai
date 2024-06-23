package com.alibaba.pictures.bricks.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.alibaba.pictures.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;

/* compiled from: Taobao */
public final class CornerFrameLayout extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private int mCornerPx;
    @Nullable
    private Integer mLastH;
    @Nullable
    private Integer mLastW;
    @Nullable
    private Path mPath;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CornerFrameLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CornerFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CornerFrameLayout(Context context, AttributeSet attributeSet, int i, int i2, m40 m40) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
        if (r0 != r1.intValue()) goto L_0x0039;
     */
    public void dispatchDraw(@Nullable Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1194549906")) {
            ipChange.ipc$dispatch("1194549906", new Object[]{this, canvas});
            return;
        }
        try {
            if (this.mCornerPx > 0) {
                int width = getWidth();
                Integer num = this.mLastW;
                if (num != null) {
                    if (width == num.intValue()) {
                        int height = getHeight();
                        Integer num2 = this.mLastH;
                        if (num2 == null) {
                        }
                    }
                }
                Path path = new Path();
                RectF rectF = new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
                int i = this.mCornerPx;
                path.addRoundRect(rectF, (float) i, (float) i, Path.Direction.CW);
                this.mPath = path;
            } else {
                this.mPath = null;
            }
            this.mLastW = Integer.valueOf(getWidth());
            this.mLastH = Integer.valueOf(getHeight());
            Path path2 = this.mPath;
            if (path2 != null) {
                if (canvas != null) {
                    canvas.save();
                }
                if (canvas != null) {
                    canvas.clipPath(path2);
                }
            }
            super.dispatchDraw(canvas);
            if (this.mPath != null && canvas != null) {
                canvas.restore();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void setRoundCornerPx(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1507790725")) {
            ipChange.ipc$dispatch("-1507790725", new Object[]{this, Integer.valueOf(i)});
        } else if (this.mCornerPx != i) {
            this.mCornerPx = i;
            this.mLastW = null;
            this.mLastH = null;
            invalidate();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CornerFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CornerFrameLayout);
        k21.h(obtainStyledAttributes, "context.obtainStyledAttr…leable.CornerFrameLayout)");
        this.mCornerPx = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CornerFrameLayout_clip_corner_radius, 0);
        obtainStyledAttributes.recycle();
    }
}
