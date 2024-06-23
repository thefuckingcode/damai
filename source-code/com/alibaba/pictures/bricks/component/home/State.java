package com.alibaba.pictures.bricks.component.home;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.m40;

/* compiled from: Taobao */
public enum State {
    NONE,
    INIT,
    LOTTIE_SUCCESS,
    PIC_SUCCESS,
    INVALID;
    
    @NotNull
    public static final a Companion = new a(null);

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        public final boolean a(@Nullable State state) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1597417240")) {
                return State.LOTTIE_SUCCESS == state || State.PIC_SUCCESS == state;
            }
            return ((Boolean) ipChange.ipc$dispatch("1597417240", new Object[]{this, state})).booleanValue();
        }
    }
}
