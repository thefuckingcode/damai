package cn.damai.rank.view;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.fb0;
import tb.k21;
import tb.ur2;

/* compiled from: Taobao */
public final class WantSeePosterTips$mark$3 extends Lambda implements Function1<fb0<Object>, ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final WantSeePosterTips$mark$3 INSTANCE = new WantSeePosterTips$mark$3();

    WantSeePosterTips$mark$3() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(fb0<Object> fb0) {
        invoke(fb0);
        return ur2.INSTANCE;
    }

    public final void invoke(@NotNull fb0<Object> fb0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1105311961")) {
            ipChange.ipc$dispatch("-1105311961", new Object[]{this, fb0});
            return;
        }
        k21.i(fb0, AdvanceSetting.NETWORK_TYPE);
    }
}
