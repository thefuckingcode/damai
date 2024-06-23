package com.youku.kubus;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

@NoProguard
/* compiled from: Taobao */
public class EventBusBuilder {
    private static final ExecutorService DEFAULT_EXECUTOR_SERVICE = ThreadPoolUtils.createThreadPool();
    boolean eventInheritance = true;
    IEventStatistic eventStatistic = null;
    ExecutorService executorService = DEFAULT_EXECUTOR_SERVICE;
    boolean ignoreGeneratedIndex;
    boolean logNoSubscriberMessages = true;
    boolean logSubscriberExceptions = true;
    boolean loggable = false;
    String name;
    boolean sendNoSubscriberEvent = true;
    boolean sendSubscriberExceptionEvent = true;
    List<Class<?>> skipMethodVerificationForClasses;
    boolean statisticSwitchOn = false;
    boolean strictMethodVerification;
    boolean throwSubscriberException = true;

    public EventBus build() {
        return new EventBus(this);
    }

    public EventBusBuilder eventInheritance(boolean z) {
        this.eventInheritance = z;
        return this;
    }

    public EventBusBuilder executorService(ExecutorService executorService2) {
        this.executorService = executorService2;
        return this;
    }

    public EventBusBuilder ignoreGeneratedIndex(boolean z) {
        this.ignoreGeneratedIndex = z;
        return this;
    }

    public EventBus installDefaultEventBus() {
        EventBus eventBus;
        synchronized (EventBus.class) {
            if (EventBus.defaultInstance == null) {
                EventBus.defaultInstance = build();
                eventBus = EventBus.defaultInstance;
            } else {
                throw new EventBusException("Default instance already exists. It may be only set once before it's used the first time to ensure consistent behavior.");
            }
        }
        return eventBus;
    }

    public EventBusBuilder keepStatisticSwitchOn(boolean z) {
        this.statisticSwitchOn = z;
        return this;
    }

    public EventBusBuilder logNoSubscriberMessages(boolean z) {
        this.logNoSubscriberMessages = z;
        return this;
    }

    public EventBusBuilder logSubscriberExceptions(boolean z) {
        this.logSubscriberExceptions = z;
        return this;
    }

    public EventBusBuilder loggable(boolean z) {
        this.loggable = z;
        return this;
    }

    public EventBusBuilder name(String str) {
        this.name = str;
        return this;
    }

    public EventBusBuilder sendNoSubscriberEvent(boolean z) {
        this.sendNoSubscriberEvent = z;
        return this;
    }

    public EventBusBuilder sendSubscriberExceptionEvent(boolean z) {
        this.sendSubscriberExceptionEvent = z;
        return this;
    }

    public EventBusBuilder setEventStatistic(IEventStatistic iEventStatistic) {
        this.eventStatistic = iEventStatistic;
        return this;
    }

    public EventBusBuilder skipMethodVerificationFor(Class<?> cls) {
        if (this.skipMethodVerificationForClasses == null) {
            this.skipMethodVerificationForClasses = new ArrayList();
        }
        this.skipMethodVerificationForClasses.add(cls);
        return this;
    }

    public EventBusBuilder strictMethodVerification(boolean z) {
        this.strictMethodVerification = z;
        return this;
    }

    public EventBusBuilder throwSubscriberException(boolean z) {
        this.throwSubscriberException = z;
        return this;
    }
}
