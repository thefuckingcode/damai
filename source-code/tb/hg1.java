package tb;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* compiled from: Taobao */
public class hg1 {
    static File a;
    static FileChannel b;
    static FileLock c;

    public static synchronized boolean a(Context context) {
        FileLock fileLock;
        synchronized (hg1.class) {
            if (context == null) {
                return true;
            }
            if (a == null) {
                a = new File(context.getFilesDir() + File.separator + "Analytics.Lock");
            }
            boolean exists = a.exists();
            if (!exists) {
                try {
                    exists = a.createNewFile();
                } catch (IOException unused) {
                }
            }
            if (!exists) {
                return true;
            }
            if (b == null) {
                try {
                    b = new RandomAccessFile(a, "rw").getChannel();
                } catch (Exception unused2) {
                    return false;
                }
            }
            try {
                fileLock = b.tryLock();
                if (fileLock != null) {
                    c = fileLock;
                    return true;
                }
            } catch (Throwable unused3) {
                fileLock = null;
            }
            Log.d("TAG", "mLock:" + fileLock);
            return false;
        }
    }

    public static synchronized void b() {
        synchronized (hg1.class) {
            FileLock fileLock = c;
            if (fileLock != null) {
                try {
                    fileLock.release();
                } catch (IOException unused) {
                } catch (Throwable th) {
                    c = null;
                    throw th;
                }
                c = null;
            }
            FileChannel fileChannel = b;
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (Exception unused2) {
                } catch (Throwable th2) {
                    b = null;
                    throw th2;
                }
                b = null;
            }
        }
    }
}
