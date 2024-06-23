package com.google.common.reflect;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.a0;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.security.AccessControlException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.ez1;
import tb.rk1;
import tb.wr2;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class Types {
    private static final Function<Type, String> a = new a();
    private static final com.google.common.base.d b = com.google.common.base.d.g(AVFSCacheConstants.COMMA_SEP).i("null");

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public enum ClassOwnership {
        OWNED_BY_ENCLOSING_CLASS {
            /* access modifiers changed from: package-private */
            @Override // com.google.common.reflect.Types.ClassOwnership
            @NullableDecl
            public Class<?> getOwnerType(Class<?> cls) {
                return cls.getEnclosingClass();
            }
        },
        LOCAL_CLASS_HAS_NO_OWNER {
            /* access modifiers changed from: package-private */
            @Override // com.google.common.reflect.Types.ClassOwnership
            @NullableDecl
            public Class<?> getOwnerType(Class<?> cls) {
                if (cls.isLocalClass()) {
                    return null;
                }
                return cls.getEnclosingClass();
            }
        };
        
        static final ClassOwnership JVM_BEHAVIOR = detectJvmBehavior();

        /* access modifiers changed from: package-private */
        /* compiled from: Taobao */
        public class a<T> {
            a() {
            }
        }

        /* access modifiers changed from: package-private */
        /* compiled from: Taobao */
        public static class b extends a<String> {
            b() {
            }
        }

        private static ClassOwnership detectJvmBehavior() {
            new b();
            ParameterizedType parameterizedType = (ParameterizedType) b.class.getGenericSuperclass();
            ClassOwnership[] values = values();
            for (ClassOwnership classOwnership : values) {
                if (classOwnership.getOwnerType(a.class) == parameterizedType.getOwnerType()) {
                    return classOwnership;
                }
            }
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        @NullableDecl
        public abstract Class<?> getOwnerType(Class<?> cls);

        /* synthetic */ ClassOwnership(a aVar) {
            this();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class GenericArrayTypeImpl implements Serializable, GenericArrayType {
        private static final long serialVersionUID = 0;
        private final Type componentType;

        GenericArrayTypeImpl(Type type) {
            this.componentType = JavaVersion.CURRENT.usedInGenericType(type);
        }

        public boolean equals(Object obj) {
            if (obj instanceof GenericArrayType) {
                return rk1.a(getGenericComponentType(), ((GenericArrayType) obj).getGenericComponentType());
            }
            return false;
        }

        public Type getGenericComponentType() {
            return this.componentType;
        }

        public int hashCode() {
            return this.componentType.hashCode();
        }

        public String toString() {
            return Types.t(this.componentType) + "[]";
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public enum JavaVersion {
        JAVA6 {
            /* access modifiers changed from: package-private */
            @Override // com.google.common.reflect.Types.JavaVersion
            public Type usedInGenericType(Type type) {
                ds1.p(type);
                if (!(type instanceof Class)) {
                    return type;
                }
                Class cls = (Class) type;
                return cls.isArray() ? new GenericArrayTypeImpl(cls.getComponentType()) : type;
            }

            /* access modifiers changed from: package-private */
            @Override // com.google.common.reflect.Types.JavaVersion
            public GenericArrayType newArrayType(Type type) {
                return new GenericArrayTypeImpl(type);
            }
        },
        JAVA7 {
            /* access modifiers changed from: package-private */
            @Override // com.google.common.reflect.Types.JavaVersion
            public Type newArrayType(Type type) {
                if (type instanceof Class) {
                    return Types.i((Class) type);
                }
                return new GenericArrayTypeImpl(type);
            }

            /* access modifiers changed from: package-private */
            @Override // com.google.common.reflect.Types.JavaVersion
            public Type usedInGenericType(Type type) {
                return (Type) ds1.p(type);
            }
        },
        JAVA8 {
            /* access modifiers changed from: package-private */
            @Override // com.google.common.reflect.Types.JavaVersion
            public Type newArrayType(Type type) {
                return JavaVersion.JAVA7.newArrayType(type);
            }

            /* access modifiers changed from: package-private */
            @Override // com.google.common.reflect.Types.JavaVersion
            public String typeName(Type type) {
                try {
                    return (String) Type.class.getMethod("getTypeName", new Class[0]).invoke(type, new Object[0]);
                } catch (NoSuchMethodException unused) {
                    throw new AssertionError("Type.getTypeName should be available in Java 8");
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e2) {
                    throw new RuntimeException(e2);
                }
            }

            /* access modifiers changed from: package-private */
            @Override // com.google.common.reflect.Types.JavaVersion
            public Type usedInGenericType(Type type) {
                return JavaVersion.JAVA7.usedInGenericType(type);
            }
        },
        JAVA9 {
            /* access modifiers changed from: package-private */
            @Override // com.google.common.reflect.Types.JavaVersion
            public boolean jdkTypeDuplicatesOwnerName() {
                return false;
            }

            /* access modifiers changed from: package-private */
            @Override // com.google.common.reflect.Types.JavaVersion
            public Type newArrayType(Type type) {
                return JavaVersion.JAVA8.newArrayType(type);
            }

            /* access modifiers changed from: package-private */
            @Override // com.google.common.reflect.Types.JavaVersion
            public String typeName(Type type) {
                return JavaVersion.JAVA8.typeName(type);
            }

            /* access modifiers changed from: package-private */
            @Override // com.google.common.reflect.Types.JavaVersion
            public Type usedInGenericType(Type type) {
                return JavaVersion.JAVA8.usedInGenericType(type);
            }
        };
        
        static final JavaVersion CURRENT;

        /* compiled from: Taobao */
        static class a extends c<Map.Entry<String, int[][]>> {
            a() {
            }
        }

        /* compiled from: Taobao */
        static class b extends c<int[]> {
            b() {
            }
        }

        static {
            AnonymousClass1 r0;
            AnonymousClass2 r1;
            AnonymousClass3 r3;
            AnonymousClass4 r5;
            if (AnnotatedElement.class.isAssignableFrom(TypeVariable.class)) {
                if (new a().capture().toString().contains("java.util.Map.java.util.Map")) {
                    CURRENT = r3;
                } else {
                    CURRENT = r5;
                }
            } else if (new b().capture() instanceof Class) {
                CURRENT = r1;
            } else {
                CURRENT = r0;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean jdkTypeDuplicatesOwnerName() {
            return true;
        }

        /* access modifiers changed from: package-private */
        public abstract Type newArrayType(Type type);

        /* access modifiers changed from: package-private */
        public String typeName(Type type) {
            return Types.t(type);
        }

        /* access modifiers changed from: package-private */
        public final ImmutableList<Type> usedInGenericType(Type[] typeArr) {
            ImmutableList.a builder = ImmutableList.builder();
            for (Type type : typeArr) {
                builder.a(usedInGenericType(type));
            }
            return builder.j();
        }

        /* access modifiers changed from: package-private */
        public abstract Type usedInGenericType(Type type);

        /* synthetic */ JavaVersion(a aVar) {
            this();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class ParameterizedTypeImpl implements Serializable, ParameterizedType {
        private static final long serialVersionUID = 0;
        private final ImmutableList<Type> argumentsList;
        @NullableDecl
        private final Type ownerType;
        private final Class<?> rawType;

        ParameterizedTypeImpl(@NullableDecl Type type, Class<?> cls, Type[] typeArr) {
            ds1.p(cls);
            ds1.d(typeArr.length == cls.getTypeParameters().length);
            Types.g(typeArr, "type parameter");
            this.ownerType = type;
            this.rawType = cls;
            this.argumentsList = JavaVersion.CURRENT.usedInGenericType(typeArr);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            if (!getRawType().equals(parameterizedType.getRawType()) || !rk1.a(getOwnerType(), parameterizedType.getOwnerType()) || !Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments())) {
                return false;
            }
            return true;
        }

        public Type[] getActualTypeArguments() {
            return Types.s(this.argumentsList);
        }

        public Type getOwnerType() {
            return this.ownerType;
        }

        public Type getRawType() {
            return this.rawType;
        }

        public int hashCode() {
            Type type = this.ownerType;
            return ((type == null ? 0 : type.hashCode()) ^ this.argumentsList.hashCode()) ^ this.rawType.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.ownerType != null) {
                JavaVersion javaVersion = JavaVersion.CURRENT;
                if (javaVersion.jdkTypeDuplicatesOwnerName()) {
                    sb.append(javaVersion.typeName(this.ownerType));
                    sb.append('.');
                }
            }
            sb.append(this.rawType.getName());
            sb.append('<');
            sb.append(Types.b.c(a0.n(this.argumentsList, Types.a)));
            sb.append('>');
            return sb.toString();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class WildcardTypeImpl implements Serializable, WildcardType {
        private static final long serialVersionUID = 0;
        private final ImmutableList<Type> lowerBounds;
        private final ImmutableList<Type> upperBounds;

        WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            Types.g(typeArr, "lower bound for wildcard");
            Types.g(typeArr2, "upper bound for wildcard");
            JavaVersion javaVersion = JavaVersion.CURRENT;
            this.lowerBounds = javaVersion.usedInGenericType(typeArr);
            this.upperBounds = javaVersion.usedInGenericType(typeArr2);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) obj;
            if (!this.lowerBounds.equals(Arrays.asList(wildcardType.getLowerBounds())) || !this.upperBounds.equals(Arrays.asList(wildcardType.getUpperBounds()))) {
                return false;
            }
            return true;
        }

        public Type[] getLowerBounds() {
            return Types.s(this.lowerBounds);
        }

        public Type[] getUpperBounds() {
            return Types.s(this.upperBounds);
        }

        public int hashCode() {
            return this.lowerBounds.hashCode() ^ this.upperBounds.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("?");
            wr2<Type> it = this.lowerBounds.iterator();
            while (it.hasNext()) {
                sb.append(" super ");
                sb.append(JavaVersion.CURRENT.typeName(it.next()));
            }
            for (Type type : Types.h(this.upperBounds)) {
                sb.append(" extends ");
                sb.append(JavaVersion.CURRENT.typeName(type));
            }
            return sb.toString();
        }
    }

    /* compiled from: Taobao */
    static class a implements Function<Type, String> {
        a() {
        }

        /* renamed from: a */
        public String apply(Type type) {
            return JavaVersion.CURRENT.typeName(type);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class b extends f {
        final /* synthetic */ AtomicReference b;

        b(AtomicReference atomicReference) {
            this.b = atomicReference;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.reflect.f
        public void b(Class<?> cls) {
            this.b.set(cls.getComponentType());
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.reflect.f
        public void c(GenericArrayType genericArrayType) {
            this.b.set(genericArrayType.getGenericComponentType());
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.reflect.f
        public void e(TypeVariable<?> typeVariable) {
            this.b.set(Types.q(typeVariable.getBounds()));
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.reflect.f
        public void f(WildcardType wildcardType) {
            this.b.set(Types.q(wildcardType.getUpperBounds()));
        }
    }

    /* compiled from: Taobao */
    static final class c<X> {
        static final boolean a = (!c.class.getTypeParameters()[0].equals(Types.l(c.class, "X", new Type[0])));

        c() {
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class d<D extends GenericDeclaration> {
        private final D a;
        private final String b;
        private final ImmutableList<Type> c;

        d(D d, String str, Type[] typeArr) {
            Types.g(typeArr, "bound for type variable");
            this.a = (D) ((GenericDeclaration) ds1.p(d));
            this.b = (String) ds1.p(str);
            this.c = ImmutableList.copyOf(typeArr);
        }

        public D a() {
            return this.a;
        }

        public String b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (c.a) {
                if (obj == null || !Proxy.isProxyClass(obj.getClass()) || !(Proxy.getInvocationHandler(obj) instanceof e)) {
                    return false;
                }
                d dVar = ((e) Proxy.getInvocationHandler(obj)).a;
                if (!this.b.equals(dVar.b()) || !this.a.equals(dVar.a()) || !this.c.equals(dVar.c)) {
                    return false;
                }
                return true;
            } else if (!(obj instanceof TypeVariable)) {
                return false;
            } else {
                TypeVariable typeVariable = (TypeVariable) obj;
                if (!this.b.equals(typeVariable.getName()) || !this.a.equals(typeVariable.getGenericDeclaration())) {
                    return false;
                }
                return true;
            }
        }

        public int hashCode() {
            return this.a.hashCode() ^ this.b.hashCode();
        }

        public String toString() {
            return this.b;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class e implements InvocationHandler {
        private static final ImmutableMap<String, Method> b;
        private final d<?> a;

        static {
            ImmutableMap.b builder = ImmutableMap.builder();
            Method[] methods = d.class.getMethods();
            for (Method method : methods) {
                if (method.getDeclaringClass().equals(d.class)) {
                    try {
                        method.setAccessible(true);
                    } catch (AccessControlException unused) {
                    }
                    builder.c(method.getName(), method);
                }
            }
            b = builder.a();
        }

        e(d<?> dVar) {
            this.a = dVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Method method2 = b.get(name);
            if (method2 != null) {
                try {
                    return method2.invoke(this.a, objArr);
                } catch (InvocationTargetException e) {
                    throw e.getCause();
                }
            } else {
                throw new UnsupportedOperationException(name);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void g(Type[] typeArr, String str) {
        for (Type type : typeArr) {
            if (type instanceof Class) {
                Class cls = (Class) type;
                ds1.l(!cls.isPrimitive(), "Primitive type '%s' used as %s", cls, str);
            }
        }
    }

    /* access modifiers changed from: private */
    public static Iterable<Type> h(Iterable<Type> iterable) {
        return a0.d(iterable, Predicates.g(Predicates.d(Object.class)));
    }

    static Class<?> i(Class<?> cls) {
        return Array.newInstance(cls, 0).getClass();
    }

    @NullableDecl
    static Type j(Type type) {
        ds1.p(type);
        AtomicReference atomicReference = new AtomicReference();
        new b(atomicReference).a(type);
        return (Type) atomicReference.get();
    }

    static Type k(Type type) {
        if (!(type instanceof WildcardType)) {
            return JavaVersion.CURRENT.newArrayType(type);
        }
        WildcardType wildcardType = (WildcardType) type;
        Type[] lowerBounds = wildcardType.getLowerBounds();
        boolean z = true;
        ds1.e(lowerBounds.length <= 1, "Wildcard cannot have more than one lower bounds.");
        if (lowerBounds.length == 1) {
            return r(k(lowerBounds[0]));
        }
        Type[] upperBounds = wildcardType.getUpperBounds();
        if (upperBounds.length != 1) {
            z = false;
        }
        ds1.e(z, "Wildcard should have only one upper bound.");
        return p(k(upperBounds[0]));
    }

    static <D extends GenericDeclaration> TypeVariable<D> l(D d2, String str, Type... typeArr) {
        if (typeArr.length == 0) {
            typeArr = new Type[]{Object.class};
        }
        return o(d2, str, typeArr);
    }

    static ParameterizedType m(Class<?> cls, Type... typeArr) {
        return new ParameterizedTypeImpl(ClassOwnership.JVM_BEHAVIOR.getOwnerType(cls), cls, typeArr);
    }

    static ParameterizedType n(@NullableDecl Type type, Class<?> cls, Type... typeArr) {
        if (type == null) {
            return m(cls, typeArr);
        }
        ds1.p(typeArr);
        ds1.k(cls.getEnclosingClass() != null, "Owner type for unenclosed %s", cls);
        return new ParameterizedTypeImpl(type, cls, typeArr);
    }

    private static <D extends GenericDeclaration> TypeVariable<D> o(D d2, String str, Type[] typeArr) {
        return (TypeVariable) ez1.a(TypeVariable.class, new e(new d(d2, str, typeArr)));
    }

    @VisibleForTesting
    static WildcardType p(Type type) {
        return new WildcardTypeImpl(new Type[0], new Type[]{type});
    }

    /* access modifiers changed from: private */
    @NullableDecl
    public static Type q(Type[] typeArr) {
        for (Type type : typeArr) {
            Type j = j(type);
            if (j != null) {
                if (j instanceof Class) {
                    Class cls = (Class) j;
                    if (cls.isPrimitive()) {
                        return cls;
                    }
                }
                return p(j);
            }
        }
        return null;
    }

    @VisibleForTesting
    static WildcardType r(Type type) {
        return new WildcardTypeImpl(new Type[]{type}, new Type[]{Object.class});
    }

    /* access modifiers changed from: private */
    public static Type[] s(Collection<Type> collection) {
        return (Type[]) collection.toArray(new Type[collection.size()]);
    }

    static String t(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }
}
