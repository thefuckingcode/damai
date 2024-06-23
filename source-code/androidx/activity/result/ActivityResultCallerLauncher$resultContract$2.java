package androidx.activity.result;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContract;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.ur2;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000b\n\u0002\b\u0002\n\u0002\b\u0004*\u0001\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"I", "O", "androidx/activity/result/ActivityResultCallerLauncher$resultContract$2$1", "invoke", "()Landroidx/activity/result/ActivityResultCallerLauncher$resultContract$2$1;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class ActivityResultCallerLauncher$resultContract$2 extends Lambda implements Function0<AnonymousClass1> {
    final /* synthetic */ ActivityResultCallerLauncher this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ActivityResultCallerLauncher$resultContract$2(ActivityResultCallerLauncher activityResultCallerLauncher) {
        super(0);
        this.this$0 = activityResultCallerLauncher;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final AnonymousClass1 invoke() {
        return new ActivityResultContract<ur2, O>(this) {
            /* class androidx.activity.result.ActivityResultCallerLauncher$resultContract$2.AnonymousClass1 */
            final /* synthetic */ ActivityResultCallerLauncher$resultContract$2 this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            @Override // androidx.activity.result.contract.ActivityResultContract
            public O parseResult(int i, @Nullable Intent intent) {
                return (O) this.this$0.this$0.getCallerContract().parseResult(i, intent);
            }

            @NotNull
            public Intent createIntent(@NotNull Context context, @Nullable ur2 ur2) {
                k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
                Intent createIntent = this.this$0.this$0.getCallerContract().createIntent(context, this.this$0.this$0.getInput());
                k21.h(createIntent, "callerContract.createIntent(context, input)");
                return createIntent;
            }
        };
    }
}
