package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import com.amap.api.mapcore.util.b;
import com.amap.api.mapcore.util.di;
import com.amap.api.mapcore.util.fb;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.CustomRenderer;
import com.amap.api.maps.InfoWindowAnimationManager;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.Projection;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.AMapCameraInfo;
import com.amap.api.maps.model.AMapGestureListener;
import com.amap.api.maps.model.Arc;
import com.amap.api.maps.model.ArcOptions;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BuildingOverlay;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.CrossOverlay;
import com.amap.api.maps.model.CrossOverlayOptions;
import com.amap.api.maps.model.CustomMapStyleOptions;
import com.amap.api.maps.model.GL3DModel;
import com.amap.api.maps.model.GL3DModelOptions;
import com.amap.api.maps.model.GroundOverlay;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.amap.api.maps.model.HeatMapLayer;
import com.amap.api.maps.model.HeatMapLayerOptions;
import com.amap.api.maps.model.HeatmapTileProvider;
import com.amap.api.maps.model.IndoorBuildingInfo;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MultiPointOverlay;
import com.amap.api.maps.model.MultiPointOverlayOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.MyTrafficStyle;
import com.amap.api.maps.model.NavigateArrow;
import com.amap.api.maps.model.NavigateArrowOptions;
import com.amap.api.maps.model.Poi;
import com.amap.api.maps.model.Polygon;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.model.RouteOverlay;
import com.amap.api.maps.model.Text;
import com.amap.api.maps.model.TextOptions;
import com.amap.api.maps.model.TileOverlay;
import com.amap.api.maps.model.TileOverlayOptions;
import com.amap.api.maps.model.TileProvider;
import com.amap.api.maps.model.animation.Animation;
import com.amap.api.maps.model.particle.ParticleOverlay;
import com.amap.api.maps.model.particle.ParticleOverlayOptions;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.api.mapcore.overlays.IBuildingDelegate;
import com.autonavi.amap.api.mapcore.overlays.IParticleLatyer;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.autonavi.amap.mapcore.animation.GLAlphaAnimation;
import com.autonavi.amap.mapcore.interfaces.IHeatMapLayer;
import com.autonavi.amap.mapcore.interfaces.IMarkerAction;
import com.autonavi.amap.mapcore.interfaces.IMultiPointOverlay;
import com.autonavi.base.ae.gmap.GLMapEngine;
import com.autonavi.base.ae.gmap.GLMapRender;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.base.ae.gmap.glinterface.MapLabelItem;
import com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay;
import com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay;
import com.autonavi.base.ae.gmap.gloverlay.GLOverlayBundle;
import com.autonavi.base.ae.gmap.gloverlay.GLTextureProperty;
import com.autonavi.base.ae.gmap.listener.AMapWidgetListener;
import com.autonavi.base.ae.gmap.style.StyleItem;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;
import com.autonavi.base.amap.api.mapcore.IProjectionDelegate;
import com.autonavi.base.amap.api.mapcore.IUiSettingsDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.IArcDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.ICircleDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.IGroundOverlayDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.IMarkerDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.INavigateArrowDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.IPolygonDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.IPolylineDelegate;
import com.autonavi.base.amap.mapcore.AMapNativeRenderer;
import com.autonavi.base.amap.mapcore.AeUtil;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.FileUtil;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.autonavi.base.amap.mapcore.Rectangle;
import com.autonavi.base.amap.mapcore.interfaces.IAMapListener;
import com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage;
import com.autonavi.base.amap.mapcore.tools.GLConvertUtil;
import com.taobao.weex.common.Constants;
import com.uc.crashsdk.export.LogType;
import com.youku.live.livesdk.wkit.component.Constants;
import com.youku.uplayer.AliMediaPlayer;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import tb.jl1;
import tb.v;

