package tb;

import android.content.Context;
import anet.channel.statist.StrategyStatObject;
import anet.channel.util.ALog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.UUID;

/* compiled from: Taobao */
public class t82 {
    private static File a;

    public static File a(String str) {
        Context c;
        if (a == null && (c = ss0.c()) != null) {
            a = c.getCacheDir();
        }
        return new File(a, str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0053, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0056, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0057, code lost:
        r10 = null;
        r11 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0053 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:8:0x0017] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006f A[Catch:{ all -> 0x0105 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0076 A[SYNTHETIC, Splitter:B:30:0x0076] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0109 A[SYNTHETIC, Splitter:B:66:0x0109] */
    public static synchronized void b(Serializable serializable, File file, StrategyStatObject strategyStatObject) {
        File file2;
        boolean z;
        boolean z2;
        FileOutputStream fileOutputStream;
        Exception e;
        synchronized (t82.class) {
            FileOutputStream fileOutputStream2 = null;
            if (serializable == null || file == null) {
                ALog.e("awcn.SerializeHelper", "persist fail. Invalid parameter", null, new Object[0]);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i = 1;
            try {
                file2 = a(UUID.randomUUID().toString().replace("-", ""));
                file2.createNewFile();
                file2.setReadable(true);
                fileOutputStream = new FileOutputStream(file2);
                try {
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(fileOutputStream));
                    objectOutputStream.writeObject(serializable);
                    objectOutputStream.flush();
                    objectOutputStream.close();
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused) {
                    }
                    z = true;
                } catch (Exception e2) {
                    e = e2;
                    try {
                        ALog.d("awcn.SerializeHelper", "persist fail. ", null, e, "file", file.getName());
                        if (strategyStatObject != null) {
                            strategyStatObject.appendErrorTrace("SerializeHelper.persist()", e);
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        z = false;
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        if (strategyStatObject != null) {
                        }
                        if (!z) {
                        }
                        try {
                            file2.delete();
                        } catch (Exception unused3) {
                            ALog.e("awcn.SerializeHelper", "delete failed.", null, new Object[0]);
                        }
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        fileOutputStream2 = fileOutputStream;
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException unused4) {
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
                ALog.d("awcn.SerializeHelper", "persist fail. ", null, e, "file", file.getName());
                if (strategyStatObject != null) {
                }
                if (fileOutputStream != null) {
                }
                z = false;
                long currentTimeMillis22 = System.currentTimeMillis() - currentTimeMillis;
                if (strategyStatObject != null) {
                }
                if (!z) {
                }
                file2.delete();
            } catch (Throwable th3) {
            }
            long currentTimeMillis222 = System.currentTimeMillis() - currentTimeMillis;
            if (strategyStatObject != null) {
                strategyStatObject.writeTempFilePath = String.valueOf(file2);
                strategyStatObject.writeStrategyFilePath = String.valueOf(file);
                strategyStatObject.isTempWriteSucceed = z ? 1 : 0;
                strategyStatObject.writeCostTime = currentTimeMillis222;
            }
            if (!z) {
                z2 = file2.renameTo(file);
                if (z2) {
                    ALog.f("awcn.SerializeHelper", "persist end.", null, "file", file.getAbsoluteFile(), "size", Long.valueOf(file.length()), "cost", Long.valueOf(currentTimeMillis222));
                } else {
                    ALog.e("awcn.SerializeHelper", "rename failed.", null, new Object[0]);
                }
                if (strategyStatObject != null) {
                    strategyStatObject.isRenameSucceed = z2 ? 1 : 0;
                    if (!z2) {
                        i = 0;
                    }
                    strategyStatObject.isSucceed = i;
                    w6.b().commitStat(strategyStatObject);
                }
            } else {
                z2 = false;
            }
            if (!z || !z2) {
                file2.delete();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b1, code lost:
        if (r4 != null) goto L_0x008e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a0 A[Catch:{ all -> 0x00b6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ac A[Catch:{ all -> 0x00b6 }] */
    public static synchronized <T> T c(File file, StrategyStatObject strategyStatObject) {
        T t;
        Throwable th;
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;
        synchronized (t82.class) {
            if (strategyStatObject != null) {
                strategyStatObject.readStrategyFilePath = String.valueOf(file);
            }
            try {
                if (!file.exists()) {
                    if (ALog.g(3)) {
                        ALog.k("awcn.SerializeHelper", "file not exist.", null, "file", file.getName());
                    }
                    return null;
                }
                if (strategyStatObject != null) {
                    strategyStatObject.isFileExists = 1;
                }
                long currentTimeMillis = System.currentTimeMillis();
                fileInputStream = new FileInputStream(file);
                try {
                    objectInputStream = new ObjectInputStream(new BufferedInputStream(fileInputStream));
                    t = (T) objectInputStream.readObject();
                } catch (Throwable th2) {
                    th = th2;
                    t = null;
                    try {
                        if (ALog.g(3)) {
                        }
                        if (strategyStatObject != null) {
                        }
                    } catch (Throwable th3) {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th3;
                    }
                }
                try {
                    objectInputStream.close();
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    if (strategyStatObject != null) {
                        strategyStatObject.isReadObjectSucceed = 1;
                        strategyStatObject.readCostTime = currentTimeMillis2;
                    }
                    ALog.f("awcn.SerializeHelper", "restore end.", null, "file", file.getAbsoluteFile(), "size", Long.valueOf(file.length()), "cost", Long.valueOf(currentTimeMillis2));
                } catch (Throwable th4) {
                    th = th4;
                    if (ALog.g(3)) {
                        ALog.j("awcn.SerializeHelper", "restore file fail.", null, th, new Object[0]);
                    }
                    if (strategyStatObject != null) {
                        strategyStatObject.appendErrorTrace("SerializeHelper.restore()", th);
                    }
                }
                try {
                    fileInputStream.close();
                } catch (IOException unused2) {
                }
                return t;
            } catch (Throwable th5) {
                th = th5;
                fileInputStream = null;
                t = null;
                if (ALog.g(3)) {
                }
                if (strategyStatObject != null) {
                }
            }
        }
    }
}
