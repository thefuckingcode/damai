package tb;

import kotlin.Result;

/* compiled from: Taobao */
public final class eh0 {
    private static final boolean a;

    static {
        Object obj;
        try {
            Result.a aVar = Result.Companion;
            obj = Result.m913constructorimpl(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            obj = Result.m913constructorimpl(k12.a(th));
        }
        a = Result.m920isSuccessimpl(obj);
    }

    public static final boolean a() {
        return a;
    }
}
