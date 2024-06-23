package com.youku.arch.v3.core;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IContainer;
import com.youku.arch.v3.event.EventHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n"}, d2 = {"Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class EventDispatcher$getTargets$2 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ List<Coordinate> $coordinates;
    final /* synthetic */ IContainer<ModelValue> $pageContainer;
    final /* synthetic */ ArrayList<EventHandler> $targets;
    final /* synthetic */ EventDispatcher this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EventDispatcher$getTargets$2(List<Coordinate> list, ArrayList<EventHandler> arrayList, EventDispatcher eventDispatcher, IContainer<ModelValue> iContainer) {
        super(0);
        this.$coordinates = list;
        this.$targets = arrayList;
        this.this$0 = eventDispatcher;
        this.$pageContainer = iContainer;
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final ur2 invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1190742020")) {
            return (ur2) ipChange.ipc$dispatch("1190742020", new Object[]{this});
        }
        List<Coordinate> list = this.$coordinates;
        if (list == null) {
            return null;
        }
        ArrayList<EventHandler> arrayList = this.$targets;
        EventDispatcher eventDispatcher = this.this$0;
        IContainer<ModelValue> iContainer = this.$pageContainer;
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(eventDispatcher.getEventHandler(iContainer, it.next()));
        }
        return ur2.INSTANCE;
    }
}
