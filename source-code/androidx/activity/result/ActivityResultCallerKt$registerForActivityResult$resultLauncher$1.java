package androidx.activity.result;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00018\u00018\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"I", "O", "kotlin.jvm.PlatformType", AdvanceSetting.NETWORK_TYPE, "Ltb/ur2;", "onActivityResult", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
final class ActivityResultCallerKt$registerForActivityResult$resultLauncher$1<O> implements ActivityResultCallback<O> {
    final /* synthetic */ Function1 $callback;

    ActivityResultCallerKt$registerForActivityResult$resultLauncher$1(Function1 function1) {
        this.$callback = function1;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public final void onActivityResult(O o) {
        this.$callback.invoke(o);
    }
}
