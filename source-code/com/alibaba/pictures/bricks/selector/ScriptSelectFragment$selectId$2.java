package com.alibaba.pictures.bricks.selector;

import android.os.Bundle;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class ScriptSelectFragment$selectId$2 extends Lambda implements Function0<String> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ ScriptSelectFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScriptSelectFragment$selectId$2(ScriptSelectFragment scriptSelectFragment) {
        super(0);
        this.this$0 = scriptSelectFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final String invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-258212963")) {
            return (String) ipChange.ipc$dispatch("-258212963", new Object[]{this});
        }
        Bundle arguments = this.this$0.getArguments();
        if (arguments != null) {
            return arguments.getString(ScriptSelectFragment.EXTRA_KEY_SELECT_ID);
        }
        return null;
    }
}
