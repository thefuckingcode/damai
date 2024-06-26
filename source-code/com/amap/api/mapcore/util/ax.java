package com.amap.api.mapcore.util;

import android.os.RemoteException;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.MultiPointItem;
import com.amap.api.maps.model.MultiPointOverlayOptions;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IMultiPointOverlay;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class ax {
    de a;
    private List<av> b = new ArrayList();
    private AMap.OnMultiPointClickListener c;
    private IAMapDelegate d;

    public ax(IAMapDelegate iAMapDelegate) {
        this.d = iAMapDelegate;
    }

    public de a() {
        de gLShaderManager = this.d.getGLShaderManager();
        this.a = gLShaderManager;
        return gLShaderManager;
    }

    public synchronized void b() {
        this.c = null;
        try {
            synchronized (this.b) {
                for (av avVar : this.b) {
                    avVar.destroy(false);
                }
                this.b.clear();
            }
        } catch (Throwable th) {
            hd.c(th, "MultiPointOverlayManagerLayer", "destory");
            th.printStackTrace();
        }
    }

    public synchronized void c() {
        try {
            synchronized (this.b) {
                this.b.clear();
            }
        } catch (Throwable th) {
            hd.c(th, "MultiPointOverlayManagerLayer", Constants.TAG_CLEAR_STRING);
            th.printStackTrace();
        }
        return;
    }

    public void d() {
        IAMapDelegate iAMapDelegate = this.d;
        if (iAMapDelegate != null) {
            iAMapDelegate.setRunLowFrame(false);
        }
    }

    public synchronized IMultiPointOverlay a(MultiPointOverlayOptions multiPointOverlayOptions) throws RemoteException {
        if (multiPointOverlayOptions == null) {
            return null;
        }
        aw awVar = new aw(multiPointOverlayOptions, this);
        a((av) awVar);
        return awVar;
    }

    private void a(av avVar) throws RemoteException {
        synchronized (this.b) {
            this.b.add(avVar);
        }
    }

    public void a(MapConfig mapConfig, float[] fArr, float[] fArr2) {
        try {
            synchronized (this.b) {
                for (av avVar : this.b) {
                    avVar.a(mapConfig, fArr, fArr2);
                }
            }
        } catch (Throwable th) {
            hd.c(th, "MultiPointOverlayManagerLayer", "draw");
            th.printStackTrace();
        }
    }

    public boolean a(IPoint iPoint) {
        MultiPointItem onClick;
        boolean z = false;
        if (this.c == null) {
            return false;
        }
        synchronized (this.b) {
            for (av avVar : this.b) {
                if (!(avVar == null || (onClick = avVar.onClick(iPoint)) == null)) {
                    AMap.OnMultiPointClickListener onMultiPointClickListener = this.c;
                    if (onMultiPointClickListener != null) {
                        z = onMultiPointClickListener.onPointClick(onClick);
                    }
                    return z;
                }
            }
            return false;
        }
    }

    public void a(AMap.OnMultiPointClickListener onMultiPointClickListener) {
        this.c = onMultiPointClickListener;
    }

    public void a(aw awVar) {
        this.b.remove(awVar);
    }
}
