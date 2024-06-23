package tb;

import android.text.TextUtils;
import com.alibaba.analytics.core.db.annotation.Column;
import com.alibaba.analytics.core.db.annotation.Ingore;
import com.alibaba.analytics.core.db.annotation.TableName;
import com.alibaba.appmonitor.pool.Reusable;
import com.alibaba.appmonitor.sample.a;
import com.alibaba.fastjson.JSON;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import java.util.UUID;

@TableName("stat_register_temp")
/* compiled from: Taobao */
public class qd1 extends xd0 implements Reusable {
    @Column("module")
    private String a;
    @Column(oj2.TAG_MONITOR_POINT)
    private String b;
    @Column("dimensions")
    private String c;
    @Column("measures")
    private String d;
    @Ingore
    private String e;
    @Column("is_commit_detail")
    private boolean f;
    @Ingore
    private DimensionSet g;
    @Ingore
    private MeasureSet h;
    @Ingore
    private String i;

    @Deprecated
    public qd1() {
    }

    public DimensionSet a() {
        if (this.g == null && !TextUtils.isEmpty(this.c)) {
            this.g = (DimensionSet) JSON.parseObject(this.c, DimensionSet.class);
        }
        return this.g;
    }

    public MeasureSet b() {
        if (this.h == null && !TextUtils.isEmpty(this.d)) {
            this.h = (MeasureSet) JSON.parseObject(this.d, MeasureSet.class);
        }
        return this.h;
    }

    public String c() {
        return this.b;
    }

    @Override // com.alibaba.appmonitor.pool.Reusable
    public void clean() {
        this.a = null;
        this.b = null;
        this.e = null;
        this.f = false;
        this.g = null;
        this.h = null;
        this.i = null;
    }

    public synchronized String d() {
        if (this.i == null) {
            this.i = UUID.randomUUID().toString() + "$" + this.a + "$" + this.b;
        }
        return this.i;
    }

    public synchronized boolean e() {
        return this.f || a.h().j(this.a, this.b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || qd1.class != obj.getClass()) {
            return false;
        }
        qd1 qd1 = (qd1) obj;
        String str = this.e;
        if (str == null) {
            if (qd1.e != null) {
                return false;
            }
        } else if (!str.equals(qd1.e)) {
            return false;
        }
        String str2 = this.a;
        if (str2 == null) {
            if (qd1.a != null) {
                return false;
            }
        } else if (!str2.equals(qd1.a)) {
            return false;
        }
        String str3 = this.b;
        if (str3 == null) {
            if (qd1.b != null) {
                return false;
            }
        } else if (!str3.equals(qd1.b)) {
            return false;
        }
        return true;
    }

    public void f() {
        this.i = null;
    }

    @Override // com.alibaba.appmonitor.pool.Reusable
    public void fill(Object... objArr) {
        this.a = (String) objArr[0];
        this.b = (String) objArr[1];
        if (objArr.length > 2) {
            this.e = (String) objArr[2];
        }
    }

    public boolean g(DimensionValueSet dimensionValueSet, MeasureValueSet measureValueSet) {
        DimensionSet dimensionSet = this.g;
        boolean z = true;
        boolean valid = dimensionSet != null ? dimensionSet.valid(dimensionValueSet) : true;
        MeasureSet measureSet = this.h;
        if (measureSet == null) {
            return valid;
        }
        if (!valid || !measureSet.valid(measureValueSet)) {
            z = false;
        }
        return z;
    }

    public String getModule() {
        return this.a;
    }

    public int hashCode() {
        String str = this.e;
        int i2 = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.a;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.b;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public qd1(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) {
        this.a = str;
        this.b = str2;
        this.g = dimensionSet;
        this.h = measureSet;
        this.e = null;
        this.f = z;
        if (dimensionSet != null) {
            this.c = JSON.toJSONString(dimensionSet);
        }
        this.d = JSON.toJSONString(measureSet);
    }
}
