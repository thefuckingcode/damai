package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.h;
import kotlin.collections.m;
import kotlin.collections.w;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.e51;
import tb.k21;
import tb.m40;
import tb.ww1;
import tb.y41;

/* compiled from: Taobao */
public final class KotlinClassHeader {
    @NotNull
    private final Kind a;
    @NotNull
    private final e51 b;
    @Nullable
    private final String[] c;
    @Nullable
    private final String[] d;
    @Nullable
    private final String[] e;
    @Nullable
    private final String f;
    private final int g;

    /* compiled from: Taobao */
    public enum Kind {
        UNKNOWN(0),
        CLASS(1),
        FILE_FACADE(2),
        SYNTHETIC_CLASS(3),
        MULTIFILE_CLASS(4),
        MULTIFILE_CLASS_PART(5);
        
        @NotNull
        public static final a Companion = new a(null);
        @NotNull
        private static final Map<Integer, Kind> entryById;
        private final int id;

        /* compiled from: Taobao */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(m40 m40) {
                this();
            }

            @JvmStatic
            @NotNull
            public final Kind a(int i) {
                Kind kind = (Kind) Kind.entryById.get(Integer.valueOf(i));
                return kind == null ? Kind.UNKNOWN : kind;
            }
        }

        static {
            Kind[] values = values();
            LinkedHashMap linkedHashMap = new LinkedHashMap(ww1.a(w.e(values.length), 16));
            for (Kind kind : values) {
                linkedHashMap.put(Integer.valueOf(kind.getId()), kind);
            }
            entryById = linkedHashMap;
        }

        private Kind(int i) {
            this.id = i;
        }

        @JvmStatic
        @NotNull
        public static final Kind getById(int i) {
            return Companion.a(i);
        }

        public final int getId() {
            return this.id;
        }
    }

    public KotlinClassHeader(@NotNull Kind kind, @NotNull e51 e51, @NotNull y41 y41, @Nullable String[] strArr, @Nullable String[] strArr2, @Nullable String[] strArr3, @Nullable String str, int i, @Nullable String str2) {
        k21.i(kind, "kind");
        k21.i(e51, "metadataVersion");
        k21.i(y41, "bytecodeVersion");
        this.a = kind;
        this.b = e51;
        this.c = strArr;
        this.d = strArr2;
        this.e = strArr3;
        this.f = str;
        this.g = i;
    }

    private final boolean h(int i, int i2) {
        return (i & i2) != 0;
    }

    @Nullable
    public final String[] a() {
        return this.c;
    }

    @Nullable
    public final String[] b() {
        return this.d;
    }

    @NotNull
    public final Kind c() {
        return this.a;
    }

    @NotNull
    public final e51 d() {
        return this.b;
    }

    @Nullable
    public final String e() {
        String str = this.f;
        if (c() == Kind.MULTIFILE_CLASS_PART) {
            return str;
        }
        return null;
    }

    @NotNull
    public final List<String> f() {
        String[] strArr = this.c;
        List<String> list = null;
        if (!(c() == Kind.MULTIFILE_CLASS)) {
            strArr = null;
        }
        if (strArr != null) {
            list = h.d(strArr);
        }
        return list != null ? list : m.g();
    }

    @Nullable
    public final String[] g() {
        return this.e;
    }

    public final boolean i() {
        return h(this.g, 2);
    }

    public final boolean j() {
        return h(this.g, 64) && !h(this.g, 32);
    }

    public final boolean k() {
        return h(this.g, 16) && !h(this.g, 32);
    }

    @NotNull
    public String toString() {
        return this.a + " version=" + this.b;
    }
}
