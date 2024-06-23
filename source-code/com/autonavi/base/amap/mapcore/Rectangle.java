package com.autonavi.base.amap.mapcore;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import com.autonavi.amap.mapcore.IPoint;

/* compiled from: Taobao */
public class Rectangle {
    private int beyond180Mode = 0;
    public float bottom;
    public FPoint[] clipMapRect = null;
    public IPoint[] clipRect = null;
    public float left;
    public Rect rect = new Rect();
    public float right;
    public float top;

    public Rectangle() {
    }

    private void updateClipMapRect(int i, int i2) {
        if (this.clipMapRect == null) {
            FPoint[] fPointArr = new FPoint[4];
            this.clipMapRect = fPointArr;
            fPointArr[0] = FPoint.obtain(0.0f, 0.0f);
            this.clipMapRect[1] = FPoint.obtain(0.0f, 0.0f);
            this.clipMapRect[2] = FPoint.obtain(0.0f, 0.0f);
            this.clipMapRect[3] = FPoint.obtain(0.0f, 0.0f);
        }
        Rect rect2 = this.rect;
        if (rect2 != null) {
            FPoint[] fPointArr2 = this.clipMapRect;
            FPoint fPoint = fPointArr2[0];
            int i3 = rect2.left;
            ((PointF) fPoint).x = (float) (i3 - i);
            FPoint fPoint2 = fPointArr2[0];
            int i4 = rect2.top;
            ((PointF) fPoint2).y = (float) (i4 - i2);
            FPoint fPoint3 = fPointArr2[1];
            int i5 = rect2.right;
            ((PointF) fPoint3).x = (float) (i5 - i);
            ((PointF) fPointArr2[1]).y = (float) (i4 - i2);
            ((PointF) fPointArr2[2]).x = (float) (i5 - i);
            FPoint fPoint4 = fPointArr2[2];
            int i6 = rect2.bottom;
            ((PointF) fPoint4).y = (float) (i6 - i2);
            ((PointF) fPointArr2[3]).x = (float) (i3 - i);
            ((PointF) fPointArr2[3]).y = (float) (i6 - i2);
        }
    }

    private void updateClipRect() {
        if (this.clipRect == null) {
            IPoint[] iPointArr = new IPoint[4];
            this.clipRect = iPointArr;
            iPointArr[0] = IPoint.obtain(0, 0);
            this.clipRect[1] = IPoint.obtain(0, 0);
            this.clipRect[2] = IPoint.obtain(0, 0);
            this.clipRect[3] = IPoint.obtain(0, 0);
        }
        Rect rect2 = this.rect;
        if (rect2 != null) {
            IPoint[] iPointArr2 = this.clipRect;
            IPoint iPoint = iPointArr2[0];
            int i = rect2.left;
            ((Point) iPoint).x = i;
            IPoint iPoint2 = iPointArr2[0];
            int i2 = rect2.top;
            ((Point) iPoint2).y = i2;
            IPoint iPoint3 = iPointArr2[1];
            int i3 = rect2.right;
            ((Point) iPoint3).x = i3;
            ((Point) iPointArr2[1]).y = i2;
            ((Point) iPointArr2[2]).x = i3;
            IPoint iPoint4 = iPointArr2[2];
            int i4 = rect2.bottom;
            ((Point) iPoint4).y = i4;
            ((Point) iPointArr2[3]).x = i;
            ((Point) iPointArr2[3]).y = i4;
        }
    }

    public boolean contains(int i, int i2) {
        Rect rect2 = this.rect;
        if (rect2 == null) {
            return false;
        }
        if (rect2.contains(i, i2)) {
            return true;
        }
        if (this.beyond180Mode == 0) {
            return false;
        }
        if (!this.rect.contains(i - 268435456, i2) && !this.rect.contains(i + 268435456, i2)) {
            return false;
        }
        return true;
    }

    public int getBeyond180Mode() {
        return this.beyond180Mode;
    }

    public FPoint[] getClipMapRect() {
        return this.clipMapRect;
    }

    public IPoint[] getClipRect() {
        return this.clipRect;
    }

    public Rect getRect() {
        return this.rect;
    }

    public boolean isOverlap(Rect rect2) {
        int i;
        int i2;
        Rect rect3 = this.rect;
        if (!(rect3 == null || rect2 == null || rect3.left + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect3) <= (i = rect2.left))) {
            int width = i + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect2);
            Rect rect4 = this.rect;
            if (width <= rect4.left || rect4.top + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect4) <= (i2 = rect2.top) || i2 + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect2) <= this.rect.top) {
                return false;
            }
            return true;
        }
        return false;
    }

    public void updateRect(Rect rect2, int i, int i2) {
        if (rect2 != null) {
            this.rect = rect2;
            rect2.inset((-com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect2)) / 8, (-com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect2)) / 8);
            Rect rect3 = this.rect;
            int i3 = rect3.right;
            if ((((float) rect3.left) / 100000.0f) * (((float) i3) / 100000.0f) < 0.0f) {
                this.beyond180Mode = -1;
            } else if (i3 > 268435456) {
                this.beyond180Mode = 1;
            } else {
                this.beyond180Mode = 0;
            }
            updateClipRect();
            updateClipMapRect(i, i2);
        }
    }

    public Rectangle(Rect rect2, int i, int i2) {
        this.rect = rect2;
        if (rect2 != null) {
            updateRect(rect2, i, i2);
            updateClipRect();
            updateClipMapRect(rect2.centerX(), rect2.centerY());
        }
    }

    public boolean contains(IPoint iPoint) {
        if (iPoint == null) {
            return false;
        }
        return contains(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(iPoint), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(iPoint));
    }

    public boolean isOverlap(int i, int i2, int i3, int i4) {
        Rect rect2 = this.rect;
        if (rect2 != null && rect2.left + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect2) > i) {
            int i5 = i + i3;
            Rect rect3 = this.rect;
            if (i5 <= rect3.left || rect3.top + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect3) <= i2 || i2 + i4 <= this.rect.top) {
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean contains(Rect rect2) {
        if (rect2 == null) {
            return false;
        }
        return this.rect.contains(rect2);
    }

    public Rectangle(float f, float f2, float f3, float f4) {
        if (f < f2 && f4 > f3) {
            this.left = f;
            this.right = f2;
            this.top = f4;
            this.bottom = f3;
        }
    }
}
