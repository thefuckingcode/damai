package tb;

import com.taobao.weex.common.Constants;

/* compiled from: Taobao */
public class a42 {
    private float a;
    private float b;

    public a42(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    public boolean a(float f, float f2) {
        return this.a == f && this.b == f2;
    }

    public float b() {
        return this.a;
    }

    public float c() {
        return this.b;
    }

    public void d(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    public String toString() {
        return b() + Constants.Name.X + c();
    }

    public a42() {
        this(1.0f, 1.0f);
    }
}
