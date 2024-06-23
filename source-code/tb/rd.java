package tb;

import android.support.v4.media.session.PlaybackStateCompat;
import java.util.Arrays;
import java.util.Random;
import java.util.TreeSet;

/* compiled from: Taobao */
public class rd {
    public static final int MAX_POOL_SIZE = 524288;
    public static final String TAG = "awcn.ByteArrayPool";
    private final TreeSet<pd> a = new TreeSet<>();
    private final pd b = pd.b(0);
    private final Random c = new Random();
    private long d = 0;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a {
        static rd a = new rd();
    }

    public static rd a() {
        return a.a;
    }

    public synchronized void b(pd pdVar) {
        pd pdVar2;
        if (pdVar != null) {
            int i = pdVar.b;
            if (i < 524288) {
                this.d += (long) i;
                this.a.add(pdVar);
                while (this.d > PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                    if (this.c.nextBoolean()) {
                        pdVar2 = this.a.pollFirst();
                    } else {
                        pdVar2 = this.a.pollLast();
                    }
                    this.d -= (long) pdVar2.b;
                }
            }
        }
    }

    public synchronized pd c(int i) {
        if (i >= 524288) {
            return pd.b(i);
        }
        pd pdVar = this.b;
        pdVar.b = i;
        pd ceiling = this.a.ceiling(pdVar);
        if (ceiling == null) {
            ceiling = pd.b(i);
        } else {
            Arrays.fill(ceiling.a, (byte) 0);
            ceiling.c = 0;
            this.a.remove(ceiling);
            this.d -= (long) ceiling.b;
        }
        return ceiling;
    }

    public pd d(byte[] bArr, int i) {
        pd c2 = c(i);
        System.arraycopy(bArr, 0, c2.a, 0, i);
        c2.c = i;
        return c2;
    }
}
