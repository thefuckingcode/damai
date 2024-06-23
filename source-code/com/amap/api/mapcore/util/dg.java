package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.mapcore.util.df;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* compiled from: Taobao */
public class dg implements Runnable {
    private Context a;
    private IAMapDelegate b;
    private df c;
    private a d;
    private int e = 0;

    /* compiled from: Taobao */
    public interface a {
        void a(byte[] bArr, int i);
    }

    public dg(Context context, a aVar, int i, String str) {
        boolean z = false;
        this.a = context;
        this.d = aVar;
        this.e = i;
        if (this.c == null) {
            this.c = new df(context, "", i != 0 ? true : z);
        }
        this.c.a(str);
    }

    public void a(String str) {
        df dfVar = this.c;
        if (dfVar != null) {
            dfVar.d(str);
        }
    }

    public void b() {
        ep.a().a(this);
    }

    public void run() {
        df.a aVar;
        byte[] bArr;
        try {
            if (MapsInitializer.getNetWorkEnable()) {
                df dfVar = this.c;
                if (!(dfVar == null || (aVar = (df.a) dfVar.e()) == null || (bArr = aVar.a) == null)) {
                    a aVar2 = this.d;
                    if (aVar2 != null) {
                        aVar2.a(bArr, this.e);
                    } else {
                        IAMapDelegate iAMapDelegate = this.b;
                        if (iAMapDelegate != null) {
                            iAMapDelegate.setCustomMapStyle(iAMapDelegate.getMapConfig().isCustomStyleEnable(), aVar.a);
                        }
                    }
                }
                hd.a(this.a, eq.e());
                IAMapDelegate iAMapDelegate2 = this.b;
                if (iAMapDelegate2 != null) {
                    iAMapDelegate2.setRunLowFrame(false);
                }
            }
        } catch (Throwable th) {
            hd.c(th, "CustomStyleTask", "download customStyle");
            th.printStackTrace();
        }
    }

    public void a() {
        this.a = null;
        if (this.c != null) {
            this.c = null;
        }
    }

    public dg(Context context, IAMapDelegate iAMapDelegate) {
        this.a = context;
        this.b = iAMapDelegate;
        if (this.c == null) {
            this.c = new df(context, "");
        }
    }
}
