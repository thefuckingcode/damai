package com.airbnb.lottie.parser.moshi;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.i;

/* compiled from: Taobao */
public abstract class JsonReader implements Closeable {
    private static final String[] g = new String[128];
    int a;
    int[] b = new int[32];
    String[] c = new String[32];
    int[] d = new int[32];
    boolean e;
    boolean f;

    /* compiled from: Taobao */
    public enum Token {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    /* compiled from: Taobao */
    public static final class a {
        final String[] a;
        final i b;

        private a(String[] strArr, i iVar) {
            this.a = strArr;
            this.b = iVar;
        }

        public static a a(String... strArr) {
            try {
                ByteString[] byteStringArr = new ByteString[strArr.length];
                Buffer buffer = new Buffer();
                for (int i = 0; i < strArr.length; i++) {
                    JsonReader.v(buffer, strArr[i]);
                    buffer.readByte();
                    byteStringArr[i] = buffer.readByteString();
                }
                return new a((String[]) strArr.clone(), i.d(byteStringArr));
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }
    }

    static {
        for (int i = 0; i <= 31; i++) {
            g[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = g;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    JsonReader() {
    }

    public static JsonReader p(BufferedSource bufferedSource) {
        return new b(bufferedSource);
    }

    /* access modifiers changed from: private */
    public static void v(BufferedSink bufferedSink, String str) throws IOException {
        String str2;
        String[] strArr = g;
        bufferedSink.writeByte(34);
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt < 128) {
                str2 = strArr[charAt];
                if (str2 == null) {
                }
            } else if (charAt == 8232) {
                str2 = "\\u2028";
            } else if (charAt == 8233) {
                str2 = "\\u2029";
            }
            if (i < i2) {
                bufferedSink.writeUtf8(str, i, i2);
            }
            bufferedSink.writeUtf8(str2);
            i = i2 + 1;
        }
        if (i < length) {
            bufferedSink.writeUtf8(str, i, length);
        }
        bufferedSink.writeByte(34);
    }

    public abstract void c() throws IOException;

    public abstract void e() throws IOException;

    public abstract void f() throws IOException;

    public abstract void g() throws IOException;

    public final String getPath() {
        return a.a(this.a, this.b, this.c, this.d);
    }

    public abstract boolean j() throws IOException;

    public abstract boolean k() throws IOException;

    public abstract double l() throws IOException;

    public abstract int m() throws IOException;

    public abstract String n() throws IOException;

    public abstract String o() throws IOException;

    public abstract Token q() throws IOException;

    /* access modifiers changed from: package-private */
    public final void r(int i) {
        int i2 = this.a;
        int[] iArr = this.b;
        if (i2 == iArr.length) {
            if (i2 != 256) {
                this.b = Arrays.copyOf(iArr, iArr.length * 2);
                String[] strArr = this.c;
                this.c = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                int[] iArr2 = this.d;
                this.d = Arrays.copyOf(iArr2, iArr2.length * 2);
            } else {
                throw new JsonDataException("Nesting too deep at " + getPath());
            }
        }
        int[] iArr3 = this.b;
        int i3 = this.a;
        this.a = i3 + 1;
        iArr3[i3] = i;
    }

    public abstract int s(a aVar) throws IOException;

    public abstract void t() throws IOException;

    public abstract void u() throws IOException;

    /* access modifiers changed from: package-private */
    public final JsonEncodingException w(String str) throws JsonEncodingException {
        throw new JsonEncodingException(str + " at path " + getPath());
    }
}
