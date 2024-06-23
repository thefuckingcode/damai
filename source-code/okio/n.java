package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import javax.annotation.Nullable;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class n {
    @Nullable
    static m a;
    static long b;

    private n() {
    }

    static void a(m mVar) {
        if (mVar.f != null || mVar.g != null) {
            throw new IllegalArgumentException();
        } else if (!mVar.d) {
            synchronized (n.class) {
                long j = b;
                if (j + PlaybackStateCompat.ACTION_PLAY_FROM_URI <= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                    b = j + PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                    mVar.f = a;
                    mVar.c = 0;
                    mVar.b = 0;
                    a = mVar;
                }
            }
        }
    }

    static m b() {
        synchronized (n.class) {
            m mVar = a;
            if (mVar == null) {
                return new m();
            }
            a = mVar.f;
            mVar.f = null;
            b -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            return mVar;
        }
    }
}
