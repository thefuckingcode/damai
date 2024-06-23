package com.meizu.cloud.pushsdk.c.g;

import android.support.v4.media.session.PlaybackStateCompat;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class k {
    private static j a;
    private static long b;

    private k() {
    }

    static j a() {
        synchronized (k.class) {
            j jVar = a;
            if (jVar == null) {
                return new j();
            }
            a = jVar.f;
            jVar.f = null;
            b -= 2048;
            return jVar;
        }
    }

    static void a(j jVar) {
        if (jVar.f != null || jVar.g != null) {
            throw new IllegalArgumentException();
        } else if (!jVar.d) {
            synchronized (k.class) {
                long j = b;
                if (j + 2048 <= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                    b = j + 2048;
                    jVar.f = a;
                    jVar.c = 0;
                    jVar.b = 0;
                    a = jVar;
                }
            }
        }
    }
}
