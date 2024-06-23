package com.taobao.accs.utl.syncps;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.aranger.ARanger;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Objects;

/* compiled from: Taobao */
public class SyncChannelSwitch {
    public static final String FILE_CONN_SERVICES = "conn_services.lock";
    public static final String FILE_SCS = "scs.lock";
    private static final String TAG = "SyncChannelSwitch";
    private static Context mContext;

    private static void checkContext(Context context) {
        if (mContext == null) {
            if (context == null) {
                context = ARanger.getContext();
                Objects.requireNonNull(context, "context is NULL");
            }
            mContext = context.getApplicationContext();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:15|(2:17|18)|19|20|21) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:30|(2:32|33)|34|35|55) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:36|(2:38|39)|40|41|42) */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00a6, code lost:
        if (r4 != null) goto L_0x0083;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0056 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x0083 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:40:0x0090 */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00a1 A[SYNTHETIC, Splitter:B:51:0x00a1] */
    public static String getOrSetValueInProcessLock(Context context, String str, String str2) {
        Throwable th;
        RandomAccessFile randomAccessFile;
        FileLock fileLock = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            randomAccessFile = new RandomAccessFile(new File(context.getDir("accs", 0), str), "rw");
            try {
                FileLock lock = randomAccessFile.getChannel().lock();
                if (UtilityImpl.isMainProcessAlive(context) && UtilityImpl.isChannelProcessAlive(context)) {
                    String read = read(context, randomAccessFile);
                    ALog.e(TAG, "read from", "file", str, "val", read);
                    if (lock != null) {
                        lock.release();
                    }
                    randomAccessFile.close();
                    return read;
                }
                if (UtilityImpl.isMainProcess(context) || UtilityImpl.isChannelProcess(context)) {
                    ALog.e(TAG, "write to", "file", str, "val", str2);
                    write(context, randomAccessFile, str2);
                    if (lock != null) {
                        lock.release();
                    }
                    randomAccessFile.close();
                    return str2;
                }
                String read2 = read(context, randomAccessFile);
                if (lock != null) {
                    lock.release();
                }
                randomAccessFile.close();
                return read2;
            } catch (Throwable th2) {
                th = th2;
                try {
                    ALog.e(TAG, "getChannelEnabledImpl", th, new Object[0]);
                    if (0 != 0) {
                        try {
                            fileLock.release();
                        } catch (IOException unused) {
                        }
                    }
                } catch (Throwable th3) {
                    if (0 != 0) {
                        try {
                            fileLock.release();
                        } catch (IOException unused2) {
                        }
                    }
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            randomAccessFile = null;
            ALog.e(TAG, "getChannelEnabledImpl", th, new Object[0]);
            if (0 != 0) {
            }
        }
    }

    private static String read(Context context, RandomAccessFile randomAccessFile) {
        checkContext(context);
        return readFromFile(randomAccessFile);
    }

    private static String readFromFile(RandomAccessFile randomAccessFile) {
        try {
            String readLine = randomAccessFile.readLine();
            ALog.i(TAG, "readFromFile", "line", readLine);
            return readLine;
        } catch (Throwable th) {
            ALog.e(TAG, "readFromFile", th, new Object[0]);
            return null;
        }
    }

    private static void saveToFile(RandomAccessFile randomAccessFile, String str) {
        try {
            randomAccessFile.setLength(0);
            randomAccessFile.seek(0);
            randomAccessFile.write(str.getBytes());
            ALog.i(TAG, "saveToFile success", new Object[0]);
        } catch (Throwable th) {
            ALog.e(TAG, "saveToFile", th, new Object[0]);
        }
    }

    private static void write(Context context, RandomAccessFile randomAccessFile, String str) {
        checkContext(context);
        saveToFile(randomAccessFile, str);
    }
}
