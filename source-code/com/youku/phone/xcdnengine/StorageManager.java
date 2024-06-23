package com.youku.phone.xcdnengine;

import android.util.Log;
import com.taobao.tlog.adapter.AdapterForTLog;
import java.io.File;
import java.util.ArrayList;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class StorageManager {
    private static final String TAG = "Xcdn-SM";
    private String localDir;
    private long maxStorageSize;
    private long totalSize = 0;

    public StorageManager(String str, int i) {
        this.localDir = str;
        this.maxStorageSize = (long) (i * 1024 * 1024);
    }

    private void listFile(ArrayList<File> arrayList, File file) {
        if (file.listFiles() != null && file.listFiles().length > 0) {
            boolean z = file.listFiles().length > 300;
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    long length = file2.length();
                    long lastModified = file2.lastModified();
                    if (length < 122880 && System.currentTimeMillis() - lastModified > 86400000) {
                        file2.delete();
                    } else if (System.currentTimeMillis() - lastModified > 1296000000) {
                        file2.delete();
                    } else if (!z || length >= 81920) {
                        arrayList.add(file2);
                        this.totalSize += file2.length();
                    } else {
                        file2.delete();
                    }
                } else {
                    listFile(arrayList, file2);
                }
            }
        }
    }

    public void checkSize() {
        Log.e(TAG, "begin check size");
        File file = new File(this.localDir);
        if (!file.exists()) {
            AdapterForTLog.loge(TAG, "xcdn local dir not exist !");
            return;
        }
        ArrayList<File> arrayList = new ArrayList<>();
        this.totalSize = 0;
        listFile(arrayList, file);
        if (this.totalSize > this.maxStorageSize) {
            Log.e(TAG, "begin clear size with size " + arrayList.size() + " total len:" + this.totalSize);
            while (this.totalSize > this.maxStorageSize && arrayList.size() > 0) {
                File file2 = arrayList.get(0);
                this.totalSize -= file2.length();
                arrayList.remove(0);
                Log.d(TAG, "delete file last modified " + file2.lastModified() + " size " + file2.length());
                file2.delete();
            }
            Log.e(TAG, "end clear size ");
        }
    }
}
