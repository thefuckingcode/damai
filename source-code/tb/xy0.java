package tb;

import java.io.ByteArrayOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: Taobao */
public class xy0 {
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0053 A[DONT_GENERATE] */
    public String getResponse(String str) {
        HttpURLConnection httpURLConnection;
        Throwable th;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.connect();
                if (httpURLConnection.getResponseCode() == 200) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = httpURLConnection.getInputStream().read(bArr);
                        if (-1 != read) {
                            byteArrayOutputStream.write(bArr, 0, read);
                        } else {
                            String str2 = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                            httpURLConnection.disconnect();
                            return str2;
                        }
                    }
                } else {
                    httpURLConnection.disconnect();
                    return "";
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    th.printStackTrace();
                    return null;
                } finally {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
            th.printStackTrace();
            return null;
        }
    }
}
