package com.taobao.pexode.decoder;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.taobao.pexode.Pexode;
import com.taobao.pexode.PexodeOptions;
import com.taobao.pexode.common.DegradeEventListener;
import com.taobao.pexode.common.NdkCore;
import com.taobao.pexode.entity.RewindableStream;
import com.taobao.pexode.exception.PexodeException;
import java.io.IOException;
import java.lang.reflect.Field;
import tb.a8;
import tb.kg0;

/* compiled from: Taobao */
public abstract class b implements Decoder {
    protected static Field sBitmapBufferField;

    protected static long getPixelAddressFromBitmap(@NonNull Bitmap bitmap) {
        long[] jArr = {0};
        try {
            NdkCore.nativePinBitmapWithAddr(bitmap, jArr);
        } catch (Throwable th) {
            kg0.c(Pexode.TAG, "get Bitmap pixels address error=%s", th);
        }
        return jArr[0];
    }

    protected static boolean invalidBitmap(Bitmap bitmap, PexodeOptions pexodeOptions, String str) {
        if (bitmap == null) {
            kg0.c(Pexode.TAG, "%s bitmap is null", str);
            return true;
        } else if (bitmap.getWidth() * bitmap.getHeight() >= pexodeOptions.outWidth * pexodeOptions.outHeight) {
            return false;
        } else {
            kg0.c(Pexode.TAG, "%s bitmap space not large enough", str);
            return true;
        }
    }

    protected static Bitmap newBitmap(PexodeOptions pexodeOptions, boolean z) {
        if (z) {
            return a8.a().newBitmap(pexodeOptions.outWidth, pexodeOptions.outHeight, PexodeOptions.CONFIG);
        }
        return Bitmap.createBitmap(pexodeOptions.outWidth, pexodeOptions.outHeight, PexodeOptions.CONFIG);
    }

    /* access modifiers changed from: protected */
    public abstract Bitmap decodeAshmem(RewindableStream rewindableStream, PexodeOptions pexodeOptions, DegradeEventListener degradeEventListener) throws PexodeException, IOException;

    /* access modifiers changed from: protected */
    public abstract Bitmap decodeInBitmap(RewindableStream rewindableStream, PexodeOptions pexodeOptions, DegradeEventListener degradeEventListener) throws PexodeException, IOException;

    /* access modifiers changed from: protected */
    public abstract Bitmap decodeNormal(RewindableStream rewindableStream, PexodeOptions pexodeOptions) throws PexodeException;

    /* access modifiers changed from: protected */
    public synchronized boolean ensureBitmapBufferField() {
        if (sBitmapBufferField == null) {
            try {
                Field declaredField = Bitmap.class.getDeclaredField("mBuffer");
                sBitmapBufferField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                kg0.c(Pexode.TAG, "ensure Bitmap buffer field error=%s", e);
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public byte[] getPixelBufferFromBitmap(Bitmap bitmap) {
        try {
            if (ensureBitmapBufferField()) {
                return (byte[]) sBitmapBufferField.get(bitmap);
            }
            return null;
        } catch (Exception e) {
            kg0.c(Pexode.TAG, "get Bitmap buffer field error=%s", e);
            return null;
        }
    }
}
