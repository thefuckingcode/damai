package tb;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import com.alibaba.pictures.uploader.FileUploader;
import com.alibaba.security.realidentity.jsbridge.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.liveplayback.widget.plugins.resize.AntiShakeOrientationEventListener;
import io.flutter.wpkbridge.WPKFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.JvmOverloads;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class sh0 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final sh0 INSTANCE = new sh0();

    private sh0() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007c, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007d, code lost:
        tb.dj.a(r13, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0080, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0083, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0084, code lost:
        tb.dj.a(r12, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0087, code lost:
        throw r13;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005f  */
    private final File b(Context context, Uri uri, String str) {
        String str2;
        InputStream openInputStream;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1026629341")) {
            return (File) ipChange.ipc$dispatch("1026629341", new Object[]{this, context, uri, str});
        }
        if (str != null) {
            try {
                if (StringsKt__StringsKt.l0(str, ".", 0, false, 6, null) >= 0) {
                    str2 = str.substring(StringsKt__StringsKt.l0(str, ".", 0, false, 6, null));
                    k21.h(str2, "(this as java.lang.String).substring(startIndex)");
                    openInputStream = context.getContentResolver().openInputStream(uri);
                    File createTempFile = File.createTempFile(WPKFactory.INIT_KEY_UPLOAD_COMPRESS, str2, context.getCacheDir());
                    FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                    if (openInputStream != null) {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = openInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        fileOutputStream.flush();
                        ur2 ur2 = ur2.INSTANCE;
                        dj.a(fileOutputStream, null);
                        dj.a(openInputStream, null);
                    }
                    return createTempFile;
                }
            } catch (IOException e) {
                FileUploader.Companion.h("copyAndSaveFile:" + e);
                e.printStackTrace();
                return null;
            }
        }
        str2 = null;
        openInputStream = context.getContentResolver().openInputStream(uri);
        File createTempFile2 = File.createTempFile(WPKFactory.INIT_KEY_UPLOAD_COMPRESS, str2, context.getCacheDir());
        FileOutputStream fileOutputStream2 = new FileOutputStream(createTempFile2);
        if (openInputStream != null) {
        }
        return createTempFile2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0083, code lost:
        r15 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0084, code lost:
        tb.dj.a(r3, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0087, code lost:
        throw r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00bb, code lost:
        if (r5 != false) goto L_0x00bd;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0043 A[Catch:{ Exception -> 0x00ee }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0044 A[Catch:{ Exception -> 0x00ee }] */
    @Nullable
    public final String a(@Nullable Context context, @Nullable String str) {
        boolean z;
        File b;
        String str2;
        String str3;
        IpChange ipChange = $ipChange;
        boolean z2 = true;
        if (AndroidInstantRuntime.support(ipChange, "1267980000")) {
            return (String) ipChange.ipc$dispatch("1267980000", new Object[]{this, context, str});
        }
        String str4 = null;
        if (!(context == null || str == null)) {
            try {
                Uri parse = Uri.parse(str);
                k21.h(parse, "Uri.parse(path)");
                String path = parse.getPath();
                if (path != null) {
                    if (path.length() != 0) {
                        z = false;
                        if (!z) {
                            return null;
                        }
                        if (k21.d("content", parse.getScheme())) {
                            Cursor query = context.getContentResolver().query(parse, new String[]{"_data", "_display_name"}, null, null, null);
                            if (query != null) {
                                if (query.moveToFirst()) {
                                    int columnIndexOrThrow = query.getColumnIndexOrThrow("_data");
                                    int columnIndexOrThrow2 = query.getColumnIndexOrThrow("_display_name");
                                    str2 = query.getString(columnIndexOrThrow);
                                    str3 = query.getString(columnIndexOrThrow2);
                                } else {
                                    str3 = null;
                                    str2 = null;
                                }
                                ur2 ur2 = ur2.INSTANCE;
                                dj.a(query, null);
                            } else {
                                str3 = null;
                                str2 = null;
                            }
                            if (str2 == null || g(str2)) {
                                File b2 = b(context, parse, str3);
                                if (b2 != null) {
                                    str4 = b2.getAbsolutePath();
                                }
                            } else {
                                str4 = str2;
                            }
                        } else {
                            if (!k21.d("file", parse.getScheme())) {
                                String scheme = parse.getScheme();
                                if (!(scheme == null || scheme.length() == 0)) {
                                    z2 = false;
                                }
                            }
                            String path2 = parse.getPath();
                            if (path2 != null) {
                                sh0 sh0 = INSTANCE;
                                if (sh0.g(path2)) {
                                    k21.h(path2, a.V);
                                    Uri d = sh0.d(context, path2);
                                    if (d == null) {
                                        d = sh0.f(context, path2);
                                    }
                                    if (!(d == null || (b = sh0.b(context, d, parse.getPath())) == null)) {
                                        str4 = b.getAbsolutePath();
                                    }
                                } else {
                                    str4 = path2;
                                }
                            }
                        }
                        FileUploader.Companion.h("checkAndCreateFileAbsPath:" + str4);
                    }
                }
                z = true;
                if (!z) {
                }
            } catch (Exception e) {
                FileUploader.Companion.h("error:checkAndCreateFileAbsPath:" + e);
            }
        }
        return str4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0041, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0042, code lost:
        tb.dj.a(r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0045, code lost:
        throw r7;
     */
    @JvmOverloads
    @Nullable
    public final Bitmap c(@NotNull Context context, @Nullable String str, @Nullable BitmapFactory.Options options) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "346443029")) {
            return (Bitmap) ipChange.ipc$dispatch("346443029", new Object[]{this, context, str, options});
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            ParcelFileDescriptor e = e(context, str);
            if (e != null) {
                Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(e.getFileDescriptor(), null, options);
                dj.a(e, null);
                return decodeFileDescriptor;
            }
        } catch (Exception e2) {
            FileUploader.a aVar = FileUploader.Companion;
            aVar.h("MoImageDecodeHelper.decodeImageFile:" + e2);
        }
        return null;
    }

    @Nullable
    public final Uri d(@NotNull Context context, @NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "173529916")) {
            return (Uri) ipChange.ipc$dispatch("173529916", new Object[]{this, context, str});
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(str, a.V);
        Cursor query = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=? ", new String[]{str}, null);
        if (query == null || !query.moveToFirst()) {
            if (query != null) {
                query.close();
            }
            return null;
        }
        int i = query.getInt(query.getColumnIndex("_id"));
        query.close();
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        return Uri.withAppendedPath(uri, "" + i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003f A[Catch:{ Exception -> 0x00e7 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0040 A[Catch:{ Exception -> 0x00e7 }] */
    @Nullable
    public final ParcelFileDescriptor e(@Nullable Context context, @Nullable String str) {
        boolean z;
        IpChange ipChange = $ipChange;
        boolean z2 = true;
        if (AndroidInstantRuntime.support(ipChange, "-246740980")) {
            return (ParcelFileDescriptor) ipChange.ipc$dispatch("-246740980", new Object[]{this, context, str});
        }
        ParcelFileDescriptor parcelFileDescriptor = null;
        if (context == null || str == null) {
            return null;
        }
        try {
            Uri parse = Uri.parse(str);
            k21.h(parse, "pathUri");
            String path = parse.getPath();
            if (path != null) {
                if (path.length() != 0) {
                    z = false;
                    if (!z) {
                        return null;
                    }
                    if (k21.d("content", parse.getScheme())) {
                        return context.getContentResolver().openFileDescriptor(parse, UploadQueueMgr.MSGTYPE_REALTIME);
                    }
                    if (!k21.d("file", parse.getScheme())) {
                        String scheme = parse.getScheme();
                        if (!(scheme == null || scheme.length() == 0)) {
                            z2 = false;
                        }
                        if (!z2) {
                            FileUploader.Companion.h("getFileDescriptor:this file scheme is not content and file or abs file path!!!");
                            return null;
                        }
                    }
                    String path2 = parse.getPath();
                    k21.f(path2);
                    k21.h(path2, "pathUri.path!!");
                    Uri d = d(context, path2);
                    if (d != null) {
                        try {
                            parcelFileDescriptor = context.getContentResolver().openFileDescriptor(d, UploadQueueMgr.MSGTYPE_REALTIME);
                        } catch (Exception e) {
                            FileUploader.a aVar = FileUploader.Companion;
                            aVar.h("getImageFileDescriptor:contentResolver.openFileDescriptor:" + e);
                        }
                        if (parcelFileDescriptor != null) {
                            return parcelFileDescriptor;
                        }
                        try {
                            String path3 = parse.getPath();
                            k21.f(path3);
                            return ParcelFileDescriptor.open(new File(path3), 268435456);
                        } catch (Exception e2) {
                            FileUploader.a aVar2 = FileUploader.Companion;
                            aVar2.h("getImageFileDescriptor:ParcelFileDescriptor.open:" + e2);
                            return parcelFileDescriptor;
                        }
                    } else {
                        FileUploader.Companion.h("getFileDescriptor:this file maybe not an image !!!");
                        ur2 ur2 = ur2.INSTANCE;
                        return null;
                    }
                }
            }
            z = true;
            if (!z) {
            }
        } catch (Exception e3) {
            FileUploader.a aVar3 = FileUploader.Companion;
            aVar3.h("getImageFileDescriptor:" + e3);
            return null;
        }
    }

    @Nullable
    public final Uri f(@NotNull Context context, @NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1624635812")) {
            return (Uri) ipChange.ipc$dispatch("-1624635812", new Object[]{this, context, str});
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(str, a.V);
        Cursor query = context.getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=? ", new String[]{str}, null);
        if (query == null || !query.moveToFirst()) {
            if (query != null) {
                query.close();
            }
            return null;
        }
        int i = query.getInt(query.getColumnIndex("_id"));
        query.close();
        Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        return Uri.withAppendedPath(uri, "" + i);
    }

    public final boolean g(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-690128929")) {
            return ((Boolean) ipChange.ipc$dispatch("-690128929", new Object[]{this, str})).booleanValue();
        } else if (str == null) {
            return false;
        } else {
            try {
                File file = new File(str);
                if (Build.VERSION.SDK_INT != 29 || file.canRead()) {
                    return false;
                }
                return true;
            } catch (Exception e) {
                FileUploader.a aVar = FileUploader.Companion;
                aVar.h("MoImageDecodeHelper:isFileNotAccess:" + e);
                return false;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0053, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0054, code lost:
        tb.dj.a(r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0057, code lost:
        throw r0;
     */
    public final int h(@NotNull Context context, @Nullable String str) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "267028326")) {
            return ((Integer) ipChange.ipc$dispatch("267028326", new Object[]{this, context, str})).intValue();
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        if (str == null || str.length() == 0) {
            return 0;
        }
        try {
            ParcelFileDescriptor e = e(context, str);
            if (e != null) {
                i = new ExifInterface(e.getFileDescriptor()).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
                ur2 ur2 = ur2.INSTANCE;
                dj.a(e, null);
            }
        } catch (Exception e2) {
            FileUploader.a aVar = FileUploader.Companion;
            aVar.h("MoImageDecodeHelper:readImageRotation:" + e2);
        }
        return i;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Nullable
    public final Bitmap i(@Nullable Bitmap bitmap, int i) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "384474481")) {
            return (Bitmap) ipChange.ipc$dispatch("384474481", new Object[]{this, bitmap, Integer.valueOf(i)});
        } else if (i == 1 || i == 0 || bitmap == null) {
            return bitmap;
        } else {
            int i2 = 90;
            switch (i) {
                case 1:
                default:
                    i2 = 0;
                    break;
                case 2:
                    i2 = 0;
                    z = true;
                    break;
                case 3:
                    i2 = 180;
                    break;
                case 4:
                    i2 = 180;
                    z = true;
                    break;
                case 5:
                    i2 = AntiShakeOrientationEventListener.SCREEN_ORIENTATION_LANDSCAPE;
                    z = true;
                    break;
                case 6:
                    break;
                case 7:
                    z = true;
                    break;
                case 8:
                    i2 = AntiShakeOrientationEventListener.SCREEN_ORIENTATION_LANDSCAPE;
                    break;
            }
            Matrix matrix = new Matrix();
            if (z) {
                matrix.postScale(-1.0f, 1.0f);
            }
            if (i2 != 0) {
                matrix.postRotate((float) i2);
            }
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        }
    }
}
