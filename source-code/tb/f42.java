package tb;

import com.taobao.phenix.builder.Builder;
import com.taobao.rxm.schedule.Scheduler;
import com.taobao.rxm.schedule.SchedulerSupplier;

/* compiled from: Taobao */
public class f42 implements Builder<SchedulerSupplier> {
    public static final int DEFAULT_CORE_SIZE = 3;
    public static final int DEFAULT_KEEP_ALIVE = 8;
    public static final int DEFAULT_MAX_RUNNING = 6;
    public static final int DEFAULT_PATIENCE_CAPACITY = 1500;
    public static final int DEFAULT_QUEUE_CAPACITY = 5;
    public static final int INVALID_NETWORK_RUNNING_EXPIRED = -1;
    public static final int MAX_DECODE_RUNNING = 3;
    public static final int MAX_NETWORK_RUNNING_AT_FAST = 5;
    public static final int MAX_NETWORK_RUNNING_AT_SLOW = 2;
    public static final int MIN_PATIENCE_CAPACITY = 500;
    public static final int VALID_NETWORK_RUNNING_EXPIRED = 25000;
    private boolean a;
    private Scheduler b;
    private int c = 3;
    private int d = 5;
    private int e = 2;
    private int f = -1;
    private int g = 3;
    private int h = 6;
    private int i = 8;
    private int j = 5;
    private int k = 1500;
    private SchedulerSupplier l;
    private boolean m = true;

    /* renamed from: a */
    public synchronized SchedulerSupplier build() {
        if (!this.a) {
            if (this.l == null) {
                h50 h50 = new h50(this.b, this.g, this.h, this.i, this.j, this.k, this.c, this.d, this.e, this.f, this.m);
                this.l = h50;
                this.a = true;
                return h50;
            }
        }
        return this.l;
    }

    public f42 b(Scheduler scheduler) {
        cs1.e(!this.a, "SchedulerSupplier has been built, not allow central() now");
        this.b = scheduler;
        return this;
    }

    public boolean c() {
        return this.a;
    }

    public f42 d(int i2) {
        boolean z = true;
        cs1.e(!this.a, "SchedulerSupplier has been built, not allow maxDecodeRunning() now");
        if (i2 > this.h) {
            z = false;
        }
        cs1.e(z, "max decode running cannot be greater than max running");
        this.c = i2;
        return this;
    }

    public f42 e(int i2) {
        boolean z = true;
        cs1.e(!this.a, "SchedulerSupplier has been built, not allow maxNetworkRunningAtFast() now");
        if (i2 > this.h) {
            z = false;
        }
        cs1.e(z, "max network running at fast cannot be greater than max running");
        this.d = i2;
        return this;
    }

    public f42 f(int i2) {
        boolean z = true;
        cs1.e(!this.a, "SchedulerSupplier has been built, not allow maxNetworkRunningAtSlow() now");
        if (i2 > this.h) {
            z = false;
        }
        cs1.e(z, "max network running at slow cannot be greater than max running");
        this.e = i2;
        return this;
    }

    public f42 g(int i2) {
        boolean z = true;
        cs1.e(!this.a, "SchedulerSupplier has been built, not allow maxRunning() now");
        if (this.b == null) {
            if (i2 < this.g) {
                z = false;
            }
            cs1.e(z, "max running cannot be lower than core size");
        } else {
            if (i2 <= 0) {
                z = false;
            }
            cs1.e(z, "max running must be greater than zero");
        }
        this.h = i2;
        return this;
    }

    public f42 h(int i2) {
        cs1.e(!this.a, "SchedulerSupplier has been built, not allow networkRunningExpired() now");
        this.f = i2;
        return this;
    }

    public f42 i(boolean z) {
        this.m = z;
        return this;
    }

    /* renamed from: j */
    public f42 with(SchedulerSupplier schedulerSupplier) {
        cs1.e(!this.a, "SchedulerSupplier has been built, not allow with() now");
        this.l = schedulerSupplier;
        return this;
    }
}
