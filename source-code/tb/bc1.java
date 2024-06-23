package tb;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import com.alibaba.security.realidentity.jsbridge.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.io.IOException;
import java.util.Objects;
import kotlin.jvm.JvmName;
import kotlin.text.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JvmName(name = "MediaUtil")
/* compiled from: Taobao */
public final class bc1 {
    private static transient /* synthetic */ IpChange $ipChange;

    @Nullable
    public static final Bitmap a(@Nullable Context context, @Nullable String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2018828943")) {
            return b(context, str, null);
        }
        return (Bitmap) ipChange.ipc$dispatch("-2018828943", new Object[]{context, str});
    }

    @Nullable
    public static final Bitmap b(@Nullable Context context, @Nullable String str, @Nullable BitmapFactory.Options options) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-2061683761")) {
            return (Bitmap) ipChange.ipc$dispatch("-2061683761", new Object[]{context, str, options});
        }
        if (context != null) {
            if (str == null || str.length() == 0) {
                z = true;
            }
            if (!z) {
                if (!e(context, str)) {
                    return BitmapFactory.decodeFile(str, options);
                }
                Uri parse = Uri.parse(str);
                if (!k21.d("content", parse != null ? parse.getScheme() : null)) {
                    parse = d(context, str);
                }
                if (parse == null) {
                    return null;
                }
                try {
                    ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(parse, UploadQueueMgr.MSGTYPE_REALTIME);
                    if (openFileDescriptor == null) {
                        return null;
                    }
                    Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(openFileDescriptor.getFileDescriptor(), null, options);
                    openFileDescriptor.close();
                    return decodeFileDescriptor;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @NotNull
    public static final String c(@Nullable Context context, @Nullable String str) {
        ContentResolver contentResolver;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1993018808")) {
            return (String) ipChange.ipc$dispatch("1993018808", new Object[]{context, str});
        }
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        Uri parse = Uri.parse(str);
        if (parse != null) {
            Cursor query = (context == null || (contentResolver = context.getContentResolver()) == null) ? null : contentResolver.query(parse, null, null, null, null);
            if (query != null) {
                if (query.moveToFirst()) {
                    String string = query.getString(query.getColumnIndexOrThrow("_data"));
                    k21.h(string, "cur.getString(index)");
                    str2 = string;
                }
                query.close();
            }
        }
        return str2;
    }

    @Nullable
    public static final Uri d(@NotNull Context context, @NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-424085128")) {
            return (Uri) ipChange.ipc$dispatch("-424085128", new Object[]{context, str});
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(str, a.V);
        Cursor query = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=? ", new String[]{str}, null);
        if (query == null || !query.moveToFirst()) {
            return null;
        }
        int i = query.getInt(query.getColumnIndex("_id"));
        Uri parse = Uri.parse("content://media/external/images/media");
        Uri withAppendedPath = Uri.withAppendedPath(parse, "" + i);
        query.close();
        return withAppendedPath;
    }

    public static final boolean e(@Nullable Context context, @Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-416523413")) {
            return ((Boolean) ipChange.ipc$dispatch("-416523413", new Object[]{context, str})).booleanValue();
        }
        if (context != null) {
            if (!(str == null || str.length() == 0) && Build.VERSION.SDK_INT >= 29) {
                int l0 = g.l0(str, "/", 0, false, 6, null);
                Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                String substring = str.substring(0, l0);
                k21.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String packageName = context.getPackageName();
                k21.h(packageName, "context.packageName");
                if (!g.Q(substring, packageName, false, 2, null)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
