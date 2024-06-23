package com.uploader.implement.a.c;

import android.text.TextUtils;
import android.util.Pair;
import com.uploader.export.IUploaderTask;
import com.uploader.implement.a;
import com.youku.upsplayer.util.YKUpsConvert;
import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import tb.e23;
import tb.h13;
import tb.u91;

/* compiled from: Taobao */
public class b {
    public static Pair<h13, e23> a(IUploaderTask iUploaderTask) {
        if (iUploaderTask != null) {
            try {
                if (!TextUtils.isEmpty(iUploaderTask.getFilePath())) {
                    if (!TextUtils.isEmpty(iUploaderTask.getBizType())) {
                        e23 e23 = new e23();
                        e23.a = iUploaderTask.getFilePath();
                        e23.e = iUploaderTask.getBizType();
                        e23.h = iUploaderTask.getMetaInfo();
                        iUploaderTask.getFileType();
                        File file = new File(e23.a);
                        if (!file.exists()) {
                            return new Pair<>(new h13("200", "3", "!file.exists()", false), null);
                        }
                        if (file.length() == 0) {
                            return new Pair<>(new h13("200", "9", "file.length() == 0", false), null);
                        }
                        e23.b = file;
                        e23.c = file.getName();
                        Pair<String, byte[]> b = b(file);
                        e23.g = (String) b.first;
                        e23.k = (byte[]) b.second;
                        e23.d = UUID.randomUUID().toString().replaceAll("-", "");
                        e23.f = file.length();
                        e23.j = file.lastModified();
                        return new Pair<>(null, e23);
                    }
                }
            } catch (Exception e) {
                if (a.d(16)) {
                    a.b(16, "ProtocolUtils", "createFileDescription", e);
                }
                return new Pair<>(new h13("200", "4", e.toString(), false), null);
            }
        }
        return new Pair<>(new h13("200", "4", "task getFilePath == null || getBizType == null", false), null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x005f A[SYNTHETIC, Splitter:B:33:0x005f] */
    public static Pair<String, byte[]> b(File file) throws Exception {
        ByteBuffer byteBuffer;
        Throwable th;
        Exception e;
        FileInputStream fileInputStream;
        try {
            byteBuffer = ByteBuffer.allocate(204800);
        } catch (OutOfMemoryError unused) {
            byteBuffer = ByteBuffer.allocate(131072);
        }
        FileInputStream fileInputStream2 = null;
        byte[] bArr = null;
        fileInputStream2 = null;
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            fileInputStream = new FileInputStream(file);
            int i = 0;
            while (true) {
                int read = fileInputStream.getChannel().read(byteBuffer);
                if (read <= 0) {
                    break;
                }
                instance.update(byteBuffer.array(), byteBuffer.arrayOffset(), read);
                byteBuffer.clear();
                i++;
            }
            String d = d(instance.digest());
            if (i == 1) {
                bArr = byteBuffer.array();
            }
            Pair<String, byte[]> pair = new Pair<>(d, bArr);
            try {
                fileInputStream.close();
            } catch (Exception unused2) {
            }
            return pair;
        } catch (NoSuchAlgorithmException e2) {
            throw e2;
        } catch (Exception e3) {
            e = e3;
            throw e;
        } catch (NoSuchAlgorithmException e4) {
            throw e4;
        } catch (Exception e5) {
            e = e5;
            fileInputStream2 = fileInputStream;
            throw e;
        } catch (Throwable th2) {
            th = th2;
            if (fileInputStream2 != null) {
            }
            throw th;
        }
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    private static String d(byte[] bArr) {
        char[] cArr = {YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, YKUpsConvert.CHAR_A, 'B', 'C', u91.LEVEL_D, u91.LEVEL_E, YKUpsConvert.CHAR_F};
        char[] cArr2 = new char[(bArr.length * 2)];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            cArr2[i] = cArr[(b >>> 4) & 15];
            i = i2 + 1;
            cArr2[i2] = cArr[b & 15];
        }
        return new String(cArr2);
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }
}
