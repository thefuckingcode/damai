package com.youku.alixplayer;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import com.youku.alixplayer.instances.Aliplayer;

/* compiled from: Taobao */
public class PlayerView extends FrameLayout implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener {
    private boolean mEnableAlphaRendering;
    private IAlixPlayer mPlayer;
    private ProportionRelation mProportionRelation;
    private AttributeSet mRecordedAttributeSet;
    private int mRecordedDefStyle;
    private IRenderDevice<View> mRenderDevice;
    private Surface mSurface;
    private SurfaceHolder mSurfaceHolder;

    /* access modifiers changed from: package-private */
    /* renamed from: com.youku.alixplayer.PlayerView$3  reason: invalid class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$youku$alixplayer$PlayerView$ProportionRelation;
        static final /* synthetic */ int[] $SwitchMap$com$youku$alixplayer$PlayerView$RenderDeviceType;

        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|(2:1|2)|3|(2:5|6)|7|9|10|(2:11|12)|13|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004e */
        static {
            int[] iArr = new int[ProportionRelation.values().length];
            $SwitchMap$com$youku$alixplayer$PlayerView$ProportionRelation = iArr;
            try {
                iArr[ProportionRelation.ASPECT_RATIO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$PlayerView$ProportionRelation[ProportionRelation.FILL_SCREEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $SwitchMap$com$youku$alixplayer$PlayerView$ProportionRelation[ProportionRelation.ORIGIN.ordinal()] = 3;
            try {
                $SwitchMap$com$youku$alixplayer$PlayerView$ProportionRelation[ProportionRelation.SCALE_TO_FIT.ordinal()] = 4;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[RenderDeviceType.values().length];
            $SwitchMap$com$youku$alixplayer$PlayerView$RenderDeviceType = iArr2;
            iArr2[RenderDeviceType.SURFACE.ordinal()] = 1;
            $SwitchMap$com$youku$alixplayer$PlayerView$RenderDeviceType[RenderDeviceType.TEXTURE.ordinal()] = 2;
            try {
                $SwitchMap$com$youku$alixplayer$PlayerView$RenderDeviceType[RenderDeviceType.MOVEABLE_TEXTURE.ordinal()] = 3;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: Taobao */
    public enum ProportionRelation {
        ASPECT_RATIO,
        FILL_SCREEN,
        ORIGIN,
        SCALE_TO_FIT
    }

    /* compiled from: Taobao */
    public enum RenderDeviceType {
        SURFACE,
        TEXTURE,
        MOVEABLE_TEXTURE
    }

    /* compiled from: Taobao */
    private static class ViewRenderDevice implements IRenderDevice<View> {
        private View mView;

        public ViewRenderDevice(View view) {
            this.mView = view;
        }

        @Override // com.youku.alixplayer.IRenderDevice
        public View getRenderer() {
            return this.mView;
        }
    }

    public PlayerView(Context context) {
        this(context, null);
    }

    public PlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mEnableAlphaRendering = false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    private void resizeLayout(int i, int i2, int i3, int i4) {
        FrameLayout.LayoutParams layoutParams;
        IRenderDevice<View> iRenderDevice = this.mRenderDevice;
        if (iRenderDevice != null && iRenderDevice.getRenderer() != null) {
            FrameLayout.LayoutParams layoutParams2 = null;
            int i5 = AnonymousClass3.$SwitchMap$com$youku$alixplayer$PlayerView$ProportionRelation[this.mProportionRelation.ordinal()];
            if (i5 != 1) {
                if (i5 == 2) {
                    layoutParams2 = new FrameLayout.LayoutParams(i3, i4);
                } else if (i5 == 3) {
                    layoutParams2 = new FrameLayout.LayoutParams(i, i2, 17);
                } else if (i5 == 4) {
                    float f = ((float) i) / ((float) i2);
                    float f2 = (float) i3;
                    float f3 = (float) i4;
                    if (f > f2 / f3) {
                        layoutParams = new FrameLayout.LayoutParams((int) (f3 * f), i4, 17);
                    } else {
                        layoutParams2 = new FrameLayout.LayoutParams(i3, (int) (f2 / f), 17);
                    }
                }
                if (layoutParams2 != null) {
                    this.mRenderDevice.getRenderer().setLayoutParams(layoutParams2);
                    return;
                }
                return;
            }
            float f4 = ((float) i) / ((float) i2);
            float f5 = (float) i3;
            float f6 = (float) i4;
            if (f4 < f5 / f6) {
                layoutParams = new FrameLayout.LayoutParams((int) (f6 * f4), i4, 17);
            } else {
                layoutParams2 = new FrameLayout.LayoutParams(i3, (int) (f5 / f4), 17);
                if (layoutParams2 != null) {
                }
            }
            layoutParams2 = layoutParams;
            if (layoutParams2 != null) {
            }
        }
    }

    public IAlixPlayer getPlayer() {
        return this.mPlayer;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        IAlixPlayer iAlixPlayer;
        Surface surface = new Surface(surfaceTexture);
        this.mSurface = surface;
        if (surface.isValid() && (iAlixPlayer = this.mPlayer) != null) {
            iAlixPlayer.setDisplay(this.mSurface);
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        IAlixPlayer iAlixPlayer = this.mPlayer;
        if (iAlixPlayer != null) {
            iAlixPlayer.setDisplay(null);
        }
        Surface surface = this.mSurface;
        if (surface == null) {
            return false;
        }
        surface.release();
        this.mSurface = null;
        return false;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        IAlixPlayer iAlixPlayer;
        IAlixPlayer iAlixPlayer2 = this.mPlayer;
        if (iAlixPlayer2 != null) {
            iAlixPlayer2.setDisplay(null);
        }
        Surface surface = this.mSurface;
        if (surface != null) {
            surface.release();
            this.mSurface = null;
        }
        Surface surface2 = new Surface(surfaceTexture);
        this.mSurface = surface2;
        if (surface2.isValid() && (iAlixPlayer = this.mPlayer) != null) {
            iAlixPlayer.setDisplay(this.mSurface);
        }
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        IAlixPlayer iAlixPlayer = this.mPlayer;
        if (iAlixPlayer != null) {
            iAlixPlayer.setDisplay(null);
        }
        Surface surface = this.mSurface;
        if (surface != null) {
            surface.release();
        }
        Surface surface2 = new Surface(surfaceTexture);
        this.mSurface = surface2;
        if (this.mPlayer != null && surface2.isValid()) {
            this.mPlayer.setDisplay(this.mSurface);
        }
    }

    public void setPlayer(IAlixPlayer iAlixPlayer) {
        this.mPlayer = iAlixPlayer;
        if (iAlixPlayer != null) {
            Surface surface = this.mSurface;
            if (surface != null && surface.isValid()) {
                this.mPlayer.setDisplay(this.mSurface);
            }
            if (this.mRenderDevice != null) {
                this.mPlayer.addOnVideoSizeChangedListener(new OnVideoSizeChangedListener() {
                    /* class com.youku.alixplayer.PlayerView.AnonymousClass1 */

                    @Override // com.youku.alixplayer.OnVideoSizeChangedListener
                    public void onVideoSizeChange(final int i, final int i2) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            /* class com.youku.alixplayer.PlayerView.AnonymousClass1.AnonymousClass1 */

                            public void run() {
                                PlayerView playerView = PlayerView.this;
                                playerView.resizeLayout(i, i2, playerView.getWidth(), PlayerView.this.getHeight());
                            }
                        });
                    }
                });
            }
        }
    }

    public void setProportionRelation(ProportionRelation proportionRelation) {
        this.mProportionRelation = proportionRelation;
        requestLayout();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    public void setRenderDevice(RenderDeviceType renderDeviceType) {
        IRenderDevice<View> iRenderDevice;
        Surface surface;
        ViewRenderDevice viewRenderDevice;
        IRenderDevice<View> iRenderDevice2 = this.mRenderDevice;
        if (iRenderDevice2 != null) {
            removeView(iRenderDevice2.getRenderer());
        }
        int[] iArr = AnonymousClass3.$SwitchMap$com$youku$alixplayer$PlayerView$RenderDeviceType;
        int i = iArr[renderDeviceType.ordinal()];
        if (i != 1) {
            if (i == 2 || i == 3) {
                TextureView textureView = new TextureView(getContext());
                textureView.setOpaque(false);
                textureView.setSurfaceTextureListener(this);
                viewRenderDevice = new ViewRenderDevice(textureView);
            }
            iRenderDevice = this.mRenderDevice;
            if (iRenderDevice == null) {
                addView(iRenderDevice.getRenderer(), new FrameLayout.LayoutParams(-1, -1, 17));
                addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                    /* class com.youku.alixplayer.PlayerView.AnonymousClass2 */

                    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                        int i9 = i3 - i;
                        int i10 = i4 - i2;
                        int i11 = i7 - i5;
                        int i12 = i8 - i6;
                        PlayerView playerView = PlayerView.this;
                        if (view != playerView) {
                            return;
                        }
                        if (i9 != i11 || i10 != i12) {
                            try {
                                if (playerView.mPlayer != null && PlayerView.this.mPlayer.getPlayerQueue() != null && PlayerView.this.mPlayer.getPlayerQueue().getActiveItem() != null) {
                                    Aliplayer mainPlayer = PlayerView.this.mPlayer.getPlayerQueue().getActiveItem().getMainPlayer();
                                    PlayerView.this.resizeLayout(mainPlayer.getVideoWidth(), mainPlayer.getVideoHeight(), i9, i10);
                                }
                            } catch (NullPointerException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
                int i2 = iArr[renderDeviceType.ordinal()];
                if (i2 == 1) {
                    SurfaceHolder surfaceHolder = this.mSurfaceHolder;
                    if (surfaceHolder != null) {
                        this.mSurface = surfaceHolder.getSurface();
                    }
                } else if (i2 == 2 || i2 == 3) {
                    TextureView textureView2 = (TextureView) this.mRenderDevice.getRenderer();
                    if (textureView2.getSurfaceTexture() != null) {
                        this.mSurface = new Surface(textureView2.getSurfaceTexture());
                    }
                }
                if (this.mPlayer != null && (surface = this.mSurface) != null && surface.isValid()) {
                    this.mPlayer.setDisplay(this.mSurface);
                    return;
                }
                return;
            }
            return;
        }
        SurfaceView surfaceView = new SurfaceView(getContext());
        SurfaceHolder holder = surfaceView.getHolder();
        this.mSurfaceHolder = holder;
        holder.addCallback(this);
        surfaceView.setZOrderOnTop(true);
        this.mSurfaceHolder.setFormat(1);
        viewRenderDevice = new ViewRenderDevice(surfaceView);
        this.mRenderDevice = viewRenderDevice;
        iRenderDevice = this.mRenderDevice;
        if (iRenderDevice == null) {
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.mSurfaceHolder = surfaceHolder;
        Surface surface = surfaceHolder.getSurface();
        this.mSurface = surface;
        if (this.mPlayer != null && surface != null && surface.isValid()) {
            this.mPlayer.setDisplay(this.mSurface);
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
        Surface surface = surfaceHolder.getSurface();
        this.mSurface = surface;
        if (surface != null && surface.isValid()) {
            this.mPlayer.setDisplay(this.mSurface);
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        IAlixPlayer iAlixPlayer = this.mPlayer;
        if (iAlixPlayer != null) {
            iAlixPlayer.setDisplay(null);
        }
        if (surfaceHolder.getSurface() != null) {
            surfaceHolder.getSurface().release();
        }
        this.mSurfaceHolder = null;
        this.mSurface = null;
    }
}
