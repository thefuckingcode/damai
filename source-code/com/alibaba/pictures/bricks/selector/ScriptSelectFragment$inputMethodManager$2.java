package com.alibaba.pictures.bricks.selector;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class ScriptSelectFragment$inputMethodManager$2 extends Lambda implements Function0<InputMethodManager> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ ScriptSelectFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScriptSelectFragment$inputMethodManager$2(ScriptSelectFragment scriptSelectFragment) {
        super(0);
        this.this$0 = scriptSelectFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final InputMethodManager invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2098987087")) {
            return (InputMethodManager) ipChange.ipc$dispatch("2098987087", new Object[]{this});
        }
        Context context = this.this$0.getContext();
        Object systemService = context != null ? context.getSystemService("input_method") : null;
        if (systemService instanceof InputMethodManager) {
            return (InputMethodManager) systemService;
        }
        return null;
    }
}
