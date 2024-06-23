package tb;

import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class e51 extends nb {
    @NotNull
    public static final a Companion = new a(null);
    @JvmField
    @NotNull
    public static final e51 INSTANCE = new e51(1, 4, 2);
    @JvmField
    @NotNull
    public static final e51 INVALID_VERSION = new e51(new int[0]);
    private final boolean f;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public e51(@NotNull int[] iArr, boolean z) {
        super(r0);
        k21.i(iArr, "versionArray");
        int[] iArr2 = new int[iArr.length];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        this.f = z;
    }

    public boolean h() {
        boolean z;
        if (a() == 1 && b() == 0) {
            return false;
        }
        if (this.f) {
            z = f(INSTANCE);
        } else {
            int a2 = a();
            e51 e51 = INSTANCE;
            z = a2 == e51.a() && b() <= e51.b() + 1;
        }
        if (z) {
            return true;
        }
        return false;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public e51(@NotNull int... iArr) {
        this(iArr, false);
        k21.i(iArr, "numbers");
    }
}
