package tb;

import com.efs.sdk.base.Constants;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: Taobao */
public final class t33 {
    public static byte[] a(byte[] bArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Exception e) {
            t43.c(Constants.TAG, "gzip error", e);
            return null;
        }
    }
}
