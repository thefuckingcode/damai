package com.taobao.alivfssdk.fresco.common.internal;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: Taobao */
public class c {
    static byte[] a(InputStream inputStream, long j) throws IOException {
        if (j <= 2147483647L) {
            return j == 0 ? a.b(inputStream) : a.c(inputStream, (int) j);
        }
        throw new OutOfMemoryError("file is too large to fit in a byte array: " + j + " bytes");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001c  */
    public static byte[] b(File file) throws IOException {
        Throwable th;
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                byte[] a = a(fileInputStream2, fileInputStream2.getChannel().size());
                fileInputStream2.close();
                return a;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (fileInputStream != null) {
            }
            throw th;
        }
    }
}
