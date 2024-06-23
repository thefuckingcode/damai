package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.ca;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;

/* compiled from: Taobao */
public class he {
    private static boolean a;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a implements Runnable {
        private Context a;

        /* renamed from: a  reason: collision with other field name */
        private hh f456a;

        public a(Context context, hh hhVar) {
            this.f456a = hhVar;
            this.a = context;
        }

        public void run() {
            he.c(this.a, this.f456a);
        }
    }

    private static void a(Context context) {
        File file = new File(context.getFilesDir() + "/tdReadTemp");
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static void a(Context context, hh hhVar) {
        al.a(context).a(new a(context, hhVar));
    }

    private static void a(Context context, hh hhVar, File file, byte[] bArr) {
        Throwable th;
        Exception e;
        String str;
        int a2;
        ArrayList arrayList = new ArrayList();
        byte[] bArr2 = new byte[4];
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            loop0:
            while (true) {
                int i = 0;
                int i2 = 0;
                while (true) {
                    try {
                        int read = bufferedInputStream2.read(bArr2);
                        if (read == -1) {
                            break loop0;
                        } else if (read != 4) {
                            str = "TinyData read from cache file failed cause lengthBuffer error. size:" + read;
                            break loop0;
                        } else {
                            a2 = af.a(bArr2);
                            if (a2 < 1) {
                                break loop0;
                            } else if (a2 > 10240) {
                                break loop0;
                            } else {
                                byte[] bArr3 = new byte[a2];
                                int read2 = bufferedInputStream2.read(bArr3);
                                if (read2 != a2) {
                                    str = "TinyData read from cache file failed cause buffer size not equal length. size:" + read2 + "__length:" + a2;
                                    break loop0;
                                }
                                byte[] a3 = i.a(bArr, bArr3);
                                if (a3 != null) {
                                    if (a3.length != 0) {
                                        hn hnVar = new hn();
                                        it.a(hnVar, a3);
                                        hnVar.a("item_size", String.valueOf(a3.length));
                                        arrayList.add(hnVar);
                                        i++;
                                        i2 += a3.length;
                                        if (i >= 8 || i2 >= 10240) {
                                            hf.a(context, hhVar, arrayList);
                                            arrayList.clear();
                                        }
                                    }
                                }
                                b.d("TinyData read from cache file failed cause decrypt fail");
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        bufferedInputStream = bufferedInputStream2;
                        try {
                            b.a(e);
                            ab.a(bufferedInputStream);
                        } catch (Throwable th2) {
                            th = th2;
                            ab.a(bufferedInputStream);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedInputStream = bufferedInputStream2;
                        ab.a(bufferedInputStream);
                        throw th;
                    }
                }
            }
            str = "TinyData read from cache file failed cause lengthBuffer < 1 || too big. length:" + a2;
            b.d(str);
            hf.a(context, hhVar, arrayList);
            if (file != null && file.exists() && !file.delete()) {
                b.m182a("TinyData delete reading temp file failed");
            }
            ab.a(bufferedInputStream2);
        } catch (Exception e3) {
            e = e3;
            b.a(e);
            ab.a(bufferedInputStream);
        }
    }

    private static void b(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 4).edit();
        edit.putLong("last_tiny_data_upload_timestamp", System.currentTimeMillis() / 1000);
        edit.commit();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00bd  */
    public static void c(Context context, hh hhVar) {
        Throwable th;
        RandomAccessFile randomAccessFile;
        File file;
        IOException e;
        Exception e2;
        if (!a) {
            a = true;
            File file2 = new File(context.getFilesDir(), "tiny_data.data");
            if (!file2.exists()) {
                b.m182a("TinyData no ready file to get data.");
                return;
            }
            a(context);
            byte[] a2 = ca.a(context);
            FileLock fileLock = null;
            try {
                File file3 = new File(context.getFilesDir(), "tiny_data.lock");
                ab.m248a(file3);
                randomAccessFile = new RandomAccessFile(file3, "rw");
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                    file2.renameTo(new File(context.getFilesDir() + "/tdReadTemp" + "/" + "tiny_data.data"));
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e3) {
                            e = e3;
                        }
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    try {
                        b.a(e2);
                        try {
                            fileLock.release();
                        } catch (IOException e5) {
                            e = e5;
                        }
                        ab.a(randomAccessFile);
                        file = new File(context.getFilesDir() + "/tdReadTemp" + "/" + "tiny_data.data");
                        if (file.exists()) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            fileLock.release();
                        } catch (IOException e6) {
                            b.a(e6);
                        }
                        ab.a(randomAccessFile);
                        throw th;
                    }
                }
            } catch (Exception e7) {
                e2 = e7;
                randomAccessFile = null;
                b.a(e2);
                if (fileLock != null && fileLock.isValid()) {
                    fileLock.release();
                }
                ab.a(randomAccessFile);
                file = new File(context.getFilesDir() + "/tdReadTemp" + "/" + "tiny_data.data");
                if (file.exists()) {
                }
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
            file = new File(context.getFilesDir() + "/tdReadTemp" + "/" + "tiny_data.data");
            if (file.exists()) {
                b.m182a("TinyData no ready file to get data.");
                return;
            }
            a(context, hhVar, file, a2);
            hd.a(false);
            b(context);
            a = false;
            return;
        }
        b.m182a("TinyData extractTinyData is running");
        return;
        b.a(e);
        ab.a(randomAccessFile);
        file = new File(context.getFilesDir() + "/tdReadTemp" + "/" + "tiny_data.data");
        if (file.exists()) {
        }
    }
}
