package com.autonavi.base.ae.gmap.glanimation;

import com.amap.api.maps.AMap;
import com.autonavi.base.ae.gmap.GLMapState;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: Taobao */
public class AdglMapAnimationMgr {
    private List<AbstractAdglAnimation> list = Collections.synchronizedList(new ArrayList());
    private AMap.CancelableCallback mCancelCallback;
    private MapAnimationListener mMapAnimationListener;

    /* compiled from: Taobao */
    public interface MapAnimationListener {
        void onMapAnimationFinish(AMap.CancelableCallback cancelableCallback);
    }

    public void addAnimation(AbstractAdglAnimation abstractAdglAnimation, AMap.CancelableCallback cancelableCallback) {
        if (abstractAdglAnimation != null) {
            synchronized (this.list) {
                if (!abstractAdglAnimation.isOver() && this.list.size() > 0) {
                    List<AbstractAdglAnimation> list2 = this.list;
                    AbstractAdglAnimation abstractAdglAnimation2 = list2.get(list2.size() - 1);
                    if (abstractAdglAnimation2 != null && (abstractAdglAnimation instanceof AdglMapAnimGroup) && (abstractAdglAnimation2 instanceof AdglMapAnimGroup) && ((AdglMapAnimGroup) abstractAdglAnimation).typeEqueal((AdglMapAnimGroup) abstractAdglAnimation2) && !((AdglMapAnimGroup) abstractAdglAnimation).needMove) {
                        this.list.remove(abstractAdglAnimation2);
                    }
                }
                this.list.add(abstractAdglAnimation);
                this.mCancelCallback = cancelableCallback;
            }
        }
    }

    public synchronized void clearAnimations() {
        this.list.clear();
    }

    public synchronized void doAnimations(GLMapState gLMapState) {
        if (gLMapState != null) {
            if (this.list.size() > 0) {
                AbstractAdglAnimation abstractAdglAnimation = this.list.get(0);
                if (abstractAdglAnimation != null) {
                    if (abstractAdglAnimation.isOver()) {
                        MapAnimationListener mapAnimationListener = this.mMapAnimationListener;
                        if (mapAnimationListener != null) {
                            mapAnimationListener.onMapAnimationFinish(this.mCancelCallback);
                        }
                        this.list.remove(abstractAdglAnimation);
                    } else {
                        abstractAdglAnimation.doAnimation(gLMapState);
                    }
                }
            }
        }
    }

    public synchronized int getAnimationsCount() {
        return this.list.size();
    }

    public AMap.CancelableCallback getCancelCallback() {
        return this.mCancelCallback;
    }

    public void setMapAnimationListener(MapAnimationListener mapAnimationListener) {
        synchronized (this) {
            this.mMapAnimationListener = mapAnimationListener;
        }
    }

    public void setMapCoreListener() {
    }
}
