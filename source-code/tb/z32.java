package tb;

import android.widget.ImageView;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class z32 {
    private float a;
    private float b;
    private float c = 1.0f;
    private float d = 1.0f;
    private float e = 1.0f;
    private boolean f;

    private final void h() {
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = 1.0f;
        this.d = 1.0f;
        this.e = 1.0f;
        this.f = false;
    }

    public final float a() {
        return this.e;
    }

    public final boolean b() {
        return this.f;
    }

    public final float c() {
        return this.c;
    }

    public final float d() {
        return this.d;
    }

    public final float e() {
        return this.a;
    }

    public final float f() {
        return this.b;
    }

    public final void g(float f2, float f3, float f4, float f5, @NotNull ImageView.ScaleType scaleType) {
        k21.j(scaleType, "scaleType");
        if (f2 != 0.0f && f3 != 0.0f && f4 != 0.0f && f5 != 0.0f) {
            h();
            float f6 = (f2 - f4) / 2.0f;
            float f7 = (f3 - f5) / 2.0f;
            float f8 = f4 / f5;
            float f9 = f2 / f3;
            float f10 = f3 / f5;
            float f11 = f2 / f4;
            boolean z = false;
            switch (y32.$EnumSwitchMapping$0[scaleType.ordinal()]) {
                case 1:
                    this.a = f6;
                    this.b = f7;
                    return;
                case 2:
                    if (f8 > f9) {
                        this.e = f10;
                        this.f = false;
                        this.c = f10;
                        this.d = f10;
                        this.a = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    }
                    this.e = f11;
                    this.f = true;
                    this.c = f11;
                    this.d = f11;
                    this.b = (f3 - (f5 * f11)) / 2.0f;
                    return;
                case 3:
                    if (f4 < f2 && f5 < f3) {
                        this.a = f6;
                        this.b = f7;
                        return;
                    } else if (f8 > f9) {
                        this.e = f11;
                        this.f = true;
                        this.c = f11;
                        this.d = f11;
                        this.b = (f3 - (f5 * f11)) / 2.0f;
                        return;
                    } else {
                        this.e = f10;
                        this.f = false;
                        this.c = f10;
                        this.d = f10;
                        this.a = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    }
                case 4:
                    if (f8 > f9) {
                        this.e = f11;
                        this.f = true;
                        this.c = f11;
                        this.d = f11;
                        this.b = (f3 - (f5 * f11)) / 2.0f;
                        return;
                    }
                    this.e = f10;
                    this.f = false;
                    this.c = f10;
                    this.d = f10;
                    this.a = (f2 - (f4 * f10)) / 2.0f;
                    return;
                case 5:
                    if (f8 > f9) {
                        this.e = f11;
                        this.f = true;
                        this.c = f11;
                        this.d = f11;
                        return;
                    }
                    this.e = f10;
                    this.f = false;
                    this.c = f10;
                    this.d = f10;
                    return;
                case 6:
                    if (f8 > f9) {
                        this.e = f11;
                        this.f = true;
                        this.c = f11;
                        this.d = f11;
                        this.b = f3 - (f5 * f11);
                        return;
                    }
                    this.e = f10;
                    this.f = false;
                    this.c = f10;
                    this.d = f10;
                    this.a = f2 - (f4 * f10);
                    return;
                case 7:
                    this.e = Math.max(f11, f10);
                    if (f11 > f10) {
                        z = true;
                    }
                    this.f = z;
                    this.c = f11;
                    this.d = f10;
                    return;
                default:
                    this.e = f11;
                    this.f = true;
                    this.c = f11;
                    this.d = f11;
                    return;
            }
        }
    }
}
