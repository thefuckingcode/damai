package tb;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class w12 {
    private static transient /* synthetic */ IpChange $ipChange;
    private Bitmap a;
    private int b;

    public w12(Bitmap bitmap, int i) {
        this.a = bitmap;
        this.b = i % 360;
    }

    public Bitmap a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2017474246")) {
            return this.a;
        }
        return (Bitmap) ipChange.ipc$dispatch("2017474246", new Object[]{this});
    }

    public int b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2006179043")) {
            return ((Integer) ipChange.ipc$dispatch("2006179043", new Object[]{this})).intValue();
        } else if (this.a == null) {
            return 0;
        } else {
            if (f()) {
                return this.a.getWidth();
            }
            return this.a.getHeight();
        }
    }

    public Matrix c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1954095367")) {
            return (Matrix) ipChange.ipc$dispatch("1954095367", new Object[]{this});
        }
        Matrix matrix = new Matrix();
        Bitmap bitmap = this.a;
        if (!(bitmap == null || this.b == 0)) {
            matrix.preTranslate((float) (-(bitmap.getWidth() / 2)), (float) (-(this.a.getHeight() / 2)));
            matrix.postRotate((float) this.b);
            matrix.postTranslate((float) (e() / 2), (float) (b() / 2));
        }
        return matrix;
    }

    public int d() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1718340948")) {
            return this.b;
        }
        return ((Integer) ipChange.ipc$dispatch("-1718340948", new Object[]{this})).intValue();
    }

    public int e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1131835488")) {
            return ((Integer) ipChange.ipc$dispatch("-1131835488", new Object[]{this})).intValue();
        } else if (this.a == null) {
            return 0;
        } else {
            if (f()) {
                return this.a.getHeight();
            }
            return this.a.getWidth();
        }
    }

    public boolean f() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1091800717")) {
            return (this.b / 90) % 2 != 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1091800717", new Object[]{this})).booleanValue();
    }

    public void g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-153136966")) {
            ipChange.ipc$dispatch("-153136966", new Object[]{this});
            return;
        }
        Bitmap bitmap = this.a;
        if (bitmap != null) {
            bitmap.recycle();
            this.a = null;
        }
    }

    public void h(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1448679762")) {
            ipChange.ipc$dispatch("1448679762", new Object[]{this, bitmap});
            return;
        }
        this.a = bitmap;
    }

    public void i(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-818179466")) {
            ipChange.ipc$dispatch("-818179466", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.b = i;
    }
}
