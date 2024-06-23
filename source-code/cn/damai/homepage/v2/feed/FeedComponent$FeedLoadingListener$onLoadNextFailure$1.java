package cn.damai.homepage.v2.feed;

import cn.damai.common.util.ToastUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

/* compiled from: Taobao */
public final class FeedComponent$FeedLoadingListener$onLoadNextFailure$1 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final FeedComponent$FeedLoadingListener$onLoadNextFailure$1 INSTANCE = new FeedComponent$FeedLoadingListener$onLoadNextFailure$1();

    FeedComponent$FeedLoadingListener$onLoadNextFailure$1() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1420599753")) {
            ipChange.ipc$dispatch("1420599753", new Object[]{this});
            return;
        }
        ToastUtil.b("小二很忙，系统很累，稍后再试吧", 0);
    }
}
