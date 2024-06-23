package com.android.dingtalk.share.ddsharemodule.algorithm;

import com.youku.upsplayer.util.YKUpsConvert;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
public class MD5 {
    public static final String getMD5(FileInputStream fileInputStream, int i, int i2, int i3) {
        byte[] digest;
        if (fileInputStream != null && i > 0 && i2 >= 0 && i3 > 0) {
            long j = (long) i2;
            try {
                if (fileInputStream.skip(j) < j) {
                    return null;
                }
                MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
                StringBuilder sb = new StringBuilder(32);
                byte[] bArr = new byte[i];
                int i4 = 0;
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1 || i4 >= i3) {
                    } else {
                        int i5 = i4 + read;
                        if (i5 <= i3) {
                            instance.update(bArr, 0, read);
                            i4 = i5;
                        } else {
                            instance.update(bArr, 0, i3 - i4);
                            i4 = i3;
                        }
                    }
                }
                for (byte b : instance.digest()) {
                    sb.append(Integer.toString((b & 255) + 256, 16).substring(1));
                }
                return sb.toString();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static final String getMessageDigest(byte[] bArr) {
        char[] cArr = {YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.update(bArr);
            byte[] digest = instance.digest();
            int length = digest.length;
            char[] cArr2 = new char[(length * 2)];
            int i = 0;
            for (byte b : digest) {
                int i2 = i + 1;
                cArr2[i] = cArr[(b >>> 4) & 15];
                i = i2 + 1;
                cArr2[i2] = cArr[b & 15];
            }
            return new String(cArr2);
        } catch (Exception unused) {
            return null;
        }
    }

    public static final byte[] getRawDigest(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.update(bArr);
            return instance.digest();
        } catch (Exception unused) {
            return null;
        }
    }

    public static final String getMD5(FileInputStream fileInputStream, int i) {
        int i2;
        byte[] digest;
        if (fileInputStream != null && i > 0) {
            try {
                MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
                StringBuilder sb = new StringBuilder(32);
                byte[] bArr = new byte[i];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    instance.update(bArr, 0, read);
                }
                for (byte b : instance.digest()) {
                    sb.append(Integer.toString((b & 255) + 256, 16).substring(1));
                }
                return sb.toString();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static String getMD5(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            return getMD5(file, 102400);
        }
        return null;
    }

    public static String getMD5(File file) {
        return getMD5(file, 102400);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0030 A[SYNTHETIC, Splitter:B:22:0x0030] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0037 A[SYNTHETIC, Splitter:B:30:0x0037] */
    public static String getMD5(File file, int i) {
        FileInputStream fileInputStream;
        Throwable th;
        long j;
        FileInputStream fileInputStream2 = null;
        if (file != null && i > 0 && file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                j = (long) i;
            } catch (Exception unused) {
                fileInputStream = null;
                if (fileInputStream != null) {
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream2 != null) {
                }
                throw th;
            }
            try {
                if (j > file.length()) {
                    j = file.length();
                }
                String md5 = getMD5(fileInputStream, (int) j);
                fileInputStream.close();
                try {
                    fileInputStream.close();
                } catch (IOException unused2) {
                }
                return md5;
            } catch (Exception unused3) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused5) {
                    }
                }
                throw th;
            }
        }
        return null;
    }

    public static String getMD5(String str, int i, int i2) {
        if (str == null) {
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            return getMD5(file, i, i2);
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0026 A[SYNTHETIC, Splitter:B:19:0x0026] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x002d A[SYNTHETIC, Splitter:B:27:0x002d] */
    public static String getMD5(File file, int i, int i2) {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2 = null;
        if (file != null && file.exists() && i >= 0 && i2 > 0) {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Exception unused) {
                fileInputStream = null;
                if (fileInputStream != null) {
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream2 != null) {
                }
                throw th;
            }
            try {
                String md5 = getMD5(fileInputStream, 102400, i, i2);
                fileInputStream.close();
                try {
                    fileInputStream.close();
                } catch (IOException unused2) {
                }
                return md5;
            } catch (Exception unused3) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused5) {
                    }
                }
                throw th;
            }
        }
        return null;
    }
}
