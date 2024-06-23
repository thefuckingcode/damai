package com.amap.api.mapcore.util;

import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: Taobao */
public abstract class cn {
    private IAMapDelegate map;

    public void destroy() {
    }

    public abstract int getZIndex();

    public abstract void onDrawFrame(GL10 gl10);
}
