package tb;

/* compiled from: Taobao */
public abstract class l13 {
    private m13 a;

    public abstract m13 a();

    public final void b(g23 g23) {
        try {
            if (this.a == null) {
                synchronized (this) {
                    if (this.a == null) {
                        m13 a2 = a();
                        this.a = a2;
                        if (a2 == null) {
                            return;
                        }
                    }
                }
            }
            this.a.a(g23);
        } catch (Throwable th) {
            t43.c("efs.processor", "log handle error", th);
        }
    }
}
