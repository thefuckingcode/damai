package kotlin.reflect.jvm.internal.calls;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.n;
import kotlin.collections.x;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;

/* compiled from: Taobao */
public final class AnnotationConstructorCaller implements Caller {
    @NotNull
    private final List<Type> a;
    private final List<Class<?>> b;
    private final List<Object> c;
    private final Class<?> d;
    private final List<String> e;
    private final CallMode f;
    private final List<Method> g;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;", "", "<init>", "(Ljava/lang/String;I)V", "CALL_BY_NAME", "POSITIONAL_CALL", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    /* compiled from: Taobao */
    public enum CallMode {
        CALL_BY_NAME,
        POSITIONAL_CALL
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;", "", "<init>", "(Ljava/lang/String;I)V", "JAVA", "KOTLIN", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    /* compiled from: Taobao */
    public enum Origin {
        JAVA,
        KOTLIN
    }

    public AnnotationConstructorCaller(@NotNull Class<?> cls, @NotNull List<String> list, @NotNull CallMode callMode, @NotNull Origin origin, @NotNull List<Method> list2) {
        k21.i(cls, "jClass");
        k21.i(list, "parameterNames");
        k21.i(callMode, "callMode");
        k21.i(origin, "origin");
        k21.i(list2, "methods");
        this.d = cls;
        this.e = list;
        this.f = callMode;
        this.g = list2;
        ArrayList arrayList = new ArrayList(n.q(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getGenericReturnType());
        }
        this.a = arrayList;
        List<Method> list3 = this.g;
        ArrayList arrayList2 = new ArrayList(n.q(list3, 10));
        Iterator<T> it2 = list3.iterator();
        while (it2.hasNext()) {
            Class<?> returnType = it2.next().getReturnType();
            k21.h(returnType, AdvanceSetting.NETWORK_TYPE);
            Class<?> h = ReflectClassUtilKt.h(returnType);
            if (h != null) {
                returnType = h;
            }
            arrayList2.add(returnType);
        }
        this.b = arrayList2;
        List<Method> list4 = this.g;
        ArrayList arrayList3 = new ArrayList(n.q(list4, 10));
        Iterator<T> it3 = list4.iterator();
        while (it3.hasNext()) {
            arrayList3.add(it3.next().getDefaultValue());
        }
        this.c = arrayList3;
        if (this.f == CallMode.POSITIONAL_CALL && origin == Origin.JAVA && (!CollectionsKt___CollectionsKt.h0(this.e, "value").isEmpty())) {
            throw new UnsupportedOperationException("Positional call of a Java annotation constructor is allowed only if there are no parameters or one parameter named \"value\". This restriction exists because Java annotations (in contrast to Kotlin)do not impose any order on their arguments. Use KCallable#callBy instead.");
        }
    }

    public void a(@NotNull Object[] objArr) {
        k21.i(objArr, "args");
        Caller.a.a(this, objArr);
    }

    @Nullable
    public Void b() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    @Nullable
    public Object call(@NotNull Object[] objArr) {
        Object obj;
        k21.i(objArr, "args");
        a(objArr);
        ArrayList arrayList = new ArrayList(objArr.length);
        int length = objArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            Object obj2 = objArr[i];
            int i3 = i2 + 1;
            if (obj2 == null && this.f == CallMode.CALL_BY_NAME) {
                obj = this.c.get(i2);
            } else {
                obj = AnnotationConstructorCallerKt.b(obj2, this.b.get(i2));
            }
            if (obj != null) {
                arrayList.add(obj);
                i++;
                i2 = i3;
            } else {
                AnnotationConstructorCallerKt.a(i2, this.e.get(i2), this.b.get(i2));
                throw null;
            }
        }
        return AnnotationConstructorCallerKt.c(this.d, x.r(CollectionsKt___CollectionsKt.F0(this.e, arrayList)), this.g);
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public /* bridge */ /* synthetic */ Member getMember() {
        return (Member) b();
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    @NotNull
    public List<Type> getParameterTypes() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    @NotNull
    public Type getReturnType() {
        return this.d;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public /* synthetic */ AnnotationConstructorCaller(Class cls, List list, CallMode callMode, Origin origin, List list2, int i, m40 m40) {
        this(cls, list, callMode, origin, list2);
        if ((i & 16) != 0) {
            list2 = new ArrayList(n.q(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                list2.add(cls.getDeclaredMethod((String) it.next(), new Class[0]));
            }
        }
    }
}
