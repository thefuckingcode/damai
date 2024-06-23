package com.idlefish.flutterboost.containers;

import android.graphics.SurfaceTexture;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import com.idlefish.flutterboost.FlutterBoost;
import io.flutter.embedding.android.FlutterTextureView;
import io.flutter.embedding.engine.FlutterEngine;
import java.lang.reflect.Field;
import tb.am0;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class a {
    private SurfaceTexture a;
    private FlutterTextureView b;
    private boolean c = false;

    /* access modifiers changed from: package-private */
    /* renamed from: com.idlefish.flutterboost.containers.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public class TextureView$SurfaceTextureListenerC0179a implements TextureView.SurfaceTextureListener {
        final /* synthetic */ TextureView.SurfaceTextureListener a;
        final /* synthetic */ FlutterTextureView b;

        TextureView$SurfaceTextureListenerC0179a(TextureView.SurfaceTextureListener surfaceTextureListener, FlutterTextureView flutterTextureView) {
            this.a = surfaceTextureListener;
            this.b = flutterTextureView;
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.a.onSurfaceTextureAvailable(surfaceTexture, i, i2);
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            try {
                Class<?> cls = this.b.getClass();
                Field declaredField = cls.getDeclaredField("isSurfaceAvailableForRendering");
                declaredField.setAccessible(true);
                declaredField.set(this.b, Boolean.FALSE);
                cls.getDeclaredField("isAttachedToFlutterRenderer").setAccessible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            a.this.c = true;
            return false;
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.a.onSurfaceTextureSizeChanged(surfaceTexture, i, i2);
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            this.a.onSurfaceTextureUpdated(surfaceTexture);
            a.this.a = surfaceTexture;
        }
    }

    a() {
    }

    public void c(FlutterTextureView flutterTextureView) {
        if (Build.VERSION.SDK_INT <= 23 && flutterTextureView != null) {
            TextureView.SurfaceTextureListener surfaceTextureListener = flutterTextureView.getSurfaceTextureListener();
            this.b = flutterTextureView;
            flutterTextureView.setSurfaceTextureListener(new TextureView$SurfaceTextureListenerC0179a(surfaceTextureListener, flutterTextureView));
        }
    }

    public void d() {
        if (Build.VERSION.SDK_INT <= 23) {
            if (am0.h().e() == 1) {
                FlutterBoost.h().f().getRenderer().stopRenderingToSurface();
            }
            SurfaceTexture surfaceTexture = this.a;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.a = null;
            }
        }
    }

    public void e() {
        FlutterTextureView flutterTextureView;
        if (Build.VERSION.SDK_INT <= 23 && this.a != null && (flutterTextureView = this.b) != null && this.c) {
            try {
                Class<?> cls = flutterTextureView.getClass();
                Field declaredField = cls.getDeclaredField("isSurfaceAvailableForRendering");
                declaredField.setAccessible(true);
                declaredField.set(this.b, Boolean.TRUE);
                Field declaredField2 = cls.getDeclaredField("isAttachedToFlutterRenderer");
                declaredField2.setAccessible(true);
                if (declaredField2.getBoolean(this.b)) {
                    FlutterEngine f = FlutterBoost.h().f();
                    if (f != null) {
                        f.getRenderer().startRenderingToSurface(new Surface(this.a));
                        this.b.setSurfaceTexture(this.a);
                    }
                    this.a = null;
                    this.c = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
