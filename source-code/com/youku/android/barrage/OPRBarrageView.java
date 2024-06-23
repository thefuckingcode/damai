package com.youku.android.barrage;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.Keep;
import com.youku.alixplayer.config.FeatureManager;
import com.youku.android.barrage.utils.OPRBitmapUtils;
import com.youku.android.barrage.view.OprSurfaceView;
import com.youku.android.barrage.view.OprViewCallback;
import com.youku.android.statistics.barrage.OprBarrageField;
import com.youku.android.statistics.barrage.OprBarrageVPM;
import com.youku.android.utils.CalculateUtils;
import com.youku.android.utils.OprLogUtils;
import com.youku.android.utils.SystemProperties;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Keep
/* compiled from: Taobao */
public class OPRBarrageView extends OprSurfaceView {
    private static final String TAG = (OprLogUtils.LOG_PREFIX + OPRBarrageView.class.getSimpleName());
    private static final String TLOG_TAG = OPRBarrageView.class.getSimpleName();
    private OprViewCallback callback;
    private volatile int mAbnormalCount = 0;
    private List<Long> mAbnormalFpsList = new ArrayList();
    private Context mContext = null;
    private volatile int mDanmakuCount = 0;
    private List<Long> mFpsList = new ArrayList();
    private INotifyListener mListener;
    private long mNativeContext = 0;
    private int mRetryCount = 1;
    private volatile long mStartTime = SystemClock.elapsedRealtime();
    private int mSubmitCount = 0;
    private String mVid = "";

    /* compiled from: Taobao */
    public enum OPRLayerPriority {
        OPRLayer_0(0),
        OPRLayer_1(1),
        OPRLayer_2(2),
        OPRLayer_3(3),
        OPRLayer_4(4);

        private OPRLayerPriority(int i) {
        }
    }

    static {
        System.loadLibrary(FeatureManager.FEATURE_KEY_OPR);
    }

    public OPRBarrageView(Context context) {
        super(context);
        AnonymousClass1 r0 = new OprViewCallback() {
            /* class com.youku.android.barrage.OPRBarrageView.AnonymousClass1 */

            @Override // com.youku.android.barrage.view.OprViewCallback
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                Surface surface = new Surface(surfaceTexture);
                int nativeInit = OPRBarrageView.this.nativeInit(new WeakReference(OPRBarrageView.this), surface);
                String str = OPRBarrageView.TAG;
                Log.d(str, "nativeInit ret: " + nativeInit);
                if (nativeInit != 0 && OPRBarrageView.access$206(OPRBarrageView.this) >= 0) {
                    OPRBarrageView.this.submitOprDanmakuAbnormal((double) nativeInit, 0.0d);
                    OPRBarrageView.this.nativeReleaseBarrage();
                    OPRBarrageView.this.setVisibility(8);
                    OPRBarrageView.this.setVisibility(0);
                }
                if (OPRBarrageView.this.mListener != null) {
                    OPRBarrageView.this.mListener.onSurfaceCreated(null);
                }
                if (OPRBarrageView.this.mListener != null) {
                    OPRBarrageView.this.mListener.onSurfaceChanged(null, 0, i, i2);
                }
                OPRBarrageView.this.setViewSize(i, i2);
            }

            @Override // com.youku.android.barrage.view.OprViewCallback
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (OPRBarrageView.this.mListener == null) {
                    return false;
                }
                OPRBarrageView.this.mListener.onSurfaceDestroyed(null);
                return false;
            }

