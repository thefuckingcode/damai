package androidx.core.transition;

import android.transition.Transition;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/transition/Transition;", AdvanceSetting.NETWORK_TYPE, "Ltb/ur2;", "invoke", "(Landroid/transition/Transition;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class TransitionKt$addListener$2 extends Lambda implements Function1<Transition, ur2> {
    public static final TransitionKt$addListener$2 INSTANCE = new TransitionKt$addListener$2();

    public TransitionKt$addListener$2() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(Transition transition) {
        invoke(transition);
        return ur2.INSTANCE;
    }

    public final void invoke(@NotNull Transition transition) {
        k21.i(transition, AdvanceSetting.NETWORK_TYPE);
    }
}
