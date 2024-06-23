package kotlin.reflect.jvm.internal;

import com.tencent.open.SocialConstants;
import com.tencent.open.SocialOperation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.k;
import kotlin.collections.w;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.o;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.az1;
import tb.d80;
import tb.dz1;
import tb.f22;
import tb.fy1;
import tb.g60;
import tb.h60;
import tb.i22;
import tb.jl1;
import tb.k21;
import tb.m40;
import tb.og1;
import tb.ur2;
import tb.v00;
import tb.zo;

/* compiled from: Taobao */
public abstract class KDeclarationContainerImpl implements ClassBasedDeclarationContainer {
    @NotNull
    public static final a Companion = new a(null);
    private static final Class<?> a = m40.class;
    @NotNull
    private static final Regex b = new Regex("<v#(\\d+)>");

    /* compiled from: Taobao */
    public abstract class Data {
        static final /* synthetic */ KProperty[] c = {dz1.i(new PropertyReference1Impl(dz1.b(Data.class), "moduleData", "getModuleData()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;"))};
        @NotNull
        private final az1.a a = az1.d(new KDeclarationContainerImpl$Data$moduleData$2(this));

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public Data() {
        }

        @NotNull
        public final f22 a() {
            return (f22) this.a.b(this, c[0]);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "member", "", "accept", "<init>", "(Ljava/lang/String;I)V", "DECLARED", "INHERITED", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    /* compiled from: Taobao */
    protected enum MemberBelonginess {
        DECLARED,
        INHERITED;

        public final boolean accept(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
            k21.i(callableMemberDescriptor, "member");
            CallableMemberDescriptor.Kind kind = callableMemberDescriptor.getKind();
            k21.h(kind, "member.kind");
            return kind.isReal() == (this == DECLARED);
        }
    }

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        @NotNull
        public final Regex a() {
            return KDeclarationContainerImpl.b;
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    /* compiled from: Taobao */
    static final class b<T> implements Comparator<h60> {
        public static final b INSTANCE = new b();

        b() {
        }

        /* renamed from: a */
        public final int compare(h60 h60, h60 h602) {
            Integer d = g60.d(h60, h602);
            if (d != null) {
                return d.intValue();
            }
            return 0;
        }
    }

    /* compiled from: Taobao */
    public static final class c extends zo {
        c(KDeclarationContainerImpl kDeclarationContainerImpl, KDeclarationContainerImpl kDeclarationContainerImpl2) {
            super(kDeclarationContainerImpl2);
        }

        @NotNull
        /* renamed from: e */
        public KCallableImpl<?> visitConstructorDescriptor(@NotNull ConstructorDescriptor constructorDescriptor, @NotNull ur2 ur2) {
            k21.i(constructorDescriptor, "descriptor");
            k21.i(ur2, "data");
            throw new IllegalStateException("No constructors should appear here: " + constructorDescriptor);
        }
    }

    private final void b(List<Class<?>> list, String str, boolean z) {
        List<Class<?>> o = o(str);
        list.addAll(o);
        int size = ((o.size() + 32) - 1) / 32;
        for (int i = 0; i < size; i++) {
            Class<?> cls = Integer.TYPE;
            k21.h(cls, "Integer.TYPE");
            list.add(cls);
        }
        Class cls2 = z ? a : Object.class;
        k21.h(cls2, "if (isConstructor) DEFAU…RKER else Any::class.java");
        list.add(cls2);
    }

    private final List<Class<?>> o(String str) {
        int i;
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        while (str.charAt(i2) != ')') {
            int i3 = i2;
            while (str.charAt(i3) == '[') {
                i3++;
            }
            char charAt = str.charAt(i3);
            if (StringsKt__StringsKt.P("VZCBSIFJD", charAt, false, 2, null)) {
                i = i3 + 1;
            } else if (charAt == 'L') {
                i = StringsKt__StringsKt.e0(str, d80.TokenSEM, i2, false, 4, null) + 1;
            } else {
                throw new KotlinReflectionInternalError("Unknown type prefix in the method signature: " + str);
            }
            arrayList.add(r(str, i2, i));
            i2 = i;
        }
        return arrayList;
    }

    private final Class<?> p(String str) {
        return r(str, StringsKt__StringsKt.e0(str, ')', 0, false, 6, null) + 1, str.length());
    }

    private final Method q(Class<?> cls, String str, Class<?>[] clsArr, Class<?> cls2, boolean z) {
        Method q;
        if (z) {
            clsArr[0] = cls;
        }
        Method t = t(cls, str, clsArr, cls2);
        if (t != null) {
            return t;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (!(superclass == null || (q = q(superclass, str, clsArr, cls2, z)) == null)) {
            return q;
        }
        Class<?>[] interfaces = cls.getInterfaces();
        for (Class<?> cls3 : interfaces) {
            k21.h(cls3, "superInterface");
            Method q2 = q(cls3, str, clsArr, cls2, z);
            if (q2 != null) {
                return q2;
            }
            if (z) {
                Class<?> a2 = fy1.a(ReflectClassUtilKt.g(cls3), cls3.getName() + "$DefaultImpls");
                if (a2 != null) {
                    clsArr[0] = cls3;
                    Method t2 = t(a2, str, clsArr, cls2);
                    if (t2 != null) {
                        return t2;
                    }
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    private final Class<?> r(String str, int i, int i2) {
        char charAt = str.charAt(i);
        if (charAt == 'F') {
            return Float.TYPE;
        }
        if (charAt == 'L') {
            ClassLoader g = ReflectClassUtilKt.g(getJClass());
            String substring = str.substring(i + 1, i2 - 1);
            k21.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            Class<?> loadClass = g.loadClass(o.E(substring, v00.DIR, '.', false, 4, null));
            k21.h(loadClass, "jClass.safeClassLoader.l…d - 1).replace('/', '.'))");
            return loadClass;
        } else if (charAt == 'S') {
            return Short.TYPE;
        } else {
            if (charAt == 'V') {
                Class<?> cls = Void.TYPE;
                k21.h(cls, "Void.TYPE");
                return cls;
            } else if (charAt == 'I') {
                return Integer.TYPE;
            } else {
                if (charAt == 'J') {
                    return Long.TYPE;
                }
                if (charAt == 'Z') {
                    return Boolean.TYPE;
                }
                if (charAt == '[') {
                    return ReflectClassUtilKt.a(r(str, i + 1, i2));
                }
                switch (charAt) {
                    case 'B':
                        return Byte.TYPE;
                    case 'C':
                        return Character.TYPE;
                    case 'D':
                        return Double.TYPE;
                    default:
                        throw new KotlinReflectionInternalError("Unknown type prefix in the method signature: " + str);
                }
            }
        }
    }

    private final Constructor<?> s(Class<?> cls, List<? extends Class<?>> list) {
        try {
            Object[] array = list.toArray(new Class[0]);
            if (array != null) {
                Class[] clsArr = (Class[]) array;
                return cls.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005a A[LOOP:0: B:6:0x0029->B:17:0x005a, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0058 A[SYNTHETIC] */
    private final Method t(Class<?> cls, String str, Class<?>[] clsArr, Class<?> cls2) {
        boolean z;
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
            k21.h(declaredMethod, "result");
            if (k21.d(declaredMethod.getReturnType(), cls2)) {
                return declaredMethod;
            }
            Method[] declaredMethods = cls.getDeclaredMethods();
            k21.h(declaredMethods, "declaredMethods");
            for (Method method : declaredMethods) {
                k21.h(method, "method");
                if (k21.d(method.getName(), str) && k21.d(method.getReturnType(), cls2)) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    k21.f(parameterTypes);
                    if (Arrays.equals(parameterTypes, clsArr)) {
                        z = true;
                        if (!z) {
                            return method;
                        }
                    }
                }
                z = false;
                if (!z) {
                }
            }
            return null;
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    @Nullable
    public final Constructor<?> c(@NotNull String str) {
        k21.i(str, SocialConstants.PARAM_APP_DESC);
        return s(getJClass(), o(str));
    }

    @Nullable
    public final Constructor<?> d(@NotNull String str) {
        k21.i(str, SocialConstants.PARAM_APP_DESC);
        Class<?> jClass = getJClass();
        ArrayList arrayList = new ArrayList();
        b(arrayList, str, true);
        ur2 ur2 = ur2.INSTANCE;
        return s(jClass, arrayList);
    }

    @Nullable
    public final Method e(@NotNull String str, @NotNull String str2, boolean z) {
        k21.i(str, "name");
        k21.i(str2, SocialConstants.PARAM_APP_DESC);
        if (k21.d(str, "<init>")) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (z) {
            arrayList.add(getJClass());
        }
        b(arrayList, str2, false);
        Class<?> m = m();
        String str3 = str + "$default";
        Object[] array = arrayList.toArray(new Class[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return q(m, str3, (Class[]) array, p(str2), z);
    }

    @NotNull
    public final FunctionDescriptor f(@NotNull String str, @NotNull String str2) {
        Collection<FunctionDescriptor> collection;
        k21.i(str, "name");
        k21.i(str2, SocialOperation.GAME_SIGNATURE);
        if (k21.d(str, "<init>")) {
            collection = CollectionsKt___CollectionsKt.y0(i());
        } else {
            og1 f = og1.f(str);
            k21.h(f, "Name.identifier(name)");
            collection = j(f);
        }
        ArrayList arrayList = new ArrayList();
        for (T t : collection) {
            if (k21.d(i22.INSTANCE.g(t).a(), str2)) {
                arrayList.add(t);
            }
        }
        boolean z = true;
        if (arrayList.size() == 1) {
            return (FunctionDescriptor) k.o0(arrayList);
        }
        String str3 = CollectionsKt___CollectionsKt.Z(collection, StringUtils.LF, null, null, 0, null, KDeclarationContainerImpl$findFunctionDescriptor$allMembers$1.INSTANCE, 30, null);
        StringBuilder sb = new StringBuilder();
        sb.append("Function '");
        sb.append(str);
        sb.append("' (JVM signature: ");
        sb.append(str2);
        sb.append(") not resolved in ");
        sb.append(this);
        sb.append(jl1.CONDITION_IF_MIDDLE);
        if (str3.length() != 0) {
            z = false;
        }
        sb.append(z ? " no members found" : '\n' + str3);
        throw new KotlinReflectionInternalError(sb.toString());
    }

    @Nullable
    public final Method g(@NotNull String str, @NotNull String str2) {
        Method q;
        k21.i(str, "name");
        k21.i(str2, SocialConstants.PARAM_APP_DESC);
        if (k21.d(str, "<init>")) {
            return null;
        }
        Object[] array = o(str2).toArray(new Class[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        Class<?>[] clsArr = (Class[]) array;
        Class<?> p = p(str2);
        Method q2 = q(m(), str, clsArr, p, false);
        if (q2 != null) {
            return q2;
        }
        if (!m().isInterface() || (q = q(Object.class, str, clsArr, p, false)) == null) {
            return null;
        }
        return q;
    }

    @NotNull
    public final PropertyDescriptor h(@NotNull String str, @NotNull String str2) {
        k21.i(str, "name");
        k21.i(str2, SocialOperation.GAME_SIGNATURE);
        MatchResult matchEntire = b.matchEntire(str2);
        boolean z = true;
        if (matchEntire != null) {
            String str3 = matchEntire.getDestructured().a().getGroupValues().get(1);
            PropertyDescriptor k = k(Integer.parseInt(str3));
            if (k != null) {
                return k;
            }
            throw new KotlinReflectionInternalError("Local property #" + str3 + " not found in " + getJClass());
        }
        og1 f = og1.f(str);
        k21.h(f, "Name.identifier(name)");
        Collection<PropertyDescriptor> n = n(f);
        ArrayList arrayList = new ArrayList();
        for (T t : n) {
            if (k21.d(i22.INSTANCE.f(t).a(), str2)) {
                arrayList.add(t);
            }
        }
        if (arrayList.isEmpty()) {
            throw new KotlinReflectionInternalError("Property '" + str + "' (JVM signature: " + str2 + ") not resolved in " + this);
        } else if (arrayList.size() == 1) {
            return (PropertyDescriptor) k.o0(arrayList);
        } else {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : arrayList) {
                h60 visibility = ((PropertyDescriptor) obj).getVisibility();
                Object obj2 = linkedHashMap.get(visibility);
                if (obj2 == null) {
                    obj2 = new ArrayList();
                    linkedHashMap.put(visibility, obj2);
                }
                ((List) obj2).add(obj);
            }
            Collection values = w.h(linkedHashMap, b.INSTANCE).values();
            k21.h(values, "properties\n             …                }).values");
            List list = (List) k.a0(values);
            if (list.size() == 1) {
                k21.h(list, "mostVisibleProperties");
                return (PropertyDescriptor) k.P(list);
            }
            og1 f2 = og1.f(str);
            k21.h(f2, "Name.identifier(name)");
            String str4 = CollectionsKt___CollectionsKt.Z(n(f2), StringUtils.LF, null, null, 0, null, KDeclarationContainerImpl$findPropertyDescriptor$allMembers$1.INSTANCE, 30, null);
            StringBuilder sb = new StringBuilder();
            sb.append("Property '");
            sb.append(str);
            sb.append("' (JVM signature: ");
            sb.append(str2);
            sb.append(") not resolved in ");
            sb.append(this);
            sb.append(jl1.CONDITION_IF_MIDDLE);
            if (str4.length() != 0) {
                z = false;
            }
            sb.append(z ? " no members found" : '\n' + str4);
            throw new KotlinReflectionInternalError(sb.toString());
        }
    }

    @NotNull
    public abstract Collection<ConstructorDescriptor> i();

    @NotNull
    public abstract Collection<FunctionDescriptor> j(@NotNull og1 og1);

    @Nullable
    public abstract PropertyDescriptor k(int i);

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x001e A[SYNTHETIC] */
    @NotNull
    public final Collection<KCallableImpl<?>> l(@NotNull MemberScope memberScope, @NotNull MemberBelonginess memberBelonginess) {
        KCallableImpl kCallableImpl;
        k21.i(memberScope, "scope");
        k21.i(memberBelonginess, "belonginess");
        c cVar = new c(this, this);
        Collection<DeclarationDescriptor> a2 = ResolutionScope.a.a(memberScope, null, null, 3, null);
        ArrayList arrayList = new ArrayList();
        for (DeclarationDescriptor declarationDescriptor : a2) {
            if (declarationDescriptor instanceof CallableMemberDescriptor) {
                CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) declarationDescriptor;
                if ((!k21.d(callableMemberDescriptor.getVisibility(), g60.INVISIBLE_FAKE)) && memberBelonginess.accept(callableMemberDescriptor)) {
                    kCallableImpl = (KCallableImpl) declarationDescriptor.accept(cVar, ur2.INSTANCE);
                    if (kCallableImpl == null) {
                        arrayList.add(kCallableImpl);
                    }
                }
            }
            kCallableImpl = null;
            if (kCallableImpl == null) {
            }
        }
        return CollectionsKt___CollectionsKt.y0(arrayList);
    }

    /* access modifiers changed from: protected */
    @NotNull
    public Class<?> m() {
        Class<?> h = ReflectClassUtilKt.h(getJClass());
        return h != null ? h : getJClass();
    }

    @NotNull
    public abstract Collection<PropertyDescriptor> n(@NotNull og1 og1);
}
