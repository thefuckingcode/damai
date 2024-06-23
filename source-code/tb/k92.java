package tb;

import com.orhanobut.logger.LogAdapter;
import com.orhanobut.logger.LogLevel;

/* compiled from: Taobao */
public final class k92 {
    private int a = 2;
    private boolean b = true;
    private int c = 0;
    private LogAdapter d;
    private LogLevel e = LogLevel.FULL;

    public LogAdapter a() {
        if (this.d == null) {
            this.d = new e5();
        }
        return this.d;
    }

    public LogLevel b() {
        return this.e;
    }

    public int c() {
        return this.a;
    }

    public int d() {
        return this.c;
    }

    public boolean e() {
        return this.b;
    }

    public void f() {
        this.a = 2;
        this.c = 0;
        this.b = true;
        this.e = LogLevel.FULL;
    }
}
