package tb;

import android.database.Cursor;
import android.text.TextUtils;
import cn.damai.common.db.ex.DbException;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.g82;

/* compiled from: Taobao */
public final class l30 {
    private static transient /* synthetic */ IpChange $ipChange;
    private String[] a;
    private String b;
    private nz2 c;
    private g82<?> d;

    protected l30(g82<?> g82, String[] strArr) {
        this.d = g82;
        this.a = strArr;
    }

    public k30 a() throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-901127995")) {
            return (k30) ipChange.ipc$dispatch("-901127995", new Object[]{this});
        }
        si2<?> i = this.d.i();
        if (!i.j()) {
            return null;
        }
        b(1);
        Cursor execQuery = i.c().execQuery(toString());
        if (execQuery != null) {
            try {
                if (execQuery.moveToNext()) {
                    k30 a2 = np.a(execQuery);
                    iz0.a(execQuery);
                    return a2;
                }
                iz0.a(execQuery);
            } catch (Throwable th) {
                iz0.a(execQuery);
                throw th;
            }
        }
        return null;
    }

    public l30 b(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1722956994")) {
            return (l30) ipChange.ipc$dispatch("1722956994", new Object[]{this, Integer.valueOf(i)});
        }
        this.d.k(i);
        return this;
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-142785586")) {
            return (String) ipChange.ipc$dispatch("-142785586", new Object[]{this});
        }
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        String[] strArr = this.a;
        if (strArr != null && strArr.length > 0) {
            for (String str : strArr) {
                sb.append(str);
                sb.append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
        } else if (!TextUtils.isEmpty(this.b)) {
            sb.append(this.b);
        } else {
            sb.append(jl1.MUL);
        }
        sb.append(" FROM ");
        sb.append("\"");
        sb.append(this.d.i().f());
        sb.append("\"");
        nz2 j = this.d.j();
        if (j != null && j.d() > 0) {
            sb.append(" WHERE ");
            sb.append(j.toString());
        }
        if (!TextUtils.isEmpty(this.b)) {
            sb.append(" GROUP BY ");
            sb.append("\"");
            sb.append(this.b);
            sb.append("\"");
            nz2 nz2 = this.c;
            if (nz2 != null && nz2.d() > 0) {
                sb.append(" HAVING ");
                sb.append(this.c.toString());
            }
        }
        List<g82.a> h = this.d.h();
        if (h != null && h.size() > 0) {
            for (int i = 0; i < h.size(); i++) {
                sb.append(" ORDER BY ");
                sb.append(h.get(i).toString());
                sb.append(',');
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        if (this.d.f() > 0) {
            sb.append(" LIMIT ");
            sb.append(this.d.f());
            sb.append(" OFFSET ");
            sb.append(this.d.g());
        }
        return sb.toString();
    }
}
