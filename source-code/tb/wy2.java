package tb;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.tencent.open.SocialConstants;
import java.io.OutputStream;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JvmName(name = "WaterMarkUtil")
/* compiled from: Taobao */
public final class wy2 {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0057, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0058, code lost:
        tb.dj.a(r0, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005b, code lost:
        throw r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    @Nullable
    public static final String a(@NotNull ContentResolver contentResolver, @Nullable Bitmap bitmap, @Nullable String str, @Nullable String str2) {
        Uri uri;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-49256297")) {
            return (String) ipChange.ipc$dispatch("-49256297", new Object[]{contentResolver, bitmap, str, str2});
        }
        k21.i(contentResolver, "cr");
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", str);
        contentValues.put(SocialConstants.PARAM_COMMENT, str2);
        contentValues.put("mime_type", "image/png");
        try {
            uri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
            if (bitmap == null || uri == null) {
                if (uri != null) {
                    contentResolver.delete(uri, null, null);
                }
                uri = null;
                if (uri == null) {
                    return uri.toString();
                }
                return null;
            }
            try {
                OutputStream openOutputStream = contentResolver.openOutputStream(uri);
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, openOutputStream);
                dj.a(openOutputStream, null);
            } catch (Exception unused) {
                if (uri != null) {
                    contentResolver.delete(uri, null, null);
                    uri = null;
                }
                if (uri == null) {
                }
            }
            if (uri == null) {
            }
        } catch (Exception unused2) {
            uri = null;
            if (uri != null) {
            }
            if (uri == null) {
            }
        }
    }
}
