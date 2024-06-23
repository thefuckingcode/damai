package com.youku.kubus;

import tb.jl1;

@NoProguard
/* compiled from: Taobao */
public final class SubscriberExceptionEvent extends Event {
    public final Event causingEvent;
    public final Object causingSubscriber;
    public final EventBus eventBus;
    public final Throwable throwable;

    public SubscriberExceptionEvent(EventBus eventBus2, Throwable th, Event event, Object obj) {
        super("no_subscriber", "NoSubscriberEvent id [" + event.id + "] type [" + event.type + jl1.ARRAY_END_STR);
        this.eventBus = eventBus2;
        this.throwable = th;
        this.causingEvent = event;
        this.causingSubscriber = obj;
    }
}
