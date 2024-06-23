package tb;

import com.alibaba.analytics.core.db.annotation.Column;
import com.alibaba.analytics.core.db.annotation.TableName;

@TableName("alarm_temp")
/* compiled from: Taobao */
public class mj2 extends oj2 {
    @Column("err_code")
    public String f;
    @Column("err_msg")
    public String g;
    @Column("arg")
    public String h;
    @Column("success")
    public String i;

    public mj2() {
    }

    public boolean a() {
        return "1".equalsIgnoreCase(this.i);
    }

    @Override // tb.oj2
    public String toString() {
        return "TempAlarm{" + " module='" + this.a + '\'' + ", monitorPoint='" + this.b + '\'' + ", commitTime=" + this.c + ", access='" + this.d + '\'' + ", accessSubType='" + this.e + '\'' + ", arg='" + this.h + '\'' + ", errCode='" + this.f + '\'' + ", errMsg='" + this.g + '\'' + ", success='" + this.i + '\'' + '}';
    }

    public mj2(String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7) {
        super(str, str2, str6, str7);
        this.h = str3;
        this.f = str4;
        this.g = str5;
        this.i = z ? "1" : "0";
    }
}
