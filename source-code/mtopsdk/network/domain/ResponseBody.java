package mtopsdk.network.domain;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.network.util.NetworkUtils;

/* compiled from: Taobao */
public abstract class ResponseBody {
    private static final String TAG = "mtopsdk.ResponseBody";
    private byte[] bodyBytes = null;

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0056 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0057  */
    private byte[] readBytes() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        DataInputStream dataInputStream;
        byte[] bArr;
        Exception e;
        long contentLength = contentLength();
        if (contentLength <= 2147483647L) {
            DataInputStream dataInputStream2 = null;
            try {
                dataInputStream = new DataInputStream(byteStream());
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (Exception e2) {
                    e = e2;
                    byteArrayOutputStream = null;
                    try {
                        TBSdkLog.e(TAG, "[readBytes] read bytes from byteStream error.", e);
                        NetworkUtils.closeQuietly(dataInputStream);
                        NetworkUtils.closeQuietly(byteArrayOutputStream);
                        bArr = null;
                        if (bArr != null) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        dataInputStream2 = dataInputStream;
                        NetworkUtils.closeQuietly(dataInputStream2);
                        NetworkUtils.closeQuietly(byteArrayOutputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayOutputStream = null;
                    dataInputStream2 = dataInputStream;
                    NetworkUtils.closeQuietly(dataInputStream2);
                    NetworkUtils.closeQuietly(byteArrayOutputStream);
                    throw th;
                }
                try {
                    byte[] bArr2 = new byte[1024];
                    while (true) {
                        int read = dataInputStream.read(bArr2);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    }
                    byteArrayOutputStream.flush();
                    bArr = byteArrayOutputStream.toByteArray();
                    NetworkUtils.closeQuietly(dataInputStream);
                    NetworkUtils.closeQuietly(byteArrayOutputStream);
                } catch (Exception e3) {
                    e = e3;
                    TBSdkLog.e(TAG, "[readBytes] read bytes from byteStream error.", e);
                    NetworkUtils.closeQuietly(dataInputStream);
                    NetworkUtils.closeQuietly(byteArrayOutputStream);
                    bArr = null;
                    if (bArr != null) {
                    }
                }
            } catch (Exception e4) {
                e = e4;
                byteArrayOutputStream = null;
                dataInputStream = null;
                TBSdkLog.e(TAG, "[readBytes] read bytes from byteStream error.", e);
                NetworkUtils.closeQuietly(dataInputStream);
                NetworkUtils.closeQuietly(byteArrayOutputStream);
                bArr = null;
                if (bArr != null) {
                }
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream = null;
                NetworkUtils.closeQuietly(dataInputStream2);
                NetworkUtils.closeQuietly(byteArrayOutputStream);
                throw th;
            }
            if (bArr != null) {
                return null;
            }
            if (contentLength == -1 || contentLength == ((long) bArr.length)) {
                return bArr;
            }
            throw new IOException("Content-Length and stream length disagree");
        }
        throw new IOException("Cannot buffer entire body for content length: " + contentLength);
    }

    public abstract InputStream byteStream();

    public abstract long contentLength() throws IOException;

    public abstract String contentType();

    public byte[] getBytes() throws IOException {
        if (this.bodyBytes == null) {
            this.bodyBytes = readBytes();
        }
        return this.bodyBytes;
    }
}
