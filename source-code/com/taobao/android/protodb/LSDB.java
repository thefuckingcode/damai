package com.taobao.android.protodb;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import tb.f0;
import tb.u51;
import tb.y51;

@Keep
/* compiled from: Taobao */
public class LSDB extends NativeBridgedObject {
    private static final int SIZE_OF_BOOL = 1;
    private static final int SIZE_OF_DOUBLE = 8;
    private static final int SIZE_OF_FLOAT = 4;
    private static final int SIZE_OF_INT = 4;
    private static final int SIZE_OF_LONG = 8;
    private static final ConcurrentLinkedQueue<LSDB> sLSDBInstances = new ConcurrentLinkedQueue<>();
    private final String path;
    private final String tag = "ProtoDB";

    LSDB(long j, String str) {
        super(j);
        this.path = str;
    }

    public static void compactAll() {
        Iterator<LSDB> it = sLSDBInstances.iterator();
        while (it.hasNext()) {
            it.next().forceCompact();
        }
    }

    @Keep
    private native boolean nativeClose();

    @Keep
    private native boolean nativeCompact();

    @Keep
    private native boolean nativeContains(String str);

    @Keep
    private native boolean nativeDelete(String str);

    @Keep
    private native byte[] nativeGetBinary(String str);

    @Keep
    private native boolean nativeGetBinaryToBuffer(String str, byte[] bArr, int i);

    @Keep
    private native int nativeGetDataSize(String str);

    @Keep
    private native boolean nativeInsert(String str, int i, byte[] bArr, int i2);

    @Keep
    private native String[] nativeKeyIterator(String str, String str2);

    @Keep
    private static native long nativeOpen(String str, Config config);

    public static LSDB open(String str, Config config) {
        Application a = f0.a();
        if (a == null) {
            throw new RuntimeException("failed to get android context!");
        } else if (!NativeBridgedObject.sNativeLibraryLoaded) {
            return new a(a);
        } else {
            LSDB openInternal = openInternal(a.getFilesDir() + File.separator + "lsdb-" + str, config);
            return openInternal != null ? openInternal : new a(a);
        }
    }

    private static LSDB openInternal(String str, Config config) {
        long nativeOpen = nativeOpen(str, config);
        if (nativeOpen <= 0) {
            return null;
        }
        LSDB lsdb = new LSDB(nativeOpen, str);
        sLSDBInstances.add(lsdb);
        return lsdb;
    }

    public boolean close() {
        sLSDBInstances.remove(this);
        return nativeClose();
    }

    public boolean contains(@NonNull u51 u51) {
        return nativeContains(u51.a());
    }

    public boolean delete(@NonNull u51 u51) {
        return nativeDelete(u51.a());
    }

    public boolean forceCompact() {
        Log.e("ProtoDB", "begin compacting: " + this.path);
        boolean nativeCompact = nativeCompact();
        Log.e("ProtoDB", "finish compacting: " + this.path);
        return nativeCompact;
    }

    public byte[] getBinary(@NonNull u51 u51) {
        return nativeGetBinary(u51.a());
    }

    public boolean getBinaryToBuffer(@NonNull u51 u51, byte[] bArr) {
        return nativeGetBinaryToBuffer(u51.a(), bArr, bArr.length);
    }

    public boolean getBool(@NonNull u51 u51) {
        byte[] bArr = new byte[1];
        if (!nativeGetBinaryToBuffer(u51.a(), bArr, 1) || ByteBuffer.wrap(bArr).get() == 0) {
            return false;
        }
        return true;
    }

    public int getDataSize(@NonNull u51 u51) {
        return nativeGetDataSize(u51.a());
    }

    public double getDouble(@NonNull u51 u51) {
        byte[] bArr = new byte[8];
        if (nativeGetBinaryToBuffer(u51.a(), bArr, 8)) {
            return ByteBuffer.wrap(bArr).getDouble();
        }
        return 0.0d;
    }

    public float getFloat(@NonNull u51 u51) {
        byte[] bArr = new byte[4];
        if (nativeGetBinaryToBuffer(u51.a(), bArr, 4)) {
            return ByteBuffer.wrap(bArr).getFloat();
        }
        return 0.0f;
    }

    public int getInt(@NonNull u51 u51) {
        byte[] bArr = new byte[4];
        if (nativeGetBinaryToBuffer(u51.a(), bArr, 4)) {
            return ByteBuffer.wrap(bArr).getInt();
        }
        return 0;
    }

    public long getLong(@NonNull u51 u51) {
        byte[] bArr = new byte[8];
        if (nativeGetBinaryToBuffer(u51.a(), bArr, 8)) {
            return ByteBuffer.wrap(bArr).getLong();
        }
        return 0;
    }

    public String getString(@NonNull u51 u51) {
        byte[] nativeGetBinary = nativeGetBinary(u51.a());
        if (nativeGetBinary == null || nativeGetBinary.length <= 0) {
            return null;
        }
        return new String(nativeGetBinary, Charset.forName("UTF-8"));
    }

    public boolean insertBinary(@NonNull u51 u51, byte[] bArr) {
        return nativeInsert(u51.a(), Integer.MAX_VALUE, bArr, bArr != null ? bArr.length : 0);
    }

    public boolean insertBool(@NonNull u51 u51, boolean z) {
        return nativeInsert(u51.a(), Integer.MAX_VALUE, new byte[]{z ? (byte) 1 : 0}, 1);
    }

    public boolean insertDouble(@NonNull u51 u51, double d) {
        return nativeInsert(u51.a(), Integer.MAX_VALUE, ByteBuffer.allocate(8).putDouble(d).array(), 8);
    }

    public boolean insertFloat(@NonNull u51 u51, float f) {
        return nativeInsert(u51.a(), Integer.MAX_VALUE, ByteBuffer.allocate(4).putFloat(f).array(), 4);
    }

    public boolean insertInt(@NonNull u51 u51, int i) {
        return nativeInsert(u51.a(), Integer.MAX_VALUE, ByteBuffer.allocate(4).putInt(i).array(), 4);
    }

    public boolean insertLong(@NonNull u51 u51, long j) {
        return nativeInsert(u51.a(), Integer.MAX_VALUE, ByteBuffer.allocate(8).putLong(j).array(), 8);
    }

    public boolean insertStream(@NonNull u51 u51, int i, InputStream inputStream) {
        if (inputStream != null) {
            try {
                int available = inputStream.available();
                byte[] bArr = new byte[available];
                if (inputStream.read(bArr, 0, inputStream.available()) == available) {
                    return insertBinary(u51, i, bArr);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean insertString(@NonNull u51 u51, @NonNull String str) {
        if (str == null) {
            return nativeInsert(u51.a(), Integer.MAX_VALUE, null, 0);
        }
        byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
        return nativeInsert(u51.a(), Integer.MAX_VALUE, bytes, bytes.length);
    }

    public Iterator<u51> keyIterator() {
        return new y51(nativeKeyIterator(null, null));
    }

    public boolean insertBinary(@NonNull u51 u51, int i, byte[] bArr) {
        return nativeInsert(u51.a(), i, bArr, bArr != null ? bArr.length : 0);
    }

    public Iterator<u51> keyIterator(@NonNull u51 u51, @NonNull u51 u512) {
        return new y51(nativeKeyIterator(u51.a(), u512.a()));
    }

    public static LSDB open(Context context, String str, Config config) {
        if (!NativeBridgedObject.sNativeLibraryLoaded) {
            return new a(context);
        }
        LSDB openInternal = openInternal(context.getFilesDir() + File.separator + "lsdb-" + str, config);
        return openInternal != null ? openInternal : new a(context);
    }
}
