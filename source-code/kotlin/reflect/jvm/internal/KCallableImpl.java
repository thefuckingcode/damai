package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.collections.e;
import kotlin.collections.k;
import kotlin.collections.n;
import kotlin.coroutines.Continuation;
import kotlin.reflect.KCallable;
import kotlin.reflect.KParameter;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.reflect.full.IllegalCallableAccessException;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.az1;
import tb.h60;
import tb.k21;
import tb.s51;
import tb.vy1;
import tb.wt2;
import tb.z41;

/* compiled from: Taobao */
public abstract class KCallableImpl<R> implements KCallable<R>, KTypeParameterOwnerImpl {
    private final az1.a<List<Annotation>> a;
    private final az1.a<ArrayList<KParameter>> b;
    private final az1.a<KTypeImpl> c;
    private final az1.a<List<KTypeParameterImpl>> d;

    public KCallableImpl() {
        az1.a<List<Annotation>> d2 = az1.d(new KCallableImpl$_annotations$1(this));
        k21.h(d2, "ReflectProperties.lazySo…or.computeAnnotations() }");
        this.a = d2;
        az1.a<ArrayList<KParameter>> d3 = az1.d(new KCallableImpl$_parameters$1(this));
        k21.h(d3, "ReflectProperties.lazySo…ze()\n        result\n    }");
        this.b = d3;
        az1.a<KTypeImpl> d4 = az1.d(new KCallableImpl$_returnType$1(this));
        k21.h(d4, "ReflectProperties.lazySo…eturnType\n        }\n    }");
        this.c = d4;
        az1.a<List<KTypeParameterImpl>> d5 = az1.d(new KCallableImpl$_typeParameters$1(this));
        k21.h(d5, "ReflectProperties.lazySo…this, descriptor) }\n    }");
        this.d = d5;
    }

