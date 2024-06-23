package tb;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.os.TraceCompat;
import com.airbnb.lottie.network.LottieNetworkCacheProvider;
import com.airbnb.lottie.network.LottieNetworkFetcher;
import com.airbnb.lottie.network.b;
import com.airbnb.lottie.network.c;
import com.airbnb.lottie.network.d;
import java.io.File;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* compiled from: Taobao */
public class k61 {
    public static final String TAG = "LOTTIE";
    public static boolean a;
    private static boolean b;
    private static String[] c;
    private static long[] d;
    private static int e;
    private static int f;
    private static LottieNetworkFetcher g;
    private static LottieNetworkCacheProvider h;
    private static volatile d i;
    private static volatile c j;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements LottieNetworkCacheProvider {
        final /* synthetic */ Context a;

        a(Context context) {
            this.a = context;
        }

        @Override // com.airbnb.lottie.network.LottieNetworkCacheProvider
        @NonNull
        public File getCacheDir() {
            return new File(this.a.getCacheDir(), "lottie_network_cache");
        }
    }

    public static void a(String str) {
        if (b) {
            int i2 = e;
            if (i2 == 20) {
                f++;
                return;
            }
            c[i2] = str;
            d[i2] = System.nanoTime();
            TraceCompat.beginSection(str);
            e++;
        }
    }

    public static float b(String str) {
        int i2 = f;
        if (i2 > 0) {
            f = i2 - 1;
            return 0.0f;
        } else if (!b) {
            return 0.0f;
        } else {
            int i3 = e - 1;
            e = i3;
            if (i3 == -1) {
                throw new IllegalStateException("Can't end trace section. There are none.");
            } else if (str.equals(c[i3])) {
                TraceCompat.endSection();
                return ((float) (System.nanoTime() - d[e])) / 1000000.0f;
            } else {
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + c[e] + ".");
            }
        }
    }

    @NonNull
    public static c c(@NonNull Context context) {
        c cVar = j;
        if (cVar == null) {
            synchronized (c.class) {
                cVar = j;
                if (cVar == null) {
                    LottieNetworkCacheProvider lottieNetworkCacheProvider = h;
                    if (lottieNetworkCacheProvider == null) {
                        lottieNetworkCacheProvider = new a(context);
                    }
                    cVar = new c(lottieNetworkCacheProvider);
                    j = cVar;
                }
            }
        }
        return cVar;
    }

    @NonNull
    public static d d(@NonNull Context context) {
        d dVar = i;
        if (dVar == null) {
            synchronized (d.class) {
                dVar = i;
                if (dVar == null) {
                    c c2 = c(context);
                    LottieNetworkFetcher lottieNetworkFetcher = g;
                    if (lottieNetworkFetcher == null) {
                        lottieNetworkFetcher = new b();
                    }
                    dVar = new d(c2, lottieNetworkFetcher);
                    i = dVar;
                }
            }
        }
        return dVar;
    }
}
