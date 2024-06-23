package com.youku.arch.v3.data.local;

import android.app.Application;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/youku/arch/v3/data/local/LocalDataSource;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class LocalDataSource$Companion$instance$2 extends Lambda implements Function0<LocalDataSource> {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final LocalDataSource$Companion$instance$2 INSTANCE = new LocalDataSource$Companion$instance$2();

    LocalDataSource$Companion$instance$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final LocalDataSource invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-10383295")) {
            return (LocalDataSource) ipChange.ipc$dispatch("-10383295", new Object[]{this});
        }
        Application application = AppInfoProviderProxy.getApplication();
        k21.h(application, "getApplication()");
        return new LocalDataSource(application);
    }
}