            @Override // com.youku.android.barrage.view.OprViewCallback
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                if (OPRBarrageView.this.mListener != null) {
                    OPRBarrageView.this.mListener.onSurfaceChanged(null, 0, i, i2);
                }
                OPRBarrageView.this.setViewSize(i, i2);
            }

            @Override // com.youku.android.barrage.view.OprViewCallback
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            @Override // com.youku.android.barrage.view.OprViewCallback
            public void surfaceChanged(final SurfaceHolder surfaceHolder, final int i, final int i2, final int i3) {
                String propString = SystemProperties.getPropString(OPRBarrageView.this.mContext, "ro.product.model");
                String str = OPRBarrageView.TLOG_TAG;
                OprLogUtils.TLogPrint(str, "deviceModel: " + propString);
                if (TextUtils.isEmpty(propString) || ((!propString.toLowerCase().startsWith("oppo") && !propString.toLowerCase().startsWith("vivo") && !propString.toLowerCase().startsWith("redmi")) || OPRBarrageView.this.mContext == null)) {
                    OPRBarrageView.this.setViewSize(i2, i3);
                    if (OPRBarrageView.this.mListener != null) {
                        OPRBarrageView.this.mListener.onSurfaceChanged(surfaceHolder, i, i2, i3);
                        return;
                    }
                    return;
                }
                new Handler(OPRBarrageView.this.mContext.getMainLooper()).postDelayed(new Runnable() {
                    /* class com.youku.android.barrage.OPRBarrageView.AnonymousClass1.AnonymousClass1 */

                    public void run() {
                        OPRBarrageView.this.setViewSize(i2, i3);
                        if (OPRBarrageView.this.mListener != null) {
                            OPRBarrageView.this.mListener.onSurfaceChanged(surfaceHolder, i, i2, i3);
                        }
                    }
                }, 500);
            }

            @Override // com.youku.android.barrage.view.OprViewCallback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                Surface surface = surfaceHolder.getSurface();
                int nativeInit = OPRBarrageView.this.nativeInit(new WeakReference(OPRBarrageView.this), surface);
                String str = OPRBarrageView.TAG;
                Log.d(str, "nativeInit ret: " + nativeInit);
                if (nativeInit != 0 && OPRBarrageView.access$210(OPRBarrageView.this) >= 0) {
                    OPRBarrageView.this.submitOprDanmakuAbnormal((double) nativeInit, 0.0d);
                    OPRBarrageView.this.nativeReleaseBarrage();
                    OPRBarrageView.this.setVisibility(8);
                    OPRBarrageView.this.setVisibility(0);
                }
                if (OPRBarrageView.this.mListener != null) {
                    OPRBarrageView.this.mListener.onSurfaceCreated(surfaceHolder);
                }
                OPRBarrageView.this.mDanmakuCount = 0;
                OPRBarrageView.this.mAbnormalCount = 0;
                OPRBarrageView.this.mStartTime = SystemClock.elapsedRealtime();
                OPRBarrageView.this.mFpsList.clear();
                OPRBarrageView.this.mAbnormalFpsList.clear();
            }

            @Override // com.youku.android.barrage.view.OprViewCallback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                if (OPRBarrageView.this.mListener != null) {
                    OPRBarrageView.this.mListener.onSurfaceDestroyed(surfaceHolder);
                }
            }
        };
        this.callback = r0;
        this.mContext = context;
        setupCallback(r0);
    }

    public OPRBarrageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AnonymousClass1 r4 = new OprViewCallback() {
            /* class com.youku.android.barrage.OPRBarrageView.AnonymousClass1 */

            @Override // com.youku.android.barrage.view.OprViewCallback
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                Surface surface = new Surface(surfaceTexture);
                int nativeInit = OPRBarrageView.this.nativeInit(new WeakReference(OPRBarrageView.this), surface);
                String str = OPRBarrageView.TAG;
                Log.d(str, "nativeInit ret: " + nativeInit);
                if (nativeInit != 0 && OPRBarrageView.access$206(OPRBarrageView.this) >= 0) {
                    OPRBarrageView.this.submitOprDanmakuAbnormal((double) nativeInit, 0.0d);
                    OPRBarrageView.this.nativeReleaseBarrage();
                    OPRBarrageView.this.setVisibility(8);
                    OPRBarrageView.this.setVisibility(0);
                }
                if (OPRBarrageView.this.mListener != null) {
                    OPRBarrageView.this.mListener.onSurfaceCreated(null);
                }
                if (OPRBarrageView.this.mListener != null) {
                    OPRBarrageView.this.mListener.onSurfaceChanged(null, 0, i, i2);
                }
                OPRBarrageView.this.setViewSize(i, i2);
            }

            @Override // com.youku.android.barrage.view.OprViewCallback
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (OPRBarrageView.this.mListener == null) {
                    return false;
                }
                OPRBarrageView.this.mListener.onSurfaceDestroyed(null);
                return false;
            }

            @Override // com.youku.android.barrage.view.OprViewCallback
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                if (OPRBarrageView.this.mListener != null) {
                    OPRBarrageView.this.mListener.onSurfaceChanged(null, 0, i, i2);
                }
                OPRBarrageView.this.setViewSize(i, i2);
            }

            @Override // com.youku.android.barrage.view.OprViewCallback
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            @Override // com.youku.android.barrage.view.OprViewCallback
            public void surfaceChanged(final SurfaceHolder surfaceHolder, final int i, final int i2, final int i3) {
                String propString = SystemProperties.getPropString(OPRBarrageView.this.mContext, "ro.product.model");
                String str = OPRBarrageView.TLOG_TAG;
                OprLogUtils.TLogPrint(str, "deviceModel: " + propString);
                if (TextUtils.isEmpty(propString) || ((!propString.toLowerCase().startsWith("oppo") && !propString.toLowerCase().startsWith("vivo") && !propString.toLowerCase().startsWith("redmi")) || OPRBarrageView.this.mContext == null)) {
                    OPRBarrageView.this.setViewSize(i2, i3);
                    if (OPRBarrageView.this.mListener != null) {
                        OPRBarrageView.this.mListener.onSurfaceChanged(surfaceHolder, i, i2, i3);
                        return;
                    }
                    return;
                }
                new Handler(OPRBarrageView.this.mContext.getMainLooper()).postDelayed(new Runnable() {
                    /* class com.youku.android.barrage.OPRBarrageView.AnonymousClass1.AnonymousClass1 */

                    public void run() {
                        OPRBarrageView.this.setViewSize(i2, i3);
                        if (OPRBarrageView.this.mListener != null) {
                            OPRBarrageView.this.mListener.onSurfaceChanged(surfaceHolder, i, i2, i3);
                        }
                    }
                }, 500);
            }

            @Override // com.youku.android.barrage.view.OprViewCallback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                Surface surface = surfaceHolder.getSurface();
                int nativeInit = OPRBarrageView.this.nativeInit(new WeakReference(OPRBarrageView.this), surface);
                String str = OPRBarrageView.TAG;
                Log.d(str, "nativeInit ret: " + nativeInit);
                if (nativeInit != 0 && OPRBarrageView.access$210(OPRBarrageView.this) >= 0) {
                    OPRBarrageView.this.submitOprDanmakuAbnormal((double) nativeInit, 0.0d);
                    OPRBarrageView.this.nativeReleaseBarrage();
                    OPRBarrageView.this.setVisibility(8);
                    OPRBarrageView.this.setVisibility(0);
                }
                if (OPRBarrageView.this.mListener != null) {
                    OPRBarrageView.this.mListener.onSurfaceCreated(surfaceHolder);
                }
                OPRBarrageView.this.mDanmakuCount = 0;
                OPRBarrageView.this.mAbnormalCount = 0;
                OPRBarrageView.this.mStartTime = SystemClock.elapsedRealtime();
                OPRBarrageView.this.mFpsList.clear();
                OPRBarrageView.this.mAbnormalFpsList.clear();
            }

            @Override // com.youku.android.barrage.view.OprViewCallback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                if (OPRBarrageView.this.mListener != null) {
                    OPRBarrageView.this.mListener.onSurfaceDestroyed(surfaceHolder);
                }
            }
        };
        this.callback = r4;
        this.mContext = context;
        setupCallback(r4);
    }

    public OPRBarrageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AnonymousClass1 r4 = new OprViewCallback() {
            /* class com.youku.android.barrage.OPRBarrageView.AnonymousClass1 */

            @Override // com.youku.android.barrage.view.OprViewCallback
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                Surface surface = new Surface(surfaceTexture);
                int nativeInit = OPRBarrageView.this.nativeInit(new WeakReference(OPRBarrageView.this), surface);
                String str = OPRBarrageView.TAG;
                Log.d(str, "nativeInit ret: " + nativeInit);
                if (nativeInit != 0 && OPRBarrageView.access$206(OPRBarrageView.this) >= 0) {
                    OPRBarrageView.this.submitOprDanmakuAbnormal((double) nativeInit, 0.0d);
                    OPRBarrageView.this.nativeReleaseBarrage();
                    OPRBarrageView.this.setVisibility(8);
                    OPRBarrageView.this.setVisibility(0);
                }
                if (OPRBarrageView.this.mListener != null) {
                    OPRBarrageView.this.mListener.onSurfaceCreated(null);
                }
                if (OPRBarrageView.this.mListener != null) {
                    OPRBarrageView.this.mListener.onSurfaceChanged(null, 0, i, i2);
                }
                OPRBarrageView.this.setViewSize(i, i2);
            }

            @Override // com.youku.android.barrage.view.OprViewCallback
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (OPRBarrageView.this.mListener == null) {
                    return false;
                }
                OPRBarrageView.this.mListener.onSurfaceDestroyed(null);
                return false;
            }

            @Override // com.youku.android.barrage.view.OprViewCallback
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                if (OPRBarrageView.this.mListener != null) {
                    OPRBarrageView.this.mListener.onSurfaceChanged(null, 0, i, i2);
                }
                OPRBarrageView.this.setViewSize(i, i2);
            }

            @Override // com.youku.android.barrage.view.OprViewCallback
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            @Override // com.youku.android.barrage.view.OprViewCallback
            public void surfaceChanged(final SurfaceHolder surfaceHolder, final int i, final int i2, final int i3) {
                String propString = SystemProperties.getPropString(OPRBarrageView.this.mContext, "ro.product.model");
                String str = OPRBarrageView.TLOG_TAG;
                OprLogUtils.TLogPrint(str, "deviceModel: " + propString);
                if (TextUtils.isEmpty(propString) || ((!propString.toLowerCase().startsWith("oppo") && !propString.toLowerCase().startsWith("vivo") && !propString.toLowerCase().startsWith("redmi")) || OPRBarrageView.this.mContext == null)) {
                    OPRBarrageView.this.setViewSize(i2, i3);
                    if (OPRBarrageView.this.mListener != null) {
                        OPRBarrageView.this.mListener.onSurfaceChanged(surfaceHolder, i, i2, i3);
                        return;
                    }
                    return;
                }
                new Handler(OPRBarrageView.this.mContext.getMainLooper()).postDelayed(new Runnable() {
                    /* class com.youku.android.barrage.OPRBarrageView.AnonymousClass1.AnonymousClass1 */

                    public void run() {
                        OPRBarrageView.this.setViewSize(i2, i3);
                        if (OPRBarrageView.this.mListener != null) {
                            OPRBarrageView.this.mListener.onSurfaceChanged(surfaceHolder, i, i2, i3);
                        }
                    }
                }, 500);
            }

            @Override // com.youku.android.barrage.view.OprViewCallback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                Surface surface = surfaceHolder.getSurface();
                int nativeInit = OPRBarrageView.this.nativeInit(new WeakReference(OPRBarrageView.this), surface);
                String str = OPRBarrageView.TAG;
                Log.d(str, "nativeInit ret: " + nativeInit);
                if (nativeInit != 0 && OPRBarrageView.access$210(OPRBarrageView.this) >= 0) {
                    OPRBarrageView.this.submitOprDanmakuAbnormal((double) nativeInit, 0.0d);
                    OPRBarrageView.this.nativeReleaseBarrage();
                    OPRBarrageView.this.setVisibility(8);
                    OPRBarrageView.this.setVisibility(0);
                }
                if (OPRBarrageView.this.mListener != null) {
                    OPRBarrageView.this.mListener.onSurfaceCreated(surfaceHolder);
                }
                OPRBarrageView.this.mDanmakuCount = 0;
                OPRBarrageView.this.mAbnormalCount = 0;
                OPRBarrageView.this.mStartTime = SystemClock.elapsedRealtime();
                OPRBarrageView.this.mFpsList.clear();
                OPRBarrageView.this.mAbnormalFpsList.clear();
            }

            @Override // com.youku.android.barrage.view.OprViewCallback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                if (OPRBarrageView.this.mListener != null) {
                    OPRBarrageView.this.mListener.onSurfaceDestroyed(surfaceHolder);
                }
            }
        };
        this.callback = r4;
        this.mContext = context;
        setupCallback(r4);
    }

    public OPRBarrageView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        AnonymousClass1 r2 = new OprViewCallback() {
            /* class com.youku.android.barrage.OPRBarrageView.AnonymousClass1 */

            @Override // com.youku.android.barrage.view.OprViewCallback
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                Surface surface = new Surface(surfaceTexture);
                int nativeInit = OPRBarrageView.this.nativeInit(new WeakReference(OPRBarrageView.this), surface);
                String str = OPRBarrageView.TAG;
                Log.d(str, "nativeInit ret: " + nativeInit);
                if (nativeInit != 0 && OPRBarrageView.access$206(OPRBarrageView.this) >= 0) {
                    OPRBarrageView.this.submitOprDanmakuAbnormal((double) nativeInit, 0.0d);
                    OPRBarrageView.this.nativeReleaseBarrage();
                    OPRBarrageView.this.setVisibility(8);
                    OPRBarrageView.this.setVisibility(0);
                }
                if (OPRBarrageView.this.mListener != null) {
                    OPRBarrageView.this.mListener.onSurfaceCreated(null);
                }
                if (OPRBarrageView.this.mListener != null) {
                    OPRBarrageView.this.mListener.onSurfaceChanged(null, 0, i, i2);
                }
                OPRBarrageView.this.setViewSize(i, i2);
            }

            @Override // com.youku.android.barrage.view.OprViewCallback
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (OPRBarrageView.this.mListener == null) {
                    return false;
                }
                OPRBarrageView.this.mListener.onSurfaceDestroyed(null);
                return false;
            }

            @Override // com.youku.android.barrage.view.OprViewCallback
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                if (OPRBarrageView.this.mListener != null) {
                    OPRBarrageView.this.mListener.onSurfaceChanged(null, 0, i, i2);
                }
                OPRBarrageView.this.setViewSize(i, i2);
            }

            @Override // com.youku.android.barrage.view.OprViewCallback
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            @Override // com.youku.android.barrage.view.OprViewCallback
            public void surfaceChanged(final SurfaceHolder surfaceHolder, final int i, final int i2, final int i3) {
                String propString = SystemProperties.getPropString(OPRBarrageView.this.mContext, "ro.product.model");
                String str = OPRBarrageView.TLOG_TAG;
                OprLogUtils.TLogPrint(str, "deviceModel: " + propString);
                if (TextUtils.isEmpty(propString) || ((!propString.toLowerCase().startsWith("oppo") && !propString.toLowerCase().startsWith("vivo") && !propString.toLowerCase().startsWith("redmi")) || OPRBarrageView.this.mContext == null)) {
                    OPRBarrageView.this.setViewSize(i2, i3);
                    if (OPRBarrageView.this.mListener != null) {
                        OPRBarrageView.this.mListener.onSurfaceChanged(surfaceHolder, i, i2, i3);
                        return;
                    }
                    return;
                }
                new Handler(OPRBarrageView.this.mContext.getMainLooper()).postDelayed(new Runnable() {
                    /* class com.youku.android.barrage.OPRBarrageView.AnonymousClass1.AnonymousClass1 */

                    public void run() {
                        OPRBarrageView.this.setViewSize(i2, i3);
                        if (OPRBarrageView.this.mListener != null) {
                            OPRBarrageView.this.mListener.onSurfaceChanged(surfaceHolder, i, i2, i3);
                        }
                    }
                }, 500);
            }

            @Override // com.youku.android.barrage.view.OprViewCallback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                Surface surface = surfaceHolder.getSurface();
                int nativeInit = OPRBarrageView.this.nativeInit(new WeakReference(OPRBarrageView.this), surface);
                String str = OPRBarrageView.TAG;
                Log.d(str, "nativeInit ret: " + nativeInit);
                if (nativeInit != 0 && OPRBarrageView.access$210(OPRBarrageView.this) >= 0) {
                    OPRBarrageView.this.submitOprDanmakuAbnormal((double) nativeInit, 0.0d);
                    OPRBarrageView.this.nativeReleaseBarrage();
                    OPRBarrageView.this.setVisibility(8);
                    OPRBarrageView.this.setVisibility(0);
                }
                if (OPRBarrageView.this.mListener != null) {
                    OPRBarrageView.this.mListener.onSurfaceCreated(surfaceHolder);
                }
                OPRBarrageView.this.mDanmakuCount = 0;
                OPRBarrageView.this.mAbnormalCount = 0;
                OPRBarrageView.this.mStartTime = SystemClock.elapsedRealtime();
                OPRBarrageView.this.mFpsList.clear();
                OPRBarrageView.this.mAbnormalFpsList.clear();
            }

            @Override // com.youku.android.barrage.view.OprViewCallback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                if (OPRBarrageView.this.mListener != null) {
                    OPRBarrageView.this.mListener.onSurfaceDestroyed(surfaceHolder);
                }
            }
        };
        this.callback = r2;
        this.mContext = context;
        setupCallback(r2);
    }

    static /* synthetic */ int access$206(OPRBarrageView oPRBarrageView) {
        int i = oPRBarrageView.mRetryCount - 1;
        oPRBarrageView.mRetryCount = i;
        return i;
    }

    static /* synthetic */ int access$210(OPRBarrageView oPRBarrageView) {
        int i = oPRBarrageView.mRetryCount;
        oPRBarrageView.mRetryCount = i - 1;
        return i;
    }

    private void addToList(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i > 0 && j <= 120) {
            this.mFpsList.add(Long.valueOf(j));
            if (i <= 0 || j >= 50) {
                this.mAbnormalFpsList.clear();
            } else if (this.mAbnormalFpsList.size() < 3) {
                this.mAbnormalFpsList.add(Long.valueOf(j));
            }
            if (this.mAbnormalFpsList.size() >= 3 && this.mSubmitCount < 50) {
                double doubleValue = CalculateUtils.calculateAverage(this.mAbnormalFpsList).doubleValue();
                String str = TAG;
                Log.d(str, "submitOprDanmakuAbnormal errCode: " + 90001.0d);
                submitOprDanmakuAbnormal(90001.0d, doubleValue);
                this.mAbnormalFpsList.clear();
                this.mSubmitCount = this.mSubmitCount + 1;
            }
        }
    }

    private void convertBarrageText2Bitmap(OPRBarrage oPRBarrage) {
        int i = oPRBarrage.nbText;
        int i2 = oPRBarrage.nbBitmap;
        if (i > 0) {
            int i3 = i2 + i;
            OPRBarrageBitmap[] oPRBarrageBitmapArr = new OPRBarrageBitmap[i3];
            for (int i4 = 0; i4 < i; i4++) {
                oPRBarrageBitmapArr[i4] = new OPRBarrageBitmap();
                OPRBarrageText[] oPRBarrageTextArr = oPRBarrage.texts;
                OPRBarrageBitmap oPRBarrageBitmap = OPRBitmapUtils.getOPRBarrageBitmap(oPRBarrageTextArr[i4].text, oPRBarrageTextArr[i4].color, oPRBarrageTextArr[i4].textSize, oPRBarrageTextArr[i4].fontPath, oPRBarrageTextArr[i4].colorType == 1, oPRBarrageTextArr[i4].colorStart, oPRBarrageTextArr[i4].colorEnd);
                oPRBarrageBitmapArr[i4].data = oPRBarrageBitmap.data;
                oPRBarrageBitmapArr[i4].width = oPRBarrageBitmap.width;
                oPRBarrageBitmapArr[i4].height = oPRBarrageBitmap.height;
                OPRBarrageBitmap oPRBarrageBitmap2 = oPRBarrageBitmapArr[i4];
                OPRBarrageText[] oPRBarrageTextArr2 = oPRBarrage.texts;
                oPRBarrageBitmap2.layer = oPRBarrageTextArr2[i4].layer;
                oPRBarrageBitmapArr[i4].position = oPRBarrageTextArr2[i4].position;
            }
            for (int i5 = i; i5 < i3; i5++) {
                oPRBarrageBitmapArr[i5] = oPRBarrage.bitmaps[i5 - i];
            }
            oPRBarrage.bitmaps = oPRBarrageBitmapArr;
            oPRBarrage.nbBitmap = i3;
        }
    }

    private void leaveScreen(long j) {
        INotifyListener iNotifyListener = this.mListener;
        if (iNotifyListener != null) {
            iNotifyListener.barrageLeave(j);
        }
    }

    private native boolean nativeGetStutterInfo(OPRDanmakuStutterInfo oPRDanmakuStutterInfo);

    private native void nativeHideBarrage(long j, boolean z);

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private native int nativeInit(Object obj, Object obj2);

    private native int nativeInsertBarrage(OPRBarrage oPRBarrage);

    private native boolean nativeQueryBarrage(long j, OPRBarrage oPRBarrage);

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private native void nativeReleaseBarrage();

    private native int nativeRemoveAllBarrages();

    private native int nativeRemoveBarrage(long j);

    private native int nativeSetRhythmOn(boolean z, boolean z2);

    private native void nativeSetSurfaceSize(int i, int i2);

    private native boolean nativeTouchEvent(OPRPoint oPRPoint, OPRBarrageAction oPRBarrageAction);

    private native int nativeUpdateAlpha(float f);

    private native int nativeUpdateAnimation(long j, int i, OPRBarrageAnimation oPRBarrageAnimation);

    private native boolean nativeUpdateBarrage(long j, OPRBarrage oPRBarrage);

    private native int nativeUpdateBitmap(long j, int i, OPRBarrageBitmap oPRBarrageBitmap);

    private native int nativeUpdateHiddenStatus(boolean z);

    private native int nativeUpdatePauseStatus(boolean z);

    private native int nativeUpdateRhythm(OPRPoint[] oPRPointArr, int[] iArr);

    private native int nativeUpdateStepRatio(float f);

    private native int nativeUpdateText(long j, int i, OPRBarrageText oPRBarrageText);

    private static void postEventFromNative(Object obj, int i, long j, int i2, Object obj2) {
        String str;
        String str2;
        if (obj == null) {
            str = TAG;
            str2 = "postEventFromNative ref is null";
        } else {
            OPRBarrageView oPRBarrageView = (OPRBarrageView) ((WeakReference) obj).get();
            if (oPRBarrageView == null) {
                str = TAG;
                str2 = "postEventFromNative barrage is null";
            } else if (i == 0) {
                oPRBarrageView.showBarrage(j);
                return;
            } else if (i == 1) {
                oPRBarrageView.leaveScreen(j);
                return;
            } else if (i == 2) {
                Log.d(TAG, "NOTIFY_BARRAGE_HIT");
                return;
            } else if (i == 5) {
                oPRBarrageView.addToList(j);
                return;
            } else {
                return;
            }
        }
        Log.e(str, str2);
    }

    private void showBarrage(long j) {
        this.mDanmakuCount++;
        INotifyListener iNotifyListener = this.mListener;
        if (iNotifyListener != null) {
            iNotifyListener.barrageShow(j);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void submitOprDanmakuAbnormal(double d, double d2) {
        OprBarrageVPM oprBarrageVPM = new OprBarrageVPM();
        HashMap hashMap = new HashMap();
        hashMap.put(OprBarrageField.danmakuText, "");
        HashMap hashMap2 = new HashMap();
        hashMap2.put(OprBarrageField.abnormalCode, Double.valueOf(d));
        hashMap2.put("subCode", Double.valueOf(d2));
        hashMap2.put("bid", Double.valueOf(0.0d));
        oprBarrageVPM.submitBarrageAbnormal(hashMap, hashMap2);
    }

    private synchronized void submitOprDanmakuSummary() {
        if (this.mDanmakuCount > 0) {
            double doubleValue = CalculateUtils.calculateAverage(this.mFpsList).doubleValue();
            if (doubleValue > 0.0d && doubleValue <= 120.0d) {
                OprBarrageVPM oprBarrageVPM = new OprBarrageVPM();
                HashMap hashMap = new HashMap();
                hashMap.put("vid", this.mVid);
                HashMap hashMap2 = new HashMap();
                hashMap2.put(OprBarrageField.danmakuCount, Double.valueOf((double) this.mDanmakuCount));
                hashMap2.put(OprBarrageField.avgFps, Double.valueOf(doubleValue));
                hashMap2.put(OprBarrageField.abnormalCount, Double.valueOf((double) this.mAbnormalCount));
                hashMap2.put("duration", Double.valueOf(Double.valueOf((double) (SystemClock.elapsedRealtime() - this.mStartTime)).doubleValue() / 1000.0d));
                oprBarrageVPM.submitBarrageSummary(hashMap, hashMap2);
            }
        }
    }

    private void updateAnimation(long j, int i, OPRBarrageAnimation oPRBarrageAnimation) {
        nativeUpdateAnimation(j, i, oPRBarrageAnimation);
    }

    private void updateBitmap(long j, int i, OPRBarrageBitmap oPRBarrageBitmap) {
        nativeUpdateBitmap(j, i, oPRBarrageBitmap);
    }

    private void updateText(long j, int i, OPRBarrageText oPRBarrageText) {
        nativeUpdateText(j, i, oPRBarrageText);
    }

    public synchronized boolean getStutterInfo(OPRDanmakuStutterInfo oPRDanmakuStutterInfo) {
        boolean nativeGetStutterInfo;
        nativeGetStutterInfo = nativeGetStutterInfo(oPRDanmakuStutterInfo);
        if (oPRDanmakuStutterInfo.avgFps > 0.0f) {
            String str = TAG;
            Log.d(str, "getStutterInfo, avgFps: " + oPRDanmakuStutterInfo.avgFps + ", avgStutterCountPerMinutes: " + oPRDanmakuStutterInfo.avgStutterCountPerMinutes + ", maxStutterCountPerMinutes: " + oPRDanmakuStutterInfo.maxStutterCountPerMinutes + ", avgSevereStutterCountPerMinutes: " + oPRDanmakuStutterInfo.avgSevereStutterCountPerMinutes + ", maxSevereStutterCountPerMinutes: " + oPRDanmakuStutterInfo.maxSevereStutterCountPerMinutes + ", scutterRatio: " + oPRDanmakuStutterInfo.scutterRatio + ", danmakuCountPerFrame: " + oPRDanmakuStutterInfo.danmakuCountPerFrame + ", apngCountPerFrame: " + oPRDanmakuStutterInfo.apngCountPerFrame);
        }
        return nativeGetStutterInfo;
    }

    public void hide() {
        nativeUpdateHiddenStatus(true);
    }

    public void hideBarrage(long j, boolean z) {
        nativeHideBarrage(j, z);
    }

    public void insertBarrage(OPRBarrage oPRBarrage) {
        if (TextUtils.isEmpty(oPRBarrage.vid) || (!TextUtils.isEmpty(oPRBarrage.vid) && !TextUtils.isEmpty(this.mVid) && !this.mVid.equals(oPRBarrage.vid))) {
            this.mSubmitCount = 0;
        }
        this.mVid = oPRBarrage.vid;
        nativeInsertBarrage(oPRBarrage);
    }

    public void pause() {
        nativeUpdatePauseStatus(true);
    }

    public boolean queryBarrage(long j, OPRBarrage oPRBarrage) {
        return nativeQueryBarrage(j, oPRBarrage);
    }

    public void releaseBarrage() {
        removeAllBarrages();
        submitOprDanmakuSummary();
        nativeReleaseBarrage();
    }

    public void removeAllBarrages() {
        nativeRemoveAllBarrages();
    }

    public void removeBarrage(long j) {
        nativeRemoveBarrage(j);
    }

    public void resume() {
        nativeUpdatePauseStatus(false);
    }

    public void setListener(INotifyListener iNotifyListener) {
        this.mListener = iNotifyListener;
    }

    public void setRhythmOn(boolean z, boolean z2) {
        nativeSetRhythmOn(z, z2);
    }

    public void setViewSize(int i, int i2) {
        nativeSetSurfaceSize(i, i2);
    }

    public void show() {
        nativeUpdateHiddenStatus(false);
    }

    public boolean touchEvent(OPRPoint oPRPoint, OPRBarrageAction oPRBarrageAction) {
        return nativeTouchEvent(oPRPoint, oPRBarrageAction);
    }

    public void updateAlpha(float f) {
        nativeUpdateAlpha(f);
    }

    public void updateBarrage(long j, OPRBarrage oPRBarrage) {
        String str = TAG;
        Log.d(str, "updateBarrage: " + j);
        this.mVid = oPRBarrage.vid;
        nativeUpdateBarrage(j, oPRBarrage);
    }

    public void updateRhythm(OPRPoint[] oPRPointArr, int[] iArr) {
        nativeUpdateRhythm(oPRPointArr, iArr);
    }

    public void updateSpeed(float f) {
        nativeUpdateStepRatio(f);
    }
}
