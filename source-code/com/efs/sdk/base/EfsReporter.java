package com.efs.sdk.base;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.efs.sdk.base.a.c.a.c;
import com.efs.sdk.base.protocol.ILogProtocol;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.c13;
import tb.t43;

/* compiled from: Taobao */
public class EfsReporter {
    private static com.efs.sdk.base.a.d.a a;

    /* compiled from: Taobao */
    public static class Builder {
        private static Map<String, EfsReporter> b = new ConcurrentHashMap();
        private static boolean c = true;
        private c13 a;

        /* compiled from: Taobao */
        public interface IPublicParams {
            Map<String, String> getRecordHeaders();
        }

        public Builder(@NonNull Context context, @NonNull String str, @NonNull String str2) {
            Context b2 = b(context);
            if (TextUtils.isEmpty(str)) {
                throw new RuntimeException("EfsReporter init, appid is empty");
            } else if (!TextUtils.isEmpty(str2)) {
                c13 c13 = new c13();
                this.a = c13;
                c13.c = b2;
                c13.a = str;
                c13.b = str2;
            } else {
                throw new RuntimeException("EfsReporter init, secret is empty");
            }
        }

        private static Context b(Context context) {
            if (context == null) {
                t43.c(Constants.TAG, "context can not be null!", null);
                throw null;
            } else if (!c || (context instanceof Application) || ((context = context.getApplicationContext()) != null && (context instanceof Application))) {
                return context;
            } else {
                t43.c(Constants.TAG, "Can not get Application context from given context!", null);
                throw new IllegalArgumentException("Can not get Application context from given context!");
            }
        }

        private void c(String str) {
            c13 c2 = b.get(str).c();
            if (!c2.c.equals(e().c)) {
                throw new RuntimeException("efs-core: duplicate init, but " + "application context is different");
            } else if (!TextUtils.isEmpty(c2.b) && !c2.b.equals(e().b)) {
                throw new RuntimeException("efs-core: duplicate init, but " + "secret is different");
            } else if (c2.j == e().j) {
                if (!TextUtils.isEmpty(e().i) && !e().i.equals(c2.i)) {
                    t43.b("efs.reporter.builder", "efs-core: duplicate init, but " + " uid is different", null);
                }
                if (e().b() != null && e().b().size() > 0) {
                    c2.c(e().b());
                }
            } else {
                throw new RuntimeException("efs-core: duplicate init, but " + "intl setting is different");
            }
        }

        public EfsReporter a() {
            String str = e().a;
            if (!b.containsKey(str)) {
                synchronized (EfsReporter.class) {
                    if (!b.containsKey(str)) {
                        EfsReporter efsReporter = new EfsReporter(this);
                        b.put(str, efsReporter);
                        return efsReporter;
                    }
                }
            }
            t43.b("efs.reporter.builder", "efs-core: duplicate init", null);
            c(str);
            return b.get(str);
        }

        public Builder d(boolean z) {
            this.a.f = z;
            return this;
        }

        public c13 e() {
            return this.a;
        }

        public Builder f(boolean z) {
            this.a.j = z;
            return this;
        }

        public Builder g(boolean z) {
            this.a.h = z;
            return this;
        }

        public Builder h(String str) {
            this.a.i = str;
            return this;
        }
    }

    private EfsReporter(Builder builder) {
        a = new com.efs.sdk.base.a.d.a(builder);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @NonNull
    private c13 c() {
        return com.efs.sdk.base.a.d.a.a();
    }

    public Map<String, Object> b() {
        return new HashMap(c.a().e.f);
    }

    public void d(ILogProtocol iLogProtocol) {
        a.b(iLogProtocol);
    }
}
