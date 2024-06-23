package com.alibaba.youku.webp4pexode;

import android.content.Context;
import android.graphics.Bitmap;
import com.taobao.pexode.Pexode;
import com.taobao.pexode.PexodeOptions;
import com.taobao.pexode.common.DegradeEventListener;
import com.taobao.pexode.decoder.Decoder;
import com.taobao.pexode.entity.RewindableStream;
import com.taobao.pexode.exception.PexodeException;
import com.taobao.pexode.mimetype.MimeType;
import com.taobao.pexode.mimetype.a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import tb.a8;
import tb.kg0;
import tb.np1;

/* compiled from: Taobao */
public class WebpDecoder implements Decoder {
    private static final int LIBRARY_JNI_VERSION = 1;
    public static final String LIBRARY_NAME = "pwebp-v7a";
    private static boolean sIsSoInstalled = true;

    static {
        a.ALL_EXTENSION_TYPES.add(WebpMimeType.WEBPD);
        String libraryName = getLibraryName();
        try {
            System.loadLibrary(libraryName);
            kg0.f(Pexode.TAG, "system load lib%s.so result = %b", libraryName, Boolean.valueOf(sIsSoInstalled));
        } catch (UnsatisfiedLinkError e) {
            kg0.c(Pexode.TAG, "system load lib%s.so error = %s", libraryName, e);
        }
    }

    private byte[] IS2Bytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    private static String getLibraryName() {
        return LIBRARY_NAME;
    }

    @Override // com.taobao.pexode.decoder.Decoder
    public boolean acceptInputType(int i, MimeType mimeType, boolean z) {
        return true;
    }

    @Override // com.taobao.pexode.decoder.Decoder
    public boolean canDecodeIncrementally(MimeType mimeType) {
        return false;
    }

    @Override // com.taobao.pexode.decoder.Decoder
    public np1 decode(RewindableStream rewindableStream, PexodeOptions pexodeOptions, DegradeEventListener degradeEventListener) throws PexodeException, IOException {
        WebpImage webpImage;
        Decoder decoder;
        boolean z = true;
        Bitmap bitmap = null;
        if (pexodeOptions.justDecodeBounds) {
            pexodeOptions.outHeight = 1;
            pexodeOptions.outWidth = 1;
            return null;
        } else if (pexodeOptions.forceStaticIfAnimation) {
            List<Decoder> g = Pexode.g(a.WEBP);
            if (g == null || g.size() <= 0 || (decoder = g.get(0)) == null) {
                return null;
            }
            return decoder.decode(rewindableStream, pexodeOptions, degradeEventListener);
        } else {
            if (rewindableStream.getInputType() != 1) {
                byte[] IS2Bytes = IS2Bytes(rewindableStream);
                com.taobao.pexode.entity.a aVar = new com.taobao.pexode.entity.a(IS2Bytes, 0, IS2Bytes.length);
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(aVar.getBuffer().length);
                allocateDirect.put(aVar.getBuffer());
                allocateDirect.rewind();
                webpImage = WebpImage.nativeCreateFromDirectByteBuffer(allocateDirect);
            } else {
                ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(rewindableStream.getBuffer().length);
                allocateDirect2.put(rewindableStream.getBuffer());
                allocateDirect2.rewind();
                webpImage = WebpImage.nativeCreateFromDirectByteBuffer(allocateDirect2);
            }
            if (!pexodeOptions.forceStaticIfAnimation || webpImage == null) {
                return np1.b(webpImage);
            }
            WebpFrame frame = webpImage.getFrame(0);
            if (frame == null) {
                frame.dispose();
                return null;
            }
            int width = frame.getWidth();
            int height = frame.getHeight();
            if (!pexodeOptions.enableAshmem || com.taobao.pexode.a.f().b) {
                z = false;
            }
            if (z) {
                bitmap = a8.a().newBitmapWithPin(width, height, Bitmap.Config.ARGB_8888);
            }
            if (!z || (bitmap == null && pexodeOptions.allowDegrade2NoAshmem)) {
                bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            }
            if (bitmap != null) {
                frame.renderFrame(width, height, bitmap);
            }
            frame.dispose();
            webpImage.dispose();
            return np1.a(bitmap);
        }
    }

    @Override // com.taobao.pexode.decoder.Decoder
    public MimeType detectMimeType(byte[] bArr) {
        if (!sIsSoInstalled) {
            return null;
        }
        MimeType mimeType = WebpMimeType.WEBPD;
        if (mimeType.f(bArr)) {
            return mimeType;
        }
        return null;
    }

    @Override // com.taobao.pexode.decoder.Decoder
    public boolean isSupported(MimeType mimeType) {
        return WebpMimeType.WEBPD.g(mimeType);
    }

    @Override // com.taobao.pexode.decoder.Decoder
    public void prepare(Context context) {
        if (!sIsSoInstalled) {
            kg0.f(Pexode.TAG, "retry load lib%s.so result=%b", getLibraryName(), Boolean.valueOf(sIsSoInstalled));
        }
    }
}
