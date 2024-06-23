package tb;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class ou0<T> extends WeakReference<T> {
    @JvmField
    public final int a;

    public ou0(T t, @Nullable ReferenceQueue<T> referenceQueue) {
        super(t, referenceQueue);
        this.a = t != null ? t.hashCode() : 0;
    }
}
