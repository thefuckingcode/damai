package okio.internal;

import com.tencent.smtt.sdk.TbsListener;
import java.io.EOFException;
import kotlin.UByte;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.text.Typography;
import okhttp3.internal.connection.RealConnection;
import okio.Buffer;
import okio.ByteString;
import okio.Options;
import okio.Platform;
import okio.Segment;
import okio.SegmentPool;
import okio.SegmentedByteString;
import okio.Sink;
import okio.Source;
import okio.Utf8;
import okio.Util;

public final class BufferKt {
    private static final byte[] HEX_DIGIT_BYTES = Platform.asUtf8ToByteArray("0123456789abcdef");
    public static final long OVERFLOW_DIGIT_START;
    public static final long OVERFLOW_ZONE;
    public static final int SEGMENTING_THRESHOLD;

    public static final byte[] getHEX_DIGIT_BYTES() {
        return HEX_DIGIT_BYTES;
    }

    public static final boolean rangeEquals(Segment segment, int i, byte[] bArr, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(segment, "segment");
        Intrinsics.checkParameterIsNotNull(bArr, "bytes");
        int i4 = segment.limit;
        byte[] bArr2 = segment.data;
        while (i2 < i3) {
            if (i == i4) {
                segment = segment.next;
                if (segment == null) {
                    Intrinsics.throwNpe();
                }
                byte[] bArr3 = segment.data;
                bArr2 = bArr3;
                i = segment.pos;
                i4 = segment.limit;
            }
            if (bArr2[i] != bArr[i2]) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    public static final String readUtf8Line(Buffer buffer, long j) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$readUtf8Line");
        if (j > 0) {
            long j2 = j - 1;
            if (buffer.getByte(j2) == ((byte) 13)) {
                String readUtf8 = buffer.readUtf8(j2);
                buffer.skip(2);
                return readUtf8;
            }
        }
        String readUtf82 = buffer.readUtf8(j);
        buffer.skip(1);
        return readUtf82;
    }

    public static final <T> T seek(Buffer buffer, long j, Function2<? super Segment, ? super Long, ? extends T> function2) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$seek");
        Intrinsics.checkParameterIsNotNull(function2, "lambda");
        Segment segment = buffer.head;
        if (segment == null) {
            return (T) function2.invoke(null, -1L);
        }
        if (buffer.size() - j < j) {
            long size = buffer.size();
            while (size > j) {
                segment = segment.prev;
                if (segment == null) {
                    Intrinsics.throwNpe();
                }
                size -= (long) (segment.limit - segment.pos);
            }
            return (T) function2.invoke(segment, Long.valueOf(size));
        }
        long j2 = 0;
        while (true) {
            long j3 = ((long) (segment.limit - segment.pos)) + j2;
            if (j3 > j) {
                return (T) function2.invoke(segment, Long.valueOf(j2));
            }
            segment = segment.next;
            if (segment == null) {
                Intrinsics.throwNpe();
            }
            j2 = j3;
        }
    }

    public static /* synthetic */ int selectPrefix$default(Buffer buffer, Options options, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return selectPrefix(buffer, options, z);
    }

    public static final int selectPrefix(Buffer buffer, Options options, boolean z) {
        int i;
        int i2;
        int i3;
        Segment segment;
        int i4;
        Intrinsics.checkParameterIsNotNull(buffer, "$this$selectPrefix");
        Intrinsics.checkParameterIsNotNull(options, "options");
        Segment segment2 = buffer.head;
        if (segment2 != null) {
            byte[] bArr = segment2.data;
            int i5 = segment2.pos;
            int i6 = segment2.limit;
            int[] trie$okio = options.getTrie$okio();
            Segment segment3 = segment2;
            int i7 = 0;
            int i8 = -1;
            loop0:
            while (true) {
                int i9 = i7 + 1;
                int i10 = trie$okio[i7];
                int i11 = i9 + 1;
                int i12 = trie$okio[i9];
                if (i12 != -1) {
                    i8 = i12;
                }
                if (segment3 == null) {
                    break;
                }
                if (i10 < 0) {
                    int i13 = i11 + (i10 * -1);
                    while (true) {
                        int i14 = i5 + 1;
                        int i15 = i11 + 1;
                        if ((bArr[i5] & UByte.MAX_VALUE) != trie$okio[i11]) {
                            return i8;
                        }
                        boolean z2 = i15 == i13;
                        if (i14 == i6) {
                            if (segment3 == null) {
                                Intrinsics.throwNpe();
                            }
                            Segment segment4 = segment3.next;
                            if (segment4 == null) {
                                Intrinsics.throwNpe();
                            }
                            i4 = segment4.pos;
                            byte[] bArr2 = segment4.data;
                            i3 = segment4.limit;
                            if (segment4 == segment2) {
                                if (!z2) {
                                    break loop0;
                                }
                                segment4 = null;
                            }
                            segment = segment4;
                            bArr = bArr2;
                        } else {
                            i3 = i6;
                            i4 = i14;
                            segment = segment3;
                        }
                        if (z2) {
                            i2 = trie$okio[i15];
                            i = i4;
                            i6 = i3;
                            segment3 = segment;
                            break;
                        }
                        i5 = i4;
                        i6 = i3;
                        i11 = i15;
                        segment3 = segment;
                    }
                } else {
                    i = i5 + 1;
                    int i16 = bArr[i5] & UByte.MAX_VALUE;
                    int i17 = i11 + i10;
                    while (i11 != i17) {
                        if (i16 == trie$okio[i11]) {
                            i2 = trie$okio[i11 + i10];
                            if (i == i6) {
                                segment3 = segment3.next;
                                if (segment3 == null) {
                                    Intrinsics.throwNpe();
                                }
                                int i18 = segment3.pos;
                                byte[] bArr3 = segment3.data;
                                int i19 = segment3.limit;
                                if (segment3 == segment2) {
                                    segment3 = null;
                                }
                                i = i18;
                                bArr = bArr3;
                                i6 = i19;
                            }
                        } else {
                            i11++;
                        }
                    }
                    return i8;
                }
                if (i2 >= 0) {
                    return i2;
                }
                i7 = -i2;
                i5 = i;
            }
            if (z) {
                return -2;
            }
            return i8;
        } else if (z) {
            return -2;
        } else {
            return -1;
        }
    }

