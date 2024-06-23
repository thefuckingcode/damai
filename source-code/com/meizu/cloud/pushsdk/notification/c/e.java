package com.meizu.cloud.pushsdk.notification.c;

import android.os.SystemClock;
import com.meizu.cloud.pushinternal.DebugLogger;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

/* compiled from: Taobao */
public class e {
    private final File a;
    private final File b;
    private final String c;

    public e(String str, String str2) {
        File file = new File(str);
        this.a = file;
        File file2 = new File(str2);
        this.b = file2;
        this.c = file2.getAbsolutePath();
        DebugLogger.i("ZipExtractTask", "Extract mInput file = " + file.toString());
        DebugLogger.i("ZipExtractTask", "Extract mOutput file = " + file2.toString());
    }

    private int a(InputStream inputStream, OutputStream outputStream) {
        StringBuilder sb;
        byte[] bArr = new byte[8192];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 8192);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream, 8192);
        int i = 0;
        while (true) {
            try {
                int read = bufferedInputStream.read(bArr, 0, 8192);
                if (read == -1) {
                    break;
                }
                bufferedOutputStream.write(bArr, 0, read);
                i += read;
            } catch (IOException e) {
                DebugLogger.e("ZipExtractTask", "Extracted IOException:" + e.toString());
                try {
                    bufferedOutputStream.close();
                } catch (IOException e2) {
                    DebugLogger.e("ZipExtractTask", "out.close() IOException e=" + e2.toString());
                }
                try {
                    bufferedInputStream.close();
                } catch (IOException e3) {
                    e = e3;
                    sb = new StringBuilder();
                }
            } catch (Throwable th) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e4) {
                    DebugLogger.e("ZipExtractTask", "out.close() IOException e=" + e4.toString());
                }
                try {
                    bufferedInputStream.close();
                } catch (IOException e5) {
                    DebugLogger.e("ZipExtractTask", "in.close() IOException e=" + e5.toString());
                }
                throw th;
            }
        }
        bufferedOutputStream.flush();
        try {
            bufferedOutputStream.close();
        } catch (IOException e6) {
            DebugLogger.e("ZipExtractTask", "out.close() IOException e=" + e6.toString());
        }
        try {
            bufferedInputStream.close();
        } catch (IOException e7) {
            e = e7;
            sb = new StringBuilder();
        }
        return i;
        sb.append("in.close() IOException e=");
        sb.append(e.toString());
        DebugLogger.e("ZipExtractTask", sb.toString());
        return i;
    }

    private void b() {
        String str;
        StringBuilder sb;
        File file = this.a;
        if (file != null && file.exists()) {
            if (this.a.delete()) {
                sb = new StringBuilder();
                str = "Delete file:";
            } else {
                sb = new StringBuilder();
                str = "Can't delete file:";
            }
            sb.append(str);
            sb.append(this.a.toString());
            sb.append(" after extracted.");
            DebugLogger.i("ZipExtractTask", sb.toString());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x0152 A[SYNTHETIC, Splitter:B:52:0x0152] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0179 A[SYNTHETIC, Splitter:B:60:0x0179] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01a2 A[SYNTHETIC, Splitter:B:68:0x01a2] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01e5  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0202 A[SYNTHETIC, Splitter:B:80:0x0202] */
    private long c() {
        Throwable th;
        long j;
        String str;
        IOException iOException;
        StringBuilder sb;
        ZipException e;
        IOException e2;
        Exception e3;
        String str2;
        long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        ZipFile zipFile = null;
        String str3 = null;
        ZipFile zipFile2 = null;
        ZipFile zipFile3 = null;
        boolean z = false;
        long j2 = 0;
        try {
            ZipFile zipFile4 = new ZipFile(this.a);
            try {
                Enumeration<? extends ZipEntry> entries = zipFile4.entries();
                while (entries.hasMoreElements()) {
                    ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                    if (!zipEntry.isDirectory()) {
                        String name = zipEntry.getName();
                        if (name != null) {
                            if (name.contains("../")) {
                                throw new Exception("Unsafe zip file");
                            }
                        }
                        if (str3 == null && name != null) {
                            str3 = name.split("/")[0];
                            DebugLogger.i("ZipExtractTask", "Extract temp directory=" + this.b + "/" + str3);
                        }
                        if (name != null) {
                            File file = new File(this.b, name);
                            if (!file.getParentFile().exists()) {
                                if (file.getParentFile().mkdirs()) {
                                    str2 = "Make Destination directory=" + file.getParentFile().getAbsolutePath();
                                } else {
                                    str2 = "Can't make destination directory=" + file.getParentFile().getAbsolutePath();
                                }
                                DebugLogger.i("ZipExtractTask", str2);
                            }
                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                            j2 += (long) a(zipFile4.getInputStream(zipEntry), fileOutputStream);
                            fileOutputStream.close();
                        }
                    }
                }
                String str4 = this.b + "/" + str3;
                if (!this.c.equals(str4)) {
                    a.a(str4, this.c);
                    z = true;
                }
                try {
                    zipFile4.close();
                } catch (IOException e4) {
                    DebugLogger.e("ZipExtractTask", "Extracted IOException:" + e4.toString());
                }
            } catch (ZipException e5) {
                e = e5;
                str = null;
                zipFile = zipFile4;
                j = 0;
                DebugLogger.e("ZipExtractTask", "ZipException :" + e.toString());
                if (zipFile != null) {
                    try {
                        zipFile.close();
                    } catch (IOException e6) {
                        iOException = e6;
                        sb = new StringBuilder();
                    }
                }
                str3 = str;
                j2 = j;
                long currentThreadTimeMillis2 = SystemClock.currentThreadTimeMillis();
                DebugLogger.i("ZipExtractTask", "Extract file " + this.a + ", UseTime =" + (currentThreadTimeMillis2 - currentThreadTimeMillis));
                if (z) {
                }
                b();
                return j2;
            } catch (IOException e7) {
                e2 = e7;
                str = null;
                zipFile3 = zipFile4;
                j = 0;
                DebugLogger.e("ZipExtractTask", "Extracted IOException:" + e2.toString());
                if (zipFile3 != null) {
                    try {
                        zipFile3.close();
                    } catch (IOException e8) {
                        iOException = e8;
                        sb = new StringBuilder();
                    }
                }
                str3 = str;
                j2 = j;
                long currentThreadTimeMillis22 = SystemClock.currentThreadTimeMillis();
                DebugLogger.i("ZipExtractTask", "Extract file " + this.a + ", UseTime =" + (currentThreadTimeMillis22 - currentThreadTimeMillis));
                if (z) {
                }
                b();
                return j2;
            } catch (Exception e9) {
                e3 = e9;
                str = null;
                zipFile2 = zipFile4;
                j = 0;
                try {
                    DebugLogger.e("ZipExtractTask", "Extracted Exception " + e3.toString());
                    if (zipFile2 != null) {
                        try {
                            zipFile2.close();
                        } catch (IOException e10) {
                            iOException = e10;
                            sb = new StringBuilder();
                        }
                    }
                    str3 = str;
                    j2 = j;
                    long currentThreadTimeMillis222 = SystemClock.currentThreadTimeMillis();
                    DebugLogger.i("ZipExtractTask", "Extract file " + this.a + ", UseTime =" + (currentThreadTimeMillis222 - currentThreadTimeMillis));
                    if (z) {
                    }
                    b();
                    return j2;
                } catch (Throwable th2) {
                    th = th2;
                    if (zipFile2 != null) {
                        try {
                            zipFile2.close();
                        } catch (IOException e11) {
                            DebugLogger.e("ZipExtractTask", "Extracted IOException:" + e11.toString());
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                zipFile2 = zipFile4;
                if (zipFile2 != null) {
                }
                throw th;
            }
        } catch (ZipException e12) {
            e = e12;
            j = 0;
            str = null;
            DebugLogger.e("ZipExtractTask", "ZipException :" + e.toString());
            if (zipFile != null) {
            }
            str3 = str;
            j2 = j;
            long currentThreadTimeMillis2222 = SystemClock.currentThreadTimeMillis();
            DebugLogger.i("ZipExtractTask", "Extract file " + this.a + ", UseTime =" + (currentThreadTimeMillis2222 - currentThreadTimeMillis));
            if (z) {
            }
            b();
            return j2;
        } catch (IOException e13) {
            e2 = e13;
            j = 0;
            str = null;
            DebugLogger.e("ZipExtractTask", "Extracted IOException:" + e2.toString());
            if (zipFile3 != null) {
            }
            str3 = str;
            j2 = j;
            long currentThreadTimeMillis22222 = SystemClock.currentThreadTimeMillis();
            DebugLogger.i("ZipExtractTask", "Extract file " + this.a + ", UseTime =" + (currentThreadTimeMillis22222 - currentThreadTimeMillis));
            if (z) {
            }
            b();
            return j2;
        } catch (Exception e14) {
            e3 = e14;
            j = 0;
            str = null;
            DebugLogger.e("ZipExtractTask", "Extracted Exception " + e3.toString());
            if (zipFile2 != null) {
            }
            str3 = str;
            j2 = j;
            long currentThreadTimeMillis222222 = SystemClock.currentThreadTimeMillis();
            DebugLogger.i("ZipExtractTask", "Extract file " + this.a + ", UseTime =" + (currentThreadTimeMillis222222 - currentThreadTimeMillis));
            if (z) {
            }
            b();
            return j2;
        }
        long currentThreadTimeMillis2222222 = SystemClock.currentThreadTimeMillis();
        DebugLogger.i("ZipExtractTask", "Extract file " + this.a + ", UseTime =" + (currentThreadTimeMillis2222222 - currentThreadTimeMillis));
        if (z) {
            a.b(this.b + "/" + str3);
        }
        b();
        return j2;
        sb.append("Extracted IOException:");
        sb.append(iOException.toString());
        DebugLogger.e("ZipExtractTask", sb.toString());
        str3 = str;
        j2 = j;
        long currentThreadTimeMillis22222222 = SystemClock.currentThreadTimeMillis();
        DebugLogger.i("ZipExtractTask", "Extract file " + this.a + ", UseTime =" + (currentThreadTimeMillis22222222 - currentThreadTimeMillis));
        if (z) {
        }
        b();
        return j2;
    }

    public boolean a() {
        return c() > 0;
    }
}
