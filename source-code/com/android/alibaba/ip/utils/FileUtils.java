package com.android.alibaba.ip.utils;

import android.annotation.SuppressLint;
import com.youku.upsplayer.util.YKUpsConvert;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
public class FileUtils {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0050 A[SYNTHETIC, Splitter:B:34:0x0050] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x005a A[SYNTHETIC, Splitter:B:39:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0064 A[SYNTHETIC, Splitter:B:44:0x0064] */
    /* JADX WARNING: Unknown variable types count: 2 */
    @SuppressLint({"NewApi"})
    public static void copyInputStreamToFile(InputStream inputStream, File file) throws IOException {
        Throwable th;
        ?? r1;
        IOException e;
        FileChannel fileChannel;
        FileChannel fileChannel2 = null;
        try {
            ?? fileOutputStream = new FileOutputStream(file);
            try {
                FileChannel channel = fileOutputStream.getChannel();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read > 0) {
                        channel.write(ByteBuffer.wrap(bArr, 0, read));
                    } else {
                        try {
                            break;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                inputStream.close();
                if (channel != null) {
                    try {
                        channel.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                try {
                    fileOutputStream.close();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            } catch (IOException e5) {
                e = e5;
                fileChannel = null;
                fileChannel2 = fileOutputStream;
                try {
                    throw new IOException(e);
                } catch (Throwable th2) {
                    th = th2;
                    r1 = fileChannel2;
                    fileChannel2 = fileChannel;
                    if (inputStream != null) {
                    }
                    if (fileChannel2 != null) {
                    }
                    if (r1 != 0) {
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                r1 = fileOutputStream;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
                if (fileChannel2 != null) {
                    try {
                        fileChannel2.close();
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                }
                if (r1 != 0) {
                    try {
                        r1.close();
                    } catch (Exception e8) {
                        e8.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e9) {
            e = e9;
            fileChannel = null;
            throw new IOException(e);
        } catch (Throwable th4) {
            th = th4;
            r1 = 0;
            if (inputStream != null) {
            }
            if (fileChannel2 != null) {
            }
            if (r1 != 0) {
            }
            throw th;
        }
    }

    public static byte[] getByte(File file) {
        byte[] bArr = new byte[((int) file.length())];
        try {
            try {
                new FileInputStream(file).read(bArr);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bArr;
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String getMD5(byte[] bArr) {
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
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isSameFile(File file, File file2) {
        return getMD5(file).equals(getMD5(file2));
    }

    public static String getMD5(File file) {
        return getMD5(getByte(file));
    }
}
