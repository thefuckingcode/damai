package cn.damai.commonbusiness.dynamicx.customwidget.dashview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.v50;

/* compiled from: Taobao */
public class DMDXDashView extends View {
    private static transient /* synthetic */ IpChange $ipChange;
    private int dashColor = Color.parseColor("#EEEEEE");
    private int dashGap = v50.a(getContext(), 2.0f);
    private int dashWidth = v50.a(getContext(), 3.0f);

    public DMDXDashView(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1858605804")) {
            ipChange.ipc$dispatch("1858605804", new Object[]{this, canvas});
            return;
        }
        Paint paint = new Paint(1);
        paint.setColor(this.dashColor);
        paint.setStrokeWidth((float) getHeight());
        paint.setPathEffect(new DashPathEffect(new float[]{(float) this.dashWidth, (float) this.dashGap}, 0.0f));
        float height = (float) (getHeight() / 2);
        canvas.drawLine(0.0f, height, (float) getWidth(), height, paint);
    }

    public void setParams(int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "934676509")) {
            ipChange.ipc$dispatch("934676509", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        this.dashColor = i;
        this.dashWidth = i2;
        this.dashGap = i3;
        invalidate();
    }

    public DMDXDashView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
