package com.amap.api.mapcore.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.opengl.GLES20;
import android.os.Build;
import android.os.RemoteException;
import android.util.Log;
import com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.TextOptions;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IMarkerAction;
import com.autonavi.amap.mapcore.interfaces.IOverlayImage;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.ITextDelegate;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.Rectangle;
import com.autonavi.base.amap.mapcore.interfaces.IAnimation;
import com.taobao.weex.common.Constants;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class db implements ITextDelegate {
    private static int a;
    private int A;
    private boolean B = false;
    private List<x> C = new ArrayList();
    private boolean D = false;
    private boolean E = false;
    private float[] F = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private float b = 0.0f;
    private float c = 0.0f;
    private int d = 4;
    private int e = 32;
    private FPoint f = FPoint.obtain();
    private int g;
    private BitmapDescriptor h;
    private int i;
    private int j;
    private String k;
    private LatLng l;
    private float m = 0.5f;
    private float n = 1.0f;
    private boolean o = true;
    private u p;
    private Object q;
    private String r;
    private int s;
    private int t;
    private int u;
    private Typeface v;
    private float w;
    private Rect x = new Rect();
    private Paint y = new Paint();
    private int z;

    public db(TextOptions textOptions, u uVar) throws RemoteException {
        this.p = uVar;
        if (textOptions.getPosition() != null) {
            this.l = textOptions.getPosition();
        }
        setAlign(textOptions.getAlignX(), textOptions.getAlignY());
        this.o = textOptions.isVisible();
        this.r = textOptions.getText();
        this.s = textOptions.getBackgroundColor();
        this.t = textOptions.getFontColor();
        this.u = textOptions.getFontSize();
        this.q = textOptions.getObject();
        this.w = textOptions.getZIndex();
        this.v = textOptions.getTypeface();
        this.k = getId();
        setRotateAngle(textOptions.getRotate());
        a();
        calFPoint();
    }

    private static String a(String str) {
        a++;
        return str + a;
    }

    private void b() {
        if (this.p.c() != null) {
            this.p.c().setRunLowFrame(false);
        }
    }

    private void c() {
        u uVar;
        List<x> list = this.C;
        if (list != null) {
            for (x xVar : list) {
                if (!(xVar == null || (uVar = this.p) == null)) {
                    uVar.a(xVar);
                }
            }
            this.C.clear();
        }
    }

    private int d() {
        int[] iArr = {0};
        GLES20.glGenTextures(1, iArr, 0);
        return iArr[0];
    }

    private synchronized void e() {
        a();
        this.E = false;
        b();
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate
    public boolean calFPoint() {
        if (this.l == null) {
            return false;
        }
        IPoint obtain = IPoint.obtain();
        LatLng latLng = this.l;
        GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, obtain);
        this.z = Point.getx(obtain);
        this.A = Point.gety(obtain);
        IAMapDelegate c2 = this.p.c();
        LatLng latLng2 = this.l;
        c2.getLatLng2Map(latLng2.latitude, latLng2.longitude, this.f);
        obtain.recycle();
        return true;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate
    public boolean checkInBounds() {
        Rectangle geoRectangle = this.p.c().getMapConfig().getGeoRectangle();
        return geoRectangle != null && geoRectangle.contains(this.z, this.A);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public void destroy(boolean z2) {
        u uVar;
        try {
            this.D = true;
            if (z2) {
                remove();
            }
            List<x> list = this.C;
            if (list != null && list.size() > 0) {
                for (int i2 = 0; i2 < this.C.size(); i2++) {
                    x xVar = this.C.get(i2);
                    if (!(xVar == null || (uVar = this.p) == null)) {
                        uVar.a(xVar);
                        if (this.p.c() != null) {
                            this.p.c().removeTextureItem(xVar.p());
                        }
                    }
                }
                this.C.clear();
            }
            BitmapDescriptor bitmapDescriptor = this.h;
            if (bitmapDescriptor != null) {
                bitmapDescriptor.recycle();
                this.h = null;
            }
            this.l = null;
            this.q = null;
        } catch (Throwable th) {
            hd.c(th, "TextDelegateImp", Constants.Event.SLOT_LIFECYCLE.DESTORY);
            th.printStackTrace();
            Log.d("destroy erro", "TextDelegateImp destroy");
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate
    public void drawMarker(IAMapDelegate iAMapDelegate) {
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate
    public void drawMarker(IAMapDelegate iAMapDelegate, float[] fArr, int i2, float f2) {
        if (this.o && !this.D && this.l != null && this.h != null) {
            ((PointF) this.f).x = (float) (this.z - ((int) iAMapDelegate.getMapConfig().getSX()));
            ((PointF) this.f).y = (float) (this.A - ((int) iAMapDelegate.getMapConfig().getSY()));
            try {
                a(iAMapDelegate, fArr, i2, f2);
            } catch (Throwable th) {
                hd.c(th, "TextDelegateImp", "drawMarker");
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public boolean equalsRemote(IOverlayImage iOverlayImage) throws RemoteException {
        return equals(iOverlayImage) || iOverlayImage.getId().equals(getId());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IText
    public int getAlignX() throws RemoteException {
        return this.d;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IText
    public int getAlignY() {
        return this.e;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public float getAnchorU() {
        return this.m;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public float getAnchorV() {
        return this.n;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IText
    public int getBackgroundColor() throws RemoteException {
        return this.s;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IText
    public int getFontColor() throws RemoteException {
        return this.t;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IText
    public int getFontSize() throws RemoteException {
        return this.u;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate
    public IAnimation getIAnimation() {
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate
    public IMarkerAction getIMarkerAction() {
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public String getId() {
        if (this.k == null) {
            this.k = a("Text");
        }
        return this.k;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public Object getObject() {
        return this.q;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public LatLng getPosition() {
        return this.l;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate
    public Rect getRect() {
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public float getRotateAngle() {
        return this.c;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IText
    public String getText() throws RemoteException {
        return this.r;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate
    public int getTextureId() {
        try {
            return this.g;
        } catch (Throwable unused) {
            return 0;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IText
    public Typeface getTypeface() throws RemoteException {
        return this.v;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public float getZIndex() {
        return this.w;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public int hashCodeRemote() {
        return super.hashCode();
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate
    public boolean isAllowLow() {
        return true;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate
    public boolean isBelowMaskLayer() {
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate
    public boolean isInfoWindowShown() {
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate
    public boolean isOnTap() {
        return this.B;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public boolean isVisible() {
        return this.o;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate
    public void loadTexture(IAMapDelegate iAMapDelegate) {
        if (!this.E) {
            try {
                this.g = a(Build.VERSION.SDK_INT >= 12, this.h);
                this.E = true;
            } catch (Throwable th) {
                hd.c(th, "TextDelegateImp", "loadtexture");
                th.printStackTrace();
            }
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate
    public void reLoadTexture() {
        this.E = false;
        this.g = 0;
        a();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public boolean remove() {
        b();
        this.o = false;
        return this.p.a(this);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IText
    public void setAlign(int i2, int i3) throws RemoteException {
        this.d = i2;
        if (i2 == 1) {
            this.m = 0.0f;
        } else if (i2 == 2) {
            this.m = 1.0f;
        } else if (i2 != 4) {
            this.m = 0.5f;
        } else {
            this.m = 0.5f;
        }
        this.e = i3;
        if (i3 == 8) {
            this.n = 0.0f;
        } else if (i3 == 16) {
            this.n = 1.0f;
        } else if (i3 != 32) {
            this.n = 0.5f;
        } else {
            this.n = 0.5f;
        }
        b();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public void setAnchor(float f2, float f3) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IText
    public void setBackgroundColor(int i2) throws RemoteException {
        this.s = i2;
        e();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IText
    public void setFontColor(int i2) throws RemoteException {
        this.t = i2;
        e();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IText
    public void setFontSize(int i2) throws RemoteException {
        this.u = i2;
        e();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public void setObject(Object obj) {
        this.q = obj;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate
    public void setOnTap(boolean z2) {
        this.B = z2;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public void setPosition(LatLng latLng) {
        this.l = latLng;
        calFPoint();
        b();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public void setRotateAngle(float f2) {
        this.c = f2;
        this.b = (((-f2) % 360.0f) + 360.0f) % 360.0f;
        b();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IText
    public void setText(String str) throws RemoteException {
        this.r = str;
        e();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IText
    public void setTypeface(Typeface typeface) throws RemoteException {
        this.v = typeface;
        e();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public void setVisible(boolean z2) {
        if (this.o != z2) {
            this.o = z2;
            b();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public void setZIndex(float f2) {
        this.w = f2;
        this.p.f();
    }

    private void a() {
        String str = this.r;
        if (str != null && str.trim().length() > 0) {
            try {
                this.y.setTypeface(this.v);
                this.y.setSubpixelText(true);
                this.y.setAntiAlias(true);
                this.y.setStrokeWidth(5.0f);
                this.y.setStrokeCap(Paint.Cap.ROUND);
                this.y.setTextSize((float) this.u);
                this.y.setTextAlign(Paint.Align.CENTER);
                this.y.setColor(this.t);
                Paint.FontMetrics fontMetrics = this.y.getFontMetrics();
                int i2 = (int) (fontMetrics.descent - fontMetrics.ascent);
                int i3 = (int) (((((float) i2) - fontMetrics.bottom) - fontMetrics.top) / 2.0f);
                Paint paint = this.y;
                String str2 = this.r;
                paint.getTextBounds(str2, 0, str2.length(), this.x);
                Bitmap createBitmap = Bitmap.createBitmap(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.x) + 6, i2, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                canvas.drawColor(this.s);
                canvas.drawText(this.r, (float) (this.x.centerX() + 3), (float) i3, this.y);
                BitmapDescriptor fromBitmap = BitmapDescriptorFactory.fromBitmap(createBitmap);
                this.h = fromBitmap;
                this.i = fromBitmap.getWidth();
                this.j = this.h.getHeight();
            } catch (Throwable th) {
                hd.c(th, "TextDelegateImp", "initBitmap");
            }
        }
    }

    private void a(IAMapDelegate iAMapDelegate, float[] fArr, int i2, float f2) throws RemoteException {
        float f3 = ((float) this.i) * f2;
        float f4 = f2 * ((float) this.j);
        FPoint fPoint = this.f;
        float f5 = ((PointF) fPoint).x;
        float f6 = ((PointF) fPoint).y;
        float sc = iAMapDelegate.getMapConfig().getSC();
        float[] fArr2 = this.F;
        float f7 = this.m;
        fArr2[0] = f5 - (f3 * f7);
        float f8 = this.n;
        fArr2[1] = ((1.0f - f8) * f4) + f6;
        fArr2[2] = f5;
        fArr2[3] = f6;
        float f9 = this.b;
        fArr2[6] = f9;
        fArr2[7] = sc;
        fArr2[9] = ((1.0f - f7) * f3) + f5;
        fArr2[10] = ((1.0f - f8) * f4) + f6;
        fArr2[11] = f5;
        fArr2[12] = f6;
        fArr2[15] = f9;
        fArr2[16] = sc;
        fArr2[18] = ((1.0f - f7) * f3) + f5;
        fArr2[19] = f6 - (f4 * f8);
        fArr2[20] = f5;
        fArr2[21] = f6;
        fArr2[24] = f9;
        fArr2[25] = sc;
        fArr2[27] = f5 - (f3 * f7);
        fArr2[28] = f6 - (f4 * f8);
        fArr2[29] = f5;
        fArr2[30] = f6;
        fArr2[33] = f9;
        fArr2[34] = sc;
        System.arraycopy(fArr2, 0, fArr, i2, fArr2.length);
    }

    private void a(x xVar) {
        if (xVar != null) {
            this.C.add(xVar);
            xVar.m();
        }
    }

    private int a(boolean z2, BitmapDescriptor bitmapDescriptor) {
        x xVar;
        Bitmap bitmap;
        c();
        if (z2) {
            xVar = this.p.c().getTextureItem(bitmapDescriptor);
            if (xVar != null) {
                int k2 = xVar.k();
                a(xVar);
                return k2;
            }
        } else {
            xVar = null;
        }
        int i2 = 0;
        if (xVar == null) {
            xVar = new x(bitmapDescriptor, 0);
        }
        if (!(bitmapDescriptor == null || (bitmap = bitmapDescriptor.getBitmap()) == null || bitmap.isRecycled())) {
            i2 = d();
            xVar.a(i2);
            if (z2) {
                this.p.c().addTextureItem(xVar);
            }
            a(xVar);
            eq.b(i2, bitmap, true);
        }
        return i2;
    }
}
