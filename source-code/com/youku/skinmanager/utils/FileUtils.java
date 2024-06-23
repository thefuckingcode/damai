package com.youku.skinmanager.utils;

import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
public class FileUtils {
    private static final String TAG = "FileUtils";

    public static boolean deleteFile(File file) {
        File[] listFiles;
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.isFile()) {
            return file.delete();
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (!deleteFile(file2)) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static boolean deleteFiles(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        File file2 = null;
        if (!TextUtils.isEmpty(str2)) {
            file2 = new File(str2).getParentFile();
        }
        return deleteFiles(file, file2);
    }

    public static String getMD5(String str) {
        int i;
        byte[] digest;
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            StringBuffer stringBuffer = new StringBuffer();
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                instance.update(bArr, 0, read);
            }
            for (byte b : instance.digest()) {
                stringBuffer.append(Integer.toString((b & 255) + 256, 16).substring(1));
            }
            return stringBuffer.toString().toLowerCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x0128 A[SYNTHETIC, Splitter:B:53:0x0128] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0130 A[Catch:{ IOException -> 0x012c }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0144 A[SYNTHETIC, Splitter:B:65:0x0144] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x014c A[Catch:{ IOException -> 0x0148 }] */
    public static String unZipFolder(String str, String str2) {
        Throwable th;
        FileOutputStream fileOutputStream;
        Exception e;
        ZipInputStream zipInputStream;
        Log.v(TAG, getMD5(str));
        ZipInputStream zipInputStream2 = null;
        try {
            zipInputStream = new ZipInputStream(new FileInputStream(str));
            String str3 = "";
            fileOutputStream = null;
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry == null) {
                        break;
                    }
                    String name = nextEntry.getName();
                    if (!name.startsWith("__MACOSX")) {
                        if (!name.contains("../")) {
                            if (nextEntry.isDirectory()) {
                                File file = new File(str2 + File.separator + name);
                                StringBuilder sb = new StringBuilder();
                                sb.append("entryName = ");
                                sb.append(name);
                                Log.d(TAG, sb.toString());
                                file.mkdirs();
                                if (TextUtils.isEmpty(str3)) {
                                    str3 = name;
                                }
                            } else {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(str2);
                                String str4 = File.separator;
                                sb2.append(str4);
                                sb2.append(name);
                                File file2 = new File(sb2.toString());
                                if (!file2.exists()) {
                                    Log.d(TAG, "create the file:" + str2 + str4 + name);
                                    file2.getParentFile().mkdirs();
                                    file2.createNewFile();
                                }
                                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                                try {
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int read = zipInputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        fileOutputStream2.write(bArr, 0, read);
                                        fileOutputStream2.flush();
                                    }
                                    fileOutputStream2.close();
                                    fileOutputStream = fileOutputStream2;
                                } catch (Exception e2) {
                                    e = e2;
                                    fileOutputStream = fileOutputStream2;
                                    try {
                                        e.printStackTrace();
                                        Log.e(TAG, e.getLocalizedMessage());
                                        if (zipInputStream != null) {
                                        }
                                        if (fileOutputStream != null) {
                                        }
                                        new File(str).delete();
                                        return null;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        zipInputStream2 = zipInputStream;
                                        if (zipInputStream2 != null) {
                                            try {
                                                zipInputStream2.close();
                                            } catch (IOException e3) {
                                                e3.printStackTrace();
                                                throw th;
                                            }
                                        }
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                        new File(str).delete();
                                        throw th;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    zipInputStream2 = zipInputStream;
                                    fileOutputStream = fileOutputStream2;
                                    if (zipInputStream2 != null) {
                                    }
                                    if (fileOutputStream != null) {
                                    }
                                    new File(str).delete();
                                    throw th;
                                }
                            }
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    e.printStackTrace();
                    Log.e(TAG, e.getLocalizedMessage());
                    if (zipInputStream != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    new File(str).delete();
                    return null;
                }
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            zipInputStream.close();
            String absolutePath = new File(str2 + File.separator + str3).getAbsolutePath();
            try {
                zipInputStream.close();
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                new File(str).delete();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            return absolutePath;
        } catch (Exception e6) {
            e = e6;
            zipInputStream = null;
            fileOutputStream = null;
            e.printStackTrace();
            Log.e(TAG, e.getLocalizedMessage());
            if (zipInputStream != null) {
                try {
                    zipInputStream.close();
                } catch (IOException e7) {
                    e7.printStackTrace();
                    return null;
                }
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            new File(str).delete();
            return null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            if (zipInputStream2 != null) {
            }
            if (fileOutputStream != null) {
            }
            new File(str).delete();
            throw th;
        }
    }

    public static boolean deleteFiles(File file, File file2) {
        File[] listFiles;
        if (file == null) {
            return false;
        }
        try {
            if (!file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null) {
                return true;
            }
            for (File file3 : listFiles) {
                if (file2 == null || !file2.getAbsolutePath().equalsIgnoreCase(file3.getAbsolutePath())) {
                    deleteFile(file3);
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
