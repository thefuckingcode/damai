package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* compiled from: Taobao */
public class ab {
    public static final String[] a = {"jpg", "png", "bmp", "gif", "webp"};

    public static String a(File file) {
        Throwable th;
        IOException e;
        InputStreamReader inputStreamReader;
        StringWriter stringWriter = new StringWriter();
        InputStreamReader inputStreamReader2 = null;
        try {
            inputStreamReader = new InputStreamReader(new BufferedInputStream(new FileInputStream(file)));
            try {
                char[] cArr = new char[2048];
                while (true) {
                    int read = inputStreamReader.read(cArr);
                    if (read != -1) {
                        stringWriter.write(cArr, 0, read);
                    } else {
                        String stringWriter2 = stringWriter.toString();
                        a(inputStreamReader);
                        a(stringWriter);
                        return stringWriter2;
                    }
                }
            } catch (IOException e2) {
                e = e2;
                try {
                    b.c("read file :" + file.getAbsolutePath() + " failure :" + e.getMessage());
                    a(inputStreamReader);
                    a(stringWriter);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    inputStreamReader2 = inputStreamReader;
                    a(inputStreamReader2);
                    a(stringWriter);
                    throw th;
                }
            }
        } catch (IOException e3) {
            e = e3;
            inputStreamReader = null;
            b.c("read file :" + file.getAbsolutePath() + " failure :" + e.getMessage());
            a(inputStreamReader);
            a(stringWriter);
            return null;
        } catch (Throwable th3) {
            th = th3;
            a(inputStreamReader2);
            a(stringWriter);
            throw th;
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void a(File file, File file2) {
        Throwable th;
        IOException e;
        ZipOutputStream zipOutputStream = null;
        try {
            ZipOutputStream zipOutputStream2 = new ZipOutputStream(new FileOutputStream(file, false));
            try {
                a(zipOutputStream2, file2, null, null);
                a(zipOutputStream2);
            } catch (FileNotFoundException unused) {
                zipOutputStream = zipOutputStream2;
                a(zipOutputStream);
            } catch (IOException e2) {
                e = e2;
                zipOutputStream = zipOutputStream2;
                try {
                    b.m182a("zip file failure + " + e.getMessage());
                    a(zipOutputStream);
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                zipOutputStream = zipOutputStream2;
                a(zipOutputStream);
                throw th;
            }
        } catch (FileNotFoundException unused2) {
            a(zipOutputStream);
        } catch (IOException e3) {
            e = e3;
            b.m182a("zip file failure + " + e.getMessage());
            a(zipOutputStream);
        }
    }

    public static void a(File file, String str) {
        Throwable th;
        IOException e;
        if (!file.exists()) {
            b.c("mkdir " + file.getAbsolutePath());
            file.getParentFile().mkdirs();
        }
        BufferedWriter bufferedWriter = null;
        try {
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            try {
                bufferedWriter2.write(str);
                a(bufferedWriter2);
            } catch (IOException e2) {
                e = e2;
                bufferedWriter = bufferedWriter2;
                try {
                    b.c("write file :" + file.getAbsolutePath() + " failure :" + e.getMessage());
                    a(bufferedWriter);
                } catch (Throwable th2) {
                    th = th2;
                    a(bufferedWriter);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedWriter = bufferedWriter2;
                a(bufferedWriter);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            b.c("write file :" + file.getAbsolutePath() + " failure :" + e.getMessage());
            a(bufferedWriter);
        }
    }

    public static void a(ZipOutputStream zipOutputStream, File file, String str, FileFilter fileFilter) {
        Throwable th;
        IOException e;
        ZipEntry zipEntry;
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        FileInputStream fileInputStream = null;
        try {
            if (file.isDirectory()) {
                File[] listFiles = fileFilter != null ? file.listFiles(fileFilter) : file.listFiles();
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                String str3 = File.separator;
                sb.append(str3);
                zipOutputStream.putNextEntry(new ZipEntry(sb.toString()));
                if (!TextUtils.isEmpty(str)) {
                    str2 = str + str3;
                }
                for (int i = 0; i < listFiles.length; i++) {
                    a(zipOutputStream, listFiles[i], str2 + listFiles[i].getName(), null);
                }
                File[] listFiles2 = file.listFiles(new ac());
                if (listFiles2 != null) {
                    for (File file2 : listFiles2) {
                        a(zipOutputStream, file2, str2 + File.separator + file2.getName(), fileFilter);
                    }
                }
            } else {
                if (!TextUtils.isEmpty(str)) {
                    zipEntry = new ZipEntry(str);
                } else {
                    Date date = new Date();
                    zipEntry = new ZipEntry(String.valueOf(date.getTime()) + ".txt");
                }
                zipOutputStream.putNextEntry(zipEntry);
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        zipOutputStream.write(bArr, 0, read);
                    }
                    fileInputStream = fileInputStream2;
                } catch (IOException e2) {
                    e = e2;
                    fileInputStream = fileInputStream2;
                    try {
                        b.d("zipFiction failed with exception:" + e.toString());
                        a(fileInputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        a(fileInputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = fileInputStream2;
                    a(fileInputStream);
                    throw th;
                }
            }
        } catch (IOException e3) {
            e = e3;
            b.d("zipFiction failed with exception:" + e.toString());
            a(fileInputStream);
        }
        a(fileInputStream);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m248a(File file) {
        try {
            if (file.isDirectory()) {
                return false;
            }
            if (file.exists()) {
                return true;
            }
            File parentFile = file.getParentFile();
            if (parentFile.exists() || parentFile.mkdirs()) {
                return file.createNewFile();
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static byte[] a(byte[] bArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.finish();
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Exception unused) {
            return bArr;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x003f  */
    public static void b(File file, File file2) {
        Throwable th;
        FileOutputStream fileOutputStream;
        if (!file.getAbsolutePath().equals(file2.getAbsolutePath())) {
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read >= 0) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            fileInputStream2.close();
                            fileOutputStream.close();
                            return;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                if (fileInputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                throw th;
            }
        }
    }
}
