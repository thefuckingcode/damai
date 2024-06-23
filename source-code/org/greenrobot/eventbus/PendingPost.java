package org.greenrobot.eventbus;

import java.util.ArrayList;
import java.util.List;

/* access modifiers changed from: package-private */
public final class PendingPost {
    private static final List<PendingPost> pendingPostPool = new ArrayList();
    Object event;
    PendingPost next;
    Subscription subscription;

    private PendingPost(Object obj, Subscription subscription2) {
        this.event = obj;
        this.subscription = subscription2;
    }

    static PendingPost obtainPendingPost(Subscription subscription2, Object obj) {
        List<PendingPost> list = pendingPostPool;
        synchronized (list) {
            int size = list.size();
            if (size <= 0) {
                return new PendingPost(obj, subscription2);
            }
            PendingPost remove = list.remove(size - 1);
            remove.event = obj;
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
