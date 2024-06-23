package cn.damai.common.image.luban;

import android.graphics.BitmapFactory;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* compiled from: Taobao */
enum Checker {
    SINGLE;
    
    private static final String JPG = ".jpg";
    private static final String TAG = "Luban";
    private final byte[] JPEG_SIGNATURE = {-1, -40, -1};

    private Checker() {
    }

    private int pack(byte[] bArr, int i, int i2, boolean z) {
        int i3;
        if (z) {
            i += i2 - 1;
            i3 = -1;
        } else {
            i3 = 1;
        }
        int i4 = 0;
        while (true) {
            int i5 = i2 - 1;
            if (i2 <= 0) {
                return i4;
            }
            i4 = (bArr[i] & 255) | (i4 << 8);
            i += i3;
            i2 = i5;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:15|16|17|18|19) */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0022, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0029, code lost:
        return new byte[0];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002d, code lost:
        throw r7;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0024 */
    private byte[] toByteArray(InputStream inputStream) {
        if (inputStream == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr, 0, 4096);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused) {
                }
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public String extSuffix(InputStreamProvider inputStreamProvider) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(inputStreamProvider.open(), null, options);
            return options.outMimeType.replace("image/", ".");
        } catch (Exception unused) {
            return JPG;
        }
    }

    /* access modifiers changed from: package-private */
    public int getOrientation(InputStream inputStream) {
        return getOrientation(toByteArray(inputStream));
    }

    /* access modifiers changed from: package-private */
    public boolean isJPG(InputStream inputStream) {
        return isJPG(toByteArray(inputStream));
    }

    /* access modifiers changed from: package-private */
    public boolean needCompress(int i, String str) {
        if (i <= 0) {
            return true;
        }
        File file = new File(str);
        if (!file.exists() || file.length() <= ((long) (i << 10))) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0066, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0067, code lost:
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0068, code lost:
        if (r3 <= 8) goto L_0x00d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x006a, code lost:
        r2 = pack(r12, r1, 4, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0071, code lost:
        if (r2 == 1229531648) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0076, code lost:
        if (r2 == 1296891946) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0078, code lost:
        android.util.Log.e(cn.damai.common.image.luban.Checker.TAG, "Invalid byte order");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x007d, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x007e, code lost:
        if (r2 != 1229531648) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0080, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0082, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0083, code lost:
        r4 = pack(r12, r1 + 4, 4, r2) + 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x008c, code lost:
        if (r4 < 10) goto L_0x00ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x008e, code lost:
        if (r4 <= r3) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0091, code lost:
        r1 = r1 + r4;
        r3 = r3 - r4;
        r4 = pack(r12, r1 - 2, 2, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0099, code lost:
        r9 = r4 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x009b, code lost:
        if (r4 <= 0) goto L_0x00d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x009f, code lost:
        if (r3 < 12) goto L_0x00d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00a7, code lost:
        if (pack(r12, r1, 2, r2) != 274) goto L_0x00c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00a9, code lost:
        r12 = pack(r12, r1 + 8, 2, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00ae, code lost:
        if (r12 == 1) goto L_0x00c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00b1, code lost:
        if (r12 == 3) goto L_0x00c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00b4, code lost:
        if (r12 == 6) goto L_0x00c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00b6, code lost:
        if (r12 == 8) goto L_0x00be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00b8, code lost:
        android.util.Log.e(cn.damai.common.image.luban.Checker.TAG, "Unsupported orientation");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00bd, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00be, code lost:
        return com.youku.live.dago.liveplayback.widget.plugins.resize.AntiShakeOrientationEventListener.SCREEN_ORIENTATION_LANDSCAPE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00c1, code lost:
        return 90;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00c4, code lost:
        return 180;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00c7, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00c8, code lost:
        r1 = r1 + 12;
        r3 = r3 - 12;
        r4 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00ce, code lost:
        android.util.Log.e(cn.damai.common.image.luban.Checker.TAG, "Invalid offset");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00d3, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00d4, code lost:
        android.util.Log.e(cn.damai.common.image.luban.Checker.TAG, "Orientation not found");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00d9, code lost:
        return 0;
     */
    private int getOrientation(byte[] bArr) {
        int i;
        if (bArr == null) {
            return 0;
        }
        int i2 = 0;
        while (true) {
            if (i2 + 3 >= bArr.length) {
                break;
            }
            int i3 = i2 + 1;
            if ((bArr[i2] & 255) != 255) {
                break;
            }
            int i4 = bArr[i3] & 255;
            if (i4 != 255) {
                i3++;
                if (!(i4 == 216 || i4 == 1)) {
                    if (i4 != 217 && i4 != 218) {
                        int pack = pack(bArr, i3, 2, false);
                        if (pack >= 2 && (i = i3 + pack) <= bArr.length) {
                            if (i4 == 225 && pack >= 8 && pack(bArr, i3 + 2, 4, false) == 1165519206 && pack(bArr, i3 + 6, 2, false) == 0) {
                                i2 = i3 + 8;
                                int i5 = pack - 8;
                                break;
                            }
                            i2 = i;
                        } else {
                            Log.e(TAG, "Invalid length");
                        }
                    } else {
                        break;
                    }
                }
            }
            i2 = i3;
        }
        Log.e(TAG, "Invalid length");
        return 0;
    }

    private boolean isJPG(byte[] bArr) {
        if (bArr == null || bArr.length < 3) {
            return false;
        }
        return Arrays.equals(this.JPEG_SIGNATURE, new byte[]{bArr[0], bArr[1], bArr[2]});
    }
}
