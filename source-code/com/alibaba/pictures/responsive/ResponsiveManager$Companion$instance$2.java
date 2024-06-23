package com.alibaba.pictures.responsive;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/alibaba/pictures/responsive/ResponsiveManager;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class ResponsiveManager$Companion$instance$2 extends Lambda implements Function0<ResponsiveManager> {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final ResponsiveManager$Companion$instance$2 INSTANCE = new ResponsiveManager$Companion$instance$2();

    ResponsiveManager$Companion$instance$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final ResponsiveManager invoke() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "981764511")) {
            return new ResponsiveManager();
        }
        return (ResponsiveManager) ipChange.ipc$dispatch("981764511", new Object[]{this});
    }
}
