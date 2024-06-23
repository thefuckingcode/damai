package com.autonavi.base.ae.gmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.alipay.sdk.m.c.a;
import com.amap.api.mapcore.util.ep;
import com.amap.api.mapcore.util.eq;
import com.amap.api.mapcore.util.hd;
import com.amap.api.maps.AMap;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.autonavi.amap.api.mapcore.IGLMapEngine;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.base.ae.gmap.glanimation.AdglMapAnimFling;
import com.autonavi.base.ae.gmap.glanimation.AdglMapAnimGroup;
import com.autonavi.base.ae.gmap.glanimation.AdglMapAnimationMgr;
import com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay;
import com.autonavi.base.ae.gmap.gloverlay.GLOverlayBundle;
import com.autonavi.base.ae.gmap.gloverlay.GLTextureProperty;
import com.autonavi.base.ae.gmap.style.StyleItem;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.FileUtil;
import com.autonavi.base.amap.mapcore.IAMapEngineCallback;
import com.autonavi.base.amap.mapcore.interfaces.IAMapListener;
import com.autonavi.base.amap.mapcore.maploader.AMapLoader;
import com.autonavi.base.amap.mapcore.maploader.NetworkState;
import com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.HoverGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.MoveGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.RotateGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.ScaleGestureMapMessage;
import com.autonavi.base.amap.mapcore.tools.GLConvertUtil;
import com.autonavi.base.amap.mapcore.tools.TextTextureGenerator;
import com.youku.alixplayer.ExtraID;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import tb.gl1;

/* compiled from: Taobao */
public class GLMapEngine implements IGLMapEngine, IAMapEngineCallback, NetworkState.NetworkChangeListener {
    Hashtable<Long, AMapLoader> aMapLoaderHashtable;
    GLOverlayBundle<BaseMapOverlay<?, ?>> bundle;
    private Context context;
    private GLMapState copyGLMapState;
    private boolean isEngineRenderComplete;
    boolean isGestureStep;
    boolean isMoveCameraStep;
    private List<AbstractCameraUpdateMessage> mAnimateStateMessageList;
    private List<AbstractGestureMapMessage> mGestureEndMessageList;
    private List<AbstractGestureMapMessage> mGestureMessageList;
    private IAMapDelegate mGlMapView;
    private Lock mLock;
    private IAMapListener mMapListener;
    private long mNativeMapengineInstance;
    private NetworkState mNetworkState;
    boolean mRequestDestroy;
    private AtomicInteger mRequestID;
    private List<AbstractCameraUpdateMessage> mStateMessageList;
    private TextTextureGenerator mTextTextureGenerator;
    private AdglMapAnimationMgr mapAnimationMgr;
    private int mapGestureCount;
    private Object mutLock;
    GLMapState state;
    private String userAgent;

    /* compiled from: Taobao */
    public static class InitParam {
        public String mConfigContent = "";
        public String mConfigPath = "";
        public String mOfflineDataPath = "";
        public String mP3dCrossPath = "";
        public String mRootPath = "";
    }

    /* compiled from: Taobao */
    public static class MapViewInitParam {
        public int engineId;
        public int height;
        public float mapZoomScale;
        public int screenHeight;
        public float screenScale;
        public int screenWidth;
        public float textScale;
        public int width;
        public int x;
        public int y;
    }