/* compiled from: Taobao */
public class c implements b.a, di.a, IAMapDelegate, IAMapListener {
    private AMap.OnMapTouchListener A;
    private AMap.OnPOIClickListener B;
    private AMap.OnMapLongClickListener C;
    private AMap.OnInfoWindowClickListener D;
    private AMap.OnIndoorBuildingActiveListener E;
    private AMap.OnMyLocationChangeListener F;
    private h G;
    private AMapWidgetListener H;
    private List<AMap.OnMarkerClickListener> I;
    private List<AMap.OnPolylineClickListener> J;
    private List<AMap.OnMarkerDragListener> K;
    private List<AMap.OnMapLoadedListener> L;
    private List<AMap.OnCameraChangeListener> M;
    private List<AMap.OnMapClickListener> N;
    private List<AMap.OnMapTouchListener> O;
    private List<AMap.OnPOIClickListener> P;
    private List<AMap.OnMapLongClickListener> Q;
    private List<AMap.OnInfoWindowClickListener> R;
    private List<AMap.OnIndoorBuildingActiveListener> S;
    private List<AMap.OnMyLocationChangeListener> T;
    private List<AMap.onMapPrintScreenListener> U;
    private List<AMap.OnMapScreenShotListener> V;
    private AMapGestureListener W;
    private ar X;
    private da Y;
    private UiSettings Z;
    protected boolean a;
    private boolean aA;
    private Rect aB;
    private int aC;
    private MyTrafficStyle aD;
    private Thread aE;
    private Thread aF;
    private boolean aG;
    private boolean aH;
    private boolean aI;
    private int aJ;
    private CustomRenderer aK;
    private final v aL;
    private int aM;
    private int aN;
    private List<x> aO;
    private dg aP;
    private di aQ;
    private g aR;
    private GLMapRender aS;
    private p aT;
    private boolean aU;
    private float aV;
    private float aW;
    private float aX;
    private boolean aY;
    private boolean aZ;
    private IProjectionDelegate aa;
    private final ac ab;
    private boolean ac;
    private final IGLSurfaceView ad;
    private fd ae;
    private ab af;
    private Object ag;
    private final r ah;
    private boolean ai;
    private int aj;
    private boolean ak;
    private o al;
    private List<AMapWidgetListener> am;
    private boolean an;
    private boolean ao;
    private boolean ap;
    private cv aq;
    private LocationSource ar;
    private boolean as;
    private Marker at;
    private BaseOverlayImp au;
    private boolean av;
    private boolean aw;
    private boolean ax;
    private boolean ay;
    private boolean az;
    protected final u b;
    private Runnable bA;
    private a bB;
    private a bC;
    private jp bD;
    private String bE;
    private String bF;
    private EAMapPlatformGestureInfo bG;
    private long bH;
    private aq bI;
    private IPoint[] bJ;
    private boolean ba;
    private int bb;
    private volatile boolean bc;
    private volatile boolean bd;
    private boolean be;
    private boolean bf;
    private Lock bg;
    private int bh;
    private int bi;
    private int bj;
    private b bk;
    private de bl;
    private s bm;
    private ax bn;
    private b bo;
    private long bp;
    private a bq;
    private a br;
    private a bs;
    private a bt;
    private a bu;
    private a bv;
    private a bw;
    private a bx;
    private a by;
    private a bz;
    protected MapConfig c;
    protected aq d;
    eh e;
    protected Context f;
    protected GLMapEngine g;
    public int h;
    public int i;
    protected final Handler j;
    Point k;
    Rect l;
    protected String m;
    float[] n;
    float[] o;
    float[] p;
    float[] q;
    String r;
    String s;
    int t;
    private AMap.OnMarkerClickListener u;
    private AMap.OnPolylineClickListener v;
    private AMap.OnMarkerDragListener w;
    private AMap.OnMapLoadedListener x;
    private AMap.OnCameraChangeListener y;
    private AMap.OnMapClickListener z;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static abstract class a implements Runnable {
        boolean b;
        boolean c;
        int d;
        int e;
        int f;
        int g;
        int h;
        int i;

        private a() {
            this.b = false;
            this.c = false;
            this.h = 0;
            this.i = 0;
        }

        public void run() {
            this.b = false;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b {
        b() {
        }

        public void a(aq aqVar) {
            aq aqVar2;
            aq aqVar3;
            int[] iArr;
            String[] strArr;
            MapConfig mapConfig = c.this.c;
            if (mapConfig != null && mapConfig.isIndoorEnable()) {
                final fb e = c.this.ae.e();
                float f = 20.0f;
                if (aqVar == null) {
                    try {
                        if (c.this.S != null && c.this.S.size() > 0) {
                            for (int i = 0; i < c.this.S.size(); i++) {
                                ((AMap.OnIndoorBuildingActiveListener) c.this.S.get(i)).OnIndoorBuilding(aqVar);
                            }
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    aq aqVar4 = c.this.d;
                    if (aqVar4 != null) {
                        aqVar4.g = null;
                    }
                    if (e.d()) {
                        c.this.j.post(new Runnable() {
                            /* class com.amap.api.mapcore.util.c.b.AnonymousClass1 */

                            public void run() {
                                e.a(false);
                            }
                        });
                    }
                    MapConfig mapConfig2 = c.this.c;
                    mapConfig2.maxZoomLevel = mapConfig2.isSetLimitZoomLevel() ? c.this.c.getMaxZoomLevel() : 20.0f;
                    try {
                        if (c.this.ab.isZoomControlsEnabled() && c.this.am != null && c.this.am.size() > 0) {
                            for (int i2 = 0; i2 < c.this.am.size(); i2++) {
                                ((AMapWidgetListener) c.this.am.get(i2)).invalidateZoomController(c.this.c.getSZ());
                            }
                            return;
                        }
                        return;
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
                if (aqVar != null && (iArr = aqVar.floor_indexs) != null && (strArr = aqVar.floor_names) != null && iArr.length == strArr.length) {
                    int i3 = 0;
                    while (true) {
                        int[] iArr2 = aqVar.floor_indexs;
                        if (i3 >= iArr2.length) {
                            break;
                        } else if (aqVar.activeFloorIndex == iArr2[i3]) {
                            aqVar.activeFloorName = aqVar.floor_names[i3];
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
                if (aqVar == null || (aqVar3 = c.this.d) == null || aqVar3.activeFloorIndex == aqVar.activeFloorIndex || !e.d()) {
                    if (aqVar != null && ((aqVar2 = c.this.d) == null || !aqVar2.poiid.equals(aqVar.poiid) || c.this.d.g == null)) {
                        c cVar = c.this;
                        cVar.d = aqVar;
                        if (cVar.c != null) {
                            if (aqVar.g == null) {
                                aqVar.g = new Point();
                            }
                            DPoint mapGeoCenter = c.this.c.getMapGeoCenter();
                            if (mapGeoCenter != null) {
                                Point point = c.this.d.g;
                                point.x = (int) mapGeoCenter.x;
                                point.y = (int) mapGeoCenter.y;
                            }
                        }
                    }
                    try {
                        if (c.this.S != null && c.this.S.size() > 0) {
                            for (int i4 = 0; i4 < c.this.S.size(); i4++) {
                                ((AMap.OnIndoorBuildingActiveListener) c.this.S.get(i4)).OnIndoorBuilding(aqVar);
                            }
                        }
                        MapConfig mapConfig3 = c.this.c;
                        if (mapConfig3.isSetLimitZoomLevel()) {
                            f = c.this.c.getMaxZoomLevel();
                        }
                        mapConfig3.maxZoomLevel = f;
                        if (c.this.ab.isZoomControlsEnabled() && c.this.am != null && c.this.am.size() > 0) {
                            for (int i5 = 0; i5 < c.this.am.size(); i5++) {
                                ((AMapWidgetListener) c.this.am.get(i5)).invalidateZoomController(c.this.c.getSZ());
                            }
                        }
                        if (c.this.ab.isIndoorSwitchEnabled()) {
                            if (!e.d()) {
                                c.this.ab.setIndoorSwitchEnabled(true);
                            }
                            c.this.j.post(new Runnable() {
                                /* class com.amap.api.mapcore.util.c.b.AnonymousClass2 */

                                public void run() {
                                    try {
                                        e.a(c.this.d.floor_names);
                                        e.a(c.this.d.activeFloorName);
                                        if (!e.d()) {
                                            e.a(true);
                                        }
                                    } catch (Throwable th) {
                                        th.printStackTrace();
                                    }
                                }
                            });
                        } else if (!c.this.ab.isIndoorSwitchEnabled() && e.d()) {
                            c.this.ab.setIndoorSwitchEnabled(false);
                        }
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                }
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.util.c$c  reason: collision with other inner class name */
    /* compiled from: Taobao */
    private class C0145c implements fb.a {
        private C0145c() {
        }

        @Override // com.amap.api.mapcore.util.fb.a
        public void a(int i) {
            c cVar = c.this;
            aq aqVar = cVar.d;
            if (aqVar != null) {
                aqVar.activeFloorIndex = aqVar.floor_indexs[i];
                aqVar.activeFloorName = aqVar.floor_names[i];
                try {
                    cVar.setIndoorBuildingInfo(aqVar);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class d implements Runnable {
        private Context b;
        private AMap.OnCacheRemoveListener c;

        public d(Context context, AMap.OnCacheRemoveListener onCacheRemoveListener) {
            this.b = context;
            this.c = onCacheRemoveListener;
        }

        public boolean equals(Object obj) {
            return obj instanceof d;
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x004a  */
        public void run() {
            Throwable th;
            AMap.OnCacheRemoveListener onCacheRemoveListener;
            AMap.OnCacheRemoveListener onCacheRemoveListener2;
            boolean z;
            AMap.OnCacheRemoveListener onCacheRemoveListener3;
            boolean z2 = true;
            try {
                Context applicationContext = this.b.getApplicationContext();
                String c2 = eq.c(applicationContext);
                String a2 = eq.a(applicationContext);
                File file = new File(c2);
                boolean z3 = !file.exists() || FileUtil.deleteFile(file);
                if (z3) {
                    try {
                        if (FileUtil.deleteFile(new File(a2))) {
                            z = true;
                            if (!z || !eq.e(applicationContext)) {
                                z2 = false;
                            }
                            if (c.this.af != null) {
                                c.this.af.i();
                            }
                            if (c.this.g != null && (onCacheRemoveListener3 = this.c) != null) {
                                onCacheRemoveListener3.onRemoveCacheFinish(z2);
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        z2 = z3;
                        try {
                            eq.a(th);
                            hd.c(th, "AMapDelegateImp", "RemoveCacheRunnable");
                            if (c.this.g != null) {
                                return;
                            }
                            return;
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                        }
                    }
                }
                z = false;
                z2 = false;
                if (c.this.af != null) {
                }
                try {
                    if (c.this.g != null) {
                        return;
                    }
                    return;
                } catch (Throwable th4) {
                    th4.printStackTrace();
                    return;
                }
            } catch (Throwable th5) {
                th = th5;
                eq.a(th);
                hd.c(th, "AMapDelegateImp", "RemoveCacheRunnable");
                if (c.this.g != null && (onCacheRemoveListener2 = this.c) != null) {
                    onCacheRemoveListener2.onRemoveCacheFinish(false);
                    return;
                }
                return;
            }
            throw th;
        }
    }

    public c(IGLSurfaceView iGLSurfaceView, Context context, AttributeSet attributeSet) {
        this(iGLSurfaceView, context, attributeSet, false);
    }

    private void j(int i2) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void accelerateNetworkInChinese(boolean z2) {
        jp jpVar = this.bD;
        if (jpVar != null) {
            jpVar.a("accelerateNetworkInChinese", Boolean.valueOf(z2));
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public Arc addArc(ArcOptions arcOptions) throws RemoteException {
        try {
            resetRenderTime();
            IArcDelegate a2 = this.ah.a(arcOptions);
            if (a2 != null) {
                return new Arc(a2);
            }
            return null;
        } catch (Throwable th) {
            eq.a(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public BuildingOverlay addBuildingOverlay() {
        try {
            IBuildingDelegate a2 = this.ah.a();
            eo.g(this.f);
            if (a2 != null) {
                return new BuildingOverlay(a2);
            }
            return null;
        } catch (RemoteException e2) {
            eq.a(e2);
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public Circle addCircle(CircleOptions circleOptions) throws RemoteException {
        try {
            resetRenderTime();
            ICircleDelegate a2 = this.ah.a(circleOptions);
            if (a2 != null) {
                return new Circle(a2);
            }
            return null;
        } catch (Throwable th) {
            eq.a(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public CrossOverlay addCrossVector(CrossOverlayOptions crossOverlayOptions) {
        if (crossOverlayOptions == null || crossOverlayOptions.getRes() == null) {
            return null;
        }
        CrossVectorOverlay crossVectorOverlay = new CrossVectorOverlay(1, getContext(), this);
        crossVectorOverlay.setAttribute(crossOverlayOptions.getAttribute());
        GLMapEngine gLMapEngine = this.g;
        if (gLMapEngine != null) {
            gLMapEngine.getOverlayBundle(1).addOverlay(crossVectorOverlay);
            crossVectorOverlay.resumeMarker(crossOverlayOptions.getRes());
        }
        return new CrossOverlay(crossOverlayOptions, crossVectorOverlay);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public GL3DModel addGLModel(GL3DModelOptions gL3DModelOptions) {
        return this.al.a(gL3DModelOptions);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void addGestureMapMessage(int i2, AbstractGestureMapMessage abstractGestureMapMessage) {
        if (this.bc && this.g != null) {
            try {
                abstractGestureMapMessage.isUseAnchor = this.ao;
                abstractGestureMapMessage.anchorX = this.c.getAnchorX();
                abstractGestureMapMessage.anchorY = this.c.getAnchorY();
                this.g.addGestureMessage(i2, abstractGestureMapMessage, this.ab.isGestureScaleByMapCenter(), this.c.getAnchorX(), this.c.getAnchorY());
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) throws RemoteException {
        try {
            resetRenderTime();
            IGroundOverlayDelegate a2 = this.ah.a(groundOverlayOptions);
            if (a2 != null) {
                return new GroundOverlay(a2);
            }
            return null;
        } catch (Throwable th) {
            eq.a(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public HeatMapLayer addHeatMapLayer(HeatMapLayerOptions heatMapLayerOptions) throws RemoteException {
        try {
            resetRenderTime();
            IHeatMapLayer a2 = this.ah.a(heatMapLayerOptions);
            if (a2 != null) {
                return new HeatMapLayer(a2);
            }
            return null;
        } catch (Throwable th) {
            eq.a(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public Marker addMarker(MarkerOptions markerOptions) throws RemoteException {
        try {
            resetRenderTime();
            return this.b.a(markerOptions);
        } catch (Throwable th) {
            eq.a(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public ArrayList<Marker> addMarkers(ArrayList<MarkerOptions> arrayList, boolean z2) throws RemoteException {
        try {
            resetRenderTime();
            return this.b.a(arrayList, z2);
        } catch (Throwable th) {
            eq.a(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public MultiPointOverlay addMultiPointOverlay(MultiPointOverlayOptions multiPointOverlayOptions) throws RemoteException {
        try {
            resetRenderTime();
            IMultiPointOverlay a2 = this.bn.a(multiPointOverlayOptions);
            if (a2 != null) {
                return new MultiPointOverlay(a2);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public RouteOverlay addNaviRouteOverlay() {
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public NavigateArrow addNavigateArrow(NavigateArrowOptions navigateArrowOptions) throws RemoteException {
        try {
            resetRenderTime();
            INavigateArrowDelegate a2 = this.ah.a(navigateArrowOptions);
            if (a2 != null) {
                return new NavigateArrow(a2);
            }
            return null;
        } catch (Throwable th) {
            eq.a(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void addOnCameraChangeListener(AMap.OnCameraChangeListener onCameraChangeListener) throws RemoteException {
        a(this.M, onCameraChangeListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void addOnIndoorBuildingActiveListener(AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) throws RemoteException {
        a(this.S, onIndoorBuildingActiveListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void addOnInfoWindowClickListener(AMap.OnInfoWindowClickListener onInfoWindowClickListener) throws RemoteException {
        a(this.R, onInfoWindowClickListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void addOnMapClickListener(AMap.OnMapClickListener onMapClickListener) throws RemoteException {
        a(this.N, onMapClickListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void addOnMapLoadedListener(AMap.OnMapLoadedListener onMapLoadedListener) {
        a(this.L, onMapLoadedListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void addOnMapLongClickListener(AMap.OnMapLongClickListener onMapLongClickListener) throws RemoteException {
        a(this.Q, onMapLongClickListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void addOnMapTouchListener(AMap.OnMapTouchListener onMapTouchListener) throws RemoteException {
        a(this.O, onMapTouchListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void addOnMarkerClickListener(AMap.OnMarkerClickListener onMarkerClickListener) throws RemoteException {
        a(this.I, onMarkerClickListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void addOnMarkerDragListener(AMap.OnMarkerDragListener onMarkerDragListener) {
        a(this.K, onMarkerDragListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void addOnMyLocationChangeListener(AMap.OnMyLocationChangeListener onMyLocationChangeListener) throws RemoteException {
        a(this.T, onMyLocationChangeListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void addOnPOIClickListener(AMap.OnPOIClickListener onPOIClickListener) throws RemoteException {
        a(this.P, onPOIClickListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void addOnPolylineClickListener(AMap.OnPolylineClickListener onPolylineClickListener) throws RemoteException {
        a(this.J, onPolylineClickListener);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void addOverlayTexture(int i2, GLTextureProperty gLTextureProperty) {
        GLOverlayBundle overlayBundle;
        try {
            GLMapEngine gLMapEngine = this.g;
            if (gLMapEngine != null && (overlayBundle = gLMapEngine.getOverlayBundle(i2)) != null && gLTextureProperty != null) {
                if (gLTextureProperty.mBitmap != null) {
                    this.g.addOverlayTexture(i2, gLTextureProperty);
                    overlayBundle.addOverlayTextureItem(gLTextureProperty.mId, gLTextureProperty.mAnchor, gLTextureProperty.mXRatio, gLTextureProperty.mYRatio, gLTextureProperty.mBitmap.getWidth(), gLTextureProperty.mBitmap.getHeight());
                }
            }
        } catch (Throwable th) {
            eq.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public ParticleOverlay addParticleOverlay(ParticleOverlayOptions particleOverlayOptions) {
        try {
            IParticleLatyer a2 = this.ah.a(particleOverlayOptions);
            if (a2 == null) {
                return null;
            }
            eo.c(this.f);
            return new ParticleOverlay(a2);
        } catch (RemoteException e2) {
            eq.a(e2);
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public Polygon addPolygon(PolygonOptions polygonOptions) throws RemoteException {
        try {
            resetRenderTime();
            IPolygonDelegate a2 = this.ah.a(polygonOptions);
            if (a2 != null) {
                return new Polygon(a2);
            }
            return null;
        } catch (Throwable th) {
            eq.a(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public Polyline addPolyline(PolylineOptions polylineOptions) throws RemoteException {
        try {
            resetRenderTime();
            IPolylineDelegate a2 = this.ah.a(polylineOptions);
            if (a2 != null) {
                return new Polyline(a2);
            }
            return null;
        } catch (Throwable th) {
            eq.a(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public Text addText(TextOptions textOptions) throws RemoteException {
        try {
            resetRenderTime();
            return this.b.a(textOptions);
        } catch (Throwable th) {
            eq.a(th);
            return null;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void addTextureItem(x xVar) {
        if (xVar != null && xVar.k() != 0) {
            synchronized (this.aO) {
                this.aO.add(xVar);
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions) throws RemoteException {
        try {
            synchronized (this.ag) {
                if (this.af == null) {
                    this.af = new ab(this.f, this);
                }
            }
            if (this.af == null) {
                return null;
            }
            TileProvider tileProvider = tileOverlayOptions.getTileProvider();
            if (tileProvider != null && (tileProvider instanceof HeatmapTileProvider)) {
                eo.a(this.f);
            }
            return this.af.a(tileOverlayOptions);
        } catch (Throwable th) {
            eq.a(th);
            return null;
        }
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public void afterAnimation() {
        redrawInfoWindow();
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public void afterDrawFrame(int i2, GLMapState gLMapState) {
        float mapZoomer = gLMapState.getMapZoomer();
        GLMapEngine gLMapEngine = this.g;
        if (!(gLMapEngine != null && (gLMapEngine.isInMapAction(i2) || this.g.isInMapAnimation(i2)))) {
            int i3 = this.aN;
            if (i3 != -1) {
                this.aS.setRenderFps((float) i3);
            } else {
                this.aS.setRenderFps(15.0f);
            }
            if (this.bb == 1) {
                this.bb = 0;
            }
            if (this.aV != mapZoomer) {
                this.aV = mapZoomer;
            }
        }
        if (!this.bf) {
            this.bf = true;
        }
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public void afterDrawLabel(int i2, GLMapState gLMapState) {
        a();
        jp jpVar = this.bD;
        if (jpVar != null) {
            jpVar.a(gLMapState, this.c);
        }
        GLMapEngine gLMapEngine = this.g;
        if (gLMapEngine != null) {
            gLMapEngine.pushRendererState();
        }
        ab abVar = this.af;
        if (abVar != null) {
            abVar.b();
        }
        this.ah.a(false, this.aJ);
        ax axVar = this.bn;
        if (axVar != null) {
            axVar.a(this.c, getViewMatrix(), getProjectionMatrix());
        }
        o oVar = this.al;
        if (oVar != null) {
            oVar.a();
        }
        u uVar = this.b;
        if (uVar != null) {
            uVar.a(false);
        }
        da daVar = this.Y;
        if (daVar != null) {
            daVar.b(getMapWidth(), getMapHeight());
        }
        GLMapEngine gLMapEngine2 = this.g;
        if (gLMapEngine2 != null) {
            gLMapEngine2.popRendererState();
        }
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public void afterRendererOver(int i2, GLMapState gLMapState) {
        GLMapEngine gLMapEngine = this.g;
        if (gLMapEngine != null) {
            gLMapEngine.pushRendererState();
        }
        u uVar = this.b;
        if (uVar != null) {
            uVar.a(true);
        }
        GLMapEngine gLMapEngine2 = this.g;
        if (gLMapEngine2 != null) {
            gLMapEngine2.popRendererState();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void animateCamera(CameraUpdate cameraUpdate) throws RemoteException {
        if (cameraUpdate != null) {
            animateCamera(cameraUpdate.getCameraUpdateFactoryDelegate());
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void animateCameraWithCallback(CameraUpdate cameraUpdate, AMap.CancelableCallback cancelableCallback) throws RemoteException {
        if (cameraUpdate != null) {
            animateCameraWithDurationAndCallback(cameraUpdate, 250, cancelableCallback);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void animateCameraWithDurationAndCallback(CameraUpdate cameraUpdate, long j2, AMap.CancelableCallback cancelableCallback) {
        if (cameraUpdate != null) {
            animateCameraWithDurationAndCallback(cameraUpdate.getCameraUpdateFactoryDelegate(), j2, cancelableCallback);
        }
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public void beforeDrawLabel(int i2, GLMapState gLMapState) {
        a();
        GLMapEngine gLMapEngine = this.g;
        if (gLMapEngine != null) {
            gLMapEngine.pushRendererState();
        }
        this.ah.a(true, this.aJ);
        GLMapEngine gLMapEngine2 = this.g;
        if (gLMapEngine2 != null) {
            gLMapEngine2.popRendererState();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public Pair<Float, LatLng> calculateZoomToSpanLevel(int i2, int i3, int i4, int i5, LatLng latLng, LatLng latLng2) {
        if (latLng != null && latLng2 != null && i2 == i3 && i3 == i4 && i4 == i5 && latLng.latitude == latLng2.latitude && latLng.longitude == latLng2.longitude) {
            return new Pair<>(Float.valueOf(getMaxZoomLevel()), latLng);
        }
        MapConfig mapConfig = getMapConfig();
        if (latLng == null || latLng2 == null || !this.bc || this.ak) {
            DPoint obtain = DPoint.obtain();
            GLMapState.geo2LonLat((int) mapConfig.getSX(), (int) mapConfig.getSY(), obtain);
            Pair<Float, LatLng> pair = new Pair<>(Float.valueOf(mapConfig.getSZ()), new LatLng(obtain.y, obtain.x));
            obtain.recycle();
            return pair;
        }
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(latLng);
        builder.include(latLng2);
        GLMapState gLMapState = new GLMapState(1, this.g.getNativeInstance());
        Pair<Float, IPoint> a2 = eq.a(mapConfig, i2, i3, i4, i5, builder.build(), getMapWidth(), getMapHeight());
        gLMapState.recycle();
        if (a2 == null) {
            return null;
        }
        DPoint obtain2 = DPoint.obtain();
        Object obj = a2.second;
        GLMapState.geo2LonLat(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx((IPoint) obj), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety((IPoint) obj), obtain2);
        Pair<Float, LatLng> pair2 = new Pair<>(a2.first, new LatLng(obtain2.y, obtain2.x));
        obtain2.recycle();
        return pair2;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public boolean canShowIndoorSwitch() {
        aq aqVar;
        if (getZoomLevel() < ((float) 17) || (aqVar = this.d) == null || aqVar.g == null) {
            return false;
        }
        FPoint obtain = FPoint.obtain();
        Point point = this.d.g;
        a(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point), obtain);
        return this.aB.contains((int) ((PointF) obtain).x, (int) ((PointF) obtain).y);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public boolean canStopMapRender() {
        GLMapEngine gLMapEngine = this.g;
        if (gLMapEngine != null) {
            gLMapEngine.canStopMapRender(1);
        }
        return true;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void changeGLOverlayIndex() {
        this.ah.e();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void changeLogoIconStyle(String str, boolean z2, int i2) {
        fd fdVar = this.ae;
        if (fdVar != null) {
            fdVar.a(str, Boolean.valueOf(z2), Integer.valueOf(i2));
        }
        ac acVar = this.ab;
        if (acVar != null) {
            acVar.requestRefreshLogo();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void changeMapLogo(int i2, boolean z2) {
        if (!this.ak) {
            try {
                List<AMapWidgetListener> list = this.am;
                if (list != null && list.size() > 0) {
                    this.ae.g(Boolean.valueOf(!z2));
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void changeSize(int i2, int i3) {
        MapConfig mapConfig = this.c;
        if (mapConfig != null) {
            this.h = i2;
            this.i = i3;
            mapConfig.setMapWidth(i2);
            this.c.setMapHeight(i3);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void changeSurface(int i2, GL10 gl10, int i3, int i4) {
        WindowManager windowManager;
        this.bf = false;
        if (!this.bc) {
            createSurface(i2, gl10, null);
        }
        p pVar = this.aT;
        if (!(pVar == null || this.f == null || ((this.h == pVar.b() && this.i == this.aT.c()) || (windowManager = (WindowManager) this.f.getSystemService(v.ATTACH_MODE_WINDOW)) == null))) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (defaultDisplay != null) {
                com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getRealMetrics(defaultDisplay, displayMetrics);
                this.aT.a(com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics), com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics));
            }
        }
        this.h = i3;
        this.i = i4;
        this.aI = true;
        this.aB = new Rect(0, 0, i3, i4);
        this.aj = a(i2, new Rect(0, 0, this.h, this.i), this.h, this.i);
        if (!this.bd) {
            MapConfig mapConfig = this.c;
            if (mapConfig != null) {
                mapConfig.setMapZoomScale(this.aW);
                this.c.setMapWidth(i3);
                this.c.setMapHeight(i4);
            }
            this.g.setIndoorEnable(this.aj, false);
            this.g.setSimple3DEnable(this.aj, false);
            this.g.initNativeTexture(this.aj);
            this.g.setMapOpenLayer("{\"bounds\" : [{\"x2\" : 235405312,\"x1\" : 188874751,\"y2\" : 85065727,\"y1\" : 122421247}],\"sublyr\" : [{\"type\" : 4,\"sid\" : 9000006,\"zlevel\" : 2}],\"id\" : 9006,\"minzoom\" : 6,\"update_period\" : 90,\"maxzoom\" : 20,\"cachemode\" : 2,\"url\" : \"http://mpsapi.amap.com//ws/mps/lyrdata/ugc/\"}");
        }
        g gVar = this.aR;
        if (gVar != null) {
            gVar.a(new w(AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_FIXED_GEAR_INDEX));
        }
        synchronized (this) {
            this.bd = true;
        }
        if (!this.ao) {
            this.c.setAnchorX(i3 >> 1);
            this.c.setAnchorY(i4 >> 1);
        } else {
            this.c.setAnchorX(Math.max(1, Math.min(this.bi, i3 - 1)));
            this.c.setAnchorY(Math.max(1, Math.min(this.bj, i4 - 1)));
        }
        this.g.setProjectionCenter(this.aj, this.c.getAnchorX(), this.c.getAnchorY());
        this.a = true;
        a aVar = this.by;
        if (aVar.b) {
            aVar.run();
        }
        a aVar2 = this.bs;
        if (aVar2.b) {
            aVar2.run();
        }
        a aVar3 = this.bt;
        if (aVar3.b) {
            aVar3.run();
        }
        a aVar4 = this.bq;
        if (aVar4.b) {
            aVar4.run();
        }
        a aVar5 = this.bu;
        if (aVar5.b) {
            aVar5.run();
        }
        a aVar6 = this.bB;
        if (aVar6.b) {
            aVar6.run();
        }
        a aVar7 = this.bv;
        if (aVar7.b) {
            aVar7.run();
        }
        a aVar8 = this.bw;
        if (aVar8.b) {
            aVar8.run();
        }
        a aVar9 = this.bx;
        if (aVar9.b) {
            aVar9.run();
        }
        a aVar10 = this.bz;
        if (aVar10.b) {
            aVar10.run();
        }
        a aVar11 = this.br;
        if (aVar11.b) {
            aVar11.run();
        }
        a aVar12 = this.bC;
        if (aVar12.b) {
            aVar12.run();
        }
        CustomRenderer customRenderer = this.aK;
        if (customRenderer != null) {
            customRenderer.onSurfaceChanged(gl10, i3, i4);
        }
        jp jpVar = this.bD;
        if (jpVar != null) {
            jpVar.a(gl10, i3, i4);
        }
        Handler handler = this.j;
        if (handler != null) {
            handler.post(this.bA);
        }
        redrawInfoWindow();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void checkMapState(IGLMapState iGLMapState) {
        MapConfig mapConfig = this.c;
        if (mapConfig != null && !this.ak) {
            LatLngBounds limitLatLngBounds = mapConfig.getLimitLatLngBounds();
            if (limitLatLngBounds != null) {
                try {
                    IPoint[] limitIPoints = this.c.getLimitIPoints();
                    if (limitIPoints == null) {
                        IPoint obtain = IPoint.obtain();
                        LatLng latLng = limitLatLngBounds.northeast;
                        GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, obtain);
                        IPoint obtain2 = IPoint.obtain();
                        LatLng latLng2 = limitLatLngBounds.southwest;
                        GLMapState.lonlat2Geo(latLng2.longitude, latLng2.latitude, obtain2);
                        IPoint[] iPointArr = {obtain, obtain2};
                        this.c.setLimitIPoints(iPointArr);
                        limitIPoints = iPointArr;
                    }
                    float b2 = eq.b(this.c, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(limitIPoints[0]), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(limitIPoints[0]), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(limitIPoints[1]), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(limitIPoints[1]), getMapWidth(), getMapHeight());
                    float mapZoomer = iGLMapState.getMapZoomer();
                    if (this.c.isSetLimitZoomLevel()) {
                        float maxZoomLevel = this.c.getMaxZoomLevel();
                        float minZoomLevel = this.c.getMinZoomLevel();
                        float max = Math.max(b2, Math.min(mapZoomer, maxZoomLevel));
                        if (b2 <= maxZoomLevel) {
                            maxZoomLevel = max;
                        }
                        b2 = maxZoomLevel < minZoomLevel ? minZoomLevel : maxZoomLevel;
                    } else if (b2 <= 0.0f || mapZoomer >= b2) {
                        b2 = mapZoomer;
                    }
                    iGLMapState.setMapZoomer(b2);
                    IPoint obtain3 = IPoint.obtain();
                    iGLMapState.getMapGeoCenter(obtain3);
                    int xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(obtain3);
                    int yVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(obtain3);
                    int[] a2 = eq.a(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(limitIPoints[0]), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(limitIPoints[0]), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(limitIPoints[1]), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(limitIPoints[1]), this.c, iGLMapState, xVar, yVar);
                    if (a2 != null && a2.length == 2) {
                        xVar = a2[0];
                        yVar = a2[1];
                    }
                    iGLMapState.setMapGeoCenter((double) xVar, (double) yVar);
                    obtain3.recycle();
                } catch (Throwable th) {
                    eq.a(th);
                }
            } else if (this.c.isSetLimitZoomLevel()) {
                iGLMapState.setMapZoomer(Math.max(this.c.getMinZoomLevel(), Math.min(iGLMapState.getMapZoomer(), this.c.getMaxZoomLevel())));
            }
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public int checkMarkerInRect(IMarkerAction iMarkerAction, Rect rect) {
        return 0;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public float checkZoomLevel(float f2) throws RemoteException {
        return eq.a(this.c, f2);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void clear() throws RemoteException {
        try {
            clear(false);
        } catch (Throwable th) {
            hd.c(th, "AMapDelegateImp", Constants.TAG_CLEAR_STRING);
            eq.a(th);
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void clearTileCache() {
        ab abVar = this.af;
        if (abVar != null) {
            abVar.i();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public long createGLOverlay(int i2) {
        GLMapEngine gLMapEngine = this.g;
        if (gLMapEngine != null) {
            return gLMapEngine.createOverlay(1, i2);
        }
        return 0;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public String createId(String str) {
        r rVar = this.ah;
        if (rVar != null) {
            return rVar.a(str);
        }
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public synchronized void createSurface(int i2, GL10 gl10, EGLConfig eGLConfig) {
        this.bp = System.currentTimeMillis();
        if (this.aC == 3) {
            this.ae.d().a(ez.b);
        } else {
            this.ae.d().a(ez.a);
        }
        this.bd = false;
        this.h = this.ad.getWidth();
        this.i = this.ad.getHeight();
        this.bf = false;
        try {
            AeUtil.initCrashHandle(this.f, AeUtil.loadLib(this.f));
            this.g.createAMapInstance(AeUtil.initResource(this.f));
            j(i2);
            synchronized (this.ag) {
                if (this.af == null) {
                    this.af = new ab(this.f, this);
                }
            }
            de deVar = new de();
            this.bl = deVar;
            this.ah.a(deVar);
            jp jpVar = this.bD;
            if (jpVar != null) {
                jpVar.a("setGLShaderManager", this.bl);
            }
            this.bc = true;
            this.m = gl10.glGetString(7937);
        } catch (Throwable th) {
            eq.a(th);
            hd.c(th, "AMapDElegateImp", "createSurface");
        }
        GLMapState mapState = this.g.getMapState(1);
        if (!(mapState == null || mapState.getNativeInstance() == 0)) {
            mapState.setMapGeoCenter((double) ((int) this.c.getSX()), (double) ((int) this.c.getSY()));
            mapState.setMapAngle(this.c.getSR());
            mapState.setMapZoomer(this.c.getSZ());
            mapState.setCameraDegree(this.c.getSC());
        }
        this.bm.a(this.f);
        j();
        CustomRenderer customRenderer = this.aK;
        if (customRenderer != null) {
            customRenderer.onSurfaceCreated(gl10, eGLConfig);
        }
        jp jpVar2 = this.bD;
        if (jpVar2 != null) {
            jpVar2.a(gl10, eGLConfig);
        }
        d();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void destroy() {
        this.ak = true;
        try {
            g gVar = this.aR;
            if (gVar != null) {
                gVar.a();
            }
            ax axVar = this.bn;
            if (axVar != null) {
                axVar.b();
            }
            LocationSource locationSource = this.ar;
            if (locationSource != null) {
                locationSource.deactivate();
            }
            this.ar = null;
            this.bk = null;
            GLMapRender gLMapRender = this.aS;
            if (gLMapRender != null) {
                gLMapRender.renderPause();
            }
            s sVar = this.bm;
            if (sVar != null) {
                sVar.e();
            }
            p pVar = this.aT;
            if (pVar != null) {
                pVar.a((AMapGestureListener) null);
                this.aT.d();
                this.aT = null;
            }
            r rVar = this.ah;
            if (rVar != null) {
                rVar.d();
            }
            u uVar = this.b;
            if (uVar != null) {
                uVar.i();
            }
            ab abVar = this.af;
            if (abVar != null) {
                abVar.g();
            }
            g();
            Thread thread = this.aE;
            if (thread != null) {
                thread.interrupt();
                this.aE = null;
            }
            Thread thread2 = this.aF;
            if (thread2 != null) {
                thread2.interrupt();
                this.aF = null;
            }
            dg dgVar = this.aP;
            if (dgVar != null) {
                dgVar.a();
                this.aP = null;
            }
            di diVar = this.aQ;
            if (diVar != null) {
                diVar.a((di.a) null);
                this.aQ.a();
                this.aQ = null;
            }
            ea.b();
            GLMapEngine gLMapEngine = this.g;
            if (gLMapEngine != null) {
                gLMapEngine.setMapListener(null);
                this.g.releaseNetworkState();
                queueEvent(new Runnable() {
                    /* class com.amap.api.mapcore.util.c.AnonymousClass33 */

                    public void run() {
                        try {
                            c cVar = c.this;
                            cVar.destroySurface(cVar.aj);
                        } catch (Throwable th) {
                            th.printStackTrace();
                            eq.a(th);
                        }
                    }
                });
                int i2 = 0;
                while (this.g != null) {
                    int i3 = i2 + 1;
                    if (i2 >= 50) {
                        break;
                    }
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e2) {
                        eq.a(e2);
                    }
                    i2 = i3;
                }
            }
            o oVar = this.al;
            if (oVar != null) {
                oVar.c();
            }
            ar arVar = this.X;
            if (arVar != null) {
                arVar.b();
            }
            IGLSurfaceView iGLSurfaceView = this.ad;
            if (iGLSurfaceView != null) {
                try {
                    iGLSurfaceView.onDetachedGLThread();
                } catch (Exception e3) {
                    e3.printStackTrace();
                    eq.a(e3);
                }
            }
            fd fdVar = this.ae;
            if (fdVar != null) {
                fdVar.i();
                this.ae = null;
            }
            cv cvVar = this.aq;
            if (cvVar != null) {
                cvVar.c();
                this.aq = null;
            }
            this.ar = null;
            m();
            this.aD = null;
            hd.b();
        } catch (Throwable th) {
            hd.c(th, "AMapDelegateImp", Constants.Event.SLOT_LIFECYCLE.DESTORY);
            eq.a(th);
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void destroySurface(int i2) {
        this.bg.lock();
        try {
            if (this.bc) {
                if (EGL14.eglGetCurrentContext() != EGL14.EGL_NO_CONTEXT) {
                    s sVar = this.bm;
                    if (sVar != null) {
                        sVar.d();
                    }
                    de deVar = this.bl;
                    if (deVar != null) {
                        deVar.b();
                        this.bl = null;
                    }
                }
                GLMapEngine gLMapEngine = this.g;
                if (gLMapEngine != null) {
                    if (gLMapEngine.getOverlayBundle(this.aj) != null) {
                        this.g.getOverlayBundle(this.aj).removeAll(true);
                    }
                    this.g.destroyAMapEngine();
                    this.g = null;
                }
                if (EGL14.eglGetCurrentContext() != EGL14.EGL_NO_CONTEXT) {
                    this.al.d();
                }
                jp jpVar = this.bD;
                if (jpVar != null) {
                    jpVar.a();
                }
            }
            this.bc = false;
            this.bd = false;
            this.bf = false;
        } catch (Throwable th) {
            this.bg.unlock();
            throw th;
        }
        this.bg.unlock();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void drawFrame(GL10 gl10) {
        if (!this.ak && this.g != null && EGL14.eglGetCurrentContext() != EGL14.EGL_NO_CONTEXT) {
            MapConfig mapConfig = this.c;
            if (mapConfig == null || mapConfig.isMapEnable()) {
                a(1, gl10);
                this.g.renderAMap();
                this.g.pushRendererState();
                CustomRenderer customRenderer = this.aK;
                if (customRenderer != null) {
                    customRenderer.onDrawFrame(gl10);
                }
                b bVar = this.bo;
                if (bVar != null) {
                    bVar.a();
                }
                a(gl10);
                i();
                if (!this.be) {
                    this.be = true;
                }
                this.g.popRendererState();
                g gVar = this.aR;
                if (gVar != null) {
                    gVar.a(new w(AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_FIXED_GEAR_INDEX));
                }
                if (eh.a()) {
                    try {
                        if (this.ad instanceof f) {
                            if (this.e == null) {
                                this.e = new eh();
                            }
                            this.e.e();
                            if (this.e.f() && !this.e.d()) {
                                if (this.e.a(((f) this.ad).getBitmap())) {
                                    if (eh.b()) {
                                        removecache();
                                    }
                                    if (eh.c()) {
                                        this.e.g();
                                    }
                                }
                            }
                        }
                    } catch (Throwable th) {
                        hd.c(th, "AMapDelegateImp", "PureScreenCheckTool.checkBlackScreen");
                    }
                }
            } else {
                GLES20.glClear(LogType.UNEXP_RESTART);
            }
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void geo2Latlng(int i2, int i3, DPoint dPoint) {
        DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong((long) i2, (long) i3, 20);
        dPoint.x = pixelsToLatLong.x;
        dPoint.y = pixelsToLatLong.y;
        pixelsToLatLong.recycle();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void geo2Map(int i2, int i3, FPoint fPoint) {
        ((PointF) fPoint).x = (float) ((int) (((double) i2) - this.c.getSX()));
        ((PointF) fPoint).y = (float) ((int) (((double) i3) - this.c.getSY()));
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public jp getAMapExtraInterfaceManager() {
        return this.bD;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public Projection getAMapProjection() throws RemoteException {
        return new Projection(this.aa);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public UiSettings getAMapUiSettings() throws RemoteException {
        if (this.Z == null) {
            this.Z = new UiSettings(this.ab);
        }
        return this.Z;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public int getBaseOverlayTextureID() {
        s sVar = this.bm;
        if (sVar != null) {
            return sVar.c();
        }
        return 0;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public AMapCameraInfo getCamerInfo() {
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public float getCameraAngle() {
        return getCameraDegree(this.aj);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public float getCameraDegree(int i2) {
        MapConfig mapConfig = this.c;
        if (mapConfig != null) {
            return mapConfig.getSC();
        }
        return 0.0f;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public CameraPosition getCameraPosition() throws RemoteException {
        return getCameraPositionPrj(this.ao);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public CameraPosition getCameraPositionPrj(boolean z2) {
        LatLng latLng;
        try {
            if (this.c == null) {
                return null;
            }
            if (!this.bc || this.an || this.g == null) {
                DPoint obtain = DPoint.obtain();
                geo2Latlng((int) this.c.getSX(), (int) this.c.getSY(), obtain);
                LatLng latLng2 = new LatLng(obtain.y, obtain.x);
                obtain.recycle();
                return CameraPosition.builder().target(latLng2).bearing(this.c.getSR()).tilt(this.c.getSC()).zoom(this.c.getSZ()).build();
            }
            if (z2) {
                DPoint obtain2 = DPoint.obtain();
                getPixel2LatLng(this.c.getAnchorX(), this.c.getAnchorY(), obtain2);
                latLng = new LatLng(obtain2.y, obtain2.x, false);
                obtain2.recycle();
            } else {
                latLng = f();
            }
            return CameraPosition.builder().target(latLng).bearing(this.c.getSR()).tilt(this.c.getSC()).zoom(this.c.getSZ()).build();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public Context getContext() {
        return this.f;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public String getCurrentWorldVectorMapStyle() {
        try {
            jp jpVar = this.bD;
            if (jpVar == null) {
                return "";
            }
            Object a2 = jpVar.a("getCurMapStyleKey");
            if (a2 instanceof String) {
                return (String) a2;
            }
            return "";
        } catch (Throwable th) {
            eq.a(th);
            return "";
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public int getDottedLineTextureID(int i2) {
        s sVar = this.bm;
        if (sVar != null) {
            return sVar.a(i2);
        }
        return 0;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public int getEngineIDWithGestureInfo(EAMapPlatformGestureInfo eAMapPlatformGestureInfo) {
        GLMapEngine gLMapEngine = this.g;
        if (gLMapEngine != null) {
            return gLMapEngine.getEngineIDWithGestureInfo(eAMapPlatformGestureInfo);
        }
        return 1;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public float[] getFinalMatrix() {
        MapConfig mapConfig = this.c;
        if (mapConfig != null) {
            return mapConfig.getMvpMatrix();
        }
        return this.n;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public GLMapEngine getGLMapEngine() {
        return this.g;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public View getGLMapView() {
        IGLSurfaceView iGLSurfaceView = this.ad;
        if (iGLSurfaceView instanceof View) {
            return (View) iGLSurfaceView;
        }
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public dd getGLShader(int i2) {
        de deVar = this.bl;
        if (deVar == null) {
            return null;
        }
        return deVar.a(i2);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public de getGLShaderManager() {
        return this.bl;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void getGeoCenter(int i2, IPoint iPoint) {
        MapConfig mapConfig = this.c;
        if (mapConfig != null) {
            ((Point) iPoint).x = (int) mapConfig.getSX();
            ((Point) iPoint).y = (int) this.c.getSY();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public long getGlOverlayMgrPtr() {
        GLMapEngine gLMapEngine = this.g;
        if (gLMapEngine != null) {
            return gLMapEngine.getGlOverlayMgrPtr(1);
        }
        return 0;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public InfoWindowAnimationManager getInfoWindowAnimationManager() {
        return new InfoWindowAnimationManager(this.Y);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void getLatLng2Map(double d2, double d3, FPoint fPoint) {
        IPoint obtain = IPoint.obtain();
        latlon2Geo(d2, d3, obtain);
        geo2Map(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(obtain), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(obtain), fPoint);
        obtain.recycle();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void getLatLng2Pixel(double d2, double d3, IPoint iPoint) {
        if (this.bc && this.g != null) {
            try {
                Point latLongToPixels = VirtualEarthProjection.latLongToPixels(d2, d3, 20);
                FPoint obtain = FPoint.obtain();
                a(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(latLongToPixels), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(latLongToPixels), obtain);
                float f2 = (float) -10000;
                if (((PointF) obtain).x == f2 && ((PointF) obtain).y == f2) {
                    GLMapState gLMapState = (GLMapState) this.g.getNewMapState(1);
                    gLMapState.setCameraDegree(0.0f);
                    gLMapState.recalculate();
                    gLMapState.p20ToScreenPoint(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(latLongToPixels), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(latLongToPixels), obtain);
                    gLMapState.recycle();
                }
                ((Point) iPoint).x = (int) ((PointF) obtain).x;
                ((Point) iPoint).y = (int) ((PointF) obtain).y;
                obtain.recycle();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void getLatLngRect(DPoint[] dPointArr) {
        try {
            Rectangle geoRectangle = this.c.getGeoRectangle();
            if (geoRectangle != null) {
                IPoint[] clipRect = geoRectangle.getClipRect();
                for (int i2 = 0; i2 < 4; i2++) {
                    GLMapState.geo2LonLat(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(clipRect[i2]), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(clipRect[i2]), dPointArr[i2]);
                }
            }
        } catch (Throwable th) {
            eq.a(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public int getLineTextureID() {
        s sVar = this.bm;
        if (sVar != null) {
            return sVar.a();
        }
        return 0;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public float getLineTextureRatio() {
        s sVar = this.bm;
        if (sVar != null) {
            return sVar.b();
        }
        return 1.0f;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public float getLogoMarginRate(int i2) {
        fd fdVar = this.ae;
        if (fdVar != null) {
            return fdVar.a(i2);
        }
        return 0.0f;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public int getLogoPosition() {
        try {
            return this.ab.getLogoPosition();
        } catch (RemoteException e2) {
            hd.c(e2, "AMapDelegateImp", "getLogoPosition");
            e2.printStackTrace();
            return 0;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public Handler getMainHandler() {
        return this.j;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public float getMapAngle(int i2) {
        MapConfig mapConfig = this.c;
        if (mapConfig != null) {
            return mapConfig.getSR();
        }
        return 0.0f;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public LatLngBounds getMapBounds(LatLng latLng, float f2, float f3, float f4) {
        int mapWidth = getMapWidth();
        int mapHeight = getMapHeight();
        if (mapWidth <= 0 || mapHeight <= 0 || this.ak) {
            return null;
        }
        float a2 = eq.a(this.c, f2);
        GLMapState gLMapState = new GLMapState(1, this.g.getNativeInstance());
        if (latLng != null) {
            IPoint obtain = IPoint.obtain();
            latlon2Geo(latLng.latitude, latLng.longitude, obtain);
            gLMapState.setCameraDegree(f4);
            gLMapState.setMapAngle(f3);
            gLMapState.setMapGeoCenter((double) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(obtain), (double) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(obtain));
            gLMapState.setMapZoomer(a2);
            gLMapState.recalculate();
            obtain.recycle();
        }
        DPoint obtain2 = DPoint.obtain();
        a(gLMapState, 0, 0, obtain2);
        LatLng latLng2 = new LatLng(obtain2.y, obtain2.x, false);
        a(gLMapState, mapWidth, mapHeight, obtain2);
        LatLng latLng3 = new LatLng(obtain2.y, obtain2.x, false);
        obtain2.recycle();
        gLMapState.recycle();
        return LatLngBounds.builder().include(latLng3).include(latLng2).build();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public MapConfig getMapConfig() {
        return this.c;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public String getMapContentApprovalNumber() {
        MapConfig mapConfig = this.c;
        if (mapConfig == null || mapConfig.isCustomStyleEnable()) {
            return null;
        }
        eo.d(this.f);
        String a2 = eg.a(this.f, "approval_number", "mc", "");
        return !TextUtils.isEmpty(a2) ? a2 : "GS（2017）3426号 | GS（2017）2550号";
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public int getMapHeight() {
        return this.i;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void getMapPrintScreen(AMap.onMapPrintScreenListener onmapprintscreenlistener) {
        try {
            a(this.U, onmapprintscreenlistener);
            this.az = true;
            resetRenderTime();
        } catch (Throwable th) {
            eq.a(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public GLMapState getMapProjection() {
        GLMapEngine gLMapEngine = this.g;
        if (gLMapEngine != null) {
            return gLMapEngine.getMapState(1);
        }
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public FPoint[] getMapRect() {
        if (this.c.getMapRect() == null) {
            this.c.setMapRect(eq.a((IAMapDelegate) this, true));
        }
        return this.c.getMapRect();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public List<Marker> getMapScreenMarkers() throws RemoteException {
        if (!eq.b(getMapWidth(), getMapHeight())) {
            return new ArrayList();
        }
        return this.b.e();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void getMapScreenShot(AMap.OnMapScreenShotListener onMapScreenShotListener) {
        try {
            a(this.V, onMapScreenShotListener);
            this.az = true;
            resetRenderTime();
        } catch (Throwable th) {
            eq.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public int getMapTextZIndex() throws RemoteException {
        return this.aJ;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public int getMapType() throws RemoteException {
        return this.aC;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public int getMapWidth() {
        return this.h;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public float getMapZoomScale() {
        return this.aW;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public int getMaskLayerType() {
        return this.aM;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public float getMaxZoomLevel() {
        try {
            MapConfig mapConfig = this.c;
            if (mapConfig != null) {
                return mapConfig.getMaxZoomLevel();
            }
            return 20.0f;
        } catch (Throwable th) {
            eq.a(th);
            return 20.0f;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public float getMinZoomLevel() {
        try {
            MapConfig mapConfig = this.c;
            if (mapConfig != null) {
                return mapConfig.getMinZoomLevel();
            }
            return 3.0f;
        } catch (Throwable th) {
            eq.a(th);
            return 3.0f;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public Location getMyLocation() throws RemoteException {
        if (this.ar != null) {
            return this.G.a;
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public MyLocationStyle getMyLocationStyle() throws RemoteException {
        cv cvVar = this.aq;
        if (cvVar != null) {
            return cvVar.a();
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public long getNativeMapController() {
        GLMapEngine gLMapEngine = this.g;
        if (gLMapEngine != null) {
            return gLMapEngine.getNativeMapController(1);
        }
        return 0;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public AMap.OnCameraChangeListener getOnCameraChangeListener() throws RemoteException {
        try {
            List<AMap.OnCameraChangeListener> list = this.M;
            if (list == null) {
                if (list.size() != 0) {
                    return this.M.get(0);
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void getPixel2Geo(int i2, int i3, IPoint iPoint) {
        GLMapEngine gLMapEngine;
        GLMapState mapState;
        if (this.bc && (gLMapEngine = this.g) != null && (mapState = gLMapEngine.getMapState(1)) != null) {
            mapState.screenToP20Point(i2, i3, iPoint);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void getPixel2LatLng(int i2, int i3, DPoint dPoint) {
        GLMapEngine gLMapEngine;
        GLMapState mapState;
        if (this.bc && (gLMapEngine = this.g) != null && (mapState = gLMapEngine.getMapState(1)) != null) {
            IPoint obtain = IPoint.obtain();
            mapState.screenToP20Point(i2, i3, obtain);
            DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong((long) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(obtain), (long) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(obtain), 20);
            dPoint.x = pixelsToLatLong.x;
            dPoint.y = pixelsToLatLong.y;
            obtain.recycle();
            pixelsToLatLong.recycle();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public float getPreciseLevel(int i2) {
        MapConfig mapConfig = this.c;
        if (mapConfig != null) {
            return mapConfig.getSZ();
        }
        return 0.0f;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public IProjectionDelegate getProjection() throws RemoteException {
        return this.aa;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public float[] getProjectionMatrix() {
        MapConfig mapConfig = this.c;
        if (mapConfig != null) {
            return mapConfig.getProjectionMatrix();
        }
        return this.p;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public Rect getRect() {
        return this.aB;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public int getRenderMode() {
        return this.ad.getRenderMode();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public int getSX() {
        MapConfig mapConfig = this.c;
        if (mapConfig != null) {
            return (int) mapConfig.getSX();
        }
        return -1;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public int getSY() {
        MapConfig mapConfig = this.c;
        if (mapConfig != null) {
            return (int) mapConfig.getSY();
        }
        return -1;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public String getSatelliteImageApprovalNumber() {
        eo.e(this.f);
        String a2 = eg.a(this.f, "approval_number", "si", "");
        return !TextUtils.isEmpty(a2) ? a2 : "GS（2018）984号";
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public float getScalePerPixel() throws RemoteException {
        try {
            return ((float) ((((Math.cos((getCameraPosition().target.latitude * 3.141592653589793d) / 180.0d) * 2.0d) * 3.141592653589793d) * 6378137.0d) / (Math.pow(2.0d, (double) getZoomLevel()) * 256.0d))) * getMapZoomScale();
        } catch (Throwable th) {
            hd.c(th, "AMapDelegateImp", "getScalePerPixel");
            eq.a(th);
            th.printStackTrace();
            return 0.0f;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public float getSkyHeight() {
        return this.c.getSkyHeight();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public x getTextureItem(BitmapDescriptor bitmapDescriptor) {
        return getTextureItem(bitmapDescriptor, false);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public IUiSettingsDelegate getUiSettings() {
        return this.ab;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public float getUnitLengthByZoom(int i2) {
        GLMapState gLMapState = new GLMapState(1, this.g.getNativeInstance());
        gLMapState.setMapZoomer((float) i2);
        gLMapState.recalculate();
        float gLUnitWithWin = gLMapState.getGLUnitWithWin(1);
        gLMapState.recycle();
        return gLUnitWithWin;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public View getView() throws RemoteException {
        return this.ae;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public float[] getViewMatrix() {
        MapConfig mapConfig = this.c;
        if (mapConfig != null) {
            return mapConfig.getViewMatrix();
        }
        return this.o;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public Point getWaterMarkerPositon() {
        fd fdVar = this.ae;
        if (fdVar != null) {
            return fdVar.a();
        }
        return new Point();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public String getWorldVectorMapLanguage() {
        return this.bE;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public String getWorldVectorMapStyle() {
        return this.bF;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public float getZoomLevel() {
        return a(this.aj);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public float getZoomToSpanLevel(LatLng latLng, LatLng latLng2) {
        try {
            MapConfig mapConfig = getMapConfig();
            if (latLng == null || latLng2 == null || !this.bc || this.ak) {
                return mapConfig.getSZ();
            }
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            builder.include(latLng);
            builder.include(latLng2);
            GLMapState gLMapState = new GLMapState(1, this.g.getNativeInstance());
            Pair<Float, IPoint> a2 = eq.a(mapConfig, 0, 0, 0, 0, builder.build(), getMapWidth(), getMapHeight());
            gLMapState.recycle();
            if (a2 != null) {
                return ((Float) a2.first).floatValue();
            }
            return gLMapState.getMapZoomer();
        } catch (Throwable th) {
            eq.a(th);
            return 0.0f;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void hideInfoWindow() {
        ar arVar = this.X;
        if (arVar != null) {
            arVar.e();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public boolean isIndoorEnabled() throws RemoteException {
        return this.c.isIndoorEnable();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public boolean isInfoWindowShown(IMarkerDelegate iMarkerDelegate) throws RemoteException {
        ar arVar = this.X;
        if (arVar != null) {
            return arVar.f();
        }
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public boolean isLockMapAngle(int i2) {
        return a(i2, 7);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public boolean isLockMapCameraDegree(int i2) {
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public boolean isMaploaded() {
        return this.ap;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public boolean isMyLocationEnabled() throws RemoteException {
        return this.ai;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public boolean isTouchPoiEnable() {
        MapConfig mapConfig = this.c;
        if (mapConfig != null) {
            return mapConfig.isTouchPoiEnable();
        }
        return true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public boolean isTrafficEnabled() throws RemoteException {
        return this.c.isTrafficEnabled();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public boolean isUseAnchor() {
        return this.ao;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void latlon2Geo(double d2, double d3, IPoint iPoint) {
        Point latLongToPixels = VirtualEarthProjection.latLongToPixels(d2, d3, 20);
        ((Point) iPoint).x = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(latLongToPixels);
        ((Point) iPoint).y = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(latLongToPixels);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void loadWorldVectorMap(boolean z2) {
        MapConfig mapConfig = this.c;
        if (mapConfig != null) {
            mapConfig.setAbroadEnable(z2);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void map2Geo(float f2, float f3, IPoint iPoint) {
        ((Point) iPoint).x = (int) (((double) f2) + this.c.getSX());
        ((Point) iPoint).y = (int) (((double) f3) + this.c.getSY());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void moveCamera(CameraUpdate cameraUpdate) throws RemoteException {
        if (cameraUpdate != null) {
            try {
                moveCamera(cameraUpdate.getCameraUpdateFactoryDelegate());
            } catch (Throwable th) {
                eq.a(th);
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void onActivityPause() {
        this.an = true;
        c(this.aj);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void onActivityResume() {
        this.an = false;
        int i2 = this.aj;
        if (i2 == 0) {
            i2 = this.g.getEngineIDWithType(0);
        }
        d(i2);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void onChangeFinish() {
        Message obtainMessage = this.j.obtainMessage();
        obtainMessage.what = 11;
        this.j.sendMessage(obtainMessage);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public boolean onDoubleTap(int i2, MotionEvent motionEvent) {
        if (!this.bc) {
            return false;
        }
        a(i2, (int) motionEvent.getX(), (int) motionEvent.getY());
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void onFling() {
        ab abVar = this.af;
        if (abVar != null) {
            abVar.b(true);
        }
        this.ay = true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void onIndoorBuildingActivity(int i2, byte[] bArr) {
        aq aqVar;
        if (bArr != null) {
            try {
                aqVar = new aq();
                byte b2 = bArr[0];
                aqVar.a = new String(bArr, 1, b2, "utf-8");
                int i3 = 1 + b2;
                int i4 = i3 + 1;
                byte b3 = bArr[i3];
                aqVar.b = new String(bArr, i4, b3, "utf-8");
                int i5 = i4 + b3;
                int i6 = i5 + 1;
                byte b4 = bArr[i5];
                aqVar.activeFloorName = new String(bArr, i6, b4, "utf-8");
                int i7 = i6 + b4;
                aqVar.activeFloorIndex = GLConvertUtil.getInt(bArr, i7);
                int i8 = i7 + 4;
                int i9 = i8 + 1;
                byte b5 = bArr[i8];
                aqVar.poiid = new String(bArr, i9, b5, "utf-8");
                int i10 = i9 + b5;
                int i11 = i10 + 1;
                byte b6 = bArr[i10];
                aqVar.h = new String(bArr, i11, b6, "utf-8");
                int i12 = i11 + b6;
                int i13 = GLConvertUtil.getInt(bArr, i12);
                aqVar.c = i13;
                int i14 = i12 + 4;
                aqVar.floor_indexs = new int[i13];
                aqVar.floor_names = new String[i13];
                aqVar.d = new String[i13];
                for (int i15 = 0; i15 < aqVar.c; i15++) {
                    aqVar.floor_indexs[i15] = GLConvertUtil.getInt(bArr, i14);
                    int i16 = i14 + 4;
                    int i17 = i16 + 1;
                    byte b7 = bArr[i16];
                    if (b7 > 0) {
                        aqVar.floor_names[i15] = new String(bArr, i17, b7, "utf-8");
                        i17 += b7;
                    }
                    i14 = i17 + 1;
                    byte b8 = bArr[i17];
                    if (b8 > 0) {
                        aqVar.d[i15] = new String(bArr, i14, b8, "utf-8");
                        i14 += b8;
                    }
                }
                int i18 = GLConvertUtil.getInt(bArr, i14);
                aqVar.e = i18;
                int i19 = i14 + 4;
                if (i18 > 0) {
                    aqVar.f = new int[i18];
                    for (int i20 = 0; i20 < aqVar.e; i20++) {
                        aqVar.f[i20] = GLConvertUtil.getInt(bArr, i19);
                        i19 += 4;
                    }
                }
            } catch (Throwable th) {
                eq.a(th);
                th.printStackTrace();
                return;
            }
        } else {
            aqVar = null;
        }
        this.bI = aqVar;
        post(new Runnable() {
            /* class com.amap.api.mapcore.util.c.AnonymousClass31 */

            public void run() {
                if (c.this.bk != null) {
                    c.this.bk.a(c.this.bI);
                }
            }
        });
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void onLongPress(int i2, MotionEvent motionEvent) {
        int i3 = 0;
        try {
            this.av = false;
            b(i2);
            BaseOverlayImp a2 = this.b.a(motionEvent);
            this.au = a2;
            if (a2 == null || !a2.isDraggable()) {
                List<AMap.OnMapLongClickListener> list = this.Q;
                if (list != null && list.size() > 0) {
                    DPoint obtain = DPoint.obtain();
                    getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), obtain);
                    while (i3 < this.Q.size()) {
                        this.Q.get(i3).onMapLongClick(new LatLng(obtain.y, obtain.x));
                        i3++;
                    }
                    this.aw = true;
                    obtain.recycle();
                }
            } else {
                Marker marker = new Marker((cu) this.au);
                this.at = marker;
                LatLng position = marker.getPosition();
                LatLng realPosition = this.au.getRealPosition();
                if (!(position == null || realPosition == null)) {
                    IPoint obtain2 = IPoint.obtain();
                    getLatLng2Pixel(realPosition.latitude, realPosition.longitude, obtain2);
                    ((Point) obtain2).y = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(obtain2) - 60;
                    DPoint obtain3 = DPoint.obtain();
                    getPixel2LatLng(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(obtain2), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(obtain2), obtain3);
                    this.at.setPosition(new LatLng((position.latitude + obtain3.y) - realPosition.latitude, (position.longitude + obtain3.x) - realPosition.longitude));
                    this.b.a((IMarkerDelegate) ((cu) this.au));
                    try {
                        List<AMap.OnMarkerDragListener> list2 = this.K;
                        if (list2 != null && list2.size() > 0) {
                            while (i3 < this.K.size()) {
                                this.K.get(i3).onMarkerDragStart(this.at);
                                i3++;
                            }
                        }
                    } catch (Throwable th) {
                        hd.c(th, "AMapDelegateImp", "onMarkerDragStart");
                        th.printStackTrace();
                    }
                    this.as = true;
                    obtain2.recycle();
                    obtain3.recycle();
                }
            }
            this.aS.resetTickCount(30);
        } catch (Throwable th2) {
            hd.c(th2, "AMapDelegateImp", "onLongPress");
            th2.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void onPause() {
        e();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void onResume() {
        try {
            this.aS.setRenderFps(15.0f);
            this.ad.setRenderMode(0);
            ab abVar = this.af;
            if (abVar != null) {
                abVar.e();
            }
            cv cvVar = this.aq;
            if (cvVar != null) {
                cvVar.b();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public boolean onSingleTapConfirmed(int i2, MotionEvent motionEvent) {
        if (!this.bc) {
            return false;
        }
        try {
            b(i2);
            if (g(motionEvent) || e(motionEvent) || f(motionEvent) || d(motionEvent)) {
                return true;
            }
            b(motionEvent);
            return true;
        } catch (Throwable th) {
            hd.c(th, "AMapDelegateImp", "onSingleTapUp");
            th.printStackTrace();
            return true;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.an || !this.bc || !this.aY) {
            return false;
        }
        EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.bG;
        eAMapPlatformGestureInfo.mGestureState = 3;
        eAMapPlatformGestureInfo.mGestureType = 8;
        eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
        int engineIDWithGestureInfo = getEngineIDWithGestureInfo(this.bG);
        b();
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            c();
            h(engineIDWithGestureInfo);
        } else if (action == 1) {
            i(engineIDWithGestureInfo);
        }
        if (motionEvent.getAction() != 2 || !this.as) {
            if (this.aU) {
                try {
                    this.aT.a(motionEvent);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            try {
                List<AMap.OnMapTouchListener> list = this.O;
                if (list != null && list.size() > 0) {
                    this.j.removeMessages(14);
                    Message obtainMessage = this.j.obtainMessage();
                    obtainMessage.what = 14;
                    obtainMessage.obj = MotionEvent.obtain(motionEvent);
                    obtainMessage.sendToTarget();
                }
            } catch (Throwable unused) {
            }
            return true;
        }
        try {
            a(motionEvent);
        } catch (Throwable th2) {
            hd.c(th2, "AMapDelegateImp", "onDragMarker");
            th2.printStackTrace();
        }
        return true;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void pixel2Map(int i2, int i3, PointF pointF) {
        if (this.bc && !this.an && this.g != null) {
            IPoint obtain = IPoint.obtain();
            getPixel2Geo(i2, i3, obtain);
            pointF.x = ((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(obtain)) - ((float) this.c.getSX());
            pointF.y = ((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(obtain)) - ((float) this.c.getSY());
            obtain.recycle();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void post(Runnable runnable) {
        IGLSurfaceView iGLSurfaceView = this.ad;
        if (iGLSurfaceView != null) {
            iGLSurfaceView.post(runnable);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void queueEvent(Runnable runnable) {
        try {
            if (this.g != null) {
                this.ad.queueEvent(runnable);
            }
        } catch (Throwable th) {
            eq.a(th);
            hd.c(th, "AMapdelegateImp", "queueEvent");
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void redrawInfoWindow() {
        if (this.bc) {
            this.j.sendEmptyMessage(18);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void refreshLogo() {
        fd fdVar = this.ae;
        if (fdVar != null) {
            fdVar.c();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void reloadMap() {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void reloadMapCustomStyle() {
        b bVar = this.bo;
        if (bVar != null) {
            bVar.b();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void removeEngineGLOverlay(BaseMapOverlay baseMapOverlay) {
        GLMapEngine gLMapEngine = this.g;
        if (gLMapEngine != null) {
            gLMapEngine.getOverlayBundle(1).removeOverlay(baseMapOverlay);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public boolean removeGLModel(String str) {
        try {
            this.al.a(str);
            return false;
        } catch (Throwable th) {
            hd.c(th, "AMapDelegateImp", "removeGLModel");
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public boolean removeGLOverlay(String str) throws RemoteException {
        resetRenderTime();
        return this.ah.removeOverlay(str);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public boolean removeMarker(String str) {
        try {
            IOverlayImageDelegate a2 = this.b.a(str);
            if (a2 == null) {
                return false;
            }
            resetRenderTime();
            return this.b.a(a2);
        } catch (Throwable th) {
            hd.c(th, "AMapDelegateImp", "removeMarker");
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void removeOnCameraChangeListener(AMap.OnCameraChangeListener onCameraChangeListener) throws RemoteException {
        b(this.M, onCameraChangeListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void removeOnIndoorBuildingActiveListener(AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) throws RemoteException {
        b(this.S, onIndoorBuildingActiveListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void removeOnInfoWindowClickListener(AMap.OnInfoWindowClickListener onInfoWindowClickListener) throws RemoteException {
        b(this.R, onInfoWindowClickListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void removeOnMapClickListener(AMap.OnMapClickListener onMapClickListener) throws RemoteException {
        b(this.N, onMapClickListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void removeOnMapLoadedListener(AMap.OnMapLoadedListener onMapLoadedListener) {
        b(this.L, onMapLoadedListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void removeOnMapLongClickListener(AMap.OnMapLongClickListener onMapLongClickListener) throws RemoteException {
        b(this.Q, onMapLongClickListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void removeOnMapTouchListener(AMap.OnMapTouchListener onMapTouchListener) throws RemoteException {
        b(this.O, onMapTouchListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void removeOnMarkerClickListener(AMap.OnMarkerClickListener onMarkerClickListener) throws RemoteException {
        b(this.I, onMarkerClickListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void removeOnMarkerDragListener(AMap.OnMarkerDragListener onMarkerDragListener) {
        b(this.K, onMarkerDragListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void removeOnMyLocationChangeListener(AMap.OnMyLocationChangeListener onMyLocationChangeListener) throws RemoteException {
        b(this.T, onMyLocationChangeListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void removeOnPOIClickListener(AMap.OnPOIClickListener onPOIClickListener) throws RemoteException {
        b(this.P, onPOIClickListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void removeOnPolylineClickListener(AMap.OnPolylineClickListener onPolylineClickListener) throws RemoteException {
        b(this.J, onPolylineClickListener);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void removeTextureItem(String str) {
        synchronized (this.aO) {
            int size = this.aO.size();
            int i2 = -1;
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    break;
                } else if (this.aO.get(i3).p().equals(str)) {
                    i2 = i3;
                    break;
                } else {
                    i3++;
                }
            }
            if (i2 >= 0) {
                this.aO.remove(i2);
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void removecache() throws RemoteException {
        removecache(null);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void renderSurface(GL10 gl10) {
        drawFrame(gl10);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void requestRender() {
        GLMapRender gLMapRender = this.aS;
        if (gLMapRender != null && !gLMapRender.isRenderPause()) {
            this.ad.requestRender();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void resetMinMaxZoomPreference() {
        List<AMapWidgetListener> list;
        this.c.resetMinMaxZoomPreference();
        try {
            if (this.ab.isZoomControlsEnabled() && this.c.isNeedUpdateZoomControllerState() && (list = this.am) != null && list.size() > 0) {
                for (int i2 = 0; i2 < this.am.size(); i2++) {
                    this.am.get(i2).invalidateZoomController(this.c.getSZ());
                }
            }
        } catch (Throwable th) {
            eq.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void resetRenderTime() {
        GLMapRender gLMapRender = this.aS;
        if (gLMapRender != null) {
            gLMapRender.resetTickCount(2);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void resetRenderTimeLongLong() {
        GLMapRender gLMapRender = this.aS;
        if (gLMapRender != null) {
            gLMapRender.resetTickCount(30);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void set3DBuildingEnabled(boolean z2) throws RemoteException {
        try {
            c(1);
            a(1, z2);
            d(1);
        } catch (Throwable th) {
            eq.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setAMapGestureListener(AMapGestureListener aMapGestureListener) {
        p pVar = this.aT;
        if (pVar != null) {
            this.W = aMapGestureListener;
            pVar.a(aMapGestureListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setCenterToPixel(int i2, int i3) throws RemoteException {
        this.ao = true;
        this.bi = i2;
        this.bj = i3;
        if (this.bd && this.bc) {
            if (this.c.getAnchorX() != this.bi || this.c.getAnchorY() != this.bj) {
                this.c.setAnchorX(this.bi);
                this.c.setAnchorY(this.bj);
                queueEvent(new Runnable() {
                    /* class com.amap.api.mapcore.util.c.AnonymousClass28 */

                    public void run() {
                        try {
                            c cVar = c.this;
                            cVar.c.setAnchorX(Math.max(0, Math.min(cVar.bi, c.this.h)));
                            c cVar2 = c.this;
                            cVar2.c.setAnchorY(Math.max(0, Math.min(cVar2.bj, c.this.i)));
                            c cVar3 = c.this;
                            cVar3.g.setProjectionCenter(1, cVar3.c.getAnchorX(), c.this.c.getAnchorY());
                            c.this.aI = true;
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setCustomMapStyle(CustomMapStyleOptions customMapStyleOptions) {
        if (customMapStyleOptions != null) {
            try {
                if (customMapStyleOptions.isEnable() && !(customMapStyleOptions.getStyleId() == null && customMapStyleOptions.getStyleTexturePath() == null && customMapStyleOptions.getStyleTextureData() == null)) {
                    k();
                }
                this.bo.c();
                this.bo.a(customMapStyleOptions);
                jp jpVar = this.bD;
                if (jpVar != null) {
                    jpVar.a("setCustomMapStyle", customMapStyleOptions);
                }
            } catch (Throwable th) {
                eq.a(th);
                return;
            }
        }
        resetRenderTime();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setCustomMapStyleID(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.c.getCustomStyleID())) {
            this.c.setCustomStyleID(str);
            this.ac = true;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setCustomMapStylePath(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.c.getCustomStylePath())) {
            this.c.setCustomStylePath(str);
            this.ac = true;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setCustomRenderer(CustomRenderer customRenderer) throws RemoteException {
        this.aK = customRenderer;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setCustomTextureResourcePath(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.c.setCustomTextureResourcePath(str);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void setGestureStatus(int i2, int i3) {
        if (this.bh == 0 || i3 != 5) {
            this.bh = i3;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void setHideLogoEnble(boolean z2) {
        MapConfig mapConfig = this.c;
        if (mapConfig != null) {
            mapConfig.setHideLogoEnble(z2);
            if (this.c.isCustomStyleEnable()) {
                this.ab.setLogoEnable(!z2);
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setIndoorBuildingInfo(IndoorBuildingInfo indoorBuildingInfo) throws RemoteException {
        if (!this.ak && indoorBuildingInfo != null && indoorBuildingInfo.activeFloorName != null && indoorBuildingInfo.poiid != null) {
            this.d = (aq) indoorBuildingInfo;
            resetRenderTime();
            queueEvent(new Runnable() {
                /* class com.amap.api.mapcore.util.c.AnonymousClass29 */

                public void run() {
                    c cVar = c.this;
                    GLMapEngine gLMapEngine = cVar.g;
                    if (gLMapEngine != null) {
                        aq aqVar = cVar.d;
                        gLMapEngine.setIndoorBuildingToBeActive(1, aqVar.activeFloorName, aqVar.activeFloorIndex, aqVar.poiid);
                    }
                }
            });
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setIndoorEnabled(final boolean z2) throws RemoteException {
        List<AMapWidgetListener> list;
        try {
            if (!this.bc || this.ak) {
                a aVar = this.bz;
                aVar.c = z2;
                aVar.b = true;
                aVar.g = 1;
                return;
            }
            this.c.setIndoorEnable(z2);
            resetRenderTime();
            if (z2) {
                GLMapEngine gLMapEngine = this.g;
                if (gLMapEngine != null) {
                    gLMapEngine.setIndoorEnable(1, true);
                }
            } else {
                GLMapEngine gLMapEngine2 = this.g;
                if (gLMapEngine2 != null) {
                    gLMapEngine2.setIndoorEnable(1, false);
                }
                MapConfig mapConfig = this.c;
                mapConfig.maxZoomLevel = mapConfig.isSetLimitZoomLevel() ? this.c.getMaxZoomLevel() : 20.0f;
                try {
                    if (this.ab.isZoomControlsEnabled() && (list = this.am) != null && list.size() > 0) {
                        for (int i2 = 0; i2 < this.am.size(); i2++) {
                            this.am.get(i2).invalidateZoomController(this.c.getSZ());
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            eo.c(this.f, z2);
            if (this.ab.isIndoorSwitchEnabled()) {
                this.j.post(new Runnable() {
                    /* class com.amap.api.mapcore.util.c.AnonymousClass22 */

                    public void run() {
                        if (z2) {
                            c.this.showIndoorSwitchControlsEnabled(true);
                        } else if (c.this.ae != null) {
                            c.this.ae.i(Boolean.FALSE);
                        }
                    }
                });
            }
        } catch (Throwable th) {
            eq.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setInfoWindowAdapter(AMap.InfoWindowAdapter infoWindowAdapter) throws RemoteException {
        ar arVar;
        if (!this.ak && (arVar = this.X) != null) {
            arVar.a(infoWindowAdapter);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setLoadOfflineData(final boolean z2) throws RemoteException {
        queueEvent(new Runnable() {
            /* class com.amap.api.mapcore.util.c.AnonymousClass23 */

            public void run() {
                GLMapEngine gLMapEngine = c.this.g;
                if (gLMapEngine != null) {
                    gLMapEngine.setOfflineDataEnable(1, z2);
                }
            }
        });
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setLocationSource(LocationSource locationSource) throws RemoteException {
        try {
            if (!this.ak) {
                LocationSource locationSource2 = this.ar;
                if (locationSource2 != null && (locationSource2 instanceof as)) {
                    locationSource2.deactivate();
                }
                this.ar = locationSource;
                if (locationSource != null) {
                    this.ae.h(Boolean.TRUE);
                } else {
                    this.ae.h(Boolean.FALSE);
                }
            }
        } catch (Throwable th) {
            hd.c(th, "AMapDelegateImp", "setLocationSource");
            th.printStackTrace();
            eq.a(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void setLogoBottomMargin(int i2) {
        fd fdVar = this.ae;
        if (fdVar != null) {
            fdVar.c(Integer.valueOf(i2));
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void setLogoLeftMargin(int i2) {
        fd fdVar = this.ae;
        if (fdVar != null) {
            fdVar.d(Integer.valueOf(i2));
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void setLogoMarginRate(int i2, float f2) {
        fd fdVar = this.ae;
        if (fdVar != null) {
            fdVar.a(Integer.valueOf(i2), Float.valueOf(f2));
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void setLogoPosition(int i2) {
        fd fdVar = this.ae;
        if (fdVar != null) {
            fdVar.b(Integer.valueOf(i2));
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void setMapCustomEnable(boolean z2, boolean z3) {
        dg dgVar;
        if (!this.bc || this.ak) {
            a aVar = this.bt;
            aVar.b = true;
            aVar.c = z2;
            return;
        }
        boolean z4 = z3 ? z3 : false;
        if (!TextUtils.isEmpty(this.c.getCustomStylePath()) || !TextUtils.isEmpty(this.c.getCustomStyleID())) {
            if (z2) {
                try {
                    if (this.c.isProFunctionAuthEnable() && !TextUtils.isEmpty(this.c.getCustomStyleID()) && (dgVar = this.aP) != null) {
                        dgVar.a(this.c.getCustomStyleID());
                        this.aP.b();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    eq.a(th);
                    return;
                }
            }
            if (z3 || this.ac || (this.c.isCustomStyleEnable() ^ z2)) {
                a(z2, (byte[]) null, z4);
            }
            this.ac = false;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void setMapEnable(boolean z2) {
        MapConfig mapConfig = this.c;
        if (mapConfig != null) {
            mapConfig.setMapEnable(z2);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMapLanguage(String str) {
        MapConfig mapConfig;
        if (!TextUtils.isEmpty(str) && (mapConfig = this.c) != null && !mapConfig.isCustomStyleEnable() && !this.c.getMapLanguage().equals(str)) {
            if (!str.equals("en")) {
                this.c.setMapLanguage("zh_cn");
                this.aJ = 0;
            } else {
                if (this.aC != 1) {
                    try {
                        setMapType(1);
                    } catch (Throwable th) {
                        eq.a(th);
                        th.printStackTrace();
                    }
                }
                this.c.setMapLanguage("en");
                this.aJ = -10000;
            }
            try {
                a(getCameraPosition());
                synchronized (this.ag) {
                    if (this.af == null) {
                        this.af = new ab(this.f, this);
                    }
                }
                ab abVar = this.af;
                if (abVar != null) {
                    abVar.a(this.c.getMapLanguage());
                }
            } catch (Throwable th2) {
                eq.a(th2);
                th2.printStackTrace();
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMapStatusLimits(LatLngBounds latLngBounds) {
        try {
            this.c.setLimitLatLngBounds(latLngBounds);
            l();
        } catch (Throwable th) {
            th.printStackTrace();
            eq.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMapTextEnable(final boolean z2) throws RemoteException {
        try {
            if (!this.bc || !this.bd) {
                a aVar = this.bv;
                aVar.c = z2;
                aVar.b = true;
                aVar.g = 1;
                return;
            }
            resetRenderTime();
            queueEvent(new Runnable() {
                /* class com.amap.api.mapcore.util.c.AnonymousClass24 */

                public void run() {
                    try {
                        c.this.g.setLabelEnable(1, z2);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        } catch (Throwable th) {
            eq.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMapTextZIndex(int i2) throws RemoteException {
        this.aJ = i2;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMapType(int i2) throws RemoteException {
        MapConfig mapConfig;
        if (i2 != this.aC || ((mapConfig = this.c) != null && mapConfig.isCustomStyleEnable())) {
            g gVar = this.aR;
            if (gVar != null) {
                gVar.a(new w(1, Integer.valueOf(i2)));
            }
            this.aC = i2;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void setMapWidgetListener(AMapWidgetListener aMapWidgetListener) {
        try {
            AMapWidgetListener aMapWidgetListener2 = this.H;
            if (aMapWidgetListener2 != null) {
                b(aMapWidgetListener2);
            }
            this.H = aMapWidgetListener;
            a(aMapWidgetListener);
        } catch (Throwable unused) {
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMaskLayerParams(int i2, int i3, int i4, int i5, final int i6, long j2) {
        GLAlphaAnimation gLAlphaAnimation;
        try {
            if (this.aL != null) {
                float f2 = ((float) i5) / 255.0f;
                if (i6 == -1) {
                    gLAlphaAnimation = new GLAlphaAnimation(f2, 0.0f);
                    gLAlphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                        /* class com.amap.api.mapcore.util.c.AnonymousClass30 */

                        @Override // com.amap.api.maps.model.animation.Animation.AnimationListener
                        public void onAnimationEnd() {
                            c.this.j.post(new Runnable() {
                                /* class com.amap.api.mapcore.util.c.AnonymousClass30.AnonymousClass1 */

                                public void run() {
                                    AnonymousClass30 r0 = AnonymousClass30.this;
                                    c.this.aM = i6;
                                    if (c.this.ae != null) {
                                        c.this.ae.j(Boolean.TRUE);
                                    }
                                }
                            });
                        }

                        @Override // com.amap.api.maps.model.animation.Animation.AnimationListener
                        public void onAnimationStart() {
                        }
                    });
                } else {
                    this.aM = i6;
                    gLAlphaAnimation = new GLAlphaAnimation(0.0f, f2);
                    if (f2 > 0.2f) {
                        fd fdVar = this.ae;
                        if (fdVar != null) {
                            fdVar.j(Boolean.FALSE);
                        }
                    } else {
                        fd fdVar2 = this.ae;
                        if (fdVar2 != null) {
                            fdVar2.j(Boolean.TRUE);
                        }
                    }
                }
                gLAlphaAnimation.setInterpolator(new LinearInterpolator());
                gLAlphaAnimation.setDuration(j2);
                this.aL.a(i2, i3, i4, i5);
                this.aL.a(gLAlphaAnimation);
            }
        } catch (Throwable th) {
            eq.a(th);
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMaxZoomLevel(float f2) {
        this.c.setMaxZoomLevel(f2);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMinZoomLevel(float f2) {
        this.c.setMinZoomLevel(f2);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMyLocationEnabled(boolean z2) throws RemoteException {
        if (!this.ak) {
            try {
                fd fdVar = this.ae;
                if (fdVar != null) {
                    fdVar.f();
                    LocationSource locationSource = this.ar;
                    if (locationSource == null) {
                        this.ae.h(Boolean.FALSE);
                    } else if (z2) {
                        locationSource.activate(this.G);
                        this.ae.h(Boolean.TRUE);
                        if (this.aq == null) {
                            this.aq = new cv(this, this.f);
                        }
                    } else {
                        cv cvVar = this.aq;
                        if (cvVar != null) {
                            cvVar.c();
                            this.aq = null;
                        }
                        this.ar.deactivate();
                    }
                }
                if (!z2) {
                    this.ab.setMyLocationButtonEnabled(z2);
                }
                this.ai = z2;
                resetRenderTime();
            } catch (Throwable th) {
                hd.c(th, "AMapDelegateImp", "setMyLocationEnabled");
                th.printStackTrace();
                eq.a(th);
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMyLocationRotateAngle(float f2) throws RemoteException {
        try {
            cv cvVar = this.aq;
            if (cvVar != null) {
                cvVar.a(f2);
            }
        } catch (Throwable th) {
            eq.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMyLocationStyle(MyLocationStyle myLocationStyle) throws RemoteException {
        if (!this.ak) {
            try {
                if (this.aq == null) {
                    this.aq = new cv(this, this.f);
                }
                if (this.aq != null) {
                    long j2 = (long) 1000;
                    if (myLocationStyle.getInterval() < j2) {
                        myLocationStyle.interval(j2);
                    }
                    LocationSource locationSource = this.ar;
                    if (locationSource != null && (locationSource instanceof as)) {
                        ((as) locationSource).a(myLocationStyle.getInterval());
                        ((as) this.ar).a(myLocationStyle.getMyLocationType());
                    }
                    this.aq.a(myLocationStyle);
                }
            } catch (Throwable th) {
                eq.a(th);
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMyLocationType(int i2) throws RemoteException {
        try {
            cv cvVar = this.aq;
            if (cvVar != null && cvVar.a() != null) {
                this.aq.a().myLocationType(i2);
                setMyLocationStyle(this.aq.a());
            }
        } catch (Throwable th) {
            eq.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMyTrafficStyle(MyTrafficStyle myTrafficStyle) throws RemoteException {
        if (!this.ak) {
            try {
                this.aD = myTrafficStyle;
                if (!this.bc || !this.bd || myTrafficStyle == null) {
                    a aVar = this.bC;
                    aVar.c = false;
                    aVar.b = true;
                    aVar.g = 1;
                    return;
                }
                resetRenderTime();
                queueEvent(new Runnable() {
                    /* class com.amap.api.mapcore.util.c.AnonymousClass27 */

                    public void run() {
                        try {
                            c cVar = c.this;
                            cVar.g.setTrafficStyle(1, cVar.aD.getSmoothColor(), c.this.aD.getSlowColor(), c.this.aD.getCongestedColor(), c.this.aD.getSeriousCongestedColor());
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            } catch (Throwable th) {
                eq.a(th);
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setNaviLabelEnable(final boolean z2, final int i2, final int i3) throws RemoteException {
        try {
            if (!this.bc || !this.bd) {
                a aVar = this.bx;
                aVar.c = z2;
                aVar.h = i2;
                aVar.i = i3;
                aVar.b = true;
                aVar.g = 1;
                return;
            }
            resetRenderTime();
            queueEvent(new Runnable() {
                /* class com.amap.api.mapcore.util.c.AnonymousClass26 */

                public void run() {
                    try {
                        c.this.g.setNaviLabelEnable(1, z2, i2, i3);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        } catch (Throwable th) {
            eq.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnCameraChangeListener(AMap.OnCameraChangeListener onCameraChangeListener) throws RemoteException {
        AMap.OnCameraChangeListener onCameraChangeListener2 = this.y;
        if (onCameraChangeListener2 != null) {
            removeOnCameraChangeListener(onCameraChangeListener2);
        }
        this.y = onCameraChangeListener;
        addOnCameraChangeListener(onCameraChangeListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnIndoorBuildingActiveListener(AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) throws RemoteException {
        AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener2 = this.E;
        if (onIndoorBuildingActiveListener2 != null) {
            removeOnIndoorBuildingActiveListener(onIndoorBuildingActiveListener2);
        }
        this.E = onIndoorBuildingActiveListener;
        addOnIndoorBuildingActiveListener(onIndoorBuildingActiveListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnInfoWindowClickListener(AMap.OnInfoWindowClickListener onInfoWindowClickListener) throws RemoteException {
        AMap.OnInfoWindowClickListener onInfoWindowClickListener2 = this.D;
        if (onInfoWindowClickListener2 != null) {
            removeOnInfoWindowClickListener(onInfoWindowClickListener2);
        }
        this.D = onInfoWindowClickListener;
        addOnInfoWindowClickListener(onInfoWindowClickListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnMapClickListener(AMap.OnMapClickListener onMapClickListener) throws RemoteException {
        AMap.OnMapClickListener onMapClickListener2 = this.z;
        if (onMapClickListener2 != null) {
            removeOnMapClickListener(onMapClickListener2);
        }
        this.z = onMapClickListener;
        addOnMapClickListener(onMapClickListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnMapLongClickListener(AMap.OnMapLongClickListener onMapLongClickListener) throws RemoteException {
        AMap.OnMapLongClickListener onMapLongClickListener2 = this.C;
        if (onMapLongClickListener2 != null) {
            removeOnMapLongClickListener(onMapLongClickListener2);
        }
        this.C = onMapLongClickListener;
        addOnMapLongClickListener(onMapLongClickListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnMapTouchListener(AMap.OnMapTouchListener onMapTouchListener) throws RemoteException {
        AMap.OnMapTouchListener onMapTouchListener2 = this.A;
        if (onMapTouchListener2 != null) {
            removeOnMapTouchListener(onMapTouchListener2);
        }
        this.A = onMapTouchListener;
        addOnMapTouchListener(onMapTouchListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnMaploadedListener(AMap.OnMapLoadedListener onMapLoadedListener) throws RemoteException {
        AMap.OnMapLoadedListener onMapLoadedListener2 = this.x;
        if (onMapLoadedListener2 != null) {
            removeOnMapLoadedListener(onMapLoadedListener2);
        }
        this.x = onMapLoadedListener;
        addOnMapLoadedListener(onMapLoadedListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnMarkerClickListener(AMap.OnMarkerClickListener onMarkerClickListener) throws RemoteException {
        AMap.OnMarkerClickListener onMarkerClickListener2 = this.u;
        if (onMarkerClickListener2 != null) {
            removeOnMarkerClickListener(onMarkerClickListener2);
        }
        this.u = onMarkerClickListener;
        addOnMarkerClickListener(onMarkerClickListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnMarkerDragListener(AMap.OnMarkerDragListener onMarkerDragListener) throws RemoteException {
        AMap.OnMarkerDragListener onMarkerDragListener2 = this.w;
        if (onMarkerDragListener2 != null) {
            removeOnMarkerDragListener(onMarkerDragListener2);
        }
        this.w = onMarkerDragListener;
        addOnMarkerDragListener(onMarkerDragListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnMultiPointClickListener(AMap.OnMultiPointClickListener onMultiPointClickListener) {
        ax axVar = this.bn;
        if (axVar != null) {
            axVar.a(onMultiPointClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnMyLocationChangeListener(AMap.OnMyLocationChangeListener onMyLocationChangeListener) {
        try {
            AMap.OnMyLocationChangeListener onMyLocationChangeListener2 = this.F;
            if (onMyLocationChangeListener2 != null) {
                removeOnMyLocationChangeListener(onMyLocationChangeListener2);
            }
            this.F = onMyLocationChangeListener;
            addOnMyLocationChangeListener(onMyLocationChangeListener);
        } catch (Throwable unused) {
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnPOIClickListener(AMap.OnPOIClickListener onPOIClickListener) throws RemoteException {
        AMap.OnPOIClickListener onPOIClickListener2 = this.B;
        if (onPOIClickListener2 != null) {
            removeOnPOIClickListener(onPOIClickListener2);
        }
        this.B = onPOIClickListener;
        addOnPOIClickListener(onPOIClickListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnPolylineClickListener(AMap.OnPolylineClickListener onPolylineClickListener) throws RemoteException {
        AMap.OnPolylineClickListener onPolylineClickListener2 = this.v;
        if (onPolylineClickListener2 != null) {
            removeOnPolylineClickListener(onPolylineClickListener2);
        }
        this.v = onPolylineClickListener;
        addOnPolylineClickListener(onPolylineClickListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setRenderFps(int i2) {
        if (i2 == -1) {
            try {
                this.aN = i2;
            } catch (Throwable th) {
                eq.a(th);
                th.printStackTrace();
                return;
            }
        } else {
            this.aN = Math.max(10, Math.min(i2, 40));
        }
        eo.f(this.f);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setRenderMode(int i2) {
        try {
            IGLSurfaceView iGLSurfaceView = this.ad;
            if (iGLSurfaceView != null) {
                iGLSurfaceView.setRenderMode(i2);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setRoadArrowEnable(final boolean z2) throws RemoteException {
        try {
            if (!this.bc || !this.bd) {
                a aVar = this.bw;
                aVar.c = z2;
                aVar.b = true;
                aVar.g = 1;
                return;
            }
            resetRenderTime();
            queueEvent(new Runnable() {
                /* class com.amap.api.mapcore.util.c.AnonymousClass25 */

                public void run() {
                    try {
                        c.this.g.setRoadArrowEnable(1, z2);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        } catch (Throwable th) {
            eq.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setRunLowFrame(boolean z2) {
        if (!z2) {
            try {
                if (this.aN == -1) {
                    c();
                }
            } catch (Throwable th) {
                eq.a(th);
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setTouchPoiEnable(boolean z2) {
        MapConfig mapConfig = this.c;
        if (mapConfig != null) {
            mapConfig.setTouchPoiEnable(z2);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setTrafficEnabled(final boolean z2) throws RemoteException {
        try {
            if (!this.bc || this.ak) {
                a aVar = this.bq;
                aVar.c = z2;
                aVar.b = true;
                aVar.g = 1;
                return;
            }
            queueEvent(new Runnable(z2) {
                /* class com.amap.api.mapcore.util.c.AnonymousClass20 */
                final /* synthetic */ boolean a;

                {
                    this.a = r2;
                }

                public void run() {
                    try {
                        if (c.this.c.isTrafficEnabled() != this.a) {
                            c.this.c.setTrafficEnabled(z2);
                            c.this.aS.setTrafficMode(this.a);
                            c.this.g.setTrafficEnable(1, this.a);
                            c.this.resetRenderTime();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                        eq.a(th);
                    }
                }
            });
        } catch (Throwable th) {
            eq.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setVisibilityEx(int i2) {
        IGLSurfaceView iGLSurfaceView = this.ad;
        if (iGLSurfaceView != null) {
            try {
                iGLSurfaceView.setVisibility(i2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setWorldVectorMapStyle(String str) {
        if (!TextUtils.isEmpty(str) && this.c != null && !this.bF.equals(str)) {
            this.bF = str;
            jp jpVar = this.bD;
            if (jpVar != null) {
                jpVar.a("setWorldVectorMapStyle", str);
            }
            resetRenderTime();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setZOrderOnTop(boolean z2) throws RemoteException {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void setZoomPosition(int i2) {
        fd fdVar;
        if (!this.ak && (fdVar = this.ae) != null) {
            fdVar.a(Integer.valueOf(i2));
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setZoomScaleParam(float f2) {
        this.aW = f2;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void showCompassEnabled(boolean z2) {
        fd fdVar;
        if (!this.ak && (fdVar = this.ae) != null) {
            fdVar.d(Boolean.valueOf(z2));
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void showIndoorSwitchControlsEnabled(boolean z2) {
        fd fdVar;
        if (!this.ak && (fdVar = this.ae) != null) {
            fdVar.a(Boolean.valueOf(z2));
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void showInfoWindow(BaseOverlayImp baseOverlayImp) throws RemoteException {
        ar arVar;
        if (baseOverlayImp != null && (arVar = this.X) != null) {
            try {
                arVar.a(baseOverlayImp);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void showLogoEnabled(boolean z2) {
        if (!this.ak) {
            this.ae.f(Boolean.valueOf(z2));
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void showMyLocationButtonEnabled(boolean z2) {
        fd fdVar;
        if (!this.ak && (fdVar = this.ae) != null) {
            fdVar.c(Boolean.valueOf(z2));
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void showMyLocationOverlay(Location location) throws RemoteException {
        if (location != null) {
            try {
                if (this.ai) {
                    if (this.ar != null) {
                        if (this.aq == null) {
                            this.aq = new cv(this, this.f);
                        }
                        if (!(com.alibaba.wireless.security.aopsdk.replace.android.location.Location.getLongitude(location) == 0.0d || com.alibaba.wireless.security.aopsdk.replace.android.location.Location.getLatitude(location) == 0.0d)) {
                            this.aq.a(location);
                        }
                        List<AMap.OnMyLocationChangeListener> list = this.T;
                        if (list != null && list.size() > 0) {
                            for (int i2 = 0; i2 < this.T.size(); i2++) {
                                this.T.get(i2).onMyLocationChange(location);
                            }
                        }
                        resetRenderTime();
                        return;
                    }
                }
                cv cvVar = this.aq;
                if (cvVar != null) {
                    cvVar.c();
                }
                this.aq = null;
            } catch (Throwable th) {
                hd.c(th, "AMapDelegateImp", "showMyLocationOverlay");
                th.printStackTrace();
            }
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void showScaleEnabled(boolean z2) {
        fd fdVar;
        if (!this.ak && (fdVar = this.ae) != null) {
            fdVar.e(Boolean.valueOf(z2));
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void showZoomControlsEnabled(boolean z2) {
        fd fdVar;
        if (!this.ak && (fdVar = this.ae) != null) {
            fdVar.b(Boolean.valueOf(z2));
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void stopAnimation() throws RemoteException {
        try {
            GLMapEngine gLMapEngine = this.g;
            if (gLMapEngine != null) {
                gLMapEngine.interruptAnimation();
            }
            resetRenderTime();
        } catch (Throwable th) {
            eq.a(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public float toMapLenWithWin(int i2) {
        GLMapEngine gLMapEngine;
        if (!this.bc || this.an || (gLMapEngine = this.g) == null) {
            return 0.0f;
        }
        return gLMapEngine.getMapState(1).getGLUnitWithWin(i2);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void zoomOut(int i2) {
        if (this.bc && ((float) ((int) a(i2))) > this.c.getMinZoomLevel()) {
            try {
                animateCamera(ah.b());
            } catch (Throwable th) {
                hd.c(th, "AMapDelegateImp", "onDoubleTap");
                th.printStackTrace();
            }
            resetRenderTime();
        }
    }

    public c(IGLSurfaceView iGLSurfaceView, Context context, AttributeSet attributeSet, boolean z2) {
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = new ArrayList();
        this.J = new ArrayList();
        this.K = new ArrayList();
        this.L = new ArrayList();
        this.M = new ArrayList();
        this.N = new ArrayList();
        this.O = new ArrayList();
        this.P = new ArrayList();
        this.Q = new ArrayList();
        this.R = new ArrayList();
        this.S = new ArrayList();
        this.T = new ArrayList();
        this.U = new ArrayList();
        this.V = new ArrayList();
        this.Y = null;
        boolean z3 = false;
        this.a = false;
        this.ac = false;
        this.af = null;
        this.ag = new Object();
        this.ai = false;
        this.ak = false;
        this.am = new ArrayList();
        this.an = false;
        this.c = new MapConfig(true);
        this.ao = false;
        this.ap = false;
        this.as = false;
        this.at = null;
        this.au = null;
        this.av = false;
        this.aw = false;
        this.ax = false;
        this.ay = false;
        this.az = false;
        this.aA = true;
        this.aB = new Rect();
        this.aC = 1;
        this.aD = null;
        this.aG = false;
        this.aH = false;
        this.aI = false;
        this.aJ = 0;
        this.aM = -1;
        this.aN = -1;
        this.aO = new ArrayList();
        this.e = null;
        this.aU = false;
        this.aV = 0.0f;
        this.aW = 1.0f;
        this.aX = 1.0f;
        this.aY = true;
        this.aZ = false;
        this.ba = false;
        this.bb = 0;
        this.bc = false;
        this.bd = false;
        this.be = false;
        this.bf = false;
        this.bg = new ReentrantLock();
        this.bh = 0;
        this.j = new Handler(Looper.getMainLooper()) {
            /* class com.amap.api.mapcore.util.c.AnonymousClass1 */

            public void handleMessage(Message message) {
                if (message != null && !c.this.ak) {
                    try {
                        int i = message.what;
                        if (i != 2) {
                            boolean z = true;
                            int i2 = 0;
                            switch (i) {
                                case 10:
                                    CameraPosition cameraPosition = (CameraPosition) message.obj;
                                    if (cameraPosition != null) {
                                        try {
                                            if (c.this.M != null && c.this.M.size() > 0) {
                                                for (AMap.OnCameraChangeListener onCameraChangeListener : c.this.M) {
                                                    onCameraChangeListener.onCameraChange(cameraPosition);
                                                }
                                            }
                                        } catch (Throwable th) {
                                            eq.a(th);
                                        }
                                    }
                                    c.this.c.addChangedCounter();
                                    return;
                                case 11:
                                    try {
                                        CameraPosition cameraPosition2 = c.this.getCameraPosition();
                                        if (!(cameraPosition2 == null || c.this.ae == null)) {
                                            c.this.ae.a(cameraPosition2);
                                        }
                                        c.this.a((c) cameraPosition2);
                                        if (c.this.ba) {
                                            c.this.ba = false;
                                            if (c.this.af != null) {
                                                c.this.af.b(false);
                                            }
                                            c.this.a(true);
                                        }
                                        if (c.this.ay) {
                                            c.this.redrawInfoWindow();
                                            c.this.ay = false;
                                        }
                                        c.this.a(true, cameraPosition2);
                                        return;
                                    } catch (Throwable th2) {
                                        hd.c(th2, "AMapDelegateImp", "CameraUpdateFinish");
                                        eq.a(th2);
                                        return;
                                    }
                                case 12:
                                    if (c.this.ae != null) {
                                        c.this.ae.a(Float.valueOf(c.this.getZoomLevel()));
                                        return;
                                    }
                                    return;
                                case 13:
                                    if (c.this.ae != null) {
                                        c.this.ae.k();
                                        return;
                                    }
                                    return;
                                case 14:
                                    try {
                                        if (c.this.O != null && c.this.O.size() > 0) {
                                            for (AMap.OnMapTouchListener onMapTouchListener : c.this.O) {
                                                onMapTouchListener.onTouch((MotionEvent) message.obj);
                                            }
                                            return;
                                        }
                                        return;
                                    } catch (Throwable th3) {
                                        hd.c(th3, "AMapDelegateImp", "onTouchHandler");
                                        th3.printStackTrace();
                                        return;
                                    }
                                case 15:
                                    Bitmap bitmap = (Bitmap) message.obj;
                                    int i3 = message.arg1;
                                    if (bitmap == null || c.this.ae == null) {
                                        if (c.this.U != null && c.this.U.size() > 0) {
                                            for (int i4 = 0; i4 < c.this.U.size(); i4++) {
                                                ((AMap.onMapPrintScreenListener) c.this.U.get(i4)).onMapPrint(null);
                                            }
                                        }
                                        if (c.this.V != null && c.this.V.size() > 0) {
                                            while (i2 < c.this.V.size()) {
                                                ((AMap.OnMapScreenShotListener) c.this.V.get(i2)).onMapScreenShot(null);
                                                ((AMap.OnMapScreenShotListener) c.this.V.get(i2)).onMapScreenShot(null, i3);
                                                i2++;
                                            }
                                        }
                                    } else {
                                        Canvas canvas = new Canvas(bitmap);
                                        fg g = c.this.ae.g();
                                        if (g != null) {
                                            g.onDraw(canvas);
                                        }
                                        c.this.ae.a(canvas);
                                        try {
                                            if (c.this.U != null && c.this.U.size() > 0) {
                                                for (int i5 = 0; i5 < c.this.U.size(); i5++) {
                                                    ((AMap.onMapPrintScreenListener) c.this.U.get(i5)).onMapPrint(new BitmapDrawable(c.this.f.getResources(), bitmap));
                                                }
                                            }
                                            if (c.this.V != null && c.this.V.size() > 0) {
                                                while (i2 < c.this.V.size()) {
                                                    ((AMap.OnMapScreenShotListener) c.this.V.get(i2)).onMapScreenShot(bitmap);
                                                    ((AMap.OnMapScreenShotListener) c.this.V.get(i2)).onMapScreenShot(bitmap, i3);
                                                    i2++;
                                                }
                                            }
                                        } catch (Throwable unused) {
                                        }
                                    }
                                    c cVar = c.this;
                                    cVar.a((c) cVar.U);
                                    c cVar2 = c.this;
                                    cVar2.a((c) cVar2.V);
                                    return;
                                case 16:
                                    if (c.this.L != null) {
                                        while (i2 < c.this.L.size()) {
                                            try {
                                                ((AMap.OnMapLoadedListener) c.this.L.get(i2)).onMapLoaded();
                                                i2++;
                                            } catch (Throwable th4) {
                                                hd.c(th4, "AMapDelegateImp", "onMapLoaded");
                                                th4.printStackTrace();
                                                eq.a(th4);
                                            }
                                        }
                                    }
                                    if (c.this.ae != null) {
                                        c.this.ae.l();
                                        return;
                                    }
                                    return;
                                case 17:
                                    if (c.this.g.isInMapAnimation(1) && c.this.af != null) {
                                        c.this.af.b(false);
                                    }
                                    if (c.this.af != null) {
                                        ab abVar = c.this.af;
                                        if (message.arg1 == 0) {
                                            z = false;
                                        }
                                        abVar.a(z);
                                        return;
                                    }
                                    return;
                                case 18:
                                    if (c.this.X != null && c.this.ap) {
                                        c.this.X.c();
                                        return;
                                    }
                                    return;
                                case 19:
                                    if (c.this.N != null) {
                                        DPoint obtain = DPoint.obtain();
                                        c.this.getPixel2LatLng(message.arg1, message.arg2, obtain);
                                        try {
                                            for (AMap.OnMapClickListener onMapClickListener : c.this.N) {
                                                onMapClickListener.onMapClick(new LatLng(obtain.y, obtain.x));
                                            }
                                            obtain.recycle();
                                            return;
                                        } catch (Throwable th5) {
                                            hd.c(th5, "AMapDelegateImp", "OnMapClickListener.onMapClick");
                                            th5.printStackTrace();
                                            return;
                                        }
                                    } else {
                                        return;
                                    }
                                case 20:
                                    try {
                                        if (c.this.P != null && c.this.P.size() > 0) {
                                            while (i2 < c.this.P.size()) {
                                                ((AMap.OnPOIClickListener) c.this.P.get(i2)).onPOIClick((Poi) message.obj);
                                                i2++;
                                            }
                                            return;
                                        }
                                        return;
                                    } catch (Throwable th6) {
                                        hd.c(th6, "AMapDelegateImp", "OnPOIClickListener.onPOIClick");
                                        th6.printStackTrace();
                                        return;
                                    }
                                default:
                                    return;
                            }
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Key验证失败：[");
                            Object obj = message.obj;
                            if (obj != null) {
                                sb.append(obj);
                            } else {
                                sb.append(gd.b);
                            }
                            sb.append(jl1.ARRAY_END_STR);
                            Log.w("amapsdk", sb.toString());
                        }
                    } catch (Throwable th7) {
                        hd.c(th7, "AMapDelegateImp", "handleMessage");
                        th7.printStackTrace();
                    }
                }
            }
        };
        this.bq = new a() {
            /* class com.amap.api.mapcore.util.c.AnonymousClass11 */

            @Override // com.amap.api.mapcore.util.c.a
            public void run() {
                super.run();
                try {
                    c.this.setTrafficEnabled(this.c);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        this.br = new a() {
            /* class com.amap.api.mapcore.util.c.AnonymousClass21 */

            @Override // com.amap.api.mapcore.util.c.a
            public void run() {
                super.run();
                try {
                    c cVar = c.this;
                    cVar.setCenterToPixel(cVar.bi, c.this.bj);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        this.bs = new a() {
            /* class com.amap.api.mapcore.util.c.AnonymousClass32 */

            @Override // com.amap.api.mapcore.util.c.a
            public void run() {
                super.run();
                c.this.b(this.g, this.d, this.e, this.f);
            }
        };
        this.bt = new a() {
            /* class com.amap.api.mapcore.util.c.AnonymousClass34 */

            @Override // com.amap.api.mapcore.util.c.a
            public void run() {
                super.run();
                c.this.setMapCustomEnable(this.c);
            }
        };
        this.bu = new a() {
            /* class com.amap.api.mapcore.util.c.AnonymousClass35 */

            @Override // com.amap.api.mapcore.util.c.a
            public void run() {
                super.run();
                c.this.a(this.g, this.c);
            }
        };
        this.bv = new a() {
            /* class com.amap.api.mapcore.util.c.AnonymousClass36 */

            @Override // com.amap.api.mapcore.util.c.a
            public void run() {
                super.run();
                try {
                    c.this.setMapTextEnable(this.c);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        this.bw = new a() {
            /* class com.amap.api.mapcore.util.c.AnonymousClass37 */

            @Override // com.amap.api.mapcore.util.c.a
            public void run() {
                super.run();
                try {
                    c.this.setRoadArrowEnable(this.c);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        this.bx = new a() {
            /* class com.amap.api.mapcore.util.c.AnonymousClass38 */

            @Override // com.amap.api.mapcore.util.c.a
            public void run() {
                super.run();
                try {
                    c.this.setNaviLabelEnable(this.c, this.h, this.i);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        this.by = new a() {
            /* class com.amap.api.mapcore.util.c.AnonymousClass2 */

            @Override // com.amap.api.mapcore.util.c.a
            public void run() {
                super.run();
                c.this.b(this.g, this.c);
            }
        };
        this.bz = new a() {
            /* class com.amap.api.mapcore.util.c.AnonymousClass3 */

            @Override // com.amap.api.mapcore.util.c.a
            public void run() {
                super.run();
                try {
                    c.this.setIndoorEnabled(this.c);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        this.bA = new Runnable() {
            /* class com.amap.api.mapcore.util.c.AnonymousClass4 */

            public void run() {
                fg g;
                if (c.this.ae != null && (g = c.this.ae.g()) != null) {
                    g.d();
                }
            }
        };
        this.bB = new a() {
            /* class com.amap.api.mapcore.util.c.AnonymousClass5 */

            @Override // com.amap.api.mapcore.util.c.a
            public void run() {
                super.run();
                c.this.c(this.g, this.c);
            }
        };
        this.bC = new a() {
            /* class com.amap.api.mapcore.util.c.AnonymousClass6 */

            @Override // com.amap.api.mapcore.util.c.a
            public void run() {
                super.run();
                try {
                    c cVar = c.this;
                    cVar.setMyTrafficStyle(cVar.aD);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        this.bE = "";
        this.bF = "";
        this.bG = new EAMapPlatformGestureInfo();
        this.k = new Point();
        this.l = new Rect();
        this.bH = 0;
        this.m = null;
        this.bI = null;
        this.n = new float[16];
        this.o = new float[16];
        this.p = new float[16];
        this.bJ = null;
        this.q = new float[12];
        this.r = "precision highp float;\nattribute vec3 aVertex;//顶点数组,三维坐标\nuniform mat4 aMVPMatrix;//mvp矩阵\nvoid main(){\n  gl_Position = aMVPMatrix * vec4(aVertex, 1.0);\n}";
        this.s = "//有颜色 没有纹理\nprecision highp float;\nvoid main(){\n  gl_FragColor = vec4(1.0,0,0,1.0);\n}";
        this.t = -1;
        this.f = context;
        jm.a();
        this.bD = new jp(this.f, this, z2);
        this.aR = new g(context, this, iGLSurfaceView);
        hd.a(this.f);
        ea.a().a(this.f);
        m.b = gc.c(context);
        dr.a(this.f);
        this.aT = new p(this);
        this.g = new GLMapEngine(this.f, this);
        GLMapRender gLMapRender = new GLMapRender(this);
        this.aS = gLMapRender;
        this.ad = iGLSurfaceView;
        iGLSurfaceView.setRenderer(gLMapRender);
        this.ab = new ac(this);
        fd fdVar = new fd(this.f, this);
        this.ae = fdVar;
        fdVar.a(new C0145c());
        this.bk = new b();
        this.ah = new r(this);
        this.b = new u(this.f, this);
        this.al = new o(this.f, this);
        iGLSurfaceView.setRenderMode(0);
        this.aS.setRenderFps(15.0f);
        this.g.setMapListener(this);
        this.aa = new z(this);
        this.G = new h(this);
        this.Y = new da(this, context);
        ar arVar = new ar(this.f);
        this.X = arVar;
        arVar.a(this.ae);
        this.X.b(this.Y);
        this.aL = new v();
        this.aE = new k(this.f, this);
        this.ar = new as(this.f);
        this.bn = new ax(this);
        this.bm = new s();
        this.aP = new dg(this.f, this);
        di diVar = new di(this.f);
        this.aQ = diVar;
        diVar.a(this);
        b(z2);
        MapConfig mapConfig = this.c;
        b bVar = new b(this, this.f, mapConfig != null ? mapConfig.isAbroadEnable() : z3);
        this.bo = bVar;
        bVar.a(this);
    }

    private boolean d(MotionEvent motionEvent) {
        try {
            List<AMap.OnPolylineClickListener> list = this.J;
            if (list != null && list.size() > 0) {
                DPoint obtain = DPoint.obtain();
                getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), obtain);
                LatLng latLng = new LatLng(obtain.y, obtain.x);
                obtain.recycle();
                IOverlayDelegate a2 = this.ah.a(latLng);
                if (a2 != null) {
                    for (AMap.OnPolylineClickListener onPolylineClickListener : this.J) {
                        onPolylineClickListener.onPolylineClick(new Polyline((IPolylineDelegate) a2));
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private void e() {
        GLMapState gLMapState;
        GLMapEngine gLMapEngine = this.g;
        if (gLMapEngine != null && (gLMapState = (GLMapState) gLMapEngine.getNewMapState(1)) != null) {
            IPoint obtain = IPoint.obtain();
            gLMapState.recalculate();
            gLMapState.getMapGeoCenter(obtain);
            this.c.setSX((double) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(obtain));
            this.c.setSY((double) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(obtain));
            this.c.setSZ(gLMapState.getMapZoomer());
            this.c.setSC(gLMapState.getCameraDegree());
            this.c.setSR(gLMapState.getMapAngle());
            gLMapState.recycle();
            obtain.recycle();
        }
    }

    private LatLng f() {
        MapConfig mapConfig = this.c;
        if (mapConfig == null) {
            return null;
        }
        DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(mapConfig.getSX(), this.c.getSY(), 20);
        LatLng latLng = new LatLng(pixelsToLatLong.y, pixelsToLatLong.x, false);
        pixelsToLatLong.recycle();
        return latLng;
    }

    private synchronized void g() {
        synchronized (this.aO) {
            int size = this.aO.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.aO.get(i2).j().recycle();
            }
            this.aO.clear();
        }
    }

    private void h(final int i2) {
        if (this.bc) {
            this.aT.a();
            this.aU = true;
            this.aZ = true;
            try {
                stopAnimation();
            } catch (RemoteException unused) {
            }
            queueEvent(new Runnable() {
                /* class com.amap.api.mapcore.util.c.AnonymousClass7 */

                public void run() {
                    try {
                        c.this.g.clearAllMessages(i2);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    private void i(int i2) {
        this.aU = true;
        this.aZ = false;
        if (this.aw) {
            this.aw = false;
        }
        if (this.av) {
            this.av = false;
        }
        if (this.ax) {
            this.ax = false;
        }
        this.as = false;
        List<AMap.OnMarkerDragListener> list = this.K;
        if (!(list == null || list.size() <= 0 || this.at == null)) {
            for (int i3 = 0; i3 < this.K.size(); i3++) {
                try {
                    this.K.get(i3).onMarkerDragEnd(this.at);
                } catch (Throwable th) {
                    hd.c(th, "AMapDelegateImp", "OnMarkerDragListener.onMarkerDragEnd");
                    th.printStackTrace();
                }
            }
            this.at = null;
        }
        this.ad.postDelayed(new Runnable() {
            /* class com.amap.api.mapcore.util.c.AnonymousClass8 */

            public void run() {
                c.this.bb = 1;
            }
        }, 300);
    }

    private void j() {
        if (!this.aG) {
            try {
                this.aE.setName("AuthThread");
                this.aE.start();
                this.aG = true;
            } catch (Throwable th) {
                th.printStackTrace();
                eq.a(th);
            }
        }
    }

    private void k() {
        if (!this.aH) {
            try {
                if (this.aF == null) {
                    this.aF = new i(this.f, this);
                }
                this.aF.setName("AuthProThread");
                this.aF.start();
                this.aH = true;
            } catch (Throwable th) {
                th.printStackTrace();
                eq.a(th);
            }
        }
    }

    private void l() {
        try {
            LatLngBounds limitLatLngBounds = this.c.getLimitLatLngBounds();
            if (this.g != null && a(limitLatLngBounds)) {
                GLMapState gLMapState = new GLMapState(1, this.g.getNativeInstance());
                IPoint obtain = IPoint.obtain();
                LatLng latLng = limitLatLngBounds.northeast;
                GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, obtain);
                IPoint obtain2 = IPoint.obtain();
                LatLng latLng2 = limitLatLngBounds.southwest;
                GLMapState.lonlat2Geo(latLng2.longitude, latLng2.latitude, obtain2);
                this.c.setLimitIPoints(new IPoint[]{obtain, obtain2});
                gLMapState.recycle();
                return;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.c.setLimitIPoints(null);
    }

    private void m() {
        a(this.T);
        a(this.I);
        a(this.J);
        a(this.K);
        a(this.L);
        a(this.M);
        a(this.N);
        a(this.O);
        a(this.P);
        a(this.Q);
        a(this.R);
        a(this.S);
        a(this.U);
        a(this.V);
        a(this.am);
        this.G = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void animateCamera(AbstractCameraUpdateMessage abstractCameraUpdateMessage) throws RemoteException {
        animateCameraWithDurationAndCallback(abstractCameraUpdateMessage, 250, (AMap.CancelableCallback) null);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void animateCameraWithDurationAndCallback(AbstractCameraUpdateMessage abstractCameraUpdateMessage, long j2, AMap.CancelableCallback cancelableCallback) {
        if (abstractCameraUpdateMessage != null && !this.ak && this.g != null) {
            abstractCameraUpdateMessage.mCallback = cancelableCallback;
            abstractCameraUpdateMessage.mDuration = j2;
            if (this.an || getMapHeight() == 0 || getMapWidth() == 0) {
                try {
                    moveCamera(abstractCameraUpdateMessage);
                    AMap.CancelableCallback cancelableCallback2 = abstractCameraUpdateMessage.mCallback;
                    if (cancelableCallback2 != null) {
                        cancelableCallback2.onFinish();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    eq.a(th);
                }
            } else {
                try {
                    this.g.interruptAnimation();
                    resetRenderTime();
                    a(abstractCameraUpdateMessage);
                    this.g.addMessage(abstractCameraUpdateMessage, true);
                } catch (Throwable th2) {
                    eq.a(th2);
                    th2.printStackTrace();
                }
            }
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public x getTextureItem(BitmapDescriptor bitmapDescriptor, boolean z2) {
        if (bitmapDescriptor == null || bitmapDescriptor.getBitmap() == null || bitmapDescriptor.getBitmap().isRecycled()) {
            return null;
        }
        synchronized (this.aO) {
            for (int i2 = 0; i2 < this.aO.size(); i2++) {
                x xVar = this.aO.get(i2);
                if (!z2 || xVar.k() != getBaseOverlayTextureID()) {
                    if (xVar.j().equals(bitmapDescriptor)) {
                        return xVar;
                    }
                }
            }
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void removecache(AMap.OnCacheRemoveListener onCacheRemoveListener) throws RemoteException {
        if (this.j != null && this.g != null) {
            try {
                d dVar = new d(this.f, onCacheRemoveListener);
                this.j.removeCallbacks(dVar);
                this.j.post(dVar);
            } catch (Throwable th) {
                hd.c(th, "AMapDelegateImp", "removecache");
                th.printStackTrace();
                eq.a(th);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void c(final MotionEvent motionEvent) {
        this.j.post(new Runnable() {
            /* class com.amap.api.mapcore.util.c.AnonymousClass10 */

            public void run() {
                Message obtain = Message.obtain();
                obtain.what = 19;
                obtain.arg1 = (int) motionEvent.getX();
                obtain.arg2 = (int) motionEvent.getY();
                c.this.j.sendMessage(obtain);
            }
        });
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void moveCamera(AbstractCameraUpdateMessage abstractCameraUpdateMessage) throws RemoteException {
        GLMapEngine gLMapEngine = this.g;
        if (gLMapEngine != null && !this.ak) {
            try {
                if (this.an && gLMapEngine.getStateMessageCount() > 0) {
                    AbstractCameraUpdateMessage c2 = ah.c();
                    c2.nowType = AbstractCameraUpdateMessage.Type.changeGeoCenterZoomTiltBearing;
                    c2.geoPoint = new DPoint(this.c.getSX(), this.c.getSY());
                    c2.zoom = this.c.getSZ();
                    c2.bearing = this.c.getSR();
                    c2.tilt = this.c.getSC();
                    this.g.addMessage(abstractCameraUpdateMessage, false);
                    while (this.g.getStateMessageCount() > 0) {
                        AbstractCameraUpdateMessage stateMessage = this.g.getStateMessage();
                        if (stateMessage != null) {
                            stateMessage.mergeCameraUpdateDelegate(c2);
                        }
                    }
                    abstractCameraUpdateMessage = c2;
                }
            } catch (Throwable th) {
                eq.a(th);
            }
            resetRenderTime();
            this.g.clearAnimations(1, false);
            abstractCameraUpdateMessage.isChangeFinished = true;
            a(abstractCameraUpdateMessage);
            this.g.addMessage(abstractCameraUpdateMessage, false);
        }
    }

    private boolean b(CameraPosition cameraPosition) {
        if (cameraPosition.zoom < 6.0f) {
            return false;
        }
        if (cameraPosition.isAbroad) {
            return true;
        }
        MapConfig mapConfig = this.c;
        if (mapConfig == null) {
            return false;
        }
        try {
            return !ej.a(mapConfig.getGeoRectangle().getClipRect());
        } catch (Throwable th) {
            th.printStackTrace();
            eq.a(th);
            return false;
        }
    }

    public void c(int i2) {
        GLMapRender gLMapRender = this.aS;
        if (gLMapRender != null) {
            gLMapRender.renderPause();
        }
        f(i2);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setInfoWindowAdapter(AMap.CommonInfoWindowAdapter commonInfoWindowAdapter) throws RemoteException {
        ar arVar;
        if (!this.ak && (arVar = this.X) != null) {
            arVar.a(commonInfoWindowAdapter);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036 A[Catch:{ all -> 0x004c }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003d A[Catch:{ all -> 0x004c }] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0025 A[Catch:{ all -> 0x004c }] */
    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void clear(boolean z2) throws RemoteException {
        String str;
        ab abVar;
        fd fdVar;
        ax axVar;
        try {
            hideInfoWindow();
            cv cvVar = this.aq;
            String str2 = null;
            if (cvVar != null) {
                if (z2) {
                    String d2 = cvVar.d();
                    str2 = this.aq.e();
                    str = d2;
                    this.ah.b(str2);
                    abVar = this.af;
                    if (abVar != null) {
                        abVar.c();
                    }
                    this.b.b(str);
                    this.al.b();
                    fdVar = this.ae;
                    if (fdVar != null) {
                        fdVar.j();
                    }
                    axVar = this.bn;
                    if (axVar != null) {
                        axVar.c();
                    }
                    queueEvent(new Runnable() {
                        /* class com.amap.api.mapcore.util.c.AnonymousClass19 */

                        public void run() {
                            c cVar = c.this;
                            if (cVar.g != null && !cVar.ak) {
                                c cVar2 = c.this;
                                cVar2.g.removeNativeAllOverlay(cVar2.aj);
                            }
                        }
                    });
                    resetRenderTime();
                }
                cvVar.f();
            }
            str = null;
            this.ah.b(str2);
            abVar = this.af;
            if (abVar != null) {
            }
            this.b.b(str);
            this.al.b();
            fdVar = this.ae;
            if (fdVar != null) {
            }
            axVar = this.bn;
            if (axVar != null) {
            }
            queueEvent(new Runnable() {
                /* class com.amap.api.mapcore.util.c.AnonymousClass19 */

                public void run() {
                    c cVar = c.this;
                    if (cVar.g != null && !cVar.ak) {
                        c cVar2 = c.this;
                        cVar2.g.removeNativeAllOverlay(cVar2.aj);
                    }
                }
            });
            resetRenderTime();
        } catch (Throwable th) {
            hd.c(th, "AMapDelegateImp", com.youku.live.livesdk.wkit.component.Constants.TAG_CLEAR_STRING);
            eq.a(th);
            th.printStackTrace();
        }
    }

    private boolean f(MotionEvent motionEvent) {
        if (this.bn == null) {
            return false;
        }
        IPoint obtain = IPoint.obtain();
        if (this.g != null) {
            getPixel2Geo((int) motionEvent.getX(), (int) motionEvent.getY(), obtain);
        }
        boolean a2 = this.bn.a(obtain);
        obtain.recycle();
        return a2;
    }

    public void c() {
        GLMapRender gLMapRender;
        if (this.bc && (gLMapRender = this.aS) != null && !gLMapRender.isRenderPause()) {
            requestRender();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(CameraPosition cameraPosition) {
        if (this.c.getMapLanguage().equals("en")) {
            boolean b2 = b(cameraPosition);
            if (b2 != this.aA) {
                this.aA = b2;
                b(1, b2);
            }
        } else if (!this.aA) {
            this.aA = true;
            b(1, true);
        }
    }

    private void h() {
        try {
            this.c.setMapRect(eq.a((IAMapDelegate) this, true));
            GLMapState gLMapState = (GLMapState) this.g.getNewMapState(1);
            if (gLMapState != null) {
                gLMapState.recalculate();
                gLMapState.getPixel20Bound(this.l, getMapWidth(), getMapHeight());
                this.c.getGeoRectangle().updateRect(this.l, (int) this.c.getSX(), (int) this.c.getSY());
                this.c.setMapPerPixelUnitLength(gLMapState.getGLUnitWithWin(1));
                gLMapState.recycle();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean g(MotionEvent motionEvent) throws RemoteException {
        try {
            ar arVar = this.X;
            if (arVar != null && arVar.a(motionEvent)) {
                List<AMap.OnInfoWindowClickListener> list = this.R;
                if (list != null && list.size() > 0) {
                    BaseOverlayImp d2 = this.b.d();
                    if (!d2.isVisible() && d2.isInfoWindowEnable()) {
                        return true;
                    }
                    Marker marker = new Marker((cu) d2);
                    for (int i2 = 0; i2 < this.R.size(); i2++) {
                        this.R.get(i2).onInfoWindowClick(marker);
                    }
                }
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public void c(final int i2, final boolean z2) {
        if (!this.bc || !this.bd) {
            a aVar = this.bB;
            aVar.c = z2;
            aVar.b = true;
            aVar.g = i2;
            return;
        }
        resetRenderTime();
        queueEvent(new Runnable() {
            /* class com.amap.api.mapcore.util.c.AnonymousClass18 */

            public void run() {
                try {
                    if (z2) {
                        c.this.g.setBuildingTextureEnable(i2, true);
                    } else {
                        c.this.g.setBuildingTextureEnable(i2, false);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    private void b(boolean z2) {
        jp jpVar = this.bD;
        if (jpVar != null) {
            Object a2 = jpVar.a("getAbroadEnable");
            if (a2 != null && (a2 instanceof Boolean)) {
                MapConfig mapConfig = this.c;
                if (mapConfig != null) {
                    mapConfig.setAbroadEnable(z2 && ((Boolean) a2).booleanValue());
                }
                if (z2 && ((Boolean) a2).booleanValue()) {
                    MapsInitializer.setSupportRecycleView(false);
                }
            }
            Object a3 = this.bD.a("getLogoEnable");
            if (a3 != null && (a3 instanceof Boolean)) {
                this.ae.a(((Boolean) a3).booleanValue());
            }
            Object a4 = this.bD.a("getMapZindex");
            if (a3 != null && (a3 instanceof Integer)) {
                this.aJ = ((Integer) a4).intValue();
            }
        }
    }

    public void d(int i2) {
        f(i2);
        GLMapRender gLMapRender = this.aS;
        if (gLMapRender != null) {
            gLMapRender.renderResume();
        }
    }

    public void f(final int i2) {
        queueEvent(new Runnable() {
            /* class com.amap.api.mapcore.util.c.AnonymousClass15 */

            public void run() {
                try {
                    c.this.g.clearAllMessages(i2);
                    c.this.g.clearAnimations(i2, true);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void setCustomMapStyle(boolean z2, byte[] bArr) {
        a(z2, bArr, false);
    }

    private boolean e(MotionEvent motionEvent) throws RemoteException {
        LatLng realPosition;
        if (this.b.b(motionEvent)) {
            BaseOverlayImp d2 = this.b.d();
            boolean z2 = true;
            if (d2 == null) {
                return true;
            }
            try {
                Marker marker = new Marker((cu) d2);
                this.b.a((IMarkerDelegate) ((cu) d2));
                List<AMap.OnMarkerClickListener> list = this.I;
                if (list != null && list.size() > 0) {
                    if (this.I.size() == 1) {
                        boolean onMarkerClick = this.I.get(0).onMarkerClick(marker);
                        if (!onMarkerClick) {
                            if (this.b.g() > 0) {
                                z2 = onMarkerClick;
                            }
                        }
                        return true;
                    }
                    boolean z3 = false;
                    for (AMap.OnMarkerClickListener onMarkerClickListener : this.I) {
                        z3 |= onMarkerClickListener.onMarkerClick(marker);
                    }
                    if (!z3) {
                        if (this.b.g() > 0) {
                            z2 = z3;
                        }
                    }
                    return true;
                }
                showInfoWindow((cu) d2);
                if (!d2.isViewMode() && (realPosition = d2.getRealPosition()) != null) {
                    IPoint obtain = IPoint.obtain();
                    latlon2Geo(realPosition.latitude, realPosition.longitude, obtain);
                    moveCamera(ah.a(obtain));
                }
                return z2;
            } catch (Throwable th) {
                hd.c(th, "AMapDelegateImp", "onMarkerTap");
                th.printStackTrace();
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void d() {
        AMapNativeRenderer.nativeDrawLineInit();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMapCustomEnable(boolean z2) {
        if (z2) {
            k();
        }
        setMapCustomEnable(z2, false);
    }

    public float a(int i2) {
        if (this.c != null) {
            return getMapConfig().getSZ();
        }
        return 0.0f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003d A[Catch:{ all -> 0x007a }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0060 A[Catch:{ all -> 0x007a }] */
    public void g(int i2) {
        int i3;
        int i4;
        int i5;
        this.aC = i2;
        if (i2 != 1) {
            if (i2 == 2) {
                i5 = 1;
                i4 = 0;
                i3 = 0;
                this.c.setMapStyleMode(i5);
                this.c.setMapStyleTime(i4);
                this.c.setMapStyleState(i3);
                if (!this.c.isCustomStyleEnable()) {
                    b bVar = this.bo;
                    if (bVar == null || !bVar.d()) {
                        a(1, i5, i4, i3, true, false, (StyleItem[]) null);
                        this.c.setCustomStyleEnable(false);
                    } else {
                        this.bo.e();
                    }
                    this.ab.setLogoEnable(true);
                } else {
                    if (this.c.getMapLanguage().equals("en")) {
                        setMapLanguage("zh_cn");
                    }
                    b(1, i5, i4, i3);
                }
                resetRenderTime();
            }
            if (i2 == 3) {
                i5 = 0;
                i4 = 1;
            } else if (i2 == 4) {
                i5 = 0;
                i4 = 0;
            } else if (i2 == 5) {
                i5 = 2;
                i4 = 0;
                i3 = 5;
                this.c.setMapStyleMode(i5);
                this.c.setMapStyleTime(i4);
                this.c.setMapStyleState(i3);
                if (!this.c.isCustomStyleEnable()) {
                }
                resetRenderTime();
            } else {
                try {
                    this.aC = 1;
                } catch (Throwable th) {
                    hd.c(th, "AMapDelegateImp", "setMaptype");
                    th.printStackTrace();
                    eq.a(th);
                    return;
                }
            }
            i3 = 4;
            this.c.setMapStyleMode(i5);
            this.c.setMapStyleTime(i4);
            this.c.setMapStyleState(i3);
            if (!this.c.isCustomStyleEnable()) {
            }
            resetRenderTime();
        }
        i5 = 0;
        i4 = 0;
        i3 = 0;
        this.c.setMapStyleMode(i5);
        this.c.setMapStyleTime(i4);
        this.c.setMapStyleState(i3);
        if (!this.c.isCustomStyleEnable()) {
        }
        resetRenderTime();
    }

    private void i() {
        if (!this.ap) {
            this.j.sendEmptyMessage(16);
            this.ap = true;
            a(true);
        }
        long j2 = this.bH;
        if (j2 < ((long) 2)) {
            this.bH = j2 + 1;
            return;
        }
        final ez d2 = this.ae.d();
        if (d2 != null && d2.getVisibility() != 8) {
            eo.a(this.f, System.currentTimeMillis() - this.bp);
            this.j.post(new Runnable() {
                /* class com.amap.api.mapcore.util.c.AnonymousClass12 */

                public void run() {
                    if (!c.this.an) {
                        try {
                            c cVar = c.this;
                            aq aqVar = cVar.d;
                            if (aqVar != null) {
                                cVar.setIndoorBuildingInfo(aqVar);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        d2.a(false);
                    }
                }
            });
        }
    }

    public boolean a(int i2, int i3, int i4) {
        AbstractCameraUpdateMessage abstractCameraUpdateMessage;
        if (!this.bc || ((float) ((int) a(i2))) >= this.c.getMaxZoomLevel()) {
            return false;
        }
        try {
            if (this.ao) {
                abstractCameraUpdateMessage = ah.a(1.0f, (Point) null);
            } else if (!this.ab.isZoomInByScreenCenter()) {
                Point point = this.k;
                point.x = i3;
                point.y = i4;
                abstractCameraUpdateMessage = ah.a(1.0f, point);
            } else {
                abstractCameraUpdateMessage = ah.a(1.0f, (Point) null);
            }
            animateCamera(abstractCameraUpdateMessage);
        } catch (Throwable th) {
            hd.c(th, "AMapDelegateImp", "onDoubleTap");
            th.printStackTrace();
        }
        resetRenderTime();
        return true;
    }

    private void b(final MotionEvent motionEvent) {
        queueEvent(new Runnable() {
            /* class com.amap.api.mapcore.util.c.AnonymousClass9 */

            public void run() {
                try {
                    Message obtain = Message.obtain();
                    Poi poi = null;
                    MapConfig mapConfig = c.this.c;
                    if (mapConfig != null && mapConfig.isTouchPoiEnable()) {
                        poi = c.this.b((int) motionEvent.getX(), (int) motionEvent.getY(), 25);
                    }
                    if (c.this.P == null || c.this.P.size() <= 0 || poi == null) {
                        c.this.c((c) motionEvent);
                        return;
                    }
                    obtain.what = 20;
                    obtain.obj = poi;
                    c.this.j.sendMessage(obtain);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public void b(final int i2) {
        queueEvent(new Runnable() {
            /* class com.amap.api.mapcore.util.c.AnonymousClass13 */

            public void run() {
                GLMapEngine gLMapEngine;
                if (c.this.bc && (gLMapEngine = c.this.g) != null) {
                    gLMapEngine.setHighlightSubwayEnable(i2, false);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Poi b(int i2, int i3, int i4) {
        if (!this.bc) {
            return null;
        }
        try {
            ArrayList<MapLabelItem> a2 = a(1, i2, i3, i4);
            MapLabelItem mapLabelItem = (a2 == null || a2.size() <= 0) ? null : a2.get(0);
            if (mapLabelItem != null) {
                DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong((long) mapLabelItem.pixel20X, (long) mapLabelItem.pixel20Y, 20);
                Poi poi = new Poi(mapLabelItem.name, new LatLng(pixelsToLatLong.y, pixelsToLatLong.x, false), mapLabelItem.poiid);
                pixelsToLatLong.recycle();
                return poi;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private void a(MotionEvent motionEvent) throws RemoteException {
        if (this.as && this.at != null && this.au != null) {
            int x2 = (int) motionEvent.getX();
            int y2 = (int) (motionEvent.getY() - 60.0f);
            LatLng realPosition = this.au.getRealPosition();
            if (realPosition != null) {
                LatLng position = this.au.getPosition();
                DPoint obtain = DPoint.obtain();
                getPixel2LatLng(x2, y2, obtain);
                LatLng latLng = new LatLng((position.latitude + obtain.y) - realPosition.latitude, (position.longitude + obtain.x) - realPosition.longitude);
                obtain.recycle();
                this.at.setPosition(latLng);
                try {
                    List<AMap.OnMarkerDragListener> list = this.K;
                    if (list != null && list.size() > 0) {
                        for (int i2 = 0; i2 < this.K.size(); i2++) {
                            this.K.get(i2).onMarkerDrag(this.at);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public void b() {
        GLMapRender gLMapRender = this.aS;
        if (gLMapRender != null) {
            gLMapRender.resetTickCount(2);
        }
    }

    /* access modifiers changed from: protected */
    public void e(int i2) {
        fd fdVar = this.ae;
        if (fdVar == null) {
            return;
        }
        if (i2 == 0) {
            if (fdVar.b()) {
                this.ae.g(Boolean.FALSE);
                this.ae.c();
            }
        } else if (!fdVar.b()) {
            this.ae.g(Boolean.TRUE);
            this.ae.c();
        }
    }

    public synchronized void b(int i2, int i3, int i4, int i5) {
        a(i2, i3, i4, i5, false, false, (StyleItem[]) null);
    }

    public void b(final int i2, final boolean z2) {
        if (!this.bc || !this.bd) {
            a aVar = this.by;
            aVar.c = z2;
            aVar.b = true;
            aVar.g = i2;
            return;
        }
        resetRenderTime();
        queueEvent(new Runnable() {
            /* class com.amap.api.mapcore.util.c.AnonymousClass17 */

            public void run() {
                GLMapEngine gLMapEngine = c.this.g;
                if (gLMapEngine != null) {
                    if (z2) {
                        gLMapEngine.setAllContentEnable(i2, true);
                    } else {
                        gLMapEngine.setAllContentEnable(i2, false);
                    }
                    c.this.g.setSimple3DEnable(i2, false);
                }
            }
        });
    }

    public void b(AMapWidgetListener aMapWidgetListener) throws RemoteException {
        b(this.am, aMapWidgetListener);
    }

    private <T> void b(List<T> list, T t2) {
        if (list != null && t2 != null) {
            try {
                if (list.contains(t2)) {
                    list.remove(t2);
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void createSurface(GL10 gl10, EGLConfig eGLConfig) {
        try {
            createSurface(1, gl10, eGLConfig);
        } catch (Throwable th) {
            th.printStackTrace();
            eq.a(th);
        }
    }

    /* access modifiers changed from: protected */
    public void a(GLMapState gLMapState, int i2, int i3, DPoint dPoint) {
        if (this.bc && this.g != null) {
            Point point = new Point();
            gLMapState.screenToP20Point(i2, i3, point);
            DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong((long) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), (long) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point), 20);
            dPoint.x = pixelsToLatLong.x;
            dPoint.y = pixelsToLatLong.y;
            pixelsToLatLong.recycle();
        }
    }

    public void a(int i2, int i3, FPoint fPoint) {
        GLMapEngine gLMapEngine;
        GLMapState mapState;
        if (this.bc && (gLMapEngine = this.g) != null && (mapState = gLMapEngine.getMapState(1)) != null) {
            mapState.p20ToScreenPoint(i2, i3, fPoint);
        }
    }

    private void a(int i2, GL10 gl10) {
        int i3 = this.aN;
        if (i3 != -1) {
            this.aS.setRenderFps((float) i3);
            resetRenderTime();
        } else if (this.g.isInMapAction(i2) || this.aZ) {
            this.aS.setRenderFps(40.0f);
        } else if (this.g.isInMapAnimation(i2)) {
            this.aS.setRenderFps(30.0f);
            this.aS.resetTickCount(15);
        } else {
            this.aS.setRenderFps(15.0f);
        }
        if (this.c.isWorldMapEnable() != MapsInitializer.isLoadWorldGridMap()) {
            a(true);
            this.c.setWorldMapEnable(MapsInitializer.isLoadWorldGridMap());
        }
    }

    private void a(GL10 gl10) {
        if (this.az) {
            boolean canStopMapRender = this.g.canStopMapRender(1);
            Message obtainMessage = this.j.obtainMessage(15, eq.a(0, 0, getMapWidth(), getMapHeight()));
            obtainMessage.arg1 = canStopMapRender ? 1 : 0;
            obtainMessage.sendToTarget();
            this.az = false;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void changeSurface(GL10 gl10, int i2, int i3) {
        try {
            changeSurface(1, gl10, i2, i3);
        } catch (Throwable th) {
            th.printStackTrace();
            eq.a(th);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0138 A[Catch:{ all -> 0x016e }, LOOP:1: B:40:0x0130->B:42:0x0138, LOOP_END] */
    public void a() {
        List<AMapWidgetListener> list;
        List<AMapWidgetListener> list2;
        int i2;
        List<AMapWidgetListener> list3;
        if (this.c.getMapRect() == null || this.aI) {
            h();
            this.aI = false;
        }
        boolean z2 = true;
        this.g.getCurTileIDs(1, this.c.getCurTileIds());
        GLMapState mapState = this.g.getMapState(1);
        if (mapState != null) {
            mapState.getViewMatrix(this.c.getViewMatrix());
            mapState.getProjectionMatrix(this.c.getProjectionMatrix());
            this.c.updateFinalMatrix();
            DPoint mapGeoCenter = mapState.getMapGeoCenter();
            this.c.setSX(mapGeoCenter.x);
            this.c.setSY(mapGeoCenter.y);
            this.c.setSZ(mapState.getMapZoomer());
            this.c.setSC(mapState.getCameraDegree());
            this.c.setSR(mapState.getMapAngle());
            if (this.c.isMapStateChange()) {
                this.c.setSkyHeight(mapState.getSkyHeight());
                DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(mapGeoCenter.x, mapGeoCenter.y, 20);
                CameraPosition cameraPosition = new CameraPosition(new LatLng(pixelsToLatLong.y, pixelsToLatLong.x, false), this.c.getSZ(), this.c.getSC(), this.c.getSR());
                pixelsToLatLong.recycle();
                Message obtainMessage = this.j.obtainMessage();
                obtainMessage.what = 10;
                obtainMessage.obj = cameraPosition;
                this.j.sendMessage(obtainMessage);
                this.ba = true;
                redrawInfoWindow();
                h();
                try {
                    if (this.ab.isZoomControlsEnabled() && this.c.isNeedUpdateZoomControllerState() && (list3 = this.am) != null && list3.size() > 0) {
                        for (int i3 = 0; i3 < this.am.size(); i3++) {
                            this.am.get(i3).invalidateZoomController(this.c.getSZ());
                        }
                    }
                    if (this.c.getChangeGridRatio() != 1.0d) {
                        a(true);
                    }
                    if (this.ab.isCompassEnabled()) {
                        if (!this.c.isTiltChanged()) {
                            if (this.c.isBearingChanged()) {
                            }
                        }
                        if (z2 && (list2 = this.am) != null && list2.size() > 0) {
                            for (i2 = 0; i2 < this.am.size(); i2++) {
                                this.am.get(i2).invalidateCompassView();
                            }
                        }
                        if (this.ab.isScaleControlsEnabled() && (list = this.am) != null && list.size() > 0) {
                            for (int i4 = 0; i4 < this.am.size(); i4++) {
                                this.am.get(i4).invalidateScaleView();
                            }
                            return;
                        }
                        return;
                    }
                    z2 = false;
                    while (i2 < this.am.size()) {
                    }
                    if (this.ab.isScaleControlsEnabled()) {
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } else if (!this.aZ && this.g.getAnimateionsCount() == 0 && this.g.getStateMessageCount() == 0) {
                onChangeFinish();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z2) {
        this.j.obtainMessage(17, z2 ? 1 : 0, 0).sendToTarget();
    }

    public ArrayList<MapLabelItem> a(int i2, int i3, int i4, int i5) {
        if (!this.bc) {
            return null;
        }
        ArrayList<MapLabelItem> arrayList = new ArrayList<>();
        byte[] labelBuffer = this.g.getLabelBuffer(i2, i3, i4, i5);
        if (labelBuffer == null) {
            return null;
        }
        int i6 = GLConvertUtil.getInt(labelBuffer, 0) >= 1 ? 1 : 0;
        int i7 = 0;
        int i8 = 4;
        while (i7 < i6) {
            MapLabelItem mapLabelItem = new MapLabelItem();
            int i9 = GLConvertUtil.getInt(labelBuffer, i8);
            int i10 = i8 + 4;
            int i11 = GLConvertUtil.getInt(labelBuffer, i10);
            int i12 = i10 + 4;
            mapLabelItem.x = i9;
            mapLabelItem.y = this.ad.getHeight() - i11;
            mapLabelItem.pixel20X = GLConvertUtil.getInt(labelBuffer, i12);
            int i13 = i12 + 4;
            mapLabelItem.pixel20Y = GLConvertUtil.getInt(labelBuffer, i13);
            int i14 = i13 + 4;
            mapLabelItem.pixel20Z = GLConvertUtil.getInt(labelBuffer, i14);
            int i15 = i14 + 4;
            mapLabelItem.type = GLConvertUtil.getInt(labelBuffer, i15);
            int i16 = i15 + 4;
            mapLabelItem.mSublayerId = GLConvertUtil.getInt(labelBuffer, i16);
            int i17 = i16 + 4;
            mapLabelItem.timeStamp = GLConvertUtil.getInt(labelBuffer, i17);
            int i18 = i17 + 4;
            mapLabelItem.mIsFouces = labelBuffer[i18] != 0;
            int i19 = i18 + 1;
            if (labelBuffer[i19] == 0) {
                mapLabelItem.poiid = null;
            } else {
                String str = "";
                for (int i20 = 0; i20 < 20; i20++) {
                    int i21 = i20 + i19;
                    if (labelBuffer[i21] == 0) {
                        break;
                    }
                    str = str + ((char) labelBuffer[i21]);
                }
                mapLabelItem.poiid = str;
            }
            int i22 = i19 + 20;
            int i23 = i22 + 1;
            byte b2 = labelBuffer[i22];
            StringBuffer stringBuffer = new StringBuffer();
            for (int i24 = 0; i24 < b2; i24++) {
                stringBuffer.append((char) GLConvertUtil.getShort(labelBuffer, i23));
                i23 += 2;
            }
            mapLabelItem.name = stringBuffer.toString();
            arrayList.add(mapLabelItem);
            i7++;
            i8 = i23;
        }
        return arrayList;
    }

    public synchronized void a(final int i2, final int i3, final int i4, final int i5, final boolean z2, final boolean z3, final StyleItem[] styleItemArr) {
        if (!this.bd || !this.bc || !this.a) {
            a aVar = this.bs;
            aVar.g = i2;
            aVar.d = i3;
            aVar.e = i4;
            aVar.f = i5;
            aVar.b = true;
        } else {
            e(i4);
            queueEvent(new Runnable() {
                /* class com.amap.api.mapcore.util.c.AnonymousClass14 */

                public void run() {
                    try {
                        c.this.g.setMapModeAndStyle(i2, i3, i4, i5, z2, z3, styleItemArr);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    public void a(final int i2, final boolean z2) {
        if (!this.bc || !this.bd) {
            a aVar = this.bu;
            aVar.c = z2;
            aVar.b = true;
            aVar.g = i2;
            return;
        }
        resetRenderTime();
        queueEvent(new Runnable() {
            /* class com.amap.api.mapcore.util.c.AnonymousClass16 */

            public void run() {
                try {
                    c.this.g.setBuildingEnable(i2, z2);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public int a(int i2, Rect rect, int i3, int i4) {
        GLMapEngine gLMapEngine = this.g;
        if (gLMapEngine == null || i2 < 0 || rect == null) {
            return 0;
        }
        int engineIDWithType = gLMapEngine.getEngineIDWithType(i2);
        if (!this.g.isEngineCreated(engineIDWithType)) {
            int i5 = this.f.getResources().getDisplayMetrics().densityDpi;
            float f2 = this.f.getResources().getDisplayMetrics().density;
            this.aW = GLMapState.calMapZoomScalefactor(i3, i4, i5);
            GLMapEngine.MapViewInitParam mapViewInitParam = new GLMapEngine.MapViewInitParam();
            mapViewInitParam.engineId = engineIDWithType;
            mapViewInitParam.x = rect.left;
            mapViewInitParam.y = rect.top;
            mapViewInitParam.width = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect);
            mapViewInitParam.height = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect);
            mapViewInitParam.screenWidth = i3;
            mapViewInitParam.screenHeight = i4;
            mapViewInitParam.screenScale = f2;
            mapViewInitParam.textScale = this.aX * f2;
            mapViewInitParam.mapZoomScale = this.aW;
            this.g.createAMapEngineWithFrame(mapViewInitParam);
            GLMapState mapState = this.g.getMapState(engineIDWithType);
            mapState.setMapZoomer(this.c.getSZ());
            mapState.setCameraDegree(this.c.getSC());
            mapState.setMapAngle(this.c.getSR());
            mapState.setMapGeoCenter(this.c.getSX(), this.c.getSY());
            this.g.setMapState(engineIDWithType, mapState);
            this.g.setOvelayBundle(engineIDWithType, new GLOverlayBundle<>(engineIDWithType, this));
            return engineIDWithType;
        }
        a(engineIDWithType, rect.left, rect.top, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect), i3, i4);
        return engineIDWithType;
    }

    public void a(int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        GLMapEngine gLMapEngine = this.g;
        if (gLMapEngine != null) {
            gLMapEngine.setServiceViewRect(i2, i3, i4, i5, i6, i7, i8);
        }
    }

    private boolean a(int i2, int i3) {
        GLMapEngine gLMapEngine = this.g;
        if (gLMapEngine != null) {
            return gLMapEngine.getSrvViewStateBoolValue(i2, i3);
        }
        return false;
    }

    private void a(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
        boolean z2 = this.ao;
        abstractCameraUpdateMessage.isUseAnchor = z2;
        if (z2) {
            abstractCameraUpdateMessage.anchorX = this.c.getAnchorX();
            abstractCameraUpdateMessage.anchorY = this.c.getAnchorY();
        }
        if (abstractCameraUpdateMessage.width == 0) {
            abstractCameraUpdateMessage.width = getMapWidth();
        }
        if (abstractCameraUpdateMessage.height == 0) {
            abstractCameraUpdateMessage.height = getMapHeight();
        }
        abstractCameraUpdateMessage.mapConfig = this.c;
    }

    private boolean a(LatLngBounds latLngBounds) {
        return (latLngBounds == null || latLngBounds.northeast == null || latLngBounds.southwest == null) ? false : true;
    }

    /* access modifiers changed from: protected */
    public void a(boolean z2, CameraPosition cameraPosition) {
        MapConfig mapConfig = this.c;
        if (mapConfig != null && mapConfig.getChangedCounter() != 0) {
            try {
                if (!this.aZ && this.g.getAnimateionsCount() == 0 && this.g.getStateMessageCount() == 0) {
                    AMapGestureListener aMapGestureListener = this.W;
                    if (aMapGestureListener != null) {
                        aMapGestureListener.onMapStable();
                    }
                    List<AMap.OnCameraChangeListener> list = this.M;
                    if (list == null) {
                        return;
                    }
                    if (list.size() != 0) {
                        if (this.ad.isEnabled()) {
                            if (cameraPosition == null) {
                                try {
                                    cameraPosition = getCameraPosition();
                                } catch (Throwable th) {
                                    hd.c(th, "AMapDelegateImp", "cameraChangeFinish");
                                    th.printStackTrace();
                                }
                            }
                            try {
                                for (AMap.OnCameraChangeListener onCameraChangeListener : this.M) {
                                    onCameraChangeListener.onCameraChangeFinish(cameraPosition);
                                }
                            } catch (Throwable unused) {
                            }
                            this.c.resetChangedCounter();
                        }
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
                eq.a(th2);
            }
        }
    }

    @Override // com.amap.api.mapcore.util.b.a
    public void a(byte[] bArr) {
        jp jpVar = this.bD;
        if (jpVar != null) {
            jpVar.a("onAbroadStyleComplete", bArr);
        }
    }

    public void a(boolean z2, byte[] bArr, boolean z3) {
        Cdo doVar;
        try {
            this.c.setCustomStyleEnable(z2);
            boolean z4 = false;
            if (this.c.isHideLogoEnable()) {
                this.ab.setLogoEnable(!z2);
            }
            if (z2) {
                c(1, true);
                dn dnVar = new dn(this.f);
                MyTrafficStyle myTrafficStyle = this.aD;
                if (!(myTrafficStyle == null || myTrafficStyle.getTrafficRoadBackgroundColor() == -1)) {
                    dnVar.a(this.aD.getTrafficRoadBackgroundColor());
                }
                if (this.c.isProFunctionAuthEnable() && !TextUtils.isEmpty(this.c.getCustomTextureResourcePath())) {
                    z4 = true;
                }
                StyleItem[] styleItemArr = null;
                if (bArr != null) {
                    doVar = dnVar.a(bArr, z4);
                    if (!(doVar == null || (styleItemArr = doVar.c()) == null)) {
                        this.c.setUseProFunction(true);
                    }
                } else {
                    doVar = null;
                }
                if (styleItemArr == null && (doVar = dnVar.a(this.c.getCustomStylePath(), z4)) != null) {
                    styleItemArr = doVar.c();
                }
                if (dnVar.a() != 0) {
                    this.c.setCustomBackgroundColor(dnVar.a());
                }
                if (doVar == null || doVar.d() == null) {
                    a(styleItemArr, z3);
                } else if (this.aQ != null) {
                    this.aQ.a((String) doVar.d());
                    this.aQ.a(doVar);
                    this.aQ.b();
                }
            } else {
                c(1, false);
                a(1, this.c.getMapStyleMode(), this.c.getMapStyleTime(), this.c.getMapStyleState(), true, false, (StyleItem[]) null);
            }
        } catch (Throwable th) {
            eq.a(th);
        }
    }

    @Override // com.amap.api.mapcore.util.di.a
    public void a(String str, Cdo doVar) {
        setCustomTextureResourcePath(str);
        if (this.c.isCustomStyleEnable() && doVar != null) {
            a(doVar.c(), false);
        }
    }

    /* access modifiers changed from: protected */
    public void a(StyleItem[] styleItemArr, boolean z2) {
        if (z2 || (styleItemArr != null && styleItemArr.length > 0)) {
            a(1, 0, 0, 0, true, true, styleItemArr);
            eo.a(this.f, true);
            return;
        }
        eo.a(this.f, false);
    }

    public void a(AMapWidgetListener aMapWidgetListener) throws RemoteException {
        a(this.am, aMapWidgetListener);
    }

    private <T> void a(List<T> list, T t2) {
        if (list != null && t2 != null) {
            try {
                if (!list.contains(t2)) {
                    list.add(t2);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private <T> void a(List<T> list) {
        if (list != null) {
            try {
                list.clear();
            } catch (Throwable unused) {
            }
        }
    }
}
