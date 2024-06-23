package com.amap.api.mapcore.util;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.os.RemoteException;
import android.view.animation.AnimationUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point;
import com.amap.api.mapcore.util.de;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.GL3DModelOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.animation.GLAnimation;
import com.autonavi.amap.mapcore.animation.GLAnimationSet;
import com.autonavi.amap.mapcore.animation.GLTransformation;
import com.autonavi.amap.mapcore.animation.GLTranslateAnimation;
import com.autonavi.amap.mapcore.interfaces.IglModel;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.FPoint;
import com.youku.alixplayer.MsgID;
import java.util.List;

/* compiled from: Taobao */
public class cr extends BaseOverlayImp implements IglModel {
    private boolean A = false;
    private boolean B = false;
    private FPoint C = FPoint.obtain();
    private int D = 0;
    private int E = 0;
    private float F = 0.5f;
    private float G = 0.5f;
    private String H;
    private String I;
    private float J = -1.0f;
    float[] a = new float[16];
    float[] b = new float[16];
    Rect c = new Rect(0, 0, 0, 0);
    float d = 1.0f;
    private boolean e = true;
    private String f;
    private float[] g = new float[16];
    private q h;
    private BitmapDescriptor i;
    private IAMapDelegate j;
    private int k;
    private int l;
    private LatLng m;
    private GLAnimation n;
    private boolean o = true;
    private boolean p = true;
    private Bitmap q;
    private de.b r;
    private float s;
    private Object t;
    private float u = 18.0f;
    private float v = -1.0f;
    private float w = 0.0f;
    private boolean x = false;
    private o y;
    private int z;

