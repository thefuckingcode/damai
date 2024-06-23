package tb;

import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlinx.coroutines.internal.MainDispatcherFactory;

public final class za1 {
    private static final boolean a;

    private static final ie1 a(Throwable th, String str) {
        if (a) {
            return new ie1(th, str);
        }
        if (th == null) {
            c();
            throw new KotlinNothingValueException();
        }
        throw th;
    }

    static /* synthetic */ ie1 b(Throwable th, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        return a(th, str);
    }

    public static final Void c() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    public static final xa1 d(MainDispatcherFactory mainDispatcherFactory, List<? extends MainDispatcherFactory> list) {
        try {
            return mainDispatcherFactory.createDispatcher(list);
        } catch (Throwable th) {
            return a(th, mainDispatcherFactory.hintOnError());
        }
    }
}
