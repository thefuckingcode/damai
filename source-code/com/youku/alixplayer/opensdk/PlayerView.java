package com.youku.alixplayer.opensdk;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.youku.alixplayer.OnVideoSizeChangedListener;
import com.youku.alixplayer.opensdk.resize.IResizer;
import com.youku.alixplayer.opensdk.resize.OnResizerListener;
import com.youku.alixplayer.opensdk.utils.TLogUtil;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
public class PlayerView extends FrameLayout implements OnVideoSizeChangedListener, IResizer {
    public static final int PLAYER_VIEW_TYPE_SURFACE_VIEW = 0;
    public static final int PLAYER_VIEW_TYPE_TEXTURE_VIEW = 1;
    private IPlayer mAlixPlayer;
    private List<OnResizerListener> mOnResizerListeners = new CopyOnWriteArrayList();
    private float mParentAspectRatio;
    private int mParentHeight;
    private int mParentWidth;
    private int mPlayerViewType;
    private Surface mSurface;
    private SurfaceHolder.Callback mSurfaceCallback = new SurfaceHolder.Callback() {
        /* class com.youku.alixplayer.opensdk.PlayerView.AnonymousClass2 */

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            PlayerView.this.mSurface = surfaceHolder.getSurface();
            if (PlayerView.this.mAlixPlayer != null) {
                TLogUtil.playLog("setDisplay player=" + PlayerView.this.mAlixPlayer.hashCode() + " surface=" + PlayerView.this.mSurface);
                PlayerView.this.mAlixPlayer.setDisplay(PlayerView.this.mSurface);
            }
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (PlayerView.this.mSurface != null) {
                PlayerView.this.mSurface.release();
            }
        }
    };
    private TextureView.SurfaceTextureListener mSurfaceTextureListener = new TextureView.SurfaceTextureListener() {
        /* class com.youku.alixplayer.opensdk.PlayerView.AnonymousClass3 */

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            Log.i("lwj", "surface texturae available " + PlayerView.this.mAlixPlayer);
            PlayerView.this.mSurface = new Surface(surfaceTexture);
            if (PlayerView.this.mAlixPlayer != null) {
                PlayerView.this.mAlixPlayer.setDisplay(PlayerView.this.mSurface);
            }
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            if (PlayerView.this.mSurface != null) {
                PlayerView.this.mSurface.release();
            }
            PlayerView.this.mSurface = null;
            return false;
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    };
    private float mTargetAspectRatio;
    private int mVideCurMode;
    private View mVideoView;

    public PlayerView(@NonNull Context context, IPlayer iPlayer, PlayerConfig playerConfig) {
        super(context);
        this.mAlixPlayer = iPlayer;
        iPlayer.addOnVideoSizeChangedListener(this);
        int playerViewType = playerConfig.getPlayerViewType();
        this.mPlayerViewType = playerViewType;
        if (playerViewType == 0) {
            SurfaceView surfaceView = new SurfaceView(getContext());
            surfaceView.getHolder().addCallback(this.mSurfaceCallback);
            this.mVideoView = surfaceView;
        } else if (playerViewType != 1) {
            this.mVideoView = new SurfaceView(getContext());
        } else {
            TextureView textureView = new TextureView(getContext());
            SurfaceTexture surfaceTexture = textureView.getSurfaceTexture();
            if (surfaceTexture != null) {
                Surface surface = new Surface(surfaceTexture);
                this.mSurface = surface;
                IPlayer iPlayer2 = this.mAlixPlayer;
                if (iPlayer2 != null) {
                    iPlayer2.setDisplay(surface);
                }
            }
            textureView.setSurfaceTextureListener(this.mSurfaceTextureListener);
            this.mVideoView = textureView;
        }
        this.mVideoView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            /* class com.youku.alixplayer.opensdk.PlayerView.AnonymousClass1 */
            private int mHeight;
            private int mWidth;

            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                if (PlayerView.this.mOnResizerListeners.size() > 0) {
                    int width = view.getWidth();
                    int height = view.getHeight();
                    if (!(width == 0 || height == 0)) {
                        if (!(width == this.mWidth && height == this.mHeight)) {
                            this.mWidth = width;
                            this.mHeight = height;
                            if (PlayerView.this.mVideoView.getAlpha() < 1.0f) {
                                PlayerView.this.mVideoView.setAlpha(1.0f);
                            }
                            if (PlayerView.this.mAlixPlayer != null && (PlayerView.this.mAlixPlayer instanceof AlixPlayerWrapper)) {
                                ((AlixPlayerWrapper) PlayerView.this.mAlixPlayer).changeVideoSize(this.mWidth, this.mHeight);
                            }
                            for (OnResizerListener onResizerListener : PlayerView.this.mOnResizerListeners) {
                                onResizerListener.onSizeChanged(width, height);
                            }
                        }
                    }
                }
            }
        });
        addView(this.mVideoView);
        setBackgroundColor(0);
    }

    private void resizeOnUiThread() {
        post(new Runnable() {
            /* class com.youku.alixplayer.opensdk.PlayerView.AnonymousClass4 */

            public void run() {
                PlayerView.this.resize();
            }
        });
    }

    private void setAspectRatio(float f) {
        if (this.mTargetAspectRatio != f) {
            this.mTargetAspectRatio = f;
            resizeOnUiThread();
        }
    }

    @Override // com.youku.alixplayer.opensdk.resize.IResizer
    public void addOnResizerListener(OnResizerListener onResizerListener) {
        this.mOnResizerListeners.add(onResizerListener);
    }

    public void addView(View view) {
        super.addView(view, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    public float getParentAspectRatio() {
        return this.mParentAspectRatio;
    }

    public int getParentHeight() {
        return this.mParentHeight;
    }

    public int getParentWidth() {
        return this.mParentWidth;
    }

    public float getTargetAspectRatio() {
        return this.mTargetAspectRatio;
    }

    public View getVideoView() {
        return this.mVideoView;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (size != 0 && size2 != 0) {
            float f = (float) size;
            float f2 = (float) size2;
            this.mParentAspectRatio = (1.0f * f) / f2;
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                this.mParentWidth = viewGroup.getWidth();
                this.mParentHeight = viewGroup.getHeight();
            }
            if (!onVideoViewResize(size, size2, this.mVideCurMode)) {
                float f3 = this.mTargetAspectRatio;
                if (f3 != 0.0f) {
                    int i3 = this.mVideCurMode;
                    if (i3 == 0) {
                        if (this.mParentAspectRatio > f3) {
                            size = Math.round(f2 * f3);
                        } else {
                            size2 = Math.round(f / f3);
                        }
                        if (size % 2 == 1) {
                            size--;
                        }
                        if (size2 % 2 == 1) {
                            size2--;
                        }
                    } else if (i3 == 2) {
                        size2 = (int) (f / f3);
                    } else if (i3 == 3) {
                        size = Math.round(f2 * f3);
                    } else if (i3 == 4) {
                        if (this.mParentAspectRatio > f3) {
                            size2 = Math.round(f / f3);
                        } else {
                            size = Math.round(f2 * f3);
                        }
                    }
                }
                this.mVideoView.getLayoutParams().width = size;
                this.mVideoView.getLayoutParams().height = size2;
                this.mVideoView.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
            }
        }
    }

    @Override // com.youku.alixplayer.OnVideoSizeChangedListener
    public void onVideoSizeChange(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            TLogUtil.playLog("内核返回视频尺寸异常 width=" + i + " height=" + i2);
            return;
        }
        setAspectRatio((((float) i) * 1.0f) / ((float) i2));
    }

    /* access modifiers changed from: protected */
    public boolean onVideoViewResize(int i, int i2, int i3) {
        return false;
    }

    public void resize() {
        requestLayout();
    }

    @Override // com.youku.alixplayer.opensdk.resize.IResizer
    public void setVideoCutMode(int i) {
        this.mVideCurMode = i;
        resizeOnUiThread();
    }
}