    public GLMapEngine(Context context2, IAMapDelegate iAMapDelegate) {
        this.mNativeMapengineInstance = 0;
        this.mGlMapView = null;
        this.mStateMessageList = new Vector();
        this.mGestureMessageList = new Vector();
        this.mGestureEndMessageList = new Vector();
        this.mAnimateStateMessageList = new Vector();
        this.isMoveCameraStep = false;
        this.isGestureStep = false;
        this.mapGestureCount = 0;
        this.mapAnimationMgr = null;
        this.copyGLMapState = null;
        this.mLock = new ReentrantLock();
        this.mutLock = new Object();
        this.mNetworkState = null;
        this.bundle = null;
        this.isEngineRenderComplete = false;
        this.aMapLoaderHashtable = new Hashtable<>();
        this.mRequestDestroy = false;
        this.mRequestID = new AtomicInteger(1);
        this.mRequestDestroy = false;
        if (context2 != null) {
            this.context = context2.getApplicationContext();
            this.mGlMapView = iAMapDelegate;
            this.mTextTextureGenerator = new TextTextureGenerator();
            AdglMapAnimationMgr adglMapAnimationMgr = new AdglMapAnimationMgr();
            this.mapAnimationMgr = adglMapAnimationMgr;
            adglMapAnimationMgr.setMapAnimationListener(new AdglMapAnimationMgr.MapAnimationListener() {
                /* class com.autonavi.base.ae.gmap.GLMapEngine.AnonymousClass5 */

                @Override // com.autonavi.base.ae.gmap.glanimation.AdglMapAnimationMgr.MapAnimationListener
                public void onMapAnimationFinish(AMap.CancelableCallback cancelableCallback) {
                    GLMapEngine.this.doMapAnimationFinishCallback(cancelableCallback);
                }
            });
            this.userAgent = System.getProperty("http.agent") + " amap/" + GlMapUtil.getAppVersionName(context2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0072 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    private float adapterDpiScale(DisplayMetrics displayMetrics, int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        float f;
        String emui = getEMUI();
        if (emui == null || emui.isEmpty()) {
            return 1.0f;
        }
        if ((emui.indexOf("EmotionUI_8") == -1 && emui.indexOf("EmotionUI_9") == -1) || i3 <= 0) {
            return 1.0f;
        }
        i4 = 0;
        try {
            Field declaredField = DisplayMetrics.class.getDeclaredField("noncompatWidthPixels");
            declaredField.setAccessible(true);
            i5 = declaredField.getInt(displayMetrics);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
        try {
            Field declaredField2 = DisplayMetrics.class.getDeclaredField("noncompatHeightPixels");
            declaredField2.setAccessible(true);
            i6 = declaredField2.getInt(displayMetrics);
        } catch (NoSuchFieldException e3) {
            e3.printStackTrace();
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
        }
        try {
            Field declaredField3 = DisplayMetrics.class.getDeclaredField("noncompatDensityDpi");
            declaredField3.setAccessible(true);
            i4 = declaredField3.getInt(displayMetrics);
        } catch (NoSuchFieldException e5) {
            e5.printStackTrace();
        } catch (IllegalAccessException e6) {
            e6.printStackTrace();
        }
        if (i4 > i3 && i5 <= i && i6 <= i2) {
            return 1.0f;
        }
        f = ((float) i4) / ((float) i3);
        if (f > 2.0f) {
            f = 2.0f;
        }
        if (f < 1.0f) {
            return 1.0f;
        }
        return f;
        i6 = 0;
        Field declaredField32 = DisplayMetrics.class.getDeclaredField("noncompatDensityDpi");
        declaredField32.setAccessible(true);
        i4 = declaredField32.getInt(displayMetrics);
        if (i4 > i3) {
        }
        f = ((float) i4) / ((float) i3);
        if (f > 2.0f) {
        }
        if (f < 1.0f) {
        }
        i5 = 0;
        Field declaredField22 = DisplayMetrics.class.getDeclaredField("noncompatHeightPixels");
        declaredField22.setAccessible(true);
        i6 = declaredField22.getInt(displayMetrics);
        Field declaredField322 = DisplayMetrics.class.getDeclaredField("noncompatDensityDpi");
        declaredField322.setAccessible(true);
        i4 = declaredField322.getInt(displayMetrics);
        if (i4 > i3) {
        }
        f = ((float) i4) / ((float) i3);
        if (f > 2.0f) {
        }
        if (f < 1.0f) {
        }
    }

    public static void destroyOverlay(int i, long j) {
        synchronized (GLMapEngine.class) {
            nativeDestroyOverlay(i, j);
        }
    }

    private void doMapAnimationCancelCallback(final AMap.CancelableCallback cancelableCallback) {
        IAMapDelegate iAMapDelegate;
        if (cancelableCallback != null && (iAMapDelegate = this.mGlMapView) != null) {
            iAMapDelegate.getMainHandler().post(new Runnable() {
                /* class com.autonavi.base.ae.gmap.GLMapEngine.AnonymousClass2 */

                public void run() {
                    try {
                        cancelableCallback.onCancel();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void doMapAnimationFinishCallback(final AMap.CancelableCallback cancelableCallback) {
        IAMapDelegate iAMapDelegate;
        IAMapListener iAMapListener = this.mMapListener;
        if (iAMapListener != null) {
            iAMapListener.afterAnimation();
        }
        if (cancelableCallback != null && (iAMapDelegate = this.mGlMapView) != null) {
            iAMapDelegate.getMainHandler().post(new Runnable() {
                /* class com.autonavi.base.ae.gmap.GLMapEngine.AnonymousClass3 */

                public void run() {
                    try {
                        cancelableCallback.onFinish();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    private void gestureBegin() {
        this.mapGestureCount++;
    }

    private void gestureEnd() {
        int i = this.mapGestureCount - 1;
        this.mapGestureCount = i;
        if (i == 0) {
            recycleMessage();
        }
    }

    private static String getEMUI() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod(gl1.TYPE_OPEN_URL_METHOD_GET, String.class).invoke(cls, a.a);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void initAnimation() {
        AbstractCameraUpdateMessage remove;
        if (this.mStateMessageList.size() <= 0 && this.mAnimateStateMessageList.size() > 0 && (remove = this.mAnimateStateMessageList.remove(0)) != null) {
            remove.generateMapAnimation(this);
        }
    }

    private void initNetworkState() {
        NetworkState networkState = new NetworkState();
        this.mNetworkState = networkState;
        networkState.setNetworkListener(this);
        this.mNetworkState.registerNetChangeReceiver(this.context.getApplicationContext(), true);
        boolean isNetworkConnected = NetworkState.isNetworkConnected(this.context.getApplicationContext());
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetNetStatus(j, isNetworkConnected ? 1 : 0);
        }
    }

    protected static native String nativeAddNativeOverlay(int i, long j, int i2, int i3);

    private static native boolean nativeAddOverlayTexture(int i, long j, int i2, int i3, float f, float f2, Bitmap bitmap, boolean z, boolean z2);

    private static native void nativeCancelDownLoad(int i, long j, long j2);

    private static native void nativeCreateAMapEngineWithFrame(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, float f, float f2, float f3);

    private static native long nativeCreateAMapInstance(String str, String str2, String str3, float f, float f2, float f3);

    protected static native long nativeCreateOverlay(int i, long j, int i2);

    private static native void nativeDestroy(long j);

    private static native void nativeDestroyCurrentState(long j, long j2);

    protected static native void nativeDestroyOverlay(int i, long j);

    private static native void nativeFinishDownLoad(int i, long j, long j2);

    private static native void nativeGetCurTileIDs(int i, long j, int[] iArr, int i2);

    private static native long nativeGetCurrentMapState(int i, long j);

    private static native long nativeGetGlOverlayMgrPtr(int i, long j);

    public static native String nativeGetMapEngineVersion(int i);

    private static native int[] nativeGetMapModeState(int i, long j, boolean z);

    public static native long nativeGetNativeMapController(int i, long j);

    private static native boolean nativeGetSrvViewStateBoolValue(int i, long j, int i2);

    private static native void nativeInitAMapEngineCallback(long j, Object obj);

    private static native void nativeInitParam(String str, String str2, String str3, String str4);

    private static native boolean nativeIsEngineCreated(long j, int i);

    private static native void nativePopRenderState(int i, long j);

    private static native void nativePostRenderAMap(long j, int i);

    private static native void nativePushRendererState(int i, long j);

    private static native void nativeReceiveNetData(int i, long j, byte[] bArr, long j2, int i2);

    protected static native void nativeRemoveNativeAllOverlay(int i, long j);

    protected static native void nativeRemoveNativeOverlay(int i, long j, String str);

    private static native void nativeRenderAMap(long j, int i);

    private static native void nativeSelectMapPois(int i, long j, int i2, int i3, int i4, byte[] bArr);

    private static native void nativeSetAllContentEnable(int i, long j, boolean z);

    private static native void nativeSetBuildingEnable(int i, long j, boolean z);

    private static native void nativeSetBuildingTextureEnable(int i, long j, boolean z);

    private static native void nativeSetCustomStyleData(int i, long j, byte[] bArr, byte[] bArr2);

    private static native void nativeSetCustomStyleTexture(int i, long j, byte[] bArr);

    private static native void nativeSetHighlightSubwayEnable(int i, long j, boolean z);

    private static native void nativeSetIndoorBuildingToBeActive(int i, long j, String str, int i2, String str2);

    private static native void nativeSetIndoorEnable(int i, long j, boolean z);

    private static native void nativeSetLabelEnable(int i, long j, boolean z);

    private static native boolean nativeSetMapModeAndStyle(int i, long j, int[] iArr, boolean z, boolean z2, StyleItem[] styleItemArr);

    private static native void nativeSetNaviLabelEnable(int i, long j, boolean z, int i2, int i3);

    /* access modifiers changed from: private */
    public static native void nativeSetNetStatus(long j, int i);

    private static native void nativeSetOfflineDataEnable(int i, long j, boolean z);

    private static native void nativeSetParameter(int i, long j, int i2, int i3, int i4, int i5, int i6);

    private static native void nativeSetProjectionCenter(int i, long j, float f, float f2);

    private static native void nativeSetRenderListenerStatus(int i, long j);

    private static native void nativeSetRoadArrowEnable(int i, long j, boolean z);

    private static native void nativeSetServiceViewRect(int i, long j, int i2, int i3, int i4, int i5, int i6, int i7);

    private static native void nativeSetSetBackgroundTexture(int i, long j, byte[] bArr);

    private static native void nativeSetSimple3DEnable(int i, long j, boolean z);

    private static native void nativeSetSkyTexture(int i, long j, byte[] bArr);

    private static native void nativeSetSrvViewStateBoolValue(int i, long j, int i2, boolean z);

    private static native void nativeSetTrafficEnable(int i, long j, boolean z);

    private static native void nativeSetTrafficTexture(int i, long j, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4);

    private static native void nativeSetTrafficTextureAllInOne(int i, long j, byte[] bArr);

    protected static native void nativeUpdateNativeArrowOverlay(int i, long j, String str, int[] iArr, int[] iArr2, int i2, int i3, int i4, float f, boolean z, int i5, int i6, int i7);

    private static native void nativesetMapOpenLayer(int i, long j, byte[] bArr);

    private boolean processAnimations(GLMapState gLMapState) {
        try {
            if (this.mapAnimationMgr.getAnimationsCount() <= 0) {
                return false;
            }
            gLMapState.recalculate();
            this.mapAnimationMgr.doAnimations(gLMapState);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private boolean processGestureMessage(GLMapState gLMapState) {
        AbstractGestureMapMessage remove;
        if (this.mGestureMessageList.size() <= 0) {
            if (this.isGestureStep) {
                this.isGestureStep = false;
            }
            return false;
        }
        this.isGestureStep = true;
        if (gLMapState == null) {
            return false;
        }
        while (this.mGestureMessageList.size() > 0 && (remove = this.mGestureMessageList.remove(0)) != null) {
            if (remove.width == 0) {
                remove.width = this.mGlMapView.getMapWidth();
            }
            if (remove.height == 0) {
                remove.height = this.mGlMapView.getMapHeight();
            }
            int mapGestureState = remove.getMapGestureState();
            if (mapGestureState == 100) {
                gestureBegin();
            } else if (mapGestureState == 101) {
                remove.runCameraUpdate(gLMapState);
            } else if (mapGestureState == 102) {
                gestureEnd();
            }
            this.mGestureEndMessageList.add(remove);
        }
        if (this.mGestureEndMessageList.size() == 1) {
            recycleMessage();
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x003c A[Catch:{ Exception -> 0x0058 }] */
    private boolean processMessage() {
        boolean z;
        try {
            GLMapState gLMapState = (GLMapState) getNewMapState(1);
            boolean processGestureMessage = processGestureMessage(gLMapState);
            if (this.mGestureMessageList.size() <= 0) {
                if (!processGestureMessage) {
                    if (!processStateMapMessage(gLMapState)) {
                        processGestureMessage = false;
                    }
                }
                processGestureMessage = true;
            } else if (this.mStateMessageList.size() > 0) {
                this.mStateMessageList.clear();
            }
            if (!processGestureMessage) {
                if (!processAnimations(gLMapState)) {
                    z = false;
                    if (z) {
                        gLMapState.setCameraDegree(eq.a(this.mGlMapView.getMapConfig(), gLMapState.getCameraDegree(), gLMapState.getMapZoomer()));
                        setMapState(1, gLMapState);
                    }
                    gLMapState.recycle();
                    return z;
                }
            }
            z = true;
            if (z) {
            }
            gLMapState.recycle();
            return z;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean processStateMapMessage(GLMapState gLMapState) {
        AbstractCameraUpdateMessage remove;
        if (this.mStateMessageList.size() <= 0) {
            if (this.isMoveCameraStep) {
                this.isMoveCameraStep = false;
            }
            return false;
        }
        this.isMoveCameraStep = true;
        if (gLMapState == null) {
            return false;
        }
        while (this.mStateMessageList.size() > 0 && (remove = this.mStateMessageList.remove(0)) != null) {
            if (remove.width == 0) {
                remove.width = this.mGlMapView.getMapWidth();
            }
            if (remove.height == 0) {
                remove.height = this.mGlMapView.getMapHeight();
            }
            gLMapState.recalculate();
            remove.runCameraUpdate(gLMapState);
        }
        return true;
    }

    private void recycleMessage() {
        AbstractGestureMapMessage remove;
        while (this.mGestureEndMessageList.size() > 0 && (remove = this.mGestureEndMessageList.remove(0)) != null) {
            if (remove instanceof MoveGestureMapMessage) {
                ((MoveGestureMapMessage) remove).recycle();
            } else if (remove instanceof HoverGestureMapMessage) {
                ((HoverGestureMapMessage) remove).recycle();
            } else if (remove instanceof RotateGestureMapMessage) {
                ((RotateGestureMapMessage) remove).recycle();
            } else if (remove instanceof ScaleGestureMapMessage) {
                ((ScaleGestureMapMessage) remove).recycle();
            }
        }
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    public void OnIndoorBuildingActivity(int i, byte[] bArr) {
        IAMapDelegate iAMapDelegate = this.mGlMapView;
        if (iAMapDelegate != null) {
            try {
                iAMapDelegate.onIndoorBuildingActivity(i, bArr);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public synchronized void addGestureMessage(int i, AbstractGestureMapMessage abstractGestureMapMessage, boolean z, int i2, int i3) {
        if (abstractGestureMapMessage != null) {
            abstractGestureMapMessage.isGestureScaleByMapCenter = z;
            this.mGestureMessageList.add(abstractGestureMapMessage);
        }
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapEngine
    public void addGroupAnimation(int i, int i2, float f, int i3, int i4, int i5, int i6, AMap.CancelableCallback cancelableCallback) {
        AdglMapAnimGroup adglMapAnimGroup = new AdglMapAnimGroup(i2);
        adglMapAnimGroup.setToCameraDegree((float) i4, 0);
        adglMapAnimGroup.setToMapAngle((float) i3, 0);
        adglMapAnimGroup.setToMapLevel(f, 0);
        adglMapAnimGroup.setToMapCenterGeo(i5, i6, 0);
        if (this.mapAnimationMgr != null && adglMapAnimGroup.isValid()) {
            this.mapAnimationMgr.addAnimation(adglMapAnimGroup, cancelableCallback);
        }
    }

    public void addMessage(AbstractCameraUpdateMessage abstractCameraUpdateMessage, boolean z) {
        if (z) {
            List<AbstractCameraUpdateMessage> list = this.mAnimateStateMessageList;
            if (list != null) {
                list.clear();
                this.mAnimateStateMessageList.add(abstractCameraUpdateMessage);
                return;
            }
            return;
        }
        List<AbstractCameraUpdateMessage> list2 = this.mStateMessageList;
        if (list2 != null) {
            list2.add(abstractCameraUpdateMessage);
        }
    }

    public String addNativeOverlay(int i, int i2, int i3) {
        long j = this.mNativeMapengineInstance;
        if (j == 0) {
            return null;
        }
        String nativeAddNativeOverlay = nativeAddNativeOverlay(i, j, i2, i3);
        if (TextUtils.isEmpty(nativeAddNativeOverlay)) {
            return null;
        }
        return nativeAddNativeOverlay;
    }

    public void addOverlayTexture(int i, GLTextureProperty gLTextureProperty) {
        Bitmap bitmap;
        if (this.mNativeMapengineInstance != 0 && gLTextureProperty != null && (bitmap = gLTextureProperty.mBitmap) != null && !bitmap.isRecycled()) {
            nativeAddOverlayTexture(i, this.mNativeMapengineInstance, gLTextureProperty.mId, gLTextureProperty.mAnchor, gLTextureProperty.mXRatio, gLTextureProperty.mYRatio, gLTextureProperty.mBitmap, gLTextureProperty.isGenMimps, gLTextureProperty.isRepeat);
        }
    }

    public boolean canStopMapRender(int i) {
        return this.isEngineRenderComplete;
    }

    public void cancelAllAMapDownload() {
        try {
            synchronized (this.aMapLoaderHashtable) {
                for (Map.Entry<Long, AMapLoader> entry : this.aMapLoaderHashtable.entrySet()) {
                    AMapLoader value = entry.getValue();
                    value.doCancel();
                    if (!value.isFinish) {
                        synchronized (value) {
                            if (!value.isFinish) {
                                value.notify();
                                value.isFinish = true;
                            }
                        }
                    }
                }
                this.aMapLoaderHashtable.clear();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    public void cancelRequireMapData(Object obj) {
        if (obj != null && (obj instanceof AMapLoader)) {
            ((AMapLoader) obj).doCancel();
        }
    }

    public void changeSurface(int i, int i2) {
    }

    public void clearAllMessages(int i) {
    }

    public void clearAnimations(int i, boolean z) {
        this.mapAnimationMgr.clearAnimations();
    }

    public void createAMapEngineWithFrame(MapViewInitParam mapViewInitParam) {
        if (this.mNativeMapengineInstance != 0) {
            synchronized (GLMapEngine.class) {
                nativeCreateAMapEngineWithFrame(this.mNativeMapengineInstance, mapViewInitParam.engineId, mapViewInitParam.x, mapViewInitParam.y, mapViewInitParam.width, mapViewInitParam.height, mapViewInitParam.screenWidth, mapViewInitParam.screenHeight, mapViewInitParam.screenScale, mapViewInitParam.textScale, mapViewInitParam.mapZoomScale);
            }
        }
    }

    public void createAMapInstance(InitParam initParam) {
        if (initParam != null) {
            synchronized (GLMapEngine.class) {
                nativeInitParam(initParam.mRootPath, initParam.mConfigContent, initParam.mOfflineDataPath, initParam.mP3dCrossPath);
                DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
                int i = displayMetrics.densityDpi;
                long nativeCreateAMapInstance = nativeCreateAMapInstance("", "http://mpsapi.amap.com/", "http://m5.amap.com/", (float) i, displayMetrics.density, adapterDpiScale(displayMetrics, com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics), com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics), i));
                this.mNativeMapengineInstance = nativeCreateAMapInstance;
                nativeInitAMapEngineCallback(nativeCreateAMapInstance, this);
                initNetworkState();
            }
        }
    }

    public long createOverlay(int i, int i2) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            return nativeCreateOverlay(i, j, i2);
        }
        return 0;
    }

    public void destroyAMapEngine() {
        try {
            this.mRequestDestroy = true;
            cancelAllAMapDownload();
            synchronized (this.mutLock) {
                if (this.mNativeMapengineInstance != 0) {
                    synchronized (this) {
                        GLMapState gLMapState = this.copyGLMapState;
                        if (gLMapState != null) {
                            gLMapState.recycle();
                        }
                    }
                    nativeDestroyCurrentState(this.mNativeMapengineInstance, this.state.getNativeInstance());
                    nativeDestroy(this.mNativeMapengineInstance);
                }
                this.mNativeMapengineInstance = 0;
            }
            this.mGlMapView = null;
            this.mStateMessageList.clear();
            this.mAnimateStateMessageList.clear();
            this.mGestureEndMessageList.clear();
            this.mGestureMessageList.clear();
            this.mMapListener = null;
            this.bundle = null;
            ep.b();
        } catch (Throwable th) {
            th.printStackTrace();
            eq.a(th);
        }
    }

    public synchronized void finishDownLoad(int i, long j) {
        if (this.aMapLoaderHashtable.containsKey(Long.valueOf(j))) {
            long j2 = this.mNativeMapengineInstance;
            if (j2 != 0) {
                nativeFinishDownLoad(i, j2, j);
            }
            this.aMapLoaderHashtable.remove(Long.valueOf(j));
        }
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    public int generateRequestId() {
        return this.mRequestID.incrementAndGet();
    }

    public int getAnimateionsCount() {
        if (this.mNativeMapengineInstance != 0) {
            return this.mapAnimationMgr.getAnimationsCount();
        }
        return 0;
    }

    /* JADX INFO: finally extract failed */
    public synchronized GLMapState getCloneMapState() {
        this.mLock.lock();
        try {
            long j = this.mNativeMapengineInstance;
            if (j != 0) {
                if (this.copyGLMapState == null) {
                    this.copyGLMapState = new GLMapState(1, j);
                }
                this.copyGLMapState.setMapZoomer(this.mGlMapView.getMapConfig().getSZ());
                this.copyGLMapState.setCameraDegree(this.mGlMapView.getMapConfig().getSC());
                this.copyGLMapState.setMapAngle(this.mGlMapView.getMapConfig().getSR());
                this.copyGLMapState.setMapGeoCenter(this.mGlMapView.getMapConfig().getSX(), this.mGlMapView.getMapConfig().getSY());
            }
            this.mLock.unlock();
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
        return this.copyGLMapState;
    }

    public Context getContext() {
        return this.context;
    }

    public void getCurTileIDs(int i, int[] iArr) {
        if (iArr != null) {
            for (int i2 = 0; i2 < iArr.length; i2++) {
                iArr[i2] = 0;
            }
            nativeGetCurTileIDs(i, this.mNativeMapengineInstance, iArr, iArr.length);
        }
    }

    public int getEngineIDWithGestureInfo(EAMapPlatformGestureInfo eAMapPlatformGestureInfo) {
        return 1;
    }

    public int getEngineIDWithType(int i) {
        return 1;
    }

    public long getGlOverlayMgrPtr(int i) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            return nativeGetGlOverlayMgrPtr(i, j);
        }
        return 0;
    }

    public boolean getIsProcessBuildingMark(int i) {
        return false;
    }

    public byte[] getLabelBuffer(int i, int i2, int i3, int i4) {
        this.mLock.lock();
        try {
            byte[] bArr = new byte[3072];
            long j = this.mNativeMapengineInstance;
            if (j != 0) {
                nativeSelectMapPois(i, j, i2, i3, i4, bArr);
            }
            return bArr;
        } finally {
            this.mLock.unlock();
        }
    }

    public boolean getMapDataTaskIsCancel(int i, long j) {
        return !this.aMapLoaderHashtable.containsKey(Long.valueOf(j));
    }

    public int[] getMapModeState(int i, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j == 0) {
            return null;
        }
        nativeGetMapModeState(i, j, z);
        return null;
    }

    /* JADX INFO: finally extract failed */
    public GLMapState getMapState(int i) {
        this.mLock.lock();
        try {
            long j = this.mNativeMapengineInstance;
            if (j != 0 && this.state == null) {
                long nativeGetCurrentMapState = nativeGetCurrentMapState(i, j);
                if (nativeGetCurrentMapState != 0) {
                    this.state = new GLMapState(this.mNativeMapengineInstance, nativeGetCurrentMapState);
                }
            }
            this.mLock.unlock();
            return this.state;
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    public long getMapStateInstance(int i) {
        return 0;
    }

    public long getNativeInstance() {
        return this.mNativeMapengineInstance;
    }

    public long getNativeMapController(int i) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            return nativeGetNativeMapController(i, j);
        }
        return 0;
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapEngine
    public IGLMapState getNewMapState(int i) {
        this.mLock.lock();
        try {
            long j = this.mNativeMapengineInstance;
            if (j != 0) {
                return new GLMapState(i, j);
            }
            this.mLock.unlock();
            return null;
        } finally {
            this.mLock.unlock();
        }
    }

    public GLOverlayBundle getOverlayBundle(int i) {
        return this.bundle;
    }

    public boolean getSrvViewStateBoolValue(int i, int i2) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            return nativeGetSrvViewStateBoolValue(i, j, i2);
        }
        return false;
    }

    public synchronized AbstractCameraUpdateMessage getStateMessage() {
        List<AbstractCameraUpdateMessage> list = this.mStateMessageList;
        if (list != null) {
            if (list.size() != 0) {
                AbstractCameraUpdateMessage abstractCameraUpdateMessage = this.mStateMessageList.get(0);
                this.mStateMessageList.remove(abstractCameraUpdateMessage);
                return abstractCameraUpdateMessage;
            }
        }
        return null;
    }

    public int getStateMessageCount() {
        return this.mStateMessageList.size();
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public void initNativeTexture(int i) {
        try {
            BitmapDescriptor fromAsset = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_inner.png");
            Bitmap bitmap = null;
            Bitmap bitmap2 = fromAsset != null ? fromAsset.getBitmap() : null;
            BitmapDescriptor fromAsset2 = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_outer.png");
            Bitmap bitmap3 = fromAsset2 != null ? fromAsset2.getBitmap() : null;
            BitmapDescriptor fromAsset3 = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_shadow.png");
            if (fromAsset3 != null) {
                bitmap = fromAsset3.getBitmap();
            }
            addOverlayTexture(i, bitmap2, 111, 4);
            addOverlayTexture(i, bitmap3, 222, 4);
            addOverlayTexture(i, bitmap, 333, 4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void interruptAnimation() {
        if (isInMapAnimation(1)) {
            try {
                doMapAnimationCancelCallback(this.mapAnimationMgr.getCancelCallback());
                clearAnimations(1, false);
            } catch (Throwable th) {
                hd.c(th, getClass().getName(), "CancelableCallback.onCancel");
                th.printStackTrace();
            }
        }
    }

    public boolean isEngineCreated(int i) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            return nativeIsEngineCreated(j, i);
        }
        return false;
    }

    public boolean isInMapAction(int i) {
        return false;
    }

    public boolean isInMapAnimation(int i) {
        return getAnimateionsCount() > 0;
    }

    public synchronized void netError(int i, long j, int i2, int i3) {
        if (this.aMapLoaderHashtable.containsKey(Long.valueOf(j))) {
            long j2 = this.mNativeMapengineInstance;
            if (j2 != 0) {
                nativeCancelDownLoad(i, j2, j);
            }
            this.aMapLoaderHashtable.remove(Long.valueOf(j));
            try {
                if (MapsInitializer.getExceptionLogger() != null) {
                    MapsInitializer.getExceptionLogger().onDownloaderException(i2, i3);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public synchronized void netStop(int i, long j, int i2) {
        if (this.aMapLoaderHashtable.containsKey(Long.valueOf(j))) {
            long j2 = this.mNativeMapengineInstance;
            if (j2 != 0) {
                nativeCancelDownLoad(i, j2, j);
            }
            this.aMapLoaderHashtable.remove(Long.valueOf(j));
        }
    }

    @Override // com.autonavi.base.amap.mapcore.maploader.NetworkState.NetworkChangeListener
    public void networkStateChanged(Context context2) {
        if (!this.mRequestDestroy && this.mNativeMapengineInstance != 0 && this.mGlMapView != null) {
            final boolean isNetworkConnected = NetworkState.isNetworkConnected(context2);
            this.mGlMapView.queueEvent(new Runnable() {
                /* class com.autonavi.base.ae.gmap.GLMapEngine.AnonymousClass4 */

                public void run() {
                    GLMapEngine.nativeSetNetStatus(GLMapEngine.this.mNativeMapengineInstance, isNetworkConnected ? 1 : 0);
                }
            });
        }
    }

    public void onClearCache(int i) {
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    public void onMapRender(int i, int i2) {
        if (i2 == 5) {
            IAMapListener iAMapListener = this.mMapListener;
            if (iAMapListener != null) {
                iAMapListener.beforeDrawLabel(i, getMapState(i));
            }
        } else if (i2 == 6) {
            IAMapListener iAMapListener2 = this.mMapListener;
            if (iAMapListener2 != null) {
                iAMapListener2.afterDrawLabel(i, getMapState(i));
            }
        } else if (i2 == 7) {
            IAMapListener iAMapListener3 = this.mMapListener;
            if (iAMapListener3 != null) {
                iAMapListener3.afterRendererOver(i, getMapState(i));
            }
        } else if (i2 == 13) {
            try {
                this.isEngineRenderComplete = true;
            } catch (Throwable unused) {
            }
        }
    }

    public void popRendererState() {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativePopRenderState(1, j);
        }
    }

    public void pushRendererState() {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativePushRendererState(1, j);
        }
    }

    public void putResourceData(int i, byte[] bArr) {
    }

    public synchronized void receiveNetData(int i, long j, byte[] bArr, int i2) {
        if (!this.mRequestDestroy) {
            if (this.aMapLoaderHashtable.containsKey(Long.valueOf(j))) {
                long j2 = this.mNativeMapengineInstance;
                if (j2 != 0) {
                    nativeReceiveNetData(i, j2, bArr, j, i2);
                }
            }
        }
    }

    public void releaseNetworkState() {
        NetworkState networkState = this.mNetworkState;
        if (networkState != null) {
            networkState.registerNetChangeReceiver(this.context.getApplicationContext(), false);
            this.mNetworkState.setNetworkListener(null);
            this.mNetworkState = null;
        }
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    public void reloadMapResource(int i, String str, int i2) {
    }

    public void removeNativeAllOverlay(int i) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeRemoveNativeAllOverlay(i, j);
        }
    }

    public void removeNativeOverlay(int i, String str) {
        long j = this.mNativeMapengineInstance;
        if (j != 0 && str != null) {
            nativeRemoveNativeOverlay(i, j, str);
        }
    }

    public void renderAMap() {
        if (this.mNativeMapengineInstance != 0) {
            boolean processMessage = processMessage();
            synchronized (GLMapEngine.class) {
                nativeRenderAMap(this.mNativeMapengineInstance, 1);
                nativePostRenderAMap(this.mNativeMapengineInstance, 1);
            }
            initAnimation();
            if (processMessage) {
                startCheckEngineRenderComplete();
            }
            if (!this.isEngineRenderComplete) {
                nativeSetRenderListenerStatus(1, this.mNativeMapengineInstance);
            }
        }
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    public byte[] requireCharBitmap(int i, int i2, int i3) {
        return this.mTextTextureGenerator.getTextPixelBuffer(i2, i3);
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    public byte[] requireCharsWidths(int i, int[] iArr, int i2, int i3) {
        return this.mTextTextureGenerator.getCharsWidths(iArr);
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    public void requireMapData(int i, byte[] bArr) {
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    public int requireMapDataAsyn(int i, byte[] bArr) {
        if (!this.mRequestDestroy && bArr != null) {
            AMapLoader.ADataRequestParam aDataRequestParam = new AMapLoader.ADataRequestParam();
            int i2 = GLConvertUtil.getInt(bArr, 0);
            aDataRequestParam.requestBaseUrl = GLConvertUtil.getString(bArr, 4, i2);
            int i3 = i2 + 4;
            int i4 = GLConvertUtil.getInt(bArr, i3);
            int i5 = i3 + 4;
            aDataRequestParam.requestUrl = GLConvertUtil.getString(bArr, i5, i4);
            int i6 = i5 + i4;
            aDataRequestParam.handler = GLConvertUtil.getLong(bArr, i6);
            int i7 = i6 + 8;
            aDataRequestParam.nRequestType = GLConvertUtil.getInt(bArr, i7);
            int i8 = i7 + 4;
            int i9 = GLConvertUtil.getInt(bArr, i8);
            int i10 = i8 + 4;
            aDataRequestParam.enCodeString = GLConvertUtil.getSubBytes(bArr, i10, i9);
            aDataRequestParam.nCompress = GLConvertUtil.getInt(bArr, i10 + i9);
            final AMapLoader aMapLoader = new AMapLoader(i, this, aDataRequestParam);
            synchronized (this) {
                this.aMapLoaderHashtable.put(Long.valueOf(aDataRequestParam.handler), aMapLoader);
            }
            aMapLoader.isFinish = false;
            try {
                ep.a().a(new Runnable() {
                    /* class com.autonavi.base.ae.gmap.GLMapEngine.AnonymousClass1 */

                    public void run() {
                        try {
                            if (GLMapEngine.this.mRequestDestroy) {
                                AMapLoader aMapLoader = aMapLoader;
                                if (aMapLoader != null && !aMapLoader.isFinish) {
                                    synchronized (aMapLoader) {
                                        AMapLoader aMapLoader2 = aMapLoader;
                                        if (!aMapLoader2.isFinish) {
                                            aMapLoader2.notify();
                                            aMapLoader.isFinish = true;
                                        }
                                    }
                                    return;
                                }
                                return;
                            }
                            AMapLoader aMapLoader3 = aMapLoader;
                            if (aMapLoader3 != null) {
                                aMapLoader3.doRequest();
                                AMapLoader aMapLoader4 = aMapLoader;
                                if (aMapLoader4 != null && !aMapLoader4.isFinish) {
                                    synchronized (aMapLoader4) {
                                        AMapLoader aMapLoader5 = aMapLoader;
                                        if (!aMapLoader5.isFinish) {
                                            aMapLoader5.notify();
                                            aMapLoader.isFinish = true;
                                        }
                                    }
                                }
                            } else if (aMapLoader3 != null && !aMapLoader3.isFinish) {
                                synchronized (aMapLoader3) {
                                    AMapLoader aMapLoader6 = aMapLoader;
                                    if (!aMapLoader6.isFinish) {
                                        aMapLoader6.notify();
                                        aMapLoader.isFinish = true;
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            AMapLoader aMapLoader7 = aMapLoader;
                            if (aMapLoader7 != null && !aMapLoader7.isFinish) {
                                synchronized (aMapLoader7) {
                                    AMapLoader aMapLoader8 = aMapLoader;
                                    if (!aMapLoader8.isFinish) {
                                        aMapLoader8.notify();
                                        aMapLoader.isFinish = true;
                                    }
                                }
                            }
                            throw th;
                        }
                    }
                });
                synchronized (aMapLoader) {
                    while (!aMapLoader.isFinish) {
                        aMapLoader.wait();
                    }
                }
            } catch (Throwable th) {
                hd.c(th, "download Thread", "requireMapData");
                eq.a(th);
            }
        }
        return 0;
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    public void requireMapRender(int i, int i2, int i3) {
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    public byte[] requireMapResource(int i, String str) {
        byte[] bArr;
        if (str == null) {
            return null;
        }
        String str2 = "map_assets/" + str;
        try {
            if (this.mGlMapView.getMapConfig().isCustomStyleEnable()) {
                if (str.startsWith("icons_5")) {
                    bArr = FileUtil.readFileContents(this.mGlMapView.getMapConfig().getCustomTextureResourcePath());
                } else if (str.startsWith("bktile")) {
                    bArr = FileUtil.readFileContentsFromAssets(this.context, str2);
                    int customBackgroundColor = this.mGlMapView.getMapConfig().getCustomBackgroundColor();
                    if (customBackgroundColor != 0) {
                        bArr = eq.a(bArr, customBackgroundColor);
                    }
                } else {
                    bArr = null;
                }
                if (bArr != null) {
                    return bArr;
                }
            }
            return FileUtil.readFileContentsFromAssets(this.context, str2);
        } catch (Throwable th) {
            eq.a(th);
            return null;
        }
    }

    public void setAllContentEnable(int i, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            if (z) {
                nativeSetAllContentEnable(i, j, true);
            } else {
                nativeSetAllContentEnable(i, j, false);
            }
            setSimple3DEnable(i, false);
        }
    }

    public void setBackgroundTexture(int i, byte[] bArr) {
        if (bArr != null) {
            long j = this.mNativeMapengineInstance;
            if (j != 0) {
                nativeSetSetBackgroundTexture(i, j, bArr);
            }
        }
    }

    public void setBuildingEnable(int i, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetBuildingEnable(i, j, z);
        }
    }

    public void setBuildingTextureEnable(int i, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetBuildingTextureEnable(i, j, z);
        }
    }

    public void setCustomStyleData(int i, byte[] bArr, byte[] bArr2) {
        if (bArr != null) {
            long j = this.mNativeMapengineInstance;
            if (j != 0) {
                nativeSetCustomStyleData(i, j, bArr, bArr2);
            }
        }
    }

    public void setCustomStyleTexture(int i, byte[] bArr) {
        if (bArr != null) {
            long j = this.mNativeMapengineInstance;
            if (j != 0) {
                nativeSetCustomStyleTexture(i, j, bArr);
            }
        }
    }

    public void setHighlightSubwayEnable(int i, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetHighlightSubwayEnable(i, j, z);
        }
    }

    public void setIndoorBuildingToBeActive(int i, String str, int i2, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            long j = this.mNativeMapengineInstance;
            if (j != 0) {
                nativeSetIndoorBuildingToBeActive(i, j, str, i2, str2);
            }
        }
    }

    public void setIndoorEnable(int i, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetIndoorEnable(i, j, z);
        }
    }

    public void setInternaltexture(int i, byte[] bArr, int i2) {
    }

    public void setLabelEnable(int i, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetLabelEnable(i, j, z);
        }
    }

    public void setMapListener(IAMapListener iAMapListener) {
        this.mMapListener = iAMapListener;
    }

    public void setMapLoaderToTask(int i, long j, AMapLoader aMapLoader) {
    }

    public boolean setMapModeAndStyle(int i, int i2, int i3, int i4, boolean z, boolean z2, StyleItem[] styleItemArr) {
        if (this.mNativeMapengineInstance == 0) {
            return false;
        }
        boolean nativeMapModeAndStyle = setNativeMapModeAndStyle(i, i2, i3, i4, z, z2, styleItemArr);
        if (styleItemArr != null && z2) {
            int customBackgroundColor = this.mGlMapView.getMapConfig().getCustomBackgroundColor();
            if (customBackgroundColor != 0) {
                Context context2 = this.context;
                setBackgroundTexture(i, eq.a(FileUtil.readFileContentsFromAssets(context2, AMapEngineUtils.MAP_MAP_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_BACKGROUND_NAME), customBackgroundColor));
            }
            String customTextureResourcePath = this.mGlMapView.getMapConfig().getCustomTextureResourcePath();
            if (this.mGlMapView.getMapConfig().isProFunctionAuthEnable() && !TextUtils.isEmpty(customTextureResourcePath)) {
                this.mGlMapView.getMapConfig().setUseProFunction(true);
                setCustomStyleTexture(i, FileUtil.readFileContents(customTextureResourcePath));
            }
        } else if (i2 == 0 && i3 == 0 && i4 == 0) {
            Context context3 = this.context;
            StringBuilder sb = new StringBuilder();
            sb.append(AMapEngineUtils.MAP_MAP_ASSETS_NAME);
            String str = File.separator;
            sb.append(str);
            sb.append(AMapEngineUtils.MAP_MAP_ASSETS_BACKGROUND_NAME);
            setBackgroundTexture(i, FileUtil.readFileContentsFromAssets(context3, sb.toString()));
            Context context4 = this.context;
            setCustomStyleTexture(i, FileUtil.readFileContentsFromAssets(context4, AMapEngineUtils.MAP_MAP_ASSETS_NAME + str + AMapEngineUtils.MAP_MAP_ASSETS_ICON_5_NAME));
        }
        return nativeMapModeAndStyle;
    }

    public void setMapOpenLayer(String str) {
        long j = this.mNativeMapengineInstance;
        if (j != 0 && str != null) {
            nativesetMapOpenLayer(1, j, str.getBytes());
        }
    }

    public void setMapState(int i, GLMapState gLMapState) {
        setMapState(i, gLMapState, true);
    }

    public boolean setNativeMapModeAndStyle(int i, int i2, int i3, int i4, boolean z, boolean z2, StyleItem[] styleItemArr) {
        long j = this.mNativeMapengineInstance;
        if (j == 0) {
            return false;
        }
        return nativeSetMapModeAndStyle(i, j, new int[]{i2, i3, i4, 0, 0}, z, z2, styleItemArr);
    }

    public void setNaviLabelEnable(int i, boolean z, int i2, int i3) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetNaviLabelEnable(i, j, z, i2, i3);
        }
    }

    public void setOfflineDataEnable(int i, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetOfflineDataEnable(i, j, z);
        }
    }

    public void setOvelayBundle(int i, GLOverlayBundle<BaseMapOverlay<?, ?>> gLOverlayBundle) {
        this.bundle = gLOverlayBundle;
    }

    public void setParamater(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mLock.lock();
        try {
            long j = this.mNativeMapengineInstance;
            if (j != 0) {
                nativeSetParameter(i, j, i2, i3, i4, i5, i6);
            }
        } finally {
            this.mLock.unlock();
        }
    }

    public void setProjectionCenter(int i, int i2, int i3) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetProjectionCenter(i, j, (float) i2, (float) i3);
        }
    }

    public void setRoadArrowEnable(int i, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetRoadArrowEnable(i, j, z);
        }
    }

    public void setServiceViewRect(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        nativeSetServiceViewRect(i, this.mNativeMapengineInstance, i2, i3, i4, i5, i6, i7);
    }

    public void setSimple3DEnable(int i, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetSimple3DEnable(i, j, z);
        }
    }

    public void setSkyTexture(int i, byte[] bArr) {
        if (bArr != null) {
            long j = this.mNativeMapengineInstance;
            if (j != 0) {
                nativeSetSkyTexture(i, j, bArr);
            }
        }
    }

    public void setSrvViewStateBoolValue(int i, int i2, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetSrvViewStateBoolValue(i, j, i2, z);
        }
    }

    public void setTrafficEnable(int i, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetTrafficEnable(i, j, z);
        }
    }

    public void setTrafficStyle(int i, int i2, int i3, int i4, int i5, boolean z) {
        if (this.mNativeMapengineInstance != 0) {
            Context context2 = this.context;
            byte[] readFileContentsFromAssets = FileUtil.readFileContentsFromAssets(context2, AMapEngineUtils.MAP_MAP_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_TRL_NAME);
            if (z) {
                nativeSetTrafficTextureAllInOne(i, this.mNativeMapengineInstance, eq.a(readFileContentsFromAssets, new int[]{i4, i5, i3, i2}));
                return;
            }
            nativeSetTrafficTextureAllInOne(i, this.mNativeMapengineInstance, readFileContentsFromAssets);
        }
    }

    public void startCheckEngineRenderComplete() {
        this.isEngineRenderComplete = false;
    }

    public void startMapSlidAnim(int i, Point point, float f, float f2) {
        if (point != null) {
            try {
                clearAnimations(i, true);
                GLMapState cloneMapState = getCloneMapState();
                cloneMapState.reset();
                cloneMapState.recalculate();
                float abs = Math.abs(f);
                float abs2 = Math.abs(f2);
                int i2 = (abs > abs2 ? 1 : (abs == abs2 ? 0 : -1));
                float f3 = i2 > 0 ? abs : abs2;
                float f4 = (float) ExtraID.ERRCODE_PARSER_SEEK_BUFFER_ERR;
                if (f3 > f4) {
                    if (i2 > 0) {
                        f = f > 0.0f ? f4 : (float) -12000;
                        f2 *= f4 / abs;
                    } else {
                        f *= f4 / abs2;
                        f2 = f2 > 0.0f ? f4 : (float) -12000;
                    }
                }
                int mapWidth = this.mGlMapView.getMapWidth() >> 1;
                int mapHeight = this.mGlMapView.getMapHeight() >> 1;
                if (this.mGlMapView.isUseAnchor()) {
                    mapWidth = this.mGlMapView.getMapConfig().getAnchorX();
                    mapHeight = this.mGlMapView.getMapConfig().getAnchorY();
                }
                AdglMapAnimFling adglMapAnimFling = new AdglMapAnimFling(500, mapWidth, mapHeight);
                adglMapAnimFling.setPositionAndVelocity(f, f2);
                adglMapAnimFling.commitAnimation(cloneMapState);
                this.mapAnimationMgr.addAnimation(adglMapAnimFling, null);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void startPivotZoomRotateAnim(int i, Point point, float f, int i2, int i3) {
    }

    public void updateNativeArrowOverlay(int i, String str, int[] iArr, int[] iArr2, int i2, int i3, int i4, float f, int i5, int i6, int i7, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0 && str != null) {
            nativeUpdateNativeArrowOverlay(i, j, str, iArr, iArr2, i2, i3, i4, f, z, i5, i6, i7);
        }
    }

    public void clearAnimations(int i, boolean z, int i2) {
        this.mapAnimationMgr.clearAnimations();
    }

    public void setMapState(int i, GLMapState gLMapState, boolean z) {
        IAMapDelegate iAMapDelegate;
        if (this.mNativeMapengineInstance != 0) {
            if (!(!z || (iAMapDelegate = this.mGlMapView) == null || iAMapDelegate.getMapConfig() == null)) {
                this.mGlMapView.checkMapState(gLMapState);
            }
            this.mLock.lock();
            try {
                gLMapState.setNativeMapengineState(i, this.mNativeMapengineInstance);
            } finally {
                this.mLock.unlock();
            }
        }
    }

    public void addOverlayTexture(int i, Bitmap bitmap, int i2, int i3) {
        GLTextureProperty gLTextureProperty = new GLTextureProperty();
        gLTextureProperty.mId = i2;
        gLTextureProperty.mAnchor = i3;
        gLTextureProperty.mBitmap = bitmap;
        gLTextureProperty.mXRatio = 0.0f;
        gLTextureProperty.mYRatio = 0.0f;
        gLTextureProperty.isGenMimps = true;
        addOverlayTexture(i, gLTextureProperty);
    }

    public void setTrafficStyle(int i, int i2, int i3, int i4, int i5) {
        setTrafficStyle(i, i2, i3, i4, i5, true);
    }
}