    private final R b(Map<KParameter, ? extends Object> map) {
        Object obj;
        List<KParameter> parameters = getParameters();
        ArrayList arrayList = new ArrayList(n.q(parameters, 10));
        for (T t : parameters) {
            if (map.containsKey(t)) {
                obj = map.get(t);
                if (obj == null) {
                    throw new IllegalArgumentException("Annotation argument value cannot be null (" + ((Object) t) + ')');
                }
            } else if (t.isOptional()) {
                obj = null;
            } else if (t.isVararg()) {
                obj = d(t.getType());
            } else {
                throw new IllegalArgumentException("No argument provided for a required parameter: " + ((Object) t));
            }
            arrayList.add(obj);
        }
        Caller<?> h = h();
        if (h != null) {
            try {
                Object[] array = arrayList.toArray(new Object[0]);
                if (array != null) {
                    return (R) h.call(array);
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            } catch (IllegalAccessException e) {
                throw new IllegalCallableAccessException(e);
            }
        } else {
            throw new KotlinReflectionInternalError("This callable does not support a default call: " + i());
        }
    }

    private final Object d(KType kType) {
        Class b2 = z41.b(s51.b(kType));
        if (b2.isArray()) {
            Object newInstance = Array.newInstance(b2.getComponentType(), 0);
            k21.h(newInstance, "type.jvmErasure.java.run…\"\n            )\n        }");
            return newInstance;
        }
        throw new KotlinReflectionInternalError("Cannot instantiate the default empty array of type " + b2.getSimpleName() + ", because it is not an array type");
    }

    /* access modifiers changed from: private */
    public final Type e() {
        Type[] lowerBounds;
        CallableMemberDescriptor i = i();
        if (!(i instanceof FunctionDescriptor)) {
            i = null;
        }
        FunctionDescriptor functionDescriptor = (FunctionDescriptor) i;
        if (functionDescriptor == null || !functionDescriptor.isSuspend()) {
            return null;
        }
        Object d0 = k.d0(f().getParameterTypes());
        if (!(d0 instanceof ParameterizedType)) {
            d0 = null;
        }
        ParameterizedType parameterizedType = (ParameterizedType) d0;
        if (!k21.d(parameterizedType != null ? parameterizedType.getRawType() : null, Continuation.class)) {
            return null;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        k21.h(actualTypeArguments, "continuationType.actualTypeArguments");
        Object L = e.L(actualTypeArguments);
        if (!(L instanceof WildcardType)) {
            L = null;
        }
        WildcardType wildcardType = (WildcardType) L;
        if (wildcardType == null || (lowerBounds = wildcardType.getLowerBounds()) == null) {
            return null;
        }
        return (Type) e.u(lowerBounds);
    }

    public final R c(@NotNull Map<KParameter, ? extends Object> map, @Nullable Continuation<?> continuation) {
        k21.i(map, "args");
        List<KParameter> parameters = getParameters();
        ArrayList arrayList = new ArrayList(parameters.size());
        ArrayList arrayList2 = new ArrayList(1);
        Iterator<KParameter> it = parameters.iterator();
        int i = 0;
        boolean z = false;
        int i2 = 0;
        while (true) {
            Object obj = null;
            if (it.hasNext()) {
                KParameter next = it.next();
                if (i != 0 && i % 32 == 0) {
                    arrayList2.add(Integer.valueOf(i2));
                    i2 = 0;
                }
                if (map.containsKey(next)) {
                    arrayList.add(map.get(next));
                } else if (next.isOptional()) {
                    if (!wt2.i(next.getType())) {
                        obj = wt2.e(vy1.a(next.getType()));
                    }
                    arrayList.add(obj);
                    i2 = (1 << (i % 32)) | i2;
                    z = true;
                } else if (next.isVararg()) {
                    arrayList.add(d(next.getType()));
                } else {
                    throw new IllegalArgumentException("No argument provided for a required parameter: " + next);
                }
                if (next.getKind() == KParameter.Kind.VALUE) {
                    i++;
                }
            } else {
                if (continuation != null) {
                    arrayList.add(continuation);
                }
                if (!z) {
                    Object[] array = arrayList.toArray(new Object[0]);
                    Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                    return call(Arrays.copyOf(array, array.length));
                }
                arrayList2.add(Integer.valueOf(i2));
                Caller<?> h = h();
                if (h != null) {
                    arrayList.addAll(arrayList2);
                    arrayList.add(null);
                    try {
                        Object[] array2 = arrayList.toArray(new Object[0]);
                        if (array2 != null) {
                            return (R) h.call(array2);
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    } catch (IllegalAccessException e) {
                        throw new IllegalCallableAccessException(e);
                    }
                } else {
                    throw new KotlinReflectionInternalError("This callable does not support a default call: " + i());
                }
            }
        }
    }

    @Override // kotlin.reflect.KCallable
    public R call(@NotNull Object... objArr) {
        k21.i(objArr, "args");
        try {
            return (R) f().call(objArr);
        } catch (IllegalAccessException e) {
            throw new IllegalCallableAccessException(e);
        }
    }

    @Override // kotlin.reflect.KCallable
    public R callBy(@NotNull Map<KParameter, ? extends Object> map) {
        k21.i(map, "args");
        return j() ? b(map) : c(map, null);
    }

    @NotNull
    public abstract Caller<?> f();

    @NotNull
    public abstract KDeclarationContainerImpl g();

    @Override // kotlin.reflect.KAnnotatedElement
    @NotNull
    public List<Annotation> getAnnotations() {
        List<Annotation> invoke = this.a.invoke();
        k21.h(invoke, "_annotations()");
        return invoke;
    }

    @Override // kotlin.reflect.KCallable
    @NotNull
    public List<KParameter> getParameters() {
        ArrayList<KParameter> invoke = this.b.invoke();
        k21.h(invoke, "_parameters()");
        return invoke;
    }

    @Override // kotlin.reflect.KCallable
    @NotNull
    public KType getReturnType() {
        KTypeImpl invoke = this.c.invoke();
        k21.h(invoke, "_returnType()");
        return invoke;
    }

    @Override // kotlin.reflect.KCallable
    @NotNull
    public List<KTypeParameter> getTypeParameters() {
        List<KTypeParameterImpl> invoke = this.d.invoke();
        k21.h(invoke, "_typeParameters()");
        return invoke;
    }

    @Override // kotlin.reflect.KCallable
    @Nullable
    public KVisibility getVisibility() {
        h60 visibility = i().getVisibility();
        k21.h(visibility, "descriptor.visibility");
        return wt2.o(visibility);
    }

    @Nullable
    public abstract Caller<?> h();

    @NotNull
    public abstract CallableMemberDescriptor i();

    @Override // kotlin.reflect.KCallable
    public boolean isAbstract() {
        return i().getModality() == Modality.ABSTRACT;
    }

    @Override // kotlin.reflect.KCallable
    public boolean isFinal() {
        return i().getModality() == Modality.FINAL;
    }

    @Override // kotlin.reflect.KCallable
    public boolean isOpen() {
        return i().getModality() == Modality.OPEN;
    }

    /* access modifiers changed from: protected */
    public final boolean j() {
        return k21.d(getName(), "<init>") && g().getJClass().isAnnotation();
    }

    public abstract boolean k();
}
