package tb;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public abstract class hs0 implements GestureDetector.OnGestureListener {
    private static transient /* synthetic */ IpChange $ipChange;

    public boolean onDown(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1729837393")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("1729837393", new Object[]{this, motionEvent})).booleanValue();
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1811299842")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("1811299842", new Object[]{this, motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})).booleanValue();
    }

    public void onLongPress(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1591953090")) {
            ipChange.ipc$dispatch("-1591953090", new Object[]{this, motionEvent});
        }
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-50548837")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-50548837", new Object[]{this, motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})).booleanValue();
    }

    public void onShowPress(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1567396481")) {
            ipChange.ipc$dispatch("-1567396481", new Object[]{this, motionEvent});
        }
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1110484525")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1110484525", new Object[]{this, motionEvent})).booleanValue();
    }
}
