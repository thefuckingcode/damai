package com.youku.playerservice.axp.resize;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.youku.opengl.widget.l;
import com.youku.playerservice.axp.axpinterface.IPlayerService;
import com.youku.playerservice.axp.utils.TLogUtil;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
public class ResizeView extends FrameLayout implements IResizer {
    public static final String TAG = "ResizeView";
    private List<OnResizerListener> mOnResizerListeners = new CopyOnWriteArrayList();
    private float mParentAspectRatio;
    private int mParentHeight;
    private int mParentWidth;
    private int mPlayerIndex;
    private IPlayerService mPlayerService;
    private Surface mSurface;
    private SurfaceHolder.Callback mSurfaceCallback = new SurfaceHolder.Callback() {
        /* class com.youku.playerservice.axp.resize.ResizeView.AnonymousClass2 */

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            ResizeView.this.mSurface = surfaceHolder.getSurface();
            if (ResizeView.this.mPlayerService != null) {
                TLogUtil.playLog("setDisplay player=" + ResizeView.this.mPlayerService.hashCode() + " surface=" + ResizeView.this.mSurface);
                ResizeView.this.mPlayerService.setDisplay(ResizeView.this.mSurface);
            }
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (ResizeView.this.mSurface != null) {
                ResizeView.this.mSurface.release();
            }
        }
    };
    private TextureView.SurfaceTextureListener mSurfaceTextureListener = new TextureView.SurfaceTextureListener() {
        /* class com.youku.playerservice.axp.resize.ResizeView.AnonymousClass3 */

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            Log.i("lwj", "surface texturae available " + ResizeView.this.mPlayerService);
            ResizeView.this.mSurface = new Surface(surfaceTexture);
            if (ResizeView.this.mPlayerService != null) {
                ResizeView.this.mPlayerService.setDisplay(ResizeView.this.mSurface);
            }
            if (ResizeView.this.mVideoTextureListener != null) {
                ResizeView.this.mVideoTextureListener.onSurfaceTextureAvailable(surfaceTexture, i, i2);
            }
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            if (ResizeView.this.mSurface != null) {
                ResizeView.this.mSurface.release();
            }
            if (ResizeView.this.mVideoTextureListener != null) {
                ResizeView.this.mVideoTextureListener.onSurfaceTextureDestroyed(surfaceTexture);
            }
            ResizeView.this.mSurface = null;
            return false;
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            if (ResizeView.this.mVideoTextureListener != null) {
                ResizeView.this.mVideoTextureListener.onSurfaceTextureSizeChanged(surfaceTexture, i, i2);
            }
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            if (ResizeView.this.mVideoTextureListener != null) {
                ResizeView.this.mVideoTextureListener.onSurfaceTextureUpdated(surfaceTexture);
            }
        }
    };
    private float mTargetAspectRatio;
    private int mVideoCurMode = 0;
    private TextureView.SurfaceTextureListener mVideoTextureListener;
    private View mVideoView;

    public ResizeView(@NonNull Context context) {
        super(context);
    }

    public ResizeView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void resizeOnUiThread() {
        post(new Runnable() {
            /* class com.youku.playerservice.axp.resize.ResizeView.AnonymousClass4 */

            public void run() {
                ResizeView.this.resize();
            }
        });
    }

    private void setAspectRatio(float f) {
        if (this.mTargetAspectRatio != f) {
            this.mTargetAspectRatio = f;
            resizeOnUiThread();
        }
    }

    @Override // com.youku.playerservice.axp.resize.IResizer
    public void addOnResizerListener(OnResizerListener onResizerListener) {
        this.mOnResizerListeners.add(onResizerListener);
    }

    public void addView(View view) {
        super.addView(view, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    public View getVideoView() {
        return this.mVideoView;
    }

    public void init(@NonNull IPlayerService iPlayerService, int i, @NonNull View view) {
        this.mPlayerService = iPlayerService;
        this.mPlayerIndex = i;
        this.mVideoView = view;
        if (view instanceof l) {
            ((l) view).setSurfaceTextureListener(this.mSurfaceTextureListener);
        } else if (view instanceof SurfaceView) {
            ((SurfaceView) view).getHolder().addCallback(this.mSurfaceCallback);
        } else if (view instanceof TextureView) {
            TextureView textureView = (TextureView) view;
            textureView.setSurfaceTextureListener(this.mSurfaceTextureListener);
            SurfaceTexture surfaceTexture = textureView.getSurfaceTexture();
            if (surfaceTexture != null) {
                Surface surface = new Surface(surfaceTexture);
                this.mSurface = surface;
                IPlayerService iPlayerService2 = this.mPlayerService;
                if (iPlayerService2 != null) {
                    iPlayerService2.setDisplay(surface);
                }
            }
        }
        this.mVideoView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            /* class com.youku.playerservice.axp.resize.ResizeView.AnonymousClass1 */
            private int mHeight;
            private int mWidth;

            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                int width = view.getWidth();
                int height = view.getHeight();
                if (!(width == 0 || height == 0)) {
                    if (!(width == this.mWidth && height == this.mHeight)) {
                        this.mWidth = width;
                        this.mHeight = height;
                        if (ResizeView.this.mPlayerService != null) {
                            ResizeView.this.mPlayerService.changeVideoSize(this.mWidth, this.mHeight);
                        }
                        if (ResizeView.this.mOnResizerListeners.size() > 0) {
                            for (OnResizerListener onResizerListener : ResizeView.this.mOnResizerListeners) {
                                onResizerListener.onSizeChanged(width, height);
                            }
                        }
                    }
                }
            }
        });
        removeAllViews();
        addView(this.mVideoView);
        setBackgroundColor(0);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int width = getWidth();
        int height = getHeight();
        if (z && width > 0 && height > 0) {
            this.mParentWidth = width;
            this.mParentHeight = height;
            this.mParentAspectRatio = (((float) width) * 1.0f) / ((float) height);
            TLogUtil.loge(TAG, "onLayout width=" + width + " height=" + height + " PlayerView" + hashCode());
            resize();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void refreshVideoSize(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            TLogUtil.loge(TAG, "内核返回视频尺寸异常 width=" + i + " height=" + i2);
            return;
        }
        setAspectRatio((((float) i) * 1.0f) / ((float) i2));
    }

    public void resize() {
        int i;
        int i2 = this.mParentWidth;
        if (i2 != 0 && (i = this.mParentHeight) != 0) {
            float f = this.mTargetAspectRatio;
            if (f != 0.0f) {
                float f2 = this.mParentAspectRatio;
                if (f2 != 0.0f) {
                    int i3 = this.mVideoCurMode;
                    if (i3 != 0) {
                        if (i3 == 1) {
                            if (f2 > f) {
                                i = (int) (((float) i2) / f);
                            } else {
                                i2 = (int) (((float) i) * f);
                            }
                        }
                    } else if (f2 > f) {
                        i2 = Math.round(((float) i) * f);
                    } else {
                        i = Math.round(((float) i2) / f);
                    }
                    if (i2 % 2 == 1) {
                        i2--;
                    }
                    if (i % 2 == 1) {
                        i--;
                    }
                    TLogUtil.loge(TAG, "resize width=" + this.mParentWidth + " height=" + this.mParentHeight + " resizeWidth=" + i2 + " resizeHeight=" + i + " PlayerView" + hashCode());
                    this.mVideoView.getLayoutParams().width = i2;
                    this.mVideoView.getLayoutParams().height = i;
                    this.mVideoView.requestLayout();
                }
            }
        }
    }

    @Override // com.youku.playerservice.axp.resize.IResizer
    public void setVideoCutMode(int i) {
        this.mVideoCurMode = i;
        resizeOnUiThread();
    }

    public void setVideoTextureListener(TextureView.SurfaceTextureListener surfaceTextureListener) {
        this.mVideoTextureListener = surfaceTextureListener;
    }

    public void setVideoView(@NonNull IPlayerService iPlayerService, @NonNull View view) {
        init(iPlayerService, 0, view);
    }
}
