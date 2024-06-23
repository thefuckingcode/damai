package tb;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.alibaba.pictures.uploader.FileUploader;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
import kotlin.text.o;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class qs2 {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006f, code lost:
        if (kotlin.text.o.v(r0, ".heif", false, 2, null) != false) goto L_0x0071;
     */
    @Nullable
    public static final String a(@Nullable String str, @Nullable os2 os2) {
        Integer f;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-655102923")) {
            return (String) ipChange.ipc$dispatch("-655102923", new Object[]{str, os2});
        }
        if (str == null || str.length() == 0) {
            return str;
        }
        FileUploader.a aVar = FileUploader.Companion;
        Context b = aVar.b();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        sh0.INSTANCE.c(aVar.b(), str, options);
        String str2 = options.outMimeType;
        if (str2 != null) {
            k21.h(str2, "sizeOptions.outMimeType");
            Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = str2.toLowerCase();
            k21.h(lowerCase, "(this as java.lang.String).toLowerCase()");
            if (!(o.v(lowerCase, "heif", false, 2, null))) {
                Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                String lowerCase2 = str.toLowerCase();
                k21.h(lowerCase2, "(this as java.lang.String).toLowerCase()");
            }
            Bitmap decodeFile = BitmapFactory.decodeFile(str);
            if (decodeFile != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Boolean a = os2 != null ? os2.a() : null;
                Boolean bool = Boolean.TRUE;
                decodeFile.compress(k21.d(a, bool) ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG, (os2 == null || (f = os2.f()) == null) ? 100 : f.intValue(), byteArrayOutputStream);
                File b2 = b(b, byteArrayOutputStream.toByteArray(), k21.d(os2 != null ? os2.a() : null, bool) ? ".png" : ".jpeg");
                decodeFile.recycle();
                byteArrayOutputStream.close();
                if (b2 != null) {
                    return b2.getAbsolutePath();
                }
                return null;
            }
        }
        return str;
    }

    private static final File b(Context context, byte[] bArr, String str) {
        Throwable th;
        FileOutputStream fileOutputStream;
        IOException e;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-2143069949")) {
            return (File) ipChange.ipc$dispatch("-2143069949", new Object[]{context, bArr, str});
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            FileUploader.a aVar = FileUploader.Companion;
            StringBuilder sb = new StringBuilder();
            sb.append("decode:after decode this file size = ");
            if (bArr != null) {
                i = bArr.length;
            }
            sb.append(i / 1024);
            aVar.h(sb.toString());
            File createTempFile = File.createTempFile("upload_decode", str, context.getCacheDir());
            fileOutputStream = new FileOutputStream(createTempFile);
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.flush();
                try {
                    fileOutputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return createTempFile;
            } catch (IOException e3) {
                e = e3;
                try {
                    e.printStackTrace();
                    try {
                        k21.f(fileOutputStream);
                        fileOutputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    try {
                        k21.f(fileOutputStream2);
                        fileOutputStream2.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    throw th;
                }
            }
        } catch (IOException e6) {
            e = e6;
            fileOutputStream = null;
            e.printStackTrace();
            k21.f(fileOutputStream);
            fileOutputStream.close();
            return null;
        } catch (Throwable th3) {
            th = th3;
            k21.f(fileOutputStream2);
            fileOutputStream2.close();
            throw th;
        }
    }
}
