package tb;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
public class ta1 {
    public static String a(File file) {
        Throwable th;
        FileInputStream fileInputStream;
        Exception e;
        if (file != null) {
            try {
                if (file.exists() && file.isFile() && file.length() > 0) {
                    byte[] bArr = new byte[1024];
                    try {
                        MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
                        fileInputStream = new FileInputStream(file);
                        while (true) {
                            try {
                                int read = fileInputStream.read(bArr, 0, 1024);
                                if (read != -1) {
                                    instance.update(bArr, 0, read);
                                } else {
                                    String b = b(instance);
                                    ej.a(fileInputStream);
                                    return b;
                                }
                            } catch (Exception e2) {
                                e = e2;
                                try {
                                    e.printStackTrace();
                                    ej.a(fileInputStream);
                                    return null;
                                } catch (Throwable th2) {
                                    th = th2;
                                    ej.a(fileInputStream);
                                    throw th;
                                }
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        fileInputStream = null;
                        e.printStackTrace();
                        ej.a(fileInputStream);
                        return null;
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream = null;
                        ej.a(fileInputStream);
                        throw th;
                    }
                }
            } catch (Throwable th4) {
                s91.e(th4);
            }
        }
        return null;
    }

    public static String b(MessageDigest messageDigest) {
        byte[] digest = messageDigest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            int i = b;
            if (b < 0) {
                i = b + 256;
            }
            if (i < 16) {
                sb.append(0);
            }
            sb.append(Integer.toHexString(i == 1 ? 1 : 0));
        }
        return sb.toString().toLowerCase();
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            byte[] bytes = str.getBytes();
            instance.update(bytes, 0, bytes.length);
            return b(instance);
        } catch (Exception e) {
            s91.e(e);
            return null;
        }
    }
}
