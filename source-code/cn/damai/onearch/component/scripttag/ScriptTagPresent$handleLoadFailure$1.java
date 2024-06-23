package cn.damai.onearch.component.scripttag;

import cn.damai.common.util.ToastUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

/* compiled from: Taobao */
public final class ScriptTagPresent$handleLoadFailure$1 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final ScriptTagPresent$handleLoadFailure$1 INSTANCE = new ScriptTagPresent$handleLoadFailure$1();

    ScriptTagPresent$handleLoadFailure$1() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-910580362")) {
            ipChange.ipc$dispatch("-910580362", new Object[]{this});
            return;
        }
        ToastUtil.b("网络开小差了哦，请稍后重试", 0);
    }
}
