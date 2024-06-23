package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import org.jetbrains.annotations.NotNull;
import tb.es2;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class SignatureEnhancement$enhanceTypeParameterBounds$1$1 extends Lambda implements Function1<es2, Boolean> {
    public static final SignatureEnhancement$enhanceTypeParameterBounds$1$1 INSTANCE = new SignatureEnhancement$enhanceTypeParameterBounds$1$1();

    SignatureEnhancement$enhanceTypeParameterBounds$1$1() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(es2 es2) {
        return Boolean.valueOf(invoke(es2));
    }

    public final boolean invoke(@NotNull es2 es2) {
        k21.i(es2, AdvanceSetting.NETWORK_TYPE);
        return es2 instanceof RawType;
    }
}
