package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ab;
import com.xiaomi.push.af;
import com.xiaomi.push.al;
import com.xiaomi.push.bm;
import com.xiaomi.push.bp;
import com.xiaomi.push.hn;
import com.xiaomi.push.i;
import com.xiaomi.push.it;
import com.xiaomi.push.r;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: Taobao */
public class ca {
    public static final Object a = new Object();

    /* renamed from: a  reason: collision with other field name */
    public static ArrayList<hn> f956a = new ArrayList<>();

    public static void a() {
        f956a.clear();
    }

    public static void a(Context context, hn hnVar) {
        if (bz.a(hnVar.e())) {
            al.a(context).a(new cb(context, hnVar));
        }
    }

    public static void a(hn hnVar) {
        if (f956a.size() > 10) {
            f956a.remove(0);
        }
        f956a.add(hnVar);
    }

    public static byte[] a(Context context) {
        String a2 = r.a(context).a("mipush", "td_key", "");
        if (TextUtils.isEmpty(a2)) {
            a2 = bp.a(20);
            r.a(context).m743a("mipush", "td_key", a2);
        }
        return a(a2);
    }

    private static byte[] a(String str) {
        byte[] copyOf = Arrays.copyOf(bm.m290a(str), 16);
        copyOf[0] = 68;
        copyOf[15] = 84;
        return copyOf;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:1:0x0005 */
    /* access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r7v13, types: [java.io.Closeable, java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARNING: Unknown variable types count: 3 */
    public static void c(Context context, hn hnVar) {
        Throwable th;
        ?? r0;
        String str;
        IOException e;
        ?? r02;
        Object obj;
        String str2;
        byte[] a2 = a(context);
        try {
            byte[] b = i.b(a2, it.a(hnVar));
            if (b == null || b.length < 1) {
                str2 = "TinyData write to cache file failed case encryption fail item:" + hnVar.d() + "  ts:" + System.currentTimeMillis();
            } else if (b.length > 10240) {
                str2 = "TinyData write to cache file failed case too much data content item:" + hnVar.d() + "  ts:" + System.currentTimeMillis();
            } else {
                ?? bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(context.getFilesDir(), "tiny_data.data"), true));
                try {
                    bufferedOutputStream.write(af.a(b.length));
                    bufferedOutputStream.write(b);
                    bufferedOutputStream.flush();
                    ab.a((Closeable) null);
                    ab.a((Closeable) bufferedOutputStream);
                    return;
                } catch (IOException e2) {
                    obj = bufferedOutputStream;
                    e = e2;
                    str = "TinyData write to cache file failed cause io exception item:" + hnVar.d();
                    r02 = obj;
                    b.a(str, e);
                    ab.a((Closeable) null);
                    ab.a((Closeable) r02);
                } catch (Exception e3) {
                    a2 = bufferedOutputStream;
                    e = e3;
                    str = "TinyData write to cache file  failed item:" + hnVar.d();
                    r02 = a2;
                    b.a(str, e);
                    ab.a((Closeable) null);
                    ab.a((Closeable) r02);
                } catch (Throwable th2) {
                    r0 = bufferedOutputStream;
                    th = th2;
                    ab.a((Closeable) null);
                    ab.a((Closeable) r0);
                    throw th;
                }
            }
            b.m182a(str2);
            ab.a((Closeable) null);
            ab.a((Closeable) null);
        } catch (IOException e4) {
            e = e4;
            obj = null;
            str = "TinyData write to cache file failed cause io exception item:" + hnVar.d();
            r02 = obj;
            b.a(str, e);
            ab.a((Closeable) null);
            ab.a((Closeable) r02);
        } catch (Exception e5) {
            e = e5;
            a2 = null;
            str = "TinyData write to cache file  failed item:" + hnVar.d();
            r02 = a2;
            b.a(str, e);
            ab.a((Closeable) null);
            ab.a((Closeable) r02);
        } catch (Throwable th3) {
            th = th3;
            r0 = a2;
            ab.a((Closeable) null);
            ab.a((Closeable) r0);
            throw th;
        }
    }
}
