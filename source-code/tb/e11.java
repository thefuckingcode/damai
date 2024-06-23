package tb;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
public class e11 {
    public static String a(InputStream inputStream, OutputStream outputStream) throws NoSuchAlgorithmException, IOException {
        MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr, 0, 4096);
            if (read == -1) {
                return ta1.b(instance);
            }
            instance.update(bArr, 0, read);
            outputStream.write(bArr, 0, read);
        }
    }
}
