package cn.damai.launcher;

import cn.damai.wantsee.StartConfig;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class PrivacyDoubleListDelegate$isOpen$2 extends Lambda implements Function0<Boolean> {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final PrivacyDoubleListDelegate$isOpen$2 INSTANCE = new PrivacyDoubleListDelegate$isOpen$2();

    PrivacyDoubleListDelegate$isOpen$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Boolean invoke() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "182074424")) {
            return Boolean.valueOf(StartConfig.isOrangeOpenPrivacyDoubleListInit());
        }
        return (Boolean) ipChange.ipc$dispatch("182074424", new Object[]{this});
    }
}
