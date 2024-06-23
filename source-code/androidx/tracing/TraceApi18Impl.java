package androidx.tracing;

import android.os.Trace;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* access modifiers changed from: package-private */
@RequiresApi(18)
/* compiled from: Taobao */
public final class TraceApi18Impl {
    private TraceApi18Impl() {
    }

    public static void beginSection(@NonNull String str) {
        Trace.beginSection(str);
    }

    public static void endSection() {
        Trace.endSection();
    }
}
