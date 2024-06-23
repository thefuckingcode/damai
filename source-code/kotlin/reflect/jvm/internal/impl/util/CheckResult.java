package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: modifierChecks.kt */
public abstract class CheckResult {
    private final boolean isSuccess;

    /* compiled from: modifierChecks.kt */
    public static final class IllegalSignature extends CheckResult {
        private final String error;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public IllegalSignature(String str) {
            super(false, null);
            Intrinsics.checkParameterIsNotNull(str, "error");
            this.error = str;
        }
    }

    private CheckResult(boolean z) {
        this.isSuccess = z;
    }

    public /* synthetic */ CheckResult(boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(z);
    }

    public final boolean isSuccess() {
        return this.isSuccess;
    }

    /* compiled from: modifierChecks.kt */
    public static final class IllegalFunctionName extends CheckResult {
        public static final IllegalFunctionName INSTANCE = new IllegalFunctionName();

        private IllegalFunctionName() {
            super(false, null);
        }
    }

    /* compiled from: modifierChecks.kt */
    public static final class SuccessCheck extends CheckResult {
        public static final SuccessCheck INSTANCE = new SuccessCheck();

        private SuccessCheck() {
            super(true, null);
        }
    }
}
