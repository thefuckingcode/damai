package com.taobao.pexode.decoder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import com.taobao.pexode.Pexode;
import com.taobao.pexode.PexodeOptions;
import com.taobao.pexode.common.DegradeEventListener;
import com.taobao.pexode.common.NdkCore;
import com.taobao.pexode.entity.RewindableStream;
import com.taobao.pexode.exception.PexodeException;
import com.taobao.pexode.mimetype.MimeType;
import com.taobao.pexode.mimetype.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;
import tb.kg0;
import tb.np1;

/* compiled from: Taobao */
public class d implements Decoder {
    private static final boolean b;
    private static final boolean c;
    private Context a;

    static {
        int i = Build.VERSION.SDK_INT;
        boolean z = true;
        b = i >= 14;
        if (i <= 17) {
            z = false;
        }
        c = z;
    }

    private static void a(RewindableStream rewindableStream, PexodeOptions pexodeOptions) throws PexodeException {
        if (rewindableStream.getInputType() == 2 && Build.VERSION.SDK_INT == 19) {
            if (!pexodeOptions.justDecodeBounds) {
                kg0.f(Pexode.TAG, "maybe leak when system decoding with fd, back to input stream type!", new Object[0]);
            }
            rewindableStream.back2StreamType();
        }
        if (rewindableStream.getInputType() == 3) {
            if (pexodeOptions.enableAshmem) {
                kg0.i(Pexode.TAG, "cannot use ashmem when system decoding with input stream(justBounds=%b), disabled already!", Boolean.valueOf(pexodeOptions.justDecodeBounds));
                pexodeOptions.enableAshmem = false;
            }
            if (a.WEBP.g(pexodeOptions.outMimeType) && !c) {
                kg0.c(Pexode.TAG, "maybe error black image when system decoding webp with input stream(justBounds=%b)!", Boolean.valueOf(pexodeOptions.justDecodeBounds));
            }
        }
    }

