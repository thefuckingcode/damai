package tb;

import android.text.TextUtils;
import com.youku.upsplayer.util.YKUpsConvert;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
public class wb1 {
    private static final char[] a = {YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, 'a', 'b', 'c', 'd', 'e', 'f'};

    private static final String a(byte[] bArr) {
        char[] cArr = new char[32];
        int i = 0;
        for (int i2 = 0; i2 < 16; i2++) {
            byte b = bArr[i2];
            int i3 = i + 1;
            char[] cArr2 = a;
            cArr[i] = cArr2[(b >>> 4) & 15];
            i = i3 + 1;
            cArr[i3] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public static String b(String str) {
        try {
            return a(MessageDigest.getInstance(MessageDigestAlgorithms.MD5).digest(str.getBytes()));
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x006d A[SYNTHETIC, Splitter:B:35:0x006d] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0077 A[SYNTHETIC, Splitter:B:40:0x0077] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0083 A[SYNTHETIC, Splitter:B:47:0x0083] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x008d A[SYNTHETIC, Splitter:B:52:0x008d] */
    public static boolean c(String str, String str2) {
        FileChannel fileChannel;
        Throwable th;
        Exception e;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String lowerCase = str.toLowerCase();
        if (str2 == null) {
            return false;
        }
        FileInputStream fileInputStream = null;
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            FileInputStream fileInputStream2 = new FileInputStream(str2);
            try {
                FileChannel channel = fileInputStream2.getChannel();
                ByteBuffer allocate = ByteBuffer.allocate(102400);
                while (true) {
                    int read = channel.read(allocate);
                    if (read == -1) {
                        break;
                    }
                    instance.update(allocate.array(), 0, read);
                    allocate.position(0);
                    Thread.sleep(1);
                }
                boolean equals = a(instance.digest()).equals(lowerCase);
                try {
                    fileInputStream2.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                try {
                    channel.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                return equals;
            } catch (Exception e4) {
                e = e4;
                fileChannel = null;
                fileInputStream = fileInputStream2;
                try {
                    e.printStackTrace();
                    if (fileInputStream != null) {
                    }
                    if (fileChannel != null) {
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileChannel = null;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                }
                if (fileChannel != null) {
                }
                throw th;
            }
        } catch (Exception e7) {
            e = e7;
            fileChannel = null;
            e.printStackTrace();
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e8) {
                    e8.printStackTrace();
                }
            }
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (IOException e9) {
                    e9.printStackTrace();
                }
            }
            return false;
        } catch (Throwable th4) {
            th = th4;
            fileChannel = null;
            if (fileInputStream != null) {
            }
            if (fileChannel != null) {
            }
            throw th;
        }
    }
}
