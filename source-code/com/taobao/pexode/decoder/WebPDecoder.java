package com.taobao.pexode.decoder;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.taobao.pexode.Pexode;
import com.taobao.pexode.PexodeOptions;
import com.taobao.pexode.common.DegradeEventListener;
import com.taobao.pexode.entity.IncrementalStaging;
import com.taobao.pexode.entity.RewindableStream;
import com.taobao.pexode.exception.IncrementalDecodeException;
import com.taobao.pexode.exception.PexodeException;
import com.taobao.pexode.mimetype.MimeType;
import java.io.FileDescriptor;
import java.io.IOException;
import tb.kg0;
import tb.np1;

/* compiled from: Taobao */
public class WebPDecoder extends b {
    private static final int LIBRARY_JNI_VERSION = 2;
    private static final int NATIVE_RET_DECODE_OK = 0;
    private static final int NATIVE_RET_NULL_STRAIGHT = 2;
    private static final int NATIVE_RET_TRY_DEGRADING = 1;
    private static final int VP8_STATUS_OK = 0;
    private static final int VP8_STATUS_REQUEST_CANCELLED = -6;
    private static final int VP8_STATUS_SUSPENDED = 5;
    private static boolean sIsSoInstalled;
    private final IncrementalStaging.NativeDestructor CONFIG_OUT_DESTRUCTOR = new a(this);

    /* compiled from: Taobao */
    class a implements IncrementalStaging.NativeDestructor {
        a(WebPDecoder webPDecoder) {
        }

        @Override // com.taobao.pexode.entity.IncrementalStaging.NativeDestructor
        public void destruct(long j) {
            WebPDecoder.nativeDestructConfigOut(j);
        }
    }

    static {
        String libraryName = getLibraryName();
        try {
            System.loadLibrary(libraryName);
            boolean z = nativeLoadedVersionTest() == 2;
            sIsSoInstalled = z;
            kg0.f(Pexode.TAG, "system load lib%s.so result=%b", libraryName, Boolean.valueOf(z));
        } catch (UnsatisfiedLinkError e) {
            kg0.c(Pexode.TAG, "system load lib%s.so error=%s", libraryName, e);
        }
    }

    private int decodeFirstIncrementally(RewindableStream rewindableStream, PexodeOptions pexodeOptions, Bitmap bitmap, boolean z) throws PexodeException {
        long j;
        byte[] bArr;
        int i;
        if (b.invalidBitmap(bitmap, pexodeOptions, "decodeFirstIncrementally")) {
            return 1;
        }
        if (z) {
            j = b.getPixelAddressFromBitmap(bitmap);
            bArr = null;
        } else {
            bArr = getPixelBufferFromBitmap(bitmap);
            j = 0;
        }
        if (bArr == null && j == 0) {
            return 1;
        }
        long[] jArr = new long[1];
        int inputType = rewindableStream.getInputType();
        if (inputType != 1) {
            if (inputType != 2) {
                byte[] g = com.taobao.pexode.a.f().g(2048);
                if (z) {
                    i = nativeDecodeStreamWithOutAddressIncrementally(rewindableStream, g, pexodeOptions, j, jArr);
                } else {
                    i = nativeDecodeStreamWithOutBufferIncrementally(rewindableStream, g, pexodeOptions, bArr, jArr);
                }
                com.taobao.pexode.a.f().h(g);
            } else if (z) {
                i = nativeDecodeFdWithOutAddressIncrementally(rewindableStream.getFD(), pexodeOptions, j, jArr);
            } else {
                i = nativeDecodeFdWithOutBufferIncrementally(rewindableStream.getFD(), pexodeOptions, bArr, jArr);
            }
        } else if (z) {
            i = nativeDecodeBytesWithOutAddressIncrementally(rewindableStream.getBuffer(), rewindableStream.getBufferOffset(), rewindableStream.getBufferLength(), pexodeOptions, j, jArr);
        } else {
            i = nativeDecodeBytesWithOutBufferIncrementally(rewindableStream.getBuffer(), rewindableStream.getBufferOffset(), rewindableStream.getBufferLength(), pexodeOptions, bArr, jArr);
        }
        IncrementalStaging incrementalStaging = new IncrementalStaging(bitmap, jArr[0], this.CONFIG_OUT_DESTRUCTOR);
        if (i != 5 || com.taobao.pexode.a.b(pexodeOptions)) {
            incrementalStaging.c();
        }
        if (i == -6) {
            return 2;
        }
        if (i != 0 && i != 5) {
            return 1;
        }
        com.taobao.pexode.a.l(pexodeOptions, incrementalStaging);
        if (i == 5) {
            return 2;
        }
        return 0;
    }

