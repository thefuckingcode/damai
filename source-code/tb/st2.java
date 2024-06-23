package tb;

import java.util.concurrent.ThreadFactory;
import okhttp3.internal.a;

/* compiled from: Taobao */
public final /* synthetic */ class st2 implements ThreadFactory {
    public final /* synthetic */ String a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ st2(String str, boolean z) {
        this.a = str;
        this.b = z;
    }

    public final Thread newThread(Runnable runnable) {
        return a.B(this.a, this.b, runnable);
    }
}