    public static final Buffer commonCopyTo(Buffer buffer, Buffer buffer2, long j, long j2) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonCopyTo");
        Intrinsics.checkParameterIsNotNull(buffer2, "out");
        Util.checkOffsetAndCount(buffer.size(), j, j2);
        if (j2 == 0) {
            return buffer;
        }
        buffer2.setSize$okio(buffer2.size() + j2);
        Segment segment = buffer.head;
        while (true) {
            if (segment == null) {
                Intrinsics.throwNpe();
            }
            if (j < ((long) (segment.limit - segment.pos))) {
                break;
            }
            j -= (long) (segment.limit - segment.pos);
            segment = segment.next;
        }
        while (j2 > 0) {
            if (segment == null) {
                Intrinsics.throwNpe();
            }
            Segment sharedCopy = segment.sharedCopy();
            sharedCopy.pos += (int) j;
            sharedCopy.limit = Math.min(sharedCopy.pos + ((int) j2), sharedCopy.limit);
            if (buffer2.head == null) {
                sharedCopy.prev = sharedCopy;
                sharedCopy.next = sharedCopy.prev;
                buffer2.head = sharedCopy.next;
            } else {
                Segment segment2 = buffer2.head;
                if (segment2 == null) {
                    Intrinsics.throwNpe();
                }
                Segment segment3 = segment2.prev;
                if (segment3 == null) {
                    Intrinsics.throwNpe();
                }
                segment3.push(sharedCopy);
            }
            j2 -= (long) (sharedCopy.limit - sharedCopy.pos);
            segment = segment.next;
            j = 0;
        }
        return buffer;
    }

    public static final long commonCompleteSegmentByteCount(Buffer buffer) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonCompleteSegmentByteCount");
        long size = buffer.size();
        if (size == 0) {
            return 0;
        }
        Segment segment = buffer.head;
        if (segment == null) {
            Intrinsics.throwNpe();
        }
        Segment segment2 = segment.prev;
        if (segment2 == null) {
            Intrinsics.throwNpe();
        }
        return (segment2.limit >= 8192 || !segment2.owner) ? size : size - ((long) (segment2.limit - segment2.pos));
    }

    public static final byte commonReadByte(Buffer buffer) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonReadByte");
        if (buffer.size() != 0) {
            Segment segment = buffer.head;
            if (segment == null) {
                Intrinsics.throwNpe();
            }
            int i = segment.pos;
            int i2 = segment.limit;
            int i3 = i + 1;
            byte b = segment.data[i];
            buffer.setSize$okio(buffer.size() - 1);
            if (i3 == i2) {
                buffer.head = segment.pop();
                SegmentPool.INSTANCE.recycle(segment);
            } else {
                segment.pos = i3;
            }
            return b;
        }
        throw new EOFException();
    }

    public static final short commonReadShort(Buffer buffer) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonReadShort");
        if (buffer.size() >= 2) {
            Segment segment = buffer.head;
            if (segment == null) {
                Intrinsics.throwNpe();
            }
            int i = segment.pos;
            int i2 = segment.limit;
            if (i2 - i < 2) {
                return (short) ((buffer.readByte() & UByte.MAX_VALUE) | ((buffer.readByte() & UByte.MAX_VALUE) << 8));
            }
            byte[] bArr = segment.data;
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = ((bArr[i] & UByte.MAX_VALUE) << 8) | (bArr[i3] & UByte.MAX_VALUE);
            buffer.setSize$okio(buffer.size() - 2);
            if (i4 == i2) {
                buffer.head = segment.pop();
                SegmentPool.INSTANCE.recycle(segment);
            } else {
                segment.pos = i4;
            }
            return (short) i5;
        }
        throw new EOFException();
    }

    public static final int commonReadInt(Buffer buffer) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonReadInt");
        if (buffer.size() >= 4) {
            Segment segment = buffer.head;
            if (segment == null) {
                Intrinsics.throwNpe();
            }
            int i = segment.pos;
            int i2 = segment.limit;
            if (((long) (i2 - i)) < 4) {
                return (buffer.readByte() & UByte.MAX_VALUE) | ((buffer.readByte() & UByte.MAX_VALUE) << 24) | ((buffer.readByte() & UByte.MAX_VALUE) << 16) | ((buffer.readByte() & UByte.MAX_VALUE) << 8);
            }
            byte[] bArr = segment.data;
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = ((bArr[i] & UByte.MAX_VALUE) << 24) | ((bArr[i3] & UByte.MAX_VALUE) << 16);
            int i6 = i4 + 1;
            int i7 = i5 | ((bArr[i4] & UByte.MAX_VALUE) << 8);
            int i8 = i6 + 1;
            int i9 = i7 | (bArr[i6] & UByte.MAX_VALUE);
            buffer.setSize$okio(buffer.size() - 4);
            if (i8 == i2) {
                buffer.head = segment.pop();
                SegmentPool.INSTANCE.recycle(segment);
            } else {
                segment.pos = i8;
            }
            return i9;
        }
        throw new EOFException();
    }

    public static final long commonReadLong(Buffer buffer) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonReadLong");
        if (buffer.size() >= 8) {
            Segment segment = buffer.head;
            if (segment == null) {
                Intrinsics.throwNpe();
            }
            int i = segment.pos;
            int i2 = segment.limit;
            if (((long) (i2 - i)) < 8) {
                return ((((long) buffer.readInt()) & 4294967295L) << 32) | (4294967295L & ((long) buffer.readInt()));
            }
            byte[] bArr = segment.data;
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = i4 + 1;
            long j = ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i3]) & 255) << 48) | ((((long) bArr[i4]) & 255) << 40);
            int i6 = i5 + 1;
            long j2 = ((((long) bArr[i5]) & 255) << 32) | j;
            int i7 = i6 + 1;
            int i8 = i7 + 1;
            long j3 = j2 | ((((long) bArr[i6]) & 255) << 24) | ((((long) bArr[i7]) & 255) << 16);
            int i9 = i8 + 1;
            int i10 = i9 + 1;
            long j4 = j3 | ((((long) bArr[i8]) & 255) << 8) | (((long) bArr[i9]) & 255);
            buffer.setSize$okio(buffer.size() - 8);
            if (i10 == i2) {
                buffer.head = segment.pop();
                SegmentPool.INSTANCE.recycle(segment);
            } else {
                segment.pos = i10;
            }
            return j4;
        }
        throw new EOFException();
    }

    public static final byte commonGet(Buffer buffer, long j) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonGet");
        Util.checkOffsetAndCount(buffer.size(), j, 1);
        Segment segment = buffer.head;
        if (segment == null) {
            Segment segment2 = null;
            Intrinsics.throwNpe();
            return segment2.data[(int) ((((long) segment2.pos) + j) - -1)];
        } else if (buffer.size() - j < j) {
            long size = buffer.size();
            while (size > j) {
                segment = segment.prev;
                if (segment == null) {
                    Intrinsics.throwNpe();
                }
                size -= (long) (segment.limit - segment.pos);
            }
            if (segment == null) {
                Intrinsics.throwNpe();
            }
            return segment.data[(int) ((((long) segment.pos) + j) - size)];
        } else {
            long j2 = 0;
            while (true) {
                long j3 = ((long) (segment.limit - segment.pos)) + j2;
                if (j3 > j) {
                    break;
                }
                segment = segment.next;
                if (segment == null) {
                    Intrinsics.throwNpe();
                }
                j2 = j3;
            }
            if (segment == null) {
                Intrinsics.throwNpe();
            }
            return segment.data[(int) ((((long) segment.pos) + j) - j2)];
        }
    }

    public static final void commonClear(Buffer buffer) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonClear");
        buffer.skip(buffer.size());
    }

    public static final void commonSkip(Buffer buffer, long j) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonSkip");
        while (j > 0) {
            Segment segment = buffer.head;
            if (segment != null) {
                int min = (int) Math.min(j, (long) (segment.limit - segment.pos));
                long j2 = (long) min;
                buffer.setSize$okio(buffer.size() - j2);
                j -= j2;
                segment.pos += min;
                if (segment.pos == segment.limit) {
                    buffer.head = segment.pop();
                    SegmentPool.INSTANCE.recycle(segment);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public static /* synthetic */ Buffer commonWrite$default(Buffer buffer, ByteString byteString, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = byteString.size();
        }
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonWrite");
        Intrinsics.checkParameterIsNotNull(byteString, "byteString");
        byteString.write$okio(buffer, i, i2);
        return buffer;
    }

    public static final Buffer commonWrite(Buffer buffer, ByteString byteString, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonWrite");
        Intrinsics.checkParameterIsNotNull(byteString, "byteString");
        byteString.write$okio(buffer, i, i2);
        return buffer;
    }

    public static final Buffer commonWriteDecimalLong(Buffer buffer, long j) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonWriteDecimalLong");
        if (j == 0) {
            return buffer.writeByte(48);
        }
        boolean z = false;
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return buffer.writeUtf8("-9223372036854775808");
            }
            z = true;
        }
        if (j >= 100000000) {
            i = j < 1000000000000L ? j < RealConnection.IDLE_CONNECTION_HEALTHY_NS ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i = 2;
        }
        if (z) {
            i++;
        }
        Segment writableSegment$okio = buffer.writableSegment$okio(i);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit + i;
        while (j != 0) {
            long j2 = (long) 10;
            i2--;
            bArr[i2] = getHEX_DIGIT_BYTES()[(int) (j % j2)];
            j /= j2;
        }
        if (z) {
            bArr[i2 - 1] = (byte) 45;
        }
        writableSegment$okio.limit += i;
        buffer.setSize$okio(buffer.size() + ((long) i));
        return buffer;
    }

    public static final Buffer commonWriteHexadecimalUnsignedLong(Buffer buffer, long j) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonWriteHexadecimalUnsignedLong");
        if (j == 0) {
            return buffer.writeByte(48);
        }
        long j2 = (j >>> 1) | j;
        long j3 = j2 | (j2 >>> 2);
        long j4 = j3 | (j3 >>> 4);
        long j5 = j4 | (j4 >>> 8);
        long j6 = j5 | (j5 >>> 16);
        long j7 = j6 | (j6 >>> 32);
        long j8 = j7 - ((j7 >>> 1) & 6148914691236517205L);
        long j9 = ((j8 >>> 2) & 3689348814741910323L) + (j8 & 3689348814741910323L);
        long j10 = ((j9 >>> 4) + j9) & 1085102592571150095L;
        long j11 = j10 + (j10 >>> 8);
        long j12 = j11 + (j11 >>> 16);
        int i = (int) ((((j12 & 63) + ((j12 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        Segment writableSegment$okio = buffer.writableSegment$okio(i);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        for (int i3 = (writableSegment$okio.limit + i) - 1; i3 >= i2; i3--) {
            bArr[i3] = getHEX_DIGIT_BYTES()[(int) (15 & j)];
            j >>>= 4;
        }
        writableSegment$okio.limit += i;
        buffer.setSize$okio(buffer.size() + ((long) i));
        return buffer;
    }

    public static final Segment commonWritableSegment(Buffer buffer, int i) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonWritableSegment");
        boolean z = true;
        if (i < 1 || i > 8192) {
            z = false;
        }
        if (!z) {
            throw new IllegalArgumentException("unexpected capacity".toString());
        } else if (buffer.head == null) {
            Segment take = SegmentPool.INSTANCE.take();
            buffer.head = take;
            take.prev = take;
            take.next = take;
            return take;
        } else {
            Segment segment = buffer.head;
            if (segment == null) {
                Intrinsics.throwNpe();
            }
            Segment segment2 = segment.prev;
            if (segment2 == null) {
                Intrinsics.throwNpe();
            }
            return (segment2.limit + i > 8192 || !segment2.owner) ? segment2.push(SegmentPool.INSTANCE.take()) : segment2;
        }
    }

    public static final Buffer commonWrite(Buffer buffer, byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonWrite");
        Intrinsics.checkParameterIsNotNull(bArr, "source");
        return buffer.write(bArr, 0, bArr.length);
    }

    public static final Buffer commonWrite(Buffer buffer, byte[] bArr, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonWrite");
        Intrinsics.checkParameterIsNotNull(bArr, "source");
        long j = (long) i2;
        Util.checkOffsetAndCount((long) bArr.length, (long) i, j);
        int i3 = i2 + i;
        while (i < i3) {
            Segment writableSegment$okio = buffer.writableSegment$okio(1);
            int min = Math.min(i3 - i, 8192 - writableSegment$okio.limit);
            int i4 = i + min;
            ArraysKt.copyInto(bArr, writableSegment$okio.data, writableSegment$okio.limit, i, i4);
            writableSegment$okio.limit += min;
            i = i4;
        }
        buffer.setSize$okio(buffer.size() + j);
        return buffer;
    }

    public static final byte[] commonReadByteArray(Buffer buffer) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonReadByteArray");
        return buffer.readByteArray(buffer.size());
    }

    public static final byte[] commonReadByteArray(Buffer buffer, long j) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonReadByteArray");
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j).toString());
        } else if (buffer.size() >= j) {
            byte[] bArr = new byte[((int) j)];
            buffer.readFully(bArr);
            return bArr;
        } else {
            throw new EOFException();
        }
    }

    public static final int commonRead(Buffer buffer, byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonRead");
        Intrinsics.checkParameterIsNotNull(bArr, "sink");
        return buffer.read(bArr, 0, bArr.length);
    }

    public static final void commonReadFully(Buffer buffer, byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonReadFully");
        Intrinsics.checkParameterIsNotNull(bArr, "sink");
        int i = 0;
        while (i < bArr.length) {
            int read = buffer.read(bArr, i, bArr.length - i);
            if (read != -1) {
                i += read;
            } else {
                throw new EOFException();
            }
        }
    }

    public static final int commonRead(Buffer buffer, byte[] bArr, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonRead");
        Intrinsics.checkParameterIsNotNull(bArr, "sink");
        Util.checkOffsetAndCount((long) bArr.length, (long) i, (long) i2);
        Segment segment = buffer.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i2, segment.limit - segment.pos);
        ArraysKt.copyInto(segment.data, bArr, i, segment.pos, segment.pos + min);
        segment.pos += min;
        buffer.setSize$okio(buffer.size() - ((long) min));
        if (segment.pos == segment.limit) {
            buffer.head = segment.pop();
            SegmentPool.INSTANCE.recycle(segment);
        }
        return min;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b9, code lost:
        if (r10 != r11) goto L_0x00c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00bb, code lost:
        r17.head = r16.pop();
        okio.SegmentPool.INSTANCE.recycle(r16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c9, code lost:
        r16.pos = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00cd, code lost:
        if (r7 != false) goto L_0x00d3;
     */
    public static final long commonReadDecimalLong(Buffer buffer) {
        Segment segment;
        byte b;
        boolean z;
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonReadDecimalLong");
        long j = 0;
        if (buffer.size() != 0) {
            long j2 = -7;
            int i = 0;
            boolean z2 = false;
            boolean z3 = false;
            loop0:
            do {
                Segment segment2 = buffer.head;
                if (segment2 == null) {
                    Intrinsics.throwNpe();
                }
                byte[] bArr = segment2.data;
                int i2 = segment2.pos;
                int i3 = segment2.limit;
                while (true) {
                    if (i2 >= i3) {
                        segment = segment2;
                        break;
                    }
                    b = bArr[i2];
                    byte b2 = (byte) 48;
                    if (b >= b2 && b <= ((byte) 57)) {
                        int i4 = b2 - b;
                        if (j < OVERFLOW_ZONE) {
                            break loop0;
                        }
                        z = z3;
                        segment = segment2;
                        if (j == OVERFLOW_ZONE && ((long) i4) < j2) {
                            break loop0;
                        }
                        j = (j * 10) + ((long) i4);
                    } else {
                        z = z3;
                        segment = segment2;
                        if (b == ((byte) 45) && i == 0) {
                            j2--;
                            z2 = true;
                        } else if (i != 0) {
                            z3 = true;
                        } else {
                            throw new NumberFormatException("Expected leading [0-9] or '-' character but was 0x" + Util.toHexString(b));
                        }
                    }
                    i2++;
                    i++;
                    z3 = z;
                    segment2 = segment;
                }
                Buffer writeByte = new Buffer().writeDecimalLong(j).writeByte((int) b);
                if (!z2) {
                    writeByte.readByte();
                }
                throw new NumberFormatException("Number too large: " + writeByte.readUtf8());
            } while (buffer.head != null);
            buffer.setSize$okio(buffer.size() - ((long) i));
            return z2 ? j : -j;
        }
        throw new EOFException();
    }

    public static final long commonReadHexadecimalUnsignedLong(Buffer buffer) {
        int i;
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonReadHexadecimalUnsignedLong");
        if (buffer.size() != 0) {
            int i2 = 0;
            long j = 0;
            boolean z = false;
            do {
                Segment segment = buffer.head;
                if (segment == null) {
                    Intrinsics.throwNpe();
                }
                byte[] bArr = segment.data;
                int i3 = segment.pos;
                int i4 = segment.limit;
                while (true) {
                    if (i3 >= i4) {
                        break;
                    }
                    byte b = bArr[i3];
                    byte b2 = (byte) 48;
                    if (b < b2 || b > ((byte) 57)) {
                        byte b3 = (byte) 97;
                        if ((b >= b3 && b <= ((byte) 102)) || (b >= (b3 = (byte) 65) && b <= ((byte) 70))) {
                            i = (b - b3) + 10;
                        } else if (i2 != 0) {
                            z = true;
                        } else {
                            throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Util.toHexString(b));
                        }
                    } else {
                        i = b - b2;
                    }
                    if ((-1152921504606846976L & j) == 0) {
                        j = (j << 4) | ((long) i);
                        i3++;
                        i2++;
                    } else {
                        Buffer writeByte = new Buffer().writeHexadecimalUnsignedLong(j).writeByte((int) b);
                        throw new NumberFormatException("Number too large: " + writeByte.readUtf8());
                    }
                }
                if (i3 == i4) {
                    buffer.head = segment.pop();
                    SegmentPool.INSTANCE.recycle(segment);
                } else {
                    segment.pos = i3;
                }
                if (z) {
                    break;
                }
            } while (buffer.head != null);
            buffer.setSize$okio(buffer.size() - ((long) i2));
            return j;
        }
        throw new EOFException();
    }

    public static final ByteString commonReadByteString(Buffer buffer) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonReadByteString");
        return buffer.readByteString(buffer.size());
    }

    public static final ByteString commonReadByteString(Buffer buffer, long j) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonReadByteString");
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j).toString());
        } else if (buffer.size() < j) {
            throw new EOFException();
        } else if (j < ((long) 4096)) {
            return new ByteString(buffer.readByteArray(j));
        } else {
            ByteString snapshot = buffer.snapshot((int) j);
            buffer.skip(j);
            return snapshot;
        }
    }

    public static final int commonSelect(Buffer buffer, Options options) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonSelect");
        Intrinsics.checkParameterIsNotNull(options, "options");
        int selectPrefix$default = selectPrefix$default(buffer, options, false, 2, null);
        if (selectPrefix$default == -1) {
            return -1;
        }
        buffer.skip((long) options.getByteStrings$okio()[selectPrefix$default].size());
        return selectPrefix$default;
    }

    public static final void commonReadFully(Buffer buffer, Buffer buffer2, long j) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonReadFully");
        Intrinsics.checkParameterIsNotNull(buffer2, "sink");
        if (buffer.size() >= j) {
            buffer2.write(buffer, j);
        } else {
            buffer2.write(buffer, buffer.size());
            throw new EOFException();
        }
    }

    public static final long commonReadAll(Buffer buffer, Sink sink) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonReadAll");
        Intrinsics.checkParameterIsNotNull(sink, "sink");
        long size = buffer.size();
        if (size > 0) {
            sink.write(buffer, size);
        }
        return size;
    }

    public static final String commonReadUtf8(Buffer buffer, long j) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonReadUtf8");
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j).toString());
        } else if (buffer.size() < j) {
            throw new EOFException();
        } else if (j == 0) {
            return "";
        } else {
            Segment segment = buffer.head;
            if (segment == null) {
                Intrinsics.throwNpe();
            }
            if (((long) segment.pos) + j > ((long) segment.limit)) {
                return _Utf8Kt.commonToUtf8String$default(buffer.readByteArray(j), 0, 0, 3, null);
            }
            int i = (int) j;
            String commonToUtf8String = _Utf8Kt.commonToUtf8String(segment.data, segment.pos, segment.pos + i);
            segment.pos += i;
            buffer.setSize$okio(buffer.size() - j);
            if (segment.pos == segment.limit) {
                buffer.head = segment.pop();
                SegmentPool.INSTANCE.recycle(segment);
            }
            return commonToUtf8String;
        }
    }

    public static final String commonReadUtf8Line(Buffer buffer) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonReadUtf8Line");
        long indexOf = buffer.indexOf((byte) 10);
        if (indexOf != -1) {
            return readUtf8Line(buffer, indexOf);
        }
        if (buffer.size() != 0) {
            return buffer.readUtf8(buffer.size());
        }
        return null;
    }

    public static final String commonReadUtf8LineStrict(Buffer buffer, long j) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonReadUtf8LineStrict");
        if (j >= 0) {
            long j2 = LongCompanionObject.MAX_VALUE;
            if (j != LongCompanionObject.MAX_VALUE) {
                j2 = j + 1;
            }
            byte b = (byte) 10;
            long indexOf = buffer.indexOf(b, 0, j2);
            if (indexOf != -1) {
                return readUtf8Line(buffer, indexOf);
            }
            if (j2 < buffer.size() && buffer.getByte(j2 - 1) == ((byte) 13) && buffer.getByte(j2) == b) {
                return readUtf8Line(buffer, j2);
            }
            Buffer buffer2 = new Buffer();
            buffer.copyTo(buffer2, 0, Math.min((long) 32, buffer.size()));
            throw new EOFException("\\n not found: limit=" + Math.min(buffer.size(), j) + " content=" + buffer2.readByteString().hex() + Typography.ellipsis);
        }
        throw new IllegalArgumentException(("limit < 0: " + j).toString());
    }

    public static final int commonReadUtf8CodePoint(Buffer buffer) {
        int i;
        int i2;
        int i3;
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonReadUtf8CodePoint");
        if (buffer.size() != 0) {
            byte b = buffer.getByte(0);
            if ((b & ByteCompanionObject.MIN_VALUE) == 0) {
                i3 = b & ByteCompanionObject.MAX_VALUE;
                i2 = 1;
                i = 0;
            } else if ((b & 224) == 192) {
                i3 = b & 31;
                i2 = 2;
                i = 128;
            } else if ((b & 240) == 224) {
                i3 = b & 15;
                i2 = 3;
                i = 2048;
            } else if ((b & 248) == 240) {
                i3 = b & 7;
                i2 = 4;
                i = 65536;
            } else {
                buffer.skip(1);
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            long j = (long) i2;
            if (buffer.size() >= j) {
                for (int i4 = 1; i4 < i2; i4++) {
                    long j2 = (long) i4;
                    byte b2 = buffer.getByte(j2);
                    if ((b2 & 192) == 128) {
                        i3 = (i3 << 6) | (b2 & Utf8.REPLACEMENT_BYTE);
                    } else {
                        buffer.skip(j2);
                        return Utf8.REPLACEMENT_CODE_POINT;
                    }
                }
                buffer.skip(j);
                if (i3 > 1114111) {
                    return Utf8.REPLACEMENT_CODE_POINT;
                }
                if ((55296 <= i3 && 57343 >= i3) || i3 < i) {
                    return Utf8.REPLACEMENT_CODE_POINT;
                }
                return i3;
            }
            throw new EOFException("size < " + i2 + ": " + buffer.size() + " (to read code point prefixed 0x" + Util.toHexString(b) + ')');
        }
        throw new EOFException();
    }

    public static final Buffer commonWriteUtf8(Buffer buffer, String str, int i, int i2) {
        int i3;
        char c;
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonWriteUtf8");
        Intrinsics.checkParameterIsNotNull(str, "string");
        if (i >= 0) {
            if (i2 >= i) {
                if (i2 <= str.length()) {
                    while (i < i2) {
                        char charAt = str.charAt(i);
                        if (charAt < 128) {
                            Segment writableSegment$okio = buffer.writableSegment$okio(1);
                            byte[] bArr = writableSegment$okio.data;
                            int i4 = writableSegment$okio.limit - i;
                            int min = Math.min(i2, 8192 - i4);
                            i3 = i + 1;
                            bArr[i + i4] = (byte) charAt;
                            while (i3 < min) {
                                char charAt2 = str.charAt(i3);
                                if (charAt2 >= 128) {
                                    break;
                                }
                                bArr[i3 + i4] = (byte) charAt2;
                                i3++;
                            }
                            int i5 = (i4 + i3) - writableSegment$okio.limit;
                            writableSegment$okio.limit += i5;
                            buffer.setSize$okio(buffer.size() + ((long) i5));
                        } else {
                            if (charAt < 2048) {
                                Segment writableSegment$okio2 = buffer.writableSegment$okio(2);
                                writableSegment$okio2.data[writableSegment$okio2.limit] = (byte) ((charAt >> 6) | 192);
                                writableSegment$okio2.data[writableSegment$okio2.limit + 1] = (byte) ((charAt & '?') | 128);
                                writableSegment$okio2.limit += 2;
                                buffer.setSize$okio(buffer.size() + 2);
                            } else if (charAt < 55296 || charAt > 57343) {
                                Segment writableSegment$okio3 = buffer.writableSegment$okio(3);
                                writableSegment$okio3.data[writableSegment$okio3.limit] = (byte) ((charAt >> '\f') | TbsListener.ErrorCode.EXCEED_INCR_UPDATE);
                                writableSegment$okio3.data[writableSegment$okio3.limit + 1] = (byte) ((63 & (charAt >> 6)) | 128);
                                writableSegment$okio3.data[writableSegment$okio3.limit + 2] = (byte) ((charAt & '?') | 128);
                                writableSegment$okio3.limit += 3;
                                buffer.setSize$okio(buffer.size() + 3);
                            } else {
                                i3 = i + 1;
                                if (i3 < i2) {
                                    c = str.charAt(i3);
                                } else {
                                    c = 0;
                                }
                                if (charAt > 56319 || 56320 > c || 57343 < c) {
                                    buffer.writeByte(63);
                                } else {
                                    int i6 = (((charAt & 1023) << 10) | (c & 1023)) + 65536;
                                    Segment writableSegment$okio4 = buffer.writableSegment$okio(4);
                                    writableSegment$okio4.data[writableSegment$okio4.limit] = (byte) ((i6 >> 18) | 240);
                                    writableSegment$okio4.data[writableSegment$okio4.limit + 1] = (byte) (((i6 >> 12) & 63) | 128);
                                    writableSegment$okio4.data[writableSegment$okio4.limit + 2] = (byte) (((i6 >> 6) & 63) | 128);
                                    writableSegment$okio4.data[writableSegment$okio4.limit + 3] = (byte) ((i6 & 63) | 128);
                                    writableSegment$okio4.limit += 4;
                                    buffer.setSize$okio(buffer.size() + 4);
                                    i += 2;
                                }
                            }
                            i++;
                        }
                        i = i3;
                    }
                    return buffer;
                }
                throw new IllegalArgumentException(("endIndex > string.length: " + i2 + " > " + str.length()).toString());
            }
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i2 + " < " + i).toString());
        }
        throw new IllegalArgumentException(("beginIndex < 0: " + i).toString());
    }

    public static final Buffer commonWriteUtf8CodePoint(Buffer buffer, int i) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonWriteUtf8CodePoint");
        if (i < 128) {
            buffer.writeByte(i);
        } else if (i < 2048) {
            Segment writableSegment$okio = buffer.writableSegment$okio(2);
            writableSegment$okio.data[writableSegment$okio.limit] = (byte) ((i >> 6) | 192);
            writableSegment$okio.data[writableSegment$okio.limit + 1] = (byte) ((i & 63) | 128);
            writableSegment$okio.limit += 2;
            buffer.setSize$okio(buffer.size() + 2);
        } else if (55296 <= i && 57343 >= i) {
            buffer.writeByte(63);
        } else if (i < 65536) {
            Segment writableSegment$okio2 = buffer.writableSegment$okio(3);
            writableSegment$okio2.data[writableSegment$okio2.limit] = (byte) ((i >> 12) | TbsListener.ErrorCode.EXCEED_INCR_UPDATE);
            writableSegment$okio2.data[writableSegment$okio2.limit + 1] = (byte) (((i >> 6) & 63) | 128);
            writableSegment$okio2.data[writableSegment$okio2.limit + 2] = (byte) ((i & 63) | 128);
            writableSegment$okio2.limit += 3;
            buffer.setSize$okio(buffer.size() + 3);
        } else if (i <= 1114111) {
            Segment writableSegment$okio3 = buffer.writableSegment$okio(4);
            writableSegment$okio3.data[writableSegment$okio3.limit] = (byte) ((i >> 18) | 240);
            writableSegment$okio3.data[writableSegment$okio3.limit + 1] = (byte) (((i >> 12) & 63) | 128);
            writableSegment$okio3.data[writableSegment$okio3.limit + 2] = (byte) (((i >> 6) & 63) | 128);
            writableSegment$okio3.data[writableSegment$okio3.limit + 3] = (byte) ((i & 63) | 128);
            writableSegment$okio3.limit += 4;
            buffer.setSize$okio(buffer.size() + 4);
        } else {
            throw new IllegalArgumentException("Unexpected code point: 0x" + Util.toHexString(i));
        }
        return buffer;
    }

    public static final long commonWriteAll(Buffer buffer, Source source) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonWriteAll");
        Intrinsics.checkParameterIsNotNull(source, "source");
        long j = 0;
        while (true) {
            long read = source.read(buffer, (long) 8192);
            if (read == -1) {
                return j;
            }
            j += read;
        }
    }

    public static final Buffer commonWrite(Buffer buffer, Source source, long j) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonWrite");
        Intrinsics.checkParameterIsNotNull(source, "source");
        while (j > 0) {
            long read = source.read(buffer, j);
            if (read != -1) {
                j -= read;
            } else {
                throw new EOFException();
            }
        }
        return buffer;
    }

    public static final Buffer commonWriteByte(Buffer buffer, int i) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonWriteByte");
        Segment writableSegment$okio = buffer.writableSegment$okio(1);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        writableSegment$okio.limit = i2 + 1;
        bArr[i2] = (byte) i;
        buffer.setSize$okio(buffer.size() + 1);
        return buffer;
    }

    public static final Buffer commonWriteShort(Buffer buffer, int i) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonWriteShort");
        Segment writableSegment$okio = buffer.writableSegment$okio(2);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        writableSegment$okio.limit = i3 + 1;
        buffer.setSize$okio(buffer.size() + 2);
        return buffer;
    }

    public static final Buffer commonWriteInt(Buffer buffer, int i) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonWriteInt");
        Segment writableSegment$okio = buffer.writableSegment$okio(4);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        writableSegment$okio.limit = i5 + 1;
        buffer.setSize$okio(buffer.size() + 4);
        return buffer;
    }

    public static final Buffer commonWriteLong(Buffer buffer, long j) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonWriteLong");
        Segment writableSegment$okio = buffer.writableSegment$okio(8);
        byte[] bArr = writableSegment$okio.data;
        int i = writableSegment$okio.limit;
        int i2 = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 56) & 255));
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((int) ((j >>> 48) & 255));
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((int) ((j >>> 40) & 255));
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((int) ((j >>> 32) & 255));
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((int) ((j >>> 24) & 255));
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((int) ((j >>> 16) & 255));
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((int) ((j >>> 8) & 255));
        bArr[i8] = (byte) ((int) (j & 255));
        writableSegment$okio.limit = i8 + 1;
        buffer.setSize$okio(buffer.size() + 8);
        return buffer;
    }

    public static final void commonWrite(Buffer buffer, Buffer buffer2, long j) {
        Segment segment;
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonWrite");
        Intrinsics.checkParameterIsNotNull(buffer2, "source");
        if (buffer2 != buffer) {
            Util.checkOffsetAndCount(buffer2.size(), 0, j);
            while (j > 0) {
                Segment segment2 = buffer2.head;
                if (segment2 == null) {
                    Intrinsics.throwNpe();
                }
                int i = segment2.limit;
                Segment segment3 = buffer2.head;
                if (segment3 == null) {
                    Intrinsics.throwNpe();
                }
                if (j < ((long) (i - segment3.pos))) {
                    if (buffer.head != null) {
                        Segment segment4 = buffer.head;
                        if (segment4 == null) {
                            Intrinsics.throwNpe();
                        }
                        segment = segment4.prev;
                    } else {
                        segment = null;
                    }
                    if (segment != null && segment.owner) {
                        if ((((long) segment.limit) + j) - ((long) (segment.shared ? 0 : segment.pos)) <= ((long) 8192)) {
                            Segment segment5 = buffer2.head;
                            if (segment5 == null) {
                                Intrinsics.throwNpe();
                            }
                            segment5.writeTo(segment, (int) j);
                            buffer2.setSize$okio(buffer2.size() - j);
                            buffer.setSize$okio(buffer.size() + j);
                            return;
                        }
                    }
                    Segment segment6 = buffer2.head;
                    if (segment6 == null) {
                        Intrinsics.throwNpe();
                    }
                    buffer2.head = segment6.split((int) j);
                }
                Segment segment7 = buffer2.head;
                if (segment7 == null) {
                    Intrinsics.throwNpe();
                }
                long j2 = (long) (segment7.limit - segment7.pos);
                buffer2.head = segment7.pop();
                if (buffer.head == null) {
                    buffer.head = segment7;
                    segment7.prev = segment7;
                    segment7.next = segment7.prev;
                } else {
                    Segment segment8 = buffer.head;
                    if (segment8 == null) {
                        Intrinsics.throwNpe();
                    }
                    Segment segment9 = segment8.prev;
                    if (segment9 == null) {
                        Intrinsics.throwNpe();
                    }
                    segment9.push(segment7).compact();
                }
                buffer2.setSize$okio(buffer2.size() - j2);
                buffer.setSize$okio(buffer.size() + j2);
                j -= j2;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }

    public static final long commonRead(Buffer buffer, Buffer buffer2, long j) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonRead");
        Intrinsics.checkParameterIsNotNull(buffer2, "sink");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        } else if (buffer.size() == 0) {
            return -1;
        } else {
            if (j > buffer.size()) {
                j = buffer.size();
            }
            buffer2.write(buffer, j);
            return j;
        }
    }

    public static final long commonIndexOf(Buffer buffer, byte b, long j, long j2) {
        int i;
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonIndexOf");
        long j3 = 0;
        if (0 <= j && j2 >= j) {
            if (j2 > buffer.size()) {
                j2 = buffer.size();
            }
            if (j == j2) {
                return -1;
            }
            Segment segment = buffer.head;
            if (segment == null) {
                return -1;
            }
            if (buffer.size() - j < j) {
                j3 = buffer.size();
                while (j3 > j) {
                    segment = segment.prev;
                    if (segment == null) {
                        Intrinsics.throwNpe();
                    }
                    j3 -= (long) (segment.limit - segment.pos);
                }
                if (segment != null) {
                    while (j3 < j2) {
                        byte[] bArr = segment.data;
                        int min = (int) Math.min((long) segment.limit, (((long) segment.pos) + j2) - j3);
                        i = (int) ((((long) segment.pos) + j) - j3);
                        while (i < min) {
                            if (bArr[i] != b) {
                                i++;
                            }
                        }
                        j3 += (long) (segment.limit - segment.pos);
                        segment = segment.next;
                        if (segment == null) {
                            Intrinsics.throwNpe();
                        }
                        j = j3;
                    }
                }
                return -1;
            }
            while (true) {
                long j4 = ((long) (segment.limit - segment.pos)) + j3;
                if (j4 > j) {
                    break;
                }
                segment = segment.next;
                if (segment == null) {
                    Intrinsics.throwNpe();
                }
                j3 = j4;
            }
            if (segment != null) {
                while (j3 < j2) {
                    byte[] bArr2 = segment.data;
                    int min2 = (int) Math.min((long) segment.limit, (((long) segment.pos) + j2) - j3);
                    i = (int) ((((long) segment.pos) + j) - j3);
                    while (i < min2) {
                        if (bArr2[i] != b) {
                            i++;
                        }
                    }
                    j3 += (long) (segment.limit - segment.pos);
                    segment = segment.next;
                    if (segment == null) {
                        Intrinsics.throwNpe();
                    }
                    j = j3;
                }
            }
            return -1;
            return ((long) (i - segment.pos)) + j3;
        }
        throw new IllegalArgumentException(("size=" + buffer.size() + " fromIndex=" + j + " toIndex=" + j2).toString());
    }

    public static final long commonIndexOf(Buffer buffer, ByteString byteString, long j) {
        long j2;
        int i;
        long j3 = j;
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonIndexOf");
        Intrinsics.checkParameterIsNotNull(byteString, "bytes");
        if (byteString.size() > 0) {
            long j4 = 0;
            if (j3 >= 0) {
                Segment segment = buffer.head;
                if (segment == null) {
                    return -1;
                }
                if (buffer.size() - j3 < j3) {
                    j2 = buffer.size();
                    while (j2 > j3) {
                        segment = segment.prev;
                        if (segment == null) {
                            Intrinsics.throwNpe();
                        }
                        j2 -= (long) (segment.limit - segment.pos);
                    }
                    if (segment == null) {
                        return -1;
                    }
                    byte[] internalArray$okio = byteString.internalArray$okio();
                    byte b = internalArray$okio[0];
                    int size = byteString.size();
                    long size2 = (buffer.size() - ((long) size)) + 1;
                    while (j2 < size2) {
                        byte[] bArr = segment.data;
                        int min = (int) Math.min((long) segment.limit, (((long) segment.pos) + size2) - j2);
                        i = (int) ((((long) segment.pos) + j3) - j2);
                        while (i < min) {
                            if (bArr[i] != b || !rangeEquals(segment, i + 1, internalArray$okio, 1, size)) {
                                i++;
                            }
                        }
                        j2 += (long) (segment.limit - segment.pos);
                        segment = segment.next;
                        if (segment == null) {
                            Intrinsics.throwNpe();
                        }
                        j3 = j2;
                    }
                    return -1;
                }
                while (true) {
                    long j5 = ((long) (segment.limit - segment.pos)) + j4;
                    if (j5 > j3) {
                        break;
                    }
                    segment = segment.next;
                    if (segment == null) {
                        Intrinsics.throwNpe();
                    }
                    j4 = j5;
                }
                if (segment == null) {
                    return -1;
                }
                byte[] internalArray$okio2 = byteString.internalArray$okio();
                byte b2 = internalArray$okio2[0];
                int size3 = byteString.size();
                long size4 = (buffer.size() - ((long) size3)) + 1;
                j2 = j4;
                while (j2 < size4) {
                    byte[] bArr2 = segment.data;
                    int min2 = (int) Math.min((long) segment.limit, (((long) segment.pos) + size4) - j2);
                    i = (int) ((((long) segment.pos) + j3) - j2);
                    while (i < min2) {
                        if (bArr2[i] == b2) {
                            if (rangeEquals(segment, i + 1, internalArray$okio2, 1, size3)) {
                            }
                        }
                        i++;
                    }
                    j2 += (long) (segment.limit - segment.pos);
                    segment = segment.next;
                    if (segment == null) {
                        Intrinsics.throwNpe();
                    }
                    size4 = size4;
                    j3 = j2;
                }
                return -1;
                return ((long) (i - segment.pos)) + j2;
            }
            throw new IllegalArgumentException(("fromIndex < 0: " + j3).toString());
        }
        throw new IllegalArgumentException("bytes is empty".toString());
    }

    public static final boolean commonRangeEquals(Buffer buffer, long j, ByteString byteString, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonRangeEquals");
        Intrinsics.checkParameterIsNotNull(byteString, "bytes");
        if (j < 0 || i < 0 || i2 < 0 || buffer.size() - j < ((long) i2) || byteString.size() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (buffer.getByte(((long) i3) + j) != byteString.getByte(i + i3)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean commonEquals(Buffer buffer, Object obj) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonEquals");
        if (buffer == obj) {
            return true;
        }
        if (!(obj instanceof Buffer)) {
            return false;
        }
        Buffer buffer2 = (Buffer) obj;
        if (buffer.size() != buffer2.size()) {
            return false;
        }
        if (buffer.size() == 0) {
            return true;
        }
        Segment segment = buffer.head;
        if (segment == null) {
            Intrinsics.throwNpe();
        }
        Segment segment2 = buffer2.head;
        if (segment2 == null) {
            Intrinsics.throwNpe();
        }
        int i = segment.pos;
        int i2 = segment2.pos;
        long j = 0;
        while (j < buffer.size()) {
            long min = (long) Math.min(segment.limit - i, segment2.limit - i2);
            long j2 = 0;
            while (j2 < min) {
                int i3 = i + 1;
                int i4 = i2 + 1;
                if (segment.data[i] != segment2.data[i2]) {
                    return false;
                }
                j2++;
                i = i3;
                i2 = i4;
            }
            if (i == segment.limit) {
                segment = segment.next;
                if (segment == null) {
                    Intrinsics.throwNpe();
                }
                i = segment.pos;
            }
            if (i2 == segment2.limit) {
                segment2 = segment2.next;
                if (segment2 == null) {
                    Intrinsics.throwNpe();
                }
                i2 = segment2.pos;
            }
            j += min;
        }
        return true;
    }

    public static final int commonHashCode(Buffer buffer) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonHashCode");
        Segment segment = buffer.head;
        if (segment == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = segment.limit;
            for (int i3 = segment.pos; i3 < i2; i3++) {
                i = (i * 31) + segment.data[i3];
            }
            segment = segment.next;
            if (segment == null) {
                Intrinsics.throwNpe();
            }
        } while (segment != buffer.head);
        return i;
    }

    public static final Buffer commonCopy(Buffer buffer) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonCopy");
        Buffer buffer2 = new Buffer();
        if (buffer.size() == 0) {
            return buffer2;
        }
        Segment segment = buffer.head;
        if (segment == null) {
            Intrinsics.throwNpe();
        }
        Segment sharedCopy = segment.sharedCopy();
        buffer2.head = sharedCopy;
        sharedCopy.prev = buffer2.head;
        sharedCopy.next = sharedCopy.prev;
        for (Segment segment2 = segment.next; segment2 != segment; segment2 = segment2.next) {
            Segment segment3 = sharedCopy.prev;
            if (segment3 == null) {
                Intrinsics.throwNpe();
            }
            if (segment2 == null) {
                Intrinsics.throwNpe();
            }
            segment3.push(segment2.sharedCopy());
        }
        buffer2.setSize$okio(buffer.size());
        return buffer2;
    }

    public static final ByteString commonSnapshot(Buffer buffer) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonSnapshot");
        if (buffer.size() <= ((long) Integer.MAX_VALUE)) {
            return buffer.snapshot((int) buffer.size());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + buffer.size()).toString());
    }

    public static final ByteString commonSnapshot(Buffer buffer, int i) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonSnapshot");
        if (i == 0) {
            return ByteString.EMPTY;
        }
        Util.checkOffsetAndCount(buffer.size(), 0, (long) i);
        Segment segment = buffer.head;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (segment == null) {
                Intrinsics.throwNpe();
            }
            if (segment.limit != segment.pos) {
                i3 += segment.limit - segment.pos;
                i4++;
                segment = segment.next;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        byte[][] bArr = new byte[i4][];
        int[] iArr = new int[(i4 * 2)];
        Segment segment2 = buffer.head;
        int i5 = 0;
        while (i2 < i) {
            if (segment2 == null) {
                Intrinsics.throwNpe();
            }
            bArr[i5] = segment2.data;
            i2 += segment2.limit - segment2.pos;
            iArr[i5] = Math.min(i2, i);
            iArr[bArr.length + i5] = segment2.pos;
            segment2.shared = true;
            i5++;
            segment2 = segment2.next;
        }
        return new SegmentedByteString(bArr, iArr);
    }

    public static final long commonIndexOfElement(Buffer buffer, ByteString byteString, long j) {
        int i;
        int i2;
        Intrinsics.checkParameterIsNotNull(buffer, "$this$commonIndexOfElement");
        Intrinsics.checkParameterIsNotNull(byteString, "targetBytes");
        long j2 = 0;
        if (j >= 0) {
            Segment segment = buffer.head;
            if (segment == null) {
                return -1;
            }
            if (buffer.size() - j < j) {
                j2 = buffer.size();
                while (j2 > j) {
                    segment = segment.prev;
                    if (segment == null) {
                        Intrinsics.throwNpe();
                    }
                    j2 -= (long) (segment.limit - segment.pos);
                }
                if (segment != null) {
                    if (byteString.size() == 2) {
                        byte b = byteString.getByte(0);
                        byte b2 = byteString.getByte(1);
                        while (j2 < buffer.size()) {
                            byte[] bArr = segment.data;
                            i = (int) ((((long) segment.pos) + j) - j2);
                            int i3 = segment.limit;
                            while (i < i3) {
                                byte b3 = bArr[i];
                                if (!(b3 == b || b3 == b2)) {
                                    i++;
                                }
                            }
                            j2 += (long) (segment.limit - segment.pos);
                            segment = segment.next;
                            if (segment == null) {
                                Intrinsics.throwNpe();
                            }
                            j = j2;
                        }
                    } else {
                        byte[] internalArray$okio = byteString.internalArray$okio();
                        while (j2 < buffer.size()) {
                            byte[] bArr2 = segment.data;
                            i = (int) ((((long) segment.pos) + j) - j2);
                            int i4 = segment.limit;
                            while (i < i4) {
                                byte b4 = bArr2[i];
                                for (byte b5 : internalArray$okio) {
                                    if (b4 == b5) {
                                        i2 = segment.pos;
                                        return ((long) (i - i2)) + j2;
                                    }
                                }
                                i++;
                            }
                            j2 += (long) (segment.limit - segment.pos);
                            segment = segment.next;
                            if (segment == null) {
                                Intrinsics.throwNpe();
                            }
                            j = j2;
                        }
                    }
                }
                return -1;
            }
            while (true) {
                long j3 = ((long) (segment.limit - segment.pos)) + j2;
                if (j3 > j) {
                    break;
                }
                segment = segment.next;
                if (segment == null) {
                    Intrinsics.throwNpe();
                }
                j2 = j3;
            }
            if (segment != null) {
                if (byteString.size() == 2) {
                    byte b6 = byteString.getByte(0);
                    byte b7 = byteString.getByte(1);
                    while (j2 < buffer.size()) {
                        byte[] bArr3 = segment.data;
                        i = (int) ((((long) segment.pos) + j) - j2);
                        int i5 = segment.limit;
                        while (i < i5) {
                            byte b8 = bArr3[i];
                            if (!(b8 == b6 || b8 == b7)) {
                                i++;
                            }
                        }
                        j2 += (long) (segment.limit - segment.pos);
                        segment = segment.next;
                        if (segment == null) {
                            Intrinsics.throwNpe();
                        }
                        j = j2;
                    }
                } else {
                    byte[] internalArray$okio2 = byteString.internalArray$okio();
                    while (j2 < buffer.size()) {
                        byte[] bArr4 = segment.data;
                        i = (int) ((((long) segment.pos) + j) - j2);
                        int i6 = segment.limit;
                        while (i < i6) {
                            byte b9 = bArr4[i];
                            for (byte b10 : internalArray$okio2) {
                                if (b9 == b10) {
                                    i2 = segment.pos;
                                    return ((long) (i - i2)) + j2;
                                }
                            }
                            i++;
                        }
                        j2 += (long) (segment.limit - segment.pos);
                        segment = segment.next;
                        if (segment == null) {
                            Intrinsics.throwNpe();
                        }
                        j = j2;
                    }
                }
            }
            return -1;
            i2 = segment.pos;
            return ((long) (i - i2)) + j2;
        }
        throw new IllegalArgumentException(("fromIndex < 0: " + j).toString());
    }
}
