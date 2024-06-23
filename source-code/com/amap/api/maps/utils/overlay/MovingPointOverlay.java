package com.amap.api.maps.utils.overlay;

import com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
public class MovingPointOverlay {
    private a STATUS = a.ACTION_UNKNOWN;
    private BasePointOverlay baseOverlay = null;
    private long duration = 10000;
    private LinkedList<Double> eachDistance = new LinkedList<>();
    AtomicBoolean exitFlag = new AtomicBoolean(false);
    private int index = 0;
    private AMap mAMap;
    private long mAnimationBeginTime = System.currentTimeMillis();
    private Object mLock = new Object();
    private long mStepDuration = 20;
    private ExecutorService mThreadPools;
    private MoveListener moveListener;
    private long pauseMillis;
    private LinkedList<LatLng> points = new LinkedList<>();
    private double remainDistance = 0.0d;
    private double totalDistance = 0.0d;
    private boolean useDefaultDescriptor = false;

    /* compiled from: Taobao */
    public interface MoveListener {
        void move(double d);
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public enum a {
        ACTION_UNKNOWN,
        ACTION_START,
        ACTION_RUNNING,
        ACTION_PAUSE,
        ACTION_STOP
    }

    /* compiled from: Taobao */
    private class b implements ThreadFactory {
        private b() {
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "MoveSmoothThread");
        }
    }

