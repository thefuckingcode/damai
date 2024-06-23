package com.taobao.weex.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
public class WXFileUtils {
    public static String base64Md5(String str) {
        if (str == null) {
            return "";
        }
        try {
            return base64Md5(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static void closeIo(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x005b A[SYNTHETIC, Splitter:B:18:0x005b] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0065 A[SYNTHETIC, Splitter:B:23:0x0065] */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    public static void copyFile(File file, File file2) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        Exception e;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[1024];
                fileOutputStream = new FileOutputStream(file2);
                while (fileInputStream.read(bArr) != -1) {
                    try {
                        fileOutputStream.write(bArr);
                    } catch (Exception e2) {
                        e = e2;
                        WXLogUtils.e("copyFile " + e.getMessage() + ": " + file.getAbsolutePath() + ": " + file2.getAbsolutePath());
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                                return;
                            } catch (IOException e4) {
                                e4.printStackTrace();
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
                fileInputStream.close();
                fileOutputStream.close();
            } catch (Exception e5) {
                fileOutputStream = null;
                e = e5;
                WXLogUtils.e("copyFile " + e.getMessage() + ": " + file.getAbsolutePath() + ": " + file2.getAbsolutePath());
                if (fileInputStream != null) {
                }
                if (fileOutputStream != null) {
                }
            }
        } catch (Exception e6) {
            fileOutputStream = null;
            e = e6;
            fileInputStream = null;
            WXLogUtils.e("copyFile " + e.getMessage() + ": " + file.getAbsolutePath() + ": " + file2.getAbsolutePath());
            if (fileInputStream != null) {
            }
            if (fileOutputStream != null) {
            }
        }
    }

    public static void copyFileWithException(File file, File file2) throws Exception {
        Throwable th;
        FileOutputStream fileOutputStream;
        Exception e;
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                byte[] bArr = new byte[1024];
                fileOutputStream = new FileOutputStream(file2);
                while (fileInputStream2.read(bArr) != -1) {
                    try {
                        fileOutputStream.write(bArr);
                    } catch (Exception e2) {
                        e = e2;
                        fileInputStream = fileInputStream2;
                        try {
                            throw e;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream = fileInputStream2;
                        closeIo(fileInputStream);
                        closeIo(fileOutputStream);
                        throw th;
                    }
                }
                closeIo(fileInputStream2);
                closeIo(fileOutputStream);
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
                throw e;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
                closeIo(fileInputStream);
                closeIo(fileOutputStream);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            fileOutputStream = null;
            throw e;
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
            closeIo(fileInputStream);
            closeIo(fileOutputStream);
            throw th;
        }
    }

    public static void extractSo(String str, String str2) throws IOException {
        ZipFile zipFile = new ZipFile(str);
        ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(str)));
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                zipInputStream.closeEntry();
                return;
            } else if (!nextEntry.isDirectory()) {
                String name = nextEntry.getName();
                if (name.contains("lib/" + WXSoInstallMgrSdk._cpuType() + "/") && (nextEntry.getName().contains("weex") || nextEntry.getName().equals("libJavaScriptCore.so"))) {
                    String[] split = nextEntry.getName().split("/");
                    String str3 = split[split.length - 1];
                    InputStream inputStream = zipFile.getInputStream(nextEntry);
                    byte[] bArr = new byte[1024];
                    File file = new File(str2 + "/" + str3);
                    if (file.exists()) {
                        file.delete();
                    }
                    file.createNewFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    while (inputStream.read(bArr) != -1) {
                        fileOutputStream.write(bArr);
                    }
                    fileOutputStream.close();
                }
            }
        }
    }

    public static String loadAsset(String str, Context context) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return readStreamToString(context.getAssets().open(str));
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String loadFileOrAsset(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        File file = new File(str);
        if (!file.exists()) {
            return loadAsset(str, context);
        }
        try {
            return readStreamToString(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String md5(String str) {
        if (str == null) {
            return "";
        }
        try {
            return md5(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static byte[] readBytesFromAssets(String str, Context context) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                InputStream open = context.getAssets().open(str);
                byte[] bArr = new byte[4096];
                int read = open.read(bArr);
                byte[] bArr2 = new byte[read];
                System.arraycopy(bArr, 0, bArr2, 0, read);
                return bArr2;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x004d A[SYNTHETIC, Splitter:B:26:0x004d] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0057 A[SYNTHETIC, Splitter:B:31:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0064 A[SYNTHETIC, Splitter:B:39:0x0064] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x006e A[SYNTHETIC, Splitter:B:44:0x006e] */
    public static String readStreamToString(InputStream inputStream) {
        Throwable th;
        BufferedReader bufferedReader;
        IOException e;
        BufferedReader bufferedReader2 = null;
        try {
            StringBuilder sb = new StringBuilder(inputStream.available() + 10);
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            try {
                char[] cArr = new char[4096];
                while (true) {
                    int read = bufferedReader.read(cArr);
                    if (read <= 0) {
                        break;
                    }
                    sb.append(cArr, 0, read);
                }
                String sb2 = sb.toString();
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                    WXLogUtils.e("WXFileUtils loadAsset: ", e2);
                }
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    WXLogUtils.e("WXFileUtils loadAsset: ", e3);
                }
                return sb2;
            } catch (IOException e4) {
                e = e4;
                try {
                    e.printStackTrace();
                    WXLogUtils.e("", e);
                    if (bufferedReader != null) {
                    }
                    if (inputStream != null) {
                    }
                    return "";
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e5) {
                            WXLogUtils.e("WXFileUtils loadAsset: ", e5);
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e6) {
                            WXLogUtils.e("WXFileUtils loadAsset: ", e6);
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e7) {
            bufferedReader = null;
            e = e7;
            e.printStackTrace();
            WXLogUtils.e("", e);
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e8) {
                    WXLogUtils.e("WXFileUtils loadAsset: ", e8);
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e9) {
                    WXLogUtils.e("WXFileUtils loadAsset: ", e9);
                }
            }
            return "";
        } catch (Throwable th3) {
            th = th3;
            if (bufferedReader2 != null) {
            }
            if (inputStream != null) {
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0042 A[SYNTHETIC, Splitter:B:24:0x0042] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x004d A[SYNTHETIC, Splitter:B:30:0x004d] */
    public static boolean saveFile(String str, byte[] bArr, Context context) {
        Throwable th;
        Exception e;
        if (TextUtils.isEmpty(str) || bArr == null || context == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(str);
            try {
                fileOutputStream2.write(bArr);
                try {
                    fileOutputStream2.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return true;
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = fileOutputStream2;
                try {
                    WXLogUtils.e("WXFileUtils saveFile: " + WXLogUtils.getStackTrace(e));
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            WXLogUtils.e("WXFileUtils saveFile: " + WXLogUtils.getStackTrace(e));
            if (fileOutputStream != null) {
            }
            return false;
        }
    }

    public static String base64Md5(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.update(bArr);
            return Base64.encodeToString(instance.digest(), 2);
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public static String md5(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.update(bArr);
            return new BigInteger(1, instance.digest()).toString(16);
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }
}
