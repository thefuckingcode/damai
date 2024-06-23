package kotlin.reflect.jvm.internal.impl.resolve.constants;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.g61;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class ConstantValueFactory$createArrayValue$1 extends Lambda implements Function1<ModuleDescriptor, g61> {
    final /* synthetic */ g61 $type;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConstantValueFactory$createArrayValue$1(g61 g61) {
        super(1);
        this.$type = g61;
    }

    @NotNull
    public final g61 invoke(@NotNull ModuleDescriptor moduleDescriptor) {
        k21.i(moduleDescriptor, AdvanceSetting.NETWORK_TYPE);
        return this.$type;
    }
}
