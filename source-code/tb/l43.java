package tb;

import com.loc.dl;
import com.loc.dr;
import com.loc.ds;
import com.loc.dt;
import com.loc.du;
import com.loc.dv;
import com.loc.y0;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public final class l43 {

    /* compiled from: Taobao */
    public static class a implements dl {
        private int a;
        private int b;
        private int c;

        a(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        @Override // com.loc.dl
        public final long a() {
            return l43.a(this.a, this.b);
        }

        @Override // com.loc.dl
        public final int b() {
            return this.c;
        }
    }

    /* compiled from: Taobao */
    public static class b implements dl {
        private long a;
        private int b;

        b(long j, int i) {
            this.a = j;
            this.b = i;
        }

        @Override // com.loc.dl
        public final long a() {
            return this.a;
        }

        @Override // com.loc.dl
        public final int b() {
            return this.b;
        }
    }

    public static long a(int i, int i2) {
        return (((long) i2) & 4294967295L) | ((((long) i) & 4294967295L) << 32);
    }

    public static synchronized short b(long j) {
        short b2;
        synchronized (l43.class) {
            b2 = k43.a().b(j);
        }
        return b2;
    }

    public static synchronized void c(List<dr> list) {
        a aVar;
        synchronized (l43.class) {
            if (list != null) {
                if (!list.isEmpty()) {
                    ArrayList arrayList = new ArrayList(list.size());
                    for (dr drVar : list) {
                        if (drVar instanceof dt) {
                            dt dtVar = (dt) drVar;
                            aVar = new a(dtVar.j, dtVar.k, dtVar.c);
                        } else if (drVar instanceof du) {
                            du duVar = (du) drVar;
                            aVar = new a(duVar.j, duVar.k, duVar.c);
                        } else if (drVar instanceof dv) {
                            dv dvVar = (dv) drVar;
                            aVar = new a(dvVar.j, dvVar.k, dvVar.c);
                        } else if (drVar instanceof ds) {
                            ds dsVar = (ds) drVar;
                            aVar = new a(dsVar.k, dsVar.l, dsVar.c);
                        }
                        arrayList.add(aVar);
                    }
                    k43.a().d(arrayList);
                }
            }
        }
    }

    public static synchronized short d(long j) {
        short g;
        synchronized (l43.class) {
            g = k43.a().g(j);
        }
        return g;
    }

    public static synchronized void e(List<y0> list) {
        synchronized (l43.class) {
            if (list != null) {
                if (!list.isEmpty()) {
                    ArrayList arrayList = new ArrayList(list.size());
                    for (y0 y0Var : list) {
                        arrayList.add(new b(y0Var.a, y0Var.c));
                    }
                    k43.a().h(arrayList);
                }
            }
        }
    }
}
