package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import com.taobao.weex.bridge.WXBridgeManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a[\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u00020\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\f\u0010\r\u001aS\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u00020\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0005\u001a\u00028\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\f\u0010\u000e¨\u0006\u000f"}, d2 = {"I", "O", "Landroidx/activity/result/ActivityResultCaller;", "Landroidx/activity/result/contract/ActivityResultContract;", "contract", "input", "Landroidx/activity/result/ActivityResultRegistry;", "registry", "Lkotlin/Function1;", "Ltb/ur2;", WXBridgeManager.METHOD_CALLBACK, "Landroidx/activity/result/ActivityResultLauncher;", "registerForActivityResult", "(Landroidx/activity/result/ActivityResultCaller;Landroidx/activity/result/contract/ActivityResultContract;Ljava/lang/Object;Landroidx/activity/result/ActivityResultRegistry;Lkotlin/jvm/functions/Function1;)Landroidx/activity/result/ActivityResultLauncher;", "(Landroidx/activity/result/ActivityResultCaller;Landroidx/activity/result/contract/ActivityResultContract;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Landroidx/activity/result/ActivityResultLauncher;", "activity-ktx_release"}, k = 2, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class ActivityResultCallerKt {
    @NotNull
    public static final <I, O> ActivityResultLauncher<ur2> registerForActivityResult(@NotNull ActivityResultCaller activityResultCaller, @NotNull ActivityResultContract<I, O> activityResultContract, I i, @NotNull ActivityResultRegistry activityResultRegistry, @NotNull Function1<? super O, ur2> function1) {
        k21.i(activityResultCaller, "$this$registerForActivityResult");
        k21.i(activityResultContract, "contract");
        k21.i(activityResultRegistry, "registry");
        k21.i(function1, WXBridgeManager.METHOD_CALLBACK);
        ActivityResultLauncher<I> registerForActivityResult = activityResultCaller.registerForActivityResult(activityResultContract, activityResultRegistry, new ActivityResultCallerKt$registerForActivityResult$resultLauncher$1(function1));
        k21.h(registerForActivityResult, "registerForActivityResul…egistry) { callback(it) }");
        return new ActivityResultCallerLauncher(registerForActivityResult, activityResultContract, i);
    }

    @NotNull
    public static final <I, O> ActivityResultLauncher<ur2> registerForActivityResult(@NotNull ActivityResultCaller activityResultCaller, @NotNull ActivityResultContract<I, O> activityResultContract, I i, @NotNull Function1<? super O, ur2> function1) {
        k21.i(activityResultCaller, "$this$registerForActivityResult");
        k21.i(activityResultContract, "contract");
        k21.i(function1, WXBridgeManager.METHOD_CALLBACK);
        ActivityResultLauncher<I> registerForActivityResult = activityResultCaller.registerForActivityResult(activityResultContract, new ActivityResultCallerKt$registerForActivityResult$resultLauncher$2(function1));
        k21.h(registerForActivityResult, "registerForActivityResul…ontract) { callback(it) }");
        return new ActivityResultCallerLauncher(registerForActivityResult, activityResultContract, i);
    }
}
