package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: constantValues.kt */
public abstract class ErrorValue extends ConstantValue<Unit> {
    public static final Companion Companion = new Companion(null);

    public ErrorValue() {
        super(Unit.INSTANCE);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public Unit getValue() {
        throw new UnsupportedOperationException();
    }

    /* compiled from: constantValues.kt */
    public static final class ErrorValueWithMessage extends ErrorValue {
        private final String message;

        public ErrorValueWithMessage(String str) {
            Intrinsics.checkParameterIsNotNull(str, "message");
            this.message = str;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
        public SimpleType getType(ModuleDescriptor moduleDescriptor) {
            Intrinsics.checkParameterIsNotNull(moduleDescriptor, "module");
            SimpleType createErrorType = ErrorUtils.createErrorType(this.message);
            Intrinsics.checkExpressionValueIsNotNull(createErrorType, "ErrorUtils.createErrorType(message)");
            return createErrorType;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
        public String toString() {
            return this.message;
        }
    }

    /* compiled from: constantValues.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ErrorValue create(String str) {
            Intrinsics.checkParameterIsNotNull(str, "message");
            return new ErrorValueWithMessage(str);
        }
    }
}
