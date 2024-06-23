package com.tencent.open.log;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.text.SimpleDateFormat;

/* compiled from: Taobao */
public class d {

    /* compiled from: Taobao */
    public static final class a {
        public static final boolean a(int i, int i2) {
            return i2 == (i & i2);
        }
    }

    /* compiled from: Taobao */
    public static final class b {
        public static boolean a() {
            String externalStorageState = Environment.getExternalStorageState();
            return "mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState);
        }

        public static c b() {
            if (!a()) {
                return null;
            }
            return c.b(Environment.getExternalStorageDirectory());
        }
    }

    /* compiled from: Taobao */
    public static class c {
        private File a;
        private long b;
        private long c;

        public File a() {
            return this.a;
        }

        public long b() {
            return this.b;
        }

        public long c() {
            return this.c;
        }

        public String toString() {
            return String.format("[%s : %d / %d]", a().getAbsolutePath(), Long.valueOf(c()), Long.valueOf(b()));
        }

        public void a(File file) {
            this.a = file;
        }

        public void b(long j) {
            this.c = j;
        }

        public static c b(File file) {
            c cVar = new c();
            cVar.a(file);
            StatFs statFs = new StatFs(file.getAbsolutePath());
            long blockSize = (long) statFs.getBlockSize();
            cVar.a(((long) statFs.getBlockCount()) * blockSize);
            cVar.b(((long) statFs.getAvailableBlocks()) * blockSize);
            return cVar;
        }

        public void a(long j) {
            this.b = j;
        }
    }

    /* renamed from: com.tencent.open.log.d$d  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static final class C0241d {
        @SuppressLint({"SimpleDateFormat"})
        public static SimpleDateFormat a(String str) {
            return new SimpleDateFormat(str);
        }
    }

    public static boolean a(String str) {
        return str.contains(Constants.PARAM_ACCESS_TOKEN) || str.contains("pay_token") || str.contains("pfkey") || str.contains(Constants.PARAM_EXPIRES_IN) || str.contains("openid") || str.contains("proxy_code") || str.contains("proxy_expires_in");
    }

    public static Bundle b(Bundle bundle) {
        if (!a(bundle)) {
            return bundle;
        }
        Bundle bundle2 = new Bundle(bundle);
        bundle2.remove(Constants.PARAM_ACCESS_TOKEN);
        bundle2.remove("pay_token");
        bundle2.remove("pfkey");
        bundle2.remove(Constants.PARAM_EXPIRES_IN);
        bundle2.remove("openid");
        bundle2.remove("proxy_code");
        bundle2.remove("proxy_expires_in");
        return bundle2;
    }

    public static boolean a(Bundle bundle) {
        return bundle.containsKey(Constants.PARAM_ACCESS_TOKEN) || bundle.containsKey("pay_token") || bundle.containsKey("pfkey") || bundle.containsKey(Constants.PARAM_EXPIRES_IN) || bundle.containsKey("openid") || bundle.containsKey("proxy_code") || bundle.containsKey("proxy_expires_in");
    }
}
