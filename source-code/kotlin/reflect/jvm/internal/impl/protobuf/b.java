package kotlin.reflect.jvm.internal.impl.protobuf;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.util.NoSuchElementException;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import tb.jl1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class b extends e {
    private final int c;
    private final int d;

    /* access modifiers changed from: private */
    /* renamed from: kotlin.reflect.jvm.internal.impl.protobuf.b$b  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public class C0280b implements ByteString.ByteIterator {
        private int a;
        private final int b;

        /* renamed from: a */
        public Byte next() {
            return Byte.valueOf(nextByte());
        }

        public boolean hasNext() {
            return this.a < this.b;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString.ByteIterator
        public byte nextByte() {
            int i = this.a;
            if (i < this.b) {
                byte[] bArr = b.this.a;
                this.a = i + 1;
                return bArr[i];
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        private C0280b() {
            int y = b.this.y();
            this.a = y;
            this.b = y + b.this.size();
        }
    }

    b(byte[] bArr, int i, int i2) {
        super(bArr);
        if (i < 0) {
            StringBuilder sb = new StringBuilder(29);
            sb.append("Offset too small: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 < 0) {
            StringBuilder sb2 = new StringBuilder(29);
            sb2.append("Length too small: ");
            sb2.append(i);
            throw new IllegalArgumentException(sb2.toString());
        } else if (((long) i) + ((long) i2) <= ((long) bArr.length)) {
            this.c = i;
            this.d = i2;
        } else {
            StringBuilder sb3 = new StringBuilder(48);
            sb3.append("Offset+Length too large: ");
            sb3.append(i);
            sb3.append(jl1.PLUS);
            sb3.append(i2);
            throw new IllegalArgumentException(sb3.toString());
        }
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public void h(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.a, y() + i, bArr, i2, i3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    /* renamed from: l */
    public ByteString.ByteIterator iterator() {
        return new C0280b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int size() {
        return this.d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.e
    public byte w(int i) {
        if (i < 0) {
            StringBuilder sb = new StringBuilder(28);
            sb.append("Index too small: ");
            sb.append(i);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        } else if (i < size()) {
            return this.a[this.c + i];
        } else {
            int size = size();
            StringBuilder sb2 = new StringBuilder(41);
            sb2.append("Index too large: ");
            sb2.append(i);
            sb2.append(AVFSCacheConstants.COMMA_SEP);
            sb2.append(size);
            throw new ArrayIndexOutOfBoundsException(sb2.toString());
        }
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.protobuf.e
    public int y() {
        return this.c;
    }
}