    private static int decodeInBitmapAddress(RewindableStream rewindableStream, PexodeOptions pexodeOptions, Bitmap bitmap) {
        boolean z;
        if (b.invalidBitmap(bitmap, pexodeOptions, "decodeInBitmapAddress")) {
            return 1;
        }
        long pixelAddressFromBitmap = b.getPixelAddressFromBitmap(bitmap);
        if (pixelAddressFromBitmap == 0) {
            return 1;
        }
        int inputType = rewindableStream.getInputType();
        if (inputType == 1) {
            z = nativeDecodeBytesWithOutAddress(rewindableStream.getBuffer(), rewindableStream.getBufferOffset(), rewindableStream.getBufferLength(), pexodeOptions, pixelAddressFromBitmap);
        } else if (inputType != 2) {
            byte[] g = com.taobao.pexode.a.f().g(2048);
            z = nativeDecodeStreamWithOutAddress(rewindableStream, g, pexodeOptions, pixelAddressFromBitmap);
            com.taobao.pexode.a.f().h(g);
        } else {
            z = nativeDecodeFdWithOutAddress(rewindableStream.getFD(), pexodeOptions, pixelAddressFromBitmap);
        }
        return !z ? 1 : 0;
    }

    private int decodeInBitmapBuffer(RewindableStream rewindableStream, PexodeOptions pexodeOptions, Bitmap bitmap) {
        byte[] pixelBufferFromBitmap;
        boolean z;
        if (b.invalidBitmap(bitmap, pexodeOptions, "decodeInBitmapBuffer") || (pixelBufferFromBitmap = getPixelBufferFromBitmap(bitmap)) == null) {
            return 1;
        }
        int inputType = rewindableStream.getInputType();
        if (inputType == 1) {
            z = nativeDecodeBytesWithOutBuffer(rewindableStream.getBuffer(), rewindableStream.getBufferOffset(), rewindableStream.getBufferLength(), pexodeOptions, pixelBufferFromBitmap);
        } else if (inputType != 2) {
            byte[] g = com.taobao.pexode.a.f().g(2048);
            z = nativeDecodeStreamWithOutBuffer(rewindableStream, g, pexodeOptions, pixelBufferFromBitmap);
            com.taobao.pexode.a.f().h(g);
        } else {
            z = nativeDecodeFdWithOutBuffer(rewindableStream.getFD(), pexodeOptions, pixelBufferFromBitmap);
        }
        return !z ? 1 : 0;
    }

    private int decodeLaterIncrementally(RewindableStream rewindableStream, PexodeOptions pexodeOptions, @NonNull IncrementalStaging incrementalStaging) throws PexodeException {
        int i;
        int inputType = rewindableStream.getInputType();
        if (inputType == 1) {
            i = nativeDecodeBytesIncrementally(rewindableStream.getBuffer(), rewindableStream.getBufferOffset(), rewindableStream.getBufferLength(), pexodeOptions, incrementalStaging.b());
        } else if (inputType != 2) {
            byte[] g = com.taobao.pexode.a.f().g(2048);
            i = nativeDecodeStreamIncrementally(rewindableStream, g, pexodeOptions, incrementalStaging.b());
            com.taobao.pexode.a.f().h(g);
        } else {
            i = nativeDecodeFdIncrementally(rewindableStream.getFD(), pexodeOptions, incrementalStaging.b());
        }
        if (i != 5 || com.taobao.pexode.a.b(pexodeOptions)) {
            incrementalStaging.c();
        }
        if (i == 5 || i == -6) {
            return 2;
        }
        if (i == 0) {
            return 0;
        }
        throw new IncrementalDecodeException("native decode bytes with buffer incrementally error, status=" + i);
    }

