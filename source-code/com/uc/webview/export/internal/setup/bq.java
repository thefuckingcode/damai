package com.uc.webview.export.internal.setup;

import android.util.Pair;
import com.uc.webview.export.cyclone.UCElapseTime;

/* compiled from: Taobao */
public final class bq {
    private Pair<Integer, Object> a = new Pair<>(-1, null);
    private boolean b = false;

    public final void a(int i, Object obj) {
        synchronized (this) {
            this.a = new Pair<>(Integer.valueOf(i), obj);
            try {
                notify();
            } catch (Exception unused) {
            }
        }
    }

    public final Pair<Integer, Object> a(long j) {
        UCElapseTime uCElapseTime = new UCElapseTime();
        synchronized (this) {
            if (((Integer) this.a.first).intValue() != -1) {
                return this.a;
            }
            long j2 = 0;
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i > 0) {
                j2 = 100;
            }
            this.b = true;
            while (true) {
                if (uCElapseTime.getMilis() >= j) {
                    if (i > 0) {
                        this.b = false;
                        return new Pair<>(1, null);
                    }
                }
                try {
                    wait(Math.max(j2, j - uCElapseTime.getMilis()));
                    if (((Integer) this.a.first).intValue() != -1) {
                        this.b = false;
                        return this.a;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final synchronized boolean a() {
        return this.b;
    }
}
