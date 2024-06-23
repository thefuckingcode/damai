package kotlin.reflect.full;

import java.util.Arrays;
import java.util.Map;
import kotlin.SinceKotlin;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.dz1;
import tb.k12;
import tb.k21;
import tb.ld2;
import tb.p30;
import tb.ur2;
import tb.wt2;

@JvmName(name = "KCallables")
/* compiled from: Taobao */
public final class KCallables {
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @SinceKotlin(version = "1.3")
    @Nullable
    public static final <R> Object a(@NotNull KCallable<? extends R> kCallable, @NotNull Object[] objArr, @NotNull Continuation<? super R> continuation) {
        KCallables$callSuspend$1 kCallables$callSuspend$1;
        int i;
        if (continuation instanceof KCallables$callSuspend$1) {
            kCallables$callSuspend$1 = (KCallables$callSuspend$1) continuation;
            int i2 = kCallables$callSuspend$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                kCallables$callSuspend$1.label = i2 - Integer.MIN_VALUE;
                Object obj = kCallables$callSuspend$1.result;
                Object obj2 = b.d();
                i = kCallables$callSuspend$1.label;
                if (i != 0) {
                    k12.b(obj);
                    if (!kCallable.isSuspend()) {
                        return kCallable.call(Arrays.copyOf(objArr, objArr.length));
                    }
                    if (kCallable instanceof KFunction) {
                        kCallables$callSuspend$1.L$0 = kCallable;
                        kCallables$callSuspend$1.L$1 = objArr;
                        kCallables$callSuspend$1.label = 1;
                        ld2 ld2 = new ld2(2);
                        ld2.b(objArr);
                        ld2.a(kCallables$callSuspend$1);
                        obj = kCallable.call(ld2.d(new Object[ld2.c()]));
                        if (obj == b.d()) {
                            p30.c(kCallables$callSuspend$1);
                        }
                        if (obj == obj2) {
                            return obj2;
                        }
                    } else {
                        throw new IllegalArgumentException("Cannot callSuspend on a property " + kCallable + ": suspend properties are not supported yet");
                    }
                } else if (i == 1) {
                    Object[] objArr2 = (Object[]) kCallables$callSuspend$1.L$1;
                    kCallable = (KCallable) kCallables$callSuspend$1.L$0;
                    k12.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return (k21.d(kCallable.getReturnType().getClassifier(), dz1.b(ur2.class)) || kCallable.getReturnType().isMarkedNullable()) ? obj : ur2.INSTANCE;
            }
        }
        kCallables$callSuspend$1 = new KCallables$callSuspend$1(continuation);
        Object obj3 = kCallables$callSuspend$1.result;
        Object obj22 = b.d();
        i = kCallables$callSuspend$1.label;
        if (i != 0) {
        }
        if (k21.d(kCallable.getReturnType().getClassifier(), dz1.b(ur2.class))) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @SinceKotlin(version = "1.3")
    @Nullable
    public static final <R> Object b(@NotNull KCallable<? extends R> kCallable, @NotNull Map<KParameter, ? extends Object> map, @NotNull Continuation<? super R> continuation) {
        KCallables$callSuspendBy$1 kCallables$callSuspendBy$1;
        int i;
        if (continuation instanceof KCallables$callSuspendBy$1) {
            kCallables$callSuspendBy$1 = (KCallables$callSuspendBy$1) continuation;
            int i2 = kCallables$callSuspendBy$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                kCallables$callSuspendBy$1.label = i2 - Integer.MIN_VALUE;
                Object obj = kCallables$callSuspendBy$1.result;
                Object obj2 = b.d();
                i = kCallables$callSuspendBy$1.label;
                if (i != 0) {
                    k12.b(obj);
                    if (!kCallable.isSuspend()) {
                        return kCallable.callBy(map);
                    }
                    if (kCallable instanceof KFunction) {
                        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                        T t = (T) wt2.a(kCallable);
                        if (t != null) {
                            ref$ObjectRef.element = t;
                            kCallables$callSuspendBy$1.L$0 = kCallable;
                            kCallables$callSuspendBy$1.L$1 = map;
                            kCallables$callSuspendBy$1.L$2 = ref$ObjectRef;
                            kCallables$callSuspendBy$1.label = 1;
                            obj = t.c(map, kCallables$callSuspendBy$1);
                            if (obj == b.d()) {
                                p30.c(kCallables$callSuspendBy$1);
                            }
                            if (obj == obj2) {
                                return obj2;
                            }
                        } else {
                            throw new KotlinReflectionInternalError("This callable does not support a default call: " + kCallable);
                        }
                    } else {
                        throw new IllegalArgumentException("Cannot callSuspendBy on a property " + kCallable + ": suspend properties are not supported yet");
                    }
                } else if (i == 1) {
                    Ref$ObjectRef ref$ObjectRef2 = (Ref$ObjectRef) kCallables$callSuspendBy$1.L$2;
                    Map map2 = (Map) kCallables$callSuspendBy$1.L$1;
                    kCallable = (KCallable) kCallables$callSuspendBy$1.L$0;
                    k12.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return (k21.d(kCallable.getReturnType().getClassifier(), dz1.b(ur2.class)) || kCallable.getReturnType().isMarkedNullable()) ? obj : ur2.INSTANCE;
            }
        }
        kCallables$callSuspendBy$1 = new KCallables$callSuspendBy$1(continuation);
        Object obj3 = kCallables$callSuspendBy$1.result;
        Object obj22 = b.d();
        i = kCallables$callSuspendBy$1.label;
        if (i != 0) {
        }
        if (k21.d(kCallable.getReturnType().getClassifier(), dz1.b(ur2.class))) {
        }
    }
}