    private int decodeReturnInBuffer(RewindableStream rewindableStream, PexodeOptions pexodeOptions, Bitmap bitmap, IncrementalStaging incrementalStaging, boolean z, boolean z2) throws PexodeException {
        if (!z) {
            return decodeInBitmapBuffer(rewindableStream, pexodeOptions, bitmap);
        }
        if (z2) {
            return decodeFirstIncrementally(rewindableStream, pexodeOptions, bitmap, false);
        }
        return decodeLaterIncrementally(rewindableStream, pexodeOptions, incrementalStaging);
    }

    private static String getLibraryName() {
        return "pexwebp";
    }

    private static native int nativeDecodeBytesIncrementally(byte[] bArr, int i, int i2, PexodeOptions pexodeOptions, long j);

    private static native boolean nativeDecodeBytesWithOutAddress(byte[] bArr, int i, int i2, PexodeOptions pexodeOptions, long j);

    private static native int nativeDecodeBytesWithOutAddressIncrementally(byte[] bArr, int i, int i2, PexodeOptions pexodeOptions, long j, long[] jArr);

    private static native boolean nativeDecodeBytesWithOutBuffer(byte[] bArr, int i, int i2, PexodeOptions pexodeOptions, byte[] bArr2);

    private static native int nativeDecodeBytesWithOutBufferIncrementally(byte[] bArr, int i, int i2, PexodeOptions pexodeOptions, byte[] bArr2, long[] jArr);

    private static native int nativeDecodeFdIncrementally(FileDescriptor fileDescriptor, PexodeOptions pexodeOptions, long j);

    private static native boolean nativeDecodeFdWithOutAddress(FileDescriptor fileDescriptor, PexodeOptions pexodeOptions, long j);

    private static native int nativeDecodeFdWithOutAddressIncrementally(FileDescriptor fileDescriptor, PexodeOptions pexodeOptions, long j, long[] jArr);

    private static native boolean nativeDecodeFdWithOutBuffer(FileDescriptor fileDescriptor, PexodeOptions pexodeOptions, byte[] bArr);

    private static native int nativeDecodeFdWithOutBufferIncrementally(FileDescriptor fileDescriptor, PexodeOptions pexodeOptions, byte[] bArr, long[] jArr);

    private static native int nativeDecodeStreamIncrementally(RewindableStream rewindableStream, byte[] bArr, PexodeOptions pexodeOptions, long j);

    private static native boolean nativeDecodeStreamWithOutAddress(RewindableStream rewindableStream, byte[] bArr, PexodeOptions pexodeOptions, long j);

    private static native int nativeDecodeStreamWithOutAddressIncrementally(RewindableStream rewindableStream, byte[] bArr, PexodeOptions pexodeOptions, long j, long[] jArr);

    private static native boolean nativeDecodeStreamWithOutBuffer(RewindableStream rewindableStream, byte[] bArr, PexodeOptions pexodeOptions, byte[] bArr2);

    private static native int nativeDecodeStreamWithOutBufferIncrementally(RewindableStream rewindableStream, byte[] bArr, PexodeOptions pexodeOptions, byte[] bArr2, long[] jArr);

    /* access modifiers changed from: private */
    public static native void nativeDestructConfigOut(long j);

    private static native int nativeLoadedVersionTest();

