package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.util.Check;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public abstract class wu2 implements Check {
    @NotNull
    private final String a;

    /* compiled from: Taobao */
    public static final class a extends wu2 {
        private final int b;

        /* JADX WARNING: Illegal instructions before constructor call */
        public a(int i) {
            super(r0.toString(), null);
            StringBuilder sb = new StringBuilder();
            sb.append("must have at least ");
            sb.append(i);
            sb.append(" value parameter");
            sb.append(i > 1 ? "s" : "");
            this.b = i;
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.Check
        public boolean check(@NotNull FunctionDescriptor functionDescriptor) {
            k21.i(functionDescriptor, "functionDescriptor");
            return functionDescriptor.getValueParameters().size() >= this.b;
        }
    }

    /* compiled from: Taobao */
    public static final class b extends wu2 {
        private final int b;

        public b(int i) {
            super("must have exactly " + i + " value parameters", null);
            this.b = i;
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.Check
        public boolean check(@NotNull FunctionDescriptor functionDescriptor) {
            k21.i(functionDescriptor, "functionDescriptor");
            return functionDescriptor.getValueParameters().size() == this.b;
        }
    }

    /* compiled from: Taobao */
    public static final class c extends wu2 {
        @NotNull
        public static final c INSTANCE = new c();

        private c() {
            super("must have no value parameters", null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.Check
        public boolean check(@NotNull FunctionDescriptor functionDescriptor) {
            k21.i(functionDescriptor, "functionDescriptor");
            return functionDescriptor.getValueParameters().isEmpty();
        }
    }

    /* compiled from: Taobao */
    public static final class d extends wu2 {
        @NotNull
        public static final d INSTANCE = new d();

        private d() {
            super("must have a single value parameter", null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.Check
        public boolean check(@NotNull FunctionDescriptor functionDescriptor) {
            k21.i(functionDescriptor, "functionDescriptor");
            return functionDescriptor.getValueParameters().size() == 1;
        }
    }

    private wu2(String str) {
        this.a = str;
    }

    public /* synthetic */ wu2(String str, m40 m40) {
        this(str);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    @NotNull
    public String getDescription() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    @Nullable
    public String invoke(@NotNull FunctionDescriptor functionDescriptor) {
        return Check.a.a(this, functionDescriptor);
    }
}
