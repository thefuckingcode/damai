package com.youku.live.dago.widgetlib.view.favor;

import android.animation.TypeEvaluator;
import android.graphics.PointF;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class BezierEvaluator implements TypeEvaluator<PointF> {
    private static transient /* synthetic */ IpChange $ipChange;
    private PointF point1;
    private PointF pointF1;
    private PointF pointF2;

    public BezierEvaluator(PointF pointF, PointF pointF3) {
        this.pointF1 = pointF;
        this.pointF2 = pointF3;
    }

    public PointF evaluate(float f, PointF pointF, PointF pointF3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "299716829")) {
            return (PointF) ipChange.ipc$dispatch("299716829", new Object[]{this, Float.valueOf(f), pointF, pointF3});
        }
        float f2 = 1.0f - f;
        PointF pointF4 = new PointF();
        float f3 = f2 * f2 * f2;
        float f4 = 3.0f * f2;
        float f5 = f2 * f4 * f;
        PointF pointF5 = this.pointF1;
        float f6 = (pointF.x * f3) + (pointF5.x * f5);
        float f7 = f4 * f * f;
        PointF pointF6 = this.pointF2;
        float f8 = f * f * f;
        pointF4.x = f6 + (pointF6.x * f7) + (pointF3.x * f8);
        pointF4.y = (f3 * pointF.y) + (f5 * pointF5.y) + (f7 * pointF6.y) + (f8 * pointF3.y);
        return pointF4;
    }

    public BezierEvaluator(PointF pointF) {
        this.point1 = pointF;
    }
}
