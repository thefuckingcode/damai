package com.alibaba.responsive.page.orientation;

import android.app.Activity;
import android.view.OrientationEventListener;

/* compiled from: Taobao */
public class OrientationListener extends OrientationEventListener {
    public static int c = 1000;
    public static int d = 1001;
    public static int e = 1002;
    public static int f = 1003;
    public static int g = 1004;
    private OrientationChangeCallback a;
    private int b = c;

    /* compiled from: Taobao */
    public interface OrientationChangeCallback {
        void land();

        void port();

        void reverseLand();

        void reversePort();
    }

    public OrientationListener(Activity activity, OrientationChangeCallback orientationChangeCallback) {
        super(activity, 3);
        this.a = orientationChangeCallback;
    }

    public void a() {
        disable();
        this.b = c;
    }

    public void b() {
        if (canDetectOrientation()) {
            enable();
        }
    }

    public void c(int i) {
        this.b = i;
    }

    public void onOrientationChanged(int i) {
        OrientationChangeCallback orientationChangeCallback;
        OrientationChangeCallback orientationChangeCallback2;
        OrientationChangeCallback orientationChangeCallback3;
        OrientationChangeCallback orientationChangeCallback4;
        if ((i >= 0 && i <= 30) || (i >= 330 && i <= 360)) {
            if (!(this.b == d || (orientationChangeCallback = this.a) == null)) {
                orientationChangeCallback.port();
            }
            this.b = d;
        } else if (i >= 60 && i <= 120) {
            if (!(this.b == f || (orientationChangeCallback4 = this.a) == null)) {
                orientationChangeCallback4.reverseLand();
            }
            this.b = f;
        } else if (i >= 150 && i <= 210) {
            if (!(this.b == g || (orientationChangeCallback3 = this.a) == null)) {
                orientationChangeCallback3.reversePort();
            }
            this.b = g;
        } else if (i >= 240 && i <= 300) {
            if (!(this.b == e || (orientationChangeCallback2 = this.a) == null)) {
                orientationChangeCallback2.land();
            }
            this.b = e;
        }
    }
}
