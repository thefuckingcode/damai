package com.alibaba.security.biometrics.sensor.a;

import android.app.Activity;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.alibaba.security.biometrics.sensor.api.RpSecException;
import com.alibaba.security.biometrics.sensor.b.a;
import com.alibaba.security.biometrics.sensor.model.MotionEventData;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public final class c extends a<List<MotionEventData>> implements View.OnTouchListener {
    public volatile boolean c = false;
    public final List<MotionEventData> d = new ArrayList();
    private View e;

    public c(Activity activity) {
        super(activity);
    }

    private static MotionEventData b(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return null;
        }
        MotionEventData motionEventData = new MotionEventData();
        motionEventData.setAction(motionEvent.getAction());
        motionEventData.setDeviceID(motionEvent.getDeviceId());
        motionEventData.setDownTime(motionEvent.getDownTime());
        motionEventData.setElapsedRealtime(SystemClock.elapsedRealtime());
        motionEventData.setEventTime(motionEvent.getEventTime());
        motionEventData.setPressure(motionEvent.getPressure());
        motionEventData.setSize(motionEvent.getSize());
        motionEventData.setToolType(motionEvent.getToolType(0));
        motionEventData.setX(motionEvent.getX());
        motionEventData.setY(motionEvent.getY());
        return motionEventData;
    }

    private List<MotionEventData> e() {
        return this.d;
    }

    @Override // com.alibaba.security.biometrics.sensor.a.a
    public final void a(a aVar) throws RpSecException {
        super.a(aVar);
        Activity activity = this.a;
        if (activity != null) {
            Window window = activity.getWindow();
            if (window != null) {
                View decorView = window.getDecorView();
                this.e = decorView;
                if (decorView == null) {
                    throw new RpSecException("No DecorView found from current activity", (int) RpSecException.EXCEPTION_NO_DECOR_VIEW_FOUND);
                }
                return;
            }
            throw new RpSecException("No window found from current activity", (int) RpSecException.EXCEPTION_NO_WINDOW_FOUND_FROM_ACTIVITY);
        }
        throw new RpSecException("No activity found when initialized", -100);
    }

    @Override // com.alibaba.security.biometrics.sensor.a.a
    public final boolean c() {
        this.c = false;
        return false;
    }

    @Override // com.alibaba.security.biometrics.sensor.a.a
    public final void d() {
        List<MotionEventData> list = this.d;
        if (list != null) {
            list.clear();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        if (r7.getAction() == 1) goto L_0x0033;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0035  */
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        MotionEventData motionEventData;
        boolean z = true;
        if (this.c) {
            int size = this.d.size();
            a aVar = this.b;
            int i = aVar.a;
            if (i > 300 || i <= 0) {
                aVar.a = 100;
            }
            if (size <= aVar.a) {
                if (motionEvent.getAction() != 0) {
                    if (motionEvent.getAction() != 2) {
                    }
                }
                if (z) {
                    if (motionEvent == null) {
                        motionEventData = null;
                    } else {
                        motionEventData = new MotionEventData();
                        motionEventData.setAction(motionEvent.getAction());
                        motionEventData.setDeviceID(motionEvent.getDeviceId());
                        motionEventData.setDownTime(motionEvent.getDownTime());
                        motionEventData.setElapsedRealtime(SystemClock.elapsedRealtime());
                        motionEventData.setEventTime(motionEvent.getEventTime());
                        motionEventData.setPressure(motionEvent.getPressure());
                        motionEventData.setSize(motionEvent.getSize());
                        motionEventData.setToolType(motionEvent.getToolType(0));
                        motionEventData.setX(motionEvent.getX());
                        motionEventData.setY(motionEvent.getY());
                    }
                    if (motionEventData != null) {
                        this.d.add(motionEventData);
                    }
                }
                return false;
            }
        }
        z = false;
        if (z) {
        }
        return false;
    }

    @Override // com.alibaba.security.biometrics.sensor.a.a
    public final void a() throws RpSecException {
        if (this.e != null) {
            this.c = true;
            this.e.setOnTouchListener(this);
            return;
        }
        throw new RpSecException("No DecorView found from current activity while start", (int) RpSecException.EXCEPTION_NO_DECOR_VIEW_FOUND);
    }

    private boolean a(MotionEvent motionEvent) {
        if (!this.c) {
            return false;
        }
        int size = this.d.size();
        a aVar = this.b;
        int i = aVar.a;
        if (i > 300 || i <= 0) {
            aVar.a = 100;
        }
        if (size <= aVar.a) {
            return motionEvent.getAction() == 0 || motionEvent.getAction() == 2 || motionEvent.getAction() == 1;
        }
        return false;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.alibaba.security.biometrics.sensor.a.a
    public final /* bridge */ /* synthetic */ List<MotionEventData> b() {
        return this.d;
    }
}
