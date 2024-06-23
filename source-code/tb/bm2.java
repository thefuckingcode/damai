package tb;

import com.alibaba.analytics.core.db.annotation.Column;
import com.alibaba.analytics.core.db.annotation.TableName;

@TableName("timestamp_config")
/* compiled from: Taobao */
public class bm2 extends xd0 {
    @Column("namespace")
    public String a;
    @Column("timestamp")
    public String b;

    public bm2() {
    }

    public bm2(String str, String str2) {
        this.a = str;
        this.b = str2;
    }
}
