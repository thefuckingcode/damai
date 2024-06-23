package com.huawei.hms.hatool;

import android.taobao.windvane.util.ConfigStorage;
import com.taobao.weex.annotation.JSMethod;
import java.util.Calendar;
import java.util.UUID;

/* compiled from: Taobao */
public class f0 {
    public long a = ConfigStorage.DEFAULT_SMALL_MAX_AGE;
    public volatile boolean b = false;
    public a c = null;

    /* compiled from: Taobao */
    public class a {
        public String a = UUID.randomUUID().toString().replace("-", "");
        public boolean b;
        public long c;

        public a(long j) {
            this.a += JSMethod.NOT_SET + j;
            this.c = j;
            this.b = true;
            f0.this.b = false;
        }

        public void a(long j) {
            if (f0.this.b) {
                f0.this.b = false;
                b(j);
            } else if (b(this.c, j) || a(this.c, j)) {
                b(j);
            } else {
                this.c = j;
                this.b = false;
            }
        }

        public final boolean a(long j, long j2) {
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(j);
            Calendar instance2 = Calendar.getInstance();
            instance2.setTimeInMillis(j2);
            return (instance.get(1) == instance2.get(1) && instance.get(6) == instance2.get(6)) ? false : true;
        }

        public final void b(long j) {
            y.c("hmsSdk", "getNewSession() session is flush!");
            String uuid = UUID.randomUUID().toString();
            this.a = uuid;
            this.a = uuid.replace("-", "");
            this.a += JSMethod.NOT_SET + j;
            this.c = j;
            this.b = true;
        }

        public final boolean b(long j, long j2) {
            return j2 - j >= f0.this.a;
        }
    }

    public String a() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.a;
        }
        y.f("hmsSdk", "getSessionName(): session not prepared. onEvent() must be called first.");
        return "";
    }

    public void a(long j) {
        a aVar = this.c;
        if (aVar == null) {
            y.c("hmsSdk", "Session is first flush");
            this.c = new a(j);
            return;
        }
        aVar.a(j);
    }

    public boolean b() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.b;
        }
        y.f("hmsSdk", "isFirstEvent(): session not prepared. onEvent() must be called first.");
        return false;
    }
}
