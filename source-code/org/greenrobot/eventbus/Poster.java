package org.greenrobot.eventbus;

/* access modifiers changed from: package-private */
public interface Poster {
    void enqueue(Subscription subscription, Object obj);
}
