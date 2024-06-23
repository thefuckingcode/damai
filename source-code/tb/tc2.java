package tb;

import android.text.TextUtils;
import com.taobao.android.sopatch.download.FileDownloader;
import com.taobao.android.sopatch.download.a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: Taobao */
public class tc2 {
    public static boolean a(sc2 sc2) {
        File e = rh0.e(sc2);
        if (e == null || !e.exists()) {
            return false;
        }
        return TextUtils.equals(sc2.c(), ta1.a(e));
    }

    public static void b(sc2 sc2, FileDownloader.Callback callback) {
        File e = rh0.e(sc2);
        if (e != null) {
            new a().download(sc2.g(), e, callback);
        } else {
            callback.onFail();
        }
    }

    private static String c(ZipFile zipFile, ZipEntry zipEntry, File file) {
        Throwable th;
        FileOutputStream fileOutputStream;
        Exception e;
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (file != null) {
            try {
                inputStream = zipFile.getInputStream(zipEntry);
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = null;
                    try {
                        s91.e(e);
                        ej.a(inputStream);
                        ej.a(fileOutputStream);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream2 = inputStream;
                        ej.a(inputStream2);
                        ej.a(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                    inputStream2 = inputStream;
                    ej.a(inputStream2);
                    ej.a(fileOutputStream);
                    throw th;
                }
                try {
                    String a = e11.a(inputStream, fileOutputStream);
                    ej.a(inputStream);
                    ej.a(fileOutputStream);
                    return a;
                } catch (Exception e3) {
                    e = e3;
                    s91.e(e);
                    ej.a(inputStream);
                    ej.a(fileOutputStream);
                    return null;
                }
            } catch (Exception e4) {
                e = e4;
                inputStream = null;
                fileOutputStream = null;
                s91.e(e);
                ej.a(inputStream);
                ej.a(fileOutputStream);
                return null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                ej.a(inputStream2);
                ej.a(fileOutputStream);
                throw th;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00cd A[SYNTHETIC, Splitter:B:49:0x00cd] */
    public static List<pc2> d(sc2 sc2) {
        Throwable th;
        Exception e;
        ArrayList arrayList = new ArrayList();
        File e2 = rh0.e(sc2);
        if (e2 == null || !e2.exists() || !e2.isFile() || ((!e2.getName().endsWith(".zip") && !e2.getName().endsWith(".aar")) || e2.length() == 0)) {
            return arrayList;
        }
        String a = c22.a();
        ZipFile zipFile = null;
        try {
            ZipFile zipFile2 = new ZipFile(e2);
            try {
                Enumeration<? extends ZipEntry> entries = zipFile2.entries();
                while (true) {
                    if (entries.hasMoreElements()) {
                        ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                        String name = zipEntry.getName();
                        if (!zipEntry.isDirectory() && name.contains(a)) {
                            if (name.endsWith(".so")) {
                                String a2 = wh0.a(name);
                                pc2 a3 = sc2.a(a2);
                                if (rc2.b(a3)) {
                                    arrayList.add(a3);
                                } else {
                                    File d = rh0.d(a2, zipEntry.getSize());
                                    String c = c(zipFile2, zipEntry, d);
                                    if (TextUtils.isEmpty(c)) {
                                        arrayList.clear();
                                        break;
                                    }
                                    pc2 c2 = kc2.c(a2, c, d.length(), sc2.d());
                                    wh0.b(d, rh0.b(c2));
                                    arrayList.add(c2);
                                }
                            }
                        }
                    }
                }
                try {
                    zipFile2.close();
                    break;
                } catch (Exception e3) {
                    s91.e(e3);
                }
            } catch (Exception e4) {
                e = e4;
                zipFile = zipFile2;
                try {
                    arrayList.clear();
                    s91.e(e);
                    if (zipFile != null) {
                        zipFile.close();
                    }
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (Exception e5) {
                            s91.e(e5);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                zipFile = zipFile2;
                if (zipFile != null) {
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            arrayList.clear();
            s91.e(e);
            if (zipFile != null) {
            }
            return arrayList;
        }
        return arrayList;
    }
}
