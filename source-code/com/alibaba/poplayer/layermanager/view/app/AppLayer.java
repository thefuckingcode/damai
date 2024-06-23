package com.alibaba.poplayer.layermanager.view.app;

import android.content.Context;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.Toast;
import com.alibaba.poplayer.layermanager.view.Canvas;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import tb.cr1;

/* compiled from: Taobao */
public class AppLayer {
    public static final int LENGTH_ALWAYS = 0;
    private static final String l = "AppLayer";
    private Toast a;
    private Context b;
    private int c = 0;
    private int d = -1;
    private boolean e = false;
    private Object f;
    private Method g;
    private Method h;
    private WindowManager.LayoutParams i;
    private Handler j = new Handler();
    private Runnable k = new Runnable() {
        /* class com.alibaba.poplayer.layermanager.view.app.AppLayer.AnonymousClass1 */

        public void run() {
            AppLayer.this.a();
        }
    };

    public AppLayer(Context context) {
        this.b = context;
        if (this.a == null) {
            this.a = new Toast(this.b);
        }
        this.c = 0;
        this.d = 16973824;
    }

    private void b() {
        try {
            Field declaredField = this.a.getClass().getDeclaredField("mTN");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this.a);
            this.f = obj;
            this.g = obj.getClass().getMethod("show", new Class[0]);
            this.h = this.f.getClass().getMethod("hide", new Class[0]);
            Field declaredField2 = this.f.getClass().getDeclaredField("mParams");
            declaredField2.setAccessible(true);
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) declaredField2.get(this.f);
            this.i = layoutParams;
            layoutParams.flags = 56;
            int i2 = this.d;
            if (i2 != -1) {
                layoutParams.windowAnimations = i2;
            }
            Field declaredField3 = this.f.getClass().getDeclaredField("mNextView");
            declaredField3.setAccessible(true);
            declaredField3.set(this.f, this.a.getView());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.a.setGravity(119, 0, 0);
    }

    public void a() {
        if (this.e) {
            cr1.b("%s.hide", l);
            try {
                this.h.invoke(this.f, new Object[0]);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.e = false;
        }
    }

    public boolean c() {
        return this.e;
    }

    public void d(Canvas canvas) {
        this.a.setView(canvas);
    }

    public void e() {
        if (!this.e) {
            if (this.a.getView() == null) {
                cr1.b("%s.show error.", l);
                return;
            }
            cr1.b("%s.show", l);
            b();
            try {
                this.g.invoke(this.f, new Object[0]);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.e = true;
            int i2 = this.c;
            if (i2 > 0) {
                this.j.postDelayed(this.k, (long) (i2 * 1000));
            }
        }
    }
}
