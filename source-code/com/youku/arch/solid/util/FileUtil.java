package com.youku.arch.solid.util;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.upsplayer.util.YKUpsConvert;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
public class FileUtil {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final char[] HEX_DIGITS = {YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String byteToHexString(byte[] bArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-172745713")) {
            return (String) ipChange.ipc$dispatch("-172745713", new Object[]{bArr});
        }
        char[] cArr = new char[32];
        int i = 0;
        for (int i2 = 0; i2 < 16; i2++) {
            byte b = bArr[i2];
            int i3 = i + 1;
            char[] cArr2 = HEX_DIGITS;
            cArr[i] = cArr2[(b >>> 4) & 15];
            i = i3 + 1;
            cArr[i3] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public static void close(Closeable closeable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1270113104")) {
            ipChange.ipc$dispatch("1270113104", new Object[]{closeable});
        } else if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static String computeFileMD5(File file) {
        Closeable closeable;
        Throwable th;
        Closeable closeable2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1798484675")) {
            return (String) ipChange.ipc$dispatch("-1798484675", new Object[]{file});
        } else if (file == null || !file.exists()) {
            return "";
        } else {
            FileInputStream fileInputStream = null;
            try {
                MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    FileChannel channel = fileInputStream2.getChannel();
                    ByteBuffer allocate = ByteBuffer.allocate(102400);
                    while (true) {
                        int read = channel.read(allocate);
                        if (read != -1) {
                            instance.update(allocate.array(), 0, read);
                            allocate.position(0);
                            Thread.sleep(1);
                        } else {
                            String byteToHexString = byteToHexString(instance.digest());
                            close(fileInputStream2);
                            close(channel);
                            return byteToHexString;
                        }
                    }
                } catch (Exception unused) {
                    closeable = null;
                    fileInputStream = fileInputStream2;
                    close(fileInputStream);
                    close(closeable);
                    return "";
                } catch (Throwable th2) {
                    th = th2;
                    closeable2 = null;
                    fileInputStream = fileInputStream2;
                    close(fileInputStream);
                    close(closeable2);
                    throw th;
                }
            } catch (Exception unused2) {
                closeable = null;
                close(fileInputStream);
                close(closeable);
                return "";
            } catch (Throwable th3) {
                th = th3;
                closeable2 = null;
                close(fileInputStream);
                close(closeable2);
                throw th;
            }
        }
    }
}
