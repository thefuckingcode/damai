package com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.gestures;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class FroyoGestureDetector extends EclairGestureDetector {
    private static transient /* synthetic */ IpChange $ipChange;
    final ScaleGestureDetector mDetector;

    public FroyoGestureDetector(Context context) {
        super(context);
        this.mDetector = new ScaleGestureDetector(context, new ScaleGestureDetector.OnScaleGestureListener() {
            /* class com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.gestures.FroyoGestureDetector.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1468157980")) {
                    return ((Boolean) ipChange.ipc$dispatch("-1468157980", new Object[]{this, scaleGestureDetector})).booleanValue();
                }
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                    return false;
                }
                FroyoGestureDetector.this.mListener.onScale(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                return true;
            }

            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "1466279047")) {
                    return true;
                }
                return ((Boolean) ipChange.ipc$dispatch("1466279047", new Object[]{this, scaleGestureDetector})).booleanValue();
            }

            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1949330037")) {
                    ipChange.ipc$dispatch("1949330037", new Object[]{this, scaleGestureDetector});
                }
            }
        });
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.gestures.GestureDetector, com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.gestures.CupcakeGestureDetector
    public boolean isScaling() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-961960527")) {
            return this.mDetector.isInProgress();
        }
        return ((Boolean) ipChange.ipc$dispatch("-961960527", new Object[]{this})).booleanValue();
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.gestures.GestureDetector, com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.gestures.CupcakeGestureDetector, com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.gestures.EclairGestureDetector
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "375309183")) {
            return ((Boolean) ipChange.ipc$dispatch("375309183", new Object[]{this, motionEvent})).booleanValue();
        }
        this.mDetector.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }
}
