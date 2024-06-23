package tb;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.jvm.JvmField;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.internal.MainDispatcherFactory;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class ya1 {
    @NotNull
    public static final ya1 INSTANCE;
    private static final boolean a = mh2.e("kotlinx.coroutines.fast.service.loader", true);
    @JvmField
    @NotNull
    public static final xa1 dispatcher;

    static {
        ya1 ya1 = new ya1();
        INSTANCE = ya1;
        dispatcher = ya1.a();
    }

    private ya1() {
    }

    private final xa1 a() {
        List<MainDispatcherFactory> list;
        Object obj;
        try {
            if (a) {
                list = dh0.INSTANCE.c();
            } else {
                list = SequencesKt___SequencesKt.B(SequencesKt__SequencesKt.c(ServiceLoader.load(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader()).iterator()));
            }
            Iterator it = list.iterator();
            if (!it.hasNext()) {
                obj = null;
            } else {
                obj = it.next();
                if (it.hasNext()) {
                    int loadPriority = ((MainDispatcherFactory) obj).getLoadPriority();
                    do {
                        Object next = it.next();
                        int loadPriority2 = ((MainDispatcherFactory) next).getLoadPriority();
                        if (loadPriority < loadPriority2) {
                            obj = next;
                            loadPriority = loadPriority2;
                        }
                    } while (it.hasNext());
                }
            }
            MainDispatcherFactory mainDispatcherFactory = (MainDispatcherFactory) obj;
            if (mainDispatcherFactory == null) {
                return za1.b(null, null, 3, null);
            }
            return za1.d(mainDispatcherFactory, list);
        } catch (Throwable th) {
            return za1.b(th, null, 2, null);
        }
    }
}
