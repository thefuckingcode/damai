package com.taobao.android.protodb;

import androidx.annotation.Keep;

@Keep
/* compiled from: Taobao */
public class NativeBridgedObject {
    protected static boolean sNativeLibraryLoaded;
    @Keep
    private final long mNativePointer;

    static {
        try {
            System.loadLibrary("ProtoDB");
            sNativeLibraryLoaded = true;
        } catch (Throwable unused) {
            sNativeLibraryLoaded = false;
        }
    }

    protected NativeBridgedObject(long j) {
        this.mNativePointer = j;
    }

    @Keep
    private native void freeNativeObject();

    /* access modifiers changed from: protected */
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        super.finalize();
        if (sNativeLibraryLoaded) {
            freeNativeObject();
        }
    }

    public long getNativePointer() {
        return this.mNativePointer;
    }
}
