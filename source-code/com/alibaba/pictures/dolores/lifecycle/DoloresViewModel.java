package com.alibaba.pictures.dolores.lifecycle;

import androidx.lifecycle.ViewModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.wa0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016R$\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/alibaba/pictures/dolores/lifecycle/DoloresViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/alibaba/pictures/dolores/lifecycle/DoloresClearStoreProvider;", "Ltb/ur2;", "onCleared", "Ltb/wa0;", "getDoloresClearStore", "close", "clearStore", "Ltb/wa0;", "getClearStore", "()Ltb/wa0;", "setClearStore", "(Ltb/wa0;)V", "<init>", "()V", "dolores_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class DoloresViewModel extends ViewModel implements DoloresClearStoreProvider {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private wa0 clearStore;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1944253608")) {
            ipChange.ipc$dispatch("1944253608", new Object[]{this});
            return;
        }
        wa0 wa0 = this.clearStore;
        if (wa0 != null) {
            wa0.b();
        }
    }

    @Nullable
    public final wa0 getClearStore() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "38664260")) {
            return this.clearStore;
        }
        return (wa0) ipChange.ipc$dispatch("38664260", new Object[]{this});
    }

    @Override // com.alibaba.pictures.dolores.lifecycle.DoloresClearStoreProvider
    @NotNull
    public wa0 getDoloresClearStore() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1136548160")) {
            return (wa0) ipChange.ipc$dispatch("-1136548160", new Object[]{this});
        }
        if (this.clearStore == null) {
            this.clearStore = new wa0();
        }
        wa0 wa0 = this.clearStore;
        k21.f(wa0);
        return wa0;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-352488397")) {
            ipChange.ipc$dispatch("-352488397", new Object[]{this});
            return;
        }
        close();
    }

    public final void setClearStore(@Nullable wa0 wa0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1706774834")) {
            ipChange.ipc$dispatch("-1706774834", new Object[]{this, wa0});
            return;
        }
        this.clearStore = wa0;
    }
}
