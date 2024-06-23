package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ab;
import com.xiaomi.push.hn;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class cb implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ hn f957a;

    cb(Context context, hn hnVar) {
        this.a = context;
        this.f957a = hnVar;
    }

    public void run() {
        RandomAccessFile randomAccessFile;
        Throwable th;
        Exception e;
        synchronized (ca.a) {
            FileLock fileLock = null;
            try {
                File file = new File(this.a.getFilesDir(), "tiny_data.lock");
                ab.m248a(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                    ca.c(this.a, this.f957a);
                    if (fileLock != null) {
                        if (fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e2) {
                                b.a(e2);
                            }
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        b.a(e);
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e4) {
                                b.a(e4);
                            }
                        }
                        ab.a(randomAccessFile);
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            fileLock.release();
                        } catch (IOException e5) {
                            b.a(e5);
                        }
                        ab.a(randomAccessFile);
                        throw th;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                randomAccessFile = null;
                b.a(e);
                fileLock.release();
                ab.a(randomAccessFile);
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile = null;
                if (fileLock != null && fileLock.isValid()) {
                    fileLock.release();
                }
                ab.a(randomAccessFile);
                throw th;
            }
            ab.a(randomAccessFile);
        }
    }
}
