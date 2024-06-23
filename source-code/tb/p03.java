package tb;

import android.util.Pair;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: Taobao */
public abstract class p03 {
    private static void a(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    private static int b(ByteBuffer byteBuffer) {
        a(byteBuffer);
        int capacity = byteBuffer.capacity();
        if (capacity < 22) {
            return -1;
        }
        int i = capacity - 22;
        int min = Math.min(i, 65535);
        for (int i2 = 0; i2 <= min; i2++) {
            int i3 = i - i2;
            if (byteBuffer.getInt(i3) == 101010256 && d(byteBuffer, i3 + 20) == i2) {
                return i3;
            }
        }
        return -1;
    }

    private static Pair<ByteBuffer, Long> c(RandomAccessFile randomAccessFile, int i) throws IOException {
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException("maxCommentSize: " + i);
        }
        long length = randomAccessFile.length();
        if (length < 22) {
            return null;
        }
        ByteBuffer allocate = ByteBuffer.allocate(((int) Math.min((long) i, length - 22)) + 22);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        allocate.order(byteOrder);
        long capacity = length - ((long) allocate.capacity());
        randomAccessFile.seek(capacity);
        randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
        int b = b(allocate);
        if (b == -1) {
            return null;
        }
        allocate.position(b);
        ByteBuffer slice = allocate.slice();
        slice.order(byteOrder);
        return Pair.create(slice, Long.valueOf(capacity + ((long) b)));
    }

    private static int d(ByteBuffer byteBuffer, int i) {
        return byteBuffer.getShort(i) & dq2.MAX_VALUE;
    }

    private static long e(ByteBuffer byteBuffer, int i) {
        return ((long) byteBuffer.getInt(i)) & 4294967295L;
    }

    private static void f(ByteBuffer byteBuffer, int i, long j) {
        if (j < 0 || j > 4294967295L) {
            throw new IllegalArgumentException("uint32 value of out range: " + j);
        }
        byteBuffer.putInt(byteBuffer.position() + i, (int) j);
    }

    public static Pair<ByteBuffer, Long> findZipEndOfCentralDirectoryRecord(RandomAccessFile randomAccessFile) throws IOException {
        if (randomAccessFile.length() < 22) {
            return null;
        }
        Pair<ByteBuffer, Long> c = c(randomAccessFile, 0);
        if (c != null) {
            return c;
        }
        return c(randomAccessFile, 65535);
    }

    public static long getZipEocdCentralDirectoryOffset(ByteBuffer byteBuffer) {
        a(byteBuffer);
        return e(byteBuffer, byteBuffer.position() + 16);
    }

    public static long getZipEocdCentralDirectorySizeBytes(ByteBuffer byteBuffer) {
        a(byteBuffer);
        return e(byteBuffer, byteBuffer.position() + 12);
    }

    public static final boolean isZip64EndOfCentralDirectoryLocatorPresent(RandomAccessFile randomAccessFile, long j) throws IOException {
        long j2 = j - 20;
        if (j2 < 0) {
            return false;
        }
        randomAccessFile.seek(j2);
        if (randomAccessFile.readInt() == 1347094023) {
            return true;
        }
        return false;
    }

    public static void setZipEocdCentralDirectoryOffset(ByteBuffer byteBuffer, long j) {
        a(byteBuffer);
        f(byteBuffer, byteBuffer.position() + 16, j);
    }
}
