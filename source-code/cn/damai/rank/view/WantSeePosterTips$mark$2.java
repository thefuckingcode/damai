package cn.damai.rank.view;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.ur2;

/* compiled from: Taobao */
public final class WantSeePosterTips$mark$2 extends Lambda implements Function1<Object, ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final WantSeePosterTips$mark$2 INSTANCE = new WantSeePosterTips$mark$2();

    WantSeePosterTips$mark$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final void invoke(@NotNull Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2040922490")) {
            ipChange.ipc$dispatch("2040922490", new Object[]{this, obj});
            return;
        }
        k21.i(obj, AdvanceSetting.NETWORK_TYPE);
    }
}
