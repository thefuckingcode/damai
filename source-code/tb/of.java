package tb;

/* compiled from: Taobao */
public class of {
    public static long a(long j, long j2) {
        long j3 = j + j2;
        return ((j3 * (1 + j3)) / 2) + j2;
    }

    public static void b(long j, long[] jArr) {
        if (jArr == null || jArr.length < 2) {
            jArr = new long[2];
        }
        long floor = (long) (Math.floor(Math.sqrt((double) ((8 * j) + 1)) - 1.0d) / 2.0d);
        long j2 = j - (((floor * floor) + floor) / 2);
        jArr[0] = floor - j2;
        jArr[1] = j2;
    }
}
