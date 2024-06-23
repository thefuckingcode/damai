package com.youku.android.barrage.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;

/* compiled from: Taobao */
public class OprTextureView extends TextureView implements TextureView.SurfaceTextureListener {
    private OprViewCallback mCallback = null;

    public OprTextureView(Context context) {
        super(context);
        initView();
    }

    public OprTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public OprTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    public OprTextureView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        initView();
    }

    private void initView() {
        setSurfaceTextureListener(this);
        setOpaque(false);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        OprViewCallback oprViewCallback = this.mCallback;
        if (oprViewCallback != null) {
            oprViewCallback.onSurfaceTextureAvailable(surfaceTexture, i, i2);
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        OprViewCallback oprViewCallback = this.mCallback;
        if (oprViewCallback == null) {
            return false;
        }
        oprViewCallback.onSurfaceTextureDestroyed(surfaceTexture);
        return false;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        OprViewCallback oprViewCallback = this.mCallback;
        if (oprViewCallback != null) {
            oprViewCallback.onSurfaceTextureSizeChanged(surfaceTexture, i, i2);
        }
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        OprViewCallback oprViewCallback = this.mCallback;
        if (oprViewCallback != null) {
            oprViewCallback.onSurfaceTextureUpdated(surfaceTexture);
        }
    }

    public void setupCallback(OprViewCallback oprViewCallback) {
        this.mCallback = oprViewCallback;
    }
}
