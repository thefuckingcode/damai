package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public abstract class ne0 extends om<ur2> {
    @NotNull
    public static final a Companion = new a(null);

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final ne0 a(@NotNull String str) {
            k21.i(str, "message");
            return new b(str);
        }
    }

    /* compiled from: Taobao */
    public static final class b extends ne0 {
        @NotNull
        private final String b;

        public b(@NotNull String str) {
            k21.i(str, "message");
            this.b = str;
        }

        @NotNull
        /* renamed from: d */
        public ib2 a(@NotNull ModuleDescriptor moduleDescriptor) {
            k21.i(moduleDescriptor, "module");
            ib2 j = me0.j(this.b);
            k21.h(j, "createErrorType(message)");
            return j;
        }

        @Override // tb.om
        @NotNull
        public String toString() {
            return this.b;
        }
    }

    public ne0() {
        super(ur2.INSTANCE);
    }

    @NotNull
    /* renamed from: c */
    public ur2 b() {
        throw new UnsupportedOperationException();
    }
}
