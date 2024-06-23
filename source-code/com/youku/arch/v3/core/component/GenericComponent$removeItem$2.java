package com.youku.arch.v3.core.component;

import android.taobao.windvane.connect.api.ApiResponse;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.OnChildAttachStateChangeListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u0004\u0018\u00010\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n"}, d2 = {"Lcom/youku/arch/v3/core/ComponentValue;", ApiResponse.VALUE, "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GenericComponent$removeItem$2 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ IItem<ItemValue> $item;
    final /* synthetic */ OnChildAttachStateChangeListener $listener;
    final /* synthetic */ GenericComponent<VALUE> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GenericComponent$removeItem$2(GenericComponent<VALUE> genericComponent, IItem<ItemValue> iItem, OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        super(0);
        this.this$0 = genericComponent;
        this.$item = iItem;
        this.$listener = onChildAttachStateChangeListener;
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final ur2 invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1369387670")) {
            return (ur2) ipChange.ipc$dispatch("-1369387670", new Object[]{this});
        }
        this.this$0.childItems.remove(this.$item);
        this.$item.onRemove();
        this.this$0.getChildIndexUpdater().onChildRemoved(this.$item);
        OnChildAttachStateChangeListener onChildAttachStateChangeListener = this.$listener;
        if (onChildAttachStateChangeListener == null) {
            return null;
        }
        onChildAttachStateChangeListener.onChildRemoved(this.$item);
        return ur2.INSTANCE;
    }
}
