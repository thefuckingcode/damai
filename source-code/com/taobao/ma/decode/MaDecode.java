package com.taobao.ma.decode;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.YuvImage;
import com.taobao.ma.ar.ARInputParam;
import com.taobao.ma.ar.ARResult;
import com.taobao.ma.common.config.MaConfig;
import com.taobao.ma.common.log.MaLogger;
import com.taobao.ma.util.ImageTool;
import com.taobao.ma.util.StringEncodeUtils;
import com.taobao.ma.util.StringUtils;
import com.youku.upsplayer.util.YKUpsConvert;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import tb.u91;

/* compiled from: Taobao */
public class MaDecode {
    private static boolean isInDecoding = false;

    static {
        MaLogger.v("Madecode: loading so files");
        if (!MaConfig.hasSoLoaded) {
            try {
                System.loadLibrary("tbdecode");
                MaConfig.hasSoLoaded = true;
            } catch (UnsatisfiedLinkError e) {
                MaLogger.e("Failed to load libtbdecode.so", e);
            }
        }
    }

    private static synchronized DecodeResult codeDecode(byte[] bArr, int i, int i2, int i3, Rect rect, int i4, String str, String[] strArr) {
        synchronized (MaDecode.class) {
            DecodeResult decodeResult = null;
            if (isInDecoding) {
                return null;
            }
            isInDecoding = true;
            if (bArr == null) {
                MaLogger.w("codeDecode data is null");
                return null;
            }
            try {
                decodeResult = yuvcodeDecode(bArr, i, i2, i3, rect, i4, str, strArr);
            } catch (UnsatisfiedLinkError e) {
                MaLogger.e("Failed to load libtbdecode.so", e);
            } catch (Exception e2) {
                MaLogger.e(e2);
            }
            DecodeResult handleDecodeResult = handleDecodeResult(decodeResult);
            isInDecoding = false;
            return handleDecodeResult;
        }
    }

    public static synchronized DecodeResult codeDecodePictureWithQr(String str) {
        DecodeResult codeDecodePictureWithQr;
        synchronized (MaDecode.class) {
            codeDecodePictureWithQr = codeDecodePictureWithQr(str, 512);
        }
        return codeDecodePictureWithQr;
    }

    private static native DecodeResult codeDecodeWithQr(byte[] bArr, int i, int i2, int i3, int i4);

    public static synchronized ARResult detectGen3Markers(ARInputParam aRInputParam) {
        ARResult convertId;
        synchronized (MaDecode.class) {
            ARResult aRResult = new ARResult();
            detectMarkers(aRInputParam.imageData, aRInputParam.imageWidth, aRInputParam.imageHeight, aRInputParam.preXCoords, aRInputParam.preYCoords, aRInputParam.preDim, aRInputParam.preInCount, -1, aRInputParam.interestP1_X, aRInputParam.interestP1_Y, aRInputParam.interestP2_X, aRInputParam.interestP2_Y, aRResult);
            convertId = aRResult.pointNum == 0 ? null : aRResult.convertId();
        }
        return convertId;
    }

    private static native void detectMarkers(byte[] bArr, int i, int i2, int[] iArr, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, ARResult aRResult);

