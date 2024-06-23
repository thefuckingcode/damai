package com.huawei.secure.android.common.encrypt.hash;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.a;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
public abstract class FileSHA256 {
    private static final int a = 8192;
    private static final String b = "SHA-256";
    private static final String c = "FileSHA256";
    private static final String d = "";
    private static final String[] e = {"SHA-256", MessageDigestAlgorithms.SHA_384, MessageDigestAlgorithms.SHA_512};

    private static boolean a(File file) {
        return file != null && file.exists() && file.length() > 0;
    }

    public static String fileSHA256Encrypt(File file) {
        return fileSHAEncrypt(file, "SHA-256");
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:9:0x001f */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARNING: Unknown variable types count: 3 */
    public static String fileSHAEncrypt(File file, String str) {
        Throwable th;
        ?? r1;
        NoSuchAlgorithmException e2;
        Object obj;
        IOException e3;
        String str2 = "";
        if (TextUtils.isEmpty(str) || !a(str)) {
            b.b(c, "algorithm is empty or not safe");
            return str2;
        } else if (!a(file)) {
            b.b(c, "file is not valid");
            return str2;
        } else {
            String str3 = null;
            str3 = null;
            ?? r0 = null;
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                ?? fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[8192];
                    boolean z = false;
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        instance.update(bArr, 0, read);
                        z = true;
                    }
                    if (z) {
                        str3 = HexUtil.byteArray2HexStr(instance.digest());
                    }
                    a.a((InputStream) fileInputStream);
                } catch (NoSuchAlgorithmException e4) {
                    e2 = e4;
                    obj = fileInputStream;
                    b.b(c, "NoSuchAlgorithmException" + e2.getMessage());
                    r1 = obj;
                    a.a((InputStream) r1);
                    return str3;
                } catch (IOException e5) {
                    e3 = e5;
                    str2 = fileInputStream;
                    b.b(c, "IOException" + e3.getMessage());
                    r1 = str2;
                    a.a((InputStream) r1);
                    return str3;
                }
            } catch (NoSuchAlgorithmException e6) {
                e2 = e6;
                obj = null;
                b.b(c, "NoSuchAlgorithmException" + e2.getMessage());
                r1 = obj;
                a.a((InputStream) r1);
                return str3;
            } catch (IOException e7) {
                e3 = e7;
                str2 = null;
                b.b(c, "IOException" + e3.getMessage());
                r1 = str2;
                a.a((InputStream) r1);
                return str3;
            } catch (Throwable th2) {
                th = th2;
                r0 = str2;
                a.a((InputStream) r0);
                throw th;
            }
            return str3;
        }
    }

    public static String inputStreamSHA256Encrypt(InputStream inputStream) {
        return inputStream == null ? "" : inputStreamSHAEncrypt(inputStream, "SHA-256");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0026, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        com.huawei.secure.android.common.encrypt.utils.b.b(com.huawei.secure.android.common.encrypt.hash.FileSHA256.c, "inputstraem exception");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0032, code lost:
        return "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0033, code lost:
        com.huawei.secure.android.common.encrypt.utils.a.a(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0036, code lost:
        throw r5;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0028 */
    public static String inputStreamSHAEncrypt(InputStream inputStream, String str) {
        if (inputStream == null) {
            return "";
        }
        byte[] bArr = new byte[8192];
        MessageDigest instance = MessageDigest.getInstance(str);
        while (true) {
            int read = inputStream.read(bArr);
            if (read < 0) {
                String byteArray2HexStr = HexUtil.byteArray2HexStr(instance.digest());
                a.a(inputStream);
                return byteArray2HexStr;
            } else if (read > 0) {
                instance.update(bArr, 0, read);
            }
        }
    }

    public static boolean validateFileSHA(File file, String str, String str2) {
        if (!TextUtils.isEmpty(str) && a(str2)) {
            return str.equals(fileSHAEncrypt(file, str2));
        }
        b.b(c, "hash value is null || algorithm is illegal");
        return false;
    }

    public static boolean validateFileSHA256(File file, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equalsIgnoreCase(fileSHA256Encrypt(file));
    }

    public static boolean validateInputStreamSHA(InputStream inputStream, String str, String str2) {
        if (!TextUtils.isEmpty(str) && a(str2)) {
            return str.equals(inputStreamSHAEncrypt(inputStream, str2));
        }
        b.b(c, "hash value is null || algorithm is illegal");
        return false;
    }

    public static boolean validateInputStreamSHA256(InputStream inputStream, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equals(inputStreamSHA256Encrypt(inputStream));
    }

    private static boolean a(String str) {
        for (String str2 : e) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }
}
