package kotlin.reflect;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.k;
import kotlin.collections.n;
import kotlin.jvm.internal.KTypeBase;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.sequences.d;
import kotlin.text.o;
import tb.k21;
import tb.r51;
import tb.z41;

public final class TypesJVMKt {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KVariance.values().length];
            iArr[KVariance.IN.ordinal()] = 1;
            iArr[KVariance.INVARIANT.ordinal()] = 2;
            iArr[KVariance.OUT.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final Type c(KType kType, boolean z) {
        int i;
        KClassifier classifier = kType.getClassifier();
        if (classifier instanceof KTypeParameter) {
            return new b((KTypeParameter) classifier);
        }
        if (classifier instanceof KClass) {
            KClass kClass = (KClass) classifier;
            Class c = z ? z41.c(kClass) : z41.b(kClass);
            List<r51> arguments = kType.getArguments();
            if (arguments.isEmpty()) {
                return c;
            }
            if (!c.isArray()) {
                return e(c, arguments);
            }
            if (c.getComponentType().isPrimitive()) {
                return c;
            }
            r51 r51 = (r51) k.q0(arguments);
            if (r51 != null) {
                KVariance a2 = r51.a();
                KType b = r51.b();
                if (a2 == null) {
                    i = -1;
                } else {
                    i = a.$EnumSwitchMapping$0[a2.ordinal()];
                }
                if (i == -1 || i == 1) {
                    return c;
                }
                if (i == 2 || i == 3) {
                    k21.f(b);
                    Type d = d(b, false, 1, null);
                    return d instanceof Class ? c : new a(d);
                }
                throw new NoWhenBranchMatchedException();
            }
            throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + kType);
        }
        throw new UnsupportedOperationException("Unsupported type classifier: " + kType);
    }

    static /* synthetic */ Type d(KType kType, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return c(kType, z);
    }

    private static final Type e(Class<?> cls, List<r51> list) {
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            ArrayList arrayList = new ArrayList(n.q(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(g(it.next()));
            }
            return new ParameterizedTypeImpl(cls, null, arrayList);
        } else if (Modifier.isStatic(cls.getModifiers())) {
            ArrayList arrayList2 = new ArrayList(n.q(list, 10));
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList2.add(g(it2.next()));
            }
            return new ParameterizedTypeImpl(cls, declaringClass, arrayList2);
        } else {
            int length = cls.getTypeParameters().length;
            Type e = e(declaringClass, list.subList(length, list.size()));
            List<r51> subList = list.subList(0, length);
            ArrayList arrayList3 = new ArrayList(n.q(subList, 10));
            Iterator<T> it3 = subList.iterator();
            while (it3.hasNext()) {
                arrayList3.add(g(it3.next()));
            }
            return new ParameterizedTypeImpl(cls, e, arrayList3);
        }
    }

    public static final Type f(KType kType) {
        Type javaType;
        k21.i(kType, "<this>");
        if (!(kType instanceof KTypeBase) || (javaType = ((KTypeBase) kType).getJavaType()) == null) {
            return d(kType, false, 1, null);
        }
        return javaType;
    }

    private static final Type g(r51 r51) {
        KVariance d = r51.d();
        if (d == null) {
            return c.Companion.a();
        }
        KType c = r51.c();
        k21.f(c);
        int i = a.$EnumSwitchMapping$0[d.ordinal()];
        if (i == 1) {
            return new c(null, c(c, true));
        }
        if (i == 2) {
            return c(c, true);
        }
        if (i == 3) {
            return new c(c(c, true), null);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final String h(Type type) {
        String str;
        if (!(type instanceof Class)) {
            return type.toString();
        }
        Class cls = (Class) type;
        if (cls.isArray()) {
            Sequence sequence = SequencesKt__SequencesKt.h(type, TypesJVMKt$typeToString$unwrap$1.INSTANCE);
            str = ((Class) d.u(sequence)).getName() + o.B("[]", SequencesKt___SequencesKt.m(sequence));
        } else {
            str = cls.getName();
        }
        k21.h(str, "{\n        if (type.isArr…   } else type.name\n    }");
        return str;
    }
}
