package tb;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/* compiled from: Taobao */
public class a63 {
    public static final ThreadLocal<Charset> a = new b();

    /* compiled from: Taobao */
    static class a extends ThreadLocal<CharsetDecoder> {
        a() {
        }

        private static CharsetDecoder a() {
            return Charset.forName("UTF-8").newDecoder();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public final /* synthetic */ CharsetDecoder initialValue() {
            return a();
        }
    }

    /* compiled from: Taobao */
    static class b extends ThreadLocal<Charset> {
        b() {
        }

        private static Charset a() {
            return Charset.forName("UTF-8");
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public final /* synthetic */ Charset initialValue() {
            return a();
        }
    }

    static {
        new a();
        new ThreadLocal();
    }
}
