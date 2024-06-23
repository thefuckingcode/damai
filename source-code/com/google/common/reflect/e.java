package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.reflect.Types;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.rk1;

@Beta
/* compiled from: Taobao */
public final class e {
    private final c a;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a extends f {
        final /* synthetic */ Map b;
        final /* synthetic */ Type c;

        a(Map map, Type type) {
            this.b = map;
            this.c = type;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.reflect.f
        public void b(Class<?> cls) {
            if (!(this.c instanceof WildcardType)) {
                throw new IllegalArgumentException("No type mapping from " + cls + " to " + this.c);
            }
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.reflect.f
        public void c(GenericArrayType genericArrayType) {
            Type type = this.c;
            if (!(type instanceof WildcardType)) {
                Type j = Types.j(type);
                ds1.k(j != null, "%s is not an array type.", this.c);
                e.g(this.b, genericArrayType.getGenericComponentType(), j);
            }
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.reflect.f
        public void d(ParameterizedType parameterizedType) {
            Type type = this.c;
            if (!(type instanceof WildcardType)) {
                ParameterizedType parameterizedType2 = (ParameterizedType) e.e(ParameterizedType.class, type);
                if (!(parameterizedType.getOwnerType() == null || parameterizedType2.getOwnerType() == null)) {
                    e.g(this.b, parameterizedType.getOwnerType(), parameterizedType2.getOwnerType());
                }
                ds1.l(parameterizedType.getRawType().equals(parameterizedType2.getRawType()), "Inconsistent raw type: %s vs. %s", parameterizedType, this.c);
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
                ds1.l(actualTypeArguments.length == actualTypeArguments2.length, "%s not compatible with %s", parameterizedType, parameterizedType2);
                for (int i = 0; i < actualTypeArguments.length; i++) {
                    e.g(this.b, actualTypeArguments[i], actualTypeArguments2[i]);
                }
            }
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.reflect.f
        public void e(TypeVariable<?> typeVariable) {
            this.b.put(new d(typeVariable), this.c);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.reflect.f
        public void f(WildcardType wildcardType) {
            Type type = this.c;
            if (type instanceof WildcardType) {
                WildcardType wildcardType2 = (WildcardType) type;
                Type[] upperBounds = wildcardType.getUpperBounds();
                Type[] upperBounds2 = wildcardType2.getUpperBounds();
                Type[] lowerBounds = wildcardType.getLowerBounds();
                Type[] lowerBounds2 = wildcardType2.getLowerBounds();
                ds1.l(upperBounds.length == upperBounds2.length && lowerBounds.length == lowerBounds2.length, "Incompatible type: %s vs. %s", wildcardType, this.c);
                for (int i = 0; i < upperBounds.length; i++) {
                    e.g(this.b, upperBounds[i], upperBounds2[i]);
                }
                for (int i2 = 0; i2 < lowerBounds.length; i2++) {
                    e.g(this.b, lowerBounds[i2], lowerBounds2[i2]);
                }
            }
        }
    }

    /* compiled from: Taobao */
    private static final class b extends f {
        private final Map<d, Type> b = Maps.p();

        private b() {
        }

        static ImmutableMap<d, Type> g(Type type) {
            ds1.p(type);
            b bVar = new b();
            bVar.a(type);
            return ImmutableMap.copyOf(bVar.b);
        }

        private void h(d dVar, Type type) {
            if (!this.b.containsKey(dVar)) {
                Type type2 = type;
                while (type2 != null) {
                    if (dVar.a(type2)) {
                        while (type != null) {
                            type = this.b.remove(d.c(type));
                        }
                        return;
                    }
                    type2 = this.b.get(d.c(type2));
                }
                this.b.put(dVar, type);
            }
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.reflect.f
        public void b(Class<?> cls) {
            a(cls.getGenericSuperclass());
            a(cls.getGenericInterfaces());
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.reflect.f
        public void d(ParameterizedType parameterizedType) {
            Class cls = (Class) parameterizedType.getRawType();
            TypeVariable[] typeParameters = cls.getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            ds1.w(typeParameters.length == actualTypeArguments.length);
            for (int i = 0; i < typeParameters.length; i++) {
                h(new d(typeParameters[i]), actualTypeArguments[i]);
            }
            a(cls);
            a(parameterizedType.getOwnerType());
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.reflect.f
        public void e(TypeVariable<?> typeVariable) {
            a(typeVariable.getBounds());
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.reflect.f
        public void f(WildcardType wildcardType) {
            a(wildcardType.getUpperBounds());
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class d {
        private final TypeVariable<?> a;

        d(TypeVariable<?> typeVariable) {
            this.a = (TypeVariable) ds1.p(typeVariable);
        }

        private boolean b(TypeVariable<?> typeVariable) {
            return this.a.getGenericDeclaration().equals(typeVariable.getGenericDeclaration()) && this.a.getName().equals(typeVariable.getName());
        }

        static d c(Type type) {
            if (type instanceof TypeVariable) {
                return new d((TypeVariable) type);
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public boolean a(Type type) {
            if (type instanceof TypeVariable) {
                return b((TypeVariable) type);
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return b(((d) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return rk1.b(this.a.getGenericDeclaration(), this.a.getName());
        }

        public String toString() {
            return this.a.toString();
        }
    }

    /* renamed from: com.google.common.reflect.e$e  reason: collision with other inner class name */
    /* compiled from: Taobao */
    private static class C0170e {
        static final C0170e b = new C0170e();
        private final AtomicInteger a;

        /* access modifiers changed from: package-private */
        /* renamed from: com.google.common.reflect.e$e$a */
        /* compiled from: Taobao */
        public class a extends C0170e {
            final /* synthetic */ TypeVariable c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C0170e eVar, AtomicInteger atomicInteger, TypeVariable typeVariable) {
                super(atomicInteger, null);
                this.c = typeVariable;
            }

            /* access modifiers changed from: package-private */
            @Override // com.google.common.reflect.e.C0170e
            public TypeVariable<?> b(Type[] typeArr) {
                LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList(typeArr));
                linkedHashSet.addAll(Arrays.asList(this.c.getBounds()));
                if (linkedHashSet.size() > 1) {
                    linkedHashSet.remove(Object.class);
                }
                return super.b((Type[]) linkedHashSet.toArray(new Type[0]));
            }
        }

        /* synthetic */ C0170e(AtomicInteger atomicInteger, a aVar) {
            this(atomicInteger);
        }

        private Type c(@NullableDecl Type type) {
            if (type == null) {
                return null;
            }
            return a(type);
        }

        private C0170e d(TypeVariable<?> typeVariable) {
            return new a(this, this.a, typeVariable);
        }

        private C0170e e() {
            return new C0170e(this.a);
        }

        /* access modifiers changed from: package-private */
        public final Type a(Type type) {
            ds1.p(type);
            if ((type instanceof Class) || (type instanceof TypeVariable)) {
                return type;
            }
            if (type instanceof GenericArrayType) {
                return Types.k(e().a(((GenericArrayType) type).getGenericComponentType()));
            }
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Class cls = (Class) parameterizedType.getRawType();
                TypeVariable<?>[] typeParameters = cls.getTypeParameters();
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                for (int i = 0; i < actualTypeArguments.length; i++) {
                    actualTypeArguments[i] = d(typeParameters[i]).a(actualTypeArguments[i]);
                }
                return Types.n(e().c(parameterizedType.getOwnerType()), cls, actualTypeArguments);
            } else if (type instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                return wildcardType.getLowerBounds().length == 0 ? b(wildcardType.getUpperBounds()) : type;
            } else {
                throw new AssertionError("must have been one of the known types");
            }
        }

        /* access modifiers changed from: package-private */
        public TypeVariable<?> b(Type[] typeArr) {
            return Types.l(C0170e.class, "capture#" + this.a.incrementAndGet() + "-of ? extends " + com.google.common.base.d.f('&').e(typeArr), typeArr);
        }

        private C0170e() {
            this(new AtomicInteger());
        }

        private C0170e(AtomicInteger atomicInteger) {
            this.a = atomicInteger;
        }
    }

    /* synthetic */ e(c cVar, a aVar) {
        this(cVar);
    }

    static e d(Type type) {
        return new e().o(b.g(type));
    }

    /* access modifiers changed from: private */
    public static <T> T e(Class<T> cls, Object obj) {
        try {
            return cls.cast(obj);
        } catch (ClassCastException unused) {
            throw new IllegalArgumentException(obj + " is not a " + cls.getSimpleName());
        }
    }

    static e f(Type type) {
        return new e().o(b.g(C0170e.b.a(type)));
    }

    /* access modifiers changed from: private */
    public static void g(Map<d, Type> map, Type type, Type type2) {
        if (!type.equals(type2)) {
            new a(map, type2).a(type);
        }
    }

    private Type h(GenericArrayType genericArrayType) {
        return Types.k(j(genericArrayType.getGenericComponentType()));
    }

    private ParameterizedType i(ParameterizedType parameterizedType) {
        Type type;
        Type ownerType = parameterizedType.getOwnerType();
        if (ownerType == null) {
            type = null;
        } else {
            type = j(ownerType);
        }
        return Types.n(type, (Class) j(parameterizedType.getRawType()), k(parameterizedType.getActualTypeArguments()));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Type[] k(Type[] typeArr) {
        Type[] typeArr2 = new Type[typeArr.length];
        for (int i = 0; i < typeArr.length; i++) {
            typeArr2[i] = j(typeArr[i]);
        }
        return typeArr2;
    }

    private WildcardType m(WildcardType wildcardType) {
        return new Types.WildcardTypeImpl(k(wildcardType.getLowerBounds()), k(wildcardType.getUpperBounds()));
    }

    public Type j(Type type) {
        ds1.p(type);
        if (type instanceof TypeVariable) {
            return this.a.a((TypeVariable) type);
        }
        if (type instanceof ParameterizedType) {
            return i((ParameterizedType) type);
        }
        if (type instanceof GenericArrayType) {
            return h((GenericArrayType) type);
        }
        return type instanceof WildcardType ? m((WildcardType) type) : type;
    }

    /* access modifiers changed from: package-private */
    public Type[] l(Type[] typeArr) {
        for (int i = 0; i < typeArr.length; i++) {
            typeArr[i] = j(typeArr[i]);
        }
        return typeArr;
    }

    public e n(Type type, Type type2) {
        HashMap p = Maps.p();
        g(p, (Type) ds1.p(type), (Type) ds1.p(type2));
        return o(p);
    }

    /* access modifiers changed from: package-private */
    public e o(Map<d, ? extends Type> map) {
        return new e(this.a.c(map));
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class c {
        private final ImmutableMap<d, Type> a;

        /* access modifiers changed from: package-private */
        /* compiled from: Taobao */
        public class a extends c {
            final /* synthetic */ TypeVariable b;
            final /* synthetic */ c c;

            a(c cVar, TypeVariable typeVariable, c cVar2) {
                this.b = typeVariable;
                this.c = cVar2;
            }

            @Override // com.google.common.reflect.e.c
            public Type b(TypeVariable<?> typeVariable, c cVar) {
                if (typeVariable.getGenericDeclaration().equals(this.b.getGenericDeclaration())) {
                    return typeVariable;
                }
                return this.c.b(typeVariable, cVar);
            }
        }

        c() {
            this.a = ImmutableMap.of();
        }

        /* access modifiers changed from: package-private */
        public final Type a(TypeVariable<?> typeVariable) {
            return b(typeVariable, new a(this, typeVariable, this));
        }

        /* access modifiers changed from: package-private */
        public Type b(TypeVariable<?> typeVariable, c cVar) {
            Type type = this.a.get(new d(typeVariable));
            if (type != null) {
                return new e(cVar, null).j(type);
            }
            Type[] bounds = typeVariable.getBounds();
            if (bounds.length == 0) {
                return typeVariable;
            }
            Type[] k = new e(cVar, null).k(bounds);
            if (!Types.c.a || !Arrays.equals(bounds, k)) {
                return Types.l(typeVariable.getGenericDeclaration(), typeVariable.getName(), k);
            }
            return typeVariable;
        }

        /* access modifiers changed from: package-private */
        public final c c(Map<d, ? extends Type> map) {
            ImmutableMap.b builder = ImmutableMap.builder();
            builder.f(this.a);
            for (Map.Entry<d, ? extends Type> entry : map.entrySet()) {
                d key = entry.getKey();
                Type type = (Type) entry.getValue();
                ds1.k(!key.a(type), "Type variable %s bound to itself", key);
                builder.c(key, type);
            }
            return new c(builder.a());
        }

        private c(ImmutableMap<d, Type> immutableMap) {
            this.a = immutableMap;
        }
    }

    public e() {
        this.a = new c();
    }

    private e(c cVar) {
        this.a = cVar;
    }
}
