package me.ele.altriax.launcher.biz.impl;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import me.ele.altriax.launcher.biz.bridge.DelegateRuntime;
import me.ele.altriax.launcher.biz.bridge.delegate.DMInitUTDelegate;
import me.ele.altriax.launcher.biz.impl.base.DMDelegateTask;

/* compiled from: Taobao */
public class DMInitUTTask extends DMDelegateTask<DMInitUTDelegate> {
    @Override // me.ele.altriax.launcher.biz.impl.base.DelegateTask
    @Nullable
    public DMInitUTDelegate getDelegate(@NonNull Application application) {
        return DelegateRuntime.sDMInitUTDelegate;
    }
}
