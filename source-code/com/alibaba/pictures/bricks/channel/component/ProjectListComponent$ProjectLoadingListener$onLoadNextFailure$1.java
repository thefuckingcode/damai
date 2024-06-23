package com.alibaba.pictures.bricks.channel.component;

import com.alibaba.pictures.bricks.util.toast.BricksToastUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

/* compiled from: Taobao */
public final class ProjectListComponent$ProjectLoadingListener$onLoadNextFailure$1 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final ProjectListComponent$ProjectLoadingListener$onLoadNextFailure$1 INSTANCE = new ProjectListComponent$ProjectLoadingListener$onLoadNextFailure$1();

    ProjectListComponent$ProjectLoadingListener$onLoadNextFailure$1() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1833534573")) {
            ipChange.ipc$dispatch("-1833534573", new Object[]{this});
            return;
        }
        BricksToastUtil.INSTANCE.b("小二很忙，系统很累，稍后再试吧");
    }
}
