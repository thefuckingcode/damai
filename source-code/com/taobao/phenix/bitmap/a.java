package com.taobao.phenix.bitmap;

import android.graphics.Bitmap;
import android.os.Build;
import com.taobao.pexode.Pexode;
import com.taobao.pexode.mimetype.MimeType;
import com.taobao.rxm.consume.Consumer;
import com.taobao.rxm.produce.BaseChainProducer;
import com.youku.alixplayer.MsgID;
import java.io.ByteArrayOutputStream;
import tb.b40;
import tb.pb2;
import tb.pd0;
import tb.qd0;
import tb.tp1;
import tb.vr2;

/* compiled from: Taobao */
public class a extends BaseChainProducer<b40, b40, com.taobao.phenix.request.a> {
    public a() {
        super(0, 2);
    }

    private byte[] H(com.taobao.phenix.request.a aVar, Bitmap bitmap, qd0 qd0) {
        MimeType g = qd0.g();
        int i = Build.VERSION.SDK_INT;
        boolean z = i == 28 && tp1.w;
        byte[] bArr = null;
        if (g != null && !z) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(MsgID.MEDIA_INFO_VIDEO_START_RECOVER);
            if (com.taobao.pexode.mimetype.a.PNG.g(g) || com.taobao.pexode.mimetype.a.PNG_A.g(g)) {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                bArr = byteArrayOutputStream.toByteArray();
            } else if (com.taobao.pexode.mimetype.a.JPEG.g(g)) {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                bArr = byteArrayOutputStream.toByteArray();
            } else if ((com.taobao.pexode.mimetype.a.WEBP.g(g) || com.taobao.pexode.mimetype.a.WEBP_A.g(g)) && Pexode.b(g)) {
                bitmap.compress(Bitmap.CompressFormat.WEBP, 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                vr2.l("BitmapProcess", qd0.i, "compress target bitmap into webp byte array", new Object[0]);
                MimeType mimeType = com.taobao.pexode.mimetype.a.WEBP_A;
                if (!mimeType.g(g) || mimeType.f(byteArray)) {
                    bArr = byteArray;
                } else {
                    vr2.y("BitmapProcess", qd0.i, "lost alpha-channel when compress bitmap[ARGB8888 WebP], API-LEVEL=%d", Integer.valueOf(i));
                }
            }
        }
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(bArr != null);
        objArr[1] = g;
        vr2.k("BitmapProcess", aVar, "compress image with bitmap, result=%B, format=%s", objArr);
        return bArr;
    }

    private Bitmap K(Bitmap bitmap, qd0 qd0) {
        int i;
        int i2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width > height) {
            i2 = qd0.n;
            i = (height * i2) / width;
        } else {
            i = qd0.o;
            i2 = (width * i) / height;
        }
        if (width > i2 || height > i) {
            try {
                vr2.l("BitmapProcess", qd0.i, "scale down from large bitmap, target(%d) < actual(%d)", Integer.valueOf(i2), Integer.valueOf(width));
                return Bitmap.createScaledBitmap(bitmap, i2, i, true);
            } catch (Throwable th) {
                vr2.y("BitmapProcess", qd0.i, "error happen when scaling bitmap, throwable=%s", th);
                return null;
            }
        } else {
            vr2.r("BitmapProcess", qd0.i, "skip to scale from large bitmap, target(%d) >= actual(%d)", Integer.valueOf(i2), Integer.valueOf(width));
            return null;
        }
    }

    /* renamed from: I */
    public void consumeNewResult(Consumer<b40, com.taobao.phenix.request.a> consumer, boolean z, b40 b40) {
        qd0 d = b40.d();
        if (!b40.f() || d.l != 4) {
            J(consumer, b40, z);
            return;
        }
        com.taobao.phenix.request.a context = consumer.getContext();
        if (z) {
            o(consumer);
        }
        vr2.n("Phenix", "BitMapProcessor Started.", context);
        Bitmap b = b40.b();
        Bitmap K = K(b, d);
        boolean z2 = false;
        if (K != null) {
            vr2.k("BitmapProcess", context, "scale bitmap, new size=%d, old size=%d", Integer.valueOf(pb2.b(K)), Integer.valueOf(pb2.b(b)));
            if (K != b) {
                b.recycle();
            }
            byte[] H = H(context, K, d);
            if (H != null && H.length > 0) {
                d.release();
                d = d.e(new pd0(H, 0, H.length), 1, true);
            }
            b40 = new b40(d, K);
        }
        if (z) {
            if (K != null) {
                z2 = true;
            }
            n(consumer, z2);
        }
        vr2.n("Phenix", "BitMapProcessor Finished.", context);
        J(consumer, b40, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0068  */
    public void J(Consumer<b40, com.taobao.phenix.request.a> consumer, b40 b40, boolean z) {
        b40 b402;
        Bitmap bitmap;
        com.taobao.phenix.request.a context = consumer.getContext();
        q(consumer, z);
        boolean z2 = true;
        if (z && b40.f()) {
            Bitmap b = b40.b();
            BitmapProcessor[] A = context.A();
            if (A == null || A.length <= 0) {
                bitmap = b;
            } else {
                bitmap = b;
                for (BitmapProcessor bitmapProcessor : A) {
                    bitmap = bitmapProcessor.process(context.N(), b.a(), bitmap);
                    if (bitmap == null) {
                        b40.release();
                        consumer.onFailure(new Throwable("processed result bitmap cannot be null!"));
                        return;
                    }
                }
                vr2.k("BitmapProcess", context, "bitmap processors call, length=%d", Integer.valueOf(A.length));
            }
            if (b != bitmap) {
                b402 = new b40(b40.d(), bitmap);
                if (b402 == b40) {
                    z2 = false;
                }
                p(consumer, z2, z);
                consumer.onNewResult(b402, z);
            }
        }
        b402 = b40;
        if (b402 == b40) {
        }
        p(consumer, z2, z);
        consumer.onNewResult(b402, z);
    }

    /* access modifiers changed from: protected */
    @Override // tb.qg
    public boolean a(Consumer<b40, com.taobao.phenix.request.a> consumer) {
        return false;
    }
}
