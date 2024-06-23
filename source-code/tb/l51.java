package tb;

import java.lang.ref.WeakReference;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.pcollections.b;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class l51 {
    private static b<String, Object> a;

    static {
        b<String, Object> b = b.b();
        k21.h(b, "HashPMap.empty<String, Any>()");
        a = b;
    }

    @NotNull
    public static final <T> KClassImpl<T> a(@NotNull Class<T> cls) {
        k21.i(cls, "jClass");
        String name = cls.getName();
        Object c = a.c(name);
        Class<T> cls2 = null;
        if (c instanceof WeakReference) {
            KClassImpl<T> kClassImpl = (KClassImpl) ((WeakReference) c).get();
            if (kClassImpl != null) {
                cls2 = kClassImpl.getJClass();
            }
            if (k21.d(cls2, cls)) {
                return kClassImpl;
            }
        } else if (c != null) {
            for (WeakReference weakReference : (WeakReference[]) c) {
                KClassImpl<T> kClassImpl2 = (KClassImpl) weakReference.get();
                if (k21.d(kClassImpl2 != null ? kClassImpl2.getJClass() : null, cls)) {
                    return kClassImpl2;
                }
            }
            int length = ((Object[]) c).length;
            WeakReference[] weakReferenceArr = new WeakReference[(length + 1)];
            System.arraycopy(c, 0, weakReferenceArr, 0, length);
            KClassImpl<T> kClassImpl3 = new KClassImpl<>(cls);
            weakReferenceArr[length] = new WeakReference(kClassImpl3);
            b<String, Object> f = a.f(name, weakReferenceArr);
            k21.h(f, "K_CLASS_CACHE.plus(name, newArray)");
            a = f;
            return kClassImpl3;
        }
        KClassImpl<T> kClassImpl4 = new KClassImpl<>(cls);
        b<String, Object> f2 = a.f(name, new WeakReference(kClassImpl4));
        k21.h(f2, "K_CLASS_CACHE.plus(name, WeakReference(newKClass))");
        a = f2;
        return kClassImpl4;
    }
}
