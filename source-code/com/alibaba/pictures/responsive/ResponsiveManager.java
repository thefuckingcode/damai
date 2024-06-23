package com.alibaba.pictures.responsive;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.m40;

/* compiled from: Taobao */
public final class ResponsiveManager {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private static final Lazy<ResponsiveManager> b = b.a(LazyThreadSafetyMode.SYNCHRONIZED, ResponsiveManager$Companion$instance$2.INSTANCE);
    @Nullable
    private IConfig a;

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final ResponsiveManager a() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1950756675")) {
                return (ResponsiveManager) ResponsiveManager.b.getValue();
            }
            return (ResponsiveManager) ipChange.ipc$dispatch("-1950756675", new Object[]{this});
        }
    }

    @Nullable
    public final IConfig b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1605571974")) {
            return this.a;
        }
        return (IConfig) ipChange.ipc$dispatch("1605571974", new Object[]{this});
    }
}
