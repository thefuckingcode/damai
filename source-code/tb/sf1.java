package tb;

import com.taobao.network.lifecycle.IMtopLifecycle;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: Taobao */
public class sf1 implements IMtopLifecycle {
    private IMtopLifecycle a;
    private Lock b;
    private Lock c;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class b {
        private static final sf1 a = new sf1();
    }

    public static sf1 a() {
        return b.a;
    }

    public void b(IMtopLifecycle iMtopLifecycle) {
        this.c.lock();
        try {
            this.a = null;
        } finally {
            this.c.unlock();
        }
    }

    public void c(IMtopLifecycle iMtopLifecycle) {
        this.c.lock();
        try {
            if (this.a == null) {
                this.a = iMtopLifecycle;
            }
        } finally {
            this.c.unlock();
        }
    }

    @Override // com.taobao.network.lifecycle.IMtopLifecycle
    public void onMtopCancel(String str, Map<String, Object> map) {
        this.b.lock();
        try {
            IMtopLifecycle iMtopLifecycle = this.a;
            if (iMtopLifecycle != null) {
                iMtopLifecycle.onMtopCancel(str, map);
            }
        } finally {
            this.b.unlock();
        }
    }

    @Override // com.taobao.network.lifecycle.IMtopLifecycle
    public void onMtopError(String str, Map<String, Object> map) {
        this.b.lock();
        try {
            IMtopLifecycle iMtopLifecycle = this.a;
            if (iMtopLifecycle != null) {
                iMtopLifecycle.onMtopError(str, map);
            }
        } finally {
            this.b.unlock();
        }
    }

    @Override // com.taobao.network.lifecycle.IMtopLifecycle
    public void onMtopEvent(String str, String str2, Map<String, Object> map) {
        this.b.lock();
        try {
            IMtopLifecycle iMtopLifecycle = this.a;
            if (iMtopLifecycle != null) {
                iMtopLifecycle.onMtopEvent(str, str2, map);
            }
        } finally {
            this.b.unlock();
        }
    }

    @Override // com.taobao.network.lifecycle.IMtopLifecycle
    public void onMtopFinished(String str, Map<String, Object> map) {
        this.b.lock();
        try {
            IMtopLifecycle iMtopLifecycle = this.a;
            if (iMtopLifecycle != null) {
                iMtopLifecycle.onMtopFinished(str, map);
            }
        } finally {
            this.b.unlock();
        }
    }

    @Override // com.taobao.network.lifecycle.IMtopLifecycle
    public void onMtopRequest(String str, String str2, Map<String, Object> map) {
        this.b.lock();
        try {
            IMtopLifecycle iMtopLifecycle = this.a;
            if (iMtopLifecycle != null) {
                iMtopLifecycle.onMtopRequest(str, str2, map);
            }
        } finally {
            this.b.unlock();
        }
    }

    private sf1() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.b = reentrantReadWriteLock.readLock();
        this.c = reentrantReadWriteLock.writeLock();
    }
}
