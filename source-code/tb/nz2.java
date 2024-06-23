package tb;

import android.text.TextUtils;
import cn.damai.common.db.db.sqlite.ColumnDbType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
public class nz2 {
    private static transient /* synthetic */ IpChange $ipChange;
    private final List<String> a = new ArrayList();

    private nz2() {
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:89:0x00cb */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:93:0x0162 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.util.List, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.util.List, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v15, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARNING: Unknown variable types count: 2 */
    private void b(String str, String str2, String str3, Object obj) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-359708904")) {
            ipChange.ipc$dispatch("-359708904", new Object[]{this, str, str2, str3, obj});
            return;
        }
        StringBuilder sb = new StringBuilder();
        if (this.a.size() > 0) {
            sb.append(" ");
        }
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            sb.append(" ");
        }
        sb.append("\"");
        sb.append(str2);
        sb.append("\"");
        if (jl1.NOT_EQUAL2.equals(str3)) {
            str3 = "<>";
        } else if (jl1.EQUAL2.equals(str3)) {
            str3 = "=";
        }
        if (obj != null) {
            sb.append(" ");
            sb.append(str3);
            sb.append(" ");
            ?? r1 = 0;
            ?? r12 = 0;
            if ("IN".equalsIgnoreCase(str3)) {
                if (obj instanceof Iterable) {
                    r12 = (Iterable) obj;
                } else if (obj.getClass().isArray()) {
                    int length = Array.getLength(obj);
                    r12 = new ArrayList(length);
                    while (i < length) {
                        r12.add(Array.get(obj, i));
                        i++;
                    }
                }
                if (r12 != 0) {
                    StringBuilder sb2 = new StringBuilder(jl1.BRACKET_START_STR);
                    for (Object obj2 : r12) {
                        Object a2 = ck.a(obj2);
                        if (ColumnDbType.TEXT.equals(zj.b(a2.getClass()))) {
                            String obj3 = a2.toString();
                            if (obj3.indexOf(39) != -1) {
                                obj3 = obj3.replace("'", "''");
                            }
                            sb2.append("'");
                            sb2.append(obj3);
                            sb2.append("'");
                        } else {
                            sb2.append(a2);
                        }
                        sb2.append(",");
                    }
                    sb2.deleteCharAt(sb2.length() - 1);
                    sb2.append(jl1.BRACKET_END_STR);
                    sb.append(sb2.toString());
                } else {
                    throw new IllegalArgumentException("value must be an Array or an Iterable.");
                }
            } else if ("BETWEEN".equalsIgnoreCase(str3)) {
                if (obj instanceof Iterable) {
                    r1 = (Iterable) obj;
                } else if (obj.getClass().isArray()) {
                    int length2 = Array.getLength(obj);
                    r1 = new ArrayList(length2);
                    while (i < length2) {
                        r1.add(Array.get(obj, i));
                        i++;
                    }
                }
                if (r1 != 0) {
                    Iterator it = r1.iterator();
                    if (it.hasNext()) {
                        Object next = it.next();
                        if (it.hasNext()) {
                            Object next2 = it.next();
                            Object a3 = ck.a(next);
                            Object a4 = ck.a(next2);
                            if (ColumnDbType.TEXT.equals(zj.b(a3.getClass()))) {
                                String obj4 = a3.toString();
                                if (obj4.indexOf(39) != -1) {
                                    obj4 = obj4.replace("'", "''");
                                }
                                String obj5 = a4.toString();
                                if (obj5.indexOf(39) != -1) {
                                    obj5 = obj5.replace("'", "''");
                                }
                                sb.append("'");
                                sb.append(obj4);
                                sb.append("'");
                                sb.append(" AND ");
                                sb.append("'");
                                sb.append(obj5);
                                sb.append("'");
                            } else {
                                sb.append(a3);
                                sb.append(" AND ");
                                sb.append(a4);
                            }
                        } else {
                            throw new IllegalArgumentException("value must have tow items.");
                        }
                    } else {
                        throw new IllegalArgumentException("value must have tow items.");
                    }
                } else {
                    throw new IllegalArgumentException("value must be an Array or an Iterable.");
                }
            } else {
                Object a5 = ck.a(obj);
                if (ColumnDbType.TEXT.equals(zj.b(a5.getClass()))) {
                    String obj6 = a5.toString();
                    if (obj6.indexOf(39) != -1) {
                        obj6 = obj6.replace("'", "''");
                    }
                    sb.append("'");
                    sb.append(obj6);
                    sb.append("'");
                } else {
                    sb.append(a5);
                }
            }
        } else if ("=".equals(str3)) {
            sb.append(" IS NULL");
        } else if ("<>".equals(str3)) {
            sb.append(" IS NOT NULL");
        } else {
            sb.append(" ");
            sb.append(str3);
            sb.append(" NULL");
        }
        this.a.add(sb.toString());
    }

    public static nz2 c(String str, String str2, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1404675120")) {
            return (nz2) ipChange.ipc$dispatch("-1404675120", new Object[]{str, str2, obj});
        }
        nz2 nz2 = new nz2();
        nz2.b(null, str, str2, obj);
        return nz2;
    }

    public nz2 a(String str, String str2, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "938404795")) {
            return (nz2) ipChange.ipc$dispatch("938404795", new Object[]{this, str, str2, obj});
        }
        b(this.a.size() == 0 ? null : "AND", str, str2, obj);
        return this;
    }

    public int d() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1138494375")) {
            return this.a.size();
        }
        return ((Integer) ipChange.ipc$dispatch("-1138494375", new Object[]{this})).intValue();
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1012328417")) {
            return (String) ipChange.ipc$dispatch("1012328417", new Object[]{this});
        } else if (this.a.size() == 0) {
            return "";
        } else {
            StringBuilder sb = new StringBuilder();
            for (String str : this.a) {
                sb.append(str);
            }
            return sb.toString();
        }
    }
}