    /* compiled from: Taobao */
    private class c implements Runnable {
        private c() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0075, code lost:
            java.lang.Thread.sleep(r5.a.mStepDuration);
         */
        public void run() {
            try {
                MovingPointOverlay.this.mAnimationBeginTime = System.currentTimeMillis();
                MovingPointOverlay.this.STATUS = a.ACTION_START;
                MovingPointOverlay.this.exitFlag.set(false);
                while (!MovingPointOverlay.this.exitFlag.get() && MovingPointOverlay.this.index <= MovingPointOverlay.this.points.size() - 1) {
                    synchronized (MovingPointOverlay.this.mLock) {
                        if (!MovingPointOverlay.this.exitFlag.get()) {
                            if (MovingPointOverlay.this.STATUS != a.ACTION_PAUSE) {
                                MovingPointOverlay.this.baseOverlay.setGeoPoint(MovingPointOverlay.this.getCurPosition(System.currentTimeMillis() - MovingPointOverlay.this.mAnimationBeginTime));
                                MovingPointOverlay.this.STATUS = a.ACTION_RUNNING;
                            }
                        } else {
                            return;
                        }
                    }
                }
                MovingPointOverlay.this.STATUS = a.ACTION_STOP;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public MovingPointOverlay(AMap aMap, BasePointOverlay basePointOverlay) {
        if (aMap != null && basePointOverlay != null) {
            this.mAMap = aMap;
            this.mThreadPools = new ThreadPoolExecutor(1, 2, 5, TimeUnit.SECONDS, new SynchronousQueue(), new b());
            this.baseOverlay = basePointOverlay;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private IPoint getCurPosition(long j) {
        CameraPosition cameraPosition;
        MoveListener moveListener2;
        long j2 = this.duration;
        int i = 0;
        if (j > j2) {
            this.exitFlag.set(true);
            IPoint iPoint = new IPoint();
            int size = this.points.size() - 1;
            this.index = size;
            LatLng latLng = this.points.get(size);
            int i2 = this.index - 1;
            this.index = i2;
            this.index = Math.max(i2, 0);
            this.remainDistance = 0.0d;
            MapProjection.lonlat2Geo(latLng.longitude, latLng.latitude, iPoint);
            MoveListener moveListener3 = this.moveListener;
            if (moveListener3 != null) {
                moveListener3.move(this.remainDistance);
            }
            return iPoint;
        }
        double d = this.totalDistance;
        double d2 = (((double) j) * d) / ((double) j2);
        this.remainDistance = d - d2;
        double d3 = 1.0d;
        int i3 = 0;
        while (true) {
            if (i3 >= this.eachDistance.size()) {
                break;
            }
            double doubleValue = this.eachDistance.get(i3).doubleValue();
            if (d2 > doubleValue) {
                d2 -= doubleValue;
                i3++;
            } else {
                if (doubleValue > 0.0d) {
                    d3 = d2 / doubleValue;
                }
                i = i3;
            }
        }
        if (!(i == this.index || (moveListener2 = this.moveListener) == null)) {
            moveListener2.move(this.remainDistance);
        }
        this.index = i;
        LatLng latLng2 = this.points.get(i);
        LatLng latLng3 = this.points.get(i + 1);
        IPoint iPoint2 = new IPoint();
        MapProjection.lonlat2Geo(latLng2.longitude, latLng2.latitude, iPoint2);
        IPoint iPoint3 = new IPoint();
        MapProjection.lonlat2Geo(latLng3.longitude, latLng3.latitude, iPoint3);
        int xVar = Point.getx(iPoint3) - Point.getx(iPoint2);
        int yVar = Point.gety(iPoint3) - Point.gety(iPoint2);
        if (AMapUtils.calculateLineDistance(latLng2, latLng3) > 1.0f) {
            float rotate = getRotate(iPoint2, iPoint3);
            AMap aMap = this.mAMap;
            if (!(aMap == null || (cameraPosition = aMap.getCameraPosition()) == null)) {
                this.baseOverlay.setRotateAngle((360.0f - rotate) + cameraPosition.bearing);
            }
        }
        return new IPoint((int) (((double) Point.getx(iPoint2)) + (((double) xVar) * d3)), (int) (((double) Point.gety(iPoint2)) + (((double) yVar) * d3)));
    }

    private float getRotate(IPoint iPoint, IPoint iPoint2) {
        if (iPoint == null || iPoint2 == null) {
            return 0.0f;
        }
        double yVar = (double) Point.gety(iPoint);
        return (float) ((Math.atan2(((double) Point.getx(iPoint2)) - ((double) Point.getx(iPoint)), yVar - ((double) Point.gety(iPoint2))) / 3.141592653589793d) * 180.0d);
    }

    private void reset() {
        try {
            a aVar = this.STATUS;
            if (aVar == a.ACTION_RUNNING || aVar == a.ACTION_PAUSE) {
                this.exitFlag.set(true);
                this.mThreadPools.awaitTermination(this.mStepDuration + 20, TimeUnit.MILLISECONDS);
                this.baseOverlay.setAnimation(null);
                this.STATUS = a.ACTION_UNKNOWN;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
        try {
            removeMarker();
            this.mThreadPools.shutdownNow();
            synchronized (this.mLock) {
                this.points.clear();
                this.eachDistance.clear();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int getIndex() {
        return this.index;
    }

    public BasePointOverlay getObject() {
        return this.baseOverlay;
    }

    public LatLng getPosition() {
        BasePointOverlay basePointOverlay = this.baseOverlay;
        if (basePointOverlay != null) {
            return basePointOverlay.getPosition();
        }
        return null;
    }

    public void removeMarker() {
        try {
            reset();
            BasePointOverlay basePointOverlay = this.baseOverlay;
            if (basePointOverlay != null) {
                basePointOverlay.remove();
                this.baseOverlay = null;
            }
            this.points.clear();
            this.eachDistance.clear();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void resetIndex() {
        this.index = 0;
    }

    public void setMoveListener(MoveListener moveListener2) {
        this.moveListener = moveListener2;
    }

    public void setPoints(List<LatLng> list) {
        synchronized (this.mLock) {
            if (list != null) {
                try {
                    if (list.size() >= 2) {
                        stopMove();
                        this.points.clear();
                        for (LatLng latLng : list) {
                            if (latLng != null) {
                                this.points.add(latLng);
                            }
                        }
                        this.eachDistance.clear();
                        this.totalDistance = 0.0d;
                        int i = 0;
                        while (i < this.points.size() - 1) {
                            i++;
                            double calculateLineDistance = (double) AMapUtils.calculateLineDistance(this.points.get(i), this.points.get(i));
                            this.eachDistance.add(Double.valueOf(calculateLineDistance));
                            this.totalDistance += calculateLineDistance;
                        }
                        this.remainDistance = this.totalDistance;
                        this.baseOverlay.setPosition(this.points.get(0));
                        reset();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public void setPosition(LatLng latLng) {
        try {
            BasePointOverlay basePointOverlay = this.baseOverlay;
            if (basePointOverlay != null) {
                basePointOverlay.setPosition(latLng);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setRotate(float f) {
        AMap aMap;
        CameraPosition cameraPosition;
        try {
            if (this.baseOverlay != null && (aMap = this.mAMap) != null && (cameraPosition = aMap.getCameraPosition()) != null) {
                this.baseOverlay.setRotateAngle((360.0f - f) + cameraPosition.bearing);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTotalDuration(int i) {
        this.duration = (long) (i * 1000);
    }

    public void setVisible(boolean z) {
        try {
            BasePointOverlay basePointOverlay = this.baseOverlay;
            if (basePointOverlay != null) {
                basePointOverlay.setVisible(z);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startSmoothMove() {
        a aVar = this.STATUS;
        if (aVar == a.ACTION_PAUSE) {
            this.STATUS = a.ACTION_RUNNING;
            this.mAnimationBeginTime += System.currentTimeMillis() - this.pauseMillis;
        } else if ((aVar == a.ACTION_UNKNOWN || aVar == a.ACTION_STOP) && this.points.size() >= 1) {
            this.index = 0;
            try {
                this.mThreadPools.execute(new c());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void stopMove() {
        if (this.STATUS == a.ACTION_RUNNING) {
            this.STATUS = a.ACTION_PAUSE;
            this.pauseMillis = System.currentTimeMillis();
        }
    }
}
