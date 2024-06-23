package cn.damai.comment.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import cn.damai.comment.R$color;
import cn.damai.comment.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;
import tb.v50;

/* compiled from: Taobao */
public final class TopScoreDivideView extends View {
    private static transient /* synthetic */ IpChange $ipChange;
    private int color;
    @Nullable
    private Paint paint;
    private int viewHeight;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TopScoreDivideView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TopScoreDivideView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TopScoreDivideView(Context context, AttributeSet attributeSet, int i, int i2, m40 m40) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-55324545")) {
            ipChange.ipc$dispatch("-55324545", new Object[]{this});
            return;
        }
        this.viewHeight = v50.a(getContext(), 3.0f);
        Paint paint2 = new Paint(1);
        this.paint = paint2;
        k21.f(paint2);
        int i = this.color;
        if (i == 0) {
            i = getResources().getColor(R$color.color_ffe2e2e2);
        }
        paint2.setColor(i);
        Paint paint3 = this.paint;
        k21.f(paint3);
        paint3.setStrokeWidth(2.0f);
    }

    /* access modifiers changed from: protected */
    public void onDraw(@NotNull Canvas canvas) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1949467527")) {
            ipChange.ipc$dispatch("-1949467527", new Object[]{this, canvas});
            return;
        }
        k21.i(canvas, "canvas");
        super.onDraw(canvas);
        if (this.paint != null) {
            while (i < getHeight()) {
                Paint paint2 = this.paint;
                k21.f(paint2);
                canvas.drawLine(0.0f, (float) i, 0.0f, (float) (this.viewHeight + i), paint2);
                i += this.viewHeight * 2;
            }
        }
    }

    public final void setColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-879605259")) {
            ipChange.ipc$dispatch("-879605259", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.color = i;
        Paint paint2 = this.paint;
        k21.f(paint2);
        if (i == 0) {
            i = getResources().getColor(R$color.color_ffe2e2e2);
        }
        paint2.setColor(i);
    }

    public final void setHeight(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1246467471")) {
            ipChange.ipc$dispatch("-1246467471", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.viewHeight = i;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TopScoreDivideView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.DivideView);
        k21.h(obtainStyledAttributes, "context.obtainStyledAttr…, R.styleable.DivideView)");
        this.color = obtainStyledAttributes.getColor(R$styleable.DivideView_divide_color, ContextCompat.getColor(context, R$color.color_ffe2e2e2));
        init();
    }
}
