package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.FileDescriptor;

/* compiled from: Taobao */
public class es extends et {
    protected int a;
    protected int b;

    public es(Context context, int i, int i2) {
        super(context);
        a(i, i2);
    }

    public void a(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    private Bitmap a(int i) {
        return a(this.d, i, this.a, this.b, a());
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.mapcore.util.et
    public Bitmap a(Object obj) {
        return a(Integer.parseInt(String.valueOf(obj)));
    }

    public static Bitmap a(Resources resources, int i, int i2, int i3, eu euVar) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i, options);
        options.inSampleSize = a(options, i2, i3);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources, i, options);
    }

    public static Bitmap a(FileDescriptor fileDescriptor, int i, int i2, eu euVar) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
        options.inSampleSize = a(options, i, i2);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
    }

    public static int a(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        if (i3 <= i2 && i4 <= i) {
            return 1;
        }
        int round = Math.round(((float) i3) / ((float) i2));
        int round2 = Math.round(((float) i4) / ((float) i));
        if (round >= round2) {
            round = round2;
        }
        while (((float) (i4 * i3)) / ((float) (round * round)) > ((float) (i * i2 * 2))) {
            round++;
        }
        return round;
    }
}
