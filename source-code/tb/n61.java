package tb;

import android.app.Activity;
import cn.damai.commonbusiness.update.UpdateUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.jr1;

/* compiled from: Taobao */
public final class n61 extends pr1 {
    private static transient /* synthetic */ IpChange $ipChange;

    public n61(@NotNull Activity activity) {
        k21.i(activity, WPKFactory.INIT_KEY_CONTEXT);
    }

    private final void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "333532339")) {
            ipChange.ipc$dispatch("333532339", new Object[]{this});
            return;
        }
        UpdateUtil.e();
    }

    @Override // com.alibaba.yymidservice.popup.popupcenter.view.PopupViewHandleCallback
    @Nullable
    public <T, K> Object popHandle(@Nullable T t, @Nullable K k, @NotNull Continuation<? super jr1> continuation) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2076989507")) {
            return ipChange.ipc$dispatch("-2076989507", new Object[]{this, t, k, continuation});
        }
        a();
        return jr1.a.INSTANCE;
    }
}
