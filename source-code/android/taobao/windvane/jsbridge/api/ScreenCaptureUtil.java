package android.taobao.windvane.jsbridge.api;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.taobao.windvane.cache.WVCacheManager;
import android.taobao.windvane.jsbridge.utils.WVUtils;
import android.taobao.windvane.util.ImageTool;
import android.view.View;
import com.taobao.weex.ui.component.WXComponent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: Taobao */
public final class ScreenCaptureUtil {
    private static final int IMAGE_SAVE_REQUEST_CODE = 1553;

    /* compiled from: Taobao */
    public static final class BackFragment extends Fragment {
        private Bitmap bmp;

        public BackFragment() {
        }

        public void onActivityResult(int i, int i2, Intent intent) {
            super.onActivityResult(i, i2, intent);
            if (i == ScreenCaptureUtil.IMAGE_SAVE_REQUEST_CODE && i2 == -1) {
                try {
                    if (this.bmp != null) {
                        ScreenCaptureUtil.saveBitmapToPath(getActivity(), this.bmp, intent.getData());
                        ScreenCaptureUtil.notifyNewMedia(intent.getData(), getActivity());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public void updateBitmap(Bitmap bitmap) {
            this.bmp = bitmap;
        }

        public BackFragment(Bitmap bitmap) {
            this.bmp = bitmap;
        }
    }

    private ScreenCaptureUtil() {
    }

    public static long capture(View view, boolean z, long j, long j2, long j3, boolean z2) throws IOException {
        Bitmap bitmapFromView = getBitmapFromView(view);
        if (bitmapFromView != null) {
            WVCacheManager.getInstance().getCacheDir(true);
            long saveBitmapToCache = WVUtils.saveBitmapToCache(z2 ? ImageTool.zoomBitmap(bitmapFromView, j2, j3) : bitmapFromView);
            if (!z) {
                return saveBitmapToCache;
            }
            ImageTool.saveImage(view.getContext(), bitmapFromView);
            return saveBitmapToCache;
        }
        throw new RuntimeException("can't get bitmap from the view");
    }

    public static long captureByActivty(Activity activity, boolean z, long j, long j2, long j3, boolean z2) throws IOException {
        activity.getWindow().getDecorView().setDrawingCacheEnabled(true);
        Bitmap drawingCache = activity.getWindow().getDecorView().getDrawingCache();
        if (drawingCache != null) {
            WVCacheManager.getInstance().getCacheDir(true);
            if (z2) {
                drawingCache = ImageTool.zoomBitmap(drawingCache, j2, j3);
            }
            long saveBitmapToCache = WVUtils.saveBitmapToCache(drawingCache);
            if (!z) {
                return saveBitmapToCache;
            }
            ImageTool.saveImage(activity, drawingCache);
            return saveBitmapToCache;
        }
        throw new RuntimeException("can't get bitmap from the view");
    }

    private static String generateFileName() {
        return "SHOUTAO_" + new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", Locale.US).format(new Date()) + ".jpg";
    }

    private static Bitmap getBitmapFromView(View view) {
        view.setDrawingCacheEnabled(true);
        view.destroyDrawingCache();
        view.buildDrawingCache();
        return view.getDrawingCache();
    }

    /* access modifiers changed from: private */
    public static void notifyNewMedia(Uri uri, Context context) {
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(uri);
        context.sendBroadcast(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002f A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    public static void saveBitmapToPath(Context context, Bitmap bitmap, Uri uri) throws IOException {
        ParcelFileDescriptor parcelFileDescriptor;
        Throwable th;
        FileOutputStream fileOutputStream = 0;
        fileOutputStream = null;
        try {
            parcelFileDescriptor = context.getContentResolver().openFileDescriptor(uri, WXComponent.PROP_FS_WRAP_CONTENT);
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(parcelFileDescriptor.getFileDescriptor());
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream2);
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    try {
                        th.printStackTrace();
                    } finally {
                        if (fileOutputStream != null) {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        }
                        if (parcelFileDescriptor != null) {
                            parcelFileDescriptor.close();
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                th.printStackTrace();
            }
        } catch (Throwable th4) {
            th = th4;
            parcelFileDescriptor = fileOutputStream;
            th.printStackTrace();
        }
    }
}
