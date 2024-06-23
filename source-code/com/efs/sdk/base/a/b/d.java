package com.efs.sdk.base.a.b;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import com.efs.sdk.base.Constants;
import com.efs.sdk.base.a.b.a;
import com.efs.sdk.base.a.c.a.c;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import tb.g23;
import tb.k23;
import tb.k53;
import tb.n13;
import tb.o13;
import tb.s33;
import tb.t43;
import tb.v23;
import tb.w23;

/* compiled from: Taobao */
public final class d extends Handler implements e {
    private final ConcurrentHashMap<String, a> a = new ConcurrentHashMap<>();
    private s33 b = new s33();
    private v23 c = new v23();

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a extends FileOutputStream {
        File a;

        a(@NonNull File file) {
            super(file);
            this.a = file;
            System.currentTimeMillis();
        }
    }

    d() {
        super(o13.a.getLooper());
    }

    /* JADX INFO: finally extract failed */
    private boolean b(g23 g23, File file) {
        Throwable th;
        BufferedReader bufferedReader;
        StringBuilder sb = new StringBuilder();
        FileReader fileReader = null;
        try {
            FileReader fileReader2 = new FileReader(file);
            try {
                bufferedReader = new BufferedReader(fileReader2);
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            String d = k23.d(readLine.getBytes());
                            if (!TextUtils.isEmpty(d)) {
                                sb.append(d);
                                sb.append(StringUtils.LF);
                            }
                        } else {
                            g23.e(sb.toString().getBytes());
                            g23.i();
                            this.c.a(g23);
                            this.b.a(g23);
                            g23.d = file;
                            w23.c(bufferedReader);
                            w23.c(fileReader2);
                            return true;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileReader = fileReader2;
                        try {
                            t43.c("efs.cache", "local decode error", th);
                            w23.c(bufferedReader);
                            w23.c(fileReader);
                            return false;
                        } catch (Throwable th3) {
                            w23.c(bufferedReader);
                            w23.c(fileReader);
                            throw th3;
                        }
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
                fileReader = fileReader2;
                t43.c("efs.cache", "local decode error", th);
                w23.c(bufferedReader);
                w23.c(fileReader);
                return false;
            }
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
            t43.c("efs.cache", "local decode error", th);
            w23.c(bufferedReader);
            w23.c(fileReader);
            return false;
        }
    }

    private static long c(String str) {
        Map<String, String> i = c.a().i();
        String concat = "record_accumulation_time_".concat(String.valueOf(str));
        if (!i.containsKey(concat)) {
            return DateUtils.MILLIS_PER_MINUTE;
        }
        String str2 = i.get(concat);
        if (TextUtils.isEmpty(str2)) {
            return DateUtils.MILLIS_PER_MINUTE;
        }
        try {
            return Math.max(Long.parseLong(str2) * 1000, 1000L);
        } catch (Throwable th) {
            t43.c("efs.cache", "get cache interval error", th);
            return DateUtils.MILLIS_PER_MINUTE;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0076  */
    private a d(g23 g23) {
        a aVar;
        Throwable th;
        if (this.a.containsKey(g23.a.a)) {
            return this.a.get(g23.a.a);
        }
        File file = new File(n13.f(com.efs.sdk.base.a.d.a.a().c, com.efs.sdk.base.a.d.a.a().a), w23.b(g23));
        try {
            aVar = new a(file);
            try {
                a putIfAbsent = this.a.putIfAbsent(g23.a.a, aVar);
                if (putIfAbsent != null) {
                    w23.c(aVar);
                    w23.i(file);
                    return putIfAbsent;
                }
                Message obtain = Message.obtain();
                String str = g23.a.a;
                obtain.obj = str;
                obtain.what = 1;
                sendMessageDelayed(obtain, c(str));
                if (!Constants.LOG_TYPE_WA.equalsIgnoreCase(g23.a.a)) {
                    k53.a.a.c.b();
                }
                return aVar;
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
                if (!Constants.LOG_TYPE_WA.equalsIgnoreCase(g23.a.a)) {
                }
                return aVar;
            }
        } catch (Throwable th3) {
            aVar = null;
            th = th3;
            th.printStackTrace();
            if (!Constants.LOG_TYPE_WA.equalsIgnoreCase(g23.a.a)) {
            }
            return aVar;
        }
    }

    private void e(String str) {
        a aVar;
        if (this.a.containsKey(str) && (aVar = this.a.get(str)) != null) {
            try {
                aVar.flush();
                w23.c(aVar);
                a(aVar.a);
                this.a.remove(str);
                if (Constants.LOG_TYPE_WA.equalsIgnoreCase(str)) {
                    return;
                }
            } catch (Throwable th) {
                this.a.remove(str);
                if (!Constants.LOG_TYPE_WA.equalsIgnoreCase(str)) {
                    k53.a.a.c.c();
                }
                throw th;
            }
            k53.a.a.c.c();
        }
    }

    @Override // com.efs.sdk.base.a.b.e
    public final void a(File file) {
        byte[] bArr;
        g23 h = w23.h(file.getName());
        if (h == null) {
            a unused = a.b.a;
            a.d(file);
        } else if (!b(h, file) || (bArr = h.c) == null || bArr.length <= 0) {
            a unused2 = a.b.a;
            a.d(file);
        } else {
            w23.f(new File(n13.g(com.efs.sdk.base.a.d.a.a().c, com.efs.sdk.base.a.d.a.a().a), w23.b(h)), h.c);
            w23.i(file);
        }
    }

    @Override // com.efs.sdk.base.a.b.e
    public final void a(@NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            Message obtain = Message.obtain();
            obtain.obj = str;
            obtain.what = 1;
            sendMessage(obtain);
        }
    }

    @Override // com.efs.sdk.base.a.b.e
    public final void a(g23 g23) {
        Message obtain = Message.obtain();
        obtain.obj = g23;
        obtain.what = 0;
        sendMessage(obtain);
    }

    @Override // com.efs.sdk.base.a.b.e
    public final boolean a(File file, g23 g23) {
        if (!g23.g()) {
            a(file);
            return false;
        } else if (!file.exists()) {
            return false;
        } else {
            g23.d = file;
            g23.i();
            g23.f(1);
            return true;
        }
    }

    public final void handleMessage(@NonNull Message message) {
        int i = message.what;
        if (i == 0) {
            g23 g23 = (g23) message.obj;
            for (int i2 = 0; i2 < 3; i2++) {
                try {
                    a d = d(g23);
                    if (d == null) {
                        t43.b("efs.cache", "writer is null for type " + g23.a.a, null);
                        return;
                    }
                    if (d.getChannel().position() + ((long) g23.c.length) > 819200) {
                        e(g23.a.a);
                        d = d(g23);
                        if (d == null) {
                            t43.b("efs.cache", "writer is null for type " + g23.a.a, null);
                            return;
                        }
                    }
                    d.write(Base64.encode(g23.c, 11));
                    d.write(StringUtils.LF.getBytes());
                    return;
                } catch (Throwable th) {
                    t43.c("efs.cache", "cache file error", th);
                }
            }
        } else if (i == 1) {
            Object obj = message.obj;
            if (obj instanceof String) {
                e(obj.toString());
            }
        }
    }
}
