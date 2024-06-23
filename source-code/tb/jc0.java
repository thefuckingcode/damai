package tb;

public final class jc0 {
    public static final long MAX_MILLIS;
    public static final long MAX_NANOS;
    public static final int NANOS_IN_MILLIS;

    public static final long d(long j, int i) {
        return gc0.e((j << 1) + ((long) i));
    }

    public static final long e(long j) {
        return gc0.e((j << 1) + 1);
    }

    public static final long f(long j) {
        return j * ((long) 1000000);
    }
}
