package cn.damai.common.db.db.sqlite;

import cn.damai.common.db.commonutil.util.KeyValue;
import cn.damai.common.db.ex.DbException;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import tb.a61;
import tb.ak;
import tb.jl1;
import tb.nz2;
import tb.qd2;
import tb.si2;

/* compiled from: Taobao */
public final class a {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final ConcurrentHashMap<si2<?>, String> a = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<si2<?>, String> b = new ConcurrentHashMap<>();

    public static qd2 a(si2<?> si2) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-974369115")) {
            return (qd2) ipChange.ipc$dispatch("-974369115", new Object[]{si2});
        }
        ak e = si2.e();
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append("\"");
        sb.append(si2.f());
        sb.append("\"");
        sb.append(" ( ");
        if (e.f()) {
            sb.append("\"");
            sb.append(e.d());
            sb.append("\"");
            sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
        } else {
            sb.append("\"");
            sb.append(e.d());
            sb.append("\"");
            sb.append(e.a());
            sb.append(" PRIMARY KEY, ");
        }
        for (ak akVar : si2.b().values()) {
            if (!akVar.g()) {
                sb.append("\"");
                sb.append(akVar.d());
                sb.append("\"");
                sb.append(' ');
                sb.append(akVar.a());
                sb.append(' ');
                sb.append(akVar.e());
                sb.append(',');
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(" )");
        return new qd2(sb.toString());
    }

    public static qd2 b(si2<?> si2, Object obj) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1060132672")) {
            return (qd2) ipChange.ipc$dispatch("1060132672", new Object[]{si2, obj});
        }
        qd2 qd2 = new qd2();
        ak e = si2.e();
        Object b2 = e.b(obj);
        if (b2 != null) {
            qd2.f("DELETE FROM " + "\"" + si2.f() + "\"" + " WHERE " + nz2.c(e.d(), "=", b2));
            return qd2;
        }
        throw new DbException("this entity[" + si2.d() + "]'s id value is null");
    }

    public static qd2 c(si2<?> si2, nz2 nz2) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2023988535")) {
            return (qd2) ipChange.ipc$dispatch("2023988535", new Object[]{si2, nz2});
        }
        StringBuilder sb = new StringBuilder("DELETE FROM ");
        sb.append("\"");
        sb.append(si2.f());
        sb.append("\"");
        if (nz2 != null && nz2.d() > 0) {
            sb.append(" WHERE ");
            sb.append(nz2.toString());
        }
        return new qd2(sb.toString());
    }

    public static qd2 d(si2<?> si2, Object obj) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1400982770")) {
            return (qd2) ipChange.ipc$dispatch("-1400982770", new Object[]{si2, obj});
        }
        qd2 qd2 = new qd2();
        ak e = si2.e();
        if (obj != null) {
            qd2.f("DELETE FROM " + "\"" + si2.f() + "\"" + " WHERE " + nz2.c(e.d(), "=", obj));
            return qd2;
        }
        throw new DbException("this entity[" + si2.d() + "]'s id value is null");
    }

    public static qd2 e(si2<?> si2, Object obj) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-955321650")) {
            return (qd2) ipChange.ipc$dispatch("-955321650", new Object[]{si2, obj});
        }
        List<a61> j = j(si2, obj);
        if (j.size() == 0) {
            return null;
        }
        qd2 qd2 = new qd2();
        String str = a.get(si2);
        if (str == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO ");
            sb.append("\"");
            sb.append(si2.f());
            sb.append("\"");
            sb.append(" (");
            for (a61 a61 : j) {
                sb.append("\"");
                sb.append(a61.a);
                sb.append("\"");
                sb.append(',');
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(") VALUES (");
            int size = j.size();
            for (int i = 0; i < size; i++) {
                sb.append("?,");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(jl1.BRACKET_END_STR);
            String sb2 = sb.toString();
            qd2.f(sb2);
            qd2.b(j);
            a.put(si2, sb2);
        } else {
            qd2.f(str);
            qd2.b(j);
        }
        return qd2;
    }

    public static qd2 f(si2<?> si2, Object obj) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1091998645")) {
            return (qd2) ipChange.ipc$dispatch("-1091998645", new Object[]{si2, obj});
        }
        List<a61> j = j(si2, obj);
        if (j.size() == 0) {
            return null;
        }
        qd2 qd2 = new qd2();
        String str = b.get(si2);
        if (str == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("REPLACE INTO ");
            sb.append("\"");
            sb.append(si2.f());
            sb.append("\"");
            sb.append(" (");
            for (a61 a61 : j) {
                sb.append("\"");
                sb.append(a61.a);
                sb.append("\"");
                sb.append(',');
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(") VALUES (");
            int size = j.size();
            for (int i = 0; i < size; i++) {
                sb.append("?,");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(jl1.BRACKET_END_STR);
            String sb2 = sb.toString();
            qd2.f(sb2);
            qd2.b(j);
            b.put(si2, sb2);
        } else {
            qd2.f(str);
            qd2.b(j);
        }
        return qd2;
    }

    public static qd2 g(si2<?> si2, Object obj, String... strArr) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2030629385")) {
            return (qd2) ipChange.ipc$dispatch("2030629385", new Object[]{si2, obj, strArr});
        }
        List<a61> j = j(si2, obj);
        HashSet hashSet = null;
        if (j.size() == 0) {
            return null;
        }
        if (strArr != null && strArr.length > 0) {
            hashSet = new HashSet(strArr.length);
            Collections.addAll(hashSet, strArr);
        }
        ak e = si2.e();
        Object b2 = e.b(obj);
        if (b2 != null) {
            qd2 qd2 = new qd2();
            StringBuilder sb = new StringBuilder("UPDATE ");
            sb.append("\"");
            sb.append(si2.f());
            sb.append("\"");
            sb.append(" SET ");
            for (a61 a61 : j) {
                if (hashSet == null || hashSet.contains(a61.a)) {
                    sb.append("\"");
                    sb.append(a61.a);
                    sb.append("\"");
                    sb.append("=?,");
                    qd2.a(a61);
                }
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(" WHERE ");
            sb.append(nz2.c(e.d(), "=", b2));
            qd2.f(sb.toString());
            return qd2;
        }
        throw new DbException("this entity[" + si2.d() + "]'s id value is null");
    }

    public static qd2 h(si2<?> si2, nz2 nz2, KeyValue... keyValueArr) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1330120818")) {
            return (qd2) ipChange.ipc$dispatch("1330120818", new Object[]{si2, nz2, keyValueArr});
        } else if (keyValueArr == null || keyValueArr.length == 0) {
            return null;
        } else {
            qd2 qd2 = new qd2();
            StringBuilder sb = new StringBuilder("UPDATE ");
            sb.append("\"");
            sb.append(si2.f());
            sb.append("\"");
            sb.append(" SET ");
            for (KeyValue keyValue : keyValueArr) {
                sb.append("\"");
                sb.append(keyValue.a);
                sb.append("\"");
                sb.append("=?,");
                qd2.a(keyValue);
            }
            sb.deleteCharAt(sb.length() - 1);
            if (nz2 != null && nz2.d() > 0) {
                sb.append(" WHERE ");
                sb.append(nz2.toString());
            }
            qd2.f(sb.toString());
            return qd2;
        }
    }

    private static a61 i(Object obj, ak akVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "182155706")) {
            return (a61) ipChange.ipc$dispatch("182155706", new Object[]{obj, akVar});
        } else if (akVar.f()) {
            return null;
        } else {
            return new a61(akVar.d(), akVar.c(obj));
        }
    }

    public static List<a61> j(si2<?> si2, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-386811162")) {
            return (List) ipChange.ipc$dispatch("-386811162", new Object[]{si2, obj});
        }
        Collection<ak> values = si2.b().values();
        ArrayList arrayList = new ArrayList(values.size());
        for (ak akVar : values) {
            a61 i = i(obj, akVar);
            if (i != null) {
                arrayList.add(i);
            }
        }
        return arrayList;
    }
}
