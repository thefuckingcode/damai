package com.taobao.tao.log.godeye.memorydump.dump;

import android.os.Debug;

/* compiled from: Taobao */
public class MemoryDump {

    /* compiled from: Taobao */
    public interface MemoryDumpCallBack {
        void dumpError();

        void dumpSuccess(String str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        com.taobao.tao.log.godeye.memorydump.dump.MemoryFileZip.deleteFile(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0016, code lost:
        if (r2 != null) goto L_0x0018;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
        r2.dumpError();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0013 */
    public static synchronized void dumpHprof(String str, MemoryDumpCallBack memoryDumpCallBack) {
        synchronized (MemoryDump.class) {
            if (str != null) {
                MemoryFileZip.deleteFile(str);
                Debug.dumpHprofData(str);
                if (memoryDumpCallBack != null) {
                    memoryDumpCallBack.dumpSuccess(str);
                }
            }
        }
    }
}
