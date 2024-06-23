package com.taobao.ma.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.util.Log;
import com.youku.live.dago.liveplayback.widget.plugins.resize.AntiShakeOrientationEventListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: Taobao */
public class ImageTool {
    private static int computeInitialSampleSize(BitmapFactory.Options options, int i, int i2) {
        int i3;
        int i4;
        double d = (double) options.outWidth;
        double d2 = (double) options.outHeight;
        if (i2 == -1) {
            i3 = 1;
        } else {
            i3 = (int) Math.ceil(Math.sqrt((d * d2) / ((double) i2)));
        }
        if (i == -1) {
            i4 = 128;
        } else {
            double d3 = (double) i;
            i4 = (int) Math.min(Math.floor(d / d3), Math.floor(d2 / d3));
        }
        if (i4 < i3) {
            return i3;
        }
        if (i2 == -1 && i == -1) {
            return 1;
        }
        return i == -1 ? i3 : i4;
    }

    public static int computeSampleSize(BitmapFactory.Options options, int i, int i2) {
        int computeInitialSampleSize = computeInitialSampleSize(options, i, i2);
        if (computeInitialSampleSize > 8) {
            return ((computeInitialSampleSize + 7) / 8) * 8;
        }
        int i3 = 1;
        while (i3 < computeInitialSampleSize) {
            i3 <<= 1;
        }
        return i3;
    }

    public static Bitmap createThumbnail(File file, int i, int i2) {
        return createThumbnail(file, i, i2, false);
    }

    private static int getDigreeForPicturePath(String str) {
        ExifInterface exifInterface;
        try {
            exifInterface = new ExifInterface(str);
        } catch (IOException e) {
            e.printStackTrace();
            exifInterface = null;
        }
        if (exifInterface == null) {
            return 0;
        }
        int attributeInt = exifInterface.getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 0);
        if (attributeInt == 3) {
            return 180;
        }
        if (attributeInt == 6) {
            return 90;
        }
        if (attributeInt != 8) {
            return 0;
        }
        return AntiShakeOrientationEventListener.SCREEN_ORIENTATION_LANDSCAPE;
    }

    public static Bitmap rotateBitmap(String str, int i) {
        return rotateBitmap(BitmapFactory.decodeFile(str), i);
    }

    public static boolean rotateBitmapAtPath(String str, int i, Bitmap.CompressFormat compressFormat) {
        Bitmap rotateBitmap = rotateBitmap(str, i);
        if (rotateBitmap == null) {
            return false;
        }
        try {
            return rotateBitmap.compress(compressFormat, 100, new FileOutputStream(str));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Bitmap toGrayscale(Bitmap bitmap) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    public static Bitmap toRoundCorner(Context context, Bitmap bitmap, int i, int i2, int i3, boolean z, boolean z2, boolean z3, boolean z4) {
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        float f = context.getResources().getDisplayMetrics().density;
        Paint paint = new Paint();
        RectF rectF = new RectF(new Rect(0, 0, i2, i3));
        float f2 = ((float) i) * f;
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawRoundRect(rectF, f2, f2, paint);
        if (z) {
            canvas.drawRect(0.0f, 0.0f, (float) (i2 / 2), (float) (i3 / 2), paint);
        }
        if (z2) {
            canvas.drawRect((float) (i2 / 2), 0.0f, (float) i2, (float) (i3 / 2), paint);
        }
        if (z3) {
            canvas.drawRect(0.0f, (float) (i3 / 2), (float) (i2 / 2), (float) i3, paint);
        }
        if (z4) {
            canvas.drawRect((float) (i2 / 2), (float) (i3 / 2), (float) i2, (float) i3, paint);
        }
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    public static Bitmap createThumbnail(File file, int i, int i2, boolean z) {
        BitmapFactory.Options options;
        int digreeForPicturePath;
        Bitmap bitmap = null;
        if (file == null || !file.exists()) {
            return null;
        }
        if (i <= 0 || i2 <= 0) {
            options = null;
        } else {
            options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(file.getPath(), options);
            options.inSampleSize = computeSampleSize(options, Math.min(i, i2), i * i2);
            options.inJustDecodeBounds = false;
            options.inInputShareable = true;
            options.inPurgeable = true;
        }
        try {
            bitmap = BitmapFactory.decodeFile(file.getPath(), options);
        } catch (OutOfMemoryError e) {
            Log.d("TAG", "e" + e.getLocalizedMessage());
        }
        if (bitmap == null || !z || (digreeForPicturePath = getDigreeForPicturePath(file.getAbsolutePath())) == 0) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate((float) digreeForPicturePath);
        try {
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (OutOfMemoryError unused) {
            return bitmap;
        }
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, int i) {
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate((float) i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }
}
