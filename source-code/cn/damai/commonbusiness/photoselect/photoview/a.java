package cn.damai.commonbusiness.photoselect.photoview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class a {
    private static transient /* synthetic */ IpChange $ipChange;
    private int a = -1;
    private int b = 0;
    private final ScaleGestureDetector c;
    private VelocityTracker d;
    private boolean e;
    private float f;
    private float g;
    private final float h;
    private final float i;
    private OnGestureListener j;

    /* renamed from: cn.damai.commonbusiness.photoselect.photoview.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public class ScaleGestureDetector$OnScaleGestureListenerC0018a implements ScaleGestureDetector.OnScaleGestureListener {
        private static transient /* synthetic */ IpChange $ipChange;

        ScaleGestureDetector$OnScaleGestureListenerC0018a() {
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-736818659")) {
                return ((Boolean) ipChange.ipc$dispatch("-736818659", new Object[]{this, scaleGestureDetector})).booleanValue();
            }
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                return false;
            }
            a.this.j.onScale(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            return true;
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-946158098")) {
                return true;
            }
            return ((Boolean) ipChange.ipc$dispatch("-946158098", new Object[]{this, scaleGestureDetector})).booleanValue();
        }

        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "909949340")) {
                ipChange.ipc$dispatch("909949340", new Object[]{this, scaleGestureDetector});
            }
        }
    }

    a(Context context, OnGestureListener onGestureListener) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.i = (float) viewConfiguration.getScaledMinimumFlingVelocity();
        this.h = (float) viewConfiguration.getScaledTouchSlop();
        this.j = onGestureListener;
        this.c = new ScaleGestureDetector(context, new ScaleGestureDetector$OnScaleGestureListenerC0018a());
    }

    private float b(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1406552226")) {
            return ((Float) ipChange.ipc$dispatch("1406552226", new Object[]{this, motionEvent})).floatValue();
        }
        try {
            return motionEvent.getX(this.b);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    private float c(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1417868353")) {
            return ((Float) ipChange.ipc$dispatch("1417868353", new Object[]{this, motionEvent})).floatValue();
        }
        try {
            return motionEvent.getY(this.b);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    private boolean g(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "676605664")) {
            return ((Boolean) ipChange.ipc$dispatch("676605664", new Object[]{this, motionEvent})).booleanValue();
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.a = motionEvent.getPointerId(0);
            VelocityTracker obtain = VelocityTracker.obtain();
            this.d = obtain;
            if (obtain != null) {
                obtain.addMovement(motionEvent);
            }
            this.f = b(motionEvent);
            this.g = c(motionEvent);
            this.e = false;
        } else if (action == 1) {
            this.a = -1;
            if (this.e && this.d != null) {
                this.f = b(motionEvent);
                this.g = c(motionEvent);
                this.d.addMovement(motionEvent);
                this.d.computeCurrentVelocity(1000);
                float xVelocity = this.d.getXVelocity();
                float yVelocity = this.d.getYVelocity();
                if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.i) {
                    this.j.onFling(this.f, this.g, -xVelocity, -yVelocity);
                }
            }
            VelocityTracker velocityTracker = this.d;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.d = null;
            }
        } else if (action == 2) {
            float b2 = b(motionEvent);
            float c2 = c(motionEvent);
            float f2 = b2 - this.f;
            float f3 = c2 - this.g;
            if (!this.e) {
                this.e = Math.sqrt((double) ((f2 * f2) + (f3 * f3))) >= ((double) this.h);
            }
            if (this.e) {
                this.j.onDrag(f2, f3);
                this.f = b2;
                this.g = c2;
                VelocityTracker velocityTracker2 = this.d;
                if (velocityTracker2 != null) {
                    velocityTracker2.addMovement(motionEvent);
                }
            }
        } else if (action == 3) {
            this.a = -1;
            VelocityTracker velocityTracker3 = this.d;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.d = null;
            }
        } else if (action == 6) {
            int b3 = b.b(motionEvent.getAction());
            if (motionEvent.getPointerId(b3) == this.a) {
                int i3 = b3 == 0 ? 1 : 0;
                this.a = motionEvent.getPointerId(i3);
                this.f = motionEvent.getX(i3);
                this.g = motionEvent.getY(i3);
            }
        }
        int i4 = this.a;
        if (i4 != -1) {
            i2 = i4;
        }
        this.b = motionEvent.findPointerIndex(i2);
        return true;
    }

    public boolean d() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-435577596")) {
            return this.e;
        }
        return ((Boolean) ipChange.ipc$dispatch("-435577596", new Object[]{this})).booleanValue();
    }

    public boolean e() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1909553688")) {
            return this.c.isInProgress();
        }
        return ((Boolean) ipChange.ipc$dispatch("1909553688", new Object[]{this})).booleanValue();
    }

    public boolean f(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1271890824")) {
            return ((Boolean) ipChange.ipc$dispatch("-1271890824", new Object[]{this, motionEvent})).booleanValue();
        }
        try {
            this.c.onTouchEvent(motionEvent);
            return g(motionEvent);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }
}
