package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.ForOverride;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.jl1;

@GwtCompatible
/* compiled from: Taobao */
public abstract class Converter<A, B> implements Function<A, B> {
    private final boolean handleNullAutomatically;
    @LazyInit
    @MonotonicNonNullDecl
    private transient Converter<B, A> reverse;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class ConverterComposition<A, B, C> extends Converter<A, C> implements Serializable {
        private static final long serialVersionUID = 0;
        final Converter<A, B> first;
        final Converter<B, C> second;

        ConverterComposition(Converter<A, B> converter, Converter<B, C> converter2) {
            this.first = converter;
            this.second = converter2;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.base.Converter
        @NullableDecl
        public A correctedDoBackward(@NullableDecl C c) {
            return this.first.correctedDoBackward(this.second.correctedDoBackward(c));
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.base.Converter
        @NullableDecl
        public C correctedDoForward(@NullableDecl A a) {
            return this.second.correctedDoForward(this.first.correctedDoForward(a));
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        public A doBackward(C c) {
            throw new AssertionError();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        public C doForward(A a) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Function, com.google.common.base.Converter
        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof ConverterComposition)) {
                return false;
            }
            ConverterComposition converterComposition = (ConverterComposition) obj;
            if (!this.first.equals(converterComposition.first) || !this.second.equals(converterComposition.second)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.first.hashCode() * 31) + this.second.hashCode();
        }

        public String toString() {
            return this.first + ".andThen(" + this.second + jl1.BRACKET_END_STR;
        }
    }

    /* compiled from: Taobao */
    private static final class FunctionBasedConverter<A, B> extends Converter<A, B> implements Serializable {
        private final Function<? super B, ? extends A> backwardFunction;
        private final Function<? super A, ? extends B> forwardFunction;

        /* synthetic */ FunctionBasedConverter(Function function, Function function2, a aVar) {
            this(function, function2);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        public A doBackward(B b) {
            return (A) this.backwardFunction.apply(b);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        public B doForward(A a) {
            return (B) this.forwardFunction.apply(a);
        }

        @Override // com.google.common.base.Function, com.google.common.base.Converter
        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof FunctionBasedConverter)) {
                return false;
            }
            FunctionBasedConverter functionBasedConverter = (FunctionBasedConverter) obj;
            if (!this.forwardFunction.equals(functionBasedConverter.forwardFunction) || !this.backwardFunction.equals(functionBasedConverter.backwardFunction)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.forwardFunction.hashCode() * 31) + this.backwardFunction.hashCode();
        }

        public String toString() {
            return "Converter.from(" + this.forwardFunction + AVFSCacheConstants.COMMA_SEP + this.backwardFunction + jl1.BRACKET_END_STR;
        }

        private FunctionBasedConverter(Function<? super A, ? extends B> function, Function<? super B, ? extends A> function2) {
            this.forwardFunction = (Function) ds1.p(function);
            this.backwardFunction = (Function) ds1.p(function2);
        }
    }

    /* compiled from: Taobao */
    private static final class IdentityConverter<T> extends Converter<T, T> implements Serializable {
        static final IdentityConverter INSTANCE = new IdentityConverter();
        private static final long serialVersionUID = 0;

