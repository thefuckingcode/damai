package tb;

import androidx.core.view.MotionEventCompat;
import com.taobao.pexode.Pexode;
import java.io.ByteArrayInputStream;

/* compiled from: Taobao */
public class vd1 {
    public static final byte[] APNG_ACTL_BYTES = {97, 99, 84, 76};
    public static final int APNG_ACTL_OFFSET = 37;
    public static final int BMP_HEADER_LENGTH = 2;
    public static final int GIF_HEADER_LENGTH = 6;
    public static final int HEIF_HEADER_LENGTH = 4;
    public static final int JPEG_HEADER_LENGTH = 2;
    public static final byte[] PNG_HEADER = {-119, 80, 78, 71, 13, 10, 26, 10};
    public static final int PNG_HEADER_LENGTH = 41;
    public static final int WEBP_A_HEADER_LENGTH = 21;
    public static final int WEBP_HEADER_LENGTH = 21;
    private static final byte[] a = a("RIFF");
    private static final byte[] b = a("WEBP");
    private static final byte[] c = a("VP8X");
    private static final byte[] d = a("GIF87a");
    private static final byte[] e = a("GIF89a");
    private static final byte[] f = a("BM");
    private static final byte[] g = a("heic");

    public static byte[] a(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (Exception e2) {
            kg0.c(Pexode.TAG, "check image format asciiBytes error=%s", e2);
            return null;
        }
    }

    public static boolean b(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        if (byteArrayInputStream.skip(33) != 33) {
            return false;
        }
        while (true) {
            try {
                byte[] n = n(byteArrayInputStream);
                if (n == null) {
                    break;
                }
                StringBuilder sb = new StringBuilder();
                int length = n.length;
                for (int i = 0; i < length; i++) {
                    sb.append(String.format("%02X", Byte.valueOf(n[i])));
                }
                int parseInt = Integer.parseInt(sb.toString(), 16);
                byte[] n2 = n(byteArrayInputStream);
                if (n2 == null) {
                    break;
                }
                String str = new String(n2);
                if (!"acTL".equals(str)) {
                    if (!"fcTL".equals(str) && !"IDAT".equals(str)) {
                        if ("fdAT".equals(str)) {
                            break;
                        }
                        long j = (long) (parseInt + 4);
                        if (byteArrayInputStream.skip(j) != j) {
                            break;
                        }
                    } else {
                        break;
                    }
                } else {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean c(byte[] bArr) {
        if (bArr == null || bArr.length < 2 || !m(bArr, 0, f)) {
            return false;
        }
        return true;
    }

    public static boolean d(byte[] bArr) {
        if (bArr == null || bArr.length < 6) {
            return false;
        }
        if (m(bArr, 0, d) || m(bArr, 0, e)) {
            return true;
        }
        return false;
    }

    public static boolean e(byte[] bArr) {
        return bArr != null && bArr.length >= 4 && m(bArr, 20, g);
    }

    public static boolean f(byte[] bArr) {
        if (bArr != null && bArr.length >= 2) {
            if (((bArr[1] & 255) | ((bArr[0] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK)) == 65496) {
                return true;
            }
        }
        return false;
    }

    public static boolean g(byte[] bArr) {
        if (bArr == null || bArr.length < 41 || !m(bArr, 0, PNG_HEADER) || b(bArr) || bArr[25] < 3) {
            return false;
        }
        return true;
    }

    public static boolean h(byte[] bArr) {
        if (bArr == null || bArr.length < 41 || !m(bArr, 0, PNG_HEADER) || b(bArr) || bArr[25] >= 3) {
            return false;
        }
        return true;
    }

    public static boolean i(byte[] bArr) {
        return bArr != null && l(bArr) && j(bArr);
    }

    private static boolean j(byte[] bArr) {
        return bArr.length >= 21 && m(bArr, 12, c) && (bArr[20] & 16) == 16;
    }

    public static boolean k(byte[] bArr) {
        return bArr != null && l(bArr) && !j(bArr);
    }

    private static boolean l(byte[] bArr) {
        return bArr.length >= 21 && m(bArr, 0, a) && m(bArr, 8, b);
    }

    public static boolean m(byte[] bArr, int i, byte[] bArr2) {
        if (bArr == null || bArr2 == null || i < 0 || bArr2.length + i > bArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[i2 + i] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private static byte[] n(ByteArrayInputStream byteArrayInputStream) {
        byte[] bArr = new byte[4];
        if (byteArrayInputStream.read(bArr, 0, 4) != 4) {
            return null;
        }
        return bArr;
    }
}
