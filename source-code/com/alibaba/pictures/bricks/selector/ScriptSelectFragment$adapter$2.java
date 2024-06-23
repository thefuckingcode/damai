package com.alibaba.pictures.bricks.selector;

import com.alibaba.pictures.bricks.selector.adapter.ScriptSelectAdapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class ScriptSelectFragment$adapter$2 extends Lambda implements Function0<ScriptSelectAdapter> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ ScriptSelectFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScriptSelectFragment$adapter$2(ScriptSelectFragment scriptSelectFragment) {
        super(0);
        this.this$0 = scriptSelectFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final ScriptSelectAdapter invoke() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2029946600")) {
            return new ScriptSelectAdapter(this.this$0.pageType, this.this$0);
        }
        return (ScriptSelectAdapter) ipChange.ipc$dispatch("2029946600", new Object[]{this});
    }
}
