package anetwork.channel.aidl.adapter;

import android.os.RemoteException;
import anetwork.channel.aidl.ParcelableInputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import tb.b02;
import tb.pd;

/* compiled from: Taobao */
public class ParcelableInputStreamImpl extends ParcelableInputStream.Stub {
    private static final pd EOS = pd.b(0);
    private static final String TAG = "anet.ParcelableInputStreamImpl";
    private int blockIndex;
    private int blockOffset;
    private LinkedList<pd> byteList = new LinkedList<>();
    private int contentLength;
    private final AtomicBoolean isClosed = new AtomicBoolean(false);
    final ReentrantLock lock;
    final Condition newDataArrive;
    private int rto = 10000;
    private String seqNo = "";

    public ParcelableInputStreamImpl() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.newDataArrive = reentrantLock.newCondition();
    }

    private void recycleCurrentItem() {
        this.lock.lock();
        try {
            this.byteList.set(this.blockIndex, EOS).f();
        } finally {
            this.lock.unlock();
        }
    }

    @Override // anetwork.channel.aidl.ParcelableInputStream
    public int available() throws RemoteException {
        if (!this.isClosed.get()) {
            this.lock.lock();
            try {
                int i = 0;
                if (this.blockIndex == this.byteList.size()) {
                    return 0;
                }
                ListIterator<pd> listIterator = this.byteList.listIterator(this.blockIndex);
                while (listIterator.hasNext()) {
                    i += listIterator.next().d();
                }
                int i2 = i - this.blockOffset;
                this.lock.unlock();
                return i2;
            } finally {
                this.lock.unlock();
            }
        } else {
            throw new RuntimeException("Stream is closed");
        }
    }

    @Override // anetwork.channel.aidl.ParcelableInputStream
    public void close() throws RemoteException {
        if (this.isClosed.compareAndSet(false, true)) {
            this.lock.lock();
            try {
                Iterator<pd> it = this.byteList.iterator();
                while (it.hasNext()) {
                    pd next = it.next();
                    if (next != EOS) {
                        next.f();
                    }
                }
                this.byteList.clear();
                this.byteList = null;
                this.blockIndex = -1;
                this.blockOffset = -1;
                this.contentLength = 0;
            } finally {
                this.lock.unlock();
            }
        }
    }

    public void init(b02 b02, int i) {
        this.contentLength = i;
        this.seqNo = b02.i;
        this.rto = b02.h;
    }

    @Override // anetwork.channel.aidl.ParcelableInputStream
    public int length() throws RemoteException {
        return this.contentLength;
    }

    @Override // anetwork.channel.aidl.ParcelableInputStream
    public int read(byte[] bArr) throws RemoteException {
        return readBytes(bArr, 0, bArr.length);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:21|22|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0067, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0073, code lost:
        throw new java.lang.RuntimeException("await interrupt");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0074, code lost:
        r4.lock.unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0079, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0069 */
    @Override // anetwork.channel.aidl.ParcelableInputStream
    public int readByte() throws RemoteException {
        byte b;
        if (!this.isClosed.get()) {
            this.lock.lock();
            while (true) {
                if (this.blockIndex == this.byteList.size()) {
                    if (!this.newDataArrive.await((long) this.rto, TimeUnit.MILLISECONDS)) {
                        close();
                        throw new RuntimeException("await timeout.");
                    }
                }
                pd pdVar = this.byteList.get(this.blockIndex);
                if (pdVar == EOS) {
                    b = -1;
                    break;
                } else if (this.blockOffset < pdVar.d()) {
                    byte[] c = pdVar.c();
                    int i = this.blockOffset;
                    b = c[i];
                    this.blockOffset = i + 1;
                    break;
                } else {
                    recycleCurrentItem();
                    this.blockIndex++;
                    this.blockOffset = 0;
                }
            }
            this.lock.unlock();
            return b;
        }
        throw new RuntimeException("Stream is closed");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007f, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008b, code lost:
        throw new java.lang.RuntimeException("await interrupt");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008c, code lost:
        r5.lock.unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0091, code lost:
        throw r6;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0081 */
    @Override // anetwork.channel.aidl.ParcelableInputStream
    public int readBytes(byte[] bArr, int i, int i2) throws RemoteException {
        int i3;
        if (!this.isClosed.get()) {
            Objects.requireNonNull(bArr);
            if (i < 0 || i2 < 0 || (i3 = i2 + i) > bArr.length) {
                throw new ArrayIndexOutOfBoundsException();
            }
            this.lock.lock();
            int i4 = i;
            while (true) {
                if (i4 >= i3) {
                    break;
                }
                if (this.blockIndex == this.byteList.size()) {
                    if (!this.newDataArrive.await((long) this.rto, TimeUnit.MILLISECONDS)) {
                        close();
                        throw new RuntimeException("await timeout.");
                    }
                }
                pd pdVar = this.byteList.get(this.blockIndex);
                if (pdVar == EOS) {
                    break;
                }
                int d = pdVar.d() - this.blockOffset;
                int i5 = i3 - i4;
                if (d < i5) {
                    System.arraycopy(pdVar.c(), this.blockOffset, bArr, i4, d);
                    i4 += d;
                    recycleCurrentItem();
                    this.blockIndex++;
                    this.blockOffset = 0;
                } else {
                    System.arraycopy(pdVar.c(), this.blockOffset, bArr, i4, i5);
                    this.blockOffset += i5;
                    i4 += i5;
                }
            }
            this.lock.unlock();
            int i6 = i4 - i;
            if (i6 > 0) {
                return i6;
            }
            return -1;
        }
        throw new RuntimeException("Stream is closed");
    }

    @Override // anetwork.channel.aidl.ParcelableInputStream
    public long skip(int i) throws RemoteException {
        this.lock.lock();
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                break;
            }
            try {
                if (this.blockIndex == this.byteList.size()) {
                    break;
                }
                pd pdVar = this.byteList.get(this.blockIndex);
                if (pdVar == EOS) {
                    break;
                }
                int d = pdVar.d();
                int i3 = this.blockOffset;
                int i4 = i - i2;
                if (d - i3 < i4) {
                    i2 += d - i3;
                    recycleCurrentItem();
                    this.blockIndex++;
                    this.blockOffset = 0;
                } else {
                    this.blockOffset = i3 + i4;
                    i2 = i;
                }
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }
        this.lock.unlock();
        return (long) i2;
    }

    public void write(pd pdVar) {
        if (!this.isClosed.get()) {
            this.lock.lock();
            try {
                this.byteList.add(pdVar);
                this.newDataArrive.signal();
            } finally {
                this.lock.unlock();
            }
        }
    }

    public void writeEnd() {
        write(EOS);
    }
}