        private IdentityConverter() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.base.Converter
        public <S> Converter<T, S> doAndThen(Converter<T, S> converter) {
            return (Converter) ds1.q(converter, "otherConverter");
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        public T doBackward(T t) {
            return t;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        public T doForward(T t) {
            return t;
        }

        @Override // com.google.common.base.Converter
        public IdentityConverter<T> reverse() {
            return this;
        }

        public String toString() {
            return "Converter.identity()";
        }
    }

    /* compiled from: Taobao */
    private static final class ReverseConverter<A, B> extends Converter<B, A> implements Serializable {
        private static final long serialVersionUID = 0;
        final Converter<A, B> original;

        ReverseConverter(Converter<A, B> converter) {
            this.original = converter;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.base.Converter
        @NullableDecl
        public B correctedDoBackward(@NullableDecl A a) {
            return this.original.correctedDoForward(a);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.base.Converter
        @NullableDecl
        public A correctedDoForward(@NullableDecl B b) {
            return this.original.correctedDoBackward(b);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        public B doBackward(A a) {
            throw new AssertionError();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        public A doForward(B b) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Function, com.google.common.base.Converter
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof ReverseConverter) {
                return this.original.equals(((ReverseConverter) obj).original);
            }
            return false;
        }

        public int hashCode() {
            return ~this.original.hashCode();
        }

        @Override // com.google.common.base.Converter
        public Converter<A, B> reverse() {
            return this.original;
        }

        public String toString() {
            return this.original + ".reverse()";
        }
    }

    /* compiled from: Taobao */
    class a implements Iterable<B> {
        final /* synthetic */ Iterable a;

        /* renamed from: com.google.common.base.Converter$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        class C0154a implements Iterator<B> {
            private final Iterator<? extends A> a;

            C0154a() {
                this.a = a.this.a.iterator();
            }

            public boolean hasNext() {
                return this.a.hasNext();
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.google.common.base.Converter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Iterator
            public B next() {
                return (B) Converter.this.convert(this.a.next());
            }

            public void remove() {
                this.a.remove();
            }
        }

        a(Iterable iterable) {
            this.a = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<B> iterator() {
            return new C0154a();
        }
    }

    protected Converter() {
        this(true);
    }

    public static <A, B> Converter<A, B> from(Function<? super A, ? extends B> function, Function<? super B, ? extends A> function2) {
        return new FunctionBasedConverter(function, function2, null);
    }

    public static <T> Converter<T, T> identity() {
        return IdentityConverter.INSTANCE;
    }

    public final <C> Converter<A, C> andThen(Converter<B, C> converter) {
        return doAndThen(converter);
    }

    @Override // com.google.common.base.Function
    @NullableDecl
    @Deprecated
    @CanIgnoreReturnValue
    public final B apply(@NullableDecl A a2) {
        return convert(a2);
    }

    @CanIgnoreReturnValue
    @NullableDecl
    public final B convert(@NullableDecl A a2) {
        return correctedDoForward(a2);
    }

    @CanIgnoreReturnValue
    public Iterable<B> convertAll(Iterable<? extends A> iterable) {
        ds1.q(iterable, "fromIterable");
        return new a(iterable);
    }

    /* access modifiers changed from: package-private */
    @NullableDecl
    public A correctedDoBackward(@NullableDecl B b) {
        if (!this.handleNullAutomatically) {
            return doBackward(b);
        }
        if (b == null) {
            return null;
        }
        return (A) ds1.p(doBackward(b));
    }

    /* access modifiers changed from: package-private */
    @NullableDecl
    public B correctedDoForward(@NullableDecl A a2) {
        if (!this.handleNullAutomatically) {
            return doForward(a2);
        }
        if (a2 == null) {
            return null;
        }
        return (B) ds1.p(doForward(a2));
    }

    /* access modifiers changed from: package-private */
    public <C> Converter<A, C> doAndThen(Converter<B, C> converter) {
        return new ConverterComposition(this, (Converter) ds1.p(converter));
    }

    /* access modifiers changed from: protected */
    @ForOverride
    public abstract A doBackward(B b);

    /* access modifiers changed from: protected */
    @ForOverride
    public abstract B doForward(A a2);

    @Override // com.google.common.base.Function
    public boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    @CanIgnoreReturnValue
    public Converter<B, A> reverse() {
        Converter<B, A> converter = this.reverse;
        if (converter != null) {
            return converter;
        }
        ReverseConverter reverseConverter = new ReverseConverter(this);
        this.reverse = reverseConverter;
        return reverseConverter;
    }

    Converter(boolean z) {
        this.handleNullAutomatically = z;
    }
}
