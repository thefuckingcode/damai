package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import tb.es2;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class CapturedTypeApproximationKt$approximateCapturedTypesIfNecessary$1 extends Lambda implements Function1<es2, Boolean> {
    public static final CapturedTypeApproximationKt$approximateCapturedTypesIfNecessary$1 INSTANCE = new CapturedTypeApproximationKt$approximateCapturedTypesIfNecessary$1();

    CapturedTypeApproximationKt$approximateCapturedTypesIfNecessary$1() {
        super(1);
    }

    public final Boolean invoke(es2 es2) {
        k21.h(es2, AdvanceSetting.NETWORK_TYPE);
        return Boolean.valueOf(CapturedTypeConstructorKt.d(es2));
    }
}
