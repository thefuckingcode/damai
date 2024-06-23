package com.xiaomi.push;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.clientreport.manager.a;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Arrays;
import java.util.List;

/* compiled from: Taobao */
public class bt {
    public static String a() {
        return Build.VERSION.getRELEASE() + "-" + Build.VERSION.INCREMENTAL;
    }

    public static String a(Context context) {
        String a = bw.a(context).a("sp_client_report_status", "sp_client_report_key", "");
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        String a2 = bp.a(20);
        bw.a(context).m301a("sp_client_report_status", "sp_client_report_key", a2);
        return a2;
    }

    public static void a(Context context, String str) {
        Intent intent = new Intent("com.xiaomi.xmsf.push.XMSF_UPLOAD_ACTIVE");
        intent.putExtra("pkgname", context.getPackageName());
        intent.putExtra("category", "category_client_report_data");
        intent.putExtra("name", "quality_support");
        intent.putExtra("data", str);
        context.sendBroadcast(intent, "com.xiaomi.xmsf.permission.USE_XMSF_UPLOAD");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00e4, code lost:
        if (r7 == null) goto L_0x00e9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0104  */
    public static void a(Context context, String str, String str2) {
        Throwable th;
        File file;
        RandomAccessFile randomAccessFile;
        Exception e;
        File externalFilesDir = context.getExternalFilesDir(str2);
        if (externalFilesDir != null) {
            if (!externalFilesDir.exists()) {
                externalFilesDir.mkdirs();
            }
            File externalFilesDir2 = context.getExternalFilesDir(str);
            if (externalFilesDir2 == null) {
                return;
            }
            if (!externalFilesDir2.exists()) {
                externalFilesDir2.mkdirs();
                return;
            }
            File[] listFiles = externalFilesDir2.listFiles(new bu());
            if (listFiles != null && listFiles.length > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                FileLock fileLock = null;
                RandomAccessFile randomAccessFile2 = null;
                File file2 = null;
                for (File file3 : listFiles) {
                    if (file3 != null) {
                        try {
                            if (!TextUtils.isEmpty(file3.getAbsolutePath())) {
                                file = new File(file3.getAbsolutePath() + ".lock");
                                try {
                                    ab.m248a(file);
                                    randomAccessFile = new RandomAccessFile(file, "rw");
                                    try {
                                        fileLock = randomAccessFile.getChannel().lock();
                                        File file4 = new File(externalFilesDir.getAbsolutePath() + File.separator + file3.getName() + currentTimeMillis);
                                        try {
                                            ab.b(file3, file4);
                                        } catch (IOException e2) {
                                            e2.printStackTrace();
                                            file3.delete();
                                            file4.delete();
                                        }
                                        file3.delete();
                                        if (fileLock != null && fileLock.isValid()) {
                                            try {
                                                fileLock.release();
                                            } catch (IOException e3) {
                                                b.a(e3);
                                            }
                                        }
                                        ab.a(randomAccessFile);
                                    } catch (Exception e4) {
                                        e = e4;
                                        try {
                                            b.a(e);
                                            if (fileLock != null && fileLock.isValid()) {
                                                try {
                                                    fileLock.release();
                                                } catch (IOException e5) {
                                                    b.a(e5);
                                                }
                                            }
                                            ab.a(randomAccessFile);
                                        } catch (Throwable th2) {
                                            th = th2;
                                            randomAccessFile2 = randomAccessFile;
                                            file2 = file;
                                            try {
                                                fileLock.release();
                                            } catch (IOException e6) {
                                                b.a(e6);
                                            }
                                            ab.a(randomAccessFile2);
                                            if (file2 != null) {
                                            }
                                            throw th;
                                        }
                                    }
                                } catch (Exception e7) {
                                    randomAccessFile = randomAccessFile2;
                                    e = e7;
                                    b.a(e);
                                    fileLock.release();
                                    ab.a(randomAccessFile);
                                } catch (Throwable th3) {
                                    th = th3;
                                    file2 = file;
                                    fileLock.release();
                                    ab.a(randomAccessFile2);
                                    if (file2 != null) {
                                    }
                                    throw th;
                                }
                                file.delete();
                                randomAccessFile2 = randomAccessFile;
                                file2 = file;
                            }
                        } catch (Exception e8) {
                            file = file2;
                            randomAccessFile = randomAccessFile2;
                            e = e8;
                            b.a(e);
                            fileLock.release();
                            ab.a(randomAccessFile);
                        } catch (Throwable th4) {
                            th = th4;
                            if (fileLock != null && fileLock.isValid()) {
                                fileLock.release();
                            }
                            ab.a(randomAccessFile2);
                            if (file2 != null) {
                                file2.delete();
                            }
                            throw th;
                        }
                    }
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e9) {
                            b.a(e9);
                        }
                    }
                    ab.a(randomAccessFile2);
                    if (file2 != null) {
                        file2.delete();
                    }
                }
            }
        }
    }

    public static void a(Context context, List<String> list) {
        if (list != null && list.size() > 0 && m297a(context)) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    a(context, str);
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m297a(Context context) {
        try {
            return context.getApplicationContext().getPackageManager().getPackageInfo("com.xiaomi.xmsf", 0).versionCode >= 108;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m298a(Context context, String str) {
        File file = new File(str);
        long maxFileLength = a.a(context).m184a().getMaxFileLength();
        if (file.exists()) {
            try {
                if (file.length() > maxFileLength) {
                    return false;
                }
            } catch (Exception e) {
                b.a(e);
                return false;
            }
        } else {
            ab.m248a(file);
        }
        return true;
    }

    @TargetApi(9)
    public static byte[] a(String str) {
        byte[] copyOf = Arrays.copyOf(bm.m290a(str), 16);
        copyOf[0] = 68;
        copyOf[15] = 84;
        return copyOf;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static File[] m299a(Context context, String str) {
        File externalFilesDir = context.getExternalFilesDir(str);
        if (externalFilesDir != null) {
            return externalFilesDir.listFiles(new bv());
        }
        return null;
    }
}
