package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.jl1;
import tb.o70;
import tb.rk1;

@GwtCompatible(emulated = true)
/* compiled from: Taobao */
public final class Predicates {

    /* compiled from: Taobao */
    private static class AndPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final List<? extends Predicate<? super T>> components;

        @Override // com.google.common.base.Predicate
        public boolean apply(@NullableDecl T t) {
            for (int i = 0; i < this.components.size(); i++) {
                if (!((Predicate) this.components.get(i)).apply(t)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof AndPredicate) {
                return this.components.equals(((AndPredicate) obj).components);
            }
            return false;
        }

        public int hashCode() {
            return this.components.hashCode() + 306654252;
        }

        public String toString() {
            return Predicates.h(o70.AND_PREFIX, this.components);
        }

        private AndPredicate(List<? extends Predicate<? super T>> list) {
            this.components = list;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class CompositionPredicate<A, B> implements Predicate<A>, Serializable {
        private static final long serialVersionUID = 0;
        final Function<A, ? extends B> f;
        final Predicate<B> p;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.base.Predicate<B> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.base.Predicate
        public boolean apply(@NullableDecl A a) {
            return this.p.apply(this.f.apply(a));
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof CompositionPredicate)) {
                return false;
            }
            CompositionPredicate compositionPredicate = (CompositionPredicate) obj;
            if (!this.f.equals(compositionPredicate.f) || !this.p.equals(compositionPredicate.p)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.f.hashCode() ^ this.p.hashCode();
        }

        public String toString() {
            return this.p + jl1.BRACKET_START_STR + this.f + jl1.BRACKET_END_STR;
        }

        private CompositionPredicate(Predicate<B> predicate, Function<A, ? extends B> function) {
            this.p = (Predicate) ds1.p(predicate);
            this.f = (Function) ds1.p(function);
        }
    }

    @GwtIncompatible
    /* compiled from: Taobao */
    private static class ContainsPatternFromStringPredicate extends ContainsPatternPredicate {
        private static final long serialVersionUID = 0;

        ContainsPatternFromStringPredicate(String str) {
            super(f.a(str));
        }

        @Override // com.google.common.base.Predicates.ContainsPatternPredicate
        public String toString() {
            return "Predicates.containsPattern(" + this.pattern.pattern() + jl1.BRACKET_END_STR;
        }
    }

    @GwtIncompatible
    /* compiled from: Taobao */
    private static class ContainsPatternPredicate implements Predicate<CharSequence>, Serializable {
        private static final long serialVersionUID = 0;
        final b pattern;

        ContainsPatternPredicate(b bVar) {
            this.pattern = (b) ds1.p(bVar);
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof ContainsPatternPredicate)) {
                return false;
            }
            ContainsPatternPredicate containsPatternPredicate = (ContainsPatternPredicate) obj;
            if (!rk1.a(this.pattern.pattern(), containsPatternPredicate.pattern.pattern()) || this.pattern.flags() != containsPatternPredicate.pattern.flags()) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return rk1.b(this.pattern.pattern(), Integer.valueOf(this.pattern.flags()));
        }

        public String toString() {
            String bVar = e.b(this.pattern).d("pattern", this.pattern.pattern()).b("pattern.flags", this.pattern.flags()).toString();
            return "Predicates.contains(" + bVar + jl1.BRACKET_END_STR;
        }

