package kotlin.reflect.jvm.internal.impl.descriptors;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.oi;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$2 extends Lambda implements Function1<oi, Integer> {
    public static final FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$2 INSTANCE = new FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$2();

    FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$2() {
        super(1);
    }

    public final int invoke(@NotNull oi oiVar) {
        k21.i(oiVar, AdvanceSetting.NETWORK_TYPE);
        return 0;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(oi oiVar) {
        return Integer.valueOf(invoke(oiVar));
    }
}
