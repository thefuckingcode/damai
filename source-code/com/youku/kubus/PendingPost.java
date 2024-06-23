package com.youku.kubus;

import java.util.ArrayList;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class PendingPost {
    private static final List<PendingPost> pendingPostPool = new ArrayList();
    Event event;
    PendingPost next;
    Subscription subscription;

    private PendingPost(Event event2, Subscription subscription2) {
        this.event = event2;
        this.subscription = subscription2;
    }

    static PendingPost obtainPendingPost(Subscription subscription2, Event event2) {
        List<PendingPost> list = pendingPostPool;
        synchronized (list) {
            int size = list.size();
            if (size <= 0) {
                return new PendingPost(event2, subscription2);
            }
            PendingPost remove = list.remove(size - 1);
            remove.event = event2;
            remove.subscription = subscription2;
            remove.next = null;
            return remove;
        }
    }

    static void releasePendingPost(PendingPost pendingPost) {
        pendingPost.event = null;
        pendingPost.subscription = null;
        pendingPost.next = null;
        List<PendingPost> list = pendingPostPool;
        synchronized (list) {
            if (list.size() < 10000) {
                list.add(pendingPost);
            }
        }
    }
}
