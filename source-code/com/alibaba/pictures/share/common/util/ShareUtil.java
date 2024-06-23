package com.alibaba.pictures.share.common.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import com.alibaba.pictures.share.R$color;
import com.alibaba.pictures.share.ShareManager;
import com.alibaba.pictures.share.common.share.ShareContent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.push.constant.RemoteMessageConst;
import io.flutter.wpkbridge.WPKFactory;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import kotlin.jvm.JvmName;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.bc1;
import tb.j01;
import tb.k21;
import tb.v92;

@JvmName(name = "ShareUtil")
/* compiled from: Taobao */
public final class ShareUtil {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int a = 300;

    @Nullable
    public static final Bitmap a(@Nullable Bitmap bitmap, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "381839528")) {
            return (Bitmap) ipChange.ipc$dispatch("381839528", new Object[]{bitmap, Integer.valueOf(i)});
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 80;
        do {
            byteArrayOutputStream.reset();
            if (bitmap != null) {
                bitmap.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
            }
            i2 -= 10;
        } while (byteArrayOutputStream.toByteArray().length > i * 1024);
        Bitmap decodeStream = BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), null, null);
        if ((!k21.d(bitmap, decodeStream)) && bitmap != null && !bitmap.isRecycled()) {
            m(bitmap);
        }
        try {
            byteArrayOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return decodeStream;
    }

    @Nullable
    public static final Bitmap b(@NotNull Bitmap bitmap, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "973731848")) {
            return (Bitmap) ipChange.ipc$dispatch("973731848", new Object[]{bitmap, Integer.valueOf(i)});
        }
        k21.i(bitmap, "image");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        int i2 = i * 1024;
        if (byteArrayOutputStream.toByteArray().length < i2) {
            return bitmap;
        }
        while (byteArrayOutputStream.toByteArray().length > i2) {
            float length = ((float) i2) / ((float) byteArrayOutputStream.toByteArray().length);
            bitmap = Bitmap.createScaledBitmap(bitmap, (int) (((float) bitmap.getWidth()) * length), (int) (((float) bitmap.getHeight()) * length), false);
            k21.h(bitmap, "Bitmap.createScaledBitma…          false\n        )");
            byteArrayOutputStream.reset();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        }
        try {
            byteArrayOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    @Nullable
    public static final Bitmap c(@Nullable Bitmap bitmap, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1064750093")) {
            return (Bitmap) ipChange.ipc$dispatch("-1064750093", new Object[]{bitmap, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (bitmap == null) {
            return null;
        } else {
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            Application a2 = ShareManager.INSTANCE.a();
            if (a2 != null) {
                paint.setColor(ContextCompat.getColor(a2, R$color.white));
            }
            float f = (float) i;
            canvas.drawRect(0.0f, 0.0f, f, f, paint);
            canvas.drawBitmap(bitmap, (float) ((i - bitmap.getWidth()) / 2), (float) ((i2 - bitmap.getHeight()) / 2), paint);
            canvas.save();
            canvas.restore();
            return createBitmap;
        }
    }

    @Nullable
    public static final Bitmap d(@Nullable Bitmap bitmap, int i, int i2) {
        int i3;
        Bitmap bitmap2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1368204657")) {
            return (Bitmap) ipChange.ipc$dispatch("-1368204657", new Object[]{bitmap, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (bitmap == null || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0 || i <= 0 || i2 <= 0) {
            return null;
        } else {
            double d = (double) i;
            double width = (double) bitmap.getWidth();
            double d2 = (d * 1.0d) / width;
            double d3 = (double) i2;
            double height = (double) bitmap.getHeight();
            double max = Math.max(d2, (1.0d * d3) / height);
            if (max == d2) {
                i3 = 0;
                bitmap2 = Bitmap.createScaledBitmap(bitmap, i, (int) (height * max), false);
            } else {
                i3 = 0;
                bitmap2 = Bitmap.createScaledBitmap(bitmap, (int) (width * max), i2, false);
            }
            Bitmap createBitmap = Bitmap.createBitmap(bitmap2, i3, i3, i, i2);
            byte[] a2 = j01.a(createBitmap, true);
            if ((a2 != null ? a2.length : 0) > 130000) {
                d(createBitmap, (int) (d * 0.9d), (int) (d3 * 0.9d));
            }
            return createBitmap;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0084 A[Catch:{ Exception -> 0x0030 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0095 A[Catch:{ Exception -> 0x0030 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    @Nullable
    public static final Bitmap e(@Nullable Context context, @Nullable ShareContent shareContent) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Exception e;
        Bitmap decodeResource;
        ShareManager shareManager;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-83369948")) {
            return (Bitmap) ipChange.ipc$dispatch("-83369948", new Object[]{context, shareContent});
        }
        if (shareContent != null) {
            try {
                bitmap = shareContent.getDefaultImage();
            } catch (Exception e2) {
                e = e2;
                bitmap2 = null;
            }
        } else {
            bitmap = null;
        }
        if (bitmap != null) {
            try {
                if (bitmap.isRecycled()) {
                }
                if (bitmap == null || bitmap.isRecycled()) {
                    shareManager = ShareManager.INSTANCE;
                    if (shareManager.b().e() != 2) {
                        Activity activity = (Activity) (!(context instanceof Activity) ? null : context);
                        if (activity != null) {
                            activity.runOnUiThread(ShareUtil$getShareBitmap$1.INSTANCE);
                        }
                    } else {
                        Integer c = shareManager.b().c();
                        if (c != null) {
                            decodeResource = BitmapFactory.decodeResource(context != null ? context.getResources() : null, c.intValue());
                            bitmap = decodeResource;
                        }
                        bitmap = null;
                    }
                }
            } catch (Exception e3) {
                bitmap2 = bitmap;
                e = e3;
                e.printStackTrace();
                ShareManager shareManager2 = ShareManager.INSTANCE;
                if (shareManager2.b().e() == 2) {
                    if (!(context instanceof Activity)) {
                        context = null;
                    }
                    Activity activity2 = (Activity) context;
                    if (activity2 != null) {
                        activity2.runOnUiThread(ShareUtil$getShareBitmap$3.INSTANCE);
                    }
                    bitmap = bitmap2;
                    if (bitmap != null) {
                    }
                } else {
                    Integer c2 = shareManager2.b().c();
                    if (c2 != null) {
                        decodeResource = BitmapFactory.decodeResource(context != null ? context.getResources() : null, c2.intValue());
                        bitmap = decodeResource;
                        if (bitmap != null) {
                        }
                    }
                    bitmap = null;
                    if (bitmap != null) {
                    }
                }
            }
            if (bitmap != null) {
                return null;
            }
            int i = 1000;
            int imageMaxSizeKb = shareContent != null ? shareContent.getImageMaxSizeKb() : 1000;
            if (imageMaxSizeKb > 0) {
                i = imageMaxSizeKb;
            }
            return b(bitmap, i);
        }
        List<String> imgUrls = shareContent != null ? shareContent.getImgUrls() : null;
        if (imgUrls != null) {
            if (!imgUrls.isEmpty()) {
                z = false;
            }
        }
        if (!z) {
            String str = imgUrls.get(0);
            if (!TextUtils.isEmpty(str)) {
                if (!(o.L(str, "http", false, 2, null))) {
                    bitmap = bc1.a(context, str);
                } else {
                    bitmap = BitmapFactory.decodeStream(new URL(str).openStream());
                }
            }
        }
        shareManager = ShareManager.INSTANCE;
        if (shareManager.b().e() != 2) {
        }
    }

    @Nullable
    public static final String f(@NotNull Context context, @Nullable Bitmap bitmap, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1336072456")) {
            return (String) ipChange.ipc$dispatch("-1336072456", new Object[]{context, bitmap, Boolean.valueOf(z)});
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        if (!k21.d("mounted", Environment.getExternalStorageState())) {
            ShareManager shareManager = ShareManager.INSTANCE;
            if (shareManager.a() != null) {
                Toast.makeText(shareManager.a(), "分享失败，请插入SD卡", 0).show();
            } else {
                v92.f();
            }
            return null;
        } else if (bitmap == null || bitmap.isRecycled()) {
            return null;
        } else {
            File externalCacheDir = context.getExternalCacheDir();
            File file = new File(String.valueOf(externalCacheDir) + "/share");
            if (!file.exists()) {
                file.mkdirs();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(file);
            sb.append("/share");
            sb.append(z ? Long.valueOf(System.currentTimeMillis()) : "");
            sb.append(".jpeg");
            File file2 = new File(sb.toString());
            if (j01.b(file2, bitmap) != null) {
                return file2.getAbsolutePath();
            }
            return "";
        }
    }

    public static /* synthetic */ String g(Context context, Bitmap bitmap, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return f(context, bitmap, z);
    }

    @Nullable
    public static final Bitmap h(@Nullable Context context, @Nullable ShareContent shareContent, int i) {
        Bitmap bitmap;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-976060604")) {
            return (Bitmap) ipChange.ipc$dispatch("-976060604", new Object[]{context, shareContent, Integer.valueOf(i)});
        }
        Bitmap e = e(context, shareContent);
        Resources resources = null;
        if (e == null) {
            return null;
        }
        int height = e.getHeight();
        int width = e.getWidth();
        if (height >= width) {
            bitmap = Bitmap.createBitmap(e, 0, (height - width) / 2, width, width, (Matrix) null, false);
            k21.h(bitmap, "Bitmap.createBitmap(bmp,…idth, width, null, false)");
        } else {
            bitmap = Bitmap.createBitmap(e, (width - height) / 2, 0, height, height, (Matrix) null, false);
            k21.h(bitmap, "Bitmap.createBitmap(bmp,…ght, height, null, false)");
        }
        int height2 = bitmap.getHeight();
        int i2 = a;
        if (height2 > i2) {
            height2 = i2;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, height2, height2, true);
        if (!k21.d(bitmap, createScaledBitmap)) {
            m(bitmap);
        }
        if (!k21.d(e, createScaledBitmap)) {
            m(e);
        }
        if (shareContent != null) {
            Integer valueOf = Integer.valueOf(shareContent.getTypeIconId());
            if (valueOf.intValue() > 0) {
                z = true;
            }
            if (!z) {
                valueOf = null;
            }
            if (valueOf != null) {
                int intValue = valueOf.intValue();
                if (context != null) {
                    resources = context.getResources();
                }
                Bitmap decodeResource = BitmapFactory.decodeResource(resources, intValue);
                k21.h(createScaledBitmap, "thumbBmp");
                k21.h(decodeResource, RemoteMessageConst.Notification.ICON);
                Bitmap l = l(createScaledBitmap, decodeResource);
                m(createScaledBitmap);
                createScaledBitmap = l;
            }
        }
        k21.h(createScaledBitmap, "thumbBmp");
        return a(b(createScaledBitmap, i), i);
    }

    @Nullable
    public static final Bitmap i(@Nullable Bitmap bitmap, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "58299336")) {
            return j(bitmap, a, i);
        }
        return (Bitmap) ipChange.ipc$dispatch("58299336", new Object[]{bitmap, Integer.valueOf(i)});
    }

    @Nullable
    public static final Bitmap j(@Nullable Bitmap bitmap, int i, int i2) {
        Bitmap bitmap2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "456130871")) {
            return (Bitmap) ipChange.ipc$dispatch("456130871", new Object[]{bitmap, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (bitmap == null) {
            return null;
        } else {
            int height = bitmap.getHeight();
            int width = bitmap.getWidth();
            if (height >= width) {
                bitmap2 = Bitmap.createBitmap(bitmap, 0, (height - width) / 2, width, width, (Matrix) null, false);
                k21.h(bitmap2, "Bitmap.createBitmap(bmp,…idth, width, null, false)");
            } else {
                bitmap2 = Bitmap.createBitmap(bitmap, (width - height) / 2, 0, height, height, (Matrix) null, false);
                k21.h(bitmap2, "Bitmap.createBitmap(bmp,…ght, height, null, false)");
            }
            int height2 = bitmap2.getHeight();
            if (height2 > i) {
                height2 = i;
            }
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap2, height2, height2, true);
            k21.h(createScaledBitmap, "thumbBmp");
            return a(b(createScaledBitmap, i2), i2);
        }
    }

    @Nullable
    public static final Bitmap k(@Nullable Bitmap bitmap, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1128909387")) {
            return (Bitmap) ipChange.ipc$dispatch("-1128909387", new Object[]{bitmap, Integer.valueOf(i)});
        }
        Bitmap bitmap2 = null;
        if (bitmap == null) {
            return null;
        }
        Bitmap c = c(bitmap, (bitmap.getHeight() * 5) / 4, bitmap.getHeight());
        if (c != null) {
            bitmap2 = b(c, i);
        }
        return a(bitmap2, i);
    }

    private static final Bitmap l(Bitmap bitmap, Bitmap bitmap2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "566510557")) {
            return (Bitmap) ipChange.ipc$dispatch("566510557", new Object[]{bitmap, bitmap2});
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
        Rect rect = new Rect();
        rect.top = (bitmap.getHeight() - min) / 2;
        int width = (bitmap.getWidth() - min) / 2;
        rect.left = width;
        rect.right = width + min;
        rect.bottom = rect.top + min;
        canvas.drawBitmap(bitmap2, (Rect) null, rect, (Paint) null);
        m(bitmap);
        m(bitmap2);
        k21.h(createBitmap, "bitmap");
        return createBitmap;
    }

    public static final void m(@Nullable Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1567700888")) {
            ipChange.ipc$dispatch("1567700888", new Object[]{bitmap});
        }
    }

    public static final void n(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2009867642")) {
            ipChange.ipc$dispatch("-2009867642", new Object[]{str});
            return;
        }
        k21.i(str, "msg");
        o(str, false);
    }

    public static final void o(@NotNull String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2118658318")) {
            ipChange.ipc$dispatch("2118658318", new Object[]{str, Boolean.valueOf(z)});
            return;
        }
        k21.i(str, "msg");
        ShareManager.IToast n = ShareManager.INSTANCE.b().n();
        if (n != null) {
            n.showToast(str, z);
        }
    }
}