    public static synchronized Bitmap encode(String str, Bitmap bitmap, int i, char c) {
        Bitmap handleResult;
        synchronized (MaDecode.class) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i2 = bitmap.hasAlpha() ? 4 : 3;
            handleResult = handleResult(encode(str, getPixelData(bitmap, width, height, i2), width, height, i2, i, c), width, height, i2);
        }
        return handleResult;
    }

    private static native byte[] encode(String str, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, char c, char c2, int i9, int i10, int i11);

    private static byte[] getPixelData(Bitmap bitmap, int i, int i2, int i3) {
        int i4 = i * i2;
        byte[] bArr = new byte[(i3 * i4)];
        int[] iArr = new int[i4];
        bitmap.getPixels(iArr, 0, i, 0, 0, i, i2);
        int i5 = 0;
        int i6 = 0;
        while (i5 < i4) {
            int i7 = iArr[i5];
            byte b = (byte) ((i7 >> 24) & 255);
            bArr[i6] = (byte) ((i7 >> 16) & 255);
            bArr[i6 + 1] = (byte) ((i7 >> 8) & 255);
            bArr[i6 + 2] = (byte) (i7 & 255);
            if (i3 == 4) {
                bArr[i6 + 3] = b;
            }
            i5++;
            i6 += i3;
        }
        return bArr;
    }

    private static DecodeResult handleDecodeResult(DecodeResult decodeResult) {
        byte[] bArr;
        if (decodeResult == null || (bArr = decodeResult.bytes) == null || bArr.length <= 0) {
            return null;
        }
        try {
            String stringEncode = StringEncodeUtils.getStringEncode(bArr);
            if (StringUtils.isEmpty(stringEncode)) {
                decodeResult.strCode = new String(decodeResult.bytes, "utf-8");
            } else {
                decodeResult.strCode = new String(decodeResult.bytes, stringEncode);
            }
            decodeResult.bytes = null;
            if (StringUtils.isEmpty(decodeResult.strCode)) {
                decodeResult = null;
            }
            return decodeResult;
        } catch (UnsupportedEncodingException | Exception unused) {
            return null;
        }
    }

    private static Bitmap handleResult(byte[] bArr, int i, int i2, int i3) {
        if (bArr == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        int[] iArr = new int[(i * i2)];
        int i4 = 0;
        int i5 = 0;
        while (i4 < bArr.length) {
            iArr[i5] = (i3 == 4 ? (bArr[i4 + 3] & 255) << 24 : -16777216) + ((bArr[i4] & 255) << 16) + ((bArr[i4 + 1] & 255) << 8) + (bArr[i4 + 2] & 255);
            i4 += i3;
            i5++;
        }
        createBitmap.setPixels(iArr, 0, i, 0, 0, i, i2);
        return createBitmap;
    }

    private static native void releaseMemory();

    public static void releaseStaticMemory() {
        releaseMemory();
    }

    public static DecodeResult yuvcodeDecode(YuvImage yuvImage, Rect rect, int i, String str, String[] strArr) {
        return codeDecode(yuvImage.getYuvData(), yuvImage.getWidth(), yuvImage.getHeight(), yuvImage.getStrides()[0], rect, i, str, strArr);
    }

    private static native DecodeResult yuvcodeDecode(byte[] bArr, int i, int i2, int i3, Rect rect, int i4, String str, String[] strArr);

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0029, code lost:
        return null;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    public static synchronized DecodeResult codeDecodePictureWithQr(String str, int i) {
        synchronized (MaDecode.class) {
            if (StringUtils.isEmpty(str)) {
                return null;
            }
            File file = new File(str);
            if (!file.exists()) {
                return null;
            }
            return codeDecodePictureWithQr(ImageTool.createThumbnail(file, 1024, 1024), i);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002c, code lost:
        if (r20 == r21) goto L_0x002e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0035  */
    private static synchronized byte[] encode(String str, byte[] bArr, int i, int i2, int i3, int i4, char c) {
        byte[] bArr2;
        synchronized (MaDecode.class) {
            char c2 = i4 == 3 ? c : YKUpsConvert.CHAR_ZERO;
            int i5 = 0;
            char[] cArr = {'Q', 'Q', u91.LEVEL_L, u91.LEVEL_L};
            if (i <= i2) {
                if (i < i2) {
                    i5 = i2;
                }
                bArr2 = null;
                bArr2 = encode(str, bArr, i, i2, i3, i3 * i, 0, 0, 0, 0, c2, cArr[i4], 2, i5 < 350 ? 4 : 3, i4);
            }
            i5 = i;
            bArr2 = null;
            try {
                bArr2 = encode(str, bArr, i, i2, i3, i3 * i, 0, 0, 0, 0, c2, cArr[i4], 2, i5 < 350 ? 4 : 3, i4);
            } catch (UnsatisfiedLinkError e) {
                MaLogger.e("Failed to load libtbdecode.so", e);
            } catch (Exception e2) {
                MaLogger.e(e2);
            }
        }
        return bArr2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0054, code lost:
        r5 = null;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    public static synchronized DecodeResult codeDecodePictureWithQr(Bitmap bitmap, int i) {
        DecodeResult decodeResult;
        synchronized (MaDecode.class) {
            DecodeResult decodeResult2 = null;
            Bitmap.Config config = bitmap.getConfig();
            Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
            if (config != config2) {
                Bitmap copy = bitmap.copy(config2, true);
                bitmap.recycle();
                bitmap = copy;
            }
            ByteBuffer allocate = ByteBuffer.allocate(bitmap.getHeight() * bitmap.getRowBytes());
            allocate.order(ByteOrder.BIG_ENDIAN);
            bitmap.copyPixelsToBuffer(allocate);
            try {
                decodeResult2 = codeDecodeWithQr(allocate.array(), bitmap.getWidth(), bitmap.getHeight(), bitmap.getRowBytes(), i);
            } catch (UnsatisfiedLinkError e) {
                MaLogger.e("Failed to load libtbdecode.so", e);
            } catch (Exception e2) {
                MaLogger.e(e2);
            }
            decodeResult = handleDecodeResult(decodeResult2);
        }
        return decodeResult;
    }
}
