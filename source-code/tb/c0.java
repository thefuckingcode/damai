package tb;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.Method;

/* compiled from: Taobao */
public class c0 extends SurfaceTexture {
    private static transient /* synthetic */ IpChange $ipChange;
    public SurfaceTexture a = null;

    public c0() {
        super(0);
    }

    @TargetApi(16)
    public void attachToGLContext(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1139966728")) {
            ipChange.ipc$dispatch("1139966728", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.a.attachToGLContext(i);
    }

    @TargetApi(16)
    public void detachFromGLContext() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1713760792")) {
            ipChange.ipc$dispatch("1713760792", new Object[]{this});
            return;
        }
        try {
            this.a.detachFromGLContext();
        } catch (Exception e) {
            try {
                Method declaredMethod = SurfaceTexture.class.getDeclaredMethod("nativeDetachFromGLContext", new Class[0]);
                declaredMethod.setAccessible(true);
                int intValue = ((Integer) declaredMethod.invoke(this.a, new Object[0])).intValue();
                Log.d("APSurfaceTexture", "nativeDetachFromGLContext invoke retCode:" + intValue);
            } catch (Exception e2) {
                Log.e("APSurfaceTexture", "nativeDetachFromGLContext invoke exception:" + e2.getMessage());
            }
            Log.e("APSurfaceTexture", "mSurface.detachFromGLContext() exception:" + e.getMessage());
        }
    }

    public boolean equals(Object obj) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1001848282")) {
            return this.a.equals(obj);
        }
        return ((Boolean) ipChange.ipc$dispatch("-1001848282", new Object[]{this, obj})).booleanValue();
    }

    public long getTimestamp() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2096760455")) {
            return this.a.getTimestamp();
        }
        return ((Long) ipChange.ipc$dispatch("-2096760455", new Object[]{this})).longValue();
    }

    public void getTransformMatrix(float[] fArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "977350841")) {
            ipChange.ipc$dispatch("977350841", new Object[]{this, fArr});
            return;
        }
        this.a.getTransformMatrix(fArr);
    }

    public int hashCode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1451621923")) {
            return this.a.hashCode();
        }
        return ((Integer) ipChange.ipc$dispatch("-1451621923", new Object[]{this})).intValue();
    }

    public void release() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1766586466")) {
            ipChange.ipc$dispatch("-1766586466", new Object[]{this});
            return;
        }
        super.release();
        this.a.release();
    }

    @TargetApi(19)
    public void releaseTexImage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1580374154")) {
            ipChange.ipc$dispatch("1580374154", new Object[]{this});
            return;
        }
        this.a.releaseTexImage();
    }

    @TargetApi(15)
    public void setDefaultBufferSize(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-652111419")) {
            ipChange.ipc$dispatch("-652111419", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.a.setDefaultBufferSize(i, i2);
    }

    public void setOnFrameAvailableListener(SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "373204226")) {
            ipChange.ipc$dispatch("373204226", new Object[]{this, onFrameAvailableListener});
            return;
        }
        this.a.setOnFrameAvailableListener(onFrameAvailableListener);
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "119150535")) {
            return this.a.toString();
        }
        return (String) ipChange.ipc$dispatch("119150535", new Object[]{this});
    }

    public void updateTexImage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "257441128")) {
            ipChange.ipc$dispatch("257441128", new Object[]{this});
            return;
        }
        this.a.updateTexImage();
    }
}
