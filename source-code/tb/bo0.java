package tb;

import com.alibaba.fastjson.JSONObject;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.Charset;
import kotlin.collections.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class bo0 {
    @NotNull
    public static final bo0 INSTANCE = new bo0();

    private bo0() {
    }

    private final int a(byte[] bArr) {
        return (bArr[0] & 255) | ((bArr[1] & 255) << 8);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b3, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00b4, code lost:
        tb.dj.a(r2, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b7, code lost:
        throw r0;
     */
    private final a d(File file) {
        a aVar = new a(null, null, null, null, 15, null);
        FileInputStream fileInputStream = new FileInputStream(file);
        int length = (int) file.length();
        if (fileInputStream.read(new byte[100], 0, 100) <= 0) {
            dj.a(fileInputStream, null);
            return null;
        }
        int i = length - 100;
        while (i > 0) {
            byte[] bArr = new byte[4];
            int read = fileInputStream.read(bArr, 0, 4);
            bo0 bo0 = INSTANCE;
            int a2 = bo0.a(bArr);
            int i2 = i - read;
            byte[] bArr2 = new byte[a2];
            int read2 = fileInputStream.read(bArr2, 0, a2);
            Charset forName = Charset.forName("UTF-8");
            k21.h(forName, "forName(\"UTF-8\")");
            String str = new String(bArr2, forName);
            int i3 = i2 - read2;
            byte[] bArr3 = new byte[4];
            int read3 = fileInputStream.read(bArr3, 0, 4);
            int a3 = bo0.a(bArr3);
            int i4 = i3 - read3;
            byte[] bArr4 = new byte[a3];
            int read4 = fileInputStream.read(bArr4, 0, a3);
            Charset forName2 = Charset.forName("UTF-8");
            k21.h(forName2, "forName(\"UTF-8\")");
            String str2 = new String(bArr4, forName2);
            i = i4 - read4;
            switch (str.hashCode()) {
                case -1510940545:
                    if (str.equals("index.databinding")) {
                        aVar.f(str2);
                        break;
                    } else {
                        break;
                    }
                case -808658201:
                    if (str.equals("index.css")) {
                        aVar.e(str2);
                        break;
                    } else {
                        break;
                    }
                case 112461797:
                    if (str.equals("index.js")) {
                        aVar.g(str2);
                        break;
                    } else {
                        break;
                    }
                case 701608068:
                    if (str.equals("index.json")) {
                        aVar.h(str2);
                        break;
                    } else {
                        break;
                    }
            }
        }
        ur2 ur2 = ur2.INSTANCE;
        dj.a(fileInputStream, null);
        return aVar;
    }

    private final a e(byte[] bArr) {
        a aVar = new a(null, null, null, null, 15, null);
        int length = bArr.length;
        int i = 100;
        if (h.g(bArr, 0, 100).length <= 0) {
            return null;
        }
        int i2 = length - 100;
        while (i2 > 0) {
            byte[] bArr2 = h.g(bArr, i, i + 4);
            int length2 = bArr2.length;
            int i3 = i + length2;
            int i4 = i2 - length2;
            byte[] bArr3 = h.g(bArr, i3, a(bArr2) + i3);
            int length3 = bArr3.length;
            Charset forName = Charset.forName("UTF-8");
            k21.h(forName, "forName(\"UTF-8\")");
            String str = new String(bArr3, forName);
            int i5 = i3 + length3;
            int i6 = i4 - length3;
            byte[] bArr4 = h.g(bArr, i5, i5 + 4);
            int length4 = bArr4.length;
            int i7 = i5 + length4;
            int i8 = i6 - length4;
            byte[] bArr5 = h.g(bArr, i7, a(bArr4) + i7);
            int length5 = bArr5.length;
            Charset forName2 = Charset.forName("UTF-8");
            k21.h(forName2, "forName(\"UTF-8\")");
            String str2 = new String(bArr5, forName2);
            i = i7 + length5;
            i2 = i8 - length5;
            switch (str.hashCode()) {
                case -1510940545:
                    if (str.equals("index.databinding")) {
                        aVar.f(str2);
                        break;
                    } else {
                        break;
                    }
                case -808658201:
                    if (str.equals("index.css")) {
                        aVar.e(str2);
                        break;
                    } else {
                        break;
                    }
                case 112461797:
                    if (str.equals("index.js")) {
                        aVar.g(str2);
                        break;
                    } else {
                        break;
                    }
                case 701608068:
                    if (str.equals("index.json")) {
                        aVar.h(str2);
                        break;
                    } else {
                        break;
                    }
            }
        }
        return aVar;
    }

    @NotNull
    public final JSONObject b(@NotNull File file) {
        k21.i(file, "binFile");
        JSONObject jSONObject = new JSONObject();
        a d = d(file);
        if (d != null) {
            jSONObject.put((Object) "layer", (Object) d.d());
            jSONObject.put((Object) "databinding", (Object) d.b());
            jSONObject.put((Object) "css", (Object) d.a());
            jSONObject.put((Object) "js", (Object) d.c());
        }
        return jSONObject;
    }

    @NotNull
    public final JSONObject c(@NotNull byte[] bArr) {
        k21.i(bArr, "bytes");
        JSONObject jSONObject = new JSONObject();
        a e = e(bArr);
        if (e != null) {
            jSONObject.put((Object) "layer", (Object) e.d());
            jSONObject.put((Object) "databinding", (Object) e.b());
            jSONObject.put((Object) "css", (Object) e.a());
            jSONObject.put((Object) "js", (Object) e.c());
        }
        return jSONObject;
    }

    /* compiled from: Taobao */
    public static final class a {
        @NotNull
        private String a;
        @NotNull
        private String b;
        @NotNull
        private String c;
        @NotNull
        private String d;

        public a() {
            this(null, null, null, null, 15, null);
        }

        public a(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
            k21.i(str, "layer");
            k21.i(str2, "databinding");
            k21.i(str3, "css");
            k21.i(str4, "js");
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
        }

        @NotNull
        public final String a() {
            return this.c;
        }

        @NotNull
        public final String b() {
            return this.b;
        }

        @NotNull
        public final String c() {
            return this.d;
        }

        @NotNull
        public final String d() {
            return this.a;
        }

        public final void e(@NotNull String str) {
            k21.i(str, "<set-?>");
            this.c = str;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return k21.d(this.a, aVar.a) && k21.d(this.b, aVar.b) && k21.d(this.c, aVar.c) && k21.d(this.d, aVar.d);
        }

        public final void f(@NotNull String str) {
            k21.i(str, "<set-?>");
            this.b = str;
        }

        public final void g(@NotNull String str) {
            k21.i(str, "<set-?>");
            this.d = str;
        }

        public final void h(@NotNull String str) {
            k21.i(str, "<set-?>");
            this.a = str;
        }

        public int hashCode() {
            return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        @NotNull
        public String toString() {
            return "GXBinaryData(layer=" + this.a + ", databinding=" + this.b + ", css=" + this.c + ", js=" + this.d + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ a(String str, String str2, String str3, String str4, int i, m40 m40) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
        }
    }
}
