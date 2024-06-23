package com.tencent.smtt.export.external;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class libwebp {
    private static final int BITMAP_ALPHA_8 = 1;
    private static final int BITMAP_ARGB_4444 = 3;
    private static final int BITMAP_ARGB_8888 = 4;
    private static final int BITMAP_RGB_565 = 2;
    private static final String LOGTAG = "[image]";
    private static boolean isMultiCore = false;
    private static libwebp mInstance = null;
    private static boolean mIsLoadLibSuccess = false;
    private int mBitmapType = 4;

    public native int[] nativeDecode(byte[] bArr, boolean z, int[] iArr, int[] iArr2);

    public native int[] nativeDecodeInto(byte[] bArr, boolean z, int[] iArr, int[] iArr2);

    public native int[] nativeDecode_16bit(byte[] bArr, boolean z, int i);

    public native int nativeGetInfo(byte[] bArr, int[] iArr, int[] iArr2);

    public native int[] nativeIDecode(byte[] bArr, boolean z, int[] iArr, int[] iArr2);

    public static libwebp getInstance(Context context) {
        if (mInstance == null) {
            loadWepLibraryIfNeed(context);
            mInstance = new libwebp();
        }
        return mInstance;
    }

    public static void loadWepLibraryIfNeed(Context context, String str) {
        if (!mIsLoadLibSuccess) {
            try {
                System.load(str + File.separator + "libwebp_base.so");
                mIsLoadLibSuccess = true;
            } catch (UnsatisfiedLinkError unused) {
                Log.e(LOGTAG, "Load WebP Library Error...: libwebp.java - loadWepLibraryIfNeed()");
            }
        }
    }

    public static void loadWepLibraryIfNeed(Context context) {
        if (!mIsLoadLibSuccess) {
            try {
                LibraryLoader.loadLibrary(context, "webp_base");
                mIsLoadLibSuccess = true;
            } catch (UnsatisfiedLinkError unused) {
                Log.e(LOGTAG, "Load WebP Library Error...: libwebp.java - loadWepLibraryIfNeed()");
            }
        }
    }

    private boolean isMultiCore() {
        return getCPUinfo().contains("processor");
    }

    private String getCPUinfo() {
        String str = "";
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/proc/cpuinfo").start().getInputStream();
            byte[] bArr = new byte[1024];
            while (inputStream.read(bArr) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public int getInfo(byte[] bArr, int[] iArr, int[] iArr2) {
        if (!mIsLoadLibSuccess) {
            return 0;
        }
        return nativeGetInfo(bArr, iArr, iArr2);
    }

    public int[] decodeBase(byte[] bArr, int[] iArr, int[] iArr2) {
        if (mIsLoadLibSuccess) {
            return nativeDecode(bArr, isMultiCore, iArr, iArr2);
        }
        Log.e(LOGTAG, "Load WebP Library Error...");
        return null;
    }

    public int[] decodeBase_16bit(byte[] bArr, Bitmap.Config config) {
        if (!mIsLoadLibSuccess) {
            Log.e(LOGTAG, "Load WebP Library Error...");
            return null;
        }
        int i = AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[config.ordinal()];
        if (i == 1) {
            this.mBitmapType = 3;
        } else if (i != 2) {
            this.mBitmapType = 2;
        } else {
            this.mBitmapType = 2;
        }
        return nativeDecode_16bit(bArr, isMultiCore, this.mBitmapType);
    }

    /* renamed from: com.tencent.smtt.export.external.libwebp$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            $SwitchMap$android$graphics$Bitmap$Config = iArr;
            iArr[Bitmap.Config.ARGB_4444.ordinal()] = 1;
            $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.RGB_565.ordinal()] = 2;
        }
    }

    public int[] decodeInto(byte[] bArr, int[] iArr, int[] iArr2) {
        if (mIsLoadLibSuccess) {
            return nativeDecodeInto(bArr, isMultiCore, iArr, iArr2);
        }
        Log.e(LOGTAG, "Load WebP Library Error...");
        return null;
    }

    public int[] incDecode(byte[] bArr, int[] iArr, int[] iArr2) {
        if (mIsLoadLibSuccess) {
            return nativeIDecode(bArr, isMultiCore, iArr, iArr2);
        }
        Log.e(LOGTAG, "Load WebP Library Error...");
        return null;
    }

    public static int checkIsHuaModel() {
        String lowerCase = Build.BRAND.trim().toLowerCase();
        String lowerCase2 = Build.MODEL.trim().toLowerCase();
        int i = (lowerCase == null || lowerCase.length() <= 0 || !lowerCase.contains("huawei")) ? 0 : 1;
        if (lowerCase2 == null || lowerCase2.length() <= 0 || !lowerCase2.contains("huawei")) {
            return i;
        }
        return 1;
    }
}
