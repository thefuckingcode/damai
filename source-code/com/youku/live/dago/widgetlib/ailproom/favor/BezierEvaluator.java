package com.youku.live.dago.widgetlib.ailproom.favor;

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
        if (AndroidInstantRuntime.support(ipChange, "-1033462981")) {
            return (PointF) ipChange.ipc$dispatch("-1033462981", new Object[]{this, Float.valueOf(f), pointF, pointF3});
        }
        float f2 = 1.0f - f;
        PointF pointF4 = new PointF();
        float f3 = f2 * f2 * f2;
        float f4 = 6.0f * f2;
        PointF pointF5 = this.pointF1;
        float f5 = (pointF.x * f3) + (f4 * f2 * f * pointF5.x);
        PointF pointF6 = this.pointF2;
        float f6 = f5 + (f4 * f * f * pointF6.x);
        float f7 = f * f * f;
        pointF4.x = f6 + (pointF3.x * f7);
        float f8 = f3 * pointF.y;
        float f9 = 3.0f * f2;
        pointF4.y = f8 + (f2 * f9 * f * pointF5.y) + (f9 * f * f * pointF6.y) + (f7 * pointF3.y);
        return pointF4;
    }

    public BezierEvaluator(PointF pointF) {
        this.point1 = pointF;
    }
}
