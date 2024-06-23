package com.taobao.power_image.request;

import android.graphics.Bitmap;
import android.view.Surface;
import com.taobao.power_image.dispatcher.PowerImageDispatcher;
import com.taobao.power_image.loader.PowerImageResult;
import io.flutter.view.TextureRegistry;
import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: Taobao */
public class PowerImageTextureRequest extends PowerImageBaseRequest {
    public static final int MAX_RESIZE_HEIGHT = 1920;
    public static final int MAX_RESIZE_WIDTH = 1920;
    private final WeakReference<TextureRegistry> d;
    private volatile boolean e = false;
    private volatile TextureRegistry.SurfaceTextureEntry f;
    private volatile Surface g;
    private volatile int h;
    private volatile int i;
    private int j;
    private int k;

    public PowerImageTextureRequest(Map<String, Object> map, TextureRegistry textureRegistry) {
        super(map);
        this.d = new WeakReference<>(textureRegistry);
    }

    @Override // com.taobao.power_image.request.PowerImageBaseRequest
    public Map<String, Object> b() {
        Map<String, Object> b = super.b();
        b.put("width", Integer.valueOf(this.j));
        b.put("height", Integer.valueOf(this.k));
        if (this.f != null) {
            b.put("textureId", Long.valueOf(this.f.id()));
        }
        return b;
    }

    /* access modifiers changed from: package-private */
    @Override // com.taobao.power_image.request.PowerImageBaseRequest
    public void d(PowerImageResult powerImageResult) {
        c("PowerImageTextureRequest:onLoadResult(PowerImageResult result) result is null");
    }

    @Override // com.taobao.power_image.request.PowerImageBaseRequest
    public boolean h() {
        this.e = true;
        this.c = "releaseSucceed";
        this.d.clear();
        PowerImageDispatcher.c().f(new Runnable() {
            /* class com.taobao.power_image.request.PowerImageTextureRequest.AnonymousClass2 */

            /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
            /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x003f */
            public void run() {
                if (PowerImageTextureRequest.this.f != null) {
                    synchronized (PowerImageTextureRequest.this.f) {
                        if (PowerImageTextureRequest.this.f != null) {
                            PowerImageTextureRequest.this.f.release();
                            PowerImageTextureRequest.this.f = null;
                        }
                        if (PowerImageTextureRequest.this.g != null) {
                            PowerImageTextureRequest.this.g.release();
                            PowerImageTextureRequest.this.g = null;
                        }
                    }
                }
            }
        }, 2000);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void q(Bitmap bitmap) {
        if (bitmap != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            double d2 = (double) width;
            double d3 = d2 / 1920.0d;
            double d4 = (double) height;
            double d5 = d4 / 1920.0d;
            if (d3 > 1.0d || d5 > 1.0d) {
                double max = Math.max(d3, d5);
                this.h = (int) (d2 / max);
                this.i = (int) (d4 / max);
                return;
            }
            this.h = width;
            this.i = height;
        }
    }
}
