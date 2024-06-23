package cn.damai.common.image.luban;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: Taobao */
public class a {
    private static transient /* synthetic */ IpChange $ipChange;
    private InputStreamProvider a;
    private File b;
    private int c;
    private int d;
    private boolean e;

    a(InputStreamProvider inputStreamProvider, File file, boolean z) throws IOException {
        this.b = file;
        this.a = inputStreamProvider;
        this.e = z;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inSampleSize = 1;
        BitmapFactory.decodeStream(inputStreamProvider.open(), null, options);
        this.c = options.outWidth;
        this.d = options.outHeight;
    }

    private int b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1721156952")) {
            return ((Integer) ipChange.ipc$dispatch("-1721156952", new Object[]{this})).intValue();
        }
        int i = this.c;
        if (i % 2 == 1) {
            i++;
        }
        this.c = i;
        int i2 = this.d;
        if (i2 % 2 == 1) {
            i2++;
        }
        this.d = i2;
        int max = Math.max(i, i2);
        float min = ((float) Math.min(this.c, this.d)) / ((float) max);
        if (min > 1.0f || ((double) min) <= 0.5625d) {
            double d2 = (double) min;
            if (d2 > 0.5625d || d2 <= 0.5d) {
                return (int) Math.ceil(((double) max) / (1280.0d / d2));
            }
            int i3 = max / 1280;
            if (i3 == 0) {
                return 1;
            }
            return i3;
        } else if (max < 1664) {
            return 1;
        } else {
            if (max < 4990) {
                return 2;
            }
            if (max > 4990 && max < 10240) {
                return 4;
            }
            int i4 = max / 1280;
            if (i4 == 0) {
                return 1;
            }
            return i4;
        }
    }

    private Bitmap c(Bitmap bitmap, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-968592195")) {
            return (Bitmap) ipChange.ipc$dispatch("-968592195", new Object[]{this, bitmap, Integer.valueOf(i)});
        }
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    /* access modifiers changed from: package-private */
    public File a() throws IOException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2141089842")) {
            return (File) ipChange.ipc$dispatch("2141089842", new Object[]{this});
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = b();
        Bitmap decodeStream = BitmapFactory.decodeStream(this.a.open(), null, options);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Checker checker = Checker.SINGLE;
        if (checker.isJPG(this.a.open())) {
            decodeStream = c(decodeStream, checker.getOrientation(this.a.open()));
        }
        if (decodeStream == null) {
            return new File(this.a.getPath());
        }
        decodeStream.compress(this.e ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG, 60, byteArrayOutputStream);
        decodeStream.recycle();
        FileOutputStream fileOutputStream = new FileOutputStream(this.b);
        fileOutputStream.write(byteArrayOutputStream.toByteArray());
        fileOutputStream.flush();
        fileOutputStream.close();
        byteArrayOutputStream.close();
        return this.b;
    }
}
