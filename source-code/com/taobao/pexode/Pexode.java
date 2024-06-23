package com.taobao.pexode;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import androidx.annotation.NonNull;
import com.taobao.pexode.common.DegradeEventListener;
import com.taobao.pexode.common.NdkCore;
import com.taobao.pexode.decoder.Decoder;
import com.taobao.pexode.decoder.WebPDecoder;
import com.taobao.pexode.decoder.d;
import com.taobao.pexode.entity.RewindableStream;
import com.taobao.pexode.entity.c;
import com.taobao.pexode.exception.DegradeNotAllowedException;
import com.taobao.pexode.exception.IncrementalDecodeException;
import com.taobao.pexode.exception.NotSupportedException;
import com.taobao.pexode.exception.PexodeException;
import com.taobao.pexode.mimetype.MimeType;
import com.taobao.tcommon.core.BytesPool;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import tb.kg0;
import tb.np1;

/* compiled from: Taobao */
public class Pexode {
    public static final int APPEND_DECODE_CHUNK_SIZE = 2048;
    public static final int MB = 1048576;
    public static final int MINIMUM_HEADER_BUFFER_SIZE = 64;
    public static final String TAG = "Pexode";
    public static boolean f;
    public static boolean g;
    private boolean a;
    private Context b;
    private final Decoder c;
    private final List<Decoder> d;
    private ForcedDegradationListener e;

    /* compiled from: Taobao */
    public interface ForcedDegradationListener {
        void onForcedDegrade2NoAshmem();

        void onForcedDegrade2NoInBitmap();

        void onForcedDegrade2System();
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b {
        private static final Pexode a = new Pexode();
    }

