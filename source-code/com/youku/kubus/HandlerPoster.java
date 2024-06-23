package com.youku.kubus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class HandlerPoster extends Handler {
    private final EventBus eventBus;
    private boolean handlerActive;
    private final int maxMillisInsideHandleMessage;
    private final PendingPostQueue queue = new PendingPostQueue();

    HandlerPoster(EventBus eventBus2, Looper looper, int i) {
        super(looper);
        this.eventBus = eventBus2;
        this.maxMillisInsideHandleMessage = i;
    }

    /* access modifiers changed from: package-private */
    public void enqueue(Subscription subscription, Event event) {
        PendingPost obtainPendingPost = PendingPost.obtainPendingPost(subscription, event);
        synchronized (this) {
            this.queue.enqueue(obtainPendingPost);
            if (!this.handlerActive) {
                this.handlerActive = true;
                if (!sendMessage(obtainMessage())) {
                    throw new EventBusException("Could not send handler message");
                }
            }
        }
    }

    public void handleMessage(Message message) {
        boolean z = false;
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                PendingPost poll = this.queue.poll();
                if (poll == null) {
                    synchronized (this) {
                        poll = this.queue.poll();
                        if (poll == null) {
                            this.handlerActive = z;
                            this.handlerActive = z;
                            return;
                        }
                    }
                }
                this.eventBus.invokeSubscriber(poll);
            } while (SystemClock.uptimeMillis() - uptimeMillis < ((long) this.maxMillisInsideHandleMessage));
            if (sendMessage(obtainMessage())) {
                z = true;
                return;
            }
            throw new EventBusException("Could not send handler message");
        } finally {
            this.handlerActive = z;
        }
    }
}
