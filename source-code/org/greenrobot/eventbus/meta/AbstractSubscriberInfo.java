package org.greenrobot.eventbus.meta;

import org.greenrobot.eventbus.EventBusException;
import org.greenrobot.eventbus.SubscriberMethod;
import org.greenrobot.eventbus.ThreadMode;

public abstract class AbstractSubscriberInfo implements SubscriberInfo {
    private final boolean shouldCheckSuperclass;
    private final Class subscriberClass;
    private final Class<? extends SubscriberInfo> superSubscriberInfoClass;

    protected AbstractSubscriberInfo(Class cls, Class<? extends SubscriberInfo> cls2, boolean z) {
        this.subscriberClass = cls;
        this.superSubscriberInfoClass = cls2;
        this.shouldCheckSuperclass = z;
    }

    @Override // org.greenrobot.eventbus.meta.SubscriberInfo
    public Class getSubscriberClass() {
        return this.subscriberClass;
    }

    @Override // org.greenrobot.eventbus.meta.SubscriberInfo
    public SubscriberInfo getSuperSubscriberInfo() {
        Class<? extends SubscriberInfo> cls = this.superSubscriberInfoClass;
        if (cls == null) {
            return null;
        }
        try {
            return (SubscriberInfo) cls.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // org.greenrobot.eventbus.meta.SubscriberInfo
    public boolean shouldCheckSuperclass() {
        return this.shouldCheckSuperclass;
    }

    /* access modifiers changed from: protected */
    public SubscriberMethod createSubscriberMethod(String str, Class<?> cls) {
        return createSubscriberMethod(str, cls, ThreadMode.POSTING, 0, false);
    }

    /* access modifiers changed from: protected */
    public SubscriberMethod createSubscriberMethod(String str, Class<?> cls, ThreadMode threadMode) {
        return createSubscriberMethod(str, cls, threadMode, 0, false);
    }

    /* access modifiers changed from: protected */
    public SubscriberMethod createSubscriberMethod(String str, Class<?> cls, ThreadMode threadMode, int i, boolean z) {
        try {
            return new SubscriberMethod(this.subscriberClass.getDeclaredMethod(str, cls), cls, threadMode, i, z);
        } catch (NoSuchMethodException e) {
            throw new EventBusException("Could not find subscriber method in " + this.subscriberClass + ". Maybe a missing ProGuard rule?", e);
        }
    }
}
