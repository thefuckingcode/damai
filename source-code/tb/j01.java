package tb;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.Nullable;

@JvmName(name = "ImageUtil")
/* compiled from: Taobao */
public final class j01 {
    private static transient /* synthetic */ IpChange $ipChange;

    @Nullable
    public static final byte[] a(@Nullable Bitmap bitmap, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-431354680")) {
            return (byte[]) ipChange.ipc$dispatch("-431354680", new Object[]{bitmap, Boolean.valueOf(z)});
        } else if (bitmap == null) {
            return null;
        } else {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return byteArray;
        }
    }

    @Nullable
    public static final Uri b(@Nullable File file, @Nullable Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2116561026")) {
            return c(file, bitmap, "");
        }
        return (Uri) ipChange.ipc$dispatch("-2116561026", new Object[]{file, bitmap});
    }

    @Nullable
    public static final Uri c(@Nullable File file, @Nullable Bitmap bitmap, @Nullable String str) {
        FileOutputStream fileOutputStream;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1756509816")) {
            return (Uri) ipChange.ipc$dispatch("-1756509816", new Object[]{file, bitmap, str});
        } else if (file == null) {
            return null;
        } else {
            if (file.exists()) {
                file.delete();
            }
            try {
                file.createNewFile();
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    fileOutputStream = null;
                }
                if (fileOutputStream == null || bitmap == null) {
                    return null;
                }
                if (TextUtils.isEmpty(str)) {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                } else if (TextUtils.equals(str, "png")) {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                } else {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                }
                try {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return Uri.fromFile(file);
            } catch (IOException e3) {
                e3.printStackTrace();
                return null;
            }
        }
    }
}
