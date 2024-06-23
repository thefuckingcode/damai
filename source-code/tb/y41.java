package tb;

import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class y41 extends nb {
    @NotNull
    public static final a Companion = new a(null);
    @JvmField
    @NotNull
    public static final y41 INSTANCE = new y41(1, 0, 3);
    @JvmField
    @NotNull
    public static final y41 INVALID_VERSION = new y41(new int[0]);

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public y41(@NotNull int... iArr) {
        super(r0);
        k21.i(iArr, "numbers");
        int[] iArr2 = new int[iArr.length];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
    }
}
