package tb;

import android.database.Cursor;
import cn.damai.common.db.db.annotation.Column;
import cn.damai.common.db.db.converter.ColumnConverter;
import cn.damai.common.db.db.sqlite.ColumnDbType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: Taobao */
public final class ak {
    private static transient /* synthetic */ IpChange $ipChange;
    protected final String a;
    private final String b;
    private final boolean c;
    private final boolean d;
    protected final Method e;
    protected final Method f;
    protected final Field g;
    protected final ColumnConverter h;

    ak(Class<?> cls, Field field, Column column) {
        field.setAccessible(true);
        this.g = field;
        this.a = column.name();
        this.b = column.property();
        boolean isId = column.isId();
        this.c = isId;
        Class<?> type = field.getType();
        this.d = isId && column.autoGen() && ck.f(type);
        this.h = zj.a(type);
        Method d2 = ck.d(cls, field);
        this.e = d2;
        if (d2 != null && !d2.isAccessible()) {
            d2.setAccessible(true);
        }
        Method e2 = ck.e(cls, field);
        this.f = e2;
        if (e2 != null && !e2.isAccessible()) {
            e2.setAccessible(true);
        }
    }

    public ColumnDbType a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "247721047")) {
            return this.h.getColumnDbType();
        }
        return (ColumnDbType) ipChange.ipc$dispatch("247721047", new Object[]{this});
    }

    public Object b(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2139151005")) {
            return ipChange.ipc$dispatch("-2139151005", new Object[]{this, obj});
        }
        Object c2 = c(obj);
        if (!this.d || (!c2.equals(0L) && !c2.equals(0))) {
            return this.h.fieldValue2DbValue(c2);
        }
        return null;
    }

    public Object c(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1942283025")) {
            return ipChange.ipc$dispatch("1942283025", new Object[]{this, obj});
        } else if (obj == null) {
            return null;
        } else {
            Method method = this.e;
            if (method != null) {
                try {
                    return method.invoke(obj, new Object[0]);
                } catch (Throwable th) {
                    k91.c(th.getMessage(), th);
                    return null;
                }
            } else {
                try {
                    return this.g.get(obj);
                } catch (Throwable th2) {
                    k91.c(th2.getMessage(), th2);
                    return null;
                }
            }
        }
    }

    public String d() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1954721713")) {
            return this.a;
        }
        return (String) ipChange.ipc$dispatch("-1954721713", new Object[]{this});
    }

    public String e() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "919914009")) {
            return this.b;
        }
        return (String) ipChange.ipc$dispatch("919914009", new Object[]{this});
    }

    public boolean f() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "50375176")) {
            return this.d;
        }
        return ((Boolean) ipChange.ipc$dispatch("50375176", new Object[]{this})).booleanValue();
    }

    public boolean g() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1318004471")) {
            return this.c;
        }
        return ((Boolean) ipChange.ipc$dispatch("1318004471", new Object[]{this})).booleanValue();
    }

    public void h(Object obj, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "148996885")) {
            ipChange.ipc$dispatch("148996885", new Object[]{this, obj, Long.valueOf(j)});
            return;
        }
        Object valueOf = Long.valueOf(j);
        if (ck.h(this.g.getType())) {
            valueOf = Integer.valueOf((int) j);
        }
        Method method = this.f;
        if (method != null) {
            try {
                method.invoke(obj, valueOf);
            } catch (Throwable th) {
                k91.c(th.getMessage(), th);
            }
        } else {
            try {
                this.g.set(obj, valueOf);
            } catch (Throwable th2) {
                k91.c(th2.getMessage(), th2);
            }
        }
    }

    public void i(Object obj, Cursor cursor, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1952235055")) {
            ipChange.ipc$dispatch("-1952235055", new Object[]{this, obj, cursor, Integer.valueOf(i)});
            return;
        }
        Object fieldValue = this.h.getFieldValue(cursor, i);
        if (fieldValue != null) {
            Method method = this.f;
            if (method != null) {
                try {
                    method.invoke(obj, fieldValue);
                } catch (Throwable th) {
                    k91.c(th.getMessage(), th);
                }
            } else {
                try {
                    this.g.set(obj, fieldValue);
                } catch (Throwable th2) {
                    k91.c(th2.getMessage(), th2);
                }
            }
        }
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1955934060")) {
            return this.a;
        }
        return (String) ipChange.ipc$dispatch("-1955934060", new Object[]{this});
    }
}
