package tb;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.alibaba.pictures.uploader.FileUploader;
import com.alibaba.pictures.uploader.IImageCompressor;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
import kotlin.jvm.JvmOverloads;
import kotlin.text.o;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class ps2 implements IImageCompressor {
    private static transient /* synthetic */ IpChange $ipChange;

    private final int a(int i, int i2, os2 os2) {
        IpChange ipChange = $ipChange;
        int i3 = 1;
        if (AndroidInstantRuntime.support(ipChange, "1765971422")) {
            return ((Integer) ipChange.ipc$dispatch("1765971422", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), os2})).intValue();
        }
        if (os2.c() != null) {
            Integer c = os2.c();
            k21.f(c);
            if (c.intValue() > 0 && os2.e() != null) {
                Integer e = os2.e();
                k21.f(e);
                if (e.intValue() > 0) {
                    if (i <= i2) {
                        while (true) {
                            int i4 = i2 / i3;
                            Integer c2 = os2.c();
                            k21.f(c2);
                            if (i4 <= c2.intValue()) {
                                break;
                            }
                            i3 *= 2;
                        }
                    } else {
                        while (true) {
                            int i5 = i / i3;
                            Integer e2 = os2.e();
                            k21.f(e2);
                            if (i5 <= e2.intValue()) {
                                break;
                            }
                            i3 *= 2;
                        }
                    }
                }
            }
        }
        return i3;
    }

    private final os2 b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1786417318")) {
            return (os2) ipChange.ipc$dispatch("-1786417318", new Object[]{this});
        }
        os2 os2 = new os2();
        os2.k(60);
        os2.g(Boolean.FALSE);
        os2.j(2160);
        os2.h(3840);
        os2.i(2097152);
        return os2;
    }

    @JvmOverloads
    private final File c(Context context, byte[] bArr, String str) {
        Throwable th;
        FileOutputStream fileOutputStream;
        IOException e;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "733982231")) {
            return (File) ipChange.ipc$dispatch("733982231", new Object[]{this, context, bArr, str});
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            FileUploader.a aVar = FileUploader.Companion;
            StringBuilder sb = new StringBuilder();
            sb.append("compress:after compress this file size = ");
            if (bArr != null) {
                i = bArr.length;
            }
            sb.append(i / 1024);
            aVar.h(sb.toString());
            File createTempFile = File.createTempFile(WPKFactory.INIT_KEY_UPLOAD_COMPRESS, str, context.getCacheDir());
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

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x007f, code lost:
        if (kotlin.text.o.v(r12, "gif", false, 2, null) == false) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00d2, code lost:
        if (kotlin.text.o.v(r3, ".heif", false, 2, null) != false) goto L_0x00d4;
     */
    @Override // com.alibaba.pictures.uploader.IImageCompressor
    @Nullable
    public String compress(@Nullable String str, @Nullable os2 os2) {
        os2 os22;
        sh0 sh0;
        Context context;
        int i;
        String str2;
        String str3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1977033761")) {
            return (String) ipChange.ipc$dispatch("1977033761", new Object[]{this, str, os2});
        }
        if (str == null || str.length() == 0) {
            return str;
        }
        FileUploader.a aVar = FileUploader.Companion;
        Context b = aVar.b();
        if (os2 != null) {
            os22 = os2;
        } else {
            os22 = b();
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        sh0 sh02 = sh0.INSTANCE;
        sh02.c(b, str, options);
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        Boolean b2 = os22.b();
        Boolean bool = Boolean.TRUE;
        if (!(!k21.d(b2, bool)) || (str3 = options.outMimeType) == null) {
            context = b;
            sh0 = sh02;
            i = 2;
        } else {
            k21.h(str3, "sizeOptions.outMimeType");
            Objects.requireNonNull(str3, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = str3.toLowerCase();
            k21.h(lowerCase, "(this as java.lang.String).toLowerCase()");
            context = b;
            sh0 = sh02;
            i = 2;
        }
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        String lowerCase2 = str.toLowerCase();
        k21.h(lowerCase2, "(this as java.lang.String).toLowerCase()");
        if (!(o.v(lowerCase2, ".gif", false, i, null))) {
            if ((!k21.d(os22.b(), bool)) && (str2 = options.outMimeType) != null) {
                k21.h(str2, "sizeOptions.outMimeType");
                Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
                String lowerCase3 = str2.toLowerCase();
                k21.h(lowerCase3, "(this as java.lang.String).toLowerCase()");
                if (!(o.v(lowerCase3, "heif", false, 2, null))) {
                    String lowerCase4 = str.toLowerCase();
                    k21.h(lowerCase4, "(this as java.lang.String).toLowerCase()");
                }
                return qs2.a(str, os22);
            }
            int a = a(i2, i3, os22);
            if (!(!k21.d(os22.b(), bool)) || a != 1) {
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inJustDecodeBounds = false;
                options2.inSampleSize = a;
                aVar.h("compress:inSampleSize = " + a);
                Bitmap c = sh0.c(context, str, options2);
                StringBuilder sb = new StringBuilder();
                sb.append("compress:this file ori size tagBitmap.byteCount= ");
                sb.append((c != null ? c.getByteCount() : 0) / 1024);
                sb.append("，quality=");
                sb.append(os22.f());
                sb.append(",focusAlpha=");
                sb.append(os22.a());
                aVar.h(sb.toString());
                int h = sh0.h(context, str);
                if (!(h == 0 || h == 1)) {
                    c = sh0.i(c, h);
                }
                if (c == null) {
                    aVar.h("compress:旋转出问题了直接返回");
                    return str;
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Bitmap.CompressFormat compressFormat = k21.d(os22.a(), bool) ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
                Integer f = os22.f();
                c.compress(compressFormat, f != null ? f.intValue() : 100, byteArrayOutputStream);
                int size = byteArrayOutputStream.size();
                aVar.h("compress:the size before size scale compress=" + size);
                Integer d = os22.d();
                if (d != null) {
                    if (!(d.intValue() > 100)) {
                        d = null;
                    }
                    if (d != null) {
                        int intValue = d.intValue();
                        int i4 = size;
                        Bitmap bitmap = c;
                        int i5 = 1;
                        while (i4 > intValue && i5 <= 10) {
                            k21.f(bitmap);
                            k21.f(bitmap);
                            k21.f(bitmap);
                            bitmap = Bitmap.createScaledBitmap(bitmap, (int) (((double) bitmap.getWidth()) * 0.9d), (int) (((double) bitmap.getHeight()) * 0.9d), false);
                            byteArrayOutputStream.reset();
                            i5++;
                            k21.f(bitmap);
                            Bitmap.CompressFormat compressFormat2 = Bitmap.CompressFormat.JPEG;
                            Integer f2 = os22.f();
                            bitmap.compress(compressFormat2, f2 != null ? f2.intValue() : 100, byteArrayOutputStream);
                            i4 = byteArrayOutputStream.size();
                            FileUploader.Companion.h("compress:第-" + i5 + "-次压缩后大小=" + i4);
                        }
                        c = bitmap;
                    }
                }
                File c2 = c(context, byteArrayOutputStream.toByteArray(), k21.d(os22.a(), Boolean.TRUE) ? ".png" : ".jpeg");
                c.recycle();
                byteArrayOutputStream.close();
                if (c2 != null) {
                    return c2.getAbsolutePath();
                }
                return null;
            }
            aVar.h("compress:图片大小满足,w" + os22.c() + ":h" + os22.c() + "},不再压缩直接返回");
            return str;
        }
        aVar.h("compress:this file is a gif, ignore---return");
        return str;
    }
}
