package cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.model;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class SVGRect extends Shape {
    private static transient /* synthetic */ IpChange $ipChange;
    public float height;
    public RectF rect;
    public float rx;
    public float ry;
    public float width;
    public float x;
    public float y;

    /* access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.model.Shape
    public void drawSelf(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1052169713")) {
            ipChange.ipc$dispatch("-1052169713", new Object[]{this, canvas});
            return;
        }
        Paint paint = this.fillPaint;
        if (paint != null) {
            float f = this.rx;
            if (f > 0.0f || this.ry > 0.0f) {
                canvas.drawRoundRect(this.rect, f, this.ry, paint);
            } else {
                canvas.drawRect(this.rect, paint);
            }
        }
        Paint paint2 = this.strokePaint;
        if (paint2 != null) {
            float f2 = this.rx;
            if (f2 > 0.0f || this.ry > 0.0f) {
                canvas.drawRoundRect(this.rect, f2, this.ry, paint2);
            } else {
                canvas.drawRect(this.rect, paint2);
            }
        }
    }
}
