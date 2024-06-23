package de.greenrobot.event;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class AsyncPoster implements Runnable {
    private final EventBus eventBus;
    private final d queue = new d();

    AsyncPoster(EventBus eventBus2) {
        this.eventBus = eventBus2;
    }

    public void enqueue(g gVar, Object obj) {
        this.queue.a(c.a(gVar, obj));
        this.eventBus.c().execute(this);
    }

    public void run() {
        c b = this.queue.b();
        if (b != null) {
            this.eventBus.e(b);
            return;
        }
        throw new IllegalStateException("No pending post available");
    }
}
