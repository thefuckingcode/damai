package tb;

/* compiled from: Taobao */
public class u4 {
    public static void a() {
        b(null, null, null, null, null);
    }

    public static void b(Integer num, Integer num2, Integer num3, Integer num4, Integer num5) {
        w4 w4Var = new w4();
        w4Var.b();
        try {
            w80 c = tp1.o().diskCacheBuilder().with(w4Var);
            if (num != null) {
                c.b(17, num.intValue());
            }
            if (num2 != null) {
                c.b(34, num2.intValue());
            }
            if (num3 != null) {
                c.b(51, num3.intValue());
            }
            if (num4 != null) {
                c.b(68, num4.intValue());
            }
            if (num5 != null) {
                c.b(85, num5.intValue());
            }
            vr2.f("Alivfs4Phenix", "disk cache setup, top1=%s top2=%s top3=%s top4=%s top5=%s", num, num2, num3, num4, num5);
        } catch (RuntimeException e) {
            vr2.c("Alivfs4Phenix", "disk cache setup error=%s", e);
        }
    }
}
