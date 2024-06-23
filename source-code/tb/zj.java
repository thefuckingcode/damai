package tb;

import cn.damai.common.db.db.converter.ColumnConverter;
import cn.damai.common.db.db.sqlite.ColumnDbType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
public final class zj {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final ConcurrentHashMap<String, ColumnConverter> a;

    static {
        ConcurrentHashMap<String, ColumnConverter> concurrentHashMap = new ConcurrentHashMap<>();
        a = concurrentHashMap;
        kc kcVar = new kc();
        concurrentHashMap.put(Boolean.TYPE.getName(), kcVar);
        concurrentHashMap.put(Boolean.class.getName(), kcVar);
        concurrentHashMap.put(byte[].class.getName(), new qd());
        td tdVar = new td();
        concurrentHashMap.put(Byte.TYPE.getName(), tdVar);
        concurrentHashMap.put(Byte.class.getName(), tdVar);
        hh hhVar = new hh();
        concurrentHashMap.put(Character.TYPE.getName(), hhVar);
        concurrentHashMap.put(Character.class.getName(), hhVar);
        concurrentHashMap.put(Date.class.getName(), new w20());
        ib0 ib0 = new ib0();
        concurrentHashMap.put(Double.TYPE.getName(), ib0);
        concurrentHashMap.put(Double.class.getName(), ib0);
        ij0 ij0 = new ij0();
        concurrentHashMap.put(Float.TYPE.getName(), ij0);
        concurrentHashMap.put(Float.class.getName(), ij0);
        a21 a21 = new a21();
        concurrentHashMap.put(Integer.TYPE.getName(), a21);
        concurrentHashMap.put(Integer.class.getName(), a21);
        ea1 ea1 = new ea1();
        concurrentHashMap.put(Long.TYPE.getName(), ea1);
        concurrentHashMap.put(Long.class.getName(), ea1);
        oa2 oa2 = new oa2();
        concurrentHashMap.put(Short.TYPE.getName(), oa2);
        concurrentHashMap.put(Short.class.getName(), oa2);
        concurrentHashMap.put(java.sql.Date.class.getName(), new pd2());
        concurrentHashMap.put(String.class.getName(), new df2());
    }

    public static ColumnConverter a(Class cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-653412285")) {
            return (ColumnConverter) ipChange.ipc$dispatch("-653412285", new Object[]{cls});
        }
        ColumnConverter columnConverter = null;
        ConcurrentHashMap<String, ColumnConverter> concurrentHashMap = a;
        if (concurrentHashMap.containsKey(cls.getName())) {
            columnConverter = concurrentHashMap.get(cls.getName());
        } else if (ColumnConverter.class.isAssignableFrom(cls)) {
            try {
                ColumnConverter columnConverter2 = (ColumnConverter) cls.newInstance();
                if (columnConverter2 != null) {
                    concurrentHashMap.put(cls.getName(), columnConverter2);
                }
                columnConverter = columnConverter2;
            } catch (Throwable th) {
                k91.c(th.getMessage(), th);
            }
        }
        if (columnConverter != null) {
            return columnConverter;
        }
        throw new RuntimeException("Database Column Not Support: " + cls.getName() + ", please impl ColumnConverter or use ColumnConverterFactory#registerColumnConverter(...)");
    }

    public static ColumnDbType b(Class cls) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1420429747")) {
            return a(cls).getColumnDbType();
        }
        return (ColumnDbType) ipChange.ipc$dispatch("-1420429747", new Object[]{cls});
    }

    public static boolean c(Class cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1264527175")) {
            return ((Boolean) ipChange.ipc$dispatch("-1264527175", new Object[]{cls})).booleanValue();
        }
        ConcurrentHashMap<String, ColumnConverter> concurrentHashMap = a;
        if (concurrentHashMap.containsKey(cls.getName())) {
            return true;
        }
        if (!ColumnConverter.class.isAssignableFrom(cls)) {
            return false;
        }
        try {
            ColumnConverter columnConverter = (ColumnConverter) cls.newInstance();
            if (columnConverter != null) {
                concurrentHashMap.put(cls.getName(), columnConverter);
            }
            if (columnConverter == null) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }
}
