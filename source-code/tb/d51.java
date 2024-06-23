package tb;

import com.tencent.open.SocialConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public abstract class d51 {

    /* compiled from: Taobao */
    public static final class a extends d51 {
        @NotNull
        private final String a;
        @NotNull
        private final String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(@NotNull String str, @NotNull String str2) {
            super(null);
            k21.i(str, "name");
            k21.i(str2, SocialConstants.PARAM_APP_DESC);
            this.a = str;
            this.b = str2;
        }

        @Override // tb.d51
        @NotNull
        public String a() {
            return c() + jl1.CONDITION_IF_MIDDLE + b();
        }

        @Override // tb.d51
        @NotNull
        public String b() {
            return this.b;
        }

        @Override // tb.d51
        @NotNull
        public String c() {
            return this.a;
        }

        @NotNull
        public final String d() {
            return this.a;
        }

        @NotNull
        public final String e() {
            return this.b;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return k21.d(this.a, aVar.a) && k21.d(this.b, aVar.b);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }
    }

    /* compiled from: Taobao */
    public static final class b extends d51 {
        @NotNull
        private final String a;
        @NotNull
        private final String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(@NotNull String str, @NotNull String str2) {
            super(null);
            k21.i(str, "name");
            k21.i(str2, SocialConstants.PARAM_APP_DESC);
            this.a = str;
            this.b = str2;
        }

        @Override // tb.d51
        @NotNull
        public String a() {
            return k21.r(c(), b());
        }

        @Override // tb.d51
        @NotNull
        public String b() {
            return this.b;
        }

        @Override // tb.d51
        @NotNull
        public String c() {
            return this.a;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return k21.d(this.a, bVar.a) && k21.d(this.b, bVar.b);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }
    }

    private d51() {
    }

    public /* synthetic */ d51(m40 m40) {
        this();
    }

    @NotNull
    public abstract String a();

    @NotNull
    public abstract String b();

    @NotNull
    public abstract String c();

    @NotNull
    public final String toString() {
        return a();
    }
}
