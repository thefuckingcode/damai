package tb;

import com.tencent.open.SocialConstants;
import com.tencent.open.SocialOperation;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.d51;

/* compiled from: Taobao */
public final class qc1 {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private final String a;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @JvmStatic
        @NotNull
        public final qc1 a(@NotNull String str, @NotNull String str2) {
            k21.i(str, "name");
            k21.i(str2, SocialConstants.PARAM_APP_DESC);
            return new qc1(str + '#' + str2, null);
        }

        @JvmStatic
        @NotNull
        public final qc1 b(@NotNull d51 d51) {
            k21.i(d51, SocialOperation.GAME_SIGNATURE);
            if (d51 instanceof d51.b) {
                return d(d51.c(), d51.b());
            }
            if (d51 instanceof d51.a) {
                return a(d51.c(), d51.b());
            }
            throw new NoWhenBranchMatchedException();
        }

        @JvmStatic
        @NotNull
        public final qc1 c(@NotNull NameResolver nameResolver, @NotNull JvmProtoBuf.JvmMethodSignature jvmMethodSignature) {
            k21.i(nameResolver, "nameResolver");
            k21.i(jvmMethodSignature, SocialOperation.GAME_SIGNATURE);
            return d(nameResolver.getString(jvmMethodSignature.getName()), nameResolver.getString(jvmMethodSignature.getDesc()));
        }

        @JvmStatic
        @NotNull
        public final qc1 d(@NotNull String str, @NotNull String str2) {
            k21.i(str, "name");
            k21.i(str2, SocialConstants.PARAM_APP_DESC);
            return new qc1(k21.r(str, str2), null);
        }

        @JvmStatic
        @NotNull
        public final qc1 e(@NotNull qc1 qc1, int i) {
            k21.i(qc1, SocialOperation.GAME_SIGNATURE);
            return new qc1(qc1.a() + '@' + i, null);
        }
    }

    private qc1(String str) {
        this.a = str;
    }

    public /* synthetic */ qc1(String str, m40 m40) {
        this(str);
    }

    @NotNull
    public final String a() {
        return this.a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof qc1) && k21.d(this.a, ((qc1) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @NotNull
    public String toString() {
        return "MemberSignature(signature=" + this.a + ')';
    }
}
