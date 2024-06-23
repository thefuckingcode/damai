package tb;

import android.database.Cursor;
import cn.damai.common.db.ex.DbException;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public final class g82<T> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final si2<T> a;
    private nz2 b;
    private List<a> c;
    private int d = 0;
    private int e = 0;

    /* compiled from: Taobao */
    public static class a {
        private static transient /* synthetic */ IpChange $ipChange;
        private String a;
        private boolean b;

        public a(String str) {
            this.a = str;
        }

        public String toString() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "334735790")) {
                return (String) ipChange.ipc$dispatch("334735790", new Object[]{this});
            }
            StringBuilder sb = new StringBuilder();
            sb.append("\"");
            sb.append(this.a);
            sb.append("\"");
            sb.append(this.b ? " DESC" : " ASC");
            return sb.toString();
        }
    }

    private g82(si2<T> si2) {
        this.a = si2;
    }

    static <T> g82<T> e(si2<T> si2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1353045590")) {
            return new g82<>(si2);
        }
        return (g82) ipChange.ipc$dispatch("1353045590", new Object[]{si2});
    }

    public g82<T> a(String str, String str2, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1827511")) {
            return (g82) ipChange.ipc$dispatch("1827511", new Object[]{this, str, str2, obj});
        }
        this.b.a(str, str2, obj);
        return this;
    }

    public long b() throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-378641646")) {
            return ((Long) ipChange.ipc$dispatch("-378641646", new Object[]{this})).longValue();
        } else if (!this.a.j()) {
            return 0;
        } else {
            k30 a2 = n("count(\"" + this.a.e().d() + "\") as count").a();
            if (a2 != null) {
                return a2.b(AdUtConstants.XAD_UT_ARG_COUNT);
            }
            return 0;
        }
    }

    public List<T> c() throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1469090494")) {
            return (List) ipChange.ipc$dispatch("-1469090494", new Object[]{this});
        }
        ArrayList arrayList = null;
        if (!this.a.j()) {
            return null;
        }
        Cursor execQuery = this.a.c().execQuery(toString());
        if (execQuery != null) {
            try {
                arrayList = new ArrayList();
                while (execQuery.moveToNext()) {
                    arrayList.add(np.b(this.a, execQuery));
                }
                iz0.a(execQuery);
            } catch (Throwable th) {
                iz0.a(execQuery);
                throw th;
            }
        }
        return arrayList;
    }

    public T d() throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1826349884")) {
            return (T) ipChange.ipc$dispatch("1826349884", new Object[]{this});
        } else if (!this.a.j()) {
            return null;
        } else {
            k(1);
            Cursor execQuery = this.a.c().execQuery(toString());
            if (execQuery != null) {
                try {
                    if (execQuery.moveToNext()) {
                        T t = (T) np.b(this.a, execQuery);
                        iz0.a(execQuery);
                        return t;
                    }
                    iz0.a(execQuery);
                } catch (Throwable th) {
                    iz0.a(execQuery);
                    throw th;
                }
            }
            return null;
        }
    }

    public int f() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1087787307")) {
            return this.d;
        }
        return ((Integer) ipChange.ipc$dispatch("1087787307", new Object[]{this})).intValue();
    }

    public int g() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-47081897")) {
            return this.e;
        }
        return ((Integer) ipChange.ipc$dispatch("-47081897", new Object[]{this})).intValue();
    }

    public List<a> h() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-142984873")) {
            return this.c;
        }
        return (List) ipChange.ipc$dispatch("-142984873", new Object[]{this});
    }

    public si2<T> i() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "150142991")) {
            return this.a;
        }
        return (si2) ipChange.ipc$dispatch("150142991", new Object[]{this});
    }

    public nz2 j() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "355641798")) {
            return this.b;
        }
        return (nz2) ipChange.ipc$dispatch("355641798", new Object[]{this});
    }

    public g82<T> k(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1685049396")) {
            return (g82) ipChange.ipc$dispatch("-1685049396", new Object[]{this, Integer.valueOf(i)});
        }
        this.d = i;
        return this;
    }

    public g82<T> l(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-488997692")) {
            return (g82) ipChange.ipc$dispatch("-488997692", new Object[]{this, Integer.valueOf(i)});
        }
        this.e = i;
        return this;
    }

    public g82<T> m(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "770309643")) {
            return (g82) ipChange.ipc$dispatch("770309643", new Object[]{this, str});
        }
        if (this.c == null) {
            this.c = new ArrayList(5);
        }
        this.c.add(new a(str));
        return this;
    }

    public l30 n(String... strArr) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-102045138")) {
            return new l30(this, strArr);
        }
        return (l30) ipChange.ipc$dispatch("-102045138", new Object[]{this, strArr});
    }

    public g82<T> o(String str, String str2, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "449223623")) {
            return (g82) ipChange.ipc$dispatch("449223623", new Object[]{this, str, str2, obj});
        }
        this.b = nz2.c(str, str2, obj);
        return this;
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-905354929")) {
            return (String) ipChange.ipc$dispatch("-905354929", new Object[]{this});
        }
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(jl1.MUL);
        sb.append(" FROM ");
        sb.append("\"");
        sb.append(this.a.f());
        sb.append("\"");
        nz2 nz2 = this.b;
        if (nz2 != null && nz2.d() > 0) {
            sb.append(" WHERE ");
            sb.append(this.b.toString());
        }
        List<a> list = this.c;
        if (list != null && list.size() > 0) {
            sb.append(" ORDER BY ");
            for (a aVar : this.c) {
                sb.append(aVar.toString());
                sb.append(',');
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        if (this.d > 0) {
            sb.append(" LIMIT ");
            sb.append(this.d);
            sb.append(" OFFSET ");
            sb.append(this.e);
        }
        return sb.toString();
    }
}
