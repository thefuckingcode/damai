package com.amap.api.mapcore.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: Taobao */
public class br {

    /* compiled from: Taobao */
    public interface a {
        void a(String str, String str2);

        void a(String str, String str2, float f);

        void a(String str, String str2, int i);

        void b(String str, String str2);
    }

    private float a(long j, long j2) {
        return (((float) j) / ((float) j2)) * 100.0f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:63:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    public long a(File file, File file2, long j, long j2, a aVar) {
        long j3;
        Exception e;
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i == 0) {
            if (aVar != null) {
                aVar.a("", "", -1);
            }
            return 0;
        }
        String absolutePath = file.getAbsolutePath();
        String absolutePath2 = file2.getAbsolutePath();
        try {
            if (!file.isDirectory()) {
                File parentFile = file2.getParentFile();
                if (parentFile == null || parentFile.exists() || parentFile.mkdirs()) {
                    if (aVar != null && i <= 0) {
                        aVar.a(absolutePath, absolutePath2);
                    }
                    FileInputStream fileInputStream = new FileInputStream(file);
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    byte[] bArr = new byte[1024];
                    long j4 = j;
                    while (true) {
                        try {
                            int read = fileInputStream.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                            j4 += (long) read;
                            if (aVar != null) {
                                try {
                                    aVar.a(absolutePath, absolutePath2, a(j4, j2));
                                } catch (Exception e2) {
                                    e = e2;
                                    j3 = j4;
                                    e.printStackTrace();
                                    if (aVar != null) {
                                    }
                                }
                            }
                        } catch (Exception e3) {
                            e = e3;
                            j3 = j4;
                            e.printStackTrace();
                            if (aVar != null) {
                            }
                        }
                    }
                    fileInputStream.close();
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    if (aVar != null && j4 >= j2 - 1) {
                        aVar.b(absolutePath, absolutePath2);
                    }
                    return j4;
                }
                throw new IOException("Cannot create dir " + parentFile.getAbsolutePath());
            } else if (file2.exists() || file2.mkdirs()) {
                String[] list = file.list();
                j3 = j;
                if (list != null) {
                    int i2 = 0;
                    while (i2 < list.length) {
                        try {
                            j3 = a(new File(file, list[i2]), new File(new File(file2, file.getName()), list[i2]), j3, j2, aVar);
                            i2++;
                            list = list;
                        } catch (Exception e4) {
                            e = e4;
                            e.printStackTrace();
                            if (aVar != null) {
                            }
                        }
                    }
                }
                return j3;
            } else {
                throw new IOException("Cannot create dir " + file2.getAbsolutePath());
            }
        } catch (Exception e5) {
            e = e5;
            j3 = j;
            e.printStackTrace();
            if (aVar != null) {
                return j3;
            }
            aVar.a(absolutePath, absolutePath2, -1);
            return j3;
        }
    }
}
