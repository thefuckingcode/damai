package com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class RotateBitmap {
    private static transient /* synthetic */ IpChange $ipChange;
    private Bitmap bitmap;
    private int rotation;

    public RotateBitmap(Bitmap bitmap2, int i) {
        this.bitmap = bitmap2;
        this.rotation = i % 360;
    }

    public Bitmap getBitmap() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-228589524")) {
            return this.bitmap;
        }
        return (Bitmap) ipChange.ipc$dispatch("-228589524", new Object[]{this});
    }

    public int getHeight() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-732563383")) {
            return ((Integer) ipChange.ipc$dispatch("-732563383", new Object[]{this})).intValue();
        } else if (this.bitmap == null) {
            return 0;
        } else {
            if (isOrientationChanged()) {
                return this.bitmap.getWidth();
            }
            return this.bitmap.getHeight();
        }
    }

    public Matrix getRotateMatrix() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1939457517")) {
            return (Matrix) ipChange.ipc$dispatch("1939457517", new Object[]{this});
        }
        Matrix matrix = new Matrix();
        Bitmap bitmap2 = this.bitmap;
        if (!(bitmap2 == null || this.rotation == 0)) {
            matrix.preTranslate((float) (-(bitmap2.getWidth() / 2)), (float) (-(this.bitmap.getHeight() / 2)));
            matrix.postRotate((float) this.rotation);
            matrix.postTranslate((float) (getWidth() / 2), (float) (getHeight() / 2));
        }
        return matrix;
    }

    public int getRotation() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-834859886")) {
            return this.rotation;
        }
        return ((Integer) ipChange.ipc$dispatch("-834859886", new Object[]{this})).intValue();
    }

    public int getWidth() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1358729350")) {
            return ((Integer) ipChange.ipc$dispatch("-1358729350", new Object[]{this})).intValue();
        } else if (this.bitmap == null) {
            return 0;
        } else {
            if (isOrientationChanged()) {
                return this.bitmap.getHeight();
            }
            return this.bitmap.getWidth();
        }
    }

    public boolean isOrientationChanged() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "35871309")) {
            return (this.rotation / 90) % 2 != 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("35871309", new Object[]{this})).booleanValue();
    }

    public void recycle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1407382112")) {
            ipChange.ipc$dispatch("-1407382112", new Object[]{this});
            return;
        }
        Bitmap bitmap2 = this.bitmap;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.bitmap = null;
        }
    }

    public void setBitmap(Bitmap bitmap2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "540179628")) {
            ipChange.ipc$dispatch("540179628", new Object[]{this, bitmap2});
            return;
        }
        this.bitmap = bitmap2;
    }

    public void setRotation(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "799929680")) {
            ipChange.ipc$dispatch("799929680", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.rotation = i;
    }
}
