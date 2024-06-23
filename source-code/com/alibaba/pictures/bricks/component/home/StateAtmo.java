package com.alibaba.pictures.bricks.component.home;

import com.alibaba.pictures.bricks.bean.HeadAtmosphereBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class StateAtmo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private final State state;

    public StateAtmo(@Nullable State state2, @Nullable HeadAtmosphereBean headAtmosphereBean) {
        this.state = state2;
    }

    @Nullable
    public final State getState() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-159557464")) {
            return this.state;
        }
        return (State) ipChange.ipc$dispatch("-159557464", new Object[]{this});
    }
}
