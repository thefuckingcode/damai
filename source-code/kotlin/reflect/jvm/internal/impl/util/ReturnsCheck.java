package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.b;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.util.Check;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.g61;
import tb.k21;
import tb.m40;

/* compiled from: Taobao */
public abstract class ReturnsCheck implements Check {
    @NotNull
    private final String a;
    @NotNull
    private final Function1<b, g61> b;
    @NotNull
    private final String c;

    /* compiled from: Taobao */
    public static final class ReturnsBoolean extends ReturnsCheck {
        @NotNull
        public static final ReturnsBoolean INSTANCE = new ReturnsBoolean();

        private ReturnsBoolean() {
            super("Boolean", AnonymousClass1.INSTANCE, null);
        }
    }

    /* compiled from: Taobao */
    public static final class ReturnsInt extends ReturnsCheck {
        @NotNull
        public static final ReturnsInt INSTANCE = new ReturnsInt();

        private ReturnsInt() {
            super("Int", AnonymousClass1.INSTANCE, null);
        }
    }

    /* compiled from: Taobao */
    public static final class ReturnsUnit extends ReturnsCheck {
        @NotNull
        public static final ReturnsUnit INSTANCE = new ReturnsUnit();

        private ReturnsUnit() {
            super("Unit", AnonymousClass1.INSTANCE, null);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.builtins.b, ? extends tb.g61> */
    /* JADX WARN: Multi-variable type inference failed */
    private ReturnsCheck(String str, Function1<? super b, ? extends g61> function1) {
        this.a = str;
        this.b = function1;
        this.c = k21.r("must return ", str);
    }

    public /* synthetic */ ReturnsCheck(String str, Function1 function1, m40 m40) {
        this(str, function1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public boolean check(@NotNull FunctionDescriptor functionDescriptor) {
        k21.i(functionDescriptor, "functionDescriptor");
        return k21.d(functionDescriptor.getReturnType(), this.b.invoke(DescriptorUtilsKt.g(functionDescriptor)));
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    @NotNull
    public String getDescription() {
        return this.c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    @Nullable
    public String invoke(@NotNull FunctionDescriptor functionDescriptor) {
        return Check.a.a(this, functionDescriptor);
    }
}
