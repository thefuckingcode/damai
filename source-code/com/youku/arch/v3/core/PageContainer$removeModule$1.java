package com.youku.arch.v3.core;

import android.taobao.windvane.connect.api.ApiResponse;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IModule;
import com.youku.arch.v3.util.LogUtil;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u0004\u0018\u00010\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n"}, d2 = {"Lcom/youku/arch/v3/core/ModelValue;", ApiResponse.VALUE, "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class PageContainer$removeModule$1 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ OnChildAttachStateChangeListener $listener;
    final /* synthetic */ IModule<ModuleValue> $module;
    final /* synthetic */ PageContainer<VALUE> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PageContainer$removeModule$1(PageContainer<VALUE> pageContainer, IModule<ModuleValue> iModule, OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        super(0);
        this.this$0 = pageContainer;
        this.$module = iModule;
        this.$listener = onChildAttachStateChangeListener;
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final ur2 invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1618978410")) {
            return (ur2) ipChange.ipc$dispatch("-1618978410", new Object[]{this});
        }
        this.this$0.childState.setChanged();
        this.this$0.modules.remove(this.$module);
        if (AppInfoProviderProxy.isDebuggable()) {
            LogUtil.v("OneArch.PageContainer", "removeModule index is " + this.$module.getIndex() + ", adapter size " + this.this$0.adapters.size() + ", module size " + this.this$0.modules.size());
        }
        this.$module.onRemove();
        this.this$0.childIndexUpdater.onChildRemoved(this.$module);
        OnChildAttachStateChangeListener onChildAttachStateChangeListener = this.$listener;
        if (onChildAttachStateChangeListener == null) {
            return null;
        }
        onChildAttachStateChangeListener.onChildRemoved(this.$module);
        return ur2.INSTANCE;
    }
}
