package androidx.room;

/* compiled from: Taobao */
public final /* synthetic */ class q implements Runnable {
    public final /* synthetic */ InvalidationTracker a;

    public /* synthetic */ q(InvalidationTracker invalidationTracker) {
        this.a = invalidationTracker;
    }

    public final void run() {
        this.a.onAutoCloseCallback();
    }
}
