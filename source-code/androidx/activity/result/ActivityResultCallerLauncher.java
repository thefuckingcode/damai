package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;
import com.taobao.aranger.constant.Constants;
import com.taobao.weex.bridge.WXBridgeManager;
import com.xiaomi.mipush.sdk.MiPushClient;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B1\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b\u0012\u0006\u0010\u0019\u001a\u00028\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ#\u0010\b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0004H\u0016J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00010\u000bH\u0016R)\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00010\u000b8F@\u0006X\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R%\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0010R\u0019\u0010\u0019\u001a\u00028\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Landroidx/activity/result/ActivityResultCallerLauncher;", "I", "O", "Landroidx/activity/result/ActivityResultLauncher;", "Ltb/ur2;", Constants.VOID, "Landroidx/core/app/ActivityOptionsCompat;", WXBridgeManager.OPTIONS, "launch", "(Ltb/ur2;Landroidx/core/app/ActivityOptionsCompat;)V", MiPushClient.COMMAND_UNREGISTER, "Landroidx/activity/result/contract/ActivityResultContract;", "getContract", "resultContract$delegate", "Lkotlin/Lazy;", "getResultContract", "()Landroidx/activity/result/contract/ActivityResultContract;", "resultContract", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "getLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "callerContract", "Landroidx/activity/result/contract/ActivityResultContract;", "getCallerContract", "input", "Ljava/lang/Object;", "getInput", "()Ljava/lang/Object;", "<init>", "(Landroidx/activity/result/ActivityResultLauncher;Landroidx/activity/result/contract/ActivityResultContract;Ljava/lang/Object;)V", "activity-ktx_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class ActivityResultCallerLauncher<I, O> extends ActivityResultLauncher<ur2> {
    @NotNull
    private final ActivityResultContract<I, O> callerContract;
    private final I input;
    @NotNull
    private final ActivityResultLauncher<I> launcher;
    @NotNull
    private final Lazy resultContract$delegate = a.b(new ActivityResultCallerLauncher$resultContract$2(this));

    public ActivityResultCallerLauncher(@NotNull ActivityResultLauncher<I> activityResultLauncher, @NotNull ActivityResultContract<I, O> activityResultContract, I i) {
        k21.i(activityResultLauncher, "launcher");
        k21.i(activityResultContract, "callerContract");
        this.launcher = activityResultLauncher;
        this.callerContract = activityResultContract;
        this.input = i;
    }

    @NotNull
    public final ActivityResultContract<I, O> getCallerContract() {
        return this.callerContract;
    }

    /* Return type fixed from 'androidx.activity.result.contract.ActivityResultContract<tb.ur2, O>' to match base method */
    @Override // androidx.activity.result.ActivityResultLauncher
    @NotNull
    public ActivityResultContract<ur2, ?> getContract() {
        return getResultContract();
    }

    public final I getInput() {
        return this.input;
    }

    @NotNull
    public final ActivityResultLauncher<I> getLauncher() {
        return this.launcher;
    }

    @NotNull
    public final ActivityResultContract<ur2, O> getResultContract() {
        return (ActivityResultContract) this.resultContract$delegate.getValue();
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public void unregister() {
        this.launcher.unregister();
    }

    public void launch(@Nullable ur2 ur2, @Nullable ActivityOptionsCompat activityOptionsCompat) {
        this.launcher.launch(this.input, activityOptionsCompat);
    }
}
