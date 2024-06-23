package com.youku.kubus;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class AsyncPoster implements Runnable {
    private final EventBus eventBus;
    private final PendingPostQueue queue = new PendingPostQueue();

    AsyncPoster(EventBus eventBus2) {
        this.eventBus = eventBus2;
    }

    public void enqueue(Subscription subscription, Event event) {
        this.queue.enqueue(PendingPost.obtainPendingPost(subscription, event));
        this.eventBus.getExecutorService().execute(this);
    }

    public void run() {
        PendingPost poll = this.queue.poll();
        if (poll != null) {
            this.eventBus.invokeSubscriber(poll);
            return;
        }
        throw new IllegalStateException("No pending post available");
    }
}
