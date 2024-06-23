package com.google.common.hash;

import com.google.common.annotations.Beta;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.jl1;

@Beta
/* compiled from: Taobao */
public final class Funnels {

    /* compiled from: Taobao */
    private enum ByteArrayFunnel implements Funnel<byte[]> {
        INSTANCE;

        public String toString() {
            return "Funnels.byteArrayFunnel()";
        }

        public void funnel(byte[] bArr, PrimitiveSink primitiveSink) {
            primitiveSink.putBytes(bArr);
        }
    }

    /* compiled from: Taobao */
    private enum IntegerFunnel implements Funnel<Integer> {
        INSTANCE;

        public String toString() {
            return "Funnels.integerFunnel()";
        }

        public void funnel(Integer num, PrimitiveSink primitiveSink) {
            primitiveSink.putInt(num.intValue());
        }
    }

    /* compiled from: Taobao */
    private enum LongFunnel implements Funnel<Long> {
        INSTANCE;

        public String toString() {
            return "Funnels.longFunnel()";
        }

        public void funnel(Long l, PrimitiveSink primitiveSink) {
            primitiveSink.putLong(l.longValue());
        }
    }

    /* compiled from: Taobao */
    private static class SequentialFunnel<E> implements Funnel<Iterable<? extends E>>, Serializable {
        private final Funnel<E> elementFunnel;

        SequentialFunnel(Funnel<E> funnel) {
            this.elementFunnel = (Funnel) ds1.p(funnel);
        }

        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof SequentialFunnel) {
                return this.elementFunnel.equals(((SequentialFunnel) obj).elementFunnel);
            }
            return false;
        }

        @Override // com.google.common.hash.Funnel
        public /* bridge */ /* synthetic */ void funnel(Object obj, PrimitiveSink primitiveSink) {
            funnel((Iterable) ((Iterable) obj), primitiveSink);
        }

        public int hashCode() {
            return SequentialFunnel.class.hashCode() ^ this.elementFunnel.hashCode();
        }

        public String toString() {
            return "Funnels.sequentialFunnel(" + this.elementFunnel + jl1.BRACKET_END_STR;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.common.hash.Funnel<E> */
        /* JADX WARN: Multi-variable type inference failed */
        public void funnel(Iterable<? extends E> iterable, PrimitiveSink primitiveSink) {
            Iterator<? extends E> it = iterable.iterator();
            while (it.hasNext()) {
                this.elementFunnel.funnel(it.next(), primitiveSink);
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class StringCharsetFunnel implements Funnel<CharSequence>, Serializable {
        private final Charset charset;

        /* compiled from: Taobao */
        private static class SerializedForm implements Serializable {
            private static final long serialVersionUID = 0;
            private final String charsetCanonicalName;

            SerializedForm(Charset charset) {
                this.charsetCanonicalName = charset.name();
            }

            private Object readResolve() {
                return Funnels.a(Charset.forName(this.charsetCanonicalName));
            }
        }

        StringCharsetFunnel(Charset charset2) {
            this.charset = (Charset) ds1.p(charset2);
        }

        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof StringCharsetFunnel) {
                return this.charset.equals(((StringCharsetFunnel) obj).charset);
            }
            return false;
        }

        public int hashCode() {
            return StringCharsetFunnel.class.hashCode() ^ this.charset.hashCode();
        }

        public String toString() {
            return "Funnels.stringFunnel(" + this.charset.name() + jl1.BRACKET_END_STR;
        }

        /* access modifiers changed from: package-private */
        public Object writeReplace() {
            return new SerializedForm(this.charset);
        }

        public void funnel(CharSequence charSequence, PrimitiveSink primitiveSink) {
            primitiveSink.putString(charSequence, this.charset);
        }
    }

    /* compiled from: Taobao */
    private enum UnencodedCharsFunnel implements Funnel<CharSequence> {
        INSTANCE;

        public String toString() {
            return "Funnels.unencodedCharsFunnel()";
        }

        public void funnel(CharSequence charSequence, PrimitiveSink primitiveSink) {
            primitiveSink.putUnencodedChars(charSequence);
        }
    }

    public static Funnel<CharSequence> a(Charset charset) {
        return new StringCharsetFunnel(charset);
    }
}