    public cr(o oVar, GL3DModelOptions gL3DModelOptions, IAMapDelegate iAMapDelegate) {
        boolean z2 = true;
        if (gL3DModelOptions != null && iAMapDelegate != null) {
            this.y = oVar;
            this.j = iAMapDelegate;
            this.i = gL3DModelOptions.getBitmapDescriptor();
            List<Float> textrue = gL3DModelOptions.getTextrue();
            List<Float> vertext = gL3DModelOptions.getVertext();
            this.m = gL3DModelOptions.getLatLng();
            this.s = gL3DModelOptions.getAngle();
            setModelFixedLength(gL3DModelOptions.getModelFixedLength());
            if (this.m != null) {
                IPoint obtain = IPoint.obtain();
                LatLng latLng = this.m;
                GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, obtain);
                this.k = Point.getx(obtain);
                this.l = Point.gety(obtain);
            }
            if (!(textrue == null || textrue.size() <= 0 || vertext == null)) {
                if ((vertext.size() > 0) && (this.i == null ? false : z2)) {
                    q qVar = new q(vertext, textrue);
                    this.h = qVar;
                    qVar.a(this.s);
                }
            }
            this.a = new float[16];
            this.b = new float[4];
        }
    }

    private float b() {
        float mapPerPixelUnitLength = this.j.getMapConfig().getMapPerPixelUnitLength();
        if (this.j.getMapConfig().getSZ() < this.u) {
            return mapPerPixelUnitLength / this.v;
        }
        this.J = mapPerPixelUnitLength;
        return mapPerPixelUnitLength / mapPerPixelUnitLength;
    }

    private float c() {
        return (this.j.getMapConfig().getMapPerPixelUnitLength() * this.w) / this.h.a();
    }

    private void d() {
        GLAnimation gLAnimation;
        if (this.o || (gLAnimation = this.n) == null || gLAnimation.hasEnded()) {
            this.o = true;
            return;
        }
        e();
        GLTransformation gLTransformation = new GLTransformation();
        this.n.getTransformation(AnimationUtils.currentAnimationTimeMillis(), gLTransformation);
        if (!Double.isNaN(gLTransformation.x) && !Double.isNaN(gLTransformation.y)) {
            double d2 = gLTransformation.x;
            double d3 = gLTransformation.y;
            this.k = (int) d2;
            this.l = (int) d3;
        }
    }

    private void e() {
        IAMapDelegate iAMapDelegate = this.j;
        if (iAMapDelegate != null) {
            iAMapDelegate.setRunLowFrame(false);
        }
    }

    public void a() {
        try {
            if (this.h != null) {
                if (this.r == null) {
                    this.r = (de.b) this.j.getGLShader(5);
                }
                if (this.v == -1.0f) {
                    this.v = this.j.getUnitLengthByZoom((int) this.u);
                }
                if (this.e) {
                    int a2 = a(this.i.getBitmap());
                    this.z = a2;
                    this.h.a(a2);
                    this.e = false;
                }
                d();
                float sx = (float) (this.k - ((int) this.j.getMapConfig().getSX()));
                ((PointF) this.C).x = sx;
                float sy = (float) (this.l - ((int) this.j.getMapConfig().getSY()));
                ((PointF) this.C).y = sy;
                Matrix.setIdentityM(this.g, 0);
                Matrix.multiplyMM(this.g, 0, this.j.getProjectionMatrix(), 0, this.j.getViewMatrix(), 0);
                Matrix.translateM(this.g, 0, sx, sy, 0.0f);
                if (this.x) {
                    this.d = c();
                } else {
                    this.d = b();
                }
                float[] fArr = this.g;
                float f2 = this.d;
                Matrix.scaleM(fArr, 0, f2, f2, f2);
                this.h.a(this.r, this.g);
                if (this.B) {
                    this.j.redrawInfoWindow();
                    this.B = false;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate
    public boolean checkInBounds() {
        return this.j.getMapConfig().getGeoRectangle().contains(this.k, this.l);
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IglModel
    public void destroy() {
        Bitmap bitmap = this.q;
        if (bitmap != null) {
            eq.b(bitmap);
        }
        o oVar = this.y;
        if (oVar != null) {
            oVar.a(this.z);
        }
        q qVar = this.h;
        if (qVar != null) {
            qVar.c();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate
    public IPoint getAnchor() {
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate
    public BitmapDescriptor getBitmapDescriptor() {
        return this.i;
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate
    public FPoint getGeoPosition() {
        return FPoint.obtain((float) this.k, (float) this.l);
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate
    public int getHeight() {
        return (int) ((this.h.a() * this.d) / this.j.getMapConfig().getMapPerPixelUnitLength());
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IglModel
    public String getId() {
        return this.f;
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate
    public int getInfoWindowOffsetX() {
        return 0;
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate
    public int getInfoWindowOffsetY() {
        return 0;
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IglModel
    public Object getObject() {
        return this.t;
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IglModel
    public LatLng getPosition() {
        return this.m;
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate
    public int getRealInfoWindowOffsetX() {
        return this.D;
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate
    public int getRealInfoWindowOffsetY() {
        return this.E;
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate
    public LatLng getRealPosition() {
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate
    public Rect getRect() {
        try {
            GLMapState mapProjection = this.j.getMapProjection();
            int width = getWidth();
            int height = getHeight();
            FPoint obtain = FPoint.obtain();
            mapProjection.p20ToScreenPoint(this.k, this.l, obtain);
            Matrix.setIdentityM(this.a, 0);
            Matrix.rotateM(this.a, 0, -this.s, 0.0f, 0.0f, 1.0f);
            Matrix.rotateM(this.a, 0, this.j.getMapConfig().getSC(), 1.0f, 0.0f, 0.0f);
            Matrix.rotateM(this.a, 0, this.j.getMapConfig().getSR(), 0.0f, 0.0f, 1.0f);
            float[] fArr = new float[4];
            float[] fArr2 = this.b;
            float f2 = (float) (-width);
            fArr2[0] = this.F * f2;
            float f3 = (float) height;
            fArr2[1] = this.G * f3;
            fArr2[2] = 0.0f;
            fArr2[3] = 1.0f;
            Matrix.multiplyMV(fArr, 0, this.a, 0, fArr2, 0);
            Rect rect = this.c;
            float f4 = ((PointF) obtain).x;
            float f5 = ((PointF) obtain).y;
            rect.set((int) (fArr[0] + f4), (int) (f5 - fArr[1]), (int) (f4 + fArr[0]), (int) (f5 - fArr[1]));
            float[] fArr3 = this.b;
            float f6 = (float) width;
            fArr3[0] = (1.0f - this.F) * f6;
            fArr3[1] = f3 * this.G;
            fArr3[2] = 0.0f;
            fArr3[3] = 1.0f;
            Matrix.multiplyMV(fArr, 0, this.a, 0, fArr3, 0);
            this.c.union((int) (((PointF) obtain).x + fArr[0]), (int) (((PointF) obtain).y - fArr[1]));
            float[] fArr4 = this.b;
            fArr4[0] = f6 * (1.0f - this.F);
            float f7 = (float) (-height);
            fArr4[1] = (1.0f - this.G) * f7;
            fArr4[2] = 0.0f;
            fArr4[3] = 1.0f;
            Matrix.multiplyMV(fArr, 0, this.a, 0, fArr4, 0);
            this.c.union((int) (((PointF) obtain).x + fArr[0]), (int) (((PointF) obtain).y - fArr[1]));
            float[] fArr5 = this.b;
            fArr5[0] = f2 * this.F;
            fArr5[1] = f7 * (1.0f - this.G);
            fArr5[2] = 0.0f;
            fArr5[3] = 1.0f;
            Matrix.multiplyMV(fArr, 0, this.a, 0, fArr5, 0);
            this.c.union((int) (((PointF) obtain).x + fArr[0]), (int) (((PointF) obtain).y - fArr[1]));
            this.D = this.c.centerX() - ((int) ((PointF) obtain).x);
            this.E = this.c.top - ((int) ((PointF) obtain).y);
            obtain.recycle();
            return this.c;
        } catch (Throwable th) {
            hd.c(th, "MarkerDelegateImp", "getRect");
            th.printStackTrace();
            return new Rect(0, 0, 0, 0);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IglModel
    public float getRotateAngle() {
        return 0.0f;
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IglModel
    public String getSnippet() {
        return this.H;
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IglModel
    public String getTitle() {
        return this.I;
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate
    public int getWidth() {
        return (int) ((this.h.b() * this.d) / this.j.getMapConfig().getMapPerPixelUnitLength());
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate
    public boolean isContains() {
        return this.y.a(this);
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate
    public boolean isDestory() {
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate
    public boolean isInfoWindowEnable() {
        return true;
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate
    public boolean isViewMode() {
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IglModel
    public boolean isVisible() {
        return this.p;
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IglModel
    public boolean remove() {
        IAMapDelegate iAMapDelegate = this.j;
        if (iAMapDelegate == null) {
            return true;
        }
        iAMapDelegate.removeGLModel(this.f);
        return true;
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IglModel
    public void setAnimation(Animation animation) {
        if (animation != null) {
            this.n = animation.glAnimation;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IglModel
    public void setGeoPoint(IPoint iPoint) {
        if (iPoint != null) {
            this.k = Point.getx(iPoint);
            this.l = Point.gety(iPoint);
            DPoint obtain = DPoint.obtain();
            GLMapState.geo2LonLat(this.k, this.l, obtain);
            this.m = new LatLng(obtain.y, obtain.x, false);
            obtain.recycle();
        }
        this.j.setRunLowFrame(false);
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate
    public void setInfoWindowOffset(int i2, int i3) throws RemoteException {
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate
    public void setInfoWindowShown(boolean z2) {
        this.A = z2;
        this.B = true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IglModel
    public void setModelFixedLength(int i2) {
        if (i2 > 0) {
            this.w = (float) i2;
            this.x = true;
            return;
        }
        this.w = 0.0f;
        this.x = false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IglModel
    public void setObject(Object obj) {
        this.t = obj;
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IglModel
    public void setPosition(LatLng latLng) {
        if (latLng != null) {
            this.m = latLng;
            IPoint obtain = IPoint.obtain();
            GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, obtain);
            this.k = Point.getx(obtain);
            this.l = Point.gety(obtain);
            obtain.recycle();
        }
        this.B = true;
        this.j.setRunLowFrame(false);
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IglModel
    public void setRotateAngle(float f2) {
        this.s = f2;
        if (this.h != null) {
            this.h.a(this.s - this.j.getMapConfig().getSR());
        }
        this.B = true;
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IglModel
    public void setSnippet(String str) {
        this.H = str;
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IglModel
    public void setTitle(String str) {
        this.I = str;
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IglModel
    public void setVisible(boolean z2) {
        this.p = z2;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IglModel
    public void setZoomLimit(float f2) {
        this.u = f2;
        this.v = this.j.getUnitLengthByZoom((int) f2);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IglModel
    public void showInfoWindow() {
        try {
            this.j.showInfoWindow(this);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IglModel
    public boolean startAnimation() {
        GLAnimation gLAnimation = this.n;
        if (gLAnimation != null) {
            if (gLAnimation instanceof GLAnimationSet) {
                GLAnimationSet gLAnimationSet = (GLAnimationSet) gLAnimation;
                for (GLAnimation gLAnimation2 : gLAnimationSet.getAnimations()) {
                    a(gLAnimation2);
                    gLAnimation2.setDuration(gLAnimationSet.getDuration());
                }
            } else {
                a(gLAnimation);
            }
            this.o = false;
            this.n.start();
        }
        return false;
    }

    private int a(Bitmap bitmap) {
        if (bitmap != null) {
            this.q = bitmap;
        }
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexParameterf(3553, 10241, 9728.0f);
        GLES20.glTexParameterf(3553, MsgID.MEDIA_INFO_VIDEO_START_RECOVER, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLUtils.texImage2D(3553, 0, this.q, 0);
        return iArr[0];
    }

    private void a(GLAnimation gLAnimation) {
        if (gLAnimation instanceof GLTranslateAnimation) {
            GLTranslateAnimation gLTranslateAnimation = (GLTranslateAnimation) gLAnimation;
            gLTranslateAnimation.mFromXDelta = (double) this.k;
            gLTranslateAnimation.mFromYDelta = (double) this.l;
            IPoint obtain = IPoint.obtain();
            GLMapState.lonlat2Geo(gLTranslateAnimation.mToXDelta, gLTranslateAnimation.mToYDelta, obtain);
            gLTranslateAnimation.mToXDelta = (double) Point.getx(obtain);
            gLTranslateAnimation.mToYDelta = (double) Point.gety(obtain);
            obtain.recycle();
        }
    }

    public void a(String str) {
        this.f = str;
    }
}
