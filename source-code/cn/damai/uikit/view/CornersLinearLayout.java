package cn.damai.uikit.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.s50;

/* compiled from: Taobao */
public class CornersLinearLayout extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private float round = ((float) s50.a(getContext(), 6.0f));

    public CornersLinearLayout(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-177896197")) {
            ipChange.ipc$dispatch("-177896197", new Object[]{this, canvas});
            return;
        }
        if (this.round > 0.0f) {
            Path path = new Path();
            RectF rectF = new RectF((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()));
            float f = this.round;
            path.addRoundRect(rectF, f, f, Path.Direction.CW);
            canvas.clipPath(path, Region.Op.INTERSECT);
        }
        super.dispatchDraw(canvas);
    }

    public void setRound(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1687443012")) {
            ipChange.ipc$dispatch("1687443012", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.round = f;
    }

    public CornersLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CornersLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
