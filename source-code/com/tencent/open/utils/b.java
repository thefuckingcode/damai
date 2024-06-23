package com.tencent.open.utils;

import com.alibaba.analytics.core.sync.UploadQueueMgr;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Properties;
import java.util.zip.ZipException;
import tb.jl1;

/* compiled from: Taobao */
public final class b {
    private static final n a = new n(101010256);
    private static final o b = new o(38651);

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a {
        Properties a;
        byte[] b;

        private a() {
            this.a = new Properties();
        }

        /* access modifiers changed from: package-private */
        public void a(byte[] bArr) throws IOException {
            if (bArr != null) {
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                int length = b.b.a().length;
                byte[] bArr2 = new byte[length];
                wrap.get(bArr2);
                if (!b.b.equals(new o(bArr2))) {
                    throw new ProtocolException("unknow protocl [" + Arrays.toString(bArr) + jl1.ARRAY_END_STR);
                } else if (bArr.length - length > 2) {
                    byte[] bArr3 = new byte[2];
                    wrap.get(bArr3);
                    int b2 = new o(bArr3).b();
                    if ((bArr.length - length) - 2 >= b2) {
                        byte[] bArr4 = new byte[b2];
                        wrap.get(bArr4);
                        this.a.load(new ByteArrayInputStream(bArr4));
                        int length2 = ((bArr.length - length) - b2) - 2;
                        if (length2 > 0) {
                            byte[] bArr5 = new byte[length2];
                            this.b = bArr5;
                            wrap.get(bArr5);
                        }
                    }
                }
            }
        }

        public String toString() {
            return "ApkExternalInfo [p=" + this.a + ", otherData=" + Arrays.toString(this.b) + jl1.ARRAY_END_STR;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002a  */
    public static String a(File file, String str) throws IOException {
        Throwable th;
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, UploadQueueMgr.MSGTYPE_REALTIME);
            try {
                byte[] a2 = a(randomAccessFile2);
                if (a2 == null) {
                    randomAccessFile2.close();
                    return null;
                }
                a aVar = new a();
                aVar.a(a2);
                String property = aVar.a.getProperty(str);
                randomAccessFile2.close();
                return property;
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (randomAccessFile != null) {
            }
            throw th;
        }
    }

    public static String a(File file) throws IOException {
        return a(file, "channelNo");
    }

    private static byte[] a(RandomAccessFile randomAccessFile) throws IOException {
        boolean z;
        long length = randomAccessFile.length() - 22;
        randomAccessFile.seek(length);
        byte[] a2 = a.a();
        int read = randomAccessFile.read();
        while (true) {
            z = true;
            if (read != -1) {
                if (read == a2[0] && randomAccessFile.read() == a2[1] && randomAccessFile.read() == a2[2] && randomAccessFile.read() == a2[3]) {
                    break;
                }
                length--;
                randomAccessFile.seek(length);
                read = randomAccessFile.read();
            } else {
                z = false;
                break;
            }
        }
        if (z) {
            randomAccessFile.seek(length + 16 + 4);
            byte[] bArr = new byte[2];
            randomAccessFile.readFully(bArr);
            int b2 = new o(bArr).b();
            if (b2 == 0) {
                return null;
            }
            byte[] bArr2 = new byte[b2];
            randomAccessFile.read(bArr2);
            return bArr2;
        }
        throw new ZipException("archive is not a ZIP archive");
    }
}
