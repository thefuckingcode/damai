package android.taobao.windvane.thread;

/* compiled from: Taobao */
public class LockObject {
    private boolean needwait = true;
    public int result = 0;

    public synchronized void lnotify() {
        if (this.needwait) {
            this.needwait = false;
            notify();
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:1:0x0001 */
    /* JADX WARNING: Removed duplicated region for block: B:1:0x0001 A[LOOP:0: B:1:0x0001->B:11:0x0001, LOOP_START, SYNTHETIC] */
    public synchronized void lwait() {
        while (this.needwait) {
            wait();
        }
    }
}
