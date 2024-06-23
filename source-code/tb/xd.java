package tb;

/* compiled from: Taobao */
public class xd {
    public static int a(byte[] bArr, int i) {
        return bArr[i] & 255;
    }

    public static int b(byte[] bArr, int i) {
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8);
    }

    public static int c(byte[] bArr, int i) {
        return (bArr[i] & 255) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 1] & 255) << 8);
    }

    public static int d(byte[] bArr, int i) {
        return (bArr[i] & 255) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 1] & 255) << 8);
    }

    public static double e(byte[] bArr, int i) {
        return Double.longBitsToDouble(f(bArr, i));
    }

    public static long f(byte[] bArr, int i) {
        return ((long) (bArr[i] & 255)) | (((long) (bArr[i + 7] & 255)) << 56) | (((long) (bArr[i + 6] & 255)) << 48) | (((long) (bArr[i + 5] & 255)) << 40) | (((long) (bArr[i + 4] & 255)) << 32) | (((long) (bArr[i + 3] & 255)) << 24) | (((long) (bArr[i + 2] & 255)) << 16) | (((long) (bArr[i + 1] & 255)) << 8);
    }
}
