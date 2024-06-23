package com.taobao.orange.util;

import com.taobao.orange.GlobalOrange;
import com.taobao.orange.OConstant;
import com.taobao.orange.model.CheckDO;
import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: Taobao */
public class FileUtil {
    public static final String ORANGE_DIR = "orange_config";
    private static final String TAG = "FileUtil";
    public static AtomicLong ioTime = new AtomicLong(0);
    public static AtomicInteger persistCount = new AtomicInteger(0);
    public static AtomicLong persistTime = new AtomicLong(0);
    public static AtomicInteger restoreCount = new AtomicInteger(0);
    public static AtomicLong restoreTime = new AtomicLong(0);
    private static File targetDir = getTargetDir();

    private static void cleanDir(File file) {
        if (file != null && file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    file2.delete();
                } else if (file2.isDirectory()) {
                    cleanDir(file2);
                }
            }
        }
    }

    public static void clearCacheFile() {
        OLog.i(TAG, "clearCacheFile", new Object[0]);
        cleanDir(targetDir);
    }

    public static void deleteConfigFile(String str) {
        File file = new File(targetDir, str);
        if (file.exists()) {
            boolean delete = file.delete();
            if (OLog.isPrintLog(1)) {
                OLog.d(TAG, "deleteConfigFile", "filename", str, "result", Boolean.valueOf(delete));
            }
        }
    }

    public static File getOrangeConfigDir() {
        return targetDir;
    }

    private static File getTargetDir() {
        Throwable th;
        File file = null;
        try {
            File file2 = new File(new File(GlobalOrange.context.getFilesDir(), ORANGE_DIR), GlobalOrange.env.getDes());
            try {
                if (file2.exists() && file2.isFile() && !file2.delete()) {
                    OLog.w(TAG, "getTargetDir target dir delete fail", new Object[0]);
                }
                if (!file2.exists() && !file2.mkdirs()) {
                    OLog.w(TAG, "getTargetDir mkdirs fail", new Object[0]);
                    OrangeMonitor.commitFail(OConstant.MONITOR_MODULE, OConstant.POINT_EXCEPTION, "getTargetDir", OConstant.CODE_POINT_EXP_GET_TARGET_DIR, "getTargetDir mkdirs fail");
                }
                OLog.d(TAG, "getTargetDir", file2.getAbsolutePath());
                return file2;
            } catch (Throwable th2) {
                th = th2;
                file = file2;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                th.printStackTrace(new PrintStream(byteArrayOutputStream));
                OrangeMonitor.commitFail(OConstant.MONITOR_MODULE, OConstant.POINT_EXCEPTION, "0", OConstant.CODE_POINT_EXP_GET_TARGET_DIR, byteArrayOutputStream.toString());
                return file;
            }
        } catch (Throwable th3) {
            th = th3;
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            th.printStackTrace(new PrintStream(byteArrayOutputStream2));
            OrangeMonitor.commitFail(OConstant.MONITOR_MODULE, OConstant.POINT_EXCEPTION, "0", OConstant.CODE_POINT_EXP_GET_TARGET_DIR, byteArrayOutputStream2.toString());
            return file;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:62:0x00fc A[SYNTHETIC, Splitter:B:62:0x00fc] */
    public static void persistObject(Object obj, String str) {
        File file;
        ObjectOutputStream objectOutputStream;
        Throwable th;
        FileOutputStream fileOutputStream;
        if (GlobalOrange.processIsolated) {
            persistObjectLocked(obj, str);
            return;
        }
        if (OLog.isPrintLog(1)) {
            OLog.d(TAG, "persistObject", "filename", str);
        }
        long currentTimeMillis = System.currentTimeMillis();
        FileOutputStream fileOutputStream2 = null;
        try {
            file = File.createTempFile(str, ".tmp", targetDir);
            try {
                FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                try {
                    objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(fileOutputStream3));
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream3;
                    objectOutputStream = null;
                    fileOutputStream2 = fileOutputStream;
                    try {
                        OLog.e(TAG, "persistObject", th, new Object[0]);
                        OrangeUtils.close(objectOutputStream);
                        OrangeUtils.close(fileOutputStream2);
                        if (file != null) {
                        }
                        OrangeMonitor.commitCount(OConstant.MONITOR_PRIVATE_MODULE, OConstant.POINT_PERSIST_FAIL_COUNTS, str, 1.0d);
                        OrangeMonitor.commitFileStatMonitor(str, false, false, 1, (double) (System.currentTimeMillis() - currentTimeMillis));
                        return;
                    } catch (Throwable th3) {
                        OLog.e(TAG, "persistObject temp file delete cause exception", th3, new Object[0]);
                    }
                }
                try {
                    objectOutputStream.writeObject(obj);
                    objectOutputStream.flush();
                    if (!file.renameTo(new File(targetDir, str))) {
                        try {
                            OLog.w(TAG, "persistObject rename fail", str);
                            OrangeUtils.close(objectOutputStream);
                            OrangeUtils.close(fileOutputStream3);
                            try {
                                if (file.exists() && !file.delete()) {
                                    OLog.w(TAG, "persistObject temp file delete fail", new Object[0]);
                                }
                            } catch (Throwable th4) {
                                OLog.e(TAG, "persistObject temp file delete cause exception", th4, new Object[0]);
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            fileOutputStream2 = fileOutputStream3;
                            OLog.e(TAG, "persistObject", th, new Object[0]);
                            OrangeUtils.close(objectOutputStream);
                            OrangeUtils.close(fileOutputStream2);
                            if (file != null) {
                                try {
                                    if (file.exists() && !file.delete()) {
                                        OLog.w(TAG, "persistObject temp file delete fail", new Object[0]);
                                    }
                                } catch (Throwable th6) {
                                    OLog.e(TAG, "persistObject temp file delete cause exception", th6, new Object[0]);
                                }
                            }
                            OrangeMonitor.commitCount(OConstant.MONITOR_PRIVATE_MODULE, OConstant.POINT_PERSIST_FAIL_COUNTS, str, 1.0d);
                            OrangeMonitor.commitFileStatMonitor(str, false, false, 1, (double) (System.currentTimeMillis() - currentTimeMillis));
                            return;
                        }
                        OrangeMonitor.commitCount(OConstant.MONITOR_PRIVATE_MODULE, OConstant.POINT_PERSIST_FAIL_COUNTS, str, 1.0d);
                        OrangeMonitor.commitFileStatMonitor(str, false, false, 1, (double) (System.currentTimeMillis() - currentTimeMillis));
                        return;
                    }
                    if (!OrangeMonitor.mPerformanceInfoRecordDone) {
                        persistCount.incrementAndGet();
                        persistTime.addAndGet(System.currentTimeMillis() - currentTimeMillis);
                        ioTime.addAndGet(System.currentTimeMillis() - currentTimeMillis);
                    }
                    try {
                        OrangeMonitor.commitFileStatMonitor(str, true, false, 1, (double) (System.currentTimeMillis() - currentTimeMillis));
                        OrangeUtils.close(objectOutputStream);
                        OrangeUtils.close(fileOutputStream3);
                        try {
                            if (file.exists() && !file.delete()) {
                                OLog.w(TAG, "persistObject temp file delete fail", new Object[0]);
                                return;
                            }
                            return;
                        } catch (Throwable th7) {
                            OLog.e(TAG, "persistObject temp file delete cause exception", th7, new Object[0]);
                            return;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        fileOutputStream2 = fileOutputStream3;
                        objectOutputStream = objectOutputStream;
                        OLog.e(TAG, "persistObject", th, new Object[0]);
                        OrangeUtils.close(objectOutputStream);
                        OrangeUtils.close(fileOutputStream2);
                        if (file != null) {
                        }
                        OrangeMonitor.commitCount(OConstant.MONITOR_PRIVATE_MODULE, OConstant.POINT_PERSIST_FAIL_COUNTS, str, 1.0d);
                        OrangeMonitor.commitFileStatMonitor(str, false, false, 1, (double) (System.currentTimeMillis() - currentTimeMillis));
                        return;
                    }
                } catch (Throwable th9) {
                    th = th9;
                    fileOutputStream = fileOutputStream3;
                    fileOutputStream2 = fileOutputStream;
                    OLog.e(TAG, "persistObject", th, new Object[0]);
                    OrangeUtils.close(objectOutputStream);
                    OrangeUtils.close(fileOutputStream2);
                    if (file != null) {
                    }
                    OrangeMonitor.commitCount(OConstant.MONITOR_PRIVATE_MODULE, OConstant.POINT_PERSIST_FAIL_COUNTS, str, 1.0d);
                    OrangeMonitor.commitFileStatMonitor(str, false, false, 1, (double) (System.currentTimeMillis() - currentTimeMillis));
                    return;
                }
            } catch (Throwable th10) {
                th = th10;
                objectOutputStream = null;
                OLog.e(TAG, "persistObject", th, new Object[0]);
                OrangeUtils.close(objectOutputStream);
                OrangeUtils.close(fileOutputStream2);
                if (file != null) {
                }
                OrangeMonitor.commitCount(OConstant.MONITOR_PRIVATE_MODULE, OConstant.POINT_PERSIST_FAIL_COUNTS, str, 1.0d);
                OrangeMonitor.commitFileStatMonitor(str, false, false, 1, (double) (System.currentTimeMillis() - currentTimeMillis));
                return;
            }
        } catch (Throwable th11) {
            th = th11;
            objectOutputStream = null;
            file = null;
            OLog.e(TAG, "persistObject", th, new Object[0]);
            OrangeUtils.close(objectOutputStream);
            OrangeUtils.close(fileOutputStream2);
            if (file != null) {
            }
            OrangeMonitor.commitCount(OConstant.MONITOR_PRIVATE_MODULE, OConstant.POINT_PERSIST_FAIL_COUNTS, str, 1.0d);
            OrangeMonitor.commitFileStatMonitor(str, false, false, 1, (double) (System.currentTimeMillis() - currentTimeMillis));
            return;
        }
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r20v0, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r19v3 */
    /* JADX WARN: Type inference failed for: r19v4 */
    /* JADX WARN: Type inference failed for: r19v5 */
    /* JADX WARN: Type inference failed for: r19v7 */
    /* JADX WARN: Type inference failed for: r19v8 */
    /* JADX WARN: Type inference failed for: r19v10, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r20v10 */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0184 A[SYNTHETIC, Splitter:B:84:0x0184] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01a4 A[SYNTHETIC, Splitter:B:90:0x01a4] */
    public static void persistObjectLocked(Object obj, String str) {
        File file;
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;
        FileOutputStream fileOutputStream2;
        FileChannel fileChannel;
        String str2;
        Throwable th;
        int i;
        Throwable th2;
        int i2;
        Throwable th3;
        FileLock lock;
        FileOutputStream fileOutputStream3;
        File createTempFile;
        String str3;
        FileOutputStream fileOutputStream4;
        String str4;
        int i3;
        Throwable th4;
        if (OLog.isPrintLog(1)) {
            OLog.d(TAG, "persistObjectLocked", "filename", str);
        }
        long currentTimeMillis = System.currentTimeMillis();
        FileLock fileLock = null;
        try {
            File file2 = new File(targetDir, str);
            FileOutputStream fileOutputStream5 = new FileOutputStream(file2);
            try {
                fileChannel = fileOutputStream5.getChannel();
                try {
                    lock = fileChannel.lock();
                    try {
                        createTempFile = File.createTempFile(str, ".tmp", targetDir);
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream2 = fileOutputStream5;
                        str2 = TAG;
                        objectOutputStream = null;
                        fileOutputStream3 = null;
                        file = null;
                        fileLock = lock;
                        fileOutputStream = fileOutputStream3;
                        try {
                            OLog.e(str2, "persistObject", th, new Object[0]);
                            if (fileLock != null) {
                            }
                            OrangeUtils.close(fileOutputStream2);
                            OrangeUtils.close(fileChannel);
                            OrangeUtils.close(objectOutputStream);
                            OrangeUtils.close(fileOutputStream);
                            if (file != null) {
                            }
                            OrangeMonitor.commitCount(OConstant.MONITOR_PRIVATE_MODULE, OConstant.POINT_PERSIST_FAIL_COUNTS, str, 1.0d);
                            OrangeMonitor.commitFileStatMonitor(str, false, true, 1, (double) (System.currentTimeMillis() - currentTimeMillis));
                            return;
                        } catch (Throwable th6) {
                            th2 = th6;
                            OLog.e(str2, "persistObject temp file delete cause exception", th2, new Object[i]);
                            throw th;
                        }
                    }
                } catch (Throwable th7) {
                    th = th7;
                    fileOutputStream2 = fileOutputStream5;
                    str2 = TAG;
                    objectOutputStream = null;
                    ObjectOutputStream objectOutputStream2 = objectOutputStream;
                    file = objectOutputStream2;
                    fileOutputStream = objectOutputStream2;
                    OLog.e(str2, "persistObject", th, new Object[0]);
                    if (fileLock != null) {
                    }
                    OrangeUtils.close(fileOutputStream2);
                    OrangeUtils.close(fileChannel);
                    OrangeUtils.close(objectOutputStream);
                    OrangeUtils.close(fileOutputStream);
                    if (file != null) {
                    }
                    OrangeMonitor.commitCount(OConstant.MONITOR_PRIVATE_MODULE, OConstant.POINT_PERSIST_FAIL_COUNTS, str, 1.0d);
                    OrangeMonitor.commitFileStatMonitor(str, false, true, 1, (double) (System.currentTimeMillis() - currentTimeMillis));
                    return;
                }
            } catch (Throwable th8) {
                th = th8;
                fileOutputStream2 = fileOutputStream5;
                str2 = TAG;
                fileChannel = null;
                objectOutputStream = null;
                ObjectOutputStream objectOutputStream22 = objectOutputStream;
                file = objectOutputStream22;
                fileOutputStream = objectOutputStream22;
                OLog.e(str2, "persistObject", th, new Object[0]);
                if (fileLock != null) {
                    try {
                        fileLock.release();
                    } catch (Throwable th9) {
                        OLog.e(str2, "persistObjectLocked release lock failed", th9.toString());
                    }
                }
                OrangeUtils.close(fileOutputStream2);
                OrangeUtils.close(fileChannel);
                OrangeUtils.close(objectOutputStream);
                OrangeUtils.close(fileOutputStream);
                if (file != null) {
                    try {
                        if (file.exists() && !file.delete()) {
                            i2 = 0;
                            try {
                                OLog.w(str2, "persistObject temp file delete fail", new Object[0]);
                            } catch (Throwable th10) {
                                th3 = th10;
                                OLog.e(str2, "persistObject temp file delete cause exception", th3, new Object[i2]);
                                OrangeMonitor.commitCount(OConstant.MONITOR_PRIVATE_MODULE, OConstant.POINT_PERSIST_FAIL_COUNTS, str, 1.0d);
                                OrangeMonitor.commitFileStatMonitor(str, false, true, 1, (double) (System.currentTimeMillis() - currentTimeMillis));
                                return;
                            }
                        }
                    } catch (Throwable th11) {
                        th3 = th11;
                        i2 = 0;
                        OLog.e(str2, "persistObject temp file delete cause exception", th3, new Object[i2]);
                        OrangeMonitor.commitCount(OConstant.MONITOR_PRIVATE_MODULE, OConstant.POINT_PERSIST_FAIL_COUNTS, str, 1.0d);
                        OrangeMonitor.commitFileStatMonitor(str, false, true, 1, (double) (System.currentTimeMillis() - currentTimeMillis));
                        return;
                    }
                }
                OrangeMonitor.commitCount(OConstant.MONITOR_PRIVATE_MODULE, OConstant.POINT_PERSIST_FAIL_COUNTS, str, 1.0d);
                OrangeMonitor.commitFileStatMonitor(str, false, true, 1, (double) (System.currentTimeMillis() - currentTimeMillis));
                return;
            }
            try {
                FileOutputStream fileOutputStream6 = new FileOutputStream(createTempFile);
                try {
                    ObjectOutputStream objectOutputStream3 = new ObjectOutputStream(new BufferedOutputStream(fileOutputStream6));
                    try {
                        objectOutputStream3.writeObject(obj);
                        objectOutputStream3.flush();
                        if (!createTempFile.renameTo(file2)) {
                            OLog.w(TAG, "persistObject rename fail", str);
                            if (lock != null) {
                                try {
                                    lock.release();
                                } catch (Throwable th12) {
                                    OLog.e(TAG, "persistObjectLocked release lock failed", th12.toString());
                                }
                            }
                            OrangeUtils.close(fileOutputStream5);
                            OrangeUtils.close(fileChannel);
                            OrangeUtils.close(objectOutputStream3);
                            OrangeUtils.close(fileOutputStream6);
                            try {
                                if (createTempFile.exists() && !createTempFile.delete()) {
                                    OLog.w(TAG, "persistObject temp file delete fail", new Object[0]);
                                }
                            } catch (Throwable th13) {
                                OLog.e(TAG, "persistObject temp file delete cause exception", th13, new Object[0]);
                            }
                            OrangeMonitor.commitCount(OConstant.MONITOR_PRIVATE_MODULE, OConstant.POINT_PERSIST_FAIL_COUNTS, str, 1.0d);
                            OrangeMonitor.commitFileStatMonitor(str, false, true, 1, (double) (System.currentTimeMillis() - currentTimeMillis));
                            return;
                        }
                        if (!OrangeMonitor.mPerformanceInfoRecordDone) {
                            persistCount.incrementAndGet();
                            persistTime.addAndGet(System.currentTimeMillis() - currentTimeMillis);
                            ioTime.addAndGet(System.currentTimeMillis() - currentTimeMillis);
                            long currentTimeMillis2 = System.currentTimeMillis();
                            str3 = TAG;
                            double d = (double) (currentTimeMillis2 - currentTimeMillis);
                            objectOutputStream = objectOutputStream3;
                            fileOutputStream4 = fileOutputStream6;
                            fileOutputStream2 = fileOutputStream5;
                            file = createTempFile;
                            try {
                                OrangeMonitor.commitFileStatMonitor(str, true, true, 1, d);
                            } catch (Throwable th14) {
                                th = th14;
                                fileLock = lock;
                                str2 = str3;
                                fileOutputStream = fileOutputStream4;
                            }
                        } else {
                            objectOutputStream = objectOutputStream3;
                            fileOutputStream4 = fileOutputStream6;
                            fileOutputStream2 = fileOutputStream5;
                            file = createTempFile;
                            str3 = TAG;
                        }
                        if (lock != null) {
                            try {
                                lock.release();
                            } catch (Throwable th15) {
                                str4 = str3;
                                OLog.e(str4, "persistObjectLocked release lock failed", th15.toString());
                            }
                        }
                        str4 = str3;
                        OrangeUtils.close(fileOutputStream2);
                        OrangeUtils.close(fileChannel);
                        OrangeUtils.close(objectOutputStream);
                        OrangeUtils.close(fileOutputStream4);
                        try {
                            if (file.exists() && !file.delete()) {
                                i3 = 0;
                                try {
                                    OLog.w(str4, "persistObject temp file delete fail", new Object[0]);
                                    return;
                                } catch (Throwable th16) {
                                    th4 = th16;
                                    OLog.e(str4, "persistObject temp file delete cause exception", th4, new Object[i3]);
                                    return;
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable th17) {
                            th4 = th17;
                            i3 = 0;
                            OLog.e(str4, "persistObject temp file delete cause exception", th4, new Object[i3]);
                            return;
                        }
                    } catch (Throwable th18) {
                        th = th18;
                        objectOutputStream = objectOutputStream3;
                        fileOutputStream3 = fileOutputStream6;
                        fileOutputStream2 = fileOutputStream5;
                        file = createTempFile;
                        str2 = TAG;
                        fileLock = lock;
                        fileOutputStream = fileOutputStream3;
                        OLog.e(str2, "persistObject", th, new Object[0]);
                        if (fileLock != null) {
                        }
                        OrangeUtils.close(fileOutputStream2);
                        OrangeUtils.close(fileChannel);
                        OrangeUtils.close(objectOutputStream);
                        OrangeUtils.close(fileOutputStream);
                        if (file != null) {
                        }
                        OrangeMonitor.commitCount(OConstant.MONITOR_PRIVATE_MODULE, OConstant.POINT_PERSIST_FAIL_COUNTS, str, 1.0d);
                        OrangeMonitor.commitFileStatMonitor(str, false, true, 1, (double) (System.currentTimeMillis() - currentTimeMillis));
                        return;
                    }
                } catch (Throwable th19) {
                    th = th19;
                    fileOutputStream3 = fileOutputStream6;
                    fileOutputStream2 = fileOutputStream5;
                    file = createTempFile;
                    str2 = TAG;
                    objectOutputStream = null;
                    fileLock = lock;
                    fileOutputStream = fileOutputStream3;
                    OLog.e(str2, "persistObject", th, new Object[0]);
                    if (fileLock != null) {
                    }
                    OrangeUtils.close(fileOutputStream2);
                    OrangeUtils.close(fileChannel);
                    OrangeUtils.close(objectOutputStream);
                    OrangeUtils.close(fileOutputStream);
                    if (file != null) {
                    }
                    OrangeMonitor.commitCount(OConstant.MONITOR_PRIVATE_MODULE, OConstant.POINT_PERSIST_FAIL_COUNTS, str, 1.0d);
                    OrangeMonitor.commitFileStatMonitor(str, false, true, 1, (double) (System.currentTimeMillis() - currentTimeMillis));
                    return;
                }
            } catch (Throwable th20) {
                th = th20;
                fileOutputStream2 = fileOutputStream5;
                file = createTempFile;
                str2 = TAG;
                objectOutputStream = null;
                fileOutputStream3 = null;
                fileLock = lock;
                fileOutputStream = fileOutputStream3;
                OLog.e(str2, "persistObject", th, new Object[0]);
                if (fileLock != null) {
                }
                OrangeUtils.close(fileOutputStream2);
                OrangeUtils.close(fileChannel);
                OrangeUtils.close(objectOutputStream);
                OrangeUtils.close(fileOutputStream);
                if (file != null) {
                }
                OrangeMonitor.commitCount(OConstant.MONITOR_PRIVATE_MODULE, OConstant.POINT_PERSIST_FAIL_COUNTS, str, 1.0d);
                OrangeMonitor.commitFileStatMonitor(str, false, true, 1, (double) (System.currentTimeMillis() - currentTimeMillis));
                return;
            }
        } catch (Throwable th21) {
            th = th21;
            str2 = TAG;
            fileChannel = null;
            fileOutputStream2 = null;
            objectOutputStream = null;
            ObjectOutputStream objectOutputStream222 = objectOutputStream;
            file = objectOutputStream222;
            fileOutputStream = objectOutputStream222;
            OLog.e(str2, "persistObject", th, new Object[0]);
            if (fileLock != null) {
            }
            OrangeUtils.close(fileOutputStream2);
            OrangeUtils.close(fileChannel);
            OrangeUtils.close(objectOutputStream);
            OrangeUtils.close(fileOutputStream);
            if (file != null) {
            }
            OrangeMonitor.commitCount(OConstant.MONITOR_PRIVATE_MODULE, OConstant.POINT_PERSIST_FAIL_COUNTS, str, 1.0d);
            OrangeMonitor.commitFileStatMonitor(str, false, true, 1, (double) (System.currentTimeMillis() - currentTimeMillis));
            return;
        }
        OrangeUtils.close(fileOutputStream2);
        OrangeUtils.close(fileChannel);
        OrangeUtils.close(objectOutputStream);
        OrangeUtils.close(fileOutputStream);
        if (file != null) {
            if (file.exists() && !file.delete()) {
                i = 0;
                OLog.w(str2, "persistObject temp file delete fail", new Object[0]);
            }
        }
        throw th;
    }

    public static <T extends CheckDO> T restoreObject(String str) {
        FileInputStream fileInputStream;
        Throwable th;
        ObjectInputStream objectInputStream;
        Exception e;
        if (GlobalOrange.processIsolated) {
            return (T) restoreObjectLocked(str);
        }
        if (OLog.isPrintLog(1)) {
            OLog.d(TAG, "restoreObject", "filename", str);
        }
        long currentTimeMillis = System.currentTimeMillis();
        ObjectInputStream objectInputStream2 = null;
        try {
            File file = new File(targetDir, str);
            if (!file.exists()) {
                if (OLog.isPrintLog(3)) {
                    OLog.w(TAG, "restoreObject not exists", "filename", str);
                }
                OrangeUtils.close(null);
                OrangeUtils.close(null);
                return null;
            }
            fileInputStream = new FileInputStream(file);
            try {
                objectInputStream = new ObjectInputStream(new BufferedInputStream(fileInputStream));
                try {
                    T t = (T) ((CheckDO) objectInputStream.readObject());
                    if (t.checkValid()) {
                        if (!OrangeMonitor.mPerformanceInfoRecordDone) {
                            restoreCount.incrementAndGet();
                            restoreTime.addAndGet(System.currentTimeMillis() - currentTimeMillis);
                            ioTime.addAndGet(System.currentTimeMillis() - currentTimeMillis);
                            OrangeMonitor.commitFileStatMonitor(str, true, false, 0, (double) (System.currentTimeMillis() - currentTimeMillis));
                        }
                        OrangeUtils.close(objectInputStream);
                        OrangeUtils.close(fileInputStream);
                        return t;
                    }
                    throw new RuntimeException("check not vaild:" + str);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        OLog.e(TAG, "restoreObject", e, new Object[0]);
                        OrangeUtils.close(objectInputStream);
                        OrangeUtils.close(fileInputStream);
                        OrangeMonitor.commitCount(OConstant.MONITOR_PRIVATE_MODULE, OConstant.POINT_RESTORE_FAIL_COUNTS, str, 1.0d);
                        OrangeMonitor.commitFileStatMonitor(str, false, false, 0, (double) (System.currentTimeMillis() - currentTimeMillis));
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        objectInputStream2 = objectInputStream;
                        OrangeUtils.close(objectInputStream2);
                        OrangeUtils.close(fileInputStream);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                objectInputStream = null;
                OLog.e(TAG, "restoreObject", e, new Object[0]);
                OrangeUtils.close(objectInputStream);
                OrangeUtils.close(fileInputStream);
                OrangeMonitor.commitCount(OConstant.MONITOR_PRIVATE_MODULE, OConstant.POINT_RESTORE_FAIL_COUNTS, str, 1.0d);
                OrangeMonitor.commitFileStatMonitor(str, false, false, 0, (double) (System.currentTimeMillis() - currentTimeMillis));
                return null;
            } catch (Throwable th3) {
                th = th3;
                OrangeUtils.close(objectInputStream2);
                OrangeUtils.close(fileInputStream);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            fileInputStream = null;
            objectInputStream = null;
            OLog.e(TAG, "restoreObject", e, new Object[0]);
            OrangeUtils.close(objectInputStream);
            OrangeUtils.close(fileInputStream);
            OrangeMonitor.commitCount(OConstant.MONITOR_PRIVATE_MODULE, OConstant.POINT_RESTORE_FAIL_COUNTS, str, 1.0d);
            OrangeMonitor.commitFileStatMonitor(str, false, false, 0, (double) (System.currentTimeMillis() - currentTimeMillis));
            return null;
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            OrangeUtils.close(objectInputStream2);
            OrangeUtils.close(fileInputStream);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r16v10 */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0127 A[SYNTHETIC, Splitter:B:69:0x0127] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0161 A[SYNTHETIC, Splitter:B:79:0x0161] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static <T extends CheckDO> T restoreObjectLocked(String str) {
        FileChannel fileChannel;
        FileChannel fileChannel2;
        FileInputStream fileInputStream;
        Throwable th;
        FileLock fileLock;
        FileChannel fileChannel3;
        FileChannel fileChannel4;
        ?? r5;
        Exception e;
        FileLock fileLock2;
        FileChannel fileChannel5;
        FileChannel channel;
        Throwable th2;
        if (OLog.isPrintLog(1)) {
            OLog.d(TAG, "restoreObjectLocked", "filename", str);
        }
        long currentTimeMillis = System.currentTimeMillis();
        FileLock fileLock3 = null;
        try {
            File file = new File(targetDir, str);
            if (!file.exists()) {
                if (OLog.isPrintLog(3)) {
                    OLog.w(TAG, "restoreObject not exists", "filename", str);
                }
                OrangeUtils.close(null);
                OrangeUtils.close(null);
                OrangeUtils.close(null);
                return null;
            }
            fileInputStream = new FileInputStream(file);
            try {
                channel = fileInputStream.getChannel();
            } catch (Exception e2) {
                e = e2;
                r5 = null;
                fileLock2 = null;
                fileLock = fileLock2;
                fileChannel4 = fileLock2;
                try {
                    OLog.e(TAG, "restoreObject", e, new Object[0]);
                    if (fileLock != null) {
                    }
                    OrangeUtils.close(fileChannel4);
                    OrangeUtils.close(r5);
                    OrangeUtils.close(fileInputStream);
                    OrangeMonitor.commitCount(OConstant.MONITOR_PRIVATE_MODULE, OConstant.POINT_RESTORE_FAIL_COUNTS, str, 1.0d);
                    OrangeMonitor.commitFileStatMonitor(str, false, true, 0, (double) (System.currentTimeMillis() - currentTimeMillis));
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    fileChannel = r5;
                    fileChannel3 = fileChannel4;
                    fileLock3 = fileLock;
                    fileChannel2 = fileChannel3;
                    if (fileLock3 != null) {
                    }
                    OrangeUtils.close(fileChannel2);
                    OrangeUtils.close(fileChannel);
                    OrangeUtils.close(fileInputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                fileChannel5 = null;
                fileChannel = fileChannel5;
                fileChannel2 = fileChannel5;
                if (fileLock3 != null) {
                }
                OrangeUtils.close(fileChannel2);
                OrangeUtils.close(fileChannel);
                OrangeUtils.close(fileInputStream);
                throw th;
            }
            try {
                fileLock = channel.lock(0, AbsPerformance.LONG_NIL, true);
            } catch (Exception e3) {
                e = e3;
                r5 = null;
                fileLock = null;
                fileChannel4 = channel;
                OLog.e(TAG, "restoreObject", e, new Object[0]);
                if (fileLock != null) {
                }
                OrangeUtils.close(fileChannel4);
                OrangeUtils.close(r5);
                OrangeUtils.close(fileInputStream);
                OrangeMonitor.commitCount(OConstant.MONITOR_PRIVATE_MODULE, OConstant.POINT_RESTORE_FAIL_COUNTS, str, 1.0d);
                OrangeMonitor.commitFileStatMonitor(str, false, true, 0, (double) (System.currentTimeMillis() - currentTimeMillis));
                return null;
            } catch (Throwable th5) {
                th = th5;
                fileChannel = null;
                fileChannel2 = channel;
                if (fileLock3 != null) {
                }
                OrangeUtils.close(fileChannel2);
                OrangeUtils.close(fileChannel);
                OrangeUtils.close(fileInputStream);
                throw th;
            }
            try {
                r5 = new ObjectInputStream(new BufferedInputStream(fileInputStream));
                try {
                    T t = (T) ((CheckDO) r5.readObject());
                    if (t.checkValid()) {
                        if (!OrangeMonitor.mPerformanceInfoRecordDone) {
                            restoreCount.incrementAndGet();
                            restoreTime.addAndGet(System.currentTimeMillis() - currentTimeMillis);
                            ioTime.addAndGet(System.currentTimeMillis() - currentTimeMillis);
                            fileChannel = r5;
                            try {
                                OrangeMonitor.commitFileStatMonitor(str, true, true, 0, (double) (System.currentTimeMillis() - currentTimeMillis));
                            } catch (Exception e4) {
                                e = e4;
                                r5 = fileChannel;
                                fileChannel4 = channel;
                            } catch (Throwable th6) {
                                th2 = th6;
                                th = th2;
                                fileChannel3 = channel;
                                fileLock3 = fileLock;
                                fileChannel2 = fileChannel3;
                                if (fileLock3 != null) {
                                }
                                OrangeUtils.close(fileChannel2);
                                OrangeUtils.close(fileChannel);
                                OrangeUtils.close(fileInputStream);
                                throw th;
                            }
                        } else {
                            fileChannel = r5;
                        }
                        if (fileLock != null) {
                            try {
                                fileLock.release();
                            } catch (Throwable th7) {
                                OLog.e(TAG, "persistObjectLocked release lock failed", th7.toString());
                            }
                        }
                        OrangeUtils.close(channel);
                        OrangeUtils.close(fileChannel);
                        OrangeUtils.close(fileInputStream);
                        return t;
                    }
                    throw new RuntimeException("check not vaild:" + str);
                } catch (Exception e5) {
                    e = e5;
                    fileChannel4 = channel;
                    OLog.e(TAG, "restoreObject", e, new Object[0]);
                    if (fileLock != null) {
                    }
                    OrangeUtils.close(fileChannel4);
                    OrangeUtils.close(r5);
                    OrangeUtils.close(fileInputStream);
                    OrangeMonitor.commitCount(OConstant.MONITOR_PRIVATE_MODULE, OConstant.POINT_RESTORE_FAIL_COUNTS, str, 1.0d);
                    OrangeMonitor.commitFileStatMonitor(str, false, true, 0, (double) (System.currentTimeMillis() - currentTimeMillis));
                    return null;
                } catch (Throwable th8) {
                    th2 = th8;
                    fileChannel = r5;
                    th = th2;
                    fileChannel3 = channel;
                    fileLock3 = fileLock;
                    fileChannel2 = fileChannel3;
                    if (fileLock3 != null) {
                    }
                    OrangeUtils.close(fileChannel2);
                    OrangeUtils.close(fileChannel);
                    OrangeUtils.close(fileInputStream);
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                r5 = null;
                fileChannel4 = channel;
                OLog.e(TAG, "restoreObject", e, new Object[0]);
                if (fileLock != null) {
                }
                OrangeUtils.close(fileChannel4);
                OrangeUtils.close(r5);
                OrangeUtils.close(fileInputStream);
                OrangeMonitor.commitCount(OConstant.MONITOR_PRIVATE_MODULE, OConstant.POINT_RESTORE_FAIL_COUNTS, str, 1.0d);
                OrangeMonitor.commitFileStatMonitor(str, false, true, 0, (double) (System.currentTimeMillis() - currentTimeMillis));
                return null;
            } catch (Throwable th9) {
                th = th9;
                fileChannel = null;
                fileChannel3 = channel;
                fileLock3 = fileLock;
                fileChannel2 = fileChannel3;
                if (fileLock3 != null) {
                }
                OrangeUtils.close(fileChannel2);
                OrangeUtils.close(fileChannel);
                OrangeUtils.close(fileInputStream);
                throw th;
            }
        } catch (Exception e7) {
            e = e7;
            r5 = null;
            fileInputStream = null;
            fileLock2 = null;
            fileLock = fileLock2;
            fileChannel4 = fileLock2;
            OLog.e(TAG, "restoreObject", e, new Object[0]);
            if (fileLock != null) {
                try {
                    fileLock.release();
                } catch (Throwable th10) {
                    OLog.e(TAG, "persistObjectLocked release lock failed", th10.toString());
                }
            }
            OrangeUtils.close(fileChannel4);
            OrangeUtils.close(r5);
            OrangeUtils.close(fileInputStream);
            OrangeMonitor.commitCount(OConstant.MONITOR_PRIVATE_MODULE, OConstant.POINT_RESTORE_FAIL_COUNTS, str, 1.0d);
            OrangeMonitor.commitFileStatMonitor(str, false, true, 0, (double) (System.currentTimeMillis() - currentTimeMillis));
            return null;
        } catch (Throwable th11) {
            th = th11;
            fileInputStream = null;
            fileChannel5 = null;
            fileChannel = fileChannel5;
            fileChannel2 = fileChannel5;
            if (fileLock3 != null) {
                try {
                    fileLock3.release();
                } catch (Throwable th12) {
                    OLog.e(TAG, "persistObjectLocked release lock failed", th12.toString());
                }
            }
            OrangeUtils.close(fileChannel2);
            OrangeUtils.close(fileChannel);
            OrangeUtils.close(fileInputStream);
            throw th;
        }
    }
}
