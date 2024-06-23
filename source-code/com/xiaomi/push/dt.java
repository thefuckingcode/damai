package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.al;
import com.xiaomi.push.service.ba;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* compiled from: Taobao */
public abstract class dt extends al.a {
    protected int a;

    /* renamed from: a  reason: collision with other field name */
    protected Context f224a;

    public dt(Context context, int i) {
        this.a = i;
        this.f224a = context;
    }

    public static void a(Context context, hr hrVar) {
        dm a2 = dn.a().m352a();
        String a3 = a2 == null ? "" : a2.a();
        if (!TextUtils.isEmpty(a3) && !TextUtils.isEmpty(hrVar.a())) {
            a(context, hrVar, a3);
        }
    }

    private static void a(Context context, hr hrVar, String str) {
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        RandomAccessFile randomAccessFile;
        IOException e;
        FileLock lock;
        byte[] b = dp.b(str, it.a(hrVar));
        if (b != null && b.length != 0) {
            synchronized (dq.a) {
                FileLock fileLock = null;
                try {
                    File file = new File(context.getExternalFilesDir(null), "push_cdata.lock");
                    ab.m248a(file);
                    randomAccessFile = new RandomAccessFile(file, "rw");
                    try {
                        lock = randomAccessFile.getChannel().lock();
                    } catch (IOException e2) {
                        e = e2;
                        bufferedOutputStream = null;
                        try {
                            e.printStackTrace();
                            try {
                                fileLock.release();
                            } catch (IOException unused) {
                            }
                            ab.a(bufferedOutputStream);
                            ab.a(randomAccessFile);
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                fileLock.release();
                            } catch (IOException unused2) {
                            }
                            ab.a(bufferedOutputStream);
                            ab.a(randomAccessFile);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedOutputStream = null;
                        fileLock.release();
                        ab.a(bufferedOutputStream);
                        ab.a(randomAccessFile);
                        throw th;
                    }
                    try {
                        File file2 = new File(context.getExternalFilesDir(null), "push_cdata.data");
                        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2, true));
                        try {
                            bufferedOutputStream.write(af.a(b.length));
                            bufferedOutputStream.write(b);
                            bufferedOutputStream.flush();
                            file2.setLastModified(0);
                            if (lock != null) {
                                if (lock.isValid()) {
                                    try {
                                        lock.release();
                                    } catch (IOException unused3) {
                                    }
                                }
                            }
                            ab.a(bufferedOutputStream);
                        } catch (IOException e3) {
                            e = e3;
                            fileLock = lock;
                            e.printStackTrace();
                            if (fileLock != null && fileLock.isValid()) {
                                fileLock.release();
                            }
                            ab.a(bufferedOutputStream);
                            ab.a(randomAccessFile);
                        } catch (Throwable th4) {
                            th = th4;
                            fileLock = lock;
                            if (fileLock != null && fileLock.isValid()) {
                                fileLock.release();
                            }
                            ab.a(bufferedOutputStream);
                            ab.a(randomAccessFile);
                            throw th;
                        }
                    } catch (IOException e4) {
                        e = e4;
                        bufferedOutputStream = null;
                        fileLock = lock;
                        e.printStackTrace();
                        fileLock.release();
                        ab.a(bufferedOutputStream);
                        ab.a(randomAccessFile);
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedOutputStream = null;
                        fileLock = lock;
                        fileLock.release();
                        ab.a(bufferedOutputStream);
                        ab.a(randomAccessFile);
                        throw th;
                    }
                } catch (IOException e5) {
                    e = e5;
                    bufferedOutputStream = null;
                    randomAccessFile = null;
                    e.printStackTrace();
                    fileLock.release();
                    ab.a(bufferedOutputStream);
                    ab.a(randomAccessFile);
                } catch (Throwable th6) {
                    th = th6;
                    bufferedOutputStream = null;
                    randomAccessFile = null;
                    fileLock.release();
                    ab.a(bufferedOutputStream);
                    ab.a(randomAccessFile);
                    throw th;
                }
                ab.a(randomAccessFile);
            }
        }
    }

    private String c() {
        return "dc_job_result_time_" + a();
    }

    private String d() {
        return "dc_job_result_" + a();
    }

    @Override // com.xiaomi.push.al.a
    public abstract hl a();

    /* access modifiers changed from: protected */
    @Override // com.xiaomi.push.al.a
    /* renamed from: a  reason: collision with other method in class */
    public boolean m354a() {
        return dp.a(this.f224a, String.valueOf(a()), (long) this.a);
    }

    public abstract String b();

    /* access modifiers changed from: protected */
    /* renamed from: b  reason: collision with other method in class */
    public boolean m355b() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c  reason: collision with other method in class */
    public boolean m356c() {
        return false;
    }

    public void run() {
        String b = b();
        if (!TextUtils.isEmpty(b)) {
            if (m354a()) {
                b.m182a("DC run job mutual: " + a());
                return;
            }
            dm a2 = dn.a().m352a();
            String a3 = a2 == null ? "" : a2.a();
            if (!TextUtils.isEmpty(a3) && m355b()) {
                if (m356c()) {
                    SharedPreferences sharedPreferences = this.f224a.getSharedPreferences("mipush_extra", 0);
                    if (bp.a(b).equals(sharedPreferences.getString(d(), null))) {
                        long j = sharedPreferences.getLong(c(), 0);
                        int a4 = ba.a(this.f224a).a(ho.DCJobUploadRepeatedInterval.a(), 604800);
                        if ((System.currentTimeMillis() - j) / 1000 >= ((long) this.a)) {
                            if ((System.currentTimeMillis() - j) / 1000 < ((long) a4)) {
                                b = "same_" + j;
                            }
                        } else {
                            return;
                        }
                    }
                }
                hr hrVar = new hr();
                hrVar.a(b);
                hrVar.a(System.currentTimeMillis());
                hrVar.a(a());
                a(this.f224a, hrVar, a3);
            }
        }
    }
}
