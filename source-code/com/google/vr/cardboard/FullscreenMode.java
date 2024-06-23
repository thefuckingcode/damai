package com.google.vr.cardboard;

import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.view.Window;

/* compiled from: Taobao */
public class FullscreenMode {
    private final Window a;

    public FullscreenMode(Window window) {
        this.a = window;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void c() {
        this.a.getDecorView().setSystemUiVisibility(5894);
    }

    private void d() {
        if (Build.VERSION.SDK_INT < 19) {
            final Handler handler = new Handler();
            this.a.getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
                /* class com.google.vr.cardboard.FullscreenMode.AnonymousClass1 */

                public void onSystemUiVisibilityChange(int i) {
                    if ((i & 2) == 0) {
                        handler.postDelayed(new Runnable() {
                            /* class com.google.vr.cardboard.FullscreenMode.AnonymousClass1.AnonymousClass1 */

                            public void run() {
                                FullscreenMode.this.c();
                            }
                        }, 2000);
                    }
                }
            });
        }
    }

    public void b() {
        c();
        d();
    }
}