    public static String b(int i) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(random.nextInt(52)));
        }
        return sb.toString();
    }

    private static BitmapFactory.Options c(PexodeOptions pexodeOptions) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = pexodeOptions.justDecodeBounds;
        if (!com.taobao.pexode.a.f().a) {
            options.inBitmap = pexodeOptions.inBitmap;
        }
        if (pexodeOptions.isSizeAvailable()) {
            options.outWidth = pexodeOptions.outWidth;
            options.outHeight = pexodeOptions.outHeight;
        }
        MimeType mimeType = pexodeOptions.outMimeType;
        if (mimeType != null) {
            options.outMimeType = mimeType.toString();
        }
        options.inSampleSize = pexodeOptions.sampleSize;
        boolean z = true;
        options.inDither = true;
        options.inPreferredConfig = PexodeOptions.CONFIG;
        if (com.taobao.pexode.a.f().b || !pexodeOptions.enableAshmem) {
            z = false;
        }
        d(options, z);
        com.taobao.pexode.a.n(pexodeOptions, options);
        return options;
    }

    public static void d(BitmapFactory.Options options, boolean z) {
        options.inMutable = true;
        if (!options.inJustDecodeBounds) {
            options.inPurgeable = z;
            options.inInputShareable = z;
        }
    }

    private static void e(PexodeOptions pexodeOptions, BitmapFactory.Options options) {
        pexodeOptions.outWidth = options.outWidth;
        pexodeOptions.outHeight = options.outHeight;
        com.taobao.pexode.a.n(pexodeOptions, null);
    }

    @Override // com.taobao.pexode.decoder.Decoder
    public boolean acceptInputType(int i, MimeType mimeType, boolean z) {
        if (Pexode.g && Build.VERSION.SDK_INT == 28 && (a.WEBP_A.g(mimeType) || a.WEBP.g(mimeType))) {
            return i == 1;
        }
        if (i == 2 && Build.VERSION.SDK_INT == 19) {
            return false;
        }
        if (i == 3) {
            if (z) {
                return false;
            }
            if (!a.WEBP.g(mimeType) || c) {
                return true;
            }
            return false;
        }
        return true;
    }

    @Override // com.taobao.pexode.decoder.Decoder
    public boolean canDecodeIncrementally(MimeType mimeType) {
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x0100 A[Catch:{ Exception -> 0x0141 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x012c A[Catch:{ Exception -> 0x0141 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0172  */
    @Override // com.taobao.pexode.decoder.Decoder
    public np1 decode(RewindableStream rewindableStream, PexodeOptions pexodeOptions, DegradeEventListener degradeEventListener) throws PexodeException, IOException {
        Bitmap bitmap;
        boolean z;
        boolean z2;
        np1 a2;
        int inputType;
        Bitmap decodeByteArray;
        a(rewindableStream, pexodeOptions);
        BitmapFactory.Options c2 = c(pexodeOptions);
        boolean z3 = c2.inPurgeable && c2.inInputShareable;
        boolean z4 = c2.inBitmap != null;
        try {
            if (!(Pexode.g && Build.VERSION.SDK_INT == 28 && (a.WEBP_A.g(pexodeOptions.outMimeType) || a.WEBP.g(pexodeOptions.outMimeType)) && rewindableStream.getInputType() == 1) || this.a == null) {
                z = z4;
                bitmap = null;
                z2 = false;
                if (!z2 || (bitmap == null && !c2.inJustDecodeBounds)) {
                    try {
                        inputType = rewindableStream.getInputType();
                        if (inputType != 1) {
                            decodeByteArray = BitmapFactory.decodeByteArray(rewindableStream.getBuffer(), rewindableStream.getBufferOffset(), rewindableStream.getBufferLength(), c2);
                        } else if (inputType == 2) {
                            decodeByteArray = BitmapFactory.decodeFileDescriptor(rewindableStream.getFD(), pexodeOptions.outPadding, c2);
                        } else if (pexodeOptions.resourceValue != null) {
                            Context context = this.a;
                            decodeByteArray = BitmapFactory.decodeResourceStream(context != null ? context.getResources() : null, pexodeOptions.resourceValue, rewindableStream, pexodeOptions.outPadding, c2);
                        } else {
                            decodeByteArray = BitmapFactory.decodeStream(rewindableStream, pexodeOptions.outPadding, c2);
                        }
                        bitmap = decodeByteArray;
                        e(pexodeOptions, c2);
                    } catch (Exception e) {
                        kg0.c(Pexode.TAG, "SystemDecoder type=%d, error=%s", Integer.valueOf(rewindableStream.getInputType()), e);
                    }
                }
                if (bitmap != null && z3) {
                    try {
                        NdkCore.nativePinBitmap(bitmap);
                    } catch (Throwable th) {
                        kg0.c(Pexode.TAG, "NdkCore nativePinBitmap error=%s", th);
                        bitmap = null;
                    }
                }
                a2 = np1.a(bitmap);
                if (!com.taobao.pexode.a.i(a2, pexodeOptions)) {
                    if (z3 && pexodeOptions.allowDegrade2NoAshmem) {
                        rewindableStream.rewind();
                        pexodeOptions.enableAshmem = false;
                        a2 = decode(rewindableStream, pexodeOptions, degradeEventListener);
                        if (!com.taobao.pexode.a.b(pexodeOptions)) {
                            degradeEventListener.onDegraded2NoAshmem(com.taobao.pexode.a.j(a2, pexodeOptions));
                        }
                    } else if (z && pexodeOptions.allowDegrade2NoInBitmap) {
                        rewindableStream.rewind();
                        pexodeOptions.inBitmap = null;
                        a2 = decode(rewindableStream, pexodeOptions, degradeEventListener);
                        if (!com.taobao.pexode.a.b(pexodeOptions)) {
                            degradeEventListener.onDegraded2NoInBitmap(com.taobao.pexode.a.j(a2, pexodeOptions));
                        }
                    }
                }
                return a2;
            }
            c2.outMimeType = null;
            c2.inBitmap = null;
            try {
                String str = this.a.getCacheDir().toString() + "/Phenix/";
                File file = new File(str);
                if (!file.exists() ? file.mkdirs() : true) {
                    long currentTimeMillis = System.currentTimeMillis();
                    String str2 = str + String.valueOf(currentTimeMillis) + b(2);
                    if ((WebPConvert.sIsSoInstalled ? WebPConvert.nativeProcess(rewindableStream.getBuffer(), str2) : -1) != -1) {
                        File file2 = new File(str2);
                        FileInputStream fileInputStream = new FileInputStream(file2);
                        bitmap = BitmapFactory.decodeStream(fileInputStream, pexodeOptions.outPadding, c2);
                        try {
                            fileInputStream.close();
                            if (!file2.delete()) {
                                kg0.c(Pexode.TAG, "Delete File Failed", new Object[0]);
                            }
                            z2 = true;
                            z = false;
                        } catch (Throwable unused) {
                            z4 = false;
                            kg0.c(Pexode.TAG, "WebP Convert Exception", new Object[0]);
                            z = z4;
                            z2 = false;
                            inputType = rewindableStream.getInputType();
                            if (inputType != 1) {
                            }
                            bitmap = decodeByteArray;
                            e(pexodeOptions, c2);
                            NdkCore.nativePinBitmap(bitmap);
                            a2 = np1.a(bitmap);
                            if (!com.taobao.pexode.a.i(a2, pexodeOptions)) {
                            }
                            return a2;
                        }
                        inputType = rewindableStream.getInputType();
                        if (inputType != 1) {
                        }
                        bitmap = decodeByteArray;
                        e(pexodeOptions, c2);
                        NdkCore.nativePinBitmap(bitmap);
                        a2 = np1.a(bitmap);
                        if (!com.taobao.pexode.a.i(a2, pexodeOptions)) {
                        }
                        return a2;
                    }
                    kg0.c(Pexode.TAG, "WebP Convert Failed", new Object[0]);
                } else {
                    kg0.c(Pexode.TAG, "mkdir Failed", new Object[0]);
                }
                bitmap = null;
                z2 = false;
                z = false;
            } catch (Throwable unused2) {
                bitmap = null;
                z4 = false;
                kg0.c(Pexode.TAG, "WebP Convert Exception", new Object[0]);
                z = z4;
                z2 = false;
                inputType = rewindableStream.getInputType();
                if (inputType != 1) {
                }
                bitmap = decodeByteArray;
                e(pexodeOptions, c2);
                NdkCore.nativePinBitmap(bitmap);
                a2 = np1.a(bitmap);
                if (!com.taobao.pexode.a.i(a2, pexodeOptions)) {
                }
                return a2;
            }
            inputType = rewindableStream.getInputType();
            if (inputType != 1) {
            }
            bitmap = decodeByteArray;
            e(pexodeOptions, c2);
            NdkCore.nativePinBitmap(bitmap);
            a2 = np1.a(bitmap);
            if (!com.taobao.pexode.a.i(a2, pexodeOptions)) {
            }
            return a2;
        } catch (Throwable unused3) {
            bitmap = null;
            kg0.c(Pexode.TAG, "WebP Convert Exception", new Object[0]);
            z = z4;
            z2 = false;
            inputType = rewindableStream.getInputType();
            if (inputType != 1) {
            }
            bitmap = decodeByteArray;
            e(pexodeOptions, c2);
            NdkCore.nativePinBitmap(bitmap);
            a2 = np1.a(bitmap);
            if (!com.taobao.pexode.a.i(a2, pexodeOptions)) {
            }
            return a2;
        }
    }

    @Override // com.taobao.pexode.decoder.Decoder
    public MimeType detectMimeType(byte[] bArr) {
        if (b) {
            MimeType mimeType = a.WEBP;
            if (mimeType.f(bArr)) {
                return mimeType;
            }
        }
        MimeType mimeType2 = a.JPEG;
        if (mimeType2.f(bArr)) {
            return mimeType2;
        }
        MimeType mimeType3 = a.PNG;
        if (mimeType3.f(bArr)) {
            return mimeType3;
        }
        MimeType mimeType4 = a.PNG_A;
        if (mimeType4.f(bArr)) {
            return mimeType4;
        }
        if (c) {
            MimeType mimeType5 = a.WEBP_A;
            if (mimeType5.f(bArr)) {
                return mimeType5;
            }
        }
        MimeType mimeType6 = a.BMP;
        if (mimeType6.f(bArr)) {
            return mimeType6;
        }
        if (!Pexode.f || Build.VERSION.SDK_INT != 28) {
            return null;
        }
        MimeType mimeType7 = a.HEIF;
        if (mimeType7.f(bArr)) {
            return mimeType7;
        }
        return null;
    }

    @Override // com.taobao.pexode.decoder.Decoder
    public boolean isSupported(MimeType mimeType) {
        return mimeType != null && ((b && mimeType.g(a.WEBP)) || mimeType.g(a.JPEG) || mimeType.g(a.PNG) || mimeType.g(a.PNG_A) || ((c && mimeType.g(a.WEBP_A)) || mimeType.g(a.BMP) || (Pexode.f && Build.VERSION.SDK_INT == 28 && mimeType.g(a.HEIF))));
    }

    @Override // com.taobao.pexode.decoder.Decoder
    public void prepare(Context context) {
        this.a = context;
    }

    public String toString() {
        return "SystemDecoder@" + Integer.toHexString(hashCode());
    }
}
