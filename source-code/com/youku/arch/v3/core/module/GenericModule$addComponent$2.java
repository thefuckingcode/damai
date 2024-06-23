package com.youku.arch.v3.core.module;

import android.taobao.windvane.connect.api.ApiResponse;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.OnChildAttachStateChangeListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u0004\u0018\u00010\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n"}, d2 = {"Lcom/youku/arch/v3/core/ModuleValue;", ApiResponse.VALUE, "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GenericModule$addComponent$2 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ IComponent<ComponentValue> $component;
    final /* synthetic */ int $index;
    final /* synthetic */ OnChildAttachStateChangeListener $listener;
    final /* synthetic */ GenericModule<VALUE> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GenericModule$addComponent$2(GenericModule<VALUE> genericModule, IComponent<ComponentValue> iComponent, OnChildAttachStateChangeListener onChildAttachStateChangeListener, int i) {
        super(0);
        this.this$0 = genericModule;
        this.$component = iComponent;
        this.$listener = onChildAttachStateChangeListener;
        this.$index = i;
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final ur2 invoke() {
        ur2 ur2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-122339193")) {
            return (ur2) ipChange.ipc$dispatch("-122339193", new Object[]{this});
        }
        GenericModule<VALUE> genericModule = this.this$0;
        List<IComponent<ComponentValue>> list = genericModule.components;
        int i = this.$index;
        IComponent<ComponentValue> iComponent = this.$component;
        synchronized (list) {
            genericModule.components.add(i, iComponent);
            genericModule.components.get(i).setModule(genericModule);
            genericModule.components.get(i).getModule().setPageContext(iComponent.getPageContext());
            ur2 = ur2.INSTANCE;
        }
        GenericModule.access$getChildIndexUpdater$p(this.this$0).onChildAdded(this.$component);
        this.this$0.getChildState().setChanged();
        this.$component.onAdd();
        OnChildAttachStateChangeListener onChildAttachStateChangeListener = this.$listener;
        if (onChildAttachStateChangeListener == null) {
            return null;
        }
        onChildAttachStateChangeListener.onChildAdded(this.$component);
        return ur2;
    }
}
