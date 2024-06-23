package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Result;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import tb.bl;
import tb.k12;
import tb.k21;
import tb.z41;

/* compiled from: Taobao */
public final class ExceptionsConstuctorKt {
    private static final int a = d(Throwable.class, -1);
    @NotNull
    private static final ReentrantReadWriteLock b = new ReentrantReadWriteLock();
    @NotNull
    private static final WeakHashMap<Class<? extends Throwable>, Function1<Throwable, Throwable>> c = new WeakHashMap<>();

    /* compiled from: Taobao */
    public static final class a<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return bl.a(Integer.valueOf(t2.getParameterTypes().length), Integer.valueOf(t.getParameterTypes().length));
        }
    }

    private static final Function1<Throwable, Throwable> a(Constructor<?> constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        int length = parameterTypes.length;
        if (length == 0) {
            return new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$4(constructor);
        }
        if (length == 1) {
            Class<?> cls = parameterTypes[0];
            if (k21.d(cls, Throwable.class)) {
                return new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$2(constructor);
            }
            if (k21.d(cls, String.class)) {
                return new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$3(constructor);
            }
            return null;
        } else if (length == 2 && k21.d(parameterTypes[0], String.class) && k21.d(parameterTypes[1], Throwable.class)) {
            return new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$1(constructor);
        } else {
            return null;
        }
    }

    private static final int b(Class<?> cls, int i) {
        do {
            Field[] declaredFields = cls.getDeclaredFields();
            int length = declaredFields.length;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                if (!Modifier.isStatic(declaredFields[i3].getModifiers())) {
                    i2++;
                }
            }
            i += i2;
            cls = cls.getSuperclass();
        } while (cls != null);
        return i;
    }

    static /* synthetic */ int c(Class cls, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return b(cls, i);
    }

    private static final int d(Class<?> cls, int i) {
        Integer num;
        z41.e(cls);
        try {
            Result.a aVar = Result.Companion;
            num = Result.m913constructorimpl(Integer.valueOf(c(cls, 0, 1, null)));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            num = Result.m913constructorimpl(k12.a(th));
        }
        Integer valueOf = Integer.valueOf(i);
        if (Result.m919isFailureimpl(num)) {
            num = valueOf;
        }
        return ((Number) num).intValue();
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.visitors.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:451)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:436)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:408)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
        */
    @org.jetbrains.annotations.Nullable
    public static final <E extends java.lang.Throwable> E e(@org.jetbrains.annotations.NotNull E r9) {
        /*
        // Method dump skipped, instructions count: 287
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.ExceptionsConstuctorKt.e(java.lang.Throwable):java.lang.Throwable");
    }
}
