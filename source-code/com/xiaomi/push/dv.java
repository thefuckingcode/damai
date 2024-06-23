package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.al;
import com.xiaomi.push.service.ba;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class dv extends al.a {
    private Context a;

    /* renamed from: a  reason: collision with other field name */
    private SharedPreferences f225a;

    /* renamed from: a  reason: collision with other field name */
    private ba f226a;

    public dv(Context context) {
        this.a = context;
        this.f225a = context.getSharedPreferences("mipush_extra", 0);
        this.f226a = ba.a(context);
    }

    private List<hr> a(File file) {
        FileInputStream fileInputStream;
        RandomAccessFile randomAccessFile;
        Throwable th;
        FileLock lock;
        dm a2 = dn.a().m352a();
        String a3 = a2 == null ? "" : a2.a();
        FileLock fileLock = null;
        if (TextUtils.isEmpty(a3)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[4];
        synchronized (dq.a) {
            try {
                File file2 = new File(this.a.getExternalFilesDir(null), "push_cdata.lock");
                ab.m248a(file2);
                randomAccessFile = new RandomAccessFile(file2, "rw");
                try {
                    lock = randomAccessFile.getChannel().lock();
                } catch (Exception unused) {
                    fileInputStream = null;
                    try {
                        fileLock.release();
                    } catch (IOException unused2) {
                    }
                    ab.a(fileInputStream);
                    ab.a(randomAccessFile);
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = null;
                    try {
                        fileLock.release();
                    } catch (IOException unused3) {
                    }
                    ab.a(fileInputStream);
                    ab.a(randomAccessFile);
                    throw th;
                }
                try {
                    fileInputStream = new FileInputStream(file);
                    while (true) {
                        try {
                            if (fileInputStream.read(bArr) != 4) {
                                break;
                            }
                            int a4 = af.a(bArr);
                            byte[] bArr2 = new byte[a4];
                            if (fileInputStream.read(bArr2) != a4) {
                                break;
                            }
                            byte[] a5 = dp.a(a3, bArr2);
                            if (!(a5 == null || a5.length == 0)) {
                                hr hrVar = new hr();
                                it.a(hrVar, a5);
                                arrayList.add(hrVar);
                                a(hrVar);
                            }
                        } catch (Exception unused4) {
                            fileLock = lock;
                            if (fileLock != null && fileLock.isValid()) {
                                fileLock.release();
                            }
                            ab.a(fileInputStream);
                            ab.a(randomAccessFile);
                            return arrayList;
                        } catch (Throwable th3) {
                            th = th3;
                            fileLock = lock;
                            if (fileLock != null && fileLock.isValid()) {
                                fileLock.release();
                            }
                            ab.a(fileInputStream);
                            ab.a(randomAccessFile);
                            throw th;
                        }
                    }
                    if (lock != null) {
                        if (lock.isValid()) {
                            try {
                                lock.release();
                            } catch (IOException unused5) {
                            }
                        }
                    }
                    ab.a(fileInputStream);
                } catch (Exception unused6) {
                    fileInputStream = null;
                    fileLock = lock;
                    fileLock.release();
                    ab.a(fileInputStream);
                    ab.a(randomAccessFile);
                    return arrayList;
                } catch (Throwable th4) {
                    th = th4;
                    fileInputStream = null;
                    fileLock = lock;
                    fileLock.release();
                    ab.a(fileInputStream);
                    ab.a(randomAccessFile);
                    throw th;
                }
            } catch (Exception unused7) {
                randomAccessFile = null;
                fileInputStream = null;
                fileLock.release();
                ab.a(fileInputStream);
                ab.a(randomAccessFile);
                return arrayList;
            } catch (Throwable th5) {
                th = th5;
                randomAccessFile = null;
                fileInputStream = null;
                fileLock.release();
                ab.a(fileInputStream);
                ab.a(randomAccessFile);
                throw th;
            }
            ab.a(randomAccessFile);
        }
        return arrayList;
    }

    @Override // com.xiaomi.push.al.a
    private void a() {
        SharedPreferences.Editor edit = this.f225a.edit();
        edit.putLong("last_upload_data_timestamp", System.currentTimeMillis() / 1000);
        edit.commit();
    }

    private void a(hr hrVar) {
        if (hrVar.f488a == hl.AppInstallList && !hrVar.f489a.startsWith("same_")) {
            SharedPreferences.Editor edit = this.f225a.edit();
            edit.putLong("dc_job_result_time_4", hrVar.f487a);
            edit.putString("dc_job_result_4", bp.a(hrVar.f489a));
            edit.commit();
        }
    }

    @Override // com.xiaomi.push.al.a
    /* renamed from: a  reason: collision with other method in class */
    private boolean m358a() {
        if (bj.e(this.a)) {
            return false;
        }
        if ((bj.g(this.a) || bj.f(this.a)) && !c()) {
            return true;
        }
        return (bj.h(this.a) && !b()) || bj.i(this.a);
    }

    private boolean b() {
        if (!this.f226a.a(ho.Upload3GSwitch.a(), true)) {
            return false;
        }
        return Math.abs((System.currentTimeMillis() / 1000) - this.f225a.getLong("last_upload_data_timestamp", -1)) > ((long) Math.max(86400, this.f226a.a(ho.Upload3GFrequency.a(), 432000)));
    }

    private boolean c() {
        if (!this.f226a.a(ho.Upload4GSwitch.a(), true)) {
            return false;
        }
        return Math.abs((System.currentTimeMillis() / 1000) - this.f225a.getLong("last_upload_data_timestamp", -1)) > ((long) Math.max(86400, this.f226a.a(ho.Upload4GFrequency.a(), 259200)));
    }

    @Override // com.xiaomi.push.al.a
    /* renamed from: a  reason: collision with other method in class */
    public String m359a() {
        return "1";
    }

    public void run() {
        File file = new File(this.a.getExternalFilesDir(null), "push_cdata.data");
        if (!bj.d(this.a)) {
            if (file.length() > 1863680) {
                file.delete();
            }
        } else if (!m358a() && file.exists()) {
            List<hr> a2 = a(file);
            if (!ag.a(a2)) {
                int size = a2.size();
                if (size > 4000) {
                    a2 = a2.subList(size - 4000, size);
                }
                ic icVar = new ic();
                icVar.a(a2);
                byte[] a3 = ab.a(it.a(icVar));
                ii iiVar = new ii("-1", false);
                iiVar.c(ht.DataCollection.f497a);
                iiVar.a(a3);
                dm a4 = dn.a().m352a();
                if (a4 != null) {
                    a4.a(iiVar, hj.Notification, null);
                }
                a();
            }
            file.delete();
        }
    }
}
