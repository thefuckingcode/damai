package tb;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class ze1 {
    private static final ConcurrentMap<xy2, WeakReference<f22>> a = new ConcurrentHashMap();

    @NotNull
    public static final f22 a(@NotNull Class<?> cls) {
        k21.i(cls, "$this$getOrCreateModule");
        ClassLoader g = ReflectClassUtilKt.g(cls);
        xy2 xy2 = new xy2(g);
        ConcurrentMap<xy2, WeakReference<f22>> concurrentMap = a;
        WeakReference<f22> weakReference = concurrentMap.get(xy2);
        if (weakReference != null) {
            f22 f22 = weakReference.get();
            if (f22 != null) {
                k21.h(f22, AdvanceSetting.NETWORK_TYPE);
                return f22;
            }
            concurrentMap.remove(xy2, weakReference);
        }
        f22 a2 = f22.Companion.a(g);
        while (true) {
            try {
                ConcurrentMap<xy2, WeakReference<f22>> concurrentMap2 = a;
                WeakReference<f22> putIfAbsent = concurrentMap2.putIfAbsent(xy2, new WeakReference<>(a2));
                if (putIfAbsent != null) {
                    f22 f222 = putIfAbsent.get();
                    if (f222 != null) {
                        return f222;
                    }
                    concurrentMap2.remove(xy2, putIfAbsent);
                } else {
                    xy2.a(null);
                    return a2;
                }
            } finally {
                xy2.a(null);
            }
        }
    }
}
