package com.amap.api.mapcore.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IUiSettingsDelegate;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class ac implements IUiSettingsDelegate {
    final Handler a = new Handler(Looper.getMainLooper()) {
        /* class com.amap.api.mapcore.util.ac.AnonymousClass1 */

        public void handleMessage(Message message) {
            if (message != null && ac.this.b != null) {
                try {
                    switch (message.what) {
                        case 0:
                            ac.this.b.showZoomControlsEnabled(ac.this.h);
                            return;
                        case 1:
                            ac.this.b.showScaleEnabled(ac.this.j);
                            return;
                        case 2:
                            ac.this.b.showCompassEnabled(ac.this.i);
                            return;
                        case 3:
                            ac.this.b.showMyLocationButtonEnabled(ac.this.f);
                            return;
                        case 4:
                            ac.this.b.showIndoorSwitchControlsEnabled(ac.this.n);
                            return;
                        case 5:
                            ac.this.b.showLogoEnabled(ac.this.k);
                            return;
                        case 6:
                            ac.this.b.refreshLogo();
                            return;
                        default:
                            return;
                    }
                } catch (Throwable th) {
                    hd.c(th, "UiSettingsDelegateImp", "handleMessage");
                }
            }
        }
    };
    private IAMapDelegate b;
    private boolean c = true;
    private boolean d = true;
    private boolean e = true;
    private boolean f = false;
    private boolean g = true;
    private boolean h = true;
    private boolean i = true;
    private boolean j = false;
    private boolean k = true;
    private int l = 0;
    private int m = 1;
    private boolean n = true;
    private boolean o = false;
    private boolean p = false;

    ac(IAMapDelegate iAMapDelegate) {
        this.b = iAMapDelegate;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public float getLogoMarginRate(int i2) {
        return this.b.getLogoMarginRate(i2);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public int getLogoPosition() throws RemoteException {
        return this.l;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public int getZoomPosition() throws RemoteException {
        return this.m;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public boolean isCompassEnabled() throws RemoteException {
        return this.i;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public boolean isGestureScaleByMapCenter() throws RemoteException {
        return this.p;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public boolean isIndoorSwitchEnabled() throws RemoteException {
        return this.n;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public boolean isLogoEnable() {
        return this.k;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public boolean isMyLocationButtonEnabled() throws RemoteException {
        return this.f;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public boolean isRotateGesturesEnabled() throws RemoteException {
        return this.c;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public boolean isScaleControlsEnabled() throws RemoteException {
        return this.j;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public boolean isScrollGesturesEnabled() throws RemoteException {
        return this.d;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public boolean isTiltGesturesEnabled() throws RemoteException {
        return this.e;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public boolean isZoomControlsEnabled() throws RemoteException {
        return this.h;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public boolean isZoomGesturesEnabled() throws RemoteException {
        return this.g;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public boolean isZoomInByScreenCenter() {
        return this.o;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void requestRefreshLogo() {
        this.a.obtainMessage(6).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setAllGesturesEnabled(boolean z) throws RemoteException {
        setRotateGesturesEnabled(z);
        setTiltGesturesEnabled(z);
        setZoomGesturesEnabled(z);
        setScrollGesturesEnabled(z);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setCompassEnabled(boolean z) throws RemoteException {
        this.i = z;
        this.a.obtainMessage(2).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setGestureScaleByMapCenter(boolean z) throws RemoteException {
        this.p = z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setIndoorSwitchEnabled(boolean z) throws RemoteException {
        this.n = z;
        this.a.obtainMessage(4).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setLogoBottomMargin(int i2) {
        this.b.setLogoBottomMargin(i2);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setLogoEnable(boolean z) {
        this.k = z;
        this.a.obtainMessage(5).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setLogoLeftMargin(int i2) {
        this.b.setLogoLeftMargin(i2);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setLogoMarginRate(int i2, float f2) {
        this.b.setLogoMarginRate(i2, f2);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setLogoPosition(int i2) throws RemoteException {
        this.l = i2;
        this.b.setLogoPosition(i2);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setMyLocationButtonEnabled(boolean z) throws RemoteException {
        this.f = z;
        this.a.obtainMessage(3).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setRotateGesturesEnabled(boolean z) throws RemoteException {
        this.c = z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setScaleControlsEnabled(boolean z) throws RemoteException {
        this.j = z;
        this.a.obtainMessage(1).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setScrollGesturesEnabled(boolean z) throws RemoteException {
        this.d = z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setTiltGesturesEnabled(boolean z) throws RemoteException {
        this.e = z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setZoomControlsEnabled(boolean z) throws RemoteException {
        this.h = z;
        this.a.obtainMessage(0).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setZoomGesturesEnabled(boolean z) throws RemoteException {
        this.g = z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setZoomInByScreenCenter(boolean z) {
        this.o = z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setZoomPosition(int i2) throws RemoteException {
        this.m = i2;
        this.b.setZoomPosition(i2);
    }
}
