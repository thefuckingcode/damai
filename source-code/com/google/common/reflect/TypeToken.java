package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.collect.n;
import com.google.common.collect.v;
import com.google.common.reflect.Types;
import com.google.common.reflect.b;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.jl1;
import tb.ls1;
import tb.wr2;

@Beta
/* compiled from: Taobao */
public abstract class TypeToken<T> extends c<T> implements Serializable {
    private static final long serialVersionUID = 3637540370352322684L;
    @MonotonicNonNullDecl
    private transient e covariantTypeResolver;
    @MonotonicNonNullDecl
    private transient e invariantTypeResolver;
    private final Type runtimeType;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public final class ClassSet extends TypeToken<T>.TypeSet {
        private static final long serialVersionUID = 0;
        @MonotonicNonNullDecl
        private transient ImmutableSet<TypeToken<? super T>> classes;

        private ClassSet() {
            super();
        }

        private Object readResolve() {
            return TypeToken.this.getTypes().classes();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet classes() {
            return this;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet interfaces() {
            throw new UnsupportedOperationException("classes().interfaces() not supported.");
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf((Collection) f.b.a().c(TypeToken.this.getRawTypes()));
        }

        /* synthetic */ ClassSet(TypeToken typeToken, a aVar) {
            this();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.collect.o, com.google.common.collect.o, com.google.common.reflect.TypeToken.TypeSet, com.google.common.reflect.TypeToken.TypeSet, com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.t, com.google.common.collect.v, com.google.common.collect.v, com.google.common.collect.v
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.classes;
            if (immutableSet != null) {
                return immutableSet;
            }
            ImmutableSet<TypeToken<? super T>> f = n.d(f.a.a().d(TypeToken.this)).c(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).f();
            this.classes = f;
            return f;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class SimpleTypeToken<T> extends TypeToken<T> {
        private static final long serialVersionUID = 0;

        SimpleTypeToken(Type type) {
            super(type, null);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public enum TypeFilter implements Predicate<TypeToken<?>> {
        IGNORE_TYPE_VARIABLE_OR_WILDCARD {
            public boolean apply(TypeToken<?> typeToken) {
                return !(((TypeToken) typeToken).runtimeType instanceof TypeVariable) && !(((TypeToken) typeToken).runtimeType instanceof WildcardType);
            }
        },
        INTERFACE_ONLY {
            public boolean apply(TypeToken<?> typeToken) {
                return typeToken.getRawType().isInterface();
            }
        };

        /* synthetic */ TypeFilter(a aVar) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a extends b.C0169b<T> {
        a(Method method) {
            super(method);
        }

        @Override // com.google.common.reflect.a
        public TypeToken<T> a() {
            return TypeToken.this;
        }

        @Override // com.google.common.reflect.a
        public String toString() {
            return a() + "." + super.toString();
        }
    }

    /* compiled from: Taobao */
    class b extends b.a<T> {
        b(Constructor constructor) {
            super(constructor);
        }

        @Override // com.google.common.reflect.a
        public TypeToken<T> a() {
            return TypeToken.this;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.reflect.b.a
        public Type[] b() {
            return TypeToken.this.getInvariantTypeResolver().l(super.b());
        }

        @Override // com.google.common.reflect.a
        public String toString() {
            return a() + jl1.BRACKET_START_STR + com.google.common.base.d.g(AVFSCacheConstants.COMMA_SEP).e(b()) + jl1.BRACKET_END_STR;
        }
    }

    /* compiled from: Taobao */
    class c extends f {
        c() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.reflect.f
        public void c(GenericArrayType genericArrayType) {
            a(genericArrayType.getGenericComponentType());
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.reflect.f
        public void d(ParameterizedType parameterizedType) {
            a(parameterizedType.getActualTypeArguments());
            a(parameterizedType.getOwnerType());
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.reflect.f
        public void e(TypeVariable<?> typeVariable) {
            throw new IllegalArgumentException(TypeToken.this.runtimeType + "contains a type variable and is not safe for the operation");
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.reflect.f
        public void f(WildcardType wildcardType) {
            a(wildcardType.getLowerBounds());
            a(wildcardType.getUpperBounds());
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class d extends f {
        final /* synthetic */ ImmutableSet.a b;

        d(TypeToken typeToken, ImmutableSet.a aVar) {
            this.b = aVar;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.reflect.f
        public void b(Class<?> cls) {
            this.b.a(cls);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.reflect.f
        public void c(GenericArrayType genericArrayType) {
            this.b.a(Types.i(TypeToken.of(genericArrayType.getGenericComponentType()).getRawType()));
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.reflect.f
        public void d(ParameterizedType parameterizedType) {
            this.b.a((Class) parameterizedType.getRawType());
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

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class e {
        private final Type[] a;
        private final boolean b;

        e(Type[] typeArr, boolean z) {
            this.a = typeArr;
            this.b = z;
        }

        /* access modifiers changed from: package-private */
        public boolean a(Type type) {
            for (Type type2 : this.a) {
                boolean isSubtypeOf = TypeToken.of(type2).isSubtypeOf(type);
                boolean z = this.b;
                if (isSubtypeOf == z) {
                    return z;
                }
            }
            return !this.b;
        }

        /* access modifiers changed from: package-private */
        public boolean b(Type type) {
            TypeToken<?> of = TypeToken.of(type);
            for (Type type2 : this.a) {
                boolean isSubtypeOf = of.isSubtypeOf(type2);
                boolean z = this.b;
                if (isSubtypeOf == z) {
                    return z;
                }
            }
            return !this.b;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static abstract class f<K> {
        static final f<TypeToken<?>> a = new a();
        static final f<Class<?>> b = new b();

        /* compiled from: Taobao */
        static class a extends f<TypeToken<?>> {
            a() {
                super(null);
            }

            /* access modifiers changed from: package-private */
            /* renamed from: i */
            public Iterable<? extends TypeToken<?>> e(TypeToken<?> typeToken) {
                return typeToken.getGenericInterfaces();
            }

            /* access modifiers changed from: package-private */
            /* renamed from: j */
            public Class<?> f(TypeToken<?> typeToken) {
                return typeToken.getRawType();
            }

            /* access modifiers changed from: package-private */
            @NullableDecl
            /* renamed from: k */
            public TypeToken<?> g(TypeToken<?> typeToken) {
                return typeToken.getGenericSuperclass();
            }
        }

        /* compiled from: Taobao */
        static class b extends f<Class<?>> {
            b() {
                super(null);
            }

            /* access modifiers changed from: package-private */
            /* renamed from: i */
            public Iterable<? extends Class<?>> e(Class<?> cls) {
                return Arrays.asList(cls.getInterfaces());
            }

            /* access modifiers changed from: package-private */
            /* renamed from: j */
            public Class<?> f(Class<?> cls) {
                return cls;
            }

            /* access modifiers changed from: package-private */
            @NullableDecl
            /* renamed from: k */
            public Class<?> g(Class<?> cls) {
                return cls.getSuperclass();
            }
        }

        /* access modifiers changed from: package-private */
        /* compiled from: Taobao */
        public class c extends e<K> {
            c(f fVar, f fVar2) {
                super(fVar2);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.common.reflect.TypeToken$f$c */
            /* JADX WARN: Multi-variable type inference failed */
            /* access modifiers changed from: package-private */
            @Override // com.google.common.reflect.TypeToken.f
            public ImmutableList<K> c(Iterable<? extends K> iterable) {
                ImmutableList.a builder = ImmutableList.builder();
                for (Object obj : iterable) {
                    if (!f(obj).isInterface()) {
                        builder.a(obj);
                    }
                }
                return super.c(builder.j());
            }

            /* access modifiers changed from: package-private */
            @Override // com.google.common.reflect.TypeToken.f
            public Iterable<? extends K> e(K k) {
                return ImmutableSet.of();
            }
        }

        /* access modifiers changed from: package-private */
        /* compiled from: Taobao */
        public static class d extends Ordering<K> {
            final /* synthetic */ Comparator a;
            final /* synthetic */ Map b;

            d(Comparator comparator, Map map) {
                this.a = comparator;
                this.b = map;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.Comparator */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Ordering, java.util.Comparator
            public int compare(K k, K k2) {
                return this.a.compare(this.b.get(k), this.b.get(k2));
            }
        }

        /* compiled from: Taobao */
        private static class e<K> extends f<K> {
            private final f<K> c;

            e(f<K> fVar) {
                super(null);
                this.c = fVar;
            }

            /* access modifiers changed from: package-private */
            @Override // com.google.common.reflect.TypeToken.f
            public Class<?> f(K k) {
                return this.c.f(k);
            }

            /* access modifiers changed from: package-private */
            @Override // com.google.common.reflect.TypeToken.f
            public K g(K k) {
                return this.c.g(k);
            }
        }

        private f() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: int */
        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: int */
        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        private int b(K k, Map<? super K, Integer> map) {
            Integer num = map.get(k);
            if (num != null) {
                return num.intValue();
            }
            boolean isInterface = f(k).isInterface();
            Iterator<? extends K> it = e(k).iterator();
            int i = isInterface;
            while (it.hasNext()) {
                i = Math.max(i, b(it.next(), map));
            }
            K g = g(k);
            int i2 = i;
            if (g != null) {
                i2 = Math.max(i, b(g, map));
            }
            int i3 = (i2 == 1 ? 1 : 0) + 1;
            map.put(k, Integer.valueOf(i3));
            return i3;
        }

        private static <K, V> ImmutableList<K> h(Map<K, V> map, Comparator<? super V> comparator) {
            return new d(comparator, map).immutableSortedCopy(map.keySet());
        }

        /* access modifiers changed from: package-private */
        public final f<K> a() {
            return new c(this, this);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.common.reflect.TypeToken$f<K> */
        /* JADX WARN: Multi-variable type inference failed */
        /* access modifiers changed from: package-private */
        public ImmutableList<K> c(Iterable<? extends K> iterable) {
            HashMap p = Maps.p();
            Iterator<? extends K> it = iterable.iterator();
            while (it.hasNext()) {
                b(it.next(), p);
            }
            return h(p, Ordering.natural().reverse());
        }

        /* access modifiers changed from: package-private */
        public final ImmutableList<K> d(K k) {
            return c(ImmutableList.of(k));
        }

        /* access modifiers changed from: package-private */
        public abstract Iterable<? extends K> e(K k);

        /* access modifiers changed from: package-private */
        public abstract Class<?> f(K k);

        /* access modifiers changed from: package-private */
        @NullableDecl
        public abstract K g(K k);

        /* synthetic */ f(a aVar) {
            this();
        }
    }

    /* synthetic */ TypeToken(Type type, a aVar) {
        this(type);
    }

    private static e any(Type[] typeArr) {
        return new e(typeArr, true);
    }

    @NullableDecl
    private TypeToken<? super T> boundAsSuperclass(Type type) {
        TypeToken<? super T> typeToken = (TypeToken<? super T>) of(type);
        if (typeToken.getRawType().isInterface()) {
            return null;
        }
        return typeToken;
    }

    private ImmutableList<TypeToken<? super T>> boundsAsInterfaces(Type[] typeArr) {
        ImmutableList.a builder = ImmutableList.builder();
        for (Type type : typeArr) {
            TypeToken<?> of = of(type);
            if (of.getRawType().isInterface()) {
                builder.a(of);
            }
        }
        return builder.j();
    }

    private static Type canonicalizeTypeArg(TypeVariable<?> typeVariable, Type type) {
        if (type instanceof WildcardType) {
            return canonicalizeWildcardType(typeVariable, (WildcardType) type);
        }
        return canonicalizeWildcardsInType(type);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.ArrayList */
    /* JADX WARN: Multi-variable type inference failed */
    private static WildcardType canonicalizeWildcardType(TypeVariable<?> typeVariable, WildcardType wildcardType) {
        Type[] bounds = typeVariable.getBounds();
        ArrayList arrayList = new ArrayList();
        Type[] upperBounds = wildcardType.getUpperBounds();
        for (Type type : upperBounds) {
            if (!any(bounds).a(type)) {
                arrayList.add(canonicalizeWildcardsInType(type));
            }
        }
        return new Types.WildcardTypeImpl(wildcardType.getLowerBounds(), (Type[]) arrayList.toArray(new Type[0]));
    }

    private static ParameterizedType canonicalizeWildcardsInParameterizedType(ParameterizedType parameterizedType) {
        Class cls = (Class) parameterizedType.getRawType();
        TypeVariable<Class<T>>[] typeParameters = cls.getTypeParameters();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (int i = 0; i < actualTypeArguments.length; i++) {
            actualTypeArguments[i] = canonicalizeTypeArg(typeParameters[i], actualTypeArguments[i]);
        }
        return Types.n(parameterizedType.getOwnerType(), cls, actualTypeArguments);
    }

    private static Type canonicalizeWildcardsInType(Type type) {
        if (type instanceof ParameterizedType) {
            return canonicalizeWildcardsInParameterizedType((ParameterizedType) type);
        }
        return type instanceof GenericArrayType ? Types.k(canonicalizeWildcardsInType(((GenericArrayType) type).getGenericComponentType())) : type;
    }

    private static e every(Type[] typeArr) {
        return new e(typeArr, false);
    }

    private TypeToken<? extends T> getArraySubtype(Class<?> cls) {
        return (TypeToken<? extends T>) of(newArrayClassOrGenericArrayType(getComponentType().getSubtype(cls.getComponentType()).runtimeType));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.google.common.reflect.TypeToken */
    /* JADX WARN: Multi-variable type inference failed */
    private TypeToken<? super T> getArraySupertype(Class<? super T> cls) {
        return (TypeToken<? super T>) of(newArrayClassOrGenericArrayType(((TypeToken) ds1.s(getComponentType(), "%s isn't a super type of %s", cls, this)).getSupertype(cls.getComponentType()).runtimeType));
    }

    /* access modifiers changed from: private */
    public e getCovariantTypeResolver() {
        e eVar = this.covariantTypeResolver;
        if (eVar != null) {
            return eVar;
        }
        e d2 = e.d(this.runtimeType);
        this.covariantTypeResolver = d2;
        return d2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private e getInvariantTypeResolver() {
        e eVar = this.invariantTypeResolver;
        if (eVar != null) {
            return eVar;
        }
        e f2 = e.f(this.runtimeType);
        this.invariantTypeResolver = f2;
        return f2;
    }

    @NullableDecl
    private Type getOwnerTypeIfPresent() {
        Type type = this.runtimeType;
        if (type instanceof ParameterizedType) {
            return ((ParameterizedType) type).getOwnerType();
        }
        if (type instanceof Class) {
            return ((Class) type).getEnclosingClass();
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private ImmutableSet<Class<? super T>> getRawTypes() {
        ImmutableSet.a builder = ImmutableSet.builder();
        new d(this, builder).a(this.runtimeType);
        return builder.l();
    }

    private TypeToken<? extends T> getSubtypeFromLowerBounds(Class<?> cls, Type[] typeArr) {
        if (typeArr.length > 0) {
            return (TypeToken<? extends T>) of(typeArr[0]).getSubtype(cls);
        }
        throw new IllegalArgumentException(cls + " isn't a subclass of " + this);
    }

    private TypeToken<? super T> getSupertypeFromUpperBounds(Class<? super T> cls, Type[] typeArr) {
        for (Type type : typeArr) {
            TypeToken<?> of = of(type);
            if (of.isSubtypeOf(cls)) {
                return (TypeToken<? super T>) of.getSupertype(cls);
            }
        }
        throw new IllegalArgumentException(cls + " isn't a super type of " + this);
    }

    private boolean is(Type type, TypeVariable<?> typeVariable) {
        if (this.runtimeType.equals(type)) {
            return true;
        }
        if (!(type instanceof WildcardType)) {
            return canonicalizeWildcardsInType(this.runtimeType).equals(canonicalizeWildcardsInType(type));
        }
        WildcardType canonicalizeWildcardType = canonicalizeWildcardType(typeVariable, (WildcardType) type);
        if (!every(canonicalizeWildcardType.getUpperBounds()).b(this.runtimeType) || !every(canonicalizeWildcardType.getLowerBounds()).a(this.runtimeType)) {
            return false;
        }
        return true;
    }

    private boolean isOwnedBySubtypeOf(Type type) {
        Iterator it = getTypes().iterator();
        while (it.hasNext()) {
            Type ownerTypeIfPresent = ((TypeToken) it.next()).getOwnerTypeIfPresent();
            if (ownerTypeIfPresent != null && of(ownerTypeIfPresent).isSubtypeOf(type)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSubtypeOfArrayType(GenericArrayType genericArrayType) {
        Type type = this.runtimeType;
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (!cls.isArray()) {
                return false;
            }
            return of((Class) cls.getComponentType()).isSubtypeOf(genericArrayType.getGenericComponentType());
        } else if (type instanceof GenericArrayType) {
            return of(((GenericArrayType) type).getGenericComponentType()).isSubtypeOf(genericArrayType.getGenericComponentType());
        } else {
            return false;
        }
    }

    private boolean isSubtypeOfParameterizedType(ParameterizedType parameterizedType) {
        Class<? super Object> rawType = of(parameterizedType).getRawType();
        if (!someRawTypeIsSubclassOf(rawType)) {
            return false;
        }
        TypeVariable<Class<? super Object>>[] typeParameters = rawType.getTypeParameters();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (int i = 0; i < typeParameters.length; i++) {
            if (!of(getCovariantTypeResolver().j(typeParameters[i])).is(actualTypeArguments[i], typeParameters[i])) {
                return false;
            }
        }
        if (Modifier.isStatic(((Class) parameterizedType.getRawType()).getModifiers()) || parameterizedType.getOwnerType() == null || isOwnedBySubtypeOf(parameterizedType.getOwnerType())) {
            return true;
        }
        return false;
    }

    private boolean isSupertypeOfArray(GenericArrayType genericArrayType) {
        Type type = this.runtimeType;
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (!cls.isArray()) {
                return cls.isAssignableFrom(Object[].class);
            }
            return of(genericArrayType.getGenericComponentType()).isSubtypeOf(cls.getComponentType());
        } else if (type instanceof GenericArrayType) {
            return of(genericArrayType.getGenericComponentType()).isSubtypeOf(((GenericArrayType) this.runtimeType).getGenericComponentType());
        } else {
            return false;
        }
    }

    private boolean isWrapper() {
        return ls1.b().contains(this.runtimeType);
    }

    private static Type newArrayClassOrGenericArrayType(Type type) {
        return Types.JavaVersion.JAVA7.newArrayType(type);
    }

    public static <T> TypeToken<T> of(Class<T> cls) {
        return new SimpleTypeToken(cls);
    }

    private TypeToken<?> resolveSupertype(Type type) {
        TypeToken<?> of = of(getCovariantTypeResolver().j(type));
        of.covariantTypeResolver = this.covariantTypeResolver;
        of.invariantTypeResolver = this.invariantTypeResolver;
        return of;
    }

    private Type resolveTypeArgsForSubclass(Class<?> cls) {
        if ((this.runtimeType instanceof Class) && (cls.getTypeParameters().length == 0 || getRawType().getTypeParameters().length != 0)) {
            return cls;
        }
        TypeToken genericType = toGenericType(cls);
        return new e().n(genericType.getSupertype(getRawType()).runtimeType, this.runtimeType).j(genericType.runtimeType);
    }

    private boolean someRawTypeIsSubclassOf(Class<?> cls) {
        wr2<Class<? super T>> it = getRawTypes().iterator();
        while (it.hasNext()) {
            if (cls.isAssignableFrom(it.next())) {
                return true;
            }
        }
        return false;
    }

    @VisibleForTesting
    static <T> TypeToken<? extends T> toGenericType(Class<T> cls) {
        if (cls.isArray()) {
            return (TypeToken<? extends T>) of(Types.k(toGenericType(cls.getComponentType()).runtimeType));
        }
        TypeVariable<Class<T>>[] typeParameters = cls.getTypeParameters();
        Type type = (!cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) ? null : toGenericType(cls.getEnclosingClass()).runtimeType;
        return (typeParameters.length > 0 || !(type == null || type == cls.getEnclosingClass())) ? (TypeToken<? extends T>) of(Types.n(type, cls, typeParameters)) : of((Class) cls);
    }

    public final b<T, T> constructor(Constructor<?> constructor) {
        ds1.l(constructor.getDeclaringClass() == getRawType(), "%s not declared by %s", constructor, getRawType());
        return new b(constructor);
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj instanceof TypeToken) {
            return this.runtimeType.equals(((TypeToken) obj).runtimeType);
        }
        return false;
    }

    @NullableDecl
    public final TypeToken<?> getComponentType() {
        Type j = Types.j(this.runtimeType);
        if (j == null) {
            return null;
        }
        return of(j);
    }

    /* access modifiers changed from: package-private */
    public final ImmutableList<TypeToken<? super T>> getGenericInterfaces() {
        Type type = this.runtimeType;
        if (type instanceof TypeVariable) {
            return boundsAsInterfaces(((TypeVariable) type).getBounds());
        }
        if (type instanceof WildcardType) {
            return boundsAsInterfaces(((WildcardType) type).getUpperBounds());
        }
        ImmutableList.a builder = ImmutableList.builder();
        for (Type type2 : getRawType().getGenericInterfaces()) {
            builder.a(resolveSupertype(type2));
        }
        return builder.j();
    }

    /* access modifiers changed from: package-private */
    @NullableDecl
    public final TypeToken<? super T> getGenericSuperclass() {
        Type type = this.runtimeType;
        if (type instanceof TypeVariable) {
            return boundAsSuperclass(((TypeVariable) type).getBounds()[0]);
        }
        if (type instanceof WildcardType) {
            return boundAsSuperclass(((WildcardType) type).getUpperBounds()[0]);
        }
        Type genericSuperclass = getRawType().getGenericSuperclass();
        if (genericSuperclass == null) {
            return null;
        }
        return (TypeToken<? super T>) resolveSupertype(genericSuperclass);
    }

    public final Class<? super T> getRawType() {
        return getRawTypes().iterator().next();
    }

    public final TypeToken<? extends T> getSubtype(Class<?> cls) {
        ds1.k(!(this.runtimeType instanceof TypeVariable), "Cannot get subtype of type variable <%s>", this);
        Type type = this.runtimeType;
        if (type instanceof WildcardType) {
            return getSubtypeFromLowerBounds(cls, ((WildcardType) type).getLowerBounds());
        }
        if (isArray()) {
            return getArraySubtype(cls);
        }
        ds1.l(getRawType().isAssignableFrom(cls), "%s isn't a subclass of %s", cls, this);
        TypeToken<? extends T> typeToken = (TypeToken<? extends T>) of(resolveTypeArgsForSubclass(cls));
        ds1.l(typeToken.isSubtypeOf((TypeToken<?>) this), "%s does not appear to be a subtype of %s", typeToken, this);
        return typeToken;
    }

    public final TypeToken<? super T> getSupertype(Class<? super T> cls) {
        ds1.l(someRawTypeIsSubclassOf(cls), "%s is not a super class of %s", cls, this);
        Type type = this.runtimeType;
        if (type instanceof TypeVariable) {
            return getSupertypeFromUpperBounds(cls, ((TypeVariable) type).getBounds());
        }
        if (type instanceof WildcardType) {
            return getSupertypeFromUpperBounds(cls, ((WildcardType) type).getUpperBounds());
        }
        return cls.isArray() ? getArraySupertype(cls) : (TypeToken<? super T>) resolveSupertype(toGenericType(cls).runtimeType);
    }

    public final Type getType() {
        return this.runtimeType;
    }

    public final TypeToken<T>.TypeSet getTypes() {
        return new TypeSet();
    }

    public int hashCode() {
        return this.runtimeType.hashCode();
    }

    public final boolean isArray() {
        return getComponentType() != null;
    }

    public final boolean isPrimitive() {
        Type type = this.runtimeType;
        return (type instanceof Class) && ((Class) type).isPrimitive();
    }

    public final boolean isSubtypeOf(TypeToken<?> typeToken) {
        return isSubtypeOf(typeToken.getType());
    }

    public final boolean isSupertypeOf(TypeToken<?> typeToken) {
        return typeToken.isSubtypeOf(getType());
    }

    public final b<T, Object> method(Method method) {
        ds1.l(someRawTypeIsSubclassOf(method.getDeclaringClass()), "%s not declared by %s", method, this);
        return new a(method);
    }

    /* access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public final TypeToken<T> rejectTypeVariables() {
        new c().a(this.runtimeType);
        return this;
    }

    public final TypeToken<?> resolveType(Type type) {
        ds1.p(type);
        return of(getInvariantTypeResolver().j(type));
    }

    public String toString() {
        return Types.t(this.runtimeType);
    }

    public final TypeToken<T> unwrap() {
        return isWrapper() ? of(ls1.c((Class) this.runtimeType)) : this;
    }

    public final <X> TypeToken<T> where(d<X> dVar, TypeToken<X> typeToken) {
        new e();
        throw null;
    }

    public final TypeToken<T> wrap() {
        return isPrimitive() ? of(ls1.d((Class) this.runtimeType)) : this;
    }

    /* access modifiers changed from: protected */
    public Object writeReplace() {
        return of(new e().j(this.runtimeType));
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public final class InterfaceSet extends TypeToken<T>.TypeSet {
        private static final long serialVersionUID = 0;
        private final transient TypeToken<T>.TypeSet allTypes;
        @MonotonicNonNullDecl
        private transient ImmutableSet<TypeToken<? super T>> interfaces;

        /* compiled from: Taobao */
        class a implements Predicate<Class<?>> {
            a(InterfaceSet interfaceSet) {
            }

            /* renamed from: a */
            public boolean apply(Class<?> cls) {
                return cls.isInterface();
            }
        }

        InterfaceSet(TypeToken<T>.TypeSet typeSet) {
            super();
            this.allTypes = typeSet;
        }

        private Object readResolve() {
            return TypeToken.this.getTypes().interfaces();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet classes() {
            throw new UnsupportedOperationException("interfaces().classes() not supported.");
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet interfaces() {
            return this;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public Set<Class<? super T>> rawTypes() {
            return n.d(f.b.c(TypeToken.this.getRawTypes())).c(new a(this)).f();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.collect.o, com.google.common.collect.o, com.google.common.reflect.TypeToken.TypeSet, com.google.common.reflect.TypeToken.TypeSet, com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.t, com.google.common.collect.v, com.google.common.collect.v, com.google.common.collect.v
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.interfaces;
            if (immutableSet != null) {
                return immutableSet;
            }
            ImmutableSet<TypeToken<? super T>> f = n.d(this.allTypes).c(TypeFilter.INTERFACE_ONLY).f();
            this.interfaces = f;
            return f;
        }
    }

    /* compiled from: Taobao */
    public class TypeSet extends v<TypeToken<? super T>> implements Serializable {
        private static final long serialVersionUID = 0;
        @MonotonicNonNullDecl
        private transient ImmutableSet<TypeToken<? super T>> types;

        TypeSet() {
        }

        public TypeToken<T>.TypeSet classes() {
            return new ClassSet(TypeToken.this, null);
        }

        public TypeToken<T>.TypeSet interfaces() {
            return new InterfaceSet(this);
        }

        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf((Collection) f.b.c(TypeToken.this.getRawTypes()));
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.collect.o, com.google.common.collect.o, com.google.common.collect.t, com.google.common.collect.v, com.google.common.collect.v, com.google.common.collect.v
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.types;
            if (immutableSet != null) {
                return immutableSet;
            }
            ImmutableSet<TypeToken<? super T>> f = n.d(f.a.d(TypeToken.this)).c(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).f();
            this.types = f;
            return f;
        }
    }

    protected TypeToken() {
        Type capture = capture();
        this.runtimeType = capture;
        ds1.A(!(capture instanceof TypeVariable), "Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", capture);
    }

    public static TypeToken<?> of(Type type) {
        return new SimpleTypeToken(type);
    }

    public final boolean isSubtypeOf(Type type) {
        ds1.p(type);
        if (type instanceof WildcardType) {
            return any(((WildcardType) type).getLowerBounds()).b(this.runtimeType);
        }
        Type type2 = this.runtimeType;
        if (type2 instanceof WildcardType) {
            return any(((WildcardType) type2).getUpperBounds()).a(type);
        }
        if (type2 instanceof TypeVariable) {
            if (type2.equals(type) || any(((TypeVariable) this.runtimeType).getBounds()).a(type)) {
                return true;
            }
            return false;
        } else if (type2 instanceof GenericArrayType) {
            return of(type).isSupertypeOfArray((GenericArrayType) this.runtimeType);
        } else {
            if (type instanceof Class) {
                return someRawTypeIsSubclassOf((Class) type);
            }
            if (type instanceof ParameterizedType) {
                return isSubtypeOfParameterizedType((ParameterizedType) type);
            }
            if (type instanceof GenericArrayType) {
                return isSubtypeOfArrayType((GenericArrayType) type);
            }
            return false;
        }
    }

    public final boolean isSupertypeOf(Type type) {
        return of(type).isSubtypeOf(getType());
    }

    public final <X> TypeToken<T> where(d<X> dVar, Class<X> cls) {
        return where(dVar, of((Class) cls));
    }

    protected TypeToken(Class<?> cls) {
        Type capture = super.capture();
        if (capture instanceof Class) {
            this.runtimeType = capture;
        } else {
            this.runtimeType = e.d(cls).j(capture);
        }
    }

    private TypeToken(Type type) {
        this.runtimeType = (Type) ds1.p(type);
    }
}
