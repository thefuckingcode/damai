package com.alibaba.poplayer.layermanager.view.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.view.MotionEvent;
import com.alibaba.poplayer.layermanager.b;
import com.alibaba.poplayer.layermanager.view.Canvas;
import com.alibaba.poplayer.layermanager.view.app.AppLayerNotify;
import tb.cr1;
import tb.eu2;

/* compiled from: Taobao */
public class a implements AppLayerNotify.AppBackgroundNotify {
    public static final String TAG = "a";
    private MutableContextWrapper a;
    private AppLayer b;
    private Canvas c;
    private b d;
    private AppLayerNotify e;
    private int f = 0;

    public a(b bVar, Application application) {
        this.a = new MutableContextWrapper(application);
        this.f = eu2.d(application.getResources());
        Canvas canvas = new Canvas(this.a);
        this.c = canvas;
        bVar.f(canvas);
        AppLayer appLayer = new AppLayer(this.a);
        this.b = appLayer;
        appLayer.d(this.c);
        this.d = new b(this);
        this.e = new AppLayerNotify(application, this);
    }

    /* access modifiers changed from: package-private */
    public boolean a(MotionEvent motionEvent) {
        Canvas canvas;
        try {
            if (this.b.c() && (canvas = this.c) != null) {
                if (!canvas.all().isEmpty()) {
                    if (this.c.getVisibility() == 0 && this.c.getParent() != null) {
                        return this.c.dispatchTouchEvent(motionEvent);
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable th) {
            cr1.c("dispatchTouchEvent.error", th);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f;
    }

    public void c() {
        if (this.c.getVisibility() != 8) {
            cr1.b("%s.hideCanvas", TAG);
            this.c.setVisibility(8);
        }
    }

    /* access modifiers changed from: package-private */
    public void d(Activity activity) {
        this.e.e();
    }

    /* access modifiers changed from: package-private */
    public void e(Activity activity) {
        if (this.c.all().size() > 0 && !this.b.c()) {
            h(activity);
        }
        this.e.f();
    }

    public void f() {
        cr1.b("%s.removeLayer", TAG);
        this.e.g();
        this.d.d();
        this.b.a();
    }

    public void g() {
        if (this.c.getVisibility() != 0) {
            cr1.b("%s.showCanvas", TAG);
            this.c.setVisibility(0);
        }
    }

    public void h(Activity activity) {
        if (!this.b.c()) {
            this.d.b(activity);
            cr1.b("%s.showLayerWithActivity.", TAG);
            if (this.c.getParent() == null) {
                this.b.d(this.c);
            }
            g();
            this.b.e();
        }
    }

    public void i(Context context) {
        this.a.setBaseContext(context);
    }

    @Override // com.alibaba.poplayer.layermanager.view.app.AppLayerNotify.AppBackgroundNotify
    public void onKeepInBackground() {
        cr1.b("%s.onKeepInBackground", TAG);
        this.b.a();
    }

    @Override // com.alibaba.poplayer.layermanager.view.app.AppLayerNotify.AppBackgroundNotify
    public void onQuicklyIntoBackground() {
        cr1.b("%s.onQuicklyIntoBackground", TAG);
        c();
    }
}
