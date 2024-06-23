package com.youku.arch.v3.core;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.event.EventHandler;
import com.youku.kubus.Event;
import com.youku.kubus.EventBus;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016¨\u0006\t"}, d2 = {"com/youku/arch/v3/core/PageContainer$onMessage$1", "Lcom/youku/arch/v3/event/EventHandler;", "", "type", "", "", "params", "", "onMessage", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class PageContainer$onMessage$1 implements EventHandler {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ PageContainer<VALUE> this$0;

    PageContainer$onMessage$1(PageContainer<VALUE> pageContainer) {
        this.this$0 = pageContainer;
    }

    @Override // com.youku.arch.v3.event.EventHandler
    public boolean onMessage(@NotNull String str, @Nullable Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2024089902")) {
            return ((Boolean) ipChange.ipc$dispatch("-2024089902", new Object[]{this, str, map})).booleanValue();
        }
        k21.i(str, "type");
        Event event = new Event(str);
        event.data = map;
        EventBus eventBus = this.this$0.getPageContext().getEventBus();
        if (eventBus != null) {
            eventBus.post(event);
        }
        return true;
    }
}
