package com.amap.api.mapcore.util;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class bq {
    RandomAccessFile a;

    public bq() throws IOException {
        this("", 0);
    }

    public synchronized int a(byte[] bArr) throws IOException {
        this.a.write(bArr);
        return bArr.length;
    }

    public bq(String str, long j) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
            } catch (IOException e) {
                hd.c(e, "FileAccessI", "create");
                e.printStackTrace();
            }
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "rw");
        this.a = randomAccessFile;
        randomAccessFile.seek(j);
    }

    public void a() {
        RandomAccessFile randomAccessFile = this.a;
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.a = null;
        }
    }
}
