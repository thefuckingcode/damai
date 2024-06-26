package kotlin.reflect.jvm.internal.impl.util;

import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

/* compiled from: Taobao */
public interface Check {

    /* compiled from: Taobao */
    public static final class a {
        @Nullable
        public static String a(@NotNull Check check, @NotNull FunctionDescriptor functionDescriptor) {
            k21.i(check, "this");
            k21.i(functionDescriptor, "functionDescriptor");
            if (!check.check(functionDescriptor)) {
                return check.getDescription();
            }
            return null;
        }
    }

    boolean check(@NotNull FunctionDescriptor functionDescriptor);

    @NotNull
    String getDescription();

    @Nullable
    String invoke(@NotNull FunctionDescriptor functionDescriptor);
}
