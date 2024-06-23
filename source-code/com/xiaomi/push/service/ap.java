package com.xiaomi.push.service;

import android.os.Process;
import android.taobao.windvane.util.ConfigStorage;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ab;
import com.xiaomi.push.ct;
import com.xiaomi.push.dw;
import com.xiaomi.push.fh;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
public class ap {
    private static long a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static ThreadPoolExecutor f896a = new ThreadPoolExecutor(1, 1, 20, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: a  reason: collision with other field name */
    private static final Pattern f897a = Pattern.compile("([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})");

    private static String a(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(str)));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(StringUtils.LF);
                        sb.append(readLine);
                    } else {
                        String sb2 = sb.toString();
                        ab.a(bufferedReader);
                        return sb2;
                    }
                }
            } catch (Exception unused) {
                ab.a(bufferedReader);
                return null;
            } catch (Throwable th2) {
                th = th2;
                ab.a(bufferedReader);
                throw th;
            }
        } catch (Exception unused2) {
            bufferedReader = null;
            ab.a(bufferedReader);
            return null;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
            ab.a(bufferedReader);
            throw th;
        }
    }

    public static void a() {
        dw.a a2;
        long currentTimeMillis = System.currentTimeMillis();
        if ((f896a.getActiveCount() <= 0 || currentTimeMillis - a >= ConfigStorage.DEFAULT_SMALL_MAX_AGE) && fh.m474a().m479a() && (a2 = bv.a().m839a()) != null && a2.e() > 0) {
            a = currentTimeMillis;
            a(a2.m360a(), true);
        }
    }

    public static void a(List<String> list, boolean z) {
        f896a.execute(new aq(list, z));
    }

    public static void b() {
        String a2 = a("/proc/self/net/tcp");
        if (!TextUtils.isEmpty(a2)) {
            b.m182a("dump tcp for uid = " + Process.myUid());
            b.m182a(a2);
        }
        String a3 = a("/proc/self/net/tcp6");
        if (!TextUtils.isEmpty(a3)) {
            b.m182a("dump tcp6 for uid = " + Process.myUid());
            b.m182a(a3);
        }
    }

    private static boolean b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            b.m182a("ConnectivityTest: begin to connect to " + str);
            Socket socket = new Socket();
            socket.connect(ct.m336a(str, 5222), 5000);
            socket.setTcpNoDelay(true);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            b.m182a("ConnectivityTest: connect to " + str + " in " + currentTimeMillis2);
            socket.close();
            return true;
        } catch (Throwable th) {
            b.d("ConnectivityTest: could not connect to:" + str + " exception: " + th.getClass().getSimpleName() + " description: " + th.getMessage());
            return false;
        }
    }
}