    public static boolean a(MimeType mimeType) {
        if (mimeType == null) {
            return false;
        }
        for (Decoder decoder : b.a.d) {
            if (decoder.isSupported(mimeType)) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(MimeType mimeType) {
        return b.a.c.isSupported(mimeType);
    }

    private static void c(PexodeOptions pexodeOptions) {
        if (pexodeOptions.enableAshmem && !j()) {
            kg0.i(TAG, "cannot use ashmem in the runtime, disabled ashmem already!", new Object[0]);
            pexodeOptions.enableAshmem = false;
        }
        if (pexodeOptions.inBitmap != null && !l()) {
            kg0.i(TAG, "cannot reuse bitmap in the runtime, disabled inBitmap already!", new Object[0]);
            pexodeOptions.inBitmap = null;
        }
    }

    public static np1 d(@NonNull InputStream inputStream, @NonNull PexodeOptions pexodeOptions) throws IOException, PexodeException {
        RewindableStream rewindableStream;
        RewindableStream rewindableStream2;
        if (inputStream instanceof RewindableStream) {
            rewindableStream = (RewindableStream) inputStream;
        } else {
            if (inputStream instanceof FileInputStream) {
                rewindableStream2 = new com.taobao.pexode.entity.b((FileInputStream) inputStream, 1048576);
            } else {
                rewindableStream2 = new c(inputStream, 1048576);
            }
            rewindableStream = rewindableStream2;
        }
        return e(rewindableStream, pexodeOptions, a.f());
    }

    private static np1 e(RewindableStream rewindableStream, PexodeOptions pexodeOptions, DegradeEventListener degradeEventListener) throws IOException, PexodeException {
        Decoder decoder;
        Bitmap bitmap;
        c(pexodeOptions);
        MimeType mimeType = pexodeOptions.outMimeType;
        if (mimeType == null) {
            decoder = o(rewindableStream, pexodeOptions, rewindableStream.getBufferLength());
        } else {
            decoder = p(mimeType);
        }
        MimeType mimeType2 = pexodeOptions.outMimeType;
        boolean z = true;
        pexodeOptions.outAlpha = mimeType2 != null && mimeType2.c();
        boolean z2 = pexodeOptions.enableAshmem;
        Bitmap bitmap2 = pexodeOptions.inBitmap;
        if (!pexodeOptions.incrementalDecode || decoder.canDecodeIncrementally(mimeType2)) {
            np1 decode = decoder.decode(rewindableStream, pexodeOptions, degradeEventListener);
            if (!(decode == null || (bitmap = decode.a) == null)) {
                bitmap.getConfig();
            }
            Object[] objArr = new Object[8];
            objArr[0] = decoder;
            objArr[1] = Integer.valueOf(rewindableStream.getInputType());
            objArr[2] = Boolean.valueOf(pexodeOptions.justDecodeBounds);
            objArr[3] = Boolean.valueOf(pexodeOptions.isSizeAvailable());
            objArr[4] = Boolean.valueOf(pexodeOptions.enableAshmem);
            if (pexodeOptions.inBitmap == null) {
                z = false;
            }
            objArr[5] = Boolean.valueOf(z);
            objArr[6] = Boolean.valueOf(pexodeOptions.incrementalDecode);
            objArr[7] = decode;
            kg0.a(TAG, "decoder=%s, type=%d, justBounds=%b, sizeAvailable=%b, ashmem=%b, inBitmap=%b, increment=%b, result=%s", objArr);
            if (a.i(decode, pexodeOptions) || decoder == b.a.c) {
                return decode;
            }
            Decoder decoder2 = b.a.c;
            if (mimeType2 == null || !decoder2.isSupported(mimeType2) || (pexodeOptions.incrementalDecode && !decoder2.canDecodeIncrementally(mimeType2))) {
                if (pexodeOptions.incrementalDecode) {
                    throw new IncrementalDecodeException("incremental decoding not supported for type[" + mimeType2 + "] when degraded to system");
                }
                throw new NotSupportedException("type[" + mimeType2 + "] not supported when degraded to system");
            } else if (pexodeOptions.allowDegrade2System) {
                rewindableStream.rewind();
                pexodeOptions.enableAshmem = z2;
                pexodeOptions.inBitmap = bitmap2;
                np1 decode2 = decoder2.decode(rewindableStream, pexodeOptions, degradeEventListener);
                if (!pexodeOptions.cancelled) {
                    degradeEventListener.onDegraded2System(a.j(decode2, pexodeOptions));
                }
                return decode2;
            } else {
                throw new DegradeNotAllowedException("unfortunately, system supported type[" + mimeType2 + "] but not allow degrading to system");
            }
        } else {
            throw new IncrementalDecodeException("incremental decoding not supported for type[" + mimeType2 + "] in " + decoder);
        }
    }

    public static void f(boolean z) {
        synchronized (b.a) {
            if (z != b.a.a) {
                kg0.i(TAG, "force degrading to system decoder, result=%b", Boolean.valueOf(z));
                b.a.d.remove(b.a.c);
                if (z) {
                    b.a.d.add(0, b.a.c);
                } else {
                    b.a.d.add(b.a.c);
                }
                b.a.a = z;
            }
        }
    }

    public static List<Decoder> g(MimeType mimeType) {
        ArrayList arrayList = new ArrayList();
        for (Decoder decoder : b.a.d) {
            if (decoder.isSupported(mimeType)) {
                arrayList.add(decoder);
            }
        }
        return arrayList;
    }

    static ForcedDegradationListener h() {
        return b.a.e;
    }

    public static void i(Decoder decoder) {
        synchronized (b.a) {
            if (b.a.a) {
                b.a.d.add(1, decoder);
            } else {
                b.a.d.add(0, decoder);
            }
            if (b.a.b != null) {
                decoder.prepare(b.a.b);
            }
        }
    }

    public static boolean j() {
        int i;
        return NdkCore.b() && (i = Build.VERSION.SDK_INT) >= 14 && i <= 19;
    }

    static boolean k() {
        return b.a.a;
    }

    public static boolean l() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public static int m(RewindableStream rewindableStream, MimeType mimeType, boolean z) {
        int inputType = rewindableStream.getInputType();
        if (inputType == 1) {
            return inputType;
        }
        Decoder p = p(mimeType);
        if (p.acceptInputType(inputType, mimeType, z)) {
            return inputType;
        }
        if (inputType != 2 || !p.acceptInputType(3, mimeType, z)) {
            return 1;
        }
        return 3;
    }

    public static void n(Context context) {
        synchronized (b.a) {
            b.a.b = context;
            com.taobao.pexode.common.a.a(context);
            NdkCore.c(context);
            for (Decoder decoder : b.a.d) {
                decoder.prepare(context);
            }
        }
    }

    private static Decoder o(RewindableStream rewindableStream, PexodeOptions pexodeOptions, int i) throws IOException {
        byte[] g2 = a.f().g(i);
        pexodeOptions.tempHeaderBuffer = g2;
        int i2 = 0;
        try {
            i2 = rewindableStream.read(g2, 0, i);
        } catch (IOException unused) {
        }
        rewindableStream.rewind();
        if (i2 > 0) {
            for (Decoder decoder : b.a.d) {
                MimeType detectMimeType = decoder.detectMimeType(pexodeOptions.tempHeaderBuffer);
                pexodeOptions.outMimeType = detectMimeType;
                if (detectMimeType != null) {
                    return decoder;
                }
            }
        }
        return b.a.c;
    }

    private static Decoder p(MimeType mimeType) {
        if (mimeType != null) {
            for (Decoder decoder : b.a.d) {
                if (decoder.isSupported(mimeType)) {
                    return decoder;
                }
            }
        }
        return b.a.c;
    }

    public static void q(BytesPool bytesPool) {
        a.f().k(bytesPool);
    }

    public static void r(ForcedDegradationListener forcedDegradationListener) {
        b.a.e = forcedDegradationListener;
    }

    private Pexode() {
        d dVar = new d();
        this.c = dVar;
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.d = copyOnWriteArrayList;
        copyOnWriteArrayList.add(new WebPDecoder());
        copyOnWriteArrayList.add(new com.taobao.pexode.decoder.c());
        copyOnWriteArrayList.add(dVar);
    }
}
