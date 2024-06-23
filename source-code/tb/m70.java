package tb;

import kotlin.NoWhenBranchMatchedException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public abstract class m70 {

    /* compiled from: Taobao */
    public static final class a extends m70 {
        @NotNull
        public static final a INSTANCE = new a();

        private a() {
            super(null);
        }
    }

    /* compiled from: Taobao */
    public static final class b extends m70 {
        private final float a;

        public b(float f) {
            super(null);
            this.a = f;
        }

        public final float c() {
            return this.a;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && k21.d(Float.valueOf(this.a), Float.valueOf(((b) obj).a));
        }

        public int hashCode() {
            return Float.floatToIntBits(this.a);
        }

        @Override // tb.m70
        @NotNull
        public String toString() {
            return "Percent(percentage=" + this.a + ')';
        }
    }

    /* compiled from: Taobao */
    public static final class c extends m70 {
        private final float a;

        public c(float f) {
            super(null);
            this.a = f;
        }

        public final float c() {
            return this.a;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && k21.d(Float.valueOf(this.a), Float.valueOf(((c) obj).a));
        }

        public int hashCode() {
            return Float.floatToIntBits(this.a);
        }

        @Override // tb.m70
        @NotNull
        public String toString() {
            return "Points(points=" + this.a + ')';
        }
    }

    /* compiled from: Taobao */
    public static final class d extends m70 {
        @NotNull
        public static final d INSTANCE = new d();

        private d() {
            super(null);
        }
    }

    private m70() {
    }

    public /* synthetic */ m70(m40 m40) {
        this();
    }

    public final int a() {
        if (this instanceof c) {
            return 0;
        }
        if (this instanceof b) {
            return 1;
        }
        if (this instanceof d) {
            return 2;
        }
        if (this instanceof a) {
            return 3;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final float b() {
        if (this instanceof c) {
            return ((c) this).c();
        }
        if (this instanceof b) {
            return ((b) this).c();
        }
        if ((this instanceof d) || (this instanceof a)) {
            return 0.0f;
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public String toString() {
        if (this instanceof c) {
            return "Dimension.Points";
        }
        if (this instanceof b) {
            return "Dimension.Percent(value=" + b() + ')';
        } else if (this instanceof d) {
            return "Dimension.Undefined";
        } else {
            if (this instanceof a) {
                return "Dimension.Auto";
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