    @Override // com.taobao.pexode.decoder.Decoder
    public boolean acceptInputType(int i, MimeType mimeType, boolean z) {
        return true;
    }

    @Override // com.taobao.pexode.decoder.Decoder
    public boolean canDecodeIncrementally(MimeType mimeType) {
        return isSupported(mimeType);
    }

    @Override // com.taobao.pexode.decoder.Decoder
    public np1 decode(RewindableStream rewindableStream, PexodeOptions pexodeOptions, DegradeEventListener degradeEventListener) throws PexodeException, IOException {
        Bitmap bitmap;
        if (!pexodeOptions.isSizeAvailable()) {
            int inputType = rewindableStream.getInputType();
            if (inputType == 1) {
                nativeDecodeBytesWithOutBuffer(rewindableStream.getBuffer(), rewindableStream.getBufferOffset(), rewindableStream.getBufferLength(), pexodeOptions, null);
            } else if (inputType != 2) {
                byte[] g = com.taobao.pexode.a.f().g(64);
                nativeDecodeStreamWithOutBuffer(rewindableStream, g, pexodeOptions, null);
                com.taobao.pexode.a.f().h(g);
            } else {
                nativeDecodeFdWithOutBuffer(rewindableStream.getFD(), pexodeOptions, null);
            }
        } else if (pexodeOptions.sampleSize != com.taobao.pexode.a.e(pexodeOptions)) {
            int i = pexodeOptions.outWidth;
            int i2 = i / pexodeOptions.sampleSize;
            pexodeOptions.outWidth = i2;
            pexodeOptions.outHeight = (pexodeOptions.outHeight * i2) / i;
        }
        com.taobao.pexode.a.m(pexodeOptions, pexodeOptions.sampleSize);
        if (pexodeOptions.justDecodeBounds || com.taobao.pexode.a.b(pexodeOptions)) {
            return null;
        }
        if (!pexodeOptions.isSizeAvailable()) {
            kg0.c(Pexode.TAG, "WebPDecoder size unavailable before bitmap decoding", new Object[0]);
            return null;
        }
        if (pexodeOptions.enableAshmem && !com.taobao.pexode.a.f().b) {
            bitmap = decodeAshmem(rewindableStream, pexodeOptions, degradeEventListener);
        } else if (pexodeOptions.inBitmap == null || com.taobao.pexode.a.f().a) {
            bitmap = decodeNormal(rewindableStream, pexodeOptions);
        } else {
            bitmap = decodeInBitmap(rewindableStream, pexodeOptions, degradeEventListener);
        }
        return np1.a(bitmap);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.pexode.decoder.b
    public Bitmap decodeAshmem(RewindableStream rewindableStream, PexodeOptions pexodeOptions, DegradeEventListener degradeEventListener) throws PexodeException, IOException {
        Bitmap bitmap;
        int i;
        boolean z = pexodeOptions.incrementalDecode;
        IncrementalStaging d = com.taobao.pexode.a.d(pexodeOptions);
        boolean z2 = false;
        boolean z3 = d == null;
        Bitmap bitmap2 = null;
        if (!z || z3) {
            bitmap = b.newBitmap(pexodeOptions, true);
        } else {
            bitmap = null;
        }
        if (!z) {
            i = decodeInBitmapAddress(rewindableStream, pexodeOptions, bitmap);
        } else if (z3) {
            i = decodeFirstIncrementally(rewindableStream, pexodeOptions, bitmap, true);
        } else {
            i = decodeLaterIncrementally(rewindableStream, pexodeOptions, d);
        }
        if (i == 0) {
            return z ? com.taobao.pexode.a.d(pexodeOptions).a() : bitmap;
        }
        if (2 == i) {
            return null;
        }
        if (!com.taobao.pexode.a.b(pexodeOptions) && pexodeOptions.allowDegrade2NoAshmem) {
            rewindableStream.rewind();
            bitmap2 = decodeNormal(rewindableStream, pexodeOptions);
            if (!com.taobao.pexode.a.b(pexodeOptions)) {
                if (bitmap2 != null || z) {
                    z2 = true;
                }
                degradeEventListener.onDegraded2NoAshmem(z2);
            }
        }
        return bitmap2;
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.pexode.decoder.b
    public Bitmap decodeInBitmap(RewindableStream rewindableStream, PexodeOptions pexodeOptions, DegradeEventListener degradeEventListener) throws PexodeException, IOException {
        boolean z = pexodeOptions.incrementalDecode;
        IncrementalStaging d = com.taobao.pexode.a.d(pexodeOptions);
        boolean z2 = true;
        int decodeReturnInBuffer = decodeReturnInBuffer(rewindableStream, pexodeOptions, pexodeOptions.inBitmap, d, z, d == null);
        if (decodeReturnInBuffer != 0) {
            Bitmap bitmap = null;
            if (2 == decodeReturnInBuffer) {
                return null;
            }
            if (!com.taobao.pexode.a.b(pexodeOptions) && pexodeOptions.allowDegrade2NoInBitmap) {
                rewindableStream.rewind();
                bitmap = decodeNormal(rewindableStream, pexodeOptions);
                if (!com.taobao.pexode.a.b(pexodeOptions)) {
                    if (bitmap == null && !z) {
                        z2 = false;
                    }
                    degradeEventListener.onDegraded2NoInBitmap(z2);
                }
            }
            return bitmap;
        } else if (z) {
            return com.taobao.pexode.a.d(pexodeOptions).a();
        } else {
            return pexodeOptions.inBitmap;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.pexode.decoder.b
    public Bitmap decodeNormal(RewindableStream rewindableStream, PexodeOptions pexodeOptions) throws PexodeException {
        Bitmap bitmap;
        boolean z = pexodeOptions.incrementalDecode;
        IncrementalStaging d = com.taobao.pexode.a.d(pexodeOptions);
        boolean z2 = d == null;
        if (!z || z2) {
            bitmap = b.newBitmap(pexodeOptions, false);
        } else {
            bitmap = null;
        }
        int decodeReturnInBuffer = decodeReturnInBuffer(rewindableStream, pexodeOptions, bitmap, d, z, z2);
        if (decodeReturnInBuffer == 0) {
            return z ? com.taobao.pexode.a.d(pexodeOptions).a() : bitmap;
        }
        if (1 != decodeReturnInBuffer || !z) {
            return null;
        }
        throw new IncrementalDecodeException("incremental decoding error at the first and cannot degrade now");
    }

    @Override // com.taobao.pexode.decoder.Decoder
    public MimeType detectMimeType(byte[] bArr) {
        if (!sIsSoInstalled) {
            return null;
        }
        MimeType mimeType = com.taobao.pexode.mimetype.a.WEBP;
        if (mimeType.f(bArr)) {
            return mimeType;
        }
        MimeType mimeType2 = com.taobao.pexode.mimetype.a.WEBP_A;
        if (mimeType2.f(bArr)) {
            return mimeType2;
        }
        return null;
    }

    @Override // com.taobao.pexode.decoder.Decoder
    public boolean isSupported(MimeType mimeType) {
        return sIsSoInstalled && mimeType != null && com.taobao.pexode.mimetype.a.WEBP.a().equals(mimeType.a());
    }

    @Override // com.taobao.pexode.decoder.Decoder
    public void prepare(Context context) {
        if (!sIsSoInstalled) {
            String libraryName = getLibraryName();
            boolean z = com.taobao.pexode.common.a.b(libraryName, 2) && nativeLoadedVersionTest() == 2;
            sIsSoInstalled = z;
            kg0.f(Pexode.TAG, "retry load lib%s.so result=%b", libraryName, Boolean.valueOf(z));
        }
    }

    public String toString() {
        return "WebPDecoder@" + Integer.toHexString(hashCode());
    }
}
