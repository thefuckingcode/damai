package anet.channel;

import android.text.TextUtils;
import anet.channel.entity.ENV;
import anet.channel.security.ISecurity;
import anet.channel.util.ALog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public final class a {
    public static final a DEFAULT_CONFIG = new C0000a().f("[default]").c("[default]").e(ENV.ONLINE).a();
    private static Map<String, a> e = new HashMap();
    private String a;
    private String b;
    private ENV c = ENV.ONLINE;
    private ISecurity d;

    /* renamed from: anet.channel.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static class C0000a {
        private String a;
        private String b;
        private ENV c = ENV.ONLINE;
        private String d;
        private String e;

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x006c, code lost:
            r0 = new anet.channel.a();
            r0.b = r8.b;
            r0.c = r8.c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0081, code lost:
            if (android.text.TextUtils.isEmpty(r8.a) == false) goto L_0x0095;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0083, code lost:
            r0.a = tb.ag2.e(r8.b, "$", r8.c.toString());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0095, code lost:
            r0.a = r8.a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a0, code lost:
            if (android.text.TextUtils.isEmpty(r8.e) != false) goto L_0x00b0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00a2, code lost:
            r0.d = tb.b82.a().createNonSecurity(r8.e);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x00b0, code lost:
            r0.d = tb.b82.a().createSecurity(r8.d);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x00bd, code lost:
            r1 = anet.channel.a.e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x00c1, code lost:
            monitor-enter(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            anet.channel.a.e.put(r0.a, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x00cd, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00ce, code lost:
            return r0;
         */
        public a a() {
            if (!TextUtils.isEmpty(this.b)) {
                synchronized (a.e) {
                    for (a aVar : a.e.values()) {
                        if (aVar.c == this.c && aVar.b.equals(this.b)) {
                            ALog.k("awcn.Config", "duplicated config exist!", null, "appkey", this.b, "env", this.c);
                            if (!TextUtils.isEmpty(this.a)) {
                                a.e.put(this.a, aVar);
                            }
                            return aVar;
                        }
                    }
                }
            } else {
                throw new RuntimeException("appkey can not be null or empty!");
            }
        }

        public C0000a b(String str) {
            this.e = str;
            return this;
        }

        public C0000a c(String str) {
            this.b = str;
            return this;
        }

        public C0000a d(String str) {
            this.d = str;
            return this;
        }

        public C0000a e(ENV env) {
            this.c = env;
            return this;
        }

        public C0000a f(String str) {
            this.a = str;
            return this;
        }
    }

    protected a() {
    }

    public static a j(String str, ENV env) {
        synchronized (e) {
            for (a aVar : e.values()) {
                if (aVar.c == env && aVar.b.equals(str)) {
                    return aVar;
                }
            }
            return null;
        }
    }

    public static a k(String str) {
        a aVar;
        synchronized (e) {
            aVar = e.get(str);
        }
        return aVar;
    }

    public String i() {
        return this.b;
    }

    public ENV l() {
        return this.c;
    }

    public ISecurity m() {
        return this.d;
    }

    public String toString() {
        return this.a;
    }
}
