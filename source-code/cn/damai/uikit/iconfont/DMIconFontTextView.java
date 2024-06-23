package cn.damai.uikit.iconfont;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.IntRange;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.yq;

/* compiled from: Taobao */
public class DMIconFontTextView extends TextView {
    private static transient /* synthetic */ IpChange $ipChange;
    private int angle;

    public DMIconFontTextView(Context context) {
        super(context);
    }

    public Typeface getTypeface() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-677431652")) {
            return yq.a(this);
        }
        return (Typeface) ipChange.ipc$dispatch("-677431652", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "312039177")) {
            ipChange.ipc$dispatch("312039177", new Object[]{this});
            return;
        }
        super.onAttachedToWindow();
        setTypeface(yq.a(this));
        setIncludeFontPadding(false);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1687613460")) {
            ipChange.ipc$dispatch("-1687613460", new Object[]{this});
            return;
        }
        setTypeface(null);
        yq.b(this);
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1912324529")) {
            ipChange.ipc$dispatch("1912324529", new Object[]{this, canvas});
            return;
        }
        int i = this.angle;
        if (i > 0) {
            canvas.rotate((float) i, (float) (getMeasuredWidth() / 2), (float) (getMeasuredHeight() / 2));
        }
        super.onDraw(canvas);
    }

    public void setRotateAngle(@IntRange(from = 0, to = 360) int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "212414082")) {
            ipChange.ipc$dispatch("212414082", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.angle = i;
    }

    public DMIconFontTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DMIconFontTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
