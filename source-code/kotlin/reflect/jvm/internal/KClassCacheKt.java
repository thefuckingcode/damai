package kotlin.reflect.jvm.internal;

import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.pcollections.HashPMap;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0005\u001a\u00020\u0006H\u0000\u001a&\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\b\b\u0000\u0010\t*\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000bH\u0000\"*\u0010\u0000\u001a\u001e\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00040\u00040\u0001X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"K_CLASS_CACHE", "Lkotlin/reflect/jvm/internal/pcollections/HashPMap;", "", "kotlin.jvm.PlatformType", "", "clearKClassCache", "", "getOrCreateKotlinClass", "Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "jClass", "Ljava/lang/Class;", "kotlin-reflection"}, k = 2, mv = {1, 1, 16})
/* compiled from: kClassCache.kt */
public final class KClassCacheKt {
    private static HashPMap<String, Object> K_CLASS_CACHE;

    static {
        HashPMap<String, Object> empty = HashPMap.empty();
        Intrinsics.checkExpressionValueIsNotNull(empty, "HashPMap.empty<String, Any>()");
        K_CLASS_CACHE = empty;
    }

    public static final <T> KClassImpl<T> getOrCreateKotlinClass(Class<T> cls) {
        Intrinsics.checkParameterIsNotNull(cls, "jClass");
        String name = cls.getName();
        Object obj = K_CLASS_CACHE.get(name);
        Class<T> cls2 = null;
        if (obj instanceof WeakReference) {
            KClassImpl<T> kClassImpl = (KClassImpl) ((WeakReference) obj).get();
            if (kClassImpl != null) {
                cls2 = kClassImpl.getJClass();
            }
            if (Intrinsics.areEqual(cls2, cls)) {
                return kClassImpl;
            }
        } else if (obj != null) {
            for (WeakReference weakReference : (WeakReference[]) obj) {
                KClassImpl<T> kClassImpl2 = (KClassImpl) weakReference.get();
                if (Intrinsics.areEqual(kClassImpl2 != null ? kClassImpl2.getJClass() : null, cls)) {
                    return kClassImpl2;
                }
            }
            int length = ((Object[]) obj).length;
            WeakReference[] weakReferenceArr = new WeakReference[(length + 1)];
            System.arraycopy(obj, 0, weakReferenceArr, 0, length);
            KClassImpl<T> kClassImpl3 = new KClassImpl<>(cls);
            weakReferenceArr[length] = new WeakReference(kClassImpl3);
            HashPMap<String, Object> plus = K_CLASS_CACHE.plus(name, weakReferenceArr);
            Intrinsics.checkExpressionValueIsNotNull(plus, "K_CLASS_CACHE.plus(name, newArray)");
            K_CLASS_CACHE = plus;
            return kClassImpl3;
        }
        KClassImpl<T> kClassImpl4 = new KClassImpl<>(cls);
        HashPMap<String, Object> plus2 = K_CLASS_CACHE.plus(name, new WeakReference(kClassImpl4));
        Intrinsics.checkExpressionValueIsNotNull(plus2, "K_CLASS_CACHE.plus(name, WeakReference(newKClass))");
        K_CLASS_CACHE = plus2;
        return kClassImpl4;
    }

    public static final void clearKClassCache() {
        HashPMap<String, Object> empty = HashPMap.empty();
        Intrinsics.checkExpressionValueIsNotNull(empty, "HashPMap.empty()");
        K_CLASS_CACHE = empty;
    }
}