        public boolean apply(CharSequence charSequence) {
            return this.pattern.matcher(charSequence).a();
        }
    }

    /* compiled from: Taobao */
    private static class InPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Collection<?> target;

        @Override // com.google.common.base.Predicate
        public boolean apply(@NullableDecl T t) {
            try {
                return this.target.contains(t);
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof InPredicate) {
                return this.target.equals(((InPredicate) obj).target);
            }
            return false;
        }

        public int hashCode() {
            return this.target.hashCode();
        }

        public String toString() {
            return "Predicates.in(" + this.target + jl1.BRACKET_END_STR;
        }

        private InPredicate(Collection<?> collection) {
            this.target = (Collection) ds1.p(collection);
        }
    }

    @GwtIncompatible
    /* compiled from: Taobao */
    private static class InstanceOfPredicate implements Predicate<Object>, Serializable {
        private static final long serialVersionUID = 0;
        private final Class<?> clazz;

        @Override // com.google.common.base.Predicate
        public boolean apply(@NullableDecl Object obj) {
            return this.clazz.isInstance(obj);
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof InstanceOfPredicate) || this.clazz != ((InstanceOfPredicate) obj).clazz) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.clazz.hashCode();
        }

        public String toString() {
            return "Predicates.instanceOf(" + this.clazz.getName() + jl1.BRACKET_END_STR;
        }

        private InstanceOfPredicate(Class<?> cls) {
            this.clazz = (Class) ds1.p(cls);
        }
    }

    /* compiled from: Taobao */
    private static class IsEqualToPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final T target;

        @Override // com.google.common.base.Predicate
        public boolean apply(T t) {
            return this.target.equals(t);
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof IsEqualToPredicate) {
                return this.target.equals(((IsEqualToPredicate) obj).target);
            }
            return false;
        }

        public int hashCode() {
            return this.target.hashCode();
        }

        public String toString() {
            return "Predicates.equalTo(" + ((Object) this.target) + jl1.BRACKET_END_STR;
        }

        private IsEqualToPredicate(T t) {
            this.target = t;
        }
    }

    /* compiled from: Taobao */
    private static class NotPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        final Predicate<T> predicate;

        NotPredicate(Predicate<T> predicate2) {
            this.predicate = (Predicate) ds1.p(predicate2);
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@NullableDecl T t) {
            return !this.predicate.apply(t);
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof NotPredicate) {
                return this.predicate.equals(((NotPredicate) obj).predicate);
            }
            return false;
        }

        public int hashCode() {
            return ~this.predicate.hashCode();
        }

        public String toString() {
            return "Predicates.not(" + this.predicate + jl1.BRACKET_END_STR;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public enum ObjectPredicate implements Predicate<Object> {
        ALWAYS_TRUE {
            @Override // com.google.common.base.Predicate
            public boolean apply(@NullableDecl Object obj) {
                return true;
            }

            public String toString() {
                return "Predicates.alwaysTrue()";
            }
        },
        ALWAYS_FALSE {
            @Override // com.google.common.base.Predicate
            public boolean apply(@NullableDecl Object obj) {
                return false;
            }

            public String toString() {
                return "Predicates.alwaysFalse()";
            }
        },
        IS_NULL {
            @Override // com.google.common.base.Predicate
            public boolean apply(@NullableDecl Object obj) {
                return obj == null;
            }

            public String toString() {
                return "Predicates.isNull()";
            }
        },
        NOT_NULL {
            @Override // com.google.common.base.Predicate
            public boolean apply(@NullableDecl Object obj) {
                return obj != null;
            }

            public String toString() {
                return "Predicates.notNull()";
            }
        };

        /* access modifiers changed from: package-private */
        public <T> Predicate<T> withNarrowedType() {
            return this;
        }
    }

    /* compiled from: Taobao */
    private static class OrPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final List<? extends Predicate<? super T>> components;

        @Override // com.google.common.base.Predicate
        public boolean apply(@NullableDecl T t) {
            for (int i = 0; i < this.components.size(); i++) {
                if (((Predicate) this.components.get(i)).apply(t)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof OrPredicate) {
                return this.components.equals(((OrPredicate) obj).components);
            }
            return false;
        }

        public int hashCode() {
            return this.components.hashCode() + 87855567;
        }

        public String toString() {
            return Predicates.h(o70.OR_PREFIX, this.components);
        }

        private OrPredicate(List<? extends Predicate<? super T>> list) {
            this.components = list;
        }
    }

    @GwtIncompatible
    /* compiled from: Taobao */
    private static class SubtypeOfPredicate implements Predicate<Class<?>>, Serializable {
        private static final long serialVersionUID = 0;
        private final Class<?> clazz;

        @Override // com.google.common.base.Predicate
        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof SubtypeOfPredicate) || this.clazz != ((SubtypeOfPredicate) obj).clazz) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.clazz.hashCode();
        }

        public String toString() {
            return "Predicates.subtypeOf(" + this.clazz.getName() + jl1.BRACKET_END_STR;
        }

        private SubtypeOfPredicate(Class<?> cls) {
            this.clazz = (Class) ds1.p(cls);
        }

        public boolean apply(Class<?> cls) {
            return this.clazz.isAssignableFrom(cls);
        }
    }

    @GwtCompatible(serializable = true)
    public static <T> Predicate<T> b() {
        return ObjectPredicate.ALWAYS_TRUE.withNarrowedType();
    }

    public static <A, B> Predicate<A> c(Predicate<B> predicate, Function<A, ? extends B> function) {
        return new CompositionPredicate(predicate, function);
    }

    public static <T> Predicate<T> d(@NullableDecl T t) {
        return t == null ? f() : new IsEqualToPredicate(t);
    }

    public static <T> Predicate<T> e(Collection<? extends T> collection) {
        return new InPredicate(collection);
    }

    @GwtCompatible(serializable = true)
    public static <T> Predicate<T> f() {
        return ObjectPredicate.IS_NULL.withNarrowedType();
    }

    public static <T> Predicate<T> g(Predicate<T> predicate) {
        return new NotPredicate(predicate);
    }

    /* access modifiers changed from: private */
    public static String h(String str, Iterable<?> iterable) {
        StringBuilder sb = new StringBuilder("Predicates.");
        sb.append(str);
        sb.append('(');
        boolean z = true;
        for (Object obj : iterable) {
            if (!z) {
                sb.append(',');
            }
            sb.append(obj);
            z = false;
        }
        sb.append(')');
        return sb.toString();
    }
}
